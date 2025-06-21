package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public abstract class Pool<T> {
    public final com.badlogic.gdx.utils.Array<T> a;
    public final int max;
    public int peak;

    public interface Poolable {
        void reset();
    }

    public Pool() {
        this(16, Integer.MAX_VALUE);
    }

    public Pool(int i) {
        this(i, Integer.MAX_VALUE);
    }

    public Pool(int i, int i2) {
        this.a = new com.badlogic.gdx.utils.Array<>(false, i);
        this.max = i2;
    }

    public void clear() {
        this.a.clear();
    }

    public void free(T t) {
        if (t == null) {
            throw new java.lang.IllegalArgumentException("object cannot be null.");
        }
        com.badlogic.gdx.utils.Array<T> array = this.a;
        if (array.size < this.max) {
            array.add(t);
            this.peak = java.lang.Math.max(this.peak, this.a.size);
        }
        reset(t);
    }

    public void freeAll(com.badlogic.gdx.utils.Array<T> array) {
        if (array == null) {
            throw new java.lang.IllegalArgumentException("objects cannot be null.");
        }
        com.badlogic.gdx.utils.Array<T> array2 = this.a;
        int i = this.max;
        for (int i2 = 0; i2 < array.size; i2++) {
            T t = array.get(i2);
            if (t != null) {
                if (array2.size < i) {
                    array2.add(t);
                }
                reset(t);
            }
        }
        this.peak = java.lang.Math.max(this.peak, array2.size);
    }

    public int getFree() {
        return this.a.size;
    }

    public abstract T newObject();

    public T obtain() {
        com.badlogic.gdx.utils.Array<T> array = this.a;
        return array.size == 0 ? newObject() : array.pop();
    }

    public void reset(T t) {
        if (t instanceof com.badlogic.gdx.utils.Pool.Poolable) {
            ((com.badlogic.gdx.utils.Pool.Poolable) t).reset();
        }
    }
}
