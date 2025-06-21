package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public class HttpUrlHeader implements java.io.Serializable {
    public static final long serialVersionUID = -6098125857367743614L;
    public java.util.Map<java.lang.String, java.lang.String> headers = new java.util.HashMap();

    public java.lang.String getHead(java.lang.String str) {
        return this.headers.get(str);
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.headers;
    }

    public void setHead(java.lang.String str, java.lang.String str2) {
        this.headers.put(str, str2);
    }

    public void setHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
        this.headers = map;
    }
}
