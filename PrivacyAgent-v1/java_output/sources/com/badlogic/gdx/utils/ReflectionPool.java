package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class ReflectionPool<T> extends com.badlogic.gdx.utils.Pool<T> {
    public final com.badlogic.gdx.utils.reflect.Constructor b;

    public ReflectionPool(java.lang.Class<T> cls) {
        this(cls, 16, Integer.MAX_VALUE);
    }

    public ReflectionPool(java.lang.Class<T> cls, int i) {
        this(cls, i, Integer.MAX_VALUE);
    }

    public ReflectionPool(java.lang.Class<T> cls, int i, int i2) {
        super(i, i2);
        com.badlogic.gdx.utils.reflect.Constructor a = a(cls);
        this.b = a;
        if (a != null) {
            return;
        }
        throw new java.lang.RuntimeException("Class cannot be created (missing no-arg constructor): " + cls.getName());
    }

    public final com.badlogic.gdx.utils.reflect.Constructor a(java.lang.Class<T> cls) {
        try {
            try {
                return com.badlogic.gdx.utils.reflect.ClassReflection.getConstructor(cls, null);
            } catch (java.lang.Exception unused) {
                com.badlogic.gdx.utils.reflect.Constructor declaredConstructor = com.badlogic.gdx.utils.reflect.ClassReflection.getDeclaredConstructor(cls, null);
                declaredConstructor.setAccessible(true);
                return declaredConstructor;
            }
        } catch (com.badlogic.gdx.utils.reflect.ReflectionException unused2) {
            return null;
        }
    }

    @Override // com.badlogic.gdx.utils.Pool
    public T newObject() {
        try {
            return (T) this.b.newInstance(null);
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Unable to create new instance: " + this.b.getDeclaringClass().getName(), e);
        }
    }
}
