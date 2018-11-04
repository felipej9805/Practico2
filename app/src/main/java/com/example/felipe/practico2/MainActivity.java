package com.example.felipe.practico2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_nuevoRegistro;
    Button btn_verEstadistica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nuevoRegistro = findViewById(R.id.btn_nuevoRegistro);
        btn_verEstadistica = findViewById(R.id.btn_verEstadistica);
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
