package com.example.viewmodelapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        final MyViewModel viewModel =
                ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getProgressState().observe(this, new
                Observer<Boolean>() {
                    @Override
                    public void onChanged(@Nullable Boolean
                                                  isVisibleProgressBar) {
                        if (isVisibleProgressBar) {
                            progressBar.setVisibility(View.VISIBLE);
                        } else {
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
        viewModel.doSomeThing();
    }
}

