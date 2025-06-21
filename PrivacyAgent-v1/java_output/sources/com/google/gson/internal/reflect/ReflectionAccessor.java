package com.google.gson.internal.reflect;

/* loaded from: classes22.dex */
public abstract class ReflectionAccessor {
    private static final com.google.gson.internal.reflect.ReflectionAccessor instance;

    static {
        instance = com.google.gson.internal.JavaVersion.getMajorJavaVersion() < 9 ? new com.google.gson.internal.reflect.PreJava9ReflectionAccessor() : new com.google.gson.internal.reflect.UnsafeReflectionAccessor();
    }

    public static com.google.gson.internal.reflect.ReflectionAccessor getInstance() {
        return instance;
    }

    public abstract void makeAccessible(java.lang.reflect.AccessibleObject accessibleObject);
}
