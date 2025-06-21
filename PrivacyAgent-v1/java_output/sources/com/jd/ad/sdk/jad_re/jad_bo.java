package com.jd.ad.sdk.jad_re;

/* loaded from: classes23.dex */
public class jad_bo implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig jad_an;

    public jad_bo(com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig jADYunSdkConfig) {
        this.jad_an = jADYunSdkConfig;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.getClass();
        com.jd.ad.sdk.jad_uh.jad_bo jad_boVar = com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an;
        jad_boVar.getClass();
        if (com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
            jad_boVar.jad_cp = com.jd.ad.sdk.jad_uh.jad_dq.jad_an("jadyunsdk");
            jad_boVar.jad_bo.readLock().lock();
            try {
                java.util.Map<java.lang.String, ?> all = jad_boVar.jad_cp.jad_an.getAll();
                if (all != null && !all.isEmpty()) {
                    jad_boVar.jad_an.putAll(all);
                }
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_LOAD_DISC_TO_MEMORY_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            } finally {
                jad_boVar.jad_bo.readLock().unlock();
            }
        }
        com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("AppId", this.jad_an.getAppId());
    }
}
