package br.org.sp.fatec.appfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class IMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        EditText etPeso = findViewById(R.id.etPeso);
        EditText etAltura = findViewById(R.id.etAltura);
        Button btnCalcular = findViewById(R.id.btnCalcularIMC);
        TextView tvResultado = findViewById(R.id.tvResultadoIMC);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnCalcular.setOnClickListener(v -> {
            String strPeso = etPeso.getText().toString();
            String strAltura = etAltura.getText().toString();

            if (strPeso.isEmpty() || strAltura.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            double peso = Double.parseDouble(strPeso);
            double altura = Double.parseDouble(strAltura);
            double imc = peso / (altura * altura);

            String classificacao;
            if (imc < 18.5) classificacao = "Abaixo do peso";
            else if (imc < 25) classificacao = "Peso normal";
            else if (imc < 30) classificacao = "Sobrepeso";
            else if (imc < 35) classificacao = "Obesidade Grau I";
            else if (imc < 40) classificacao = "Obesidade Grau II";
            else classificacao = "Obesidade Grau III";

            tvResultado.setText(String.format(Locale.US, "IMC: %.2f\n%s", imc, classificacao));
        });

        btnVoltar.setOnClickListener(v -> finish());
    }
}
