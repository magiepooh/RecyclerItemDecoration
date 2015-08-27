package com.github.magiepooh.recycleritemdecoration.demo;

import com.github.magiepooh.recycleritemdecoration.HorizontalItemDecoration;
import com.github.magiepooh.recycleritemdecoration.demo.binder.PageBinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jp.satorufujiwara.binder.recycler.RecyclerBinder;
import jp.satorufujiwara.binder.recycler.RecyclerBinderAdapter;

/**
 * Created by magiepooh on 2015/08/17.
 */
public class HorizontalActivity extends AppCompatActivity {

    public static void startActivity(Activity activity) {
        activity.startActivity(new Intent(activity, HorizontalActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);

        // create ItemDecoration
        RecyclerView.ItemDecoration decoration = new HorizontalItemDecoration.Builder(this)
                .first(R.drawable.shape_decoration_sea_blue_w_8)
                .type(DemoViewType.PAGE.ordinal(), R.drawable.shape_decoration_black_w_4)
                .last(R.drawable.shape_decoration_flush_orange_w_8)
                .build();

        // normal
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_horizontal);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        RecyclerBinderAdapter<DemoSectionType, DemoViewType> normalAdapter = initAdapter();
        recyclerView.setAdapter(normalAdapter);
        recyclerView.addItemDecoration(decoration);

        // reverse
        RecyclerView reverseRecyclerView = (RecyclerView) findViewById(
                R.id.recycler_horizontal_reverse);
        reverseRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        RecyclerBinderAdapter<DemoSectionType, DemoViewType> reverseAdapter = initAdapter();
        reverseRecyclerView.setAdapter(reverseAdapter);
        reverseRecyclerView.addItemDecoration(decoration);
    }

    @NonNull
    private RecyclerBinderAdapter<DemoSectionType, DemoViewType> initAdapter() {
        RecyclerBinderAdapter<DemoSectionType, DemoViewType> adapter
                = new RecyclerBinderAdapter<>();
        List<RecyclerBinder<DemoViewType>> demoBinderList = new ArrayList<>();
        demoBinderList.add(new PageBinder(this, R.drawable.demo_pisa_01));
        demoBinderList.add(new PageBinder(this, R.drawable.demo_pisa_02));
        demoBinderList.add(new PageBinder(this, R.drawable.demo_pisa_03));
        demoBinderList.add(new PageBinder(this, R.drawable.demo_pisa_04));
        demoBinderList.add(new PageBinder(this, R.drawable.demo_venice_01));
        demoBinderList.add(new PageBinder(this, R.drawable.demo_venice_02));
        demoBinderList.add(new PageBinder(this, R.drawable.demo_venice_03));
        for (RecyclerBinder<DemoViewType> binder : demoBinderList) {
            adapter.add(DemoSectionType.ITEM, binder);
        }
        return adapter;
    }

}
