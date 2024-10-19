package br.edu.uniritter.primeirade24_2.presenters;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;

public interface MainPresenterContract {
    public interface view {
        public Context getContext();
        public void openActivity(Class<?> c);
        public void openActivity(Class<?> c, String parcelableName, Parcelable parcelable);
        public void showMessage(String msg);

    }
    public interface presenter {
        public void setPostId(int id);
        public void setPostId(String id);
        public void onButtonClick(View btn);

    }
}
