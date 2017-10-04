package com.tourandtravel.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tourandtravel.R;
import com.tourandtravel.fragment.BadrinathClusterFragment;

/**
 * Created by himanshu on 19-09-2017.
 */

public class ClusterAdapter extends RecyclerView.Adapter<ClusterAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and

    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mTextView;
        public ImageView mImageView;

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);
            mTextView = (TextView) v.findViewById(R.id.tv_text);
            mImageView = (ImageView)v.findViewById(R.id.image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ClusterAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ClusterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cluster, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ClusterAdapter.MyViewHolder vh = new ClusterAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ClusterAdapter.MyViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);

        if (position == 0) {
           /* holder.mImageView.setImageResource(R.drawable.education);*/
          /*  holder.mLinearLayout.setBackgroundColor(Color.parseColor("#54c7fc"));*/
              /*  holder.mTextView.setTextColor(Color.parseColor("#ffffff"));*/

         /* *//*  holder.mCardView.getLayoutParams().height =*//* 300;*/

               /* holder.mTextView.setAnimation(animation);

                AnimationUtils.loadAnimation(mContext,
                        R.anim.zoom_in);

*/


            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    BadrinathClusterFragment myFragment = new BadrinathClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });

        }
    }


            @Override
            public int getItemCount(){
                return mDataset.length  ;

            }




        }



