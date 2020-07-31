package com.vk59.buylist.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vk59.buylist.db.entities.ProductEntity;
import com.vk59.buylist.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsListViewModel extends AndroidViewModel {
    public ProductsListViewModel(@NonNull Application application) {
        super(application);
    }

    List<Product> data = new ArrayList<>();
    MutableLiveData<List<Product>> all = new MutableLiveData<>();

    public LiveData<List<Product>> getAllProducts() {
        all.setValue(data);
        return all;
    }

    public void createProduct(String name) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.name = name;
        data.add(new Product(productEntity));
        all.setValue(data);
    }

    public void deleteProduct(Long id) {

    }
}
