package com.example.practica_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class actIngresar extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ingresao);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://gorest.co.in/public/v1/users",
                datos, actIngresar.this, actIngresar.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtlista= findViewById(R.id.lblMensaje);
        ArrayList<String> lstDatos = new ArrayList<String> ();
        JSONObject JSONobjeto =  new JSONObject(result);
        JSONArray JSONlista= JSONobjeto.getJSONArray("data");
        String Lista="";
        for(int i=0; i< JSONlista.length();i++){
            JSONObject dato=  JSONlista.getJSONObject(i);
            Lista= Lista + dato.getString("name") + "\n";
        }
        txtlista.setText(Lista);

    }
}