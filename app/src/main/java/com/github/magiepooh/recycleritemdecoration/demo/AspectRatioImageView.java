package com.github.magiepooh.recycleritemdecoration.demo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class AspectRatioImageView extends ImageView {

    private float aspectRatio;
    private Object priorityDimension;

    public AspectRatioImageView(Context context) {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView));
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView));
    }

    private void init(TypedArray attrs) {
        if (attrs == null) {
            return;
        }
        aspectRatio = attrs.getFloat(R.styleable.AspectRatioImageView_aspectRatio, 0f);
        priorityDimension = PriorityDimension.values()[(attrs
                .getInt(R.styleable.AspectRatioImageView_priority,
                        PriorityDimension.WIDTH.ordinal()))];
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (aspectRatio != 0f) {
            int w;
            int h;
            if (priorityDimension == PriorityDimension.WIDTH) {
                int width = View.MeasureSpec.getSize(widthMeasureSpec);
                w = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
                h = View.MeasureSpec.makeMeasureSpec((int) (width / aspectRatio),
                        View.MeasureSpec.EXACTLY);
            } else {
                int height = View.MeasureSpec.getSize(heightMeasureSpec);

                h = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
                w = View.MeasureSpec.makeMeasureSpec((int) (height * aspectRatio),
                        View.MeasureSpec.EXACTLY);
            }
            super.onMeasure(w, h);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public enum PriorityDimension {
        WIDTH,
        HEIGHT
    }
}
