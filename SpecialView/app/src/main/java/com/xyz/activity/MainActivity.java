package com.xyz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atvivity_main);
        findViewById(R.id.item_auto_scroll_tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.item_auto_scroll_tv) {
            startActivity(new Intent(MainActivity.this, AutoScrollTextViewActivity.class));
        }
    }
}
