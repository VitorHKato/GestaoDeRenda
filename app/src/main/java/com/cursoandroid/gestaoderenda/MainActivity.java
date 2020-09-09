package com.cursoandroid.gestaoderenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText valor45;
    private EditText valor35;
    private EditText quantidade45;
    private EditText quantidade35;

    private TextView textoTotal;

    private boolean resposta;

    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor45 = findViewById(R.id.valor45);
        valor35 = findViewById(R.id.valor35);
        quantidade45 = findViewById(R.id.quantidade45);
        quantidade35 = findViewById(R.id.quantidade35);
        textoTotal = findViewById(R.id.textoTotal);

        total = 0;
    }

    public void total(View view)
    {
        String campo1 = valor45.getText().toString();
        String campo2 = quantidade45.getText().toString();
        String campo3 = valor35.getText().toString();
        String campo4 = quantidade35.getText().toString();

        if(campo1.matches("") || campo2.matches("") || campo3.matches("") ||
                campo4.matches(""))
        {
            Toast.makeText(
                    getApplicationContext(),
                    "Por favor preencha os valores primeiro!",
                    Toast.LENGTH_LONG
            ).show();
        }
        else
        {
            double valor1 = Double.parseDouble(valor45.getText().toString());
            double valor2 = Double.parseDouble(valor35.getText().toString());
            int quantidade1 = Integer.parseInt(quantidade45.getText().toString());
            int quantidade2 = Integer.parseInt(quantidade35.getText().toString());

            Toast.makeText(
                    getApplicationContext(),
                    "Valor adicionado!",
                    Toast.LENGTH_SHORT
            ).show();

            total = (valor1 * 0.45 * quantidade1) + (valor2 * 0.35 * quantidade2);

            DecimalFormat format = new DecimalFormat("0.00");
            total = Double.valueOf(format.format(total));

            textoTotal.setText("R$ " + total);

            Toast.makeText(
                    getApplicationContext(),
                    "Total calculado!",
                    Toast.LENGTH_SHORT
            ).show();

            apagar(view);
        }
    }

    public void adicionar(View view)
    {
        String campo1 = valor45.getText().toString();
        String campo2 = quantidade45.getText().toString();
        String campo3 = valor35.getText().toString();
        String campo4 = quantidade35.getText().toString();

        double valorTotal = 0;

        if(campo1.matches("") || campo2.matches("") || campo3.matches("") ||
                campo4.matches(""))
        {
            Toast.makeText(
                    getApplicationContext(),
                    "Por favor preencha os valores primeiro!",
                    Toast.LENGTH_LONG
            ).show();
        }
        else
        {
            double valor1 = Double.parseDouble(valor45.getText().toString());
            double valor2 = Double.parseDouble(valor35.getText().toString());
            int quantidade1 = Integer.parseInt(quantidade45.getText().toString());
            int quantidade2 = Integer.parseInt(quantidade35.getText().toString());

            Toast.makeText(
                    getApplicationContext(),
                    "Valor adicionado!",
                    Toast.LENGTH_SHORT
            ).show();

            valorTotal = (valor1 * 0.45 * quantidade1) + (valor2 * 0.35 * quantidade2);

            total += valorTotal;

            DecimalFormat format = new DecimalFormat("0.00");
            total = Double.valueOf(format.format(total));

            textoTotal.setText("R$ " + total);

            Toast.makeText(
                    getApplicationContext(),
                    "Valor adicionado!",
                    Toast.LENGTH_SHORT
            ).show();

            apagar(view);
        }
    }

    public void apagar(View view)
    {
        valor45.setText("");
        valor35.setText("");
        quantidade35.setText("");
        quantidade45.setText("");
    }

    public void reiniciar(View view)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Alerta!");
        dialog.setMessage("Têm certeza que deseja reiniciar a contagem?");

        dialog.setCancelable(false);

        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                total = 0;
                textoTotal.setText("R$ " + total);
                resposta = true;

                Toast.makeText(
                        getApplicationContext(),
                        "Valor total zerado.",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resposta = false;
            }
        });

        dialog.create();
        dialog.show();

        if(resposta)
            apagar(view);
    }

}
