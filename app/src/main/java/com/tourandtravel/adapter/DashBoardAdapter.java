package com.tourandtravel.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tourandtravel.R;
import com.tourandtravel.fragment.HomeFragment;

/**
 * Created by himanshu on 4/15/2017.
 */




    public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.ViewHolder>{

        private String[] mDataSet;

    Animation animation;


        private Context mContext;

    private final static int FADE_DURATION = 1000;




        public DashBoardAdapter(Context context, String[] DataSet ){
            mDataSet = DataSet;
            mContext = context;


        }



        public  class ViewHolder extends RecyclerView.ViewHolder{
            //   public ImageView mImageView;
            // public TextView nTextView;
            public ImageView mImageView;
            public TextView mTextView;
            public CardView mCardView;

            // public LinearLayout nLinearLayout;
            public LinearLayout mLinearLayout;
            public ViewHolder(View v){
                super(v);
                // mImageView =(ImageView) v.findViewById(R.id.country_photo) ;
               mImageView =(ImageView)v.findViewById(R.id.imageView);

                mTextView = (TextView) v.findViewById(R.id.tv);
                mLinearLayout = (LinearLayout) v.findViewById(R.id.ll);
                mCardView =(CardView)v.findViewById(R.id.card_view);
                // nTextView =(TextView)v.findViewById(R.id.tvv);
                // nLinearLayout =(LinearLayout)v.findViewById(R.id.lll);
            }
        }






        @Override
        public DashBoardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int position){
            // Create a new View
            View v = LayoutInflater.from(mContext).inflate(R.layout.dashboard_view,parent,false);
            ViewHolder vh = new ViewHolder(v);
            // return new AnimalsAdapter.ViewHolder(itemView,this);
            return vh;




        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position){


            holder.mTextView.setText(mDataSet[position]);






            if(position == 0){
            holder.mImageView.setImageResource(R.drawable.education);
                holder.mLinearLayout.setBackgroundColor(Color.parseColor("#54c7fc"));
              /*  holder.mTextView.setTextColor(Color.parseColor("#ffffff"));*/

                holder.mCardView.getLayoutParams().height=300;

               /* holder.mTextView.setAnimation(animation);

                AnimationUtils.loadAnimation(mContext,
                        R.anim.zoom_in);
*/



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
            else if(position == 1){
                holder.mLinearLayout.setBackgroundColor(Color.parseColor("#54c7fc"));
/*
                holder.mTextView.setTextColor(Color.parseColor("#000"));
*/
          holder.mImageView.setImageResource(R.drawable.education);
                holder.mCardView.getLayoutParams().height=300;




            }else if(position == 2){
                holder.mLinearLayout.setBackgroundColor(Color.parseColor("#54c7fc"));

                holder.mCardView.getLayoutParams().height=300;
                holder.mImageView.setImageResource(R.drawable.corporate);


              /*  holder.mCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AppCompatActivity activity = (AppCompatActivity) v.getContext();
                      Circular myFragment = new Circular();
                        //Create a bundle to pass data, add data, set the bundle to your fragment and:
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();



                    }
                });*/
/*
                holder.mTextView.setTextColor(Color.parseColor("#000"));
*/

            }else if(position == 3){
                holder.mLinearLayout.setBackgroundColor(Color.parseColor("#54c7fc"));
                holder.mCardView.getLayoutParams().height=300;
                holder.mImageView.setImageResource(R.drawable.leisure);



/*
                holder.mTextView.setTextColor(Color.parseColor("#000"));
*/


            }else if(position ==4) {
                holder.mLinearLayout.setBackgroundColor(Color.parseColor("#54c7fc"));
                holder.mCardView.getLayoutParams().height = 300;
                holder.mImageView.setImageResource(R.drawable.wellness);


               /* holder.mCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AppCompatActivity activity = (AppCompatActivity) v.getContext();
                      NotificationFragment myFragment = new NotificationFragment();
                        //Create a bundle to pass data, add data, set the bundle to your fragment and:
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, myFragment).addToBackStack(null).commit();



                    }
                });*/
/*
                holder.mTextView.setTextColor(Color.parseColor("#000"));
*/


            }
            else if(position == 5) {
                holder.mLinearLayout.setBackgroundColor(Color.parseColor("#54c7fc"));
              /*  holder.mTextView.setTextColor(Color.parseColor("#000000"));*/

                holder.mCardView.getLayoutParams().height=130;

            }

           /* setFadeAnimation(holder.itemView);*/
        }


   /* private void setFadeAnimation(View view) {
        Animation anim = AnimationUtils.loadAnimation(mContext,
                R.anim.zoom_in);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }*/







        @Override
        public int getItemCount(){
            return mDataSet.length  ;

        }




    }




