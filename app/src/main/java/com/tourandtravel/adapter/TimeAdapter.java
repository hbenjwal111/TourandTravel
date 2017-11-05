package com.tourandtravel.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tourandtravel.R;
import com.tourandtravel.activity.CommonBaseActivity;
import com.tourandtravel.utils.room;

import java.util.List;

/**
 * Created by himanshu on 01-11-2017.
 */

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.MyViewHolder> {
    private Context context;
    private List<room> roomList;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and

    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        private TextView mTime;
        private TextView mTitle;
        private TextView mType;
        private TextView mPrice;
        private TextView mBook;

        public ImageView mImageView;

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTime =(TextView)v.findViewById(R.id.tv_text);
            mTitle =(TextView)v.findViewById(R.id.tv_text1);
            mType =(TextView)v.findViewById(R.id.tv_text2);
            mPrice =(TextView)v.findViewById(R.id.tv_text3);
           mBook =(TextView)v.findViewById(R.id.choose);
            mImageView = (ImageView)v.findViewById(R.id.image);

            mBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent commonActivity = new Intent(v.getContext(),CommonBaseActivity.class);
                    commonActivity.putExtra("flowType", CommonBaseActivity.BOOK);
                    v.getContext().startActivity(commonActivity);

                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TimeAdapter(Context context, List<room> roomList) {
        this.context = context;
        this.roomList = roomList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_time, parent, false);
        // set the view's size, margins, paddings and layout parameters
       /* ClusterAdapter.MyViewHolder vh = new ClusterAdapter.MyViewHolder(v);*/
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TimeAdapter.MyViewHolder holder, int position) {

        final room constant = roomList.get(position);
        holder.mTime.setText(constant.getTime());
        holder.mTitle.setText(constant.getTitle());
       holder.mType.setText(constant.getType());
        holder.mPrice.setText(constant.getPrice());



        holder.mImageView.setImageResource(constant.getImageId());






    }


    @Override
    public int getItemCount() {
        return roomList.size();
    }




}



