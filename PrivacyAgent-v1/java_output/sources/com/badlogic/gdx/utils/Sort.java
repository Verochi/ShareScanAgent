package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class Sort {
    public static com.badlogic.gdx.utils.Sort c;
    public com.badlogic.gdx.utils.TimSort a;
    public com.badlogic.gdx.utils.ComparableTimSort b;

    public static com.badlogic.gdx.utils.Sort instance() {
        if (c == null) {
            c = new com.badlogic.gdx.utils.Sort();
        }
        return c;
    }

    public <T> void sort(com.badlogic.gdx.utils.Array<T> array) {
        if (this.b == null) {
            this.b = new com.badlogic.gdx.utils.ComparableTimSort();
        }
        this.b.c(array.items, 0, array.size);
    }

    public <T> void sort(com.badlogic.gdx.utils.Array<T> array, java.util.Comparator<? super T> comparator) {
        if (this.a == null) {
            this.a = new com.badlogic.gdx.utils.TimSort();
        }
        this.a.c(array.items, comparator, 0, array.size);
    }

    public <T> void sort(T[] tArr) {
        if (this.b == null) {
            this.b = new com.badlogic.gdx.utils.ComparableTimSort();
        }
        this.b.c(tArr, 0, tArr.length);
    }

    public <T> void sort(T[] tArr, int i, int i2) {
        if (this.b == null) {
            this.b = new com.badlogic.gdx.utils.ComparableTimSort();
        }
        this.b.c(tArr, i, i2);
    }

    public <T> void sort(T[] tArr, java.util.Comparator<? super T> comparator) {
        if (this.a == null) {
            this.a = new com.badlogic.gdx.utils.TimSort();
        }
        this.a.c(tArr, comparator, 0, tArr.length);
    }

    public <T> void sort(T[] tArr, java.util.Comparator<? super T> comparator, int i, int i2) {
        if (this.a == null) {
            this.a = new com.badlogic.gdx.utils.TimSort();
        }
        this.a.c(tArr, comparator, i, i2);
    }
}
