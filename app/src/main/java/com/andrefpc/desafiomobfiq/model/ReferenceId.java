package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class ReferenceId implements Serializable{
    @SerializedName("Key")
    private String key;
    @SerializedName("Value")
    private String value;

    public ReferenceId() {
    }

    public ReferenceId(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
