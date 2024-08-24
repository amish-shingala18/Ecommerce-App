package com.example.shoppingapp.activity;

import static com.example.shoppingapp.activity.MainActivity.listCart;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shoppingapp.adapter.CartAdapter;
import com.example.shoppingapp.databinding.ActivityAddtoCartBinding;
import com.example.shoppingapp.interfaces.ShoppingInterface;
import com.example.shoppingapp.model.ProductModel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AddtoCartActivity extends AppCompatActivity {

    ActivityAddtoCartBinding binding;

    ShoppingInterface shoppingInterface;
    int sum =0;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddtoCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        shoppingInterface = new ShoppingInterface() {
            String originalAmount = binding.txtOriAmount.getText().toString();
            String totalAmount = binding.txtAmount.getText().toString();
            @Override
            public void onClick() {
                Intent intent = new Intent(AddtoCartActivity.this,CartAdapter.class);
                intent.putExtra("OriginalAmount",originalAmount);
                intent.putExtra("Amount",totalAmount);
                startActivity(intent);
            }
            @Override
            public void onCartUpdated() {
                getDisAdd();
                getDepAdd();
            }
        };
        CartAdapter cartAdapter = new CartAdapter(listCart,shoppingInterface);
        binding.rvCart.setAdapter(cartAdapter);

        binding.imgCartBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(cartAdapter.getItemCount()==0)
        {
            Toast.makeText(this, "Your Shopsy Cart is empty", Toast.LENGTH_SHORT).show();
        }
        getDisAdd();
        getDepAdd();
    }
    void getDisAdd() {
        for(i=0;i<listCart.size();i++)
        {
            sum = sum+(Integer.parseInt(listCart.get(i).modelPrice.replaceAll(",", ""))*listCart.get(i).qa);

        }
        binding.txtAmount.setText("₹"+sum);
    }

    void getDepAdd()
    {
        for (i=0;i<listCart.size();i++)
        {
            sum = sum+(Integer.parseInt(listCart.get(i).modelOriginal.replaceAll(",", ""))*listCart.get(i).qa);
        }
        binding.txtOriAmount.setText("₹"+sum);
        binding.txtOriAmount.setPaintFlags(binding.txtOriAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}