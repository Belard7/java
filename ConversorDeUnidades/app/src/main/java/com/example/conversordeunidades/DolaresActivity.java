package com.example.conversordeunidades;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class DolaresActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dolares_activity);

        final EditText Dolares = (EditText) findViewById(R.id.edDolares);
        final EditText Euros = (EditText) findViewById(R.id.edEuros);

        Button bDatos = this.findViewById(R.id.btnConvertir);
        Button bRegresar = this.findViewById(R.id.btnRegresar);

        bDatos.setOnClickListener(new View.OnClickListener() {
          @Override
                  public void onClick(View v){
                double dolares = Double.parseDouble(Dolares.getText().toString());
                double euros = dolares * 0.85;


                Euros.setText(String.valueOf(euros));


            }
        });

        bRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DolaresActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }
}
