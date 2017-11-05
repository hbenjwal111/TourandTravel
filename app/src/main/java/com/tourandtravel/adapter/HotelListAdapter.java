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

import com.squareup.picasso.Picasso;
import com.tourandtravel.R;
import com.tourandtravel.activity.CommonBaseActivity;
import com.tourandtravel.model.CommonHotelModel;

import java.util.List;

/**
 * Created by himanshu on 29-10-2017.
 */

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.MyViewHolder> {
private Context context;
private List<CommonHotelModel> hotelLists;

    public static final String IMAGE_URL_BASE_PATH = "http://maestrotravel.co.in/";



// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and

// you provide access to all the views for a data item in a view holder
public static class MyViewHolder extends RecyclerView.ViewHolder {
    private CardView mCardView;
    private TextView mTextView;
    private TextView textView;
    private ImageView mImageView;
    private TextView chooseRoom;

    public MyViewHolder(View v) {
        super(v);

        mCardView = (CardView) v.findViewById(R.id.card_view);
        mTextView = (TextView) v.findViewById(R.id.tv_text);
        textView = (TextView)v.findViewById(R.id.tv_text1);
        mImageView = (ImageView)v.findViewById(R.id.image);
        chooseRoom =(TextView)v.findViewById(R.id.choose);
        chooseRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent commonActivity = new Intent(v.getContext(),CommonBaseActivity.class);
                commonActivity.putExtra("flowType", CommonBaseActivity.ROOM);
                v.getContext().startActivity(commonActivity);


            }
        });


    }
}

    // Provide a suitable constructor (depends on the kind of dataset)
    public HotelListAdapter(Context context, List<CommonHotelModel> hotelLists) {
        this.context = context;
        this.hotelLists = hotelLists;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_common_hotel, parent, false);
        // set the view's size, margins, paddings and layout parameters
       /* ClusterAdapter.MyViewHolder vh = new ClusterAdapter.MyViewHolder(v);*/
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HotelListAdapter.MyViewHolder holder, int position) {

        final CommonHotelModel constant = hotelLists.get(position);
        String image_url = IMAGE_URL_BASE_PATH + constant.getHotel_image();

        Picasso.with(context)
                .load(image_url)
                .into(holder.mImageView);
        holder.mTextView.setText(constant.getName());




        holder.textView.setText(constant.getDistrict());








    }


    @Override
    public int getItemCount() {
        return hotelLists.size();
    }




}




