package br.edu.uniritter.primeirade24_2.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.uniritter.primeirade24_2.R;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.primeirade24_2.models.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<Post> posts;
    private List<Post> postsFiltrados;
    private Context context;
    private boolean vertical = true;
    private int user = -1;

    public PostsAdapter(List<Post> posts, Context context, boolean vertical) {
        this.posts = posts;
        this.postsFiltrados = posts;
        this.context = context;
        this.vertical = vertical;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (vertical) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.layout, parent, false);
        } else {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.layout_horizontal, parent, false);
        }
        return new PostViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post postAtual = postsFiltrados.get(position);
        View view = holder.getView();
        view.setOnClickListener((v) -> {
            if (((EditText) view.findViewById(R.id.tvPostBody)).getVisibility() == View.VISIBLE) {
                ((EditText) view.findViewById(R.id.tvPostBody)).setVisibility(View.GONE);
            }
            else {
                ((EditText) view.findViewById(R.id.tvPostBody)).setVisibility(View.VISIBLE);
            }
            Toast.makeText(context, "Clicou no post " + postAtual.getId(), Toast.LENGTH_SHORT).show();
        });
        ((TextView) view.findViewById(R.id.tvPostId)).setText(String.valueOf(postAtual.getId()));
        ((TextView) view.findViewById(R.id.tvUser)).setText("user-> "+postAtual.getUserId());
        ((TextView) view.findViewById(R.id.tvvPostTitle)).setText(postAtual.getTitle());
        try {
            ((EditText) view.findViewById(R.id.tvPostBody)).setText(postAtual.getBody());
            ((EditText) view.findViewById(R.id.tvPostBody)).setVisibility(View.GONE);
        } catch (NullPointerException e) {
            System.out.println("Erro ao tentar setar o texto do EditText");
        }
        // trocar o chip de acordo com o valor de user
        // troquei o if por setar direto o resultado da comparação
        //if (user != -1) {
        //    ((Chip) view.findViewById(R.id.soUser)).setChecked(true);
        //} else {
        //    ((Chip) view.findViewById(R.id.soUser)).setChecked(false);
        //}
        ((CheckBox) view.findViewById(R.id.soUser)).setChecked( (user != -1) );
        view.findViewById(R.id.soUser).setOnClickListener((v) -> {
            if (user == -1) {
                user = postAtual.getUserId();
                this.postsFiltrados = new ArrayList<>();
                for (Post p : posts) {
                    if (p.getUserId() == user) {
                        this.postsFiltrados.add(p);
                    }
                }
                notifyDataSetChanged();

            } else {
                user = -1;
                this.postsFiltrados = posts;
                notifyDataSetChanged();
            }
            ((CheckBox) view.findViewById(R.id.soUser)).setChecked( (user != -1) );


        });
    }
    @Override
    public int getItemCount() {
        return postsFiltrados.size();
    }


    class PostViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
        public View getView() {
            return view;
        }
    }
}
