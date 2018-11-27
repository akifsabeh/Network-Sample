package com.akifsabeh.networkexample.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.akifsabeh.networkexample.R;
import com.akifsabeh.networkexample.models.Post;
import com.akifsabeh.networkexample.ui.base.BaseActivity;
import com.akifsabeh.networkexample.utils.Utils;

import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements HomeContract.View, HomeAdapter.HomeAdapterInterface {

    private HomePresenter homePresenter;

    private HomeAdapter homeAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressBar;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void postCreate() {

        initPresenter();
        initRecycler();
        queryPosts();

    }

    private void queryPosts() {
        homePresenter.getPosts();
    }

    private void initRecycler() {
        homeAdapter = new HomeAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeAdapter);
    }

    private void initPresenter() {
        homePresenter = new HomePresenter();
        homePresenter.setView(this);
    }


    @Override
    public void showWait(boolean showWait) {
        progressBar.setVisibility(showWait ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onNetworkError(String message) {
        Utils.showToast(this, message, Toast.LENGTH_LONG);
    }


    @Override
    public void getPostsSuccess(List<Post> posts) {
        homeAdapter.addPosts(posts);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.stop();
    }

    @Override
    public void onPostClick(Post post) {
        Utils.showToast(this, post.toString(), Toast.LENGTH_SHORT);
    }
}
