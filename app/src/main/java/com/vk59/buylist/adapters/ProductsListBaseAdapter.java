package com.vk59.buylist.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.LayoutRes;

import com.vk59.buylist.models.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductsListBaseAdapter extends BaseAdapter {
    /*------------Listener-----------*/
    public interface ItemInteractionListener{
        void action(Product p, int type);
    }

    private ItemInteractionListener listener;
    public void setListener(ItemInteractionListener listener) {
        this.listener = listener;
    }
    protected void onItemInteraction(Product p, int type) {
        if(listener != null){
            listener.action(p, type);
        }
    }

    /*------------Products-----------*/
    protected List<Product> products = new ArrayList<>();
    public void refresh(List<Product> data) {
        products.clear();
        if (data != null) {
            products.addAll(data);
        }
        notifyDataSetChanged();
    }

    /*------------Standard-----------*/
    private Context context;
    protected Context getContext() { return context; }
    private LayoutInflater inflater;

    public ProductsListBaseAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    protected Product getProduct(int i) {
        return products.get(i);
    }

    @Override
    public Object getItem(int position) {
        return getProduct(position);
    }

    @Override
    public long getItemId(int position) {
        return products.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(getItemLayout(), parent, false);
        }
        applyProductToView(getProduct(position), convertView);
        return convertView;
    }

    public abstract @LayoutRes int getItemLayout();
    public abstract void applyProductToView(Product p, View v);
}
