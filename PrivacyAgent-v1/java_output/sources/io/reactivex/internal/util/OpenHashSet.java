package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class OpenHashSet<T> {
    public final float a;
    public int b;
    public int c;
    public int d;
    public T[] e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i) {
        this(i, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.a = f;
        int roundToPowerOfTwo = io.reactivex.internal.util.Pow2.roundToPowerOfTwo(i);
        this.b = roundToPowerOfTwo - 1;
        this.d = (int) (f * roundToPowerOfTwo);
        this.e = (T[]) new java.lang.Object[roundToPowerOfTwo];
    }

    public static int a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int a = a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a = (a + 1) & i;
                t2 = tArr[a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a] = t;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.d) {
            b();
        }
        return true;
    }

    public void b() {
        T t;
        T[] tArr = this.e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new java.lang.Object[i];
        int i3 = this.c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.b = i2;
                this.d = (int) (i * this.a);
                this.e = tArr2;
                return;
            }
            do {
                length--;
                t = tArr[length];
            } while (t == null);
            int a = a(t.hashCode()) & i2;
            if (tArr2[a] != null) {
                do {
                    a = (a + 1) & i2;
                } while (tArr2[a] != null);
            }
            tArr2[a] = tArr[length];
            i3 = i4;
        }
    }

    public boolean c(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a = a(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= a && a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < a && a <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public java.lang.Object[] keys() {
        return this.e;
    }

    public boolean remove(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int a = a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return c(a, tArr, i);
        }
        do {
            a = (a + 1) & i;
            t2 = tArr[a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return c(a, tArr, i);
    }

    public int size() {
        return this.c;
    }
}
