package com.example.practica_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class actIngresao extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ingresao);

        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://api.uealecpeterson.net/public/productos/search" + bundle.getString("usr")+
                "&pass="+bundle.getString("pass"), datos, actIngresao.this, actIngresao.this);
        ws.execute("POST");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        TextView txtSaludo = (TextView)findViewById(R.id.lblMensaje);
        txtSaludo.setText("Respuesta ws: "+result);
    }
}