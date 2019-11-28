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
import com.yasser.elsalamwoods.Model.Product;
import com.yasser.elsalamwoods.R;

import java.util.ArrayList;

public class ProductMowaz3RecyclerViewAdapter extends RecyclerView.Adapter<ProductMowaz3RecyclerViewAdapter.ViewHolder> {


    CustomItemClickListener listener;

    private ArrayList<Product> products = new ArrayList<>();

    private Context mContext;

    public ProductMowaz3RecyclerViewAdapter(Context context, ArrayList<Product> products) {

        this.mContext = context;
        this.products = products;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.proudct_row, parent, false);
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
        requestOptions.placeholder(R.drawable.doorfour);
        requestOptions.fitCenter();


        Glide.with(mContext)
                .load(products.get(position).getPrImageURL()).apply(requestOptions)
                .into(holder.image);

        holder.tv_prName.setText(products.get(position).getPrName());

        holder.tv_prDesc.setText("كود المنتج"+products.get(position).getPrType());

        holder.tv_prPrice.setText(products.get(position).getPrPriceMwoza3()+" EGP");

    }

    //Set method of OnItemClickListener object
    public void setOnItemClickListener(CustomItemClickListener recyclerViewItemClickListner) {
        this.listener = recyclerViewItemClickListner;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tv_prName,tv_prPrice,tv_prDesc;
        public int position = 0;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView3);
            tv_prName = itemView.findViewById(R.id.tv_prName);
            tv_prPrice = itemView.findViewById(R.id.textView2);
            tv_prDesc = itemView.findViewById(R.id.tv_desc);
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