package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public class jad_iv {
    public static java.lang.String jad_an(double d) {
        float log;
        double random = (float) java.lang.Math.random();
        if (random <= 0.5d) {
            log = (float) (java.lang.Math.log(1.0f - r0) * (-0.001f));
        } else {
            log = (float) (java.lang.Math.log(random) * 0.001f);
        }
        try {
            return new java.text.DecimalFormat("0.000000").format(log + d);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }
}
