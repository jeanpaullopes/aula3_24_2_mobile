package br.edu.uniritter.primeirade24_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //escolhe o layout (via xml) a ser 'inflado' na tela
        setContentView(R.layout.main_activity);
        //setContentView(R.layout.novo_layout);
        View btn = this.findViewById(R.id.btn_1);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicou no botão 1");
            }
        };
        btn.setOnClickListener((view)->{
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("dado", "Olá Mundo enviando via Intent");

            EditText ed  = findViewById(R.id.edNome);
            intent.putExtra("nome", ed.getText().toString());

            startActivity(intent);


        });
        this.findViewById(R.id.button2).setOnClickListener(this);
        this.findViewById(R.id.button3).setOnClickListener(this);
        this.findViewById(R.id.button4).setOnClickListener(this);
        // ijetando o listener ocl no botão
        //btn.setOnClickListener(ocl);
        /*
        criando e injetado o listener no botão
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicou no botão 1");
            }
        });

         */

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ViewGroup layout = findViewById(R.id.llInterno);
        for (int i = 0; i < 10; i++) {
            if (i%2 == 0) {
                Button novo = new Button(this);
                novo.setText("Botão novo " + i);
                novo.setOnClickListener(this);
                layout.addView(novo);
            } else {
                TextView novo = new TextView(this);
                novo.setText("Texto novo " + i);
                layout.addView(novo);
            }
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button2) {
            ViewGroup layout = findViewById(R.id.llInterno);

            for (int i = 0; i < layout.getChildCount(); i++) {
                View v = layout.getChildAt(i);
                if (v instanceof Button) {
                    v.setVisibility(View.INVISIBLE);
                }
            }

        }
        if (view.getId() == R.id.button3) {
            ViewGroup layout = findViewById(R.id.llInterno);
            for (int i = 0; i < layout.getChildCount(); i++) {
                View v = layout.getChildAt(i);

                    v.setVisibility(View.VISIBLE);

            }

        }
        if (view.getId() == R.id.button4) {
            ViewGroup layout = findViewById(R.id.llInterno);
            for (int i = 0; i < layout.getChildCount(); i++) {
                View v = layout.getChildAt(i);
                if (v instanceof TextView && !(v instanceof Button)){
                    v.setVisibility(View.GONE);
                }
            }

        }
    }
}