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
    TextView saldoInicial, saldoRestante, saldoRestantev, numeroViajes, numeroViajesv;
    final Double valorViaje = 0.82;
    Double numeroDeViajes;
    Integer viajesInt;
    Double valorViajeRestante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        saldoInicialv = (EditText) findViewById(R.id.saldoInicialv);
        saldoInicial = (TextView) findViewById(R.id.saldoInicial);
        saldoRestante = (TextView) findViewById(R.id.saldoRestante);
        saldoRestantev = (TextView) findViewById(R.id.saldoRestantev);
        numeroViajes = (TextView) findViewById(R.id.numeroViajes);
        numeroViajesv = (TextView) findViewById(R.id.numeroViajesv);

        saldoRestantev.setText("0");
        saldoRestante.setVisibility(View.INVISIBLE);
        saldoRestantev.setVisibility(View.INVISIBLE);

        final Button viajeBtn = (Button) findViewById(R.id.viajeButton);
        viajeBtn.setVisibility(View.INVISIBLE);
        final Button storeBtn = (Button) findViewById(R.id.storageButton);


        viajeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorViajeRestante = Double.parseDouble(saldoRestantev.getText().toString().trim());
                if (valorViajeRestante < valorViaje){
                    Toast.makeText(getApplicationContext(), "Necesitas recargar la tarjeta", Toast.LENGTH_SHORT).show();
                    saldoInicialv.setVisibility(View.VISIBLE);
                    saldoInicial.setVisibility(View.VISIBLE);
                    storeBtn.setVisibility(View.VISIBLE);
                    saldoInicialv.setText(" ");
                    saldoRestante.setVisibility(View.INVISIBLE);
                    saldoRestantev.setVisibility(View.INVISIBLE);
                    viajeBtn.setVisibility(View.INVISIBLE);

                }
                else{
                    if (!saldoRestantev.getText().toString().isEmpty()){
                        saldoRestantev.setText(String.valueOf(Double.parseDouble(saldoRestantev.getText().toString())-valorViaje));
                        numeroDeViajes = valorViajeRestante/valorViaje - 1;
                        viajesInt = numeroDeViajes.intValue();
                        numeroViajesv.setText((String.valueOf(viajesInt)));
                    }
                }
            }
        });


        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!saldoInicialv.getText().toString().isEmpty()) {
                    saldoRestantev.setText(saldoInicialv.getText());
                    saldoInicialv.setVisibility(View.INVISIBLE);
                    saldoInicial.setVisibility(View.INVISIBLE);
                    storeBtn.setVisibility(View.INVISIBLE);
                    viajeBtn.setVisibility(View.VISIBLE);
                    saldoRestante.setVisibility(View.VISIBLE);
                    saldoRestantev.setVisibility(View.VISIBLE);
                }
            }
        });


        saldoInicialv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
