package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class b implements com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j {
    public static java.util.Collection<java.lang.Object> a(java.lang.Class<?> cls, java.lang.reflect.Type type) {
        if (cls == java.util.AbstractCollection.class) {
            return new java.util.ArrayList();
        }
        if (cls.isAssignableFrom(java.util.HashSet.class)) {
            return new java.util.HashSet();
        }
        if (cls.isAssignableFrom(java.util.LinkedHashSet.class)) {
            return new java.util.LinkedHashSet();
        }
        if (cls.isAssignableFrom(java.util.TreeSet.class)) {
            return new java.util.TreeSet();
        }
        if (cls.isAssignableFrom(java.util.ArrayList.class)) {
            return new java.util.ArrayList();
        }
        if (cls.isAssignableFrom(java.util.EnumSet.class)) {
            return java.util.EnumSet.noneOf((java.lang.Class) (type instanceof java.lang.reflect.ParameterizedType ? ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0] : java.lang.Object.class));
        }
        try {
            return (java.util.Collection) cls.newInstance();
        } catch (java.lang.Exception unused) {
            throw new java.lang.IllegalArgumentException("create instane error, class " + cls.getName());
        }
    }

    @Override // com.alipay.sdk.m.e.j
    public final java.lang.Object a(java.lang.Object obj) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = ((java.lang.Iterable) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(com.alipay.sdk.m.e.f.b(it.next()));
        }
        return arrayList;
    }

    @Override // com.alipay.sdk.m.e.i
    public final java.lang.Object a(java.lang.Object obj, java.lang.reflect.Type type) {
        if (!obj.getClass().equals(org.json.alipay.a.class)) {
            return null;
        }
        org.json.alipay.a aVar = (org.json.alipay.a) obj;
        java.util.Collection<java.lang.Object> a = a(com.alipay.sdk.m.f.a.a(type), type);
        if (!(type instanceof java.lang.reflect.ParameterizedType)) {
            throw new java.lang.IllegalArgumentException("Does not support the implement for generics.");
        }
        java.lang.reflect.Type type2 = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
        for (int i = 0; i < aVar.a(); i++) {
            a.add(com.alipay.sdk.m.e.e.a(aVar.a(i), type2));
        }
        return a;
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(java.lang.Class<?> cls) {
        return java.util.Collection.class.isAssignableFrom(cls);
    }
}
