package com.example.felipe.practico2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;


public class Encuesta extends AppCompatActivity {

    public static final String PREGUNTA1 = "https://practico2-aba57.firebaseio.com/pregunta1.json";



    LinearLayout ly_encuesta;


    RadioGroup opcionesP1;
    RadioGroup opcionesP2;
    RadioGroup opcionesP3;
    RadioGroup opcionesP4;
    RadioGroup opcionesP5;

    Button bt_enviar;

    FirebaseAuth auth;
    FirebaseDatabase db;

    TextView prueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        prueba = findViewById(R.id.prueba);

        // Inicializamos los componentes declarados

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        bt_enviar = findViewById(R.id.bt_enviar);
        ly_encuesta = findViewById(R.id.ly_encuesta);

        opcionesP1 = (RadioGroup) findViewById(R.id.opcionesP1);
        opcionesP2 = (RadioGroup) findViewById(R.id.opcionesP2);
        opcionesP3 = (RadioGroup) findViewById(R.id.opcionesP3);
        opcionesP4 = (RadioGroup) findViewById(R.id.opcionesP4);
        opcionesP5 = (RadioGroup) findViewById(R.id.opcionesP5);



        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Generamos un RadioButton para cada pregunta, este componente tomará el id del RadioButton correspondiente al XML
                // No tenemos necesidad de declarar ni de inicializar todos los componentes RadioButton


                RadioButton resp_p1 = findViewById(opcionesP1.getCheckedRadioButtonId());
                RadioButton resp_p2 = findViewById(opcionesP2.getCheckedRadioButtonId());
                RadioButton resp_p3 = findViewById(opcionesP3.getCheckedRadioButtonId());
                RadioButton resp_p4 = findViewById(opcionesP4.getCheckedRadioButtonId());
                RadioButton resp_p5 = findViewById(opcionesP5.getCheckedRadioButtonId());


                Date currentTime = Calendar.getInstance().getTime();
                // Verificamos que todos las preguntas se respondan

                if (resp_p1 == null || resp_p2 == null || resp_p3 == null || resp_p4 == null || resp_p5 == null) {

                    Toast.makeText(getApplicationContext(), "Por favor, responda todas las preguntas", Toast.LENGTH_LONG).show();
                    return;

                }

                //Obtenemos las referencias de la base de datos

                DatabaseReference rf1 = db.getReference().child("pregunta1");
                DatabaseReference rf2 = db.getReference().child("pregunta2");
                DatabaseReference rf3 = db.getReference().child("pregunta3");
                DatabaseReference rf4 = db.getReference().child("pregunta4");
                DatabaseReference rf5 = db.getReference().child("pregunta5");

                int value = 1;

                //Generamos una nueva referencia a la respuesta de la pregunta 1

                if (resp_p1.getId() == R.id.resp_1A) {
                    DatabaseReference reference = rf1.child("A").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p1.getId() == R.id.resp_1B) {
                    DatabaseReference reference = rf1.child("B").push();
                    reference.setValue(value);
                    value ++;

                }

                if (resp_p1.getId() == R.id.resp_1C) {
                    DatabaseReference reference = rf1.child("C").push();
                    reference.setValue(value);
                    value ++;

                }

                if (resp_p1.getId() == R.id.resp_1D) {
                    DatabaseReference reference = rf1.child("D").push();
                    reference.setValue(value);
                    value ++;

                }

                //Generamos una nueva referencia a la respuesta de la pregunta 2

                if (resp_p2.getId() == R.id.resp_2A) {
                    DatabaseReference reference = rf2.child("A").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p2.getId() == R.id.resp_2B) {
                    DatabaseReference reference = rf2.child("B").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p2.getId() == R.id.resp_2C) {
                    DatabaseReference reference = rf2.child("C").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p2.getId() == R.id.resp_2D) {
                    DatabaseReference reference = rf2.child("D").push();
                    reference.setValue(value);
                    value ++;
                }

                //Generamos una nueva referencia a la respuesta de la pregunta 3

                if (resp_p3.getId() == R.id.resp_3A) {
                    DatabaseReference reference = rf3.child("A").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p3.getId() == R.id.resp_3B) {
                    DatabaseReference reference = rf3.child("B").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p3.getId() == R.id.resp_3C) {
                    DatabaseReference reference = rf3.child("C").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p3.getId() == R.id.resp_3D) {
                    DatabaseReference reference = rf3.child("D").push();
                    reference.setValue(value);
                    value ++;
                }

                //Generamos una nueva referencia a la respuesta de la pregunta 4

                if (resp_p4.getId() == R.id.resp_4A) {
                    DatabaseReference reference = rf4.child("A").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p4.getId() == R.id.resp_4B) {
                    DatabaseReference reference = rf4.child("B").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p4.getId() == R.id.resp_4C) {
                    DatabaseReference reference = rf4.child("C").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p4.getId() == R.id.resp_4D) {
                    DatabaseReference reference = rf4.child("D").push();
                    reference.setValue(value);
                    value ++;
                }

                //Generamos una nueva referencia a la respuesta de la pregunta 5

                if (resp_p5.getId() == R.id.resp_5A) {
                    DatabaseReference reference = rf5.child("A").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p5.getId() == R.id.resp_5B) {
                    DatabaseReference reference = rf5.child("B").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p5.getId() == R.id.resp_5C) {
                    DatabaseReference reference = rf5.child("C").push();
                    reference.setValue(value);
                    value ++;
                }

                if (resp_p5.getId() == R.id.resp_5D) {
                    DatabaseReference reference = rf5.child("D").push();
                    reference.setValue(value);
                    value ++;
                }

                Toast.makeText(getApplicationContext(), "Encuesta realizada con éxito", Toast.LENGTH_LONG).show();

                finish();
            }
        });

    }

}

