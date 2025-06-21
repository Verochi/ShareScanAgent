package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public final class jad_jt {
    public static final double jad_an = 1.0d / java.lang.Math.pow(10.0d, 6.0d);

    public static double jad_an(long j) {
        return (jad_an() - j) * jad_an;
    }

    @android.annotation.TargetApi(17)
    public static long jad_an() {
        return android.os.SystemClock.elapsedRealtimeNanos();
    }
}
