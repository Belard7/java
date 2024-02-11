package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaracion de variables

    SensorManager sensorManager;

    Sensor sensor;

    SensorEventListener sensorEventListener;

    //variable para controlar el numero de giros
    int whip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        final TextView sonido = (TextView) findViewById(R.id.tvSonido);
        if(sensor == null) finish();

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                System.out.println("Valor del giro" + x);

                if (x < -5 && whip == 0){
                    whip ++;
                    sonido.setText("Sonido" + whip);
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                } else if (x > 5 && whip == 1){
                    whip++;
                    sonido.setText("Sonido" + whip);
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK);

                }
                if (whip == 2 ){
                    whip=0;
                    sound();
                    sonido.setText("Sonido" + whip);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();



    }

    //Metodo para reproducir el sonido
    private void sound(){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sonido);
        mp.start();
    }

    private void start(){
       sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }


    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }
}