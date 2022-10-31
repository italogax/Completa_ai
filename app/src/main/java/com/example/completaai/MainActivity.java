package com.example.completaai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Entrada de daodos do User.
    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;

    //Resposta sitema.
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editAlcool); //Campo de entrada do valor do Etanol.
        editPrecoGasolina = findViewById(R.id.editGasolina); //Campo de entrada do valor Gasolina.
        textResultado = findViewById(R.id.textResultado); //Campo onde demonstra o resultado.
    }
    //Função para efetuar o calculo.
    public void calc (View v) {

        //Verificação de todos os campos.
        if (editPrecoAlcool.getText().toString().trim().equals("") ||
                editPrecoGasolina.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show(); //Mensagem caso algum dos campos esteja vazio.

            //Verificação do campo ETANOL
            if (editPrecoAlcool.getText().toString().trim().equals("")) {
                editPrecoAlcool.setError("Este campo é obrigatorio"); //Mensagem erro.
                textResultado.setText("RESULTADO"); //Limpando dados antigos do campo.
            }
            if (editPrecoGasolina.getText().toString().trim().equals("")) {
                editPrecoGasolina.setError("Este campo é obrigatorio"); //Mensagem erro.
                textResultado.setText("RESULTADO"); //Limpando dados antigos do campo.
        }
        }
        //Calculo a ser feito caso os campos estejam preenchidos.
        else {
            Double vl_gasolina = Double.parseDouble(editPrecoGasolina.getText().toString()); //Valor da Gasolina inserido pelo User.
            Double vl_etanol = Double.parseDouble(editPrecoAlcool.getText().toString()); //Valor da Etanol inserido pelo User.
            Double result = (vl_etanol * 100) / vl_gasolina; //Formula para saber qual combustivel esta mais em conta.

            if (result >= 70) {
                textResultado.setText("Abasteça com Gasolina"); //Mensagem a ser exibida caso a Gasolina esteje valendo a pena.
            } else {
                textResultado.setText("Abasteça com Etanol"); //Mensagem a ser exibida caso a Etanol esteje valendo a pena.
            }
            editPrecoGasolina.setText(""); //Limpa campo da Gasolina.
            editPrecoAlcool.setText(""); //Limpa campo do Etanol.
        }
    }
}
