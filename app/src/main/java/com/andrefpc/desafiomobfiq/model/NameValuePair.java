package com.andrefpc.desafiomobfiq.model;

import java.io.Serializable;

/**
 * Created by andrefelipepaivacardozo on 29/10/17.
 */

public class NameValuePair implements Serializable {
    private String name;
    private String value;

    public NameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
