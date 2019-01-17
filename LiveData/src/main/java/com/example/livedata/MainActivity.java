package com.example.livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);

        LiveData<String> networkLiveData = NetworkLiveData.getInstance(this);
        networkLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String value) {
                textView.setText(value);
            }
        });

    }
}
