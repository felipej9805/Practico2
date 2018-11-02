package com.example.felipe.practico2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    RadioGroup radioGroup5;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        radioGroup1=findViewById(R.id.group1);
        radioGroup2=findViewById(R.id.group2);
        radioGroup3=findViewById(R.id.group3);
        radioGroup4=findViewById(R.id.group4);
        radioGroup5=findViewById(R.id.group5);
    }


    public void selectItem(View v){
        int radioSelectId=radioGroup1.getCheckedRadioButtonId();
        radioButton1= findViewById(radioSelectId);
    }

    public void onClick_Submit(View v){

        Toast.makeText(this,"Encuesta enviada",Toast.LENGTH_SHORT).show();

    }
}
