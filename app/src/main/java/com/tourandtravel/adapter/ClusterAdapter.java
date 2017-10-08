package com.tourandtravel.adapter;

import android.content.Context;
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
import com.tourandtravel.fragment.ChakrataClusterFragment;
import com.tourandtravel.fragment.ChamoliClusterFragment;
import com.tourandtravel.fragment.DehradunFragment;
import com.tourandtravel.fragment.DhanaultiMussoorieClusterFragment;
import com.tourandtravel.fragment.GangotriClusterFragment;
import com.tourandtravel.fragment.HaridwarClusterFragment;
import com.tourandtravel.fragment.HemkundShahibFragment;
import com.tourandtravel.fragment.KaranprayagClusterFragment;
import com.tourandtravel.fragment.KausaniClusterFragment;
import com.tourandtravel.fragment.KedarnathClusterFragment;
import com.tourandtravel.fragment.LansdownClusterFragment;
import com.tourandtravel.fragment.RudraprayagClusterFragment;
import com.tourandtravel.fragment.TehriClusterFragment;
import com.tourandtravel.fragment.UttarkashiClusterFragment;
import com.tourandtravel.fragment.YamonotriClusterFragment;
import com.tourandtravel.utils.Constant;

import java.util.List;

/**
 * Created by himanshu on 19-09-2017.
 */

public class ClusterAdapter extends RecyclerView.Adapter<ClusterAdapter.MyViewHolder> {
    private Context context;
    private List<Constant> cartList;


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
    public ClusterAdapter(Context context, List<Constant> cartList) {
        this.context = context;
        this.cartList = cartList;
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

          final Constant constant = cartList.get(position);
        holder.mTextView.setText(constant.getTitle());



        holder.textView.setText(constant.getDesc());

        holder.mImageView.setImageResource(constant.getImageId());

        if (position == 0) {



            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    BadrinathClusterFragment myFragment = new BadrinathClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });

        } else if (position == 1) {


            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    GangotriClusterFragment myFragment = new GangotriClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });

        }else if(position == 2){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    YamonotriClusterFragment myFragment = new YamonotriClusterFragment();

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
                    KedarnathClusterFragment myFragment = new KedarnathClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }

        else if(position == 4){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    ChakrataClusterFragment myFragment = new ChakrataClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }

        else if(position == 5){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    KausaniClusterFragment myFragment = new KausaniClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }

        else if(position == 6){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    ChamoliClusterFragment myFragment = new ChamoliClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }

        else if(position == 7){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                DehradunFragment myFragment = new DehradunFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }


        else if(position == 8){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                   DhanaultiMussoorieClusterFragment myFragment = new DhanaultiMussoorieClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }


        else if(position == 9){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                   HaridwarClusterFragment myFragment = new HaridwarClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }


        else if(position == 10){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                   HemkundShahibFragment myFragment = new HemkundShahibFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }


        else if(position == 11){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    KaranprayagClusterFragment myFragment = new KaranprayagClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }


        else if(position == 12){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    LansdownClusterFragment myFragment = new LansdownClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }


        else if(position == 13){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    RudraprayagClusterFragment myFragment = new RudraprayagClusterFragment();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }

        else if(position == 14){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    TehriClusterFragment myFragment = new TehriClusterFragment ();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }

        else if(position == 15){

            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    UttarkashiClusterFragment myFragment = new UttarkashiClusterFragment ();

                    //Create a bundle to pass data, add data, set the bundle to your fragment and:
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();


                }
            });



        }


    }


    @Override
    public int getItemCount() {
        return cartList.size();
    }




        }



