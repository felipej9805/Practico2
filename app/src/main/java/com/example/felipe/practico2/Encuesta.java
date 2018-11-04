package com.example.felipe.practico2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Encuesta extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase db;

    RadioGroup opcionesP1;
    RadioGroup opcionesP2;
    RadioGroup opcionesP3;
    RadioGroup opcionesP4;
    RadioGroup opcionesP5;

    RadioButton resp_1A;
    RadioButton resp_1B;
    RadioButton resp_1C;
    RadioButton resp_1D;

    RadioButton resp_2A;
    RadioButton resp_2B;
    RadioButton resp_2C;
    RadioButton resp_2D;

    RadioButton resp_3A;
    RadioButton resp_3B;
    RadioButton resp_3C;
    RadioButton resp_3D;

    RadioButton resp_4A;
    RadioButton resp_4B;
    RadioButton resp_4C;
    RadioButton resp_4D;

    RadioButton resp_5A;
    RadioButton resp_5B;
    RadioButton resp_5C;
    RadioButton resp_5D;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        opcionesP1=findViewById(R.id.opcionesP1);
        opcionesP2=findViewById(R.id.opcionesP2);
        opcionesP3=findViewById(R.id.opcionesP3);
        opcionesP4=findViewById(R.id.opcionesP4);
        opcionesP5=findViewById(R.id.opcionesP5);
    }


    public void selectItem(View v){
        int radioSelectId=opcionesP1.getCheckedRadioButtonId();
        resp_1A= findViewById(radioSelectId);
    }

    public void onClick_Submit(View v){

        Toast.makeText(this,"Encuesta enviada",Toast.LENGTH_SHORT).show();

    }
}
