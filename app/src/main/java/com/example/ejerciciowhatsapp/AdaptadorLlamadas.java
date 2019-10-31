package com.example.ejerciciowhatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorLlamadas extends ArrayAdapter<Llamada> {

    private Llamada llamadas[];

    public AdaptadorLlamadas(@NonNull Context context, Llamada[] llamadas)
    {
        super(context, R.layout.items_llamadas, llamadas);
        this.llamadas = llamadas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.items_llamadas, null);

        TextView txtNombreContacto = (TextView)item.findViewById(R.id.txtNombreContacto);
        txtNombreContacto.setText(llamadas[position].getNombreContacto());

        TextView txtHora = (TextView)item.findViewById(R.id.txtHoraLlamada);
        txtHora.setText(llamadas[position].getHoraLlamada());

        ImageView imagenContacto = item.findViewById(R.id.imagenContacto);
        imagenContacto.setImageResource(llamadas[position].getImagen());

        Button btnLlamar = (Button)item.findViewById(R.id.btnllamar);


        return (item);
    }
}
