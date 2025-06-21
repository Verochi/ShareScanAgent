package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class ExpressAdData {
    private java.lang.String adPlaceId;
    private java.lang.String desc;
    private java.lang.String iconUrl;
    private java.lang.String imageUrl;
    private java.util.List<java.lang.String> multiPicUrls;
    private java.lang.String pk;
    private java.lang.String title;
    private java.lang.String videoUrl;

    public ExpressAdData(com.baidu.mobads.sdk.internal.a aVar, java.lang.String str) {
        this.title = "";
        this.desc = "";
        this.iconUrl = "";
        this.pk = "";
        this.imageUrl = "";
        this.videoUrl = "";
        this.multiPicUrls = null;
        this.adPlaceId = str;
        this.title = aVar.a();
        this.desc = aVar.b();
        this.iconUrl = aVar.c();
        this.pk = aVar.m();
        this.imageUrl = aVar.d();
        this.videoUrl = aVar.n();
        this.multiPicUrls = aVar.H();
    }

    public java.lang.String getAdPlaceId() {
        return this.adPlaceId;
    }

    public java.lang.String getAppPackage() {
        return this.pk;
    }

    public java.lang.String getDesc() {
        return this.desc;
    }

    public java.lang.String getIconUrl() {
        return this.iconUrl;
    }

    public java.lang.String getImageUrl() {
        return this.imageUrl;
    }

    public java.util.List<java.lang.String> getMultiPicUrls() {
        return this.multiPicUrls;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getVideoUrl() {
        return this.videoUrl;
    }
}
