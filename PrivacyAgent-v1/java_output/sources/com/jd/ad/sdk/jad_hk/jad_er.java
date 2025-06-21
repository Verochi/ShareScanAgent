package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_er {
    static {
        java.util.logging.Logger.getLogger(com.jd.ad.sdk.jad_hk.jad_er.class.getName());
    }

    public static com.jd.ad.sdk.jad_hk.jad_mz jad_an(java.io.InputStream inputStream) {
        com.jd.ad.sdk.jad_hk.jad_na jad_naVar = new com.jd.ad.sdk.jad_hk.jad_na();
        if (inputStream != null) {
            return new com.jd.ad.sdk.jad_hk.jad_dq(jad_naVar, inputStream);
        }
        throw new java.lang.IllegalArgumentException("in == null");
    }
}
