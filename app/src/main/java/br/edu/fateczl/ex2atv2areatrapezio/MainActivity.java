/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.ex2atv2areatrapezio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etBaseMaior;
    private EditText etBaseMenor;
    private EditText etAltura;
    private TextView tvRes;

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

        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMaior.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etBaseMenor.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etAltura = findViewById(R.id.etAltura);
        etAltura.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> calc());

    }

    private void calc() {
        int baseMaior = Integer.parseInt(etBaseMaior.getText().toString());
        int baseMenor = Integer.parseInt(etBaseMenor.getText().toString());
        int altura = Integer.parseInt(etAltura.getText().toString());
        int area = ((baseMaior + baseMenor) * altura) / 2;
        String res = "Área do trapézio: " + area;
        tvRes.setText(res);
        etBaseMaior.setText("");
        etBaseMenor.setText("");
        etAltura.setText("");
    }
}