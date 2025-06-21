package com.jd.ad.sdk.jad_jt;

/* loaded from: classes23.dex */
public class jad_bo implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.dl.model.JADSlot jad_an;
    public final /* synthetic */ java.lang.String jad_bo;
    public final /* synthetic */ com.jd.ad.sdk.bl.adload.JADAdLoadListener jad_cp;
    public final /* synthetic */ com.jd.ad.sdk.jad_jt.jad_jt jad_dq;

    public class jad_an implements java.lang.Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_jt.jad_bo jad_boVar = com.jd.ad.sdk.jad_jt.jad_bo.this;
            com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener = jad_boVar.jad_cp;
            if (jADAdLoadListener == null) {
                return;
            }
            com.jd.ad.sdk.jad_jt.jad_jt.jad_an(jad_boVar.jad_dq, jADAdLoadListener, jad_boVar.jad_an.getAdDataRequestSourceType());
        }
    }

    public jad_bo(com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar, com.jd.ad.sdk.dl.model.JADSlot jADSlot, java.lang.String str, com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener) {
        this.jad_dq = jad_jtVar;
        this.jad_an = jADSlot;
        this.jad_bo = str;
        this.jad_cp = jADAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.List<com.jd.ad.sdk.jad_yl.jad_dq> list;
        com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
        com.jd.ad.sdk.jad_yl.jad_cp jad_cpVar;
        try {
            com.jd.ad.sdk.jad_jt.jad_jt.jad_an(this.jad_dq, this.jad_an);
            java.lang.String jad_an2 = com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_an(com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId() + this.jad_an.getSlotID());
            if (android.text.TextUtils.isEmpty(jad_an2)) {
                return;
            }
            com.jd.ad.sdk.jad_jt.jad_jt.jad_bo(this.jad_dq, this.jad_an);
            if (this.jad_an.getDynamicRenderTemplateHelper() != null) {
                this.jad_an.getDynamicRenderTemplateHelper().jad_an(jad_an2);
            }
            com.jd.ad.sdk.jad_yl.jad_jt jad_an3 = com.jd.ad.sdk.jad_yl.jad_jt.jad_an(jad_an2);
            com.jd.ad.sdk.jad_yl.jad_hu jad_huVar = jad_an3.jad_cp;
            if (jad_huVar != null && (list = jad_huVar.jad_an) != null && list.size() > 0 && (jad_dqVar = jad_an3.jad_cp.jad_an.get(0)) != null && (jad_cpVar = jad_dqVar.jad_bo) != null) {
                this.jad_an.setTemplateId(jad_cpVar.jad_dq);
                this.jad_an.setMediaSpecSetType(jad_dqVar.jad_bo.jad_cp);
                this.jad_an.setEventInteractionType(jad_dqVar.jad_bo.jad_er);
                this.jad_an.setModelClickAreaType(jad_dqVar.jad_bo.jad_fs);
            }
            com.jd.ad.sdk.jad_jt.jad_jt.jad_an(this.jad_dq, this.jad_bo, jad_an2);
            com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_jt.jad_bo.jad_an());
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while preload ad load from cache failed:");
            jad_an4.append(android.util.Log.getStackTraceString(e));
            com.jd.ad.sdk.logger.Logger.d(jad_an4.toString());
        }
    }
}
