package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class Select {
    public static com.badlogic.gdx.utils.Select b;
    public com.badlogic.gdx.utils.QuickSelect a;

    public static com.badlogic.gdx.utils.Select instance() {
        if (b == null) {
            b = new com.badlogic.gdx.utils.Select();
        }
        return b;
    }

    public final <T> int a(T[] tArr, java.util.Comparator<T> comparator, int i) {
        int i2 = 0;
        for (int i3 = 1; i3 < i; i3++) {
            if (comparator.compare(tArr[i3], tArr[i2]) > 0) {
                i2 = i3;
            }
        }
        return i2;
    }

    public final <T> int b(T[] tArr, java.util.Comparator<T> comparator, int i) {
        int i2 = 0;
        for (int i3 = 1; i3 < i; i3++) {
            if (comparator.compare(tArr[i3], tArr[i2]) < 0) {
                i2 = i3;
            }
        }
        return i2;
    }

    public <T> T select(T[] tArr, java.util.Comparator<T> comparator, int i, int i2) {
        return tArr[selectIndex(tArr, comparator, i, i2)];
    }

    public <T> int selectIndex(T[] tArr, java.util.Comparator<T> comparator, int i, int i2) {
        if (i2 < 1) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("cannot select from empty array (size < 1)");
        }
        if (i > i2) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Kth rank is larger than size. k: " + i + ", size: " + i2);
        }
        if (i == 1) {
            return b(tArr, comparator, i2);
        }
        if (i == i2) {
            return a(tArr, comparator, i2);
        }
        if (this.a == null) {
            this.a = new com.badlogic.gdx.utils.QuickSelect();
        }
        return this.a.select(tArr, comparator, i, i2);
    }
}
