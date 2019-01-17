package com.example.sharedpreferencesapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private TextView tv;
    private SharedPreferences sPref;
    private final String SAVED_TEXT = "seved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
    }

    public void onClickSaveText(View v) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, et.getText().toString());
        et.setText("");
        ed.commit();
        Toast.makeText(this, "text saved", Toast.LENGTH_LONG).show();
    }


    public void onClickLoadText(View v) {
        sPref = getPreferences(MODE_PRIVATE);
        tv.setText(sPref.getString(SAVED_TEXT, ""));
        Toast.makeText(this, "text unloaded", Toast.LENGTH_LONG).show();
    }
}
