package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class EarClippingTriangulator {
    public short[] b;
    public float[] c;
    public int d;
    public final com.badlogic.gdx.utils.ShortArray a = new com.badlogic.gdx.utils.ShortArray();
    public final com.badlogic.gdx.utils.IntArray e = new com.badlogic.gdx.utils.IntArray();
    public final com.badlogic.gdx.utils.ShortArray f = new com.badlogic.gdx.utils.ShortArray();

    public static boolean a(float[] fArr, int i, int i2) {
        if (i2 <= 2) {
            return false;
        }
        int i3 = i2 + i;
        int i4 = i3 - 3;
        int i5 = i;
        float f = 0.0f;
        while (i5 < i4) {
            int i6 = i5 + 2;
            f += (fArr[i5] * fArr[i5 + 3]) - (fArr[i6] * fArr[i5 + 1]);
            i5 = i6;
        }
        return (f + (fArr[i3 + (-2)] * fArr[i + 1])) - (fArr[i] * fArr[i3 - 1]) < 0.0f;
    }

    public static int c(float f, float f2, float f3, float f4, float f5, float f6) {
        return (int) java.lang.Math.signum((f * (f6 - f4)) + (f3 * (f2 - f6)) + (f5 * (f4 - f2)));
    }

    public final int b(int i) {
        short[] sArr = this.b;
        int i2 = sArr[h(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[g(i)] * 2;
        float[] fArr = this.c;
        return c(fArr[i2], fArr[i2 + 1], fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1]);
    }

    public com.badlogic.gdx.utils.ShortArray computeTriangles(com.badlogic.gdx.utils.FloatArray floatArray) {
        return computeTriangles(floatArray.items, 0, floatArray.size);
    }

    public com.badlogic.gdx.utils.ShortArray computeTriangles(float[] fArr) {
        return computeTriangles(fArr, 0, fArr.length);
    }

    public com.badlogic.gdx.utils.ShortArray computeTriangles(float[] fArr, int i, int i2) {
        this.c = fArr;
        int i3 = i2 / 2;
        this.d = i3;
        int i4 = i / 2;
        com.badlogic.gdx.utils.ShortArray shortArray = this.a;
        shortArray.clear();
        shortArray.ensureCapacity(i3);
        shortArray.size = i3;
        short[] sArr = shortArray.items;
        this.b = sArr;
        if (a(fArr, i, i2)) {
            for (short s2 = 0; s2 < i3; s2 = (short) (s2 + 1)) {
                sArr[s2] = (short) (i4 + s2);
            }
        } else {
            int i5 = i3 - 1;
            for (int i6 = 0; i6 < i3; i6++) {
                sArr[i6] = (short) ((i4 + i5) - i6);
            }
        }
        com.badlogic.gdx.utils.IntArray intArray = this.e;
        intArray.clear();
        intArray.ensureCapacity(i3);
        for (int i7 = 0; i7 < i3; i7++) {
            intArray.add(b(i7));
        }
        com.badlogic.gdx.utils.ShortArray shortArray2 = this.f;
        shortArray2.clear();
        shortArray2.ensureCapacity(java.lang.Math.max(0, i3 - 2) * 3);
        i();
        return shortArray2;
    }

    public final void d(int i) {
        short[] sArr = this.b;
        com.badlogic.gdx.utils.ShortArray shortArray = this.f;
        shortArray.add(sArr[h(i)]);
        shortArray.add(sArr[i]);
        shortArray.add(sArr[g(i)]);
        this.a.removeIndex(i);
        this.e.removeIndex(i);
        this.d--;
    }

    public final int e() {
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (f(i2)) {
                return i2;
            }
        }
        int[] iArr = this.e.items;
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] != -1) {
                return i3;
            }
        }
        return 0;
    }

    public final boolean f(int i) {
        int[] iArr = this.e.items;
        if (iArr[i] == -1) {
            return false;
        }
        int h = h(i);
        int g = g(i);
        short[] sArr = this.b;
        int i2 = sArr[h] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[g] * 2;
        float[] fArr = this.c;
        float f = fArr[i2];
        int i5 = 1;
        float f2 = fArr[i2 + 1];
        float f3 = fArr[i3];
        float f4 = fArr[i3 + 1];
        float f5 = fArr[i4];
        float f6 = fArr[i4 + 1];
        int g2 = g(g);
        while (g2 != h) {
            if (iArr[g2] != i5) {
                int i6 = sArr[g2] * 2;
                float f7 = fArr[i6];
                float f8 = fArr[i6 + i5];
                if (c(f5, f6, f, f2, f7, f8) >= 0 && c(f, f2, f3, f4, f7, f8) >= 0 && c(f3, f4, f5, f6, f7, f8) >= 0) {
                    return false;
                }
            }
            g2 = g(g2);
            i5 = 1;
        }
        return true;
    }

    public final int g(int i) {
        return (i + 1) % this.d;
    }

    public final int h(int i) {
        if (i == 0) {
            i = this.d;
        }
        return i - 1;
    }

    public final void i() {
        int i;
        int[] iArr = this.e.items;
        while (true) {
            i = this.d;
            int i2 = 0;
            if (i <= 3) {
                break;
            }
            int e = e();
            d(e);
            int h = h(e);
            if (e != this.d) {
                i2 = e;
            }
            iArr[h] = b(h);
            iArr[i2] = b(i2);
        }
        if (i == 3) {
            com.badlogic.gdx.utils.ShortArray shortArray = this.f;
            short[] sArr = this.b;
            shortArray.add(sArr[0]);
            shortArray.add(sArr[1]);
            shortArray.add(sArr[2]);
        }
    }
}
