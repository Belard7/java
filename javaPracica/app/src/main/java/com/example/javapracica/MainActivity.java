package com.example.javapracica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etNombre = (EditText) findViewById(R.id.etNombre);
        final EditText etApellido = (EditText) findViewById(R.id.etApellido);
        Button bDatos = this.findViewById(R.id.btEnviar);
        bDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                Toast.makeText(MainActivity.this, "Nombre: " + nombre + " Apellido: " + apellido, Toast.LENGTH_LONG).show();
            }
        });
    }
}