package com.example.contadordegasolina;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
public class contador extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contador);

        final EditText etKilometros = (EditText) findViewById(R.id.etkilometros);
        final TextView  teResultado = (TextView) findViewById(R.id.teResultado);
         Button bDatos = this.findViewById(R.id.btnCalcular);

        final double CONSUMO_POR_KM = 0.05; //puse como constante el consumo de gasolina por kilometro

        bDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kilometrosStr = etKilometros.getText().toString();
                double kilometros = Double.parseDouble(kilometrosStr);
                double gastoGasolina = kilometros * CONSUMO_POR_KM;
                teResultado.setText("Gasto de gasolina: " + gastoGasolina + " litros");
                Toast.makeText(contador.this, "Kilometros: " + kilometrosStr + ", Gasto de gasolina: " + gastoGasolina + " litros", Toast.LENGTH_LONG).show();
            }
        });
    }

}
