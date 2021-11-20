package com.flettieri.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
        view.isSelected();
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
        view.isSelected();
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
        view.isSelected();
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView image = findViewById(R.id.imageResult);
        TextView text = findViewById(R.id.textResult);

        Random gerador = new Random();

        String[] opcoes = {"pedra", "papel", "tesoura"} ;
        String escolhaApp = opcoes[gerador.nextInt(3)];

        switch (escolhaApp) {
            case "pedra":
                image.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                image.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                image.setImageResource(R.drawable.tesoura);
                break;
        }

        if (opcaoSelecionada == "pedra" && escolhaApp == "tesoura"
            || opcaoSelecionada == "tesoura" && escolhaApp == "papel"
            || opcaoSelecionada == "papel" && escolhaApp == "pedra") {
            text.setText("Voce Ganhou!");
        } else if (opcaoSelecionada == "tesoura" && escolhaApp == "pedra"
                || opcaoSelecionada == "papel" && escolhaApp == "tesoura"
                || opcaoSelecionada == "pedra" && escolhaApp == "papel") {
            text.setText("Voce Perdeu!");

        } else {
            text.setText("Rolou Empate!");
        }
    }


}