package br.edu.uniritter.primeirade24_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import br.edu.uniritter.primeirade24_2.models.Post;
import br.edu.uniritter.primeirade24_2.presenters.MainPresenter;
import br.edu.uniritter.primeirade24_2.presenters.MainPresenterContract;
import br.edu.uniritter.primeirade24_2.services.PostServices;
import br.edu.uniritter.primeirade24_2.views.PostsActivity;

public class MainActivity extends AppCompatActivity implements
        MainPresenterContract.view {

    private MainPresenterContract.presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //escolhe o layout (via xml) a ser 'inflado' na tela
        setContentView(R.layout.main_activity);

        this.presenter = new MainPresenter(this);
        //setContentView(R.layout.novo_layout);
        View btn = this.findViewById(R.id.btn_1);

        //cria ou busca o PostServices singleton
        View.OnClickListener         ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicou no botão 1");
            }
        };
        btn.setOnClickListener((view)->{
            presenter.onButtonClick(view);
});
        this.findViewById(R.id.btn_1).setOnClickListener((view)->{
            presenter.onButtonClick(view);
        });
        this.findViewById(R.id.button2).setOnClickListener((view)->{
            EditText et = findViewById(R.id.edPostId);
            try {
                presenter.setPostId(et.getText().toString());
                presenter.onButtonClick(view);
            } catch (NumberFormatException e) {
                Log.e("MainActivity", "Erro ao converter para inteiro");
            }
        });
        this.findViewById(R.id.button3).setOnClickListener((view)->{
            presenter.onButtonClick(view);
        });
        this.findViewById(R.id.button4).setOnClickListener((view)->{
            presenter.onButtonClick(view);
        });
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

    }

    @Override
    protected void onStart() {
        super.onStart();




    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void openActivity(Class<?> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    @Override
    public void openActivity(Class<?> c, String parcelableName, Parcelable parcelable) {
        Intent intent = new Intent(this, c);
        intent.putExtra(parcelableName, parcelable);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}