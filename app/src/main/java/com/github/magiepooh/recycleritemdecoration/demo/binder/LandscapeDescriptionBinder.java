package com.github.magiepooh.recycleritemdecoration.demo.binder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.github.magiepooh.recycleritemdecoration.demo.DemoViewType;
import com.github.magiepooh.recycleritemdecoration.demo.R;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;

public class LandscapeDescriptionBinder extends RecyclerBinder<DemoViewType> {

  private final String mText;

  public LandscapeDescriptionBinder(Activity activity, String text) {
    super(activity, DemoViewType.LANDSCAPE_DESCRIPTION);
    mText = text;
  }

  @Override public int layoutResId() {
    return R.layout.row_landscape_description;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(View v) {
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
    ViewHolder holder = (ViewHolder) viewHolder;
    holder.mTextView.setText(mText);
  }

  private static final class ViewHolder extends RecyclerView.ViewHolder {

    private final TextView mTextView;

    public ViewHolder(View itemView) {
      super(itemView);
      mTextView = (TextView) itemView.findViewById(R.id.txt_landscape_description);
    }
  }
}
