package com.example.felipe.practico2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btn_nuevoRegistro;
    Button btn_verEstadistica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nuevoRegistro = findViewById(R.id.btn_nuevoRegistro);
        btn_verEstadistica = findViewById(R.id.btn_verEstadistica);

        /**
        //ESCRIBIR
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference().child("pregunta1").setValue("EJEMPLO");

        //Escribir con push = agregar a lista
        db.getReference().push().setValue("EJEMPLO");


        //Leer un simple valor
        db.getReference().child("pregunta1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String alfa = dataSnapshot.getValue(String.class);
                //Toast.makeText(MainActivity.this, alfa, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        db.getReference().child("clave").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    String dato = child.getValue(String.class);
                    Toast.makeText(MainActivity.this, dato, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
         **/

    }

    public void onClick_Encuesta(View v) {
        Intent intent = new Intent(MainActivity.this, Encuesta.class);
        startActivity(intent);

    }

    public void onClick_Estadisticas(View v) {
        Intent intent = new Intent(MainActivity.this, Estadistica.class);
        startActivity(intent);

    }
}
