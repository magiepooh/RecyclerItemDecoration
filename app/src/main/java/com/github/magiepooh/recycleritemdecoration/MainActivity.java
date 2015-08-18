package com.github.magiepooh.recycleritemdecoration;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main_vertical).setOnClickListener(this);
        findViewById(R.id.btn_main_horizontal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_vertical:
                VerticalActivity.startActivity(this);
                break;
            case R.id.btn_main_horizontal:
                HorizontalActivity.startActivity(this);
                break;
        }
    }
}
