package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_er implements com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener {
    public final /* synthetic */ int jad_s_an;
    public final /* synthetic */ android.view.View jad_s_bo;
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_cp;

    public class jad_s_an implements com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener {
        public jad_s_an() {
        }

        @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener
        public void onAdCountdown(int i) {
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(com.jd.ad.sdk.jad_s_an.jad_s_er.this.jad_s_cp, i);
        }
    }

    public class jad_s_bo implements java.lang.Runnable {
        public jad_s_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView;
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = com.jd.ad.sdk.jad_s_an.jad_s_er.this.jad_s_cp;
            android.view.View view = jad_s_anVar.jad_s_jt;
            if (view == null || (jADSplashSkipView = (com.jd.ad.sdk.splash.JADSplashSkipView) view.findViewById(com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(jad_s_anVar.jad_s_an(), "jad_splash_skip_btn", "id"))) == null) {
                return;
            }
            com.jd.ad.sdk.fdt.utils.HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_s_an.jad_s_bo(jad_s_anVar, jADSplashSkipView));
        }
    }

    public jad_s_er(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, int i, android.view.View view) {
        this.jad_s_cp = jad_s_anVar;
        this.jad_s_an = i;
        this.jad_s_bo = view;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j, java.lang.String str, int i) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(i);
        }
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_cp, this.jad_s_bo, true, str, i, this.jad_s_an);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(java.lang.String str) {
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_cp, this.jad_s_bo, false, str, com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex(), this.jad_s_an);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
        com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView;
        if (this.jad_s_an != 1 || (jADSplashSkipView = this.jad_s_cp.jad_s_kx) == null) {
            return;
        }
        jADSplashSkipView.removeCallbacks(null);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(java.lang.String str) {
        int i = this.jad_s_an;
        if (i == 3) {
            android.view.View view = this.jad_s_bo;
            if (view != null && (view instanceof com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView)) {
                ((com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView) view).play();
                if (this.jad_s_cp.jad_s_ly != null) {
                    ((com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView) this.jad_s_bo).startCount(new com.jd.ad.sdk.jad_s_an.jad_s_er.jad_s_an());
                }
            }
        } else if (i == 1) {
            if (this.jad_s_cp.jad_s_ob) {
                android.view.View view2 = this.jad_s_bo;
                if (view2 != null && (view2 instanceof com.jd.ad.sdk.bl.video.VideoRenderView)) {
                    ((com.jd.ad.sdk.bl.video.VideoRenderView) view2).play();
                }
            } else {
                com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_s_an.jad_s_er.jad_s_bo());
            }
        }
        com.jd.ad.sdk.dl.model.JADSlot jADSlot = this.jad_s_cp.jad_s_bo;
        if (jADSlot != null) {
            jADSlot.setImm(com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_cp, this.jad_s_bo, false, str, com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex(), this.jad_s_an);
    }
}
