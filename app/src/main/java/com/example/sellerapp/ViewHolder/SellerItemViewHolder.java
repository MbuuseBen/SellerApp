package com.example.sellerapp.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sellerapp.Interface.ItemClickListner;
import com.example.sellerapp.R;


public class SellerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductName, txtProductDescription, txtProductPrice, txtProductStatus;
    public ImageView imageView,deleteBtn,editBtn;
    public ItemClickListner listner;


    public SellerItemViewHolder(View itemView)
    {
        super(itemView);


        imageView = (ImageView) itemView.findViewById(R.id.product_seller_image);
        txtProductName = (TextView) itemView.findViewById(R.id.product_seller_name);
        txtProductDescription = (TextView) itemView.findViewById(R.id.product_seller_description);
        txtProductPrice = (TextView) itemView.findViewById(R.id.product_seller_price);
        txtProductStatus = (TextView) itemView.findViewById(R.id.product_status);
        deleteBtn = (ImageView) itemView.findViewById(R.id.deleteBtn2);
        editBtn = (ImageView) itemView.findViewById(R.id.edit_item);
    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }

    @Override
    public void onClick(View view)
    {
        listner.onClick(view, getAdapterPosition(), false);
    }
}
