package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class f {
    public static java.util.List<com.alipay.sdk.m.e.j> a;

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        a = arrayList;
        arrayList.add(new com.alipay.sdk.m.e.l());
        a.add(new com.alipay.sdk.m.e.d());
        a.add(new com.alipay.sdk.m.e.c());
        a.add(new com.alipay.sdk.m.e.h());
        a.add(new com.alipay.sdk.m.e.b());
        a.add(new com.alipay.sdk.m.e.a());
        a.add(new com.alipay.sdk.m.e.g());
    }

    public static java.lang.String a(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        java.lang.Object b = b(obj);
        if (com.alipay.sdk.m.f.a.a(b.getClass())) {
            return org.json.alipay.b.c(b.toString());
        }
        if (java.util.Collection.class.isAssignableFrom(b.getClass())) {
            return new org.json.alipay.a((java.util.Collection) b).toString();
        }
        if (java.util.Map.class.isAssignableFrom(b.getClass())) {
            return new org.json.alipay.b((java.util.Map) b).toString();
        }
        throw new java.lang.IllegalArgumentException("Unsupported Class : " + b.getClass());
    }

    public static java.lang.Object b(java.lang.Object obj) {
        java.lang.Object a2;
        if (obj == null) {
            return null;
        }
        for (com.alipay.sdk.m.e.j jVar : a) {
            if (jVar.a(obj.getClass()) && (a2 = jVar.a(obj)) != null) {
                return a2;
            }
        }
        throw new java.lang.IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
