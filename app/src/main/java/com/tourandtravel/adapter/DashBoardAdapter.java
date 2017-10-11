package com.tourandtravel.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tourandtravel.R;
import com.tourandtravel.fragment.HomeFragment;
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

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.card_view);

            mImageView = (ImageView)v.findViewById(R.id.imageView);
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

        if (position == 0) {



            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                   HomeFragment myFragment = new HomeFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });

        } else if (position == 1) {


            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                  HomeFragment myFragment = new HomeFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });

        }else if(position == 2){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    HomeFragment myFragment = new HomeFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }

        else if(position == 3){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                   HomeFragment myFragment = new HomeFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }



        }





    @Override
    public int getItemCount() {
        return listItem.size();
    }




}



