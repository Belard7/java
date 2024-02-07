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

    int whip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        final TextView sonido = (TextView) findViewById(R.id.tvSonido);

    }
}