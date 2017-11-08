package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class Product implements Serializable{
    @SerializedName("Availability")
    private boolean availability;
    @SerializedName("Skus")
    private List<Sku> skus;
    @SerializedName("Name")
    private String name;
    @SerializedName("Id")
    private String id;
    @SerializedName("Brand")
    private String brand;
    @SerializedName("Description")
    private String description;
    @SerializedName("Category")
    private String category;
    @SerializedName("Categories")
    private List<String> categories;
    @SerializedName("Specifications")
    private HashMap<String, List<String>> specifications;
    @SerializedName("Variations")
    private List<String> variations;
    @SerializedName("Videos")
    private List<String> videos;
    @SerializedName("Images")
    private List<String> images;
    @SerializedName("RealId")
    private String realId;

    public Product() {
    }

    public Product(boolean availability, List<Sku> skus, String name, String id, String brand, String description, String category, List<String> categories, HashMap<String, List<String>> specifications, List<String> variations, List<String> videos, List<String> images, String realId) {
        this.availability = availability;
        this.skus = skus;
        this.name = name;
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.category = category;
        this.categories = categories;
        this.specifications = specifications;
        this.variations = variations;
        this.videos = videos;
        this.images = images;
        this.realId = realId;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public HashMap<String, List<String>> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(HashMap<String, List<String>> specifications) {
        this.specifications = specifications;
    }

    public List<String> getVariations() {
        return variations;
    }

    public void setVariations(List<String> variations) {
        this.variations = variations;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getRealId() {
        return realId;
    }

    public void setRealId(String realId) {
        this.realId = realId;
    }
}
