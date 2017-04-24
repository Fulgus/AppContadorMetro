package com.santosjosemaria.metromalaga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Contador extends AppCompatActivity {

    EditText saldoInicialv;
    TextView saldoInicial, saldoRestante, saldoRestantev;
    final Double valorViaje = 0.82;
    double valorViajeRestante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        saldoInicialv = (EditText) findViewById(R.id.saldoInicialv);
        saldoInicial = (TextView) findViewById(R.id.saldoInicial);
        saldoRestante = (TextView) findViewById(R.id.saldoRestante);
        saldoRestantev = (TextView) findViewById(R.id.saldoRestantev);

        saldoRestantev.setText("0");


        final Button viajeBtn = (Button) findViewById(R.id.viajeButton);


        viajeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorViajeRestante = Double.parseDouble(saldoRestantev.getText().toString().trim());
                if (valorViajeRestante < valorViaje){
                    Toast.makeText(getApplicationContext(), "Necesitas recargar la tarjeta", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (!saldoRestantev.getText().toString().isEmpty())
                        saldoRestantev.setText(String.valueOf(Double.parseDouble(saldoRestantev.getText().toString())-valorViaje));
                }
            }
        });


        saldoInicialv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viajeBtn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!saldoInicialv.getText().toString().isEmpty())
                    saldoRestantev.setText(saldoInicialv.getText());
                else
                    saldoRestantev.setText("0");
            }
        });
    }
}
