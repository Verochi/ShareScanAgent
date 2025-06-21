package com.alimm.tanx.core.image.util;

/* loaded from: classes.dex */
public class GifConfig extends com.alimm.tanx.core.ad.bean.BaseBean {
    private int gifRes;
    private java.lang.String gifUrl;
    private android.widget.ImageView gifView;

    public GifConfig(android.widget.ImageView imageView, int i) {
        this.gifView = imageView;
        this.gifRes = i;
    }

    public GifConfig(android.widget.ImageView imageView, java.lang.String str) {
        this.gifRes = -1;
        this.gifView = imageView;
        this.gifUrl = str;
    }

    public int getGifRes() {
        return this.gifRes;
    }

    public java.lang.String getGifUrl() {
        return this.gifUrl;
    }

    public android.widget.ImageView getGifView() {
        return this.gifView;
    }

    public void setGifRes(int i) {
        this.gifRes = i;
    }

    public void setGifUrl(java.lang.String str) {
        this.gifUrl = str;
    }

    public void setGifView(android.widget.ImageView imageView) {
        this.gifView = imageView;
    }
}
