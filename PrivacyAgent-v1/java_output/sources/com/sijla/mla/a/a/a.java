package com.sijla.mla.a.a;

/* loaded from: classes19.dex */
public class a extends com.sijla.mla.a.e {
    public static int a(int i, int i2, int i3) {
        return (i & 63) | ((i2 << 6) & 16320) | ((i3 << 14) & (-16384));
    }

    public static int a(int i, int i2, int i3, int i4) {
        return (i & 63) | ((i2 << 6) & 16320) | ((i3 << 23) & (-8388608)) | ((i4 << 14) & 8372224);
    }

    public static void a(com.sijla.mla.a.a.d dVar, int i) {
        dVar.a(((i << 6) & 16320) | (dVar.a() & (-16321)));
    }

    public static void a(boolean z) {
        if (!z) {
            throw new com.sijla.mla.a.i("compiler assert failed");
        }
    }

    public static void a(int[] iArr, int i, int i2) {
        iArr[i] = ((i2 << 6) & 16320) | (iArr[i] & (-16321));
    }

    public static char[] a(char[] cArr, int i) {
        char[] cArr2 = new char[i];
        if (cArr != null) {
            java.lang.System.arraycopy(cArr, 0, cArr2, 0, java.lang.Math.min(cArr.length, i));
        }
        return cArr2;
    }

    public static int[] a(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        if (iArr != null) {
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, java.lang.Math.min(iArr.length, i));
        }
        return iArr2;
    }

    public static com.sijla.h.f[] a(com.sijla.h.f[] fVarArr, int i) {
        com.sijla.h.f[] fVarArr2 = new com.sijla.h.f[i];
        if (fVarArr != null) {
            java.lang.System.arraycopy(fVarArr, 0, fVarArr2, 0, java.lang.Math.min(fVarArr.length, i));
        }
        return fVarArr2;
    }

    public static com.sijla.mla.a.a.f.d[] a(com.sijla.mla.a.a.f.d[] dVarArr, int i) {
        if (dVarArr == null) {
            return new com.sijla.mla.a.a.f.d[2];
        }
        if (dVarArr.length >= i) {
            return dVarArr;
        }
        int length = dVarArr.length << 1;
        com.sijla.mla.a.a.f.d[] dVarArr2 = new com.sijla.mla.a.a.f.d[length];
        java.lang.System.arraycopy(dVarArr, 0, dVarArr2, 0, java.lang.Math.min(dVarArr.length, length));
        return dVarArr2;
    }

    public static com.sijla.mla.a.r[] a(com.sijla.mla.a.r[] rVarArr, int i) {
        com.sijla.mla.a.r[] rVarArr2 = new com.sijla.mla.a.r[i];
        if (rVarArr != null) {
            java.lang.System.arraycopy(rVarArr, 0, rVarArr2, 0, java.lang.Math.min(rVarArr.length, i));
        }
        return rVarArr2;
    }

    public static com.sijla.mla.a.w[] a(com.sijla.mla.a.w[] wVarArr, int i) {
        com.sijla.mla.a.w[] wVarArr2 = new com.sijla.mla.a.w[i];
        if (wVarArr != null) {
            java.lang.System.arraycopy(wVarArr, 0, wVarArr2, 0, java.lang.Math.min(wVarArr.length, i));
        }
        return wVarArr2;
    }

    public static com.sijla.mla.b[] a(com.sijla.mla.b[] bVarArr, int i) {
        com.sijla.mla.b[] bVarArr2 = new com.sijla.mla.b[i];
        if (bVarArr != null) {
            java.lang.System.arraycopy(bVarArr, 0, bVarArr2, 0, java.lang.Math.min(bVarArr.length, i));
        }
        return bVarArr2;
    }

    public static void b(com.sijla.mla.a.a.d dVar, int i) {
        dVar.a(((i << 23) & (-8388608)) | (dVar.a() & 8388607));
    }

    public static void c(com.sijla.mla.a.a.d dVar, int i) {
        dVar.a(((i << 14) & 8372224) | (dVar.a() & (-8372225)));
    }
}
