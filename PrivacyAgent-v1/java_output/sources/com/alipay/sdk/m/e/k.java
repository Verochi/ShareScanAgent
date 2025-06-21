package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class k implements com.alipay.sdk.m.e.i {
    @Override // com.alipay.sdk.m.e.i
    public final java.lang.Object a(java.lang.Object obj, java.lang.reflect.Type type) {
        if (!obj.getClass().equals(org.json.alipay.a.class)) {
            return null;
        }
        org.json.alipay.a aVar = (org.json.alipay.a) obj;
        java.util.HashSet hashSet = new java.util.HashSet();
        java.lang.Class cls = type instanceof java.lang.reflect.ParameterizedType ? ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0] : java.lang.Object.class;
        for (int i = 0; i < aVar.a(); i++) {
            hashSet.add(com.alipay.sdk.m.e.e.a(aVar.a(i), cls));
        }
        return hashSet;
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(java.lang.Class<?> cls) {
        return java.util.Set.class.isAssignableFrom(cls);
    }
}
