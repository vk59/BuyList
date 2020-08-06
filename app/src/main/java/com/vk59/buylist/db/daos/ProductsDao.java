package com.vk59.buylist.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vk59.buylist.db.entities.ProductEntity;

import java.util.List;

@Dao
public interface ProductsDao {
    @Insert
    Long insert(ProductEntity pe);

    @Update
    void update(ProductEntity pe);

    @Query("DELETE FROM Product WHERE id = :id")
    void deleteById(Long id);

    @Query("SELECT * FROM Product WHERE name LIKE '%'+:filter+'%'")
    LiveData<List<ProductEntity>> getByFilter(String filter);

    @Query("SELECT * FROM Product")
    LiveData<List<ProductEntity>> getAll();
}
