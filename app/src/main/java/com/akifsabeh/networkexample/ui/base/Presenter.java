package com.akifsabeh.networkexample.ui.base;

import android.os.Bundle;


import com.akifsabeh.networkexample.ui.base.listeners.BaseView;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Created by Akif on 9/15/2017.
 */

public abstract class Presenter<T extends BaseView> {

    private WeakReference<T> view;

    protected AtomicBoolean isViewAlive = new AtomicBoolean();

    public WeakReference<T> getView() {
        return view;
    }

    public void setView(T view) {
        this.view = new WeakReference<>(view);
    }

    public void initialize(Bundle extras) {

    }

    public void start() {
        isViewAlive.set(true);
    }

    public void finalizeView() {
        isViewAlive.set(false);
    }

    public abstract void stop();


}
