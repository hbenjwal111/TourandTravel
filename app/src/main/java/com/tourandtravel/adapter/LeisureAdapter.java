package com.tourandtravel.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tourandtravel.R;
import com.tourandtravel.model.LeisureTimeModel;

import java.util.List;

/**
 * Created by himanshu on 09-11-2017.
 */

public class LeisureAdapter extends RecyclerView.Adapter<LeisureAdapter.MyViewHolder> {
    private Context context;
    private List<LeisureTimeModel> list;

    public static final String IMAGE_URL_BASE_PATH = "http://maestrotravel.co.in/";


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
        private TextView mLeisure;

        public ImageView mImageView;

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTime = (TextView) v.findViewById(R.id.tv_text);
            mTitle = (TextView) v.findViewById(R.id.tv_text1);
            mType = (TextView) v.findViewById(R.id.tv_text2);
            mPrice = (TextView) v.findViewById(R.id.tv_text3);
            mLeisure= (TextView)v.findViewById(R.id.tv_textprime);
            mBook = (TextView) v.findViewById(R.id.choose);
            mImageView = (ImageView) v.findViewById(R.id.image);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public LeisureAdapter(Context context, List<LeisureTimeModel> list) {
        this.context = context;
        this.list = list;
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
    public void onBindViewHolder(LeisureAdapter.MyViewHolder holder, int position) {

        final LeisureTimeModel constant = list.get(position);

        String image_url = IMAGE_URL_BASE_PATH + constant.getHotel_image();


        Picasso.with(context)
                .load(image_url)
                .into(holder.mImageView);

        holder.mTitle.setText(constant.getHotel_name());

        holder.mPrice.setText(constant.getPrice());

        holder.mTime.setText(constant.getLeisure_time_from());

        holder.mLeisure.setText(constant.getLeisure_time_to());

        holder.mType.setText(constant.getType());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

}



