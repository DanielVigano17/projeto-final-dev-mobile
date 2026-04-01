package br.org.sp.fatec.appfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnMegaSena = findViewById(R.id.btnMegaSena);
        Button btnIMC = findViewById(R.id.btnIMC);
        Button btnJokenpo = findViewById(R.id.btnJokenpo);
        Button btnFelicidade = findViewById(R.id.btnFelicidade);

        btnMegaSena.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MegaSenaActivity.class)));
        btnIMC.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, IMCActivity.class)));
        btnJokenpo.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, JokenpoActivity.class)));
        btnFelicidade.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FelicidadeActivity.class)));
    }
}
