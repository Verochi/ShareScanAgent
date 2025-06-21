package com.jd.ad.sdk.jad_xg;

/* loaded from: classes23.dex */
public class jad_jt {
    public static final android.graphics.PointF jad_an = new android.graphics.PointF();

    public static float jad_an(float f, float f2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static int jad_an(float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        int i3 = i / i2;
        int i4 = i % i2;
        if (!((i ^ i2) >= 0) && i4 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }

    public static android.graphics.PointF jad_an(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        return new android.graphics.PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, java.util.List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2, com.jd.ad.sdk.jad_nw.jad_kx jad_kxVar) {
        if (jad_erVar.jad_an(jad_kxVar.jad_cp(), i)) {
            list.add(jad_erVar2.jad_an(jad_kxVar.jad_cp()).jad_an(jad_kxVar));
        }
    }
}
