package com.jd.ad.sdk.jad_lo;

/* loaded from: classes23.dex */
public class jad_er {
    public static com.jd.ad.sdk.jad_lo.jad_er jad_an;

    public static com.jd.ad.sdk.jad_lo.jad_er jad_an() {
        if (jad_an == null) {
            synchronized (com.jd.ad.sdk.jad_lo.jad_er.class) {
                if (jad_an == null) {
                    jad_an = new com.jd.ad.sdk.jad_lo.jad_er();
                }
            }
        }
        return jad_an;
    }
}
