package br.edu.uniritter.primeirade24_2.presenters;

import android.content.Intent;
import android.view.View;

import br.edu.uniritter.primeirade24_2.Activity2;
import br.edu.uniritter.primeirade24_2.R;
import br.edu.uniritter.primeirade24_2.services.ModelDoesNotExistsException;
import br.edu.uniritter.primeirade24_2.services.PostDoesNotExistsException;
import br.edu.uniritter.primeirade24_2.services.PostServices;
import br.edu.uniritter.primeirade24_2.views.PostsActivity;

public class MainPresenter implements MainPresenterContract.presenter{
    private PostServices ps;
    private MainPresenterContract.view view;
    private int tempPostId;

    public MainPresenter(MainPresenterContract.view view){
        this.view = view;
        this.ps = PostServices.getInstance(view.getContext());
    }


    @Override
    public void setPostId(int id) {
        this.tempPostId = id;
    }

    @Override
    public void setPostId(String id) throws NumberFormatException{
        try {
            this.tempPostId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            this.tempPostId = 0;
            view.showMessage("o id de um post deve ser um número inteiro");
            throw e;
        }
    }

    @Override
    public void onButtonClick(View btn) {
        if (btn.getId() == R.id.btn_1) {
            // troca para não abrir uma activity fora do contexto de uma activity
            //Intent intent = new Intent(view.getContext(), PostsActivity.class);
            //view.getContext().startActivity(intent);
            view.openActivity(PostsActivity.class);
        }
        if (btn.getId() == R.id.button2) {
            try {
                view.openActivity(Activity2.class, "post", ps.getPost(tempPostId));
            } catch (ModelDoesNotExistsException e) {
                view.showMessage(e.getMessage());
            }
        }
    }
}
