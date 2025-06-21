package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class ResourceLocation {
    public java.lang.String a = null;
    public java.lang.String b = null;
    public java.net.URL c = null;

    public java.net.URL getBase() {
        return this.c;
    }

    public java.lang.String getLocation() {
        return this.b;
    }

    public java.lang.String getPublicId() {
        return this.a;
    }

    public void setBase(java.net.URL url) {
        this.c = url;
    }

    public void setLocation(java.lang.String str) {
        this.b = str;
    }

    public void setPublicId(java.lang.String str) {
        this.a = str;
    }
}
