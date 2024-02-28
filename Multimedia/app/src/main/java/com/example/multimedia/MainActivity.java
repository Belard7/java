package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu opcion_menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.multimedia, opcion_menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {

        int id = opcion_menu.getItemId();
        if (id == R.id.RMusica){
            Intent intent = new Intent(this, musicPlayer.class);
            Toast.makeText(this, "Elegiste Reproductor de musica", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return true;
        }

        if (id == R.id.RVideo){
            Intent intentVolumen = new Intent(this,videoplayer.class);
            Toast.makeText(this, "Elegiste Reproductor de video", Toast.LENGTH_SHORT).show();
            startActivity(intentVolumen);
            return true;
        }
        if (id == R.id.Latigo){
            Intent intentlatigo = new Intent(this,LatigoActivity.class);
            Toast.makeText(this, "Elegiste Latigo", Toast.LENGTH_SHORT).show();
            startActivity(intentlatigo);
            return true;
        }


        return super.onOptionsItemSelected(opcion_menu);
    }
}