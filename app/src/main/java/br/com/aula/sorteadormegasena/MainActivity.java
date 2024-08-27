package br.com.aula.sorteadormegasena;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView txtValor1, txtValor2, txtValor3, txtValor4, txtValor5, txtValor6;
    private Button btnSortear, btnLimpar;

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

        // Vinculando os componentes da interface
        txtValor1 = findViewById(R.id.txtValor1);
        txtValor2 = findViewById(R.id.txtValor2);
        txtValor3 = findViewById(R.id.txtValor3);
        txtValor4 = findViewById(R.id.txtValor4);
        txtValor5 = findViewById(R.id.txtValor5);
        txtValor6 = findViewById(R.id.txtValor6);
        btnSortear = findViewById(R.id.btnSortear);
        btnLimpar = findViewById(R.id.btnLimpar);

        // Configurando listeners para os botões
        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortearNumeros();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    private void sortearNumeros() {
        Set<Integer> numerosSet = new HashSet<>();
        Random random = new Random();

        // Gerando 6 números únicos
        while (numerosSet.size() < 6) {
            numerosSet.add(random.nextInt(60) + 1);
        }

        // Convertendo para array e ordenando
        Integer[] numerosArray = numerosSet.toArray(new Integer[0]);
        Arrays.sort(numerosArray);

        // Exibindo os números nos TextViews
        txtValor1.setText(String.valueOf(numerosArray[0]));
        txtValor2.setText(String.valueOf(numerosArray[1]));
        txtValor3.setText(String.valueOf(numerosArray[2]));
        txtValor4.setText(String.valueOf(numerosArray[3]));
        txtValor5.setText(String.valueOf(numerosArray[4]));
        txtValor6.setText(String.valueOf(numerosArray[5]));
    }

    private void limparCampos() {
        txtValor1.setText("");
        txtValor2.setText("");
        txtValor3.setText("");
        txtValor4.setText("");
        txtValor5.setText("");
        txtValor6.setText("");
    }
}
