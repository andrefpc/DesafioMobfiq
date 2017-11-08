package com.andrefpc.desafiomobfiq.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andrefelipepaivacardozo on 08/11/2017.
 */

public class Variations implements Serializable{
    @SerializedName("Voltagem")
    private List<String> voltagem;

    public Variations() {
    }

    public Variations(List<String> voltagem) {
        this.voltagem = voltagem;
    }

    public List<String> getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(List<String> voltagem) {
        this.voltagem = voltagem;
    }
}
