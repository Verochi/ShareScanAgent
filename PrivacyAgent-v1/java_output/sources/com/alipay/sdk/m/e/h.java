package com.alipay.sdk.m.e;

/* loaded from: classes.dex */
public final class h implements com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j {
    public static java.util.Map<java.lang.Object, java.lang.Object> a(java.lang.reflect.Type type) {
        while (type != java.util.Properties.class) {
            if (type == java.util.Hashtable.class) {
                return new java.util.Hashtable();
            }
            if (type == java.util.IdentityHashMap.class) {
                return new java.util.IdentityHashMap();
            }
            if (type == java.util.SortedMap.class || type == java.util.TreeMap.class) {
                return new java.util.TreeMap();
            }
            if (type == java.util.concurrent.ConcurrentMap.class || type == java.util.concurrent.ConcurrentHashMap.class) {
                return new java.util.concurrent.ConcurrentHashMap();
            }
            if (type == java.util.Map.class || type == java.util.HashMap.class) {
                return new java.util.HashMap();
            }
            if (type == java.util.LinkedHashMap.class) {
                return new java.util.LinkedHashMap();
            }
            if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                java.lang.Class cls = (java.lang.Class) type;
                if (cls.isInterface()) {
                    throw new java.lang.IllegalArgumentException("unsupport type " + type);
                }
                try {
                    return (java.util.Map) cls.newInstance();
                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException("unsupport type " + type, e);
                }
            }
            type = ((java.lang.reflect.ParameterizedType) type).getRawType();
        }
        return new java.util.Properties();
    }

    @Override // com.alipay.sdk.m.e.j
    public final java.lang.Object a(java.lang.Object obj) {
        java.util.TreeMap treeMap = new java.util.TreeMap();
        for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
            if (!(entry.getKey() instanceof java.lang.String)) {
                throw new java.lang.IllegalArgumentException("Map key must be String!");
            }
            treeMap.put((java.lang.String) entry.getKey(), com.alipay.sdk.m.e.f.b(entry.getValue()));
        }
        return treeMap;
    }

    @Override // com.alipay.sdk.m.e.i
    public final java.lang.Object a(java.lang.Object obj, java.lang.reflect.Type type) {
        if (!obj.getClass().equals(org.json.alipay.b.class)) {
            return null;
        }
        org.json.alipay.b bVar = (org.json.alipay.b) obj;
        java.util.Map<java.lang.Object, java.lang.Object> a = a(type);
        if (!(type instanceof java.lang.reflect.ParameterizedType)) {
            throw new java.lang.IllegalArgumentException("Deserialize Map must be Generics!");
        }
        java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
        java.lang.reflect.Type type2 = parameterizedType.getActualTypeArguments()[0];
        java.lang.reflect.Type type3 = parameterizedType.getActualTypeArguments()[1];
        if (java.lang.String.class != type2) {
            throw new java.lang.IllegalArgumentException("Deserialize Map Key must be String.class");
        }
        java.util.Iterator a2 = bVar.a();
        while (a2.hasNext()) {
            java.lang.String str = (java.lang.String) a2.next();
            a.put(str, com.alipay.sdk.m.f.a.a((java.lang.Class<?>) type3) ? bVar.a(str) : com.alipay.sdk.m.e.e.a(bVar.a(str), type3));
        }
        return a;
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(java.lang.Class<?> cls) {
        return java.util.Map.class.isAssignableFrom(cls);
    }
}
