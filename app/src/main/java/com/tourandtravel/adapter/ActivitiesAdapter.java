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
import com.tourandtravel.model.ActivitiesModel;

import java.util.List;

/**
 * Created by himanshu on 21-09-2017.
 */

public class ActivitiesAdapter

        extends RecyclerView.Adapter<ActivitiesAdapter.MyViewHolder> {
    private Context context;
    private List<ActivitiesModel> activitiesModels;

    public int activity_id;

    public static final String IMAGE_URL_BASE_PATH = "http://maestrotravel.co.in/";

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and

    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mTextView;
        public TextView textView;
        public ImageView mImageView;

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.tv_text);
            textView = (TextView)v.findViewById(R.id.tv_text1);
            mImageView = (ImageView)v.findViewById(R.id.image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ActivitiesAdapter(Context context, List<ActivitiesModel> activitiesModels) {
        this.context = context;
        this.activitiesModels = activitiesModels;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activities, parent, false);
        // set the view's size, margins, paddings and layout parameters
       /* ClusterAdapter.MyViewHolder vh = new ClusterAdapter.MyViewHolder(v);*/
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ActivitiesAdapter.MyViewHolder holder, int position) {

        final ActivitiesModel constant = activitiesModels.get(position);
        String image_url = IMAGE_URL_BASE_PATH + constant.getImage();


        Picasso.with(context)
                .load(image_url)
                .into(holder.mImageView);
        holder.mTextView.setText(constant.getName());
        holder.textView.setText(constant.getAbout());












    }


    @Override
    public int getItemCount() {
        return activitiesModels.size();
    }




}

