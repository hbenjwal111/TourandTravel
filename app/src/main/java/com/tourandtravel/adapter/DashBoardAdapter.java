package com.tourandtravel.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tourandtravel.R;
import com.tourandtravel.utils.ItemList;

import java.util.List;

/**
 * Created by himanshu on 4/15/2017.
 */




    public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.MyViewHolder> {
    private Context context;
    private List<ItemList> listItem;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and

    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;

        public ImageView mImageView;
        public TextView mTextView;

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);

            mImageView = (ImageView)v.findViewById(R.id.imageView);
            mTextView = (TextView)v.findViewById(R.id.mTextView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public DashBoardAdapter(Context context, List<ItemList> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
       /* ClusterAdapter.MyViewHolder vh = new ClusterAdapter.MyViewHolder(v);*/
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DashBoardAdapter.MyViewHolder holder, int position) {

        final ItemList constant = listItem.get(position);

        holder.mImageView.setImageResource(constant.getImageId());

        holder.mTextView.setText(constant.getTitle());






    }





    @Override
    public int getItemCount() {
        return listItem.size();
    }




}



