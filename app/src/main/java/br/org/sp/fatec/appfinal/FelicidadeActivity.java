package br.org.sp.fatec.appfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FelicidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicidade);

        RadioGroup rgSono = findViewById(R.id.rgSono);
        RadioGroup rgEstresse = findViewById(R.id.rgEstresse);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnCalcular.setOnClickListener(v -> {
            int selectedSono = rgSono.getCheckedRadioButtonId();
            int selectedEstresse = rgEstresse.getCheckedRadioButtonId();

            if (selectedSono == -1 || selectedEstresse == -1) {
                Toast.makeText(this, "Por favor, selecione todas as opções", Toast.LENGTH_SHORT).show();
                return;
            }

            int pesoSono = 0;
            if (selectedSono == R.id.rbSono1) pesoSono = 1;
            else if (selectedSono == R.id.rbSono2) pesoSono = 3;
            else if (selectedSono == R.id.rbSono3) pesoSono = 2;

            int pesoEstresse = 0;
            if (selectedEstresse == R.id.rbEstresse1) pesoEstresse = 3;
            else if (selectedEstresse == R.id.rbEstresse2) pesoEstresse = 2;
            else if (selectedEstresse == R.id.rbEstresse3) pesoEstresse = 1;

            double felicidade = ((double) (pesoSono + pesoEstresse) / 6.0) * 10.0;

            Intent intent = new Intent(FelicidadeActivity.this, ResultadoFelicidadeActivity.class);
            intent.putExtra("PONTUACAO", felicidade);
            startActivity(intent);
        });

        btnVoltar.setOnClickListener(v -> finish());
    }
}
