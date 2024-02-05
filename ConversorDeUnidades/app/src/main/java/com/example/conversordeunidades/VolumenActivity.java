package com.example.conversordeunidades;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;


public class VolumenActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volumen_activity);

        final EditText Litros = (EditText) findViewById(R.id.edLitros);
        final TextView Milo = (TextView) findViewById(R.id.tvMililitros);

        Button bConvertir = this.findViewById(R.id.btnConvertir);
        Button bRegresar = this.findViewById(R.id.btnRegresar);

bConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                double litros = Double.parseDouble(Litros.getText().toString());
                double mililitros = litros * 1000;
                Milo.setText(String.valueOf(mililitros));
            }
        });

        bRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VolumenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
