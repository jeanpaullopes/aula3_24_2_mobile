package br.edu.uniritter.primeirade24_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import br.edu.uniritter.primeirade24_2.databinding.Activity2Binding;
import br.edu.uniritter.primeirade24_2.models.Post;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_2);
        Intent intent = getIntent();
        Post post = intent.getParcelableExtra("post");
        post.getId();
        Activity2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_2);
        binding.setObjPost(post);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
        TextView tv = findViewById(R.id.textView5);
        PostServices ps = PostServices.getInstance();

        tv.setText("olá "+intent.getStringExtra("nome")+ " "+ps.getPosts().get(50).getTitle());
        */
    }

}