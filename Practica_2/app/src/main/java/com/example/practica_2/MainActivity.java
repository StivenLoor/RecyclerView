package com.example.practica_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

import WebServices.Asynchtask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnIngresar(View view){
            //SE CREEA EL INTENT
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        EditText txtNombre = (EditText) findViewById(R.id.txtUser);
        EditText txtPass = (EditText)findViewById(R.id.txtPass);

        // SE CREA LA INFORMACION QUE VA A PASAR ENTRE ACTIVIDADES
        Bundle b = new Bundle();
        b.putString("usr", txtNombre.getText().toString());
        b.putString("pass", txtPass.getText().toString());
        //AÑADE LA INFORMACION AL INTENT
        intent.putExtras(b);
        // Iniciamos la nueva actividad
        startActivity(intent);
    }
}