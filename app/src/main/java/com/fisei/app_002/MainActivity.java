package com.fisei.app_002;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNombre;
    EditText editTextApellido;
    private Button btn_finalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);

        //btn_finalizar = new Button();
        btn_finalizar = findViewById(R.id.btn_finalizar);
        btn_finalizar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //asociar el menu contextual al control nombre
        registerForContextMenu(editTextNombre) ;
    }

    public void onClicAceptar(View view)
    {
        String nombre= editTextNombre.getText().toString();
        String apellido= editTextApellido.getText().toString(); //obtener el dato
        if (!nombre.matches("") && !apellido.matches(""))
        {
            Intent intent = new Intent(this,SegundaActivity.class);// trabaja con actividades
            intent.putExtra("key_nombre", nombre);
            intent.putExtra("key_apellido", apellido);
            //this.startActivity(intent);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "nombre y apelledo son obligatorios", Toast.LENGTH_LONG).show();
        }
    }

    //para un menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      //  return super.onOptionsItemSelected(item);

        switch (item.getItemId())
        {
            case R.id.menu_archivo:
            //    Toast.makeText(this, "Presiono: Archivo",
              //          Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,Cuartoctivity.class);
                    startActivity(intent);
                break;
            case R.id.menu_acerca_de:
                Toast.makeText(this, "Presione: Acerca de..",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_editar_pegar:
                Toast.makeText(this, "Presiono: copiar",
                        Toast.LENGTH_LONG).show();
        }
        return true;
    }
//inflar esto muestra el menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       // super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_contextual_cortar:
                Toast.makeText(this, "Presiono:  del menu contextual",
                        Toast.LENGTH_LONG).show();
            break;
            case R.id.menu_contextual_copiar:
                Toast.makeText(this, "Presiono:  del menu contextual",
                        Toast.LENGTH_LONG).show();
                break;
        }


        return super.onContextItemSelected(item);
    }
}