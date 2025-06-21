package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class e {
    public static java.util.List<com.alipay.sdk.m.e.i> a;

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        a = arrayList;
        arrayList.add(new com.alipay.sdk.m.e.l());
        a.add(new com.alipay.sdk.m.e.d());
        a.add(new com.alipay.sdk.m.e.c());
        a.add(new com.alipay.sdk.m.e.h());
        a.add(new com.alipay.sdk.m.e.k());
        a.add(new com.alipay.sdk.m.e.b());
        a.add(new com.alipay.sdk.m.e.a());
        a.add(new com.alipay.sdk.m.e.g());
    }

    public static final <T> T a(java.lang.Object obj, java.lang.reflect.Type type) {
        T t;
        for (com.alipay.sdk.m.e.i iVar : a) {
            if (iVar.a(com.alipay.sdk.m.f.a.a(type)) && (t = (T) iVar.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    public static final java.lang.Object a(java.lang.String str, java.lang.reflect.Type type) {
        java.lang.Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        java.lang.String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new org.json.alipay.a(trim);
        } else {
            if (!trim.startsWith("{") || !trim.endsWith(com.alipay.sdk.m.u.i.d)) {
                return a((java.lang.Object) trim, type);
            }
            bVar = new org.json.alipay.b(trim);
        }
        return a(bVar, type);
    }
}
