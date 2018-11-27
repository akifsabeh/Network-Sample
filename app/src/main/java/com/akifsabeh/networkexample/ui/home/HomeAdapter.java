package com.akifsabeh.networkexample.ui.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akifsabeh.networkexample.R;
import com.akifsabeh.networkexample.models.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akif sabeh on 11/27/2018.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private List<Post> posts;
    private HomeAdapterInterface homeAdapterInterface;

    public HomeAdapter(HomeAdapterInterface homeAdapterInterface) {
        posts = new ArrayList<>();
        this.homeAdapterInterface = homeAdapterInterface;
    }

    public HomeAdapter(List<Post> posts, HomeAdapterInterface homeAdapterInterface) {
        this.posts = posts;
        this.homeAdapterInterface = homeAdapterInterface;
    }



    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        HomeViewHolder homeViewHolder;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item, viewGroup, false);
        homeViewHolder = new HomeViewHolder(view);
        homeViewHolder.itemView.setOnClickListener(v -> {
            int position = homeViewHolder.getAdapterPosition();
            homeAdapterInterface.onPostClick(posts.get(position));
        });
        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {
        homeViewHolder.bind(posts.get(i));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void addPosts(List<Post> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        notifyDataSetChanged();
    }

    public interface HomeAdapterInterface {
        void onPostClick(Post post);
    }
}
