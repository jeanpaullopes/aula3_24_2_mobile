package br.edu.uniritter.primeirade24_2.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.uniritter.primeirade24_2.Activity2;
import br.edu.uniritter.primeirade24_2.R;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.primeirade24_2.databinding.LayoutBinding;
import br.edu.uniritter.primeirade24_2.models.Post;
import br.edu.uniritter.primeirade24_2.views.PostsActivity;

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
        LayoutBinding lb = null;
        if (vertical) {
             lb = LayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);            //view = LayoutInflater.from(context)
            //        .inflate(R.layout.layout, parent, false);
        } else {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.layout_horizontal, parent, false);
        }
        PostViewHolder vh = new PostViewHolder(lb.getRoot());
        vh.setBinding(lb);
        return vh;

    }

    @RequiresApi(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post postAtual = postsFiltrados.get(position);
        holder.getBinding().setObjPost(postAtual);
        holder.getBinding().setClickListener((v) -> {
            Intent intent = new Intent(context, Activity2.class);
            intent.putExtra("valorToString", postAtual.toString());
            intent.putExtra("post", postAtual);
            context.startActivity(intent);

        });
        Button btn = holder.getView().findViewById(R.id.btnDetalhePost);
        /*View view = holder.getView();
        Button btn = view.findViewById(R.id.btnDetalhePost);
        btn.setOnClickListener((v) -> {
            Intent intent = new Intent(context, Activity2.class);
            intent.putExtra("valorToString", postAtual.toString());
            intent.putExtra("post", postAtual);
            context.startActivity(intent);

        });
        ((TextView) view.findViewById(R.id.tvObjIdDetalhe)).setText(postAtual.toString());
        ((TextView) view.findViewById(R.id.tvPostId)).setText(String.valueOf(postAtual.getId()));
        ((TextView) view.findViewById(R.id.tvUser)).setText("user-> "+postAtual.getUserId());
        ((TextView) view.findViewById(R.id.tvvPostTitle)).setText(postAtual.getTitle());
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


        });*/
    }
    @Override
    public int getItemCount() {
        return postsFiltrados.size();
    }


    class PostViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private LayoutBinding binding;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

        }
        public View getView() {
            return view;
        }
        public LayoutBinding getBinding() {
            return binding;
        }
        public void setBinding(LayoutBinding binding) {
            this.binding = binding;
        }
    }
}
