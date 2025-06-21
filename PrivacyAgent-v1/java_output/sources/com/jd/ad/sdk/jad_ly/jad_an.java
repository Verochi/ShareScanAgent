package com.jd.ad.sdk.jad_ly;

/* loaded from: classes23.dex */
public class jad_an implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String jad_an;
    public final /* synthetic */ com.jd.ad.sdk.bl.video.listener.VideoLoadListener jad_bo;
    public final /* synthetic */ android.content.Context jad_cp;
    public final /* synthetic */ java.lang.String jad_dq;
    public final /* synthetic */ com.jd.ad.sdk.jad_ly.jad_bo jad_er;

    /* renamed from: com.jd.ad.sdk.jad_ly.jad_an$jad_an, reason: collision with other inner class name */
    public class C0390jad_an implements com.jd.ad.sdk.jad_zm.jad_ly.jad_an {
        public C0390jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i, java.lang.String str) {
            com.jd.ad.sdk.logger.Logger.d("load video Ad response body is onRequestFailed:code: " + i + " ,error:" + str);
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(com.jd.ad.sdk.jad_zm.jad_mz jad_mzVar) {
            java.io.BufferedInputStream bufferedInputStream;
            try {
                int i = jad_mzVar.jad_an;
                if (i != 200) {
                    com.jd.ad.sdk.jad_ly.jad_an jad_anVar = com.jd.ad.sdk.jad_ly.jad_an.this;
                    jad_anVar.jad_er.jad_an(jad_anVar.jad_bo, i, "error code: " + jad_mzVar.jad_an);
                    com.jd.ad.sdk.jad_zm.jad_ob jad_obVar = jad_mzVar.jad_cp;
                    com.jd.ad.sdk.logger.Logger.d("【load】loadAd error code:" + jad_mzVar.jad_an + ",msg=" + (jad_obVar != null ? jad_obVar.jad_bo() : ""));
                    return;
                }
                com.jd.ad.sdk.jad_zm.jad_ob jad_obVar2 = jad_mzVar.jad_cp;
                if (jad_obVar2 != null && (bufferedInputStream = jad_obVar2.jad_bo) != null) {
                    com.jd.ad.sdk.jad_ly.jad_an jad_anVar2 = com.jd.ad.sdk.jad_ly.jad_an.this;
                    java.lang.String jad_an = com.jd.ad.sdk.jad_ly.jad_bo.jad_an(jad_anVar2.jad_er, jad_anVar2.jad_cp, bufferedInputStream, jad_anVar2.jad_an);
                    if (android.text.TextUtils.isEmpty(jad_an)) {
                        return;
                    }
                    com.jd.ad.sdk.jad_ly.jad_an jad_anVar3 = com.jd.ad.sdk.jad_ly.jad_an.this;
                    com.jd.ad.sdk.jad_ly.jad_bo jad_boVar = jad_anVar3.jad_er;
                    if (jad_boVar.jad_an == null) {
                        jad_boVar.jad_an = new com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper(jad_anVar3.jad_cp, jad_anVar3.jad_dq);
                    }
                    com.jd.ad.sdk.jad_ly.jad_an jad_anVar4 = com.jd.ad.sdk.jad_ly.jad_an.this;
                    jad_anVar4.jad_er.jad_an.updateVideoData(jad_anVar4.jad_dq, jad_anVar4.jad_an, jad_an);
                    com.jd.ad.sdk.bl.video.listener.VideoLoadListener videoLoadListener = com.jd.ad.sdk.jad_ly.jad_an.this.jad_bo;
                    if (videoLoadListener != null) {
                        videoLoadListener.onLoadSuccess();
                        return;
                    }
                    return;
                }
                com.jd.ad.sdk.logger.Logger.d("loadAd response body is null");
                com.jd.ad.sdk.jad_ly.jad_an jad_anVar5 = com.jd.ad.sdk.jad_ly.jad_an.this;
                com.jd.ad.sdk.jad_ly.jad_bo jad_boVar2 = jad_anVar5.jad_er;
                com.jd.ad.sdk.bl.video.listener.VideoLoadListener videoLoadListener2 = jad_anVar5.jad_bo;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_VIDEO_BODY_NULL_ERROR;
                jad_boVar2.jad_an(videoLoadListener2, jad_anVar6.jad_an, jad_anVar6.jad_an(new java.lang.String[0]));
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.d("Exception load video ad  exception:" + e);
            }
        }
    }

    public jad_an(com.jd.ad.sdk.jad_ly.jad_bo jad_boVar, java.lang.String str, com.jd.ad.sdk.bl.video.listener.VideoLoadListener videoLoadListener, android.content.Context context, java.lang.String str2) {
        this.jad_er = jad_boVar;
        this.jad_an = str;
        this.jad_bo = videoLoadListener;
        this.jad_cp = context;
        this.jad_dq = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        com.jd.ad.sdk.jad_zm.jad_ly.jad_bo jad_boVar = new com.jd.ad.sdk.jad_zm.jad_ly.jad_bo();
        jad_boVar.jad_an = 1;
        jad_boVar.jad_er = this.jad_an;
        jad_boVar.jad_bo = jad_fsVar;
        jad_boVar.jad_cp = jad_cp == null ? 5000 : (int) jad_cp.jad_dq;
        jad_boVar.jad_dq = jad_cp != null ? (int) jad_cp.jad_dq : 5000;
        jad_boVar.jad_jt = new com.jd.ad.sdk.jad_ly.jad_an.C0390jad_an();
        jad_boVar.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_dq);
    }
}
