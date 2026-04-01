package br.org.sp.fatec.appfinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MegaSenaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_megasena);

        TextView tvNumeros = findViewById(R.id.tvNumeros);
        Button btnGerar = findViewById(R.id.btnGerar);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnGerar.setOnClickListener(v -> {
            List<Integer> numeros = new ArrayList<>();
            Random random = new Random();
            while (numeros.size() < 6) {
                int num = random.nextInt(60) + 1;
                if (!numeros.contains(num)) {
                    numeros.add(num);
                }
            }
            Collections.sort(numeros);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numeros.size(); i++) {
                sb.append(String.format("%02d", numeros.get(i)));
                if (i < numeros.size() - 1) sb.append("  ");
            }
            tvNumeros.setText(sb.toString());
        });

        btnVoltar.setOnClickListener(v -> finish());
    }
}
