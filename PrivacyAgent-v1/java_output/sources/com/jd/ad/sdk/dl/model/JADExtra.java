package com.jd.ad.sdk.dl.model;

/* loaded from: classes23.dex */
public class JADExtra implements com.jd.ad.sdk.dl.model.IJADExtra {
    private double price = 0.0d;

    @Override // com.jd.ad.sdk.dl.model.IJADExtra
    public int getPrice() {
        return (int) java.lang.Math.round(this.price);
    }

    public void setPrice(double d) {
        this.price = d;
    }
}
