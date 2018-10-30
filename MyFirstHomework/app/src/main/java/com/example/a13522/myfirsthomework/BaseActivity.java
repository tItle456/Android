package com.example.a13522.myfirsthomework;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int ori = this.getResources().getConfiguration().orientation;
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            setTheme(R.style.TextSizeLand);
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            setTheme(R.style.TextSizePort);
        }
    }
}
