package com.example.viewmodelapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

class MyViewModel extends ViewModel {
    private MutableLiveData<Boolean> showProgress = new
            MutableLiveData<>();

    void doSomeThing() {
        showProgress.postValue(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showProgress.postValue(false);
            }
        }, 10000);
    }

    MutableLiveData<Boolean> getProgressState() {
        return showProgress;
    }
}

