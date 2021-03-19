package com.example.calculadora1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculadoraActivity extends Activity {

    private EditText mostrador;
    String op = null, num2 = "";
    Integer numero1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        mostrador = findViewById(R.id.editText1);
    }

    public void botaoNumero(View v) {
        String conteudo = mostrador.getText().toString();
        Button botaoPressionado = (Button) v;
        if (numero1 == null) {
            mostrador.setText(conteudo + botaoPressionado.getText().toString());
        } else {
            mostrador.setText(conteudo + botaoPressionado.getText().toString());
            num2 = num2.concat(botaoPressionado.getText().toString());
        }
    }

    public void btnOperacao(View v) {
        String conteudo = mostrador.getText().toString();
        if (op == null) {
            numero1 = Integer.valueOf(conteudo);
            Button botaoPressionado = (Button) v;
            op = botaoPressionado.getText().toString();
            mostrador.setText(conteudo + op);
        }
    }

    public void btnEquals(View v) {
        double result = 0;
        if (num2 != "") {
            Integer numero2 = Integer.valueOf(num2);
            if (op.equals("+")) {
                result = numero1 + numero2;
            } else if (op.equals("-")) {
                result = numero1 - numero2;
            } else if (op.equals("*")) {
                result = numero1 * numero2;
            } else if (op.equals("/")) {
                double n1 = numero1, n2 = numero2;
                result = n1 / n2;
            }
        }
        numero1 = null;
        num2 = "";
        op = null;
        mostrador.setText(String.valueOf(result));
    }

    public void btnClear(View v) {
        mostrador.setText("");
        numero1 = null;
        num2 = "";
        op = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculadora, menu);
        return true;
    }

}



