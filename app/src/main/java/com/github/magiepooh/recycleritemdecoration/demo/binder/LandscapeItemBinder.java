package com.github.magiepooh.recycleritemdecoration.demo.binder;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.magiepooh.recycleritemdecoration.demo.DemoViewType;
import com.github.magiepooh.recycleritemdecoration.demo.R;
import jp.satorufujiwara.binder.recycler.RecyclerBinder;

public class LandscapeItemBinder extends RecyclerBinder<DemoViewType> {

  @DrawableRes private final int mResId;
  private final String mText;

  public LandscapeItemBinder(Activity activity, @DrawableRes int resId, String text) {
    super(activity, DemoViewType.LANDSCAPE_ITEM);
    mResId = resId;
    mText = text;
  }

  @Override public int layoutResId() {
    return R.layout.row_landscape_item;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(View v) {
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
    ViewHolder holder = (ViewHolder) viewHolder;
    holder.mImageView.setImageResource(mResId);
    holder.mTextView.setText(mText);
  }

  private static final class ViewHolder extends RecyclerView.ViewHolder {

    private final ImageView mImageView;
    private final TextView mTextView;

    public ViewHolder(View itemView) {
      super(itemView);
      mImageView = (ImageView) itemView.findViewById(R.id.img_landscape_item);
      mTextView = (TextView) itemView.findViewById(R.id.txt_landscape_item);
    }
  }
}
