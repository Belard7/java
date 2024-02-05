package com.example.conversordeunidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu opcion_menu) {
        getMenuInflater().inflate(R.menu.menu_principal, opcion_menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem opcion_menu) {

        int id = opcion_menu.getItemId();
        if (id == R.id.moneda){
           Intent intent = new Intent(this, DolaresActivity.class);
            Toast.makeText(this, "Elegiste Moneda", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }

        if (id == R.id.volumen){
            Intent intentVolumen = new Intent(this,VolumenActivity.class);
            Toast.makeText(this, "Elegiste volumen", Toast.LENGTH_SHORT).show();
            startActivity(intentVolumen);
            return true;
        }

        if (id == R.id.masa){
            Intent intentMasa = new Intent(this, MasaActivity.class);
            Toast.makeText(this, "Elegiste masa", Toast.LENGTH_SHORT).show();
            startActivity(intentMasa);
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }
}