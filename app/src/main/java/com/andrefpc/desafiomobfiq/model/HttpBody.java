package com.andrefpc.desafiomobfiq.model;

import java.io.Serializable;

/**
 * Created by andrefelipepaivacardozo on 08/11/17.
 */

public class HttpBody implements Serializable {
    private String ApiQuery;
    private String Query;
    private int Offset;
    private int Size;

    public HttpBody(String apiQuery, String query, int offset, int size) {
        ApiQuery = apiQuery;
        Query = query;
        Offset = offset;
        Size = size;
    }

    public HttpBody(String query, int offset, int size) {
        Query = query;
        Offset = offset;
        Size = size;
    }

    public String getApiQuery() {
        return ApiQuery;
    }

    public void setApiQuery(String apiQuery) {
        ApiQuery = apiQuery;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        Query = query;
    }

    public int getOffset() {
        return Offset;
    }

    public void setOffset(int offset) {
        Offset = offset;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }
}
