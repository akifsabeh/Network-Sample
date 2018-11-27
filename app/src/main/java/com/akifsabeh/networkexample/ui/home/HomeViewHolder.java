package com.akifsabeh.networkexample.ui.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.akifsabeh.networkexample.R;
import com.akifsabeh.networkexample.models.Post;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Akif sabeh on 11/27/2018.
 */
public class HomeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView txt_title;
    @BindView(R.id.txt_body)
    TextView txt_body;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Post post) {
        txt_title.setText(post.getTitle());
        txt_body.setText(post.getBody());

    }
}
