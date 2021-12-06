package com.fisei.app_002;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textViewTitulo;
    private int codigoRequerido = 1;//para pasar entre actividades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        textViewTitulo = findViewById(R.id.textViewTitulo);
        //recibir informacion pasados del formulario 1 (MainActivity)
        Bundle datosExtra = getIntent().getExtras();

        String nombre = datosExtra.getString("key_nombre");
        String apellido = datosExtra.getString("key_apellido");

        textViewTitulo.setText("Bienvenido: " + nombre + " "+ apellido+ " a Android..!");
    }

    public void onClicNavegadorWeb(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));//ayuda a crear actividades va a llamar a una url
        startActivity(intent);
    }

    public void onClicLlamar(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+3590983420765"));
        startActivity(intent);
    }

    public void onClicMostrar(View view){
        Intent intent = new Intent(this,TercerActivity.class);
      //  startActivity(intent);
        //para permitir regresar datos a la actividad actual (segundaActivity)
        startActivityForResult(intent, codigoRequerido);
    }
//regresar informacion de una ventana hija a una ventana padre
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //obtener los datos regresados desde la hija

        //comprobar si son iguales
        if ((requestCode == codigoRequerido) && (resultCode == RESULT_OK))
        {
            textViewTitulo.setText("Valor seleccionado en la Actividad hija "+ data.getDataString());
        }
    }
}