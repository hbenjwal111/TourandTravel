package com.tourandtravel.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tourandtravel.R;

/**
 * Created by himanshu on 21-09-2017.
 */

public class ActivitiesAdapter

        extends RecyclerView.Adapter<ActivitiesAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and

    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mTextView;

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.tv_text);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ActivitiesAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ActivitiesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activities, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ActivitiesAdapter.MyViewHolder vh = new ActivitiesAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ActivitiesAdapter.MyViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    {
    }

}
