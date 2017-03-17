package com.sourcerebels.swiperefreshprogressview.demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewHolder> {

    private final List<String> items = Arrays.asList("item 1", "item 2", "item 3", "item 4",
            "item 5", "item 6", "item 7", "item 8", "item 9", "item 10", "item 11", "item 12",
            "item 13", "item 14", "item 15", "item 16", "item 17", "item 18", "item 19", "item 20");

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MyRecyclerViewHolder(
                inflater.inflate(R.layout.adapter_my_recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        MyRecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_view);
        }

        void bind(String item) {
            title.setText(item);
        }
    }
}
