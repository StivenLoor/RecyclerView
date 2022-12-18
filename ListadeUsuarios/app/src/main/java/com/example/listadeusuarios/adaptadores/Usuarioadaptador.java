package com.example.listadeusuarios.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listadeusuarios.R;
import com.example.listadeusuarios.modelos.Usuario;

import java.util.ArrayList;

public class Usuarioadaptador extends ArrayAdapter<Usuario> {

    public Usuarioadaptador(Context context, ArrayList<Usuario> datos) {
        super(context, R.layout.lyitemusuario, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemusuario, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).nombres);

        TextView lblemail = (TextView)item.findViewById(R.id.lblEmail);
        lblemail.setText(getItem(position).email);

        TextView lblweb = (TextView)item.findViewById(R.id.lblweb);
        lblweb.setText(getItem(position).website);

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).urlavatar)
                .into(imageView);
        return(item);
    }

}
