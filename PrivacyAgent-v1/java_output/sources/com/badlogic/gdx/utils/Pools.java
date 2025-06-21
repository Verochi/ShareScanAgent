package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class Pools {
    public static final com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.Pool> a = new com.badlogic.gdx.utils.ObjectMap<>();

    public static void free(java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("Object cannot be null.");
        }
        com.badlogic.gdx.utils.Pool pool = a.get(obj.getClass());
        if (pool == null) {
            return;
        }
        pool.free(obj);
    }

    public static void freeAll(com.badlogic.gdx.utils.Array array) {
        freeAll(array, false);
    }

    public static void freeAll(com.badlogic.gdx.utils.Array array, boolean z) {
        if (array == null) {
            throw new java.lang.IllegalArgumentException("Objects cannot be null.");
        }
        int i = array.size;
        com.badlogic.gdx.utils.Pool pool = null;
        for (int i2 = 0; i2 < i; i2++) {
            java.lang.Object obj = array.get(i2);
            if (obj != null && (pool != null || (pool = a.get(obj.getClass())) != null)) {
                pool.free(obj);
                if (!z) {
                    pool = null;
                }
            }
        }
    }

    public static <T> com.badlogic.gdx.utils.Pool<T> get(java.lang.Class<T> cls) {
        return get(cls, 100);
    }

    public static <T> com.badlogic.gdx.utils.Pool<T> get(java.lang.Class<T> cls, int i) {
        com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.Pool> objectMap = a;
        com.badlogic.gdx.utils.Pool<T> pool = objectMap.get(cls);
        if (pool != null) {
            return pool;
        }
        com.badlogic.gdx.utils.ReflectionPool reflectionPool = new com.badlogic.gdx.utils.ReflectionPool(cls, 4, i);
        objectMap.put(cls, reflectionPool);
        return reflectionPool;
    }

    public static <T> T obtain(java.lang.Class<T> cls) {
        return (T) get(cls).obtain();
    }

    public static <T> void set(java.lang.Class<T> cls, com.badlogic.gdx.utils.Pool<T> pool) {
        a.put(cls, pool);
    }
}
