package com.example.ejerciciowhatsapp;

public class Llamada {
    private String nombreContacto;
    private String horaLlamada;
    private int imagen;

    public Llamada(String nombreContacto, String horaLlamada, int imagen){
        this.horaLlamada = horaLlamada;
        this.nombreContacto = nombreContacto;
        this.imagen = imagen;
    }

    public String getNombreContacto(){
        return nombreContacto;
    }

    public String getHoraLlamada(){
        return horaLlamada;
    }

    public int getImagen(){
        return imagen;
    }

}

