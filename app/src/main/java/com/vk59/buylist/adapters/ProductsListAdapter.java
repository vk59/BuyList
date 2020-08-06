package com.vk59.buylist.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.vk59.buylist.R;
import com.vk59.buylist.models.Product;

public class ProductsListAdapter extends ProductsListBaseAdapter {

    public ProductsListAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemLayout() {
        return R.layout.product_item;
    }

    @Override
    public void applyProductToView(Product p, View v) {
        TextView name = v.findViewById(R.id.productName);
        name.setText(p.getName());
    }
}
