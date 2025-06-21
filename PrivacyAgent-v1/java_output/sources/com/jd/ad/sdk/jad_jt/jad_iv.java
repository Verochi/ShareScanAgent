package com.jd.ad.sdk.jad_jt;

/* loaded from: classes23.dex */
public class jad_iv {
    public static int jad_an(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return (int) (new java.math.BigDecimal(java.lang.String.valueOf(i)).divide(new java.math.BigDecimal(java.lang.String.valueOf(i2)), 2, java.math.RoundingMode.HALF_UP).floatValue() * 100.0f);
    }
}
