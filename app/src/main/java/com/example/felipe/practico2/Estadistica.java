package com.example.felipe.practico2;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Estadistica extends AppCompatActivity {

    private PieChart torta_p1;
    private PieChart torta_p2;
    private PieChart torta_p3;
    private PieChart torta_p4;
    private PieChart torta_p5;

    FirebaseAuth auth;
    FirebaseDatabase db;

    Button btn_atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);


        torta_p1 = (PieChart) findViewById(R.id.torta_p1);
        torta_p2 = (PieChart) findViewById(R.id.torta_p2);
        torta_p3 = (PieChart) findViewById(R.id.torta_p3);
        torta_p4 = (PieChart) findViewById(R.id.torta_p4);
        torta_p5 = (PieChart) findViewById(R.id.torta_p5);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        btn_atras = findViewById(R.id.btn_atras);

        crear_grafica_torta(torta_p1,"pregunta1");
        crear_grafica_torta(torta_p2,"pregunta2");
        crear_grafica_torta(torta_p3,"pregunta3");
        crear_grafica_torta(torta_p4,"pregunta4");
        crear_grafica_torta(torta_p5,"pregunta5");
    }

    private void crear_grafica_torta(PieChart torta, String childname) {

        //Se crea una grafica de torta

        Description desc1 = new Description();
        desc1.setText("");
        desc1.setTextSize(20);
        torta.setDescription(desc1);
        torta.setRotationEnabled(true);
        torta.setUsePercentValues(true);
        torta.setDragDecelerationFrictionCoef(0.95f);
        torta.setDrawHoleEnabled(true);
        torta.setTransparentCircleRadius(50f);
        torta.setHoleColor(Color.WHITE);
        torta.setHoleRadius(40f);

        // se carga la informacion de la base datos y llena la torta
        cargarInfo(torta, childname);

    }


    public void cargarInfo(final PieChart torta, String childName) {

        final ArrayList<String> datosX = new ArrayList<>();
        final ArrayList<Float> datosY = new ArrayList<>();
        final DatabaseReference reference = db.getReference().child(childName);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                datosX.clear();
                datosY.clear();

                Iterable<DataSnapshot> hijos = dataSnapshot.getChildren();

                //se leen los datos de la base de datos y se cargan en los respectivos arreglos
                for (DataSnapshot hijo : hijos) {
                    datosY.add(new Float(hijo.getChildrenCount()));
                    datosX.add(hijo.getKey());
                }

                //Se llena la torta
                llenarTorta(datosX, datosY, torta);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void llenarTorta(ArrayList<String> datosX, ArrayList<Float> datosY, PieChart torta) {

        //LLenamos la torta
        ArrayList<PieEntry> entradasY = new ArrayList<>();
        ArrayList<String> entradasX = new ArrayList<>();

        for (int i = 0; i < datosY.size(); i++) {
            entradasY.add(new PieEntry(datosY.get(i), datosX.get(i)));
        }

        for (int i = 0; i < datosX.size(); i++) {
            entradasX.add(datosX.get(i));
        }

        // Aplicamos las caracteristicas de la torta y la leyenda
        PieDataSet pieDataSet = new PieDataSet(entradasY, "Respuestas");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //Aplicamos los colores de la torta
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        Legend legend = torta.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData = new PieData(pieDataSet);
        torta.setData(pieData);
        torta.invalidate();

    }

    public void onClick_Atras(View v) {
        Intent intent = new Intent(Estadistica.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
