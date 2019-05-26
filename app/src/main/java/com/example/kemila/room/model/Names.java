package com.example.kemila.room.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Names {

    @PrimaryKey (autoGenerate = true)
    private int name_id;
    private String name;
    private String price;


    public int getName_id() {
        return name_id;
    }

    public void setName_id(@NonNull int name_id) {
        this.name_id = name_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
