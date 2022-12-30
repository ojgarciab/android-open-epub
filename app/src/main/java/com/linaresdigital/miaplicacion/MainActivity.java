package com.linaresdigital.miaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = getIntent();
        TextView textView1 = (TextView)findViewById(R.id.texto1);
        TextView textView2 = (TextView)findViewById(R.id.texto2);
        try {
            String ruta = getIntent().getData().getPath();
            ruta = ruta.substring(ruta.indexOf(":") + 1);
            textView1.setText(ruta);
            File file = new File(ruta);
            textView2.setText(file.exists() ? "Existe" : "No existe");
        } catch (Exception e) {
            textView1.setText("Apertura normal");
            textView2.setText("de la aplicación");
        }

    }
}