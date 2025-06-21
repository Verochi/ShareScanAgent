package com.amap.api.mapcore.util;

@java.lang.Deprecated
/* loaded from: classes12.dex */
final class fj extends com.amap.api.mapcore.util.hi {
    private java.lang.String b;
    private java.util.Map<java.lang.String, java.lang.String> a = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.String> g = new java.util.HashMap();

    public final void a(java.lang.String str) {
        this.b = str;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.a.clear();
        this.a.putAll(map);
    }

    public final void b(java.util.Map<java.lang.String, java.lang.String> map) {
        this.g.clear();
        this.g.putAll(map);
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        return this.g;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        return this.a;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        return this.b;
    }
}
