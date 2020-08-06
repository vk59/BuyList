package com.vk59.buylist.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vk59.buylist.db.daos.ProductsDao;
import com.vk59.buylist.db.entities.ProductEntity;
import com.vk59.buylist.models.Product;

@Database(entities = {ProductEntity.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    abstract ProductsDao productsDao();

    public static final String DB_NAME = "Product.db";
    public static volatile AppDB INSTANCE=null;

    public synchronized static AppDB get(Context context) {
        if(INSTANCE==null) {
            INSTANCE = create(context, false);
        }
        return INSTANCE;
    }

    public static AppDB create(Context context, boolean memoryOnly) {
        RoomDatabase.Builder<AppDB> builder;
        if(memoryOnly) {
            builder = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDB.class);
        }
        else {
            builder = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, DB_NAME);
        }
        return builder.build();
    }

    public ProductsDao getProductsDao() {
        return productsDao();
    }
}
