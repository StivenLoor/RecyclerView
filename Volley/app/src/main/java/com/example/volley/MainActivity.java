package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.txtApi);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.uealecpeterson.net/public/productos/search";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Mostramos los resultados.
                        textView.setText(response);
                        textView.setMovementMethod(new ScrollingMovementMethod());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("No conecta con la API!");
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZHVzciI6OSwiZW1haWwiOiJjemFtYnJhbm9AdXRlcS5lZHUuZWMiLCJpYXQiOjE2NzExNTk4OTksImV4cCI6MTY3MTUxOTg5OX0.ReHm_h9on2D9q--sa91Vp_O_Yi5X0Fds_Jjg0ccSf-A");
                return param;
            }
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("fuente","1");
                return params;
            }

        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}