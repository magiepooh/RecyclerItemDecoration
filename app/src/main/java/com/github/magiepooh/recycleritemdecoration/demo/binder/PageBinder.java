package com.github.magiepooh.recycleritemdecoration.demo.binder;

import com.github.magiepooh.recycleritemdecoration.demo.AspectRatioImageView;
import com.github.magiepooh.recycleritemdecoration.demo.DemoViewType;
import com.github.magiepooh.recycleritemdecoration.demo.R;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import jp.satorufujiwara.binder.recycler.RecyclerBinder;

public class PageBinder extends RecyclerBinder<DemoViewType> {

    @DrawableRes
    private final int mResId;

    public PageBinder(Activity activity, @DrawableRes int resId) {
        super(activity, DemoViewType.PAGE);
        mResId = resId;
    }

    @Override
    public int layoutResId() {
        return R.layout.row_page;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.mImageView.setImageResource(mResId);
    }

    private static final class ViewHolder extends RecyclerView.ViewHolder {

        private final AspectRatioImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (AspectRatioImageView) itemView.findViewById(R.id.img_page);
        }
    }
}
