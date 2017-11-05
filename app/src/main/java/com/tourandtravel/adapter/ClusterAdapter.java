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
import com.tourandtravel.model.ClusterModel;

import java.util.List;

/**
 * Created by himanshu on 19-09-2017.
 */

public class ClusterAdapter extends RecyclerView.Adapter<ClusterAdapter.MyViewHolder> {
    private Context context;
    private List<ClusterModel> clusterModels;

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
    public ClusterAdapter(Context context, List<ClusterModel> clusterModels) {
        this.context = context;
        this.clusterModels = clusterModels;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cluster, parent, false);
        // set the view's size, margins, paddings and layout parameters
       /* ClusterAdapter.MyViewHolder vh = new ClusterAdapter.MyViewHolder(v);*/
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClusterAdapter.MyViewHolder holder, int position) {

          final ClusterModel constant = clusterModels.get(position);

        String image_url = IMAGE_URL_BASE_PATH + constant.getClusImage();

        Picasso.with(context)
                .load(image_url)
                .into(holder.mImageView);
        holder.mTextView.setText(constant.getClusTitle());




        holder.textView.setText(constant.getClusDiscription());








    }


    @Override
    public int getItemCount() {
        return clusterModels.size();
    }




        }



