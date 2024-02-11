package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Declaracion de variables

    Button play_pause, btn_repetir;//Declaracion de los botones play/pause y repetir
    ImageView iv;
    int repetir = 2, posicion = 0;
    MediaPlayer vectormp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button) findViewById(R.id.btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        iv = (ImageView) findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this,R.raw.peaches);
        vectormp[1]= MediaPlayer.create(this,R.raw.sky);
        vectormp[2]= MediaPlayer.create(this,R.raw.cancion);

    }
    //Creacion metodos
//Metodo para reproducir o pausar la cancion
    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.play);
            Toast.makeText(this,"pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"play",Toast.LENGTH_SHORT).show();

        }

    }

    //Metodo Stop
    public void Stop(View view){
        //Si la cancion esta en reproduccion se detiene
        if (vectormp[posicion]!=null){
            vectormp[posicion].stop();
            vectormp[0] = MediaPlayer.create(this,R.raw.peaches);
            vectormp[1]= MediaPlayer.create(this,R.raw.sky);
            vectormp[2]= MediaPlayer.create(this,R.raw.cancion);
            //Se cambia el icono del boton a play y se coloca la posicion en 0
            posicion = 0;
            //Se cambia el icono del boton a play
            play_pause.setBackgroundResource(R.drawable.play);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo para repetir la cancion
    public void Repetir(View view){
        //Si repetir es igual a 1
        if(repetir == 1){
            Toast.makeText(this,"no repetir en este caso", Toast.LENGTH_SHORT).show();
            //Se cambia el icono del boton a aleatorio
            vectormp[posicion].setLooping(false);
            repetir = 2;

        }else {
            //Si repetir es igual a 2 se cambia el icono del boton a repetir
            btn_repetir.setBackgroundResource(R.drawable.aleatorio);
            Toast.makeText(this,"repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }
    //Metodo para la cancion siguiente
    public void Siguiente(View view){
        //Si la posicion es menor al tamaño del vector
        if(posicion < vectormp.length - 1){
            //Si la cancion esta en reproduccion se detiene para reproducir la siguiente
            if(vectormp[posicion].isPlaying()){
                //Se detiene la cancion para reproducir la siguiente
                vectormp[posicion].stop();
                //Se le suma 1 a la posicion
                posicion++;
                vectormp[posicion].start();
            }else{
                posicion++;
            }
        }else{
            Toast.makeText(this,"no hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }
    //Metodo para la cancion anterior

    public void Anterior (View view){
        //Si la posicion es mayor o igual a 1
        if(posicion >= 1){
            //Si la cancion esta en reproduccion
            if(vectormp[posicion].isPlaying()){
                //Se detiene la cancion para reproducir la anterior
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this,R.raw.peaches);
                vectormp[1]= MediaPlayer.create(this,R.raw.sky);
                vectormp[2]= MediaPlayer.create(this,R.raw.cancion);
                //Se le resta 1 a la posicion
                posicion--;
                //Se inicia la cancion
                vectormp[posicion].start();
            }else{
                //Si no esta en reproduccion solo se le resta 1 a la posicion
                posicion--;
            }
        }else{
            //Si la posicion es 0 no hay mas canciones
            Toast.makeText(this,"no hay mas canciones", Toast.LENGTH_SHORT).show();
        }
    }



}