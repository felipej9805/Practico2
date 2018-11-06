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
import android.widget.TextView;
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
    String[] arregloRespuesta;
    int numero;

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
    TextView prueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        prueba = findViewById(R.id.prueba);
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
                            //Esto sube a Firebase
                            Gson gson = new Gson();
                            Pregunta pregunta = new Pregunta("pregunta1", "1");
                            String json = WEBUtilDomi.JsonByPOSTrequest(USUARIOS_SERVICE, gson.toJson(pregunta));


                            String[] arreglo = comprobarTodas();
                            prueba.setText(arreglo[0] + " - " + arreglo[1] + " - " + arreglo[2]);
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
        });
    }


    public void onClick(View v) {


    }

    public void inicializarElementos() {

        opcionesP1 = (RadioGroup) findViewById(R.id.opcionesP1);
        opcionesP2 = (RadioGroup) findViewById(R.id.opcionesP2);
        opcionesP3 = (RadioGroup) findViewById(R.id.opcionesP3);
        opcionesP4 = (RadioGroup) findViewById(R.id.opcionesP4);
        opcionesP5 = (RadioGroup) findViewById(R.id.opcionesP5);

        //OpcionesP1
        resp_1A = (RadioButton) findViewById(R.id.resp_1A);
        resp_1B = (RadioButton) findViewById(R.id.resp_1B);
        resp_1C = (RadioButton) findViewById(R.id.resp_1C);
        resp_1D = (RadioButton) findViewById(R.id.resp_1D);

        //OpcionesP2
        resp_2A = (RadioButton) findViewById(R.id.resp_2A);
        resp_2B = (RadioButton) findViewById(R.id.resp_2B);
        resp_2C = (RadioButton) findViewById(R.id.resp_2C);
        resp_2D = (RadioButton) findViewById(R.id.resp_2D);

        //OpcionesP3
        resp_3A = (RadioButton) findViewById(R.id.resp_3A);
        resp_3B = (RadioButton) findViewById(R.id.resp_3B);
        resp_3C = (RadioButton) findViewById(R.id.resp_3C);
        resp_3D = (RadioButton) findViewById(R.id.resp_3D);

        //OpcionesP4
        resp_4A = (RadioButton) findViewById(R.id.resp_4A);
        resp_4B = (RadioButton) findViewById(R.id.resp_4B);
        resp_4C = (RadioButton) findViewById(R.id.resp_4C);
        resp_4D = (RadioButton) findViewById(R.id.resp_4D);

        //OpcionesP5
        resp_5A = (RadioButton) findViewById(R.id.resp_5A);
        resp_5B = (RadioButton) findViewById(R.id.resp_5B);
        resp_5C = (RadioButton) findViewById(R.id.resp_5C);
        resp_5D = (RadioButton) findViewById(R.id.resp_5D);

        //Boton de enviar
        bt_enviar = findViewById(R.id.bt_enviar);

        ly_encuesta = findViewById(R.id.ly_encuesta);

    }


    /**
     * Comprueba si todas las preguntas estan contestadas
     * Retorna un arreglo de 6 casillas
     * <p>
     * Donde la primera casilla es 1 si todas estas contestadas y 0 si falto alguna por responder
     * <p>
     * Y las siguientes 5 casillas correspondera a la respuesta de las 5 preguntas podria ser a,b,c,d
     * <p>
     * |  1 | A  | B  | C  | D  | D  |
     *
     *ESTE METODO ME GUARDA VALORES NULL Y NO SE POR QUE :(
     */
    public String[] comprobarTodas() {
        inicializarElementos();
        arregloRespuesta = new String[6];

        //Comprueba cual es la respuesta marcada de la pregunta 1 o en su defecto si ninguna fue marcada
        opcionesP1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {





            }
        });

        //Comprueba cual es la respuesta marcada de la pregunta 2 o en su defecto si ninguna fue marcada
        opcionesP2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.resp_2A) {
                    arregloRespuesta[2] = "A";
                    numero++;

                } else if (checkedId == R.id.resp_2B) {
                    arregloRespuesta[2] = "B";
                    numero++;

                } else if (checkedId == R.id.resp_2C) {
                    arregloRespuesta[2] = "C";
                    numero++;

                } else if (checkedId == R.id.resp_2D) {
                    arregloRespuesta[2] = "D";
                    numero++;


                } else {
                    arregloRespuesta[0] = "0";
                }
            }
        });

        //Comprueba cual es la respuesta marcada de la pregunta 3 o en su defecto si ninguna fue marcada
        opcionesP3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.resp_3A) {
                    arregloRespuesta[3] = "A";
                    numero++;

                } else if (checkedId == R.id.resp_3B) {
                    arregloRespuesta[3] = "B";
                    numero++;

                } else if (checkedId == R.id.resp_3C) {
                    arregloRespuesta[3] = "C";
                    numero++;

                } else if (checkedId == R.id.resp_3D) {
                    arregloRespuesta[3] = "D";
                    numero++;

                } else {
                    arregloRespuesta[0] = "0";
                }
            }
        });


        //Comprueba cual es la respuesta marcada de la pregunta 4 o en su defecto si ninguna fue marcada
        opcionesP4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.resp_4A) {
                    arregloRespuesta[4] = "A";
                    numero++;

                } else if (checkedId == R.id.resp_4B) {
                    arregloRespuesta[4] = "B";
                    numero++;

                } else if (checkedId == R.id.resp_4C) {
                    arregloRespuesta[4] = "C";
                    numero++;

                } else if (checkedId == R.id.resp_4D) {
                    arregloRespuesta[4] = "D";
                    numero++;

                } else {
                    arregloRespuesta[0] = "0";
                }
            }
        });


        //Comprueba cual es la respuesta marcada de la pregunta 4 o en su defecto si ninguna fue marcada
        opcionesP5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.resp_5A) {
                    arregloRespuesta[5] = "A";
                    numero++;

                } else if (checkedId == R.id.resp_5B) {
                    arregloRespuesta[5] = "B";
                    numero++;

                } else if (checkedId == R.id.resp_5C) {
                    arregloRespuesta[5] = "C";
                    numero++;

                } else if (checkedId == R.id.resp_5D) {
                    arregloRespuesta[5] = "D";
                    numero++;

                } else {
                    arregloRespuesta[0] = "0";
                }
            }
        });
        if (numero == 5) {
            arregloRespuesta[0] = "1";

        }


        return arregloRespuesta;

    }


    public void selectItem(View v) {
        int radioSelectId = opcionesP1.getCheckedRadioButtonId();
        opcionesP1 = (RadioGroup) findViewById(radioSelectId);
        opcionesP2 = (RadioGroup) findViewById(radioSelectId);
        opcionesP3 = (RadioGroup) findViewById(radioSelectId);
        opcionesP4 = (RadioGroup) findViewById(radioSelectId);
        opcionesP5 = (RadioGroup) findViewById(radioSelectId);

    }

    public void onClick_Submit(View v) {

        Toast.makeText(this, "Encuesta enviada", Toast.LENGTH_SHORT).show();

    }

    public String[] getRespuesta() {
        return arregloRespuesta;
    }


}

