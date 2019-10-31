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

public class AdaptadorChat extends ArrayAdapter <Chat> {

    private Chat chats[];

    public AdaptadorChat(@NonNull Context context, Chat[] chats)
    {
        super(context, R.layout.items_chat, chats);
        this.chats = chats;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.items_chat, null);

        TextView tvMensaje = (TextView)item.findViewById(R.id.txtMensaje);
        tvMensaje.setText(chats[position].getMensaje());

        TextView tvUltimaConeccion = (TextView)item.findViewById(R.id.txtUltimaConeccion);
        tvUltimaConeccion.setText(chats[position].getUltimaConeccion());


        TextView txtNombreContacto = (TextView)item.findViewById(R.id.txtNombreContacto);
        txtNombreContacto.setText(chats[position].getNombreContacto());


        ImageView imagenContacto = item.findViewById(R.id.imagenContacto);
        imagenContacto.setImageResource(chats[position].getImagen());
        return (item);
    }

}
