package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListBucketsRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private static final int MAX_RETURNED_KEYS_LIMIT = 1000;
    private java.lang.String marker;
    private java.lang.Integer maxKeys;
    private java.lang.String prefix;

    public ListBucketsRequest() {
    }

    public ListBucketsRequest(java.lang.String str) {
        this(str, null);
    }

    public ListBucketsRequest(java.lang.String str, java.lang.String str2) {
        this(str, str2, 100);
    }

    public ListBucketsRequest(java.lang.String str, java.lang.String str2, java.lang.Integer num) {
        this.prefix = str;
        this.marker = str2;
        this.maxKeys = num;
    }

    public java.lang.String getMarker() {
        return this.marker;
    }

    public java.lang.Integer getMaxKeys() {
        return this.maxKeys;
    }

    public java.lang.String getPrefix() {
        return this.prefix;
    }

    public void setMarker(java.lang.String str) {
        this.marker = str;
    }

    public void setMaxKeys(java.lang.Integer num) {
        this.maxKeys = num;
    }

    public void setPrefix(java.lang.String str) {
        this.prefix = str;
    }
}
