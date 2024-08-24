package com.example.shoppingapp.activity;

import static android.content.Intent.getIntent;
import static com.example.shoppingapp.activity.MainActivity.listCart;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shoppingapp.R;
import com.example.shoppingapp.databinding.ActivityShoppingDetailsBinding;
import com.example.shoppingapp.model.ProductModel;

public class ShoppingDetailsActivity extends AppCompatActivity {

    ActivityShoppingDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoppingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int intPhoto = intent.getIntExtra("image", 0);
        String intOriginalPrice = intent.getStringExtra("originalPrice");
        String intMrp = intent.getStringExtra("price");
        String intDes = intent.getStringExtra("description");
        String intName = intent.getStringExtra("product Name");
        String intColor = intent.getStringExtra("product Color");
        int intQuantity = intent.getIntExtra("product Quantity",0);
        String intRupees = intent.getStringExtra("product Rupees");

        Log.e("TAG",""+intQuantity);

        binding.imgSelectProduct.setImageResource(intPhoto);
        binding.txtSelectProduct.setText(intName);
        binding.txtMrp.setText("₹"+intOriginalPrice);
        binding.txtDisMrp.setText(intMrp);
        binding.txtColorTypes.setText(intColor);
        binding.txtDescription.setText(intDes);
        binding.txtMrp.setPaintFlags(binding.txtMrp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listCart.add(new ProductModel(intPhoto, intName, intOriginalPrice, intRupees,intMrp, intDes, intColor,intQuantity));

                Toast.makeText(ShoppingDetailsActivity.this, "Cart Added Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        
    }
}