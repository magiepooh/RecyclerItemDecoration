package com.github.magiepooh.recycleritemdecoration.demo;

import com.github.magiepooh.recycleritemdecoration.VerticalItemDecoration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by magiepooh on 2015/08
 */
public class VerticalActivity extends AppCompatActivity {

    private static final VerticalAdapter.Binder[] mockData = {
            new VerticalAdapter.TypeAObject("TypeA 1"),
            new VerticalAdapter.TypeAObject("TypeA 2"),
            new VerticalAdapter.TypeAObject("TypeA 3"),
            new VerticalAdapter.TypeAObject("TypeA 4"),
            new VerticalAdapter.TypeBObject("TypeB 5"),
            new VerticalAdapter.TypeBObject("TypeB 6"),
            new VerticalAdapter.TypeBObject("TypeB 7"),
            new VerticalAdapter.TypeBObject("TypeB 8"),
            new VerticalAdapter.TypeBObject("TypeB 9"),
            new VerticalAdapter.TypeBObject("TypeB 10"),
            new VerticalAdapter.TypeBObject("TypeB 11"),
            new VerticalAdapter.TypeAObject("TypeA 12"),
            new VerticalAdapter.TypeAObject("TypeA 13"),
            new VerticalAdapter.TypeAObject("TypeA 14"),
            new VerticalAdapter.TypeAObject("TypeA 15")
    };

    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, VerticalActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_vertical);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration decoration = new VerticalItemDecoration.Builder(this)
                .first(R.drawable.shape_decoration_sea_blue_h_8)
                .type(VerticalAdapter.ViewType.TYPE_A.ordinal(),
                        R.drawable.shape_decoration_black_h_1)
                .type(VerticalAdapter.ViewType.TYPE_B.ordinal(),
                        R.drawable.shape_decoration_gray_h_1)
                .last(R.drawable.shape_decoration_flush_orange_h_8)
                .build();
        recyclerView.addItemDecoration(decoration);

        recyclerView.setAdapter(new VerticalAdapter(mockData));
    }
}
