package com.badlogic.gdx.utils.reflect;

/* loaded from: classes12.dex */
public final class ArrayReflection {
    public static java.lang.Object get(java.lang.Object obj, int i) {
        return java.lang.reflect.Array.get(obj, i);
    }

    public static int getLength(java.lang.Object obj) {
        return java.lang.reflect.Array.getLength(obj);
    }

    public static java.lang.Object newInstance(java.lang.Class cls, int i) {
        return java.lang.reflect.Array.newInstance((java.lang.Class<?>) cls, i);
    }

    public static void set(java.lang.Object obj, int i, java.lang.Object obj2) {
        java.lang.reflect.Array.set(obj, i, obj2);
    }
}
