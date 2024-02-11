package com.example.tareasensores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    //Declaracion de variables
    SensorManager   SensorManager;

    Sensor sensor;

    SensorEventListener sensorEventListener;

    ImageView elcucho;


    //Metodo onCreate se ejecuta cuando se crea la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtenemos referencia a los elementos de interfaz
        final TextView texto = (TextView) findViewById(R.id.tvsensor);
        elcucho = (ImageView) findViewById(R.id.ielcucho);


        //obtenemos el servicio del sensor y del sensor proximidad
        SensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = SensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        //para que no se cierre la app si no hay sensor
        if(sensor == null)finish();


        //comportamiento del sensor
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                //si el sensor detecta algo cerca
                if(sensorEvent.values[0] < sensor.getMaximumRange()){
                    elcucho.setVisibility(View.VISIBLE);
                    texto.setText("Estas viendo una imagen");
                } else {
                    //si el sensor no detecta nada cerca
                    elcucho.setVisibility(View.INVISIBLE);
                    texto.setText("Acerca tu mano al sensor de proximidad para ver la imagen");
                }
            }

                //metodo que se ejecuta cuando cambia la precision del sensor
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        //inicia el sensor
        start();



    }
    //metodo para iniciar el sensor
    public void start(){
        SensorManager.registerListener(sensorEventListener,sensor,2000*1000);
    }
    //metodo para detener el sensor
    public void stop(){
        SensorManager.unregisterListener(sensorEventListener);
    }
    @Override
    //metodo que se ejecuta cuando la actividad se pausa
    protected void onPause() {
        //se detiene el sensor
        stop();
        //Oculta la imagen
        elcucho.setVisibility(View.INVISIBLE);
        super.onPause();
    }

    @Override
    //metodo que se ejecuta cuando la actividad se reanuda
    protected void onResume() {
        start();
        super.onResume();
    }
}