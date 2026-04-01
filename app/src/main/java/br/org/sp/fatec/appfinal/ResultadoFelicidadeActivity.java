package br.org.sp.fatec.appfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ResultadoFelicidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_felicidade);

        TextView tvPontuacao = findViewById(R.id.tvPontuacao);
        TextView tvClassificacao = findViewById(R.id.tvClassificacao);
        Button btnVoltarMenu = findViewById(R.id.btnVoltarMenu);

        double pontuacao = getIntent().getDoubleExtra("PONTUACAO", 0.0);
        tvPontuacao.setText(String.format(Locale.US, "%.1f", pontuacao));

        String classificacao;
        if (pontuacao <= 2.0) classificacao = "Muito Baixa (Alerta crítico)";
        else if (pontuacao <= 4.0) classificacao = "Baixa (Equilíbrio precário)";
        else if (pontuacao <= 6.0) classificacao = "Moderada (Estado neutro)";
        else if (pontuacao <= 8.0) classificacao = "Alta (Bom equilíbrio)";
        else classificacao = "Plena (Estado ideal)";

        tvClassificacao.setText(classificacao);

        btnVoltarMenu.setOnClickListener(v -> {
            Intent intent = new Intent(ResultadoFelicidadeActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
