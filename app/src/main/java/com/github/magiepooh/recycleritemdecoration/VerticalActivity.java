package com.github.magiepooh.recycleritemdecoration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by magiepooh on 2015/08/17.
 */
public class VerticalActivity extends AppCompatActivity {

    private static final VerticalAdapter.Binder[] mockData = {
            new VerticalAdapter.TypeAObject("111111"),
            new VerticalAdapter.TypeAObject("2222"),
            new VerticalAdapter.TypeAObject("3333333"),
            new VerticalAdapter.TypeAObject("77"),
            new VerticalAdapter.TypeBObject("444"),
            new VerticalAdapter.TypeBObject("5"),
            new VerticalAdapter.TypeBObject("6666666"),
            new VerticalAdapter.TypeBObject("88"),
            new VerticalAdapter.TypeBObject("aaaaa"),
            new VerticalAdapter.TypeBObject("cccc"),
            new VerticalAdapter.TypeBObject("EEEE"),
            new VerticalAdapter.TypeAObject("b"),
            new VerticalAdapter.TypeAObject("DDDD"),
            new VerticalAdapter.TypeAObject("999"),
            new VerticalAdapter.TypeAObject("FFF")
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
                .first(R.drawable.shape_decoration_sea_blue_w_8)
                .type(VerticalAdapter.ViewType.TYPE_A.ordinal(), R.drawable.shape_decoration_black_h_1)
                .type(VerticalAdapter.ViewType.TYPE_B.ordinal(), R.drawable.shape_decoration_gray_h_1)
                .last(R.drawable.shape_decoration_flush_orange_h_8)
                .build();
        recyclerView.addItemDecoration(decoration);

        recyclerView.setAdapter(new VerticalAdapter(mockData));
    }
}
