package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public class jad_ly {
    public final int jad_an;
    public final com.jd.ad.sdk.jad_zm.jad_fs jad_bo;
    public final int jad_cp;
    public final int jad_dq;
    public final java.lang.String jad_er;
    public final com.jd.ad.sdk.jad_zm.jad_er jad_fs;
    public final com.jd.ad.sdk.jad_zm.jad_ly.jad_an jad_hu;
    public final boolean jad_jt;

    public interface jad_an {
        void jad_an(int i, java.lang.String str);

        void jad_an(com.jd.ad.sdk.jad_zm.jad_mz jad_mzVar);
    }

    public static class jad_bo {
        public int jad_an;
        public com.jd.ad.sdk.jad_zm.jad_fs jad_bo;
        public int jad_cp;
        public int jad_dq;
        public java.lang.String jad_er;
        public com.jd.ad.sdk.jad_zm.jad_er jad_fs;
        public boolean jad_hu;
        public com.jd.ad.sdk.jad_zm.jad_ly.jad_an jad_jt;

        public void jad_an(java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            com.jd.ad.sdk.jad_zm.jad_ly jad_lyVar = new com.jd.ad.sdk.jad_zm.jad_ly(this);
            com.jd.ad.sdk.jad_zm.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_zm.jad_cp(jad_lyVar);
            jad_cpVar.jad_cp = new com.jd.ad.sdk.jad_zm.jad_jw(jad_lyVar);
            threadPoolExecutor.execute(jad_cpVar);
        }
    }

    public jad_ly(com.jd.ad.sdk.jad_zm.jad_ly.jad_bo jad_boVar) {
        this.jad_an = jad_boVar.jad_an;
        this.jad_bo = jad_boVar.jad_bo;
        this.jad_cp = jad_boVar.jad_cp;
        this.jad_dq = jad_boVar.jad_dq;
        this.jad_er = jad_boVar.jad_er;
        this.jad_fs = jad_boVar.jad_fs;
        this.jad_jt = jad_boVar.jad_hu;
        this.jad_hu = jad_boVar.jad_jt;
    }

    public java.lang.String jad_an() {
        return this.jad_er;
    }
}
