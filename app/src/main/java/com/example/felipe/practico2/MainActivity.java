package com.example.felipe.practico2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick_Encuesta(View v){
        Intent intent= new Intent(MainActivity.this, Encuesta.class);
        startActivity(intent);

    }

    public void onClick_Estadisticas(View v){
        Intent intent= new Intent(MainActivity.this, Estadistica.class);
        startActivity(intent);

    }
}
