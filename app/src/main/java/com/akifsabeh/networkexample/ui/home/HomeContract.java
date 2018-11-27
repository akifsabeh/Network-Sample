package com.akifsabeh.networkexample.ui.home;

import com.akifsabeh.networkexample.models.Post;
import com.akifsabeh.networkexample.ui.base.listeners.BaseView;

import java.util.List;

/**
 * Created by Akif sabeh on 11/27/2018.
 */
public interface HomeContract {

    interface View extends BaseView {

        void getPostsSuccess(List<Post> posts);

    }

    interface Presenter {

        void getPosts();


    }
}
