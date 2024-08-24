package com.example.shoppingapp.adapter;

import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.R;
import com.example.shoppingapp.activity.MainActivity;
import com.example.shoppingapp.activity.ShoppingDetailsActivity;
import com.example.shoppingapp.databinding.ProductItemsBinding;
import com.example.shoppingapp.interfaces.ShoppingInterface;
import com.example.shoppingapp.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<ProductModel> l1 = new ArrayList<>();
    List<ProductModel> filterList = new ArrayList<>();
    ShoppingInterface shoppingInterface;

    public ProductAdapter(List<ProductModel> l1,ShoppingInterface shoppingInterface){
        this.l1=l1;
        this.shoppingInterface=shoppingInterface;
    }

    public void search(List<ProductModel> filterList)
    {
        l1=filterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.productItemsBinding.imgProduct.setImageResource(l1.get(position).modelImage);
        holder.productItemsBinding.txtProductName.setText(l1.get(position).modelNames);
        holder.productItemsBinding.txtProductPrice.setText(l1.get(position).modelPrice);
        holder.productItemsBinding.txtOriginalPrice.setText(l1.get(position).modelOriginal);
        holder.productItemsBinding.txtRupees.setText(l1.get(position).modelRupees);
        holder.productItemsBinding.txtOriginalPrice.setPaintFlags(holder.productItemsBinding.txtOriginalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.productItemsBinding.clItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // shoppingInterface.onClick(position);
                Intent intent = new Intent(holder.itemView.getContext(), ShoppingDetailsActivity.class);
                intent.putExtra("image",l1.get(position).modelImage);
                intent.putExtra("product Name",l1.get(position).modelNames);
                intent.putExtra("originalPrice",l1.get(position).modelOriginal);
                intent.putExtra("product Rupees",l1.get(position).modelRupees);
                intent.putExtra("price",l1.get(position).modelPrice);
                intent.putExtra("description",l1.get(position).modelDescription);
                intent.putExtra("product Color",l1.get(position).modelColor);
                intent.putExtra("product Quantity",l1.get(position).qa);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return l1.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        ProductItemsBinding productItemsBinding;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productItemsBinding = ProductItemsBinding.bind(itemView);
        }
    }
}
