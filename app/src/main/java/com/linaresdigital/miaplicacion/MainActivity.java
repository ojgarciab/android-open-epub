package com.linaresdigital.miaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = getIntent();
        TextView textView1 = (TextView)findViewById(R.id.texto1);
        TextView textView2 = (TextView)findViewById(R.id.texto2);
        try {
            Uri uri = getIntent().getData();
            textView1.setText(getIntent().getData().getPath());
            InputStream file = getContentResolver().openInputStream(uri);
            /* Leemos el primer octeto del archivo:
                -1: hubo un error leyendo el archivo (no se abrió, está vacío, etc)
                75: código ASCII del primer carácter de un archivo EPUB
                    (los dos primeros son "PK" al ser un ZIP)
            */
            textView2.setText(
                    ((file.read() != -1) ? "Abierto" : "No abierto")
                    + ": " + file.read()
            );
        } catch (Exception e) {
            textView1.setText("Apertura normal");
            textView2.setText("de la aplicación");
        }
    }
}