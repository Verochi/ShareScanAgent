package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public class jad_do implements com.jd.ad.sdk.jad_kv.jad_dq.jad_an<java.lang.Object> {
    public final /* synthetic */ com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an;
    public final /* synthetic */ com.jd.ad.sdk.jad_mx.jad_ep jad_bo;

    public jad_do(com.jd.ad.sdk.jad_mx.jad_ep jad_epVar, com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_anVar) {
        this.jad_bo = jad_epVar;
        this.jad_an = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(@androidx.annotation.NonNull java.lang.Exception exc) {
        com.jd.ad.sdk.jad_mx.jad_ep jad_epVar = this.jad_bo;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = this.jad_an;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar2 = jad_epVar.jad_fs;
        if (jad_anVar2 != null && jad_anVar2 == jad_anVar) {
            com.jd.ad.sdk.jad_mx.jad_ep jad_epVar2 = this.jad_bo;
            com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_anVar3 = this.jad_an;
            com.jd.ad.sdk.jad_mx.jad_fs.jad_an jad_anVar4 = jad_epVar2.jad_bo;
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = jad_epVar2.jad_jt;
            com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_dqVar = jad_anVar3.jad_cp;
            jad_anVar4.jad_an(jad_huVar, exc, jad_dqVar, jad_dqVar.jad_dq());
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(@androidx.annotation.Nullable java.lang.Object obj) {
        com.jd.ad.sdk.jad_mx.jad_ep jad_epVar = this.jad_bo;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar = this.jad_an;
        com.jd.ad.sdk.jad_qb.jad_na.jad_an<?> jad_anVar2 = jad_epVar.jad_fs;
        if (jad_anVar2 != null && jad_anVar2 == jad_anVar) {
            com.jd.ad.sdk.jad_mx.jad_ep jad_epVar2 = this.jad_bo;
            com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_anVar3 = this.jad_an;
            com.jd.ad.sdk.jad_mx.jad_ly jad_lyVar = jad_epVar2.jad_an.jad_pc;
            if (obj != null && jad_lyVar.jad_an(jad_anVar3.jad_cp.jad_dq())) {
                jad_epVar2.jad_er = obj;
                jad_epVar2.jad_bo.jad_bo();
            } else {
                com.jd.ad.sdk.jad_mx.jad_fs.jad_an jad_anVar4 = jad_epVar2.jad_bo;
                com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = jad_anVar3.jad_an;
                com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_dqVar = jad_anVar3.jad_cp;
                jad_anVar4.jad_an(jad_huVar, obj, jad_dqVar, jad_dqVar.jad_dq(), jad_epVar2.jad_jt);
            }
        }
    }
}
