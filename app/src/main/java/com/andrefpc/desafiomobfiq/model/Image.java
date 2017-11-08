package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class Image implements Serializable{

    @SerializedName("ImageUrl")
    private String imageUrl;
    @SerializedName("ImageTag")
    private String imageTag;
    @SerializedName("Label")
    private String label;

    public Image() {
    }

    public Image(String imageUrl, String imageTag, String label) {
        this.imageUrl = imageUrl;
        this.imageTag = imageTag;
        this.label = label;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
