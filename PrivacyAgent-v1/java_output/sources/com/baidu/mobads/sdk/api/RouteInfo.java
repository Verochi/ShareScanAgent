package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class RouteInfo {
    private java.lang.Class<?> destination;
    private java.lang.String path;
    private javax.lang.model.element.Element rawType;

    public RouteInfo() {
    }

    public RouteInfo(java.lang.Class<?> cls, java.lang.String str) {
        this.destination = cls;
        this.path = str;
    }

    public RouteInfo(javax.lang.model.element.Element element, java.lang.String str) {
        this.rawType = element;
        this.path = str;
    }

    public static com.baidu.mobads.sdk.api.RouteInfo build(java.lang.Class<?> cls, java.lang.String str) {
        return new com.baidu.mobads.sdk.api.RouteInfo(cls, str);
    }

    public java.lang.Class<?> getDestination() {
        return this.destination;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public javax.lang.model.element.Element getRawType() {
        return this.rawType;
    }

    public com.baidu.mobads.sdk.api.RouteInfo setDestination(java.lang.Class<?> cls) {
        this.destination = cls;
        return this;
    }

    public com.baidu.mobads.sdk.api.RouteInfo setPath(java.lang.String str) {
        this.path = str;
        return this;
    }
}
