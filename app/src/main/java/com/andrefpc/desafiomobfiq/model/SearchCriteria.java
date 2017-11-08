package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class SearchCriteria implements Serializable {
    @SerializedName("Query")
    private String query;
    @SerializedName("OrderBy")
    private String orderBy;
    @SerializedName("Size")
    private String size;
    @SerializedName("Offset")
    private String offset;
    @SerializedName("Filter")
    private String filter;
    @SerializedName("ApiQuery")
    private String apiQuery;
    @SerializedName("ProductId")
    private String productId;
    @SerializedName("BrandId")
    private String brandId;
    @SerializedName("Hotsite")
    private String hotSite;
    @SerializedName("RealProductId")
    private String realProductId;
    @SerializedName("EAN")
    private String ean;
    @SerializedName("RealProductIdGroup")
    private String realProductIdGroup;
    @SerializedName("FacetItems")
    private String facetItems;
    @SerializedName("SearchApi")
    private String searchApi;
    @SerializedName("ReferencId")
    private String referenceId;
    @SerializedName("ReferencIdGroup")
    private String referenceIdGroup;

    public SearchCriteria() {
    }

    public SearchCriteria(String query, String orderBy, String size, String offset, String filter, String apiQuery, String productId, String brandId, String hotSite, String realProductId, String ean, String realProductIdGroup, String facetItems, String searchApi, String referenceId, String referenceIdGroup) {
        this.query = query;
        this.orderBy = orderBy;
        this.size = size;
        this.offset = offset;
        this.filter = filter;
        this.apiQuery = apiQuery;
        this.productId = productId;
        this.brandId = brandId;
        this.hotSite = hotSite;
        this.realProductId = realProductId;
        this.ean = ean;
        this.realProductIdGroup = realProductIdGroup;
        this.facetItems = facetItems;
        this.searchApi = searchApi;
        this.referenceId = referenceId;
        this.referenceIdGroup = referenceIdGroup;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getApiQuery() {
        return apiQuery;
    }

    public void setApiQuery(String apiQuery) {
        this.apiQuery = apiQuery;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getHotSite() {
        return hotSite;
    }

    public void setHotSite(String hotSite) {
        this.hotSite = hotSite;
    }

    public String getRealProductId() {
        return realProductId;
    }

    public void setRealProductId(String realProductId) {
        this.realProductId = realProductId;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getRealProductIdGroup() {
        return realProductIdGroup;
    }

    public void setRealProductIdGroup(String realProductIdGroup) {
        this.realProductIdGroup = realProductIdGroup;
    }

    public String getFacetItems() {
        return facetItems;
    }

    public void setFacetItems(String facetItems) {
        this.facetItems = facetItems;
    }

    public String getSearchApi() {
        return searchApi;
    }

    public void setSearchApi(String searchApi) {
        this.searchApi = searchApi;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceIdGroup() {
        return referenceIdGroup;
    }

    public void setReferenceIdGroup(String referenceIdGroup) {
        this.referenceIdGroup = referenceIdGroup;
    }
}
