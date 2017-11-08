package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class CategoryTree implements Serializable{

    @SerializedName("Categories")
    private List<Category> categories;
    @SerializedName("Id")
    private int id;

    public CategoryTree() {
    }

    public CategoryTree(List<Category> categories, int id) {
        this.categories = categories;
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
