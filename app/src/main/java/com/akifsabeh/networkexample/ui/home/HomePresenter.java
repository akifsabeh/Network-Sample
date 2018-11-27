package com.akifsabeh.networkexample.ui.home;

import com.akifsabeh.networkexample.network.NetworkInjector;
import com.akifsabeh.networkexample.network.NetworkService;
import com.akifsabeh.networkexample.ui.base.Presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Akif sabeh on 11/27/2018.
 */
public class HomePresenter extends Presenter<HomeContract.View> implements HomeContract.Presenter {

    private NetworkService networkService;
    private CompositeDisposable compositeDisposable;

    public HomePresenter() {
        networkService = NetworkInjector.getInstance().provideNetworkService();
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void getPosts() {
        showWait();
        compositeDisposable.add(networkService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts -> {
                    hideWait();
                    getView().get().getPostsSuccess(posts);
                }, throwable -> {
                    hideWait();
                    getView().get().onNetworkError(throwable.getMessage());
                }));

    }

    private void showWait() {
        getView().get().showWait(true);
    }


    private void hideWait() {
        getView().get().showWait(false);
    }


    @Override
    public void stop() {
        compositeDisposable.clear();
    }


}
