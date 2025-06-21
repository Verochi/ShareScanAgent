package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_kx {

    @androidx.annotation.Nullable
    public static com.jd.ad.sdk.jad_hk.jad_jw jad_an;
    public static long jad_bo;

    public static com.jd.ad.sdk.jad_hk.jad_jw jad_an() {
        synchronized (com.jd.ad.sdk.jad_hk.jad_kx.class) {
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = jad_an;
            if (jad_jwVar == null) {
                return new com.jd.ad.sdk.jad_hk.jad_jw();
            }
            jad_an = jad_jwVar.jad_fs;
            jad_jwVar.jad_fs = null;
            jad_bo -= 8192;
            return jad_jwVar;
        }
    }

    public static void jad_an(com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar) {
        if (jad_jwVar.jad_fs != null || jad_jwVar.jad_jt != null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (jad_jwVar.jad_dq) {
            return;
        }
        synchronized (com.jd.ad.sdk.jad_hk.jad_kx.class) {
            long j = jad_bo + 8192;
            if (j > 65536) {
                return;
            }
            jad_bo = j;
            jad_jwVar.jad_fs = jad_an;
            jad_jwVar.jad_cp = 0;
            jad_jwVar.jad_bo = 0;
            jad_an = jad_jwVar;
        }
    }
}
