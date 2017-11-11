package com.tourandtravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tourandtravel.R;
import com.tourandtravel.model.CommonModel;

import java.util.List;

/**
 * Created by himanshu on 29-10-2017.
 */

public class CommonAdapter  extends RecyclerView.Adapter<CommonAdapter.MyViewHolder> {
    private Context context;
    private List<CommonModel> commonModels;

    public static final String IMAGE_URL_BASE_PATH = "http://maestrotravel.co.in/";


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and

    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public TextView titleCluster;

        public ImageView mImageView;



        public MyViewHolder(View v) {
            super(v);

            titleCluster = (TextView)v.findViewById(R.id.about);
            mTextView = (TextView) v.findViewById(R.id.tv_text1);
            mImageView = (ImageView)v.findViewById(R.id.place_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CommonAdapter(Context context, List<CommonModel> commonModels) {
        this.context = context;
        this.commonModels = commonModels;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_common, parent, false);
        // set the view's size, margins, paddings and layout parameters
       /* ClusterAdapter.MyViewHolder vh = new ClusterAdapter.MyViewHolder(v);*/
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CommonAdapter.MyViewHolder holder, int position) {

        final CommonModel custers = commonModels.get(position);

        String image_url = IMAGE_URL_BASE_PATH + custers.getClusImage();

        Picasso.with(context)
                .load(image_url)
                .into(holder.mImageView);

        holder.titleCluster.setText(custers.getClusTitle());




        holder.mTextView.setText(custers.getClus_about());





    }


    @Override
    public int getItemCount() {
        return commonModels.size();
    }




}



