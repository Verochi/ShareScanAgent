package com.jd.ad.sdk.jad_zk;

/* loaded from: classes23.dex */
public final class jad_er implements com.jd.ad.sdk.jad_zk.jad_cp {
    public final android.content.Context jad_an;
    public final com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_bo;

    public jad_er(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_anVar) {
        this.jad_an = context.getApplicationContext();
        this.jad_bo = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_an() {
        com.jd.ad.sdk.jad_zk.jad_sf jad_an = com.jd.ad.sdk.jad_zk.jad_sf.jad_an(this.jad_an);
        com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_anVar = this.jad_bo;
        synchronized (jad_an) {
            jad_an.jad_bo.remove(jad_anVar);
            if (jad_an.jad_cp && jad_an.jad_bo.isEmpty()) {
                jad_an.jad_an.jad_an();
                jad_an.jad_cp = false;
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_cp() {
        com.jd.ad.sdk.jad_zk.jad_sf jad_an = com.jd.ad.sdk.jad_zk.jad_sf.jad_an(this.jad_an);
        com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_anVar = this.jad_bo;
        synchronized (jad_an) {
            jad_an.jad_bo.add(jad_anVar);
            if (!jad_an.jad_cp && !jad_an.jad_bo.isEmpty()) {
                jad_an.jad_cp = jad_an.jad_an.jad_bo();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_dq() {
    }
}
