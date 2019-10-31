package com.example.ejerciciowhatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Resources res;
    private TabHost tabs;
    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        crearDiseño();
    }

    public void crearDiseño() {
        res = getResources();
        tabs = findViewById(android.R.id.tabhost);
        tabs.setup();


        //Vinculo la tab1 con la pestaña
        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("", res.getDrawable((android.R.drawable.ic_menu_camera)));
        tabs.addTab(spec);

        //Vinculo la tab2 con la pestaña
        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("CHATS",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);
        TextView p = (TextView) tabs.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        p.setTextSize(12);
        p.setTextColor(Color.WHITE);

        //Vinculo la tab3 con la pestaña
        spec = tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("ESTADOS",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        TextView x = (TextView) tabs.getTabWidget().getChildAt(2).findViewById(android.R.id.title);
        x.setTextSize(12);
        x.setTextColor(Color.WHITE);

        //Vinculo la tab4 con la pestaña
        spec = tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("LLAMADAS",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        TextView y = (TextView) tabs.getTabWidget().getChildAt(3).findViewById(android.R.id.title);
        y.setTextSize(12);
        y.setTextColor(Color.WHITE);

        cargarListaChat();
        cargarListaEstados();
        cargarLlamadas();

        tabs.setCurrentTab(1);
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                if (tabId.equals("mitab1"))
                    accederCamara();
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.whatsappmenu, menu);
        return true;
    }

    private void accederCamara() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 0);
        tabs.setCurrentTab(1);
    }

    private void cargarListaChat() {
        Chat chats[] = new Chat[]{new Chat("25/07/2019", "Jhonatan", "Vale, hasta luego", R.drawable.jhonatan),
                new Chat("hacer 22 minutos", "Gian Piero", "Nos vemos", R.drawable.paco),
                new Chat("AYER", "Poco Brawler", "tampoco", R.drawable.poco),
                new Chat("el sabado 23:45", "Xabi", "el examen es el martes", R.drawable.xabi)
        };
        AdaptadorChat adapter = new AdaptadorChat(this, chats);
        ListView lv = (ListView) findViewById(R.id.listaChats);
        lv.setAdapter(adapter);
    }

    private void cargarListaEstados() {
        Estado estados[] = new Estado[]{new Estado("Gian Piero", "hoy 15:20", getResources().getIdentifier("paco", "drawable", getPackageName()))

        };

        AdaptadorEstados adapter = new AdaptadorEstados(this, estados);
        ListView lv = (ListView) findViewById(R.id.listaEstados);
        lv.setAdapter(adapter);
    }


    private void cargarLlamadas() {
        final Llamada llamadas[] = new Llamada[]{new Llamada("Poco Brawler", "9 de enero 7:57", R.drawable.poco),
                                    new Llamada("Jhonantan", "23/05/19", R.drawable.jhonatan),
                                    new Llamada("Petro", "29/10/19", R.drawable.petro)

        };
        AdaptadorLlamadas adapter = new AdaptadorLlamadas(this, llamadas);
        ListView lv = (ListView) findViewById(R.id.listaLlamadas);
        lv.setAdapter(adapter);
    }




}
