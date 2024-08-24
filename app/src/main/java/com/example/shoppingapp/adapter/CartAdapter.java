package com.example.shoppingapp.adapter;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.R;
import com.example.shoppingapp.databinding.CartItemBinding;
import com.example.shoppingapp.interfaces.ShoppingInterface;
import com.example.shoppingapp.model.ProductModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    List<ProductModel> l2;
    ShoppingInterface shoppingInterface;
    public CartAdapter(List<ProductModel> l2, ShoppingInterface shoppingInterface) {
        this.l2 = l2;
        this.shoppingInterface = shoppingInterface;
    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ProductModel product = l2.get(position);

        holder.cartItemBinding.imgCartProduct.setImageResource(product.modelImage);
        holder.cartItemBinding.txtProduct.setText(product.modelNames);
        holder.cartItemBinding.txtCartPrice.setText(product.modelOriginal);
        holder.cartItemBinding.txtDisCartPrice.setText("₹" + product.modelPrice);
        holder.cartItemBinding.txtCartPrice.setPaintFlags(holder.cartItemBinding.txtCartPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.cartItemBinding.txtCount.setText(String.valueOf(product.qa));

        holder.cartItemBinding.txtDeleteCart.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                l2.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
                shoppingInterface.onCartUpdated();
                if (getItemCount() == 0) {
                    Toast.makeText(v.getContext(), "Your Shopsy Cart is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.cartItemBinding.txtPlus.setOnClickListener(v -> {
            int newCount = Integer.parseInt(holder.cartItemBinding.txtCount.getText().toString()) + 1;
            holder.cartItemBinding.txtCount.setText(""+newCount);
        });

        holder.cartItemBinding.txtminus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                int newCount = Integer.parseInt(holder.cartItemBinding.txtCount.getText().toString()) - 1;
                holder.cartItemBinding.txtCount.setText(""+newCount);
                if (newCount == 0) {
                    l2.remove(position);
                    notifyItemRemoved(position);
                    notifyDataSetChanged();
                    if (getItemCount() == 0) {
                        Toast.makeText(v.getContext(), "Your Shopsy Cart is empty", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return l2.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public CartItemBinding cartItemBinding;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartItemBinding = CartItemBinding.bind(itemView);
        }
    }
}
