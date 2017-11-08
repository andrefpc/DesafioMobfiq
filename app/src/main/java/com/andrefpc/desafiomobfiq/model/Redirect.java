package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class Redirect implements Serializable{

    @SerializedName("Id")
    private int id;
    @SerializedName("SearchCriteria")
    private SearchCriteria searchCriteria;
    @SerializedName("Title")
    private String title;
    @SerializedName("Type")
    private int type;
    @SerializedName("ContentUrl")
    private String contentUrl;
    @SerializedName("CustomPageId")
    private String customPageId;
    @SerializedName("ReferenceId")
    private String referenceId;

    public Redirect() {
    }

    public Redirect(int id, SearchCriteria searchCriteria, String title, int type, String contentUrl, String customPageId, String referenceId) {
        this.id = id;
        this.searchCriteria = searchCriteria;
        this.title = title;
        this.type = type;
        this.contentUrl = contentUrl;
        this.customPageId = customPageId;
        this.referenceId = referenceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getCustomPageId() {
        return customPageId;
    }

    public void setCustomPageId(String customPageId) {
        this.customPageId = customPageId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
