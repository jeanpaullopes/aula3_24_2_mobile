package br.edu.uniritter.primeirade24_2.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.json.JSONObject;

public class Post implements Parcelable {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    protected Post(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post(JSONObject json) {
        this.title = "";
        this.body = "";
        try {
            this.userId = json.getInt("userId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.id = json.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.title = json.getString("title");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.body = json.getString("body");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.userId);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.body);

    }
}

/*
{
"userId":1,
"id":1,
"title":"sunt .. nderit",
"body":"quia et.. s"
},
 */