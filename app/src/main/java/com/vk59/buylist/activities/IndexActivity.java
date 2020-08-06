package com.vk59.buylist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vk59.buylist.R;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void onPurchasesClick(View view) {
        Intent intent = new Intent(this, PurchasesListActivity.class);
        startActivity(intent);
    }

    public void onProductsClick(View view) {
        Intent intent = new Intent(this, ProductsListActivity.class);
        startActivity(intent);
    }
}