package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
class ClassTypeReflect {
    private static java.lang.reflect.Type getGenericType(int i, java.lang.Class<?> cls) {
        java.lang.reflect.Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof java.lang.reflect.ParameterizedType)) {
            return java.lang.Object.class;
        }
        java.lang.reflect.Type[] actualTypeArguments = ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (i >= actualTypeArguments.length || i < 0) {
            throw new java.lang.RuntimeException("Index outof bounds");
        }
        java.lang.reflect.Type type = actualTypeArguments[i];
        return !(type instanceof java.lang.Class) ? java.lang.Object.class : type;
    }

    public static java.lang.reflect.Type getModelClazz(java.lang.Class<?> cls) {
        return getGenericType(0, cls);
    }
}
