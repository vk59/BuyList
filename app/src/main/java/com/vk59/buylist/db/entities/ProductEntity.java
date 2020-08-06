package com.vk59.buylist.db.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (
        tableName = "Product"
)
public class ProductEntity {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    public String name;
    public int state;
    public int counter;

}
