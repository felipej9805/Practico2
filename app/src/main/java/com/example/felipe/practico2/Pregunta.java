package com.example.felipe.practico2;

public class Pregunta {

    String nombre;
    String valor;

    public Pregunta(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public Pregunta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
