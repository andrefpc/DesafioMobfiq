package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class Sku implements Serializable{

    @SerializedName("Id")
    private String id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Order")
    private String order;
    @SerializedName("Sellers")
    private List<Seller> sellers;
    @SerializedName("Images")
    private List<Image> images;
    @SerializedName("Variations")
    private Variations variations;
    @SerializedName("SkuName")
    private String skuName;
    @SerializedName("UnitMultiplier")
    private String unitMultiplier;
    @SerializedName("ComplementName")
    private String complementName;
    @SerializedName("MeasurementUnit")
    private String measurementUnit;
    @SerializedName("ReferenceId")
    private List<ReferenceId> referenceId;
    @SerializedName("EAN")
    private String ean;

    public Sku() {
    }

    public Sku(String id, String name, String order, List<Seller> sellers, List<Image> images, Variations variations, String skuName, String unitMultiplier, String complementName, String measurementUnit, List<ReferenceId> referenceId, String ean) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.sellers = sellers;
        this.images = images;
        this.variations = variations;
        this.skuName = skuName;
        this.unitMultiplier = unitMultiplier;
        this.complementName = complementName;
        this.measurementUnit = measurementUnit;
        this.referenceId = referenceId;
        this.ean = ean;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Variations getVariations() {
        return variations;
    }

    public void setVariations(Variations variations) {
        this.variations = variations;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getUnitMultiplier() {
        return unitMultiplier;
    }

    public void setUnitMultiplier(String unitMultiplier) {
        this.unitMultiplier = unitMultiplier;
    }

    public String getComplementName() {
        return complementName;
    }

    public void setComplementName(String complementName) {
        this.complementName = complementName;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public List<ReferenceId> getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(List<ReferenceId> referenceId) {
        this.referenceId = referenceId;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
}
