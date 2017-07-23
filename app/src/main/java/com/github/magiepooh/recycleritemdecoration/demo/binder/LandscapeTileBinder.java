package com.github.magiepooh.recycleritemdecoration.demo.binder;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.github.magiepooh.recycleritemdecoration.demo.DemoViewType;
import com.github.magiepooh.recycleritemdecoration.demo.R;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;

public class LandscapeTileBinder extends RecyclerBinder<DemoViewType> {

  private final int mLeftResId;
  private final int mRightResId;

  public LandscapeTileBinder(Activity activity, @DrawableRes int leftResId,
      @DrawableRes int rightResId) {
    super(activity, DemoViewType.LANDSCAPE_TILE);
    mLeftResId = leftResId;
    mRightResId = rightResId;
  }

  @Override public int layoutResId() {
    return R.layout.row_landscape_tile;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(View v) {
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
    ViewHolder holder = (ViewHolder) viewHolder;
    holder.mLeftImageView.setImageResource(mLeftResId);
    holder.mRightImageView.setImageResource(mRightResId);
  }

  private static final class ViewHolder extends RecyclerView.ViewHolder {

    private final ImageView mLeftImageView;
    private final ImageView mRightImageView;

    public ViewHolder(View itemView) {
      super(itemView);
      mLeftImageView = (ImageView) itemView.findViewById(R.id.img_row_landscape_left);
      mRightImageView = (ImageView) itemView.findViewById(R.id.img_row_landscape_right);
    }
  }
}
