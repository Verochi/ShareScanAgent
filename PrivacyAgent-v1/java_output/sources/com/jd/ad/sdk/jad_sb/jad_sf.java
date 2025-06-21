package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public final /* synthetic */ class jad_sf {
    public static android.graphics.Paint.Cap jad_an(int i) {
        int[] iArr = com.jd.ad.sdk.jad_sb.jad_re.jad_an.jad_an;
        if (i == 0) {
            throw null;
        }
        int i2 = iArr[i - 1];
        return i2 != 1 ? i2 != 2 ? android.graphics.Paint.Cap.SQUARE : android.graphics.Paint.Cap.ROUND : android.graphics.Paint.Cap.BUTT;
    }
}
