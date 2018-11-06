package com.example.felipe.practico2;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.io.IOException;

public class Encuesta extends AppCompatActivity {

    public static final String USUARIOS_SERVICE = "https://practico2-aba57.firebaseio.com/.json";

    LinearLayout ly_encuesta;

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


    Button bt_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        inicializarElementos();
        
        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            Gson gson = new Gson();
                            Pregunta pregunta = new Pregunta("pregunta1", "1");
                            String json = WEBUtilDomi.JsonByPOSTrequest(USUARIOS_SERVICE, gson.toJson(pregunta));

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Se ejecutara en el hilo principal

                                }
                            });

                        } catch (Exception ex) {


                        }
                    }
                }).start();
            }

            ;

        });
    }


    public void inicializarElementos() {

        opcionesP1 = findViewById(R.id.opcionesP1);
        opcionesP2 = findViewById(R.id.opcionesP2);
        opcionesP3 = findViewById(R.id.opcionesP3);
        opcionesP4 = findViewById(R.id.opcionesP4);
        opcionesP5 = findViewById(R.id.opcionesP5);

        //OpcionesP1
        resp_1A = findViewById(R.id.resp_1A);
        resp_1B = findViewById(R.id.resp_1B);
        resp_1C = findViewById(R.id.resp_1C);
        resp_1D = findViewById(R.id.resp_1D);

        //OpcionesP2
        resp_2A = findViewById(R.id.resp_2A);
        resp_2B = findViewById(R.id.resp_2B);
        resp_2C = findViewById(R.id.resp_2C);
        resp_2D = findViewById(R.id.resp_2D);

        //OpcionesP3
        resp_3A = findViewById(R.id.resp_3A);
        resp_3B = findViewById(R.id.resp_3B);
        resp_3C = findViewById(R.id.resp_3C);
        resp_3D = findViewById(R.id.resp_3D);

        //OpcionesP4
        resp_4A = findViewById(R.id.resp_4A);
        resp_4B = findViewById(R.id.resp_4B);
        resp_4C = findViewById(R.id.resp_4C);
        resp_4D = findViewById(R.id.resp_4D);

        //OpcionesP5
        resp_5A = findViewById(R.id.resp_5A);
        resp_5B = findViewById(R.id.resp_5B);
        resp_5C = findViewById(R.id.resp_5C);
        resp_5D = findViewById(R.id.resp_5D);

        //Boton de enviar
        bt_enviar = findViewById(R.id.bt_enviar);

        ly_encuesta = findViewById(R.id.ly_encuesta);

    }

    /**
     * Comprueba si todas las preguntas estan contestadas
     * Retorna un arreglo de 6 casillas
     *
     * Donde la primera casilla es 1 si todas estas contestadas y 0 si falto alguna por responder
     *
     * Y las siguientes 5 casillas correspondera a la respuesta de las 5 preguntas podria ser a,b,c,d
     *
     * |  1 | a  | b  | b  | d  | c  |
     */
    public String[] comprobarTodas() {


        String respuesta[] = new String[6];

        opcionesP1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.resp_1A) {

                } else if (checkedId == R.id.resp_1B) {

                } else if (checkedId == R.id.resp_1C) {

                }else if(checkedId == R.id.resp_1D){

                }
            }
        });


        return respuesta;

    }


}
