package com.alipay.sdk.m.f;

/* loaded from: classes.dex */
public final class a {
    public static java.lang.Class<?> a(java.lang.reflect.Type type) {
        while (!(type instanceof java.lang.Class)) {
            if (!(type instanceof java.lang.reflect.ParameterizedType)) {
                throw new java.lang.IllegalArgumentException("TODO");
            }
            type = ((java.lang.reflect.ParameterizedType) type).getRawType();
        }
        return (java.lang.Class) type;
    }

    public static boolean a(java.lang.Class<?> cls) {
        return cls.isPrimitive() || cls.equals(java.lang.String.class) || cls.equals(java.lang.Integer.class) || cls.equals(java.lang.Long.class) || cls.equals(java.lang.Double.class) || cls.equals(java.lang.Float.class) || cls.equals(java.lang.Boolean.class) || cls.equals(java.lang.Short.class) || cls.equals(java.lang.Character.class) || cls.equals(java.lang.Byte.class) || cls.equals(java.lang.Void.class);
    }
}
