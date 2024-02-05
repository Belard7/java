package com.example.conversordeunidades;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class MasaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masa_activity);

        final EditText Kilogramos = (EditText) findViewById(R.id.edKilogramos);
        final TextView Libras = (TextView) findViewById(R.id.tvLibras);

        Button bConvertir = this.findViewById(R.id.btnConvertir);
        Button bRegresar = this.findViewById(R.id.btnRegresar);

        bConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                double kilogramos = Double.parseDouble(Kilogramos.getText().toString());
                double libras = kilogramos * 2.20462;
                Libras.setText(String.valueOf(libras));
            }
        });

        bRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }





}
