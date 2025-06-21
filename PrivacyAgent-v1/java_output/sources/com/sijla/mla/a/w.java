package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class w {
    private static final com.sijla.h.f[] m = new com.sijla.h.f[0];
    private static final com.sijla.mla.a.w[] n = new com.sijla.mla.a.w[0];
    public com.sijla.mla.a.r[] a;
    public int[] b;
    public int[] d;
    public com.sijla.mla.b[] e;
    public com.sijla.mla.a.n g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public com.sijla.mla.a.w[] c = n;
    public com.sijla.h.f[] f = m;

    public final com.sijla.mla.a.n a(int i, int i2) {
        int i3 = 0;
        while (true) {
            com.sijla.mla.b[] bVarArr = this.e;
            if (i3 >= bVarArr.length) {
                return null;
            }
            com.sijla.mla.b bVar = bVarArr[i3];
            if (bVar.b > i2) {
                return null;
            }
            if (i2 < bVar.c && i - 1 == 0) {
                return bVar.a;
            }
            i3++;
        }
    }

    public final java.lang.String a() {
        java.lang.String g = this.g.g();
        return (g.startsWith("@") || g.startsWith(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER)) ? g.substring(1) : g.startsWith("\u001b") ? "binary string" : g;
    }

    public final java.lang.String toString() {
        return this.g + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.h + com.sijla.mla.L2.s34103() + this.i;
    }
}
