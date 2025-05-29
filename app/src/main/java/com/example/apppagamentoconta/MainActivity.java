package com.example.apppagamentoconta;


import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mValorConta;
    private EditText mDinheiro;
    private TextView mTaxaServico;
    private TextView mTotal;

    private TextView mTroco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mValorConta = findViewById(R.id.valorConta);
        mDinheiro = findViewById(R.id.dinheiro);
        mTaxaServico = findViewById(R.id.taxaServico);
        mTotal = findViewById(R.id.total);
        mTroco = findViewById(R.id.troco);
    }

    @SuppressLint("DefaultLocale")
    public void calcular(View view) {

        String valorContaString = mValorConta.getText().toString();
        String dinheiroString = mDinheiro.getText().toString();

        if (valorContaString.isEmpty() || dinheiroString.isEmpty()) {
            return;
        }


        float valorConta = Float.parseFloat(valorContaString);
        float dinheiro = Float.parseFloat(dinheiroString);

        float taxa = valorConta / 100 * 15;
        mTaxaServico.setText(format("R$ %.2f", taxa));

        float valorContaTaxa = valorConta + (valorConta / 100 * 15);
        mTotal.setText(format("R$ %.2f", valorContaTaxa));

        float troco = dinheiro - valorContaTaxa;
        mTroco.setText(format("R$ %.2f", troco));


    }
}