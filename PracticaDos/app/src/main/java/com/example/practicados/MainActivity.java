package com.example.practicados;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu opcion_menu) {
        getMenuInflater().inflate(R.menu.menu, opcion_menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();
        if (id == R.id.configuracion) {
            Toast.makeText(this, "has elegido Configuracion", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.informacion) {
            Toast.makeText(this, "Ahora seleccionaste Informacion", Toast.LENGTH_LONG).show();
            return true;
        }

     return super.onOptionsItemSelected(opcion_menu);
    }
}


