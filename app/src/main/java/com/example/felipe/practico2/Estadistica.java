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

        cargar_graficas();
    }

    private void cargar_graficas() {

        //Grafica pregunta 1
        Description desc1 = new Description();
        desc1.setTextSize(20);
        torta_p1.setDescription(desc1);
        torta_p1.setRotationEnabled(true);


        torta_p1.setUsePercentValues(true);
        torta_p1.setDragDecelerationFrictionCoef(0.95f);
        torta_p1.setDrawHoleEnabled(true);
        torta_p1.setTransparentCircleRadius(61f);
        torta_p1.setHoleColor(Color.WHITE);


        //Grafica pregunta 2
        Description desc2 = new Description();
        desc2.setTextSize(20);
        torta_p2.setDescription(desc2);
        torta_p2.setRotationEnabled(true);
        torta_p2.setUsePercentValues(true);
        torta_p2.setDragDecelerationFrictionCoef(0.95f);
        torta_p2.setDrawHoleEnabled(true);
        torta_p2.setTransparentCircleRadius(61f);

        //Grafica pregunta 3
        Description desc3 = new Description();
        desc3.setTextSize(20);
        torta_p3.setDescription(desc3);
        torta_p3.setRotationEnabled(true);
        torta_p3.setUsePercentValues(true);
        torta_p3.setDragDecelerationFrictionCoef(0.95f);
        torta_p3.setDrawHoleEnabled(true);
        torta_p3.setTransparentCircleRadius(61f);

        //Grafica pregunta 4
        Description desc4 = new Description();
        desc4.setTextSize(20);
        torta_p4.setDescription(desc4);
        torta_p4.setRotationEnabled(true);
        torta_p4.setUsePercentValues(true);
        torta_p4.setDragDecelerationFrictionCoef(0.95f);
        torta_p4.setDrawHoleEnabled(true);
        torta_p4.setTransparentCircleRadius(61f);

        //Grafica pregunta 5
        Description desc5 = new Description();
        desc5.setText("Pregunta 5");
        desc5.setTextSize(20);
        torta_p5.setDescription(desc5);
        torta_p5.setRotationEnabled(true);
        torta_p5.setUsePercentValues(true);
        torta_p5.setDragDecelerationFrictionCoef(0.95f);
        torta_p5.setDrawHoleEnabled(true);
        torta_p5.setTransparentCircleRadius(61f);

/**
 ArrayList<PieEntry> valoresY = new ArrayList<>();
 valoresY.add(new PieEntry(34f, "Colombia"));
 valoresY.add(new PieEntry(23f, "Argentina"));
 valoresY.add(new PieEntry(14f, "Peru"));
 valoresY.add(new PieEntry(35, "Brasil"));
 valoresY.add(new PieEntry(40, "Usa"));
 valoresY.add(new PieEntry(23, "Mexico"));

 PieDataSet dataset = new PieDataSet(valoresY, "Paises");
 dataset.setSliceSpace(3f);
 dataset.setSelectionShift(5f);
 dataset.setColors(ColorTemplate.JOYFUL_COLORS);

 PieData data = new PieData(dataset);
 data.setValueTextSize(10f);
 data.setValueTextColor(Color.YELLOW);


 torta_p1.setData(data);
 */


        cargarInfo(torta_p1, "pregunta1");
        cargarInfo(torta_p2, "pregunta2");
        cargarInfo(torta_p3, "pregunta3");
        cargarInfo(torta_p4, "pregunta4");
        cargarInfo(torta_p5, "pregunta5");


    }


    public void cargarInfo(final PieChart torta, String childName) {

        final ArrayList<Float> datosY = new ArrayList<>();
        final ArrayList<String> datosX = new ArrayList<>();

        final DatabaseReference reference = db.getReference().child(childName);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                datosY.clear();
                datosX.clear();

                Iterable<DataSnapshot> hijos = dataSnapshot.getChildren();

                for (DataSnapshot hijo : hijos) {
                    datosY.add(new Float(hijo.getChildrenCount()));
                    datosX.add(hijo.getKey());

                    Log.e(">>p1", "onDataChange: " + hijo.getKey() + " values:" + hijo.getChildrenCount());

                }

                ArrayList<PieEntry> entradasY = new ArrayList<>();
                ArrayList<String> entradasX = new ArrayList<>();

                for (int i = 0; i < datosY.size(); i++) {
                    entradasY.add(new PieEntry(datosY.get(i), datosX.get(i)));
                    Log.e(">>entY", datosY.get(i) + " - " + datosX.get(i));

                }

                for (int i = 0; i < datosX.size(); i++) {
                    entradasX.add(datosX.get(i));
                    Log.e(">>entX", datosX.get(i));

                }

                PieDataSet pieDataSet = new PieDataSet(entradasY, "Respuestas");
                pieDataSet.setSliceSpace(2);
                pieDataSet.setValueTextSize(12);

/**
 ArrayList<Integer> colores = new ArrayList<>();
 colores.add(Color.GRAY);
 colores.add(Color.BLUE);
 colores.add(Color.RED);
 colores.add(Color.GREEN);
 colores.add(Color.YELLOW);
 colores.add(Color.CYAN);
 colores.add(Color.YELLOW);
 colores.add(Color.MAGENTA);

 */
                pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);


                Legend legend = torta.getLegend();
                legend.setForm(Legend.LegendForm.CIRCLE);
                legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

                PieData pieData = new PieData(pieDataSet);
                torta.setData(pieData);
                torta.invalidate();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void onClick_Atras(View v) {
        Intent intent = new Intent(Estadistica.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}
