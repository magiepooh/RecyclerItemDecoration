package com.github.magiepooh.recycleritemdecoration.demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Binder[] mDataSet;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public HorizontalAdapter(Binder[] dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(inflate(viewGroup, R.layout.row_type_a_horizontal));
    }

    private View inflate(ViewGroup viewGroup, int row_type_a) {
        return LayoutInflater.from(viewGroup.getContext())
                .inflate(row_type_a, viewGroup, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof ViewHolder) {
            ViewHolder holder = (ViewHolder) viewHolder;
            holder.getTextView().setText(mDataSet[position].getText());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSet[position].getViewType();
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public enum ViewType {
        TYPE_A,
    }

    public interface Binder {

        int getViewType();

        String getText();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.txt_type_a);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public static class TypeAObject implements Binder {

        private String mText;

        TypeAObject(String text) {
            mText = text;
        }

        @Override
        public int getViewType() {
            return ViewType.TYPE_A.ordinal();
        }

        @Override
        public String getText() {
            return mText;
        }
    }
}