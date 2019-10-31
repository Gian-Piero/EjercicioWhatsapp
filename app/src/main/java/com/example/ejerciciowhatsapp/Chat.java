package com.example.ejerciciowhatsapp;

public class Chat {

    private String ultimaConeccion;
    private String nombreContacto;
    private String mensaje;
    private int imagen;


    public Chat(String ultimaConeccion, String nombreContacto, String mensaje, int imagen)
    {
        this.ultimaConeccion = ultimaConeccion;
        this.nombreContacto = nombreContacto;
        this.mensaje = mensaje;
        this.imagen = imagen;
    }

    public String getUltimaConeccion(){
        return ultimaConeccion;
    }

    public String getNombreContacto()
    {
        return nombreContacto;
    }

    public String getMensaje()
    {
        return  mensaje;
    }

    public int getImagen()
    {
        return imagen;
    }
}
