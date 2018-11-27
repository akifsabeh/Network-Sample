package com.akifsabeh.networkexample.network;

import com.akifsabeh.networkexample.models.Post;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Desk 2 on 4/5/2018.
 */


public interface NetworkService {

    String END_POINT = "posts";

    @GET(END_POINT)
    Single<List<Post>> getPosts();


}