package com.akifsabeh.networkexample.ui.base.listeners;

/**
 * Created by Akif on 9/15/2017.
 */

public interface BaseView {

    void showWait(boolean showWait);

    void onNetworkError(String message);

}
