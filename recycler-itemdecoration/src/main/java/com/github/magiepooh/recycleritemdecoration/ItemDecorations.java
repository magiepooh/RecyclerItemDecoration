package com.github.magiepooh.recycleritemdecoration;

import android.content.Context;

/**
 * Created by magiepooh on 2015/08
 */
public class ItemDecorations {

    public static VerticalItemDecoration.Builder vertical(Context context) {
        return new VerticalItemDecoration.Builder(context);
    }

    public static HorizontalItemDecoration.Builder horizontal(Context context) {
        return new HorizontalItemDecoration.Builder(context);
    }
}
