package com.akifsabeh.networkexample.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.akifsabeh.networkexample.ui.base.listeners.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by user on 9/16/2017.
 */


public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected Presenter presenter;

    private Unbinder unbinder;

    public abstract int getLayoutId();

    public abstract void postCreate();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);

      /*  if (presenter != null)
            presenter.initialize(getIntent().getExtras());*/

        postCreate();
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null)
            presenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.finalizeView();
            //presenter.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
