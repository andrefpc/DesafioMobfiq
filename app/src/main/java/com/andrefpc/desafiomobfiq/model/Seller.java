package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class Seller implements Serializable{

    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Quantity")
    private int quantity;
    @SerializedName("Price")
    private double price;
    @SerializedName("ListPrice")
    private double listPrice;
    @SerializedName("BestInstallment")
    private BestInstallment bestInstallment;
    @SerializedName("Offer")
    private String offer;

    public Seller() {
    }

    public Seller(String id, String name, int quantity, double price, double listPrice, BestInstallment bestInstallment, String offer) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.listPrice = listPrice;
        this.bestInstallment = bestInstallment;
        this.offer = offer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public BestInstallment getBestInstallment() {
        return bestInstallment;
    }

    public void setBestInstallment(BestInstallment bestInstallment) {
        this.bestInstallment = bestInstallment;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }
}
