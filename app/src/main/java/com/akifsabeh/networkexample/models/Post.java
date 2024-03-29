package com.akifsabeh.networkexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Akif sabeh on 11/27/2018.
 */
public class Post {

    @Expose
    @SerializedName("body")
    private String body;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("userId")
    private int userId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                '}';
    }
}
