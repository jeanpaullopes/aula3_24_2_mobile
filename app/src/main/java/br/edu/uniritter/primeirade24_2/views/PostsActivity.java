package br.edu.uniritter.primeirade24_2.views;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.uniritter.primeirade24_2.R;
import br.edu.uniritter.primeirade24_2.adapters.PostsAdapter;
import br.edu.uniritter.primeirade24_2.services.PostServices;

public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_posts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // criar um apontamento para o RecyclerView
        RecyclerView rv = findViewById(R.id.PostRV);

        //criar um layout manager para o RecyclerView
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //LinearLayoutManager llmh = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //definir o layout manager para o RecyclerView
        rv.setLayoutManager(llm);
        //rv.setLayoutManager(llmh);
        // criar um adapter para o RecyclerView
        PostsAdapter adapter = new PostsAdapter(PostServices.getInstance(this).getPosts(), this, true);
        //PostsAdapter adapterHorizontal = new PostsAdapter(PostServices.getInstance(this).getPosts(), this, false);

        //definir o adapter para o RecyclerView
        rv.setAdapter(adapter);
        //rv.setAdapter(adapterHorizontal);

    }

}