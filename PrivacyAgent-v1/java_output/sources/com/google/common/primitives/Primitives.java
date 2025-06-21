package com.google.common.primitives;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Primitives {
    public static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> a;
    public static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> b;

    static {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(16);
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(16);
        a(linkedHashMap, linkedHashMap2, java.lang.Boolean.TYPE, java.lang.Boolean.class);
        a(linkedHashMap, linkedHashMap2, java.lang.Byte.TYPE, java.lang.Byte.class);
        a(linkedHashMap, linkedHashMap2, java.lang.Character.TYPE, java.lang.Character.class);
        a(linkedHashMap, linkedHashMap2, java.lang.Double.TYPE, java.lang.Double.class);
        a(linkedHashMap, linkedHashMap2, java.lang.Float.TYPE, java.lang.Float.class);
        a(linkedHashMap, linkedHashMap2, java.lang.Integer.TYPE, java.lang.Integer.class);
        a(linkedHashMap, linkedHashMap2, java.lang.Long.TYPE, java.lang.Long.class);
        a(linkedHashMap, linkedHashMap2, java.lang.Short.TYPE, java.lang.Short.class);
        a(linkedHashMap, linkedHashMap2, java.lang.Void.TYPE, java.lang.Void.class);
        a = java.util.Collections.unmodifiableMap(linkedHashMap);
        b = java.util.Collections.unmodifiableMap(linkedHashMap2);
    }

    public static void a(java.util.Map<java.lang.Class<?>, java.lang.Class<?>> map, java.util.Map<java.lang.Class<?>, java.lang.Class<?>> map2, java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static java.util.Set<java.lang.Class<?>> allPrimitiveTypes() {
        return a.keySet();
    }

    public static java.util.Set<java.lang.Class<?>> allWrapperTypes() {
        return b.keySet();
    }

    public static boolean isWrapperType(java.lang.Class<?> cls) {
        return b.containsKey(com.google.common.base.Preconditions.checkNotNull(cls));
    }

    public static <T> java.lang.Class<T> unwrap(java.lang.Class<T> cls) {
        com.google.common.base.Preconditions.checkNotNull(cls);
        java.lang.Class<T> cls2 = (java.lang.Class) b.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static <T> java.lang.Class<T> wrap(java.lang.Class<T> cls) {
        com.google.common.base.Preconditions.checkNotNull(cls);
        java.lang.Class<T> cls2 = (java.lang.Class) a.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
