package com.example.ejerciciowhatsapp;

public class Estado {

    private String nombreContacto;
    private String hora;
    private int imagen;

    public Estado(String nombreContacto, String hora, int imagen)
    {
        this.nombreContacto = nombreContacto;
        this.hora = hora;
        this.imagen = imagen;
    }

    public String getNombreContacto()
    {
        return nombreContacto;
    }

    public String getHora()
    {
        return hora;
    }

    public int getImagen()
    {
        return imagen;
    }
}
