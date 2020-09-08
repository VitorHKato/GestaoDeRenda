package com.cursoandroid.gestaoderenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText valor45;
    private EditText valor35;
    private EditText quantidade45;
    private EditText quantidade35;

    private TextView textoTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor45 = findViewById(R.id.valor45);
        valor35 = findViewById(R.id.valor35);
        quantidade45 = findViewById(R.id.quantidade45);
        quantidade35 = findViewById(R.id.quantidade35);
        textoTotal = findViewById(R.id.textoTotal);
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
        apagar(view);
        textoTotal.setText("R$ 0.00");
    }
}
