package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public final /* synthetic */ class jad_tg {
    public static android.graphics.Paint.Join jad_an(int i) {
        int[] iArr = com.jd.ad.sdk.jad_sb.jad_re.jad_an.jad_bo;
        if (i == 0) {
            throw null;
        }
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            return android.graphics.Paint.Join.BEVEL;
        }
        if (i2 == 2) {
            return android.graphics.Paint.Join.MITER;
        }
        if (i2 != 3) {
            return null;
        }
        return android.graphics.Paint.Join.ROUND;
    }
}
