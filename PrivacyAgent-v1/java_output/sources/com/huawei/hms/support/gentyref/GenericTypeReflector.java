package com.huawei.hms.support.gentyref;

/* loaded from: classes22.dex */
public final class GenericTypeReflector {
    public static java.lang.Class<?> getType(java.lang.reflect.Type type) {
        if (type instanceof java.lang.Class) {
            return (java.lang.Class) type;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return (java.lang.Class) ((java.lang.reflect.ParameterizedType) type).getRawType();
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type;
            return typeVariable.getBounds().length == 0 ? java.lang.Object.class : getType(typeVariable.getBounds()[0]);
        }
        throw new java.lang.IllegalArgumentException("not supported: " + type.getClass());
    }
}
