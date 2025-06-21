package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class QuickSelect<T> {
    public T[] a;
    public java.util.Comparator<? super T> b;

    public final int a(int i, int i2) {
        T[] tArr = this.a;
        T t = tArr[i];
        int i3 = (i + i2) / 2;
        T t2 = tArr[i3];
        T t3 = tArr[i2];
        return this.b.compare(t, t2) > 0 ? this.b.compare(t2, t3) > 0 ? i3 : this.b.compare(t, t3) > 0 ? i2 : i : this.b.compare(t, t3) > 0 ? i : this.b.compare(t2, t3) > 0 ? i2 : i3;
    }

    public final int b(int i, int i2, int i3) {
        T t = this.a[i3];
        d(i2, i3);
        int i4 = i;
        while (i < i2) {
            if (this.b.compare(this.a[i], t) < 0) {
                d(i4, i);
                i4++;
            }
            i++;
        }
        d(i2, i4);
        return i4;
    }

    public final int c(int i, int i2, int i3) {
        if (i == i2) {
            return i;
        }
        int b = b(i, i2, a(i, i2));
        int i4 = (b - i) + 1;
        return i4 == i3 ? b : i3 < i4 ? c(i, b - 1, i3) : c(b + 1, i2, i3 - i4);
    }

    public final void d(int i, int i2) {
        T[] tArr = this.a;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int select(T[] tArr, java.util.Comparator<T> comparator, int i, int i2) {
        this.a = tArr;
        this.b = comparator;
        return c(0, i2 - 1, i);
    }
}
