package com.github.magiepooh.recycleritemdecoration.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.github.magiepooh.recycleritemdecoration.demo.binder.PageBinder;
import java.util.ArrayList;
import java.util.List;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;
import jp.satorufujiwara.binder.recycler.RecyclerBinderAdapter;

/**
 * Created by magiepooh on 2015/08
 */
public class HorizontalActivity extends AppCompatActivity {

  public static void startActivity(Activity activity) {
    activity.startActivity(new Intent(activity, HorizontalActivity.class));
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_horizontal);

    // create ItemDecoration
    RecyclerView.ItemDecoration decoration = ItemDecorations.horizontal(this)
        .first(R.drawable.shape_decoration_green_w_8)
        .type(DemoViewType.PAGE.ordinal(), R.drawable.shape_decoration_red_w_8)
        .last(R.drawable.shape_decoration_flush_orange_w_8)
        .create();

    // normal
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_horizontal);
    recyclerView.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    RecyclerBinderAdapter<DemoSectionType, DemoViewType> normalAdapter = initAdapter();
    recyclerView.setAdapter(normalAdapter);
    recyclerView.addItemDecoration(decoration);

    // reverse
    RecyclerView reverseRecyclerView =
        (RecyclerView) findViewById(R.id.recycler_horizontal_reverse);
    reverseRecyclerView.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
    RecyclerBinderAdapter<DemoSectionType, DemoViewType> reverseAdapter = initAdapter();
    reverseRecyclerView.setAdapter(reverseAdapter);
    reverseRecyclerView.addItemDecoration(decoration);
  }

  @NonNull private RecyclerBinderAdapter<DemoSectionType, DemoViewType> initAdapter() {
    RecyclerBinderAdapter<DemoSectionType, DemoViewType> adapter = new RecyclerBinderAdapter<>();
    List<RecyclerBinder<DemoViewType>> demoBinderList = new ArrayList<>();
    demoBinderList.add(new PageBinder(this, R.drawable.demo0_1));
    demoBinderList.add(new PageBinder(this, R.drawable.demo0_2));
    demoBinderList.add(new PageBinder(this, R.drawable.demo0_3));
    demoBinderList.add(new PageBinder(this, R.drawable.demo0_4));
    demoBinderList.add(new PageBinder(this, R.drawable.demo1_1));
    demoBinderList.add(new PageBinder(this, R.drawable.demo1_2));
    demoBinderList.add(new PageBinder(this, R.drawable.demo1_3));
    demoBinderList.add(new PageBinder(this, R.drawable.demo1_4));
    for (RecyclerBinder<DemoViewType> binder : demoBinderList) {
      adapter.add(DemoSectionType.ITEM, binder);
    }
    return adapter;
  }
}
