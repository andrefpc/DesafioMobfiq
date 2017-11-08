package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class Criteria implements Serializable{

    @SerializedName("Size")
    private int size;
    @SerializedName("Offset")
    private int offset;
    @SerializedName("Total")
    private int total;
    @SerializedName("Delay")
    private double delay;
    @SerializedName("Products")
    private List<Product> products;
    @SerializedName("ApiQuery")
    private String apiQuery;

    public Criteria() {
    }

    public Criteria(int size, int offset, int total, double delay, List<Product> products, String apiQuery) {
        this.size = size;
        this.offset = offset;
        this.total = total;
        this.delay = delay;
        this.products = products;
        this.apiQuery = apiQuery;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getApiQuery() {
        return apiQuery;
    }

    public void setApiQuery(String apiQuery) {
        this.apiQuery = apiQuery;
    }
}
