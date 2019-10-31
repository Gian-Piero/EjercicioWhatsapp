package com.example.ejerciciowhatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorEstados extends ArrayAdapter <Estado> {

    private Estado estados[];

    public AdaptadorEstados(@NonNull Context context, Estado[] estados)
    {
        super(context, R.layout.items_estados, estados);
        this.estados = estados;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.items_estados, null);

        TextView txtNombreContacto = (TextView)item.findViewById(R.id.txtNombreContacto);
        txtNombreContacto.setText(estados[position].getNombreContacto());

        TextView txtHora = (TextView)item.findViewById(R.id.txtHoraEstado);
        txtHora.setText(estados[position].getHora());

        ImageView imagenContacto = item.findViewById(R.id.imagenContacto);
        imagenContacto.setImageResource(estados[position].getImagen());

        return (item);
    }
}
