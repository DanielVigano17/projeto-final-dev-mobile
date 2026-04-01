package br.org.sp.fatec.appfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class JokenpoActivity extends AppCompatActivity {

    private int placarVoce = 0;
    private int placarPC = 0;
    private TextView tvPlacar, tvResultadoRodada;
    private Button btnReiniciar;
    private boolean jogoAtivo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);

        tvPlacar = findViewById(R.id.tvPlacar);
        tvResultadoRodada = findViewById(R.id.tvResultadoRodada);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        findViewById(R.id.btnPedra).setOnClickListener(v -> jogar(0));
        findViewById(R.id.btnPapel).setOnClickListener(v -> jogar(1));
        findViewById(R.id.btnTesoura).setOnClickListener(v -> jogar(2));

        btnReiniciar.setOnClickListener(v -> reiniciarJogo());
        btnVoltar.setOnClickListener(v -> finish());
    }

    private void jogar(int escolhaUsuario) {
        if (!jogoAtivo) return;

        int escolhaPC = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String msg = "PC escolheu " + opcoes[escolhaPC] + ". ";

        if (escolhaUsuario == escolhaPC) {
            msg += "Empate!";
        } else if ((escolhaUsuario == 0 && escolhaPC == 2) ||
                   (escolhaUsuario == 1 && escolhaPC == 0) ||
                   (escolhaUsuario == 2 && escolhaPC == 1)) {
            msg += "Você venceu a rodada!";
            placarVoce++;
        } else {
            msg += "PC venceu a rodada!";
            placarPC++;
        }

        tvResultadoRodada.setText(msg);
        atualizarPlacar();
        verificarFimDeJogo();
    }

    private void atualizarPlacar() {
        tvPlacar.setText("VOCÊ " + placarVoce + " x " + placarPC + " PC");
    }

    private void verificarFimDeJogo() {
        if (placarVoce == 2 || placarPC == 2) {
            jogoAtivo = false;
            String vencedor = placarVoce == 2 ? "VOCÊ VENCEU O JOGO!" : "O PC VENCEU O JOGO!";
            tvResultadoRodada.setText(vencedor);
            btnReiniciar.setVisibility(View.VISIBLE);
        }
    }

    private void reiniciarJogo() {
        placarVoce = 0;
        placarPC = 0;
        jogoAtivo = true;
        atualizarPlacar();
        tvResultadoRodada.setText("Escolha sua jogada!");
        btnReiniciar.setVisibility(View.GONE);
    }
}
