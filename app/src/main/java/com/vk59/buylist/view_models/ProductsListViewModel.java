package com.vk59.buylist.view_models;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.vk59.buylist.models.Product;
import com.vk59.buylist.repositories.ProductsRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductsListViewModel extends AndroidViewModel {
    private ProductsRepository repository;

    public ProductsListViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductsRepository(application);
        all = repository.getAllProducts();
    }

    private LiveData<List<Product>> all;

    List<Product> data = new ArrayList<>();

    public LiveData<List<Product>> getAllProducts() {
        return all;
    }

    public void createProduct(String name) {
        repository.createProduct(name);
    }

    public void deleteProduct(Long id) {
        repository.deleteProduct(id);
    }
}
