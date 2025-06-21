package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_cp implements com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_cp(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void onVideoRenderFailed(int i, java.lang.String str) {
        try {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_VIDEO_FAIL_ERROR;
            com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_an.jad_s_er, jADError.getCode(), jad_s_anVar.jad_s_an(jADError.getMessage(new java.lang.String[0])), this.jad_s_an.jad_s_fs);
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, jADError.getCode(), jADError.getMessage(new java.lang.String[0]));
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(e));
        }
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void onVideoRenderSuccess(android.view.View view) {
        try {
            com.jd.ad.sdk.dl.error.JADError jADError = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError.getCode();
            java.lang.String message = jADError.getMessage(new java.lang.String[0]);
            if (view != null) {
                com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
                if (jad_s_anVar.jad_s_bo != null) {
                    jad_s_anVar.jad_s_iv = view;
                    jad_s_anVar.jad_s_an(view, 1);
                    return;
                }
            }
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.jad_s_an;
            eventService.reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code, message, jad_s_anVar2.jad_s_fs);
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, code, message);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar3 = this.jad_s_an;
            com.jd.ad.sdk.dl.error.JADError jADError2 = com.jd.ad.sdk.dl.error.JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar3, jADError2.getCode(), jADError2.getMessage(e.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void updateMaterialMetaPreload(boolean z) {
        this.jad_s_an.jad_s_na = z;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void videoPlayerError(int i, int i2, int i3, int i4, java.lang.String str) {
        com.jd.ad.sdk.splash.JADSplashVideoListener jADSplashVideoListener = this.jad_s_an.jad_s_mz;
        if (jADSplashVideoListener != null) {
            jADSplashVideoListener.onPlayerError(i, str);
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        if (jad_s_anVar.jad_s_pc == null) {
            jad_s_anVar.jad_s_pc = new com.jd.ad.sdk.jad_s_an.jad_s_jw(jad_s_anVar.jad_s_bo);
        }
        jad_s_anVar.jad_s_pc.reportVideoError(com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, i4), i2, i3);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void videoPlayerStatusChanged(int i, int i2) {
        com.jd.ad.sdk.splash.JADSplashVideoListener jADSplashVideoListener = this.jad_s_an.jad_s_mz;
        if (jADSplashVideoListener != null) {
            jADSplashVideoListener.onPlayerStatusChanged(i);
        }
        if (i != 0) {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
            if (jad_s_anVar.jad_s_pc == null) {
                jad_s_anVar.jad_s_pc = new com.jd.ad.sdk.jad_s_an.jad_s_jw(jad_s_anVar.jad_s_bo);
            }
            com.jd.ad.sdk.jad_s_an.jad_s_jw jad_s_jwVar = jad_s_anVar.jad_s_pc;
            float jad_s_an = com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, i2);
            jad_s_jwVar.getClass();
            switch (i) {
                case 1:
                    jad_s_jwVar.reportVideoWillStart();
                    break;
                case 2:
                    jad_s_jwVar.reportVideoPreloadCompleted();
                    break;
                case 3:
                    jad_s_jwVar.jad_s_an(3, jad_s_an);
                    break;
                case 4:
                    jad_s_jwVar.jad_s_an(5, jad_s_an);
                    break;
                case 5:
                    jad_s_jwVar.jad_s_an(4, jad_s_an);
                    break;
                case 6:
                    jad_s_jwVar.jad_s_an(6, jad_s_an);
                    break;
            }
        }
    }
}
