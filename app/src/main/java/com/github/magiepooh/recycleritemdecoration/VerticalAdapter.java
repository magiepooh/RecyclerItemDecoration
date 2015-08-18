package com.github.magiepooh.recycleritemdecoration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VerticalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Binder[] mDataSet;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public VerticalAdapter(Binder[] dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (ViewType.TYPE_A.ordinal() == viewType) {
            return new ViewHolderA(inflate(viewGroup, R.layout.row_type_a));
        } else {
            return new ViewHolderB(inflate(viewGroup, R.layout.row_type_b));
        }
    }

    private View inflate(ViewGroup viewGroup, int row_type_a) {
        return LayoutInflater.from(viewGroup.getContext())
                .inflate(row_type_a, viewGroup, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof ViewHolderA) {
            ViewHolderA holder = (ViewHolderA) viewHolder;
            holder.getTextView().setText(mDataSet[position].getText());
        } else {
            ViewHolderB holder = (ViewHolderB) viewHolder;
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
        TYPE_B;
    }

    public interface Binder {

        int getViewType();

        String getText();
    }

    public static class ViewHolderA extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolderA(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.txt_type_a);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public static class ViewHolderB extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolderB(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.txt_type_b);
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

    public static class TypeBObject implements Binder {

        public String mText;

        TypeBObject(String text) {
            mText = text;
        }

        @Override
        public int getViewType() {
            return ViewType.TYPE_B.ordinal();
        }

        @Override
        public String getText() {
            return mText;
        }
    }
}