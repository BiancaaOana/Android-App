package com.example.uidesignfinalsper.API;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Properties {

    @SerializedName("tip")
    @Expose
    private Tip tip;
    @SerializedName("latitudine")
    @Expose
    private Latitudine latitudine;
    @SerializedName("longitudine")
    @Expose
    private Longitudine longitudine;

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public Latitudine getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Latitudine latitudine) {
        this.latitudine = latitudine;
    }

    public Longitudine getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Longitudine longitudine) {
        this.longitudine = longitudine;
    }

}