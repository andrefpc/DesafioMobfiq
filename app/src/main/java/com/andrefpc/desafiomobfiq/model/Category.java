package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class Category implements Serializable{

    @SerializedName("Id")
    private int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Image")
    private String image;
    @SerializedName("Redirect")
    private Redirect redirect;
    @SerializedName("SubCategories")
    private List<Category> subCategories;
    @SerializedName("Highlight")
    private boolean highlight;
    @SerializedName("Icon")
    private String icon;
    @SerializedName("CategoryListOrder")
    private int categoryListOrder;
    @SerializedName("CategoryTreeOrder")
    private int categoryTreeOrder;
    @SerializedName("LinkId")
    private int linkId;

    private boolean open;

    public Category() {
    }

    public Category(int id, String name, String image, Redirect redirect, List<Category> subCategories, boolean highlight, String icon, int categoryListOrder, int categoryTreeOrder, int linkId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.redirect = redirect;
        this.subCategories = subCategories;
        this.highlight = highlight;
        this.icon = icon;
        this.categoryListOrder = categoryListOrder;
        this.categoryTreeOrder = categoryTreeOrder;
        this.linkId = linkId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCategoryListOrder() {
        return categoryListOrder;
    }

    public void setCategoryListOrder(int categoryListOrder) {
        this.categoryListOrder = categoryListOrder;
    }

    public int getCategoryTreeOrder() {
        return categoryTreeOrder;
    }

    public void setCategoryTreeOrder(int categoryTreeOrder) {
        this.categoryTreeOrder = categoryTreeOrder;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
