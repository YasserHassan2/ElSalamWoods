package com.yasser.elsalamwoods.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yasser.elsalamwoods.Model.offer;
import com.yasser.elsalamwoods.R;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {


    CustomItemClickListener listener;

    private ArrayList<offer> categories = new ArrayList<>();

    private Context mContext;

    public OfferAdapter(Context context, ArrayList<offer> categories) {

        this.mContext = context;
        this.categories = categories;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_row, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getPosition());

            }
        });


        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.logohere);
        requestOptions.fitCenter();


        Glide.with(mContext)
                .load(categories.get(position).getOffer_imageURL()).apply(requestOptions)
                .into(holder.image);

        holder.tv_offerTitle.setText(categories.get(position).getOffer_title());

        holder.tv_offerDesc.setText(categories.get(position).getOffer_desc());

        holder.tv_offerEnddate.setText("ينتهى فى " +categories.get(position).getOffer_enddate());

    }

    //Set method of OnItemClickListener object
    public void setOnItemClickListener(CustomItemClickListener recyclerViewItemClickListner) {
        this.listener = recyclerViewItemClickListner;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tv_offerTitle, tv_offerDesc, tv_offerEnddate;
        public int position = 0;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_offerImage);
            tv_offerTitle = itemView.findViewById(R.id.tv_offer_title);
            tv_offerDesc = itemView.findViewById(R.id.tv_offer_desc);
            tv_offerEnddate = itemView.findViewById(R.id.tv_offer_enddate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //When item view is clicked, trigger the itemclicklistener
                    //Because that itemclicklistener is indicated in MainActivity
                    listener.onItemClick(v, position);
                }
            });
        }
    }
}