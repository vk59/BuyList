package com.vk59.buylist.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.vk59.buylist.db.AppDB;
import com.vk59.buylist.db.daos.ProductsDao;
import com.vk59.buylist.db.entities.ProductEntity;
import com.vk59.buylist.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {
    private ProductsDao dao;

    public ProductsRepository(Application application) {
        AppDB db = AppDB.get(application);
        this.dao = db.getProductsDao();
    }

    public LiveData<List<Product>> getAllProducts() {
        return Transformations.map(dao.getAll(), new Function<List<ProductEntity>, List<Product>>() {
            @Override
            public List<Product> apply(List<ProductEntity> input) {
                List<Product> answer = new ArrayList<>();
                for(ProductEntity pe : input){
                    answer.add(new Product(pe));
                }
                return answer;
            }
        });
    }

    public void createProduct(String name) {
        new CreateTask().execute(name);
    }

    public void deleteProduct(Long id) {
        new DeleteTask().execute(id);
    }

    private class CreateTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            if (strings == null) {
                return null;
            }
            for (String s : strings) {
                if(s != null) {
                    ProductEntity productEntity = new ProductEntity();
                    productEntity.name = s;
                    dao.insert(productEntity);
                }
            }
            return null;
        }
    }

    private class DeleteTask extends AsyncTask<Long, Void, Void> {

        @Override
        protected Void doInBackground(Long... ids) {
            if (ids == null) {
                return null;
            }
            for (Long id : ids) {
                if(id != null) {
                    dao.deleteById(id);
                }
            }
            return null;
        }
    }
}
