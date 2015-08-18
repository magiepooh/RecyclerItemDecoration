package com.github.magiepooh.recycleritemdecoration.demo;

import com.github.magiepooh.recycleritemdecoration.HorizontalItemDecoration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by magiepooh on 2015/08/17.
 */
public class HorizontalActivity extends AppCompatActivity {

    private static final HorizontalAdapter.Binder[] mockData = {
            new HorizontalAdapter.TypeAObject("AType 1"),
            new HorizontalAdapter.TypeAObject("AType 2"),
            new HorizontalAdapter.TypeAObject("AType 3"),
            new HorizontalAdapter.TypeAObject("AType 4"),
            new HorizontalAdapter.TypeAObject("AType 5"),
            new HorizontalAdapter.TypeAObject("AType 6"),
            new HorizontalAdapter.TypeAObject("AType 7"),
            new HorizontalAdapter.TypeAObject("AType 8")
    };

    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, HorizontalActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);

        RecyclerView.ItemDecoration decoration = new HorizontalItemDecoration.Builder(this)
                .first(R.drawable.shape_decoration_sea_blue_w_8)
                .type(HorizontalAdapter.ViewType.TYPE_A.ordinal(),
                        R.drawable.shape_decoration_black_w_1)
                .last(R.drawable.shape_decoration_flush_orange_w_8)
                .build();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_horizontal);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new HorizontalAdapter(mockData));
        recyclerView.addItemDecoration(decoration);

        RecyclerView reverseRecyclerView = (RecyclerView) findViewById(
                R.id.recycler_horizontal_reverse);
        reverseRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        reverseRecyclerView.setAdapter(new HorizontalAdapter(mockData));
        reverseRecyclerView.addItemDecoration(decoration);
    }
}
