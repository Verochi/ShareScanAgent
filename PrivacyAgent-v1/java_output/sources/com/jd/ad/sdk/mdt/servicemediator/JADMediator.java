package com.jd.ad.sdk.mdt.servicemediator;

/* loaded from: classes23.dex */
public class JADMediator {
    private com.jd.ad.sdk.jad_gj.jad_an mMediatorService;

    public static class jad_bo {
        public static final com.jd.ad.sdk.mdt.servicemediator.JADMediator jad_an = new com.jd.ad.sdk.mdt.servicemediator.JADMediator(null);
    }

    private JADMediator() {
        if (this.mMediatorService == null) {
            this.mMediatorService = new com.jd.ad.sdk.jad_gj.jad_an();
        }
    }

    public /* synthetic */ JADMediator(com.jd.ad.sdk.mdt.servicemediator.JADMediator.jad_an jad_anVar) {
        this();
    }

    public static com.jd.ad.sdk.mdt.servicemediator.JADMediator getInstance() {
        return com.jd.ad.sdk.mdt.servicemediator.JADMediator.jad_bo.jad_an;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADAdService getAdService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_bo == null) {
            jad_anVar.jad_bo = new com.jd.ad.sdk.jad_zi.jad_an();
        }
        return jad_anVar.jad_bo;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADAdVideoLoadService getAdVideoService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_hu == null) {
            jad_anVar.jad_hu = new com.jd.ad.sdk.jad_zi.jad_bo();
        }
        return jad_anVar.jad_hu;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADDynamicRenderService getDynamicRenderService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_jt == null) {
            jad_anVar.jad_jt = new com.jd.ad.sdk.jad_zi.jad_er();
        }
        return jad_anVar.jad_jt;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADEventService getEventService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_cp == null) {
            jad_anVar.jad_cp = new com.jd.ad.sdk.jad_zi.jad_fs();
        }
        return jad_anVar.jad_cp;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADExposureService getExposureService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_dq == null) {
            jad_anVar.jad_dq = new com.jd.ad.sdk.jad_zi.jad_jt();
        }
        return jad_anVar.jad_dq;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADFoundationService getFoundationService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_er == null) {
            jad_anVar.jad_er = new com.jd.ad.sdk.jad_zi.jad_hu();
        }
        return jad_anVar.jad_er;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADInitService getInitService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_an == null) {
            jad_anVar.jad_an = new com.jd.ad.sdk.jad_zi.jad_iv();
        }
        return jad_anVar.jad_an;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADTouchService getTouchService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_fs == null) {
            jad_anVar.jad_fs = new com.jd.ad.sdk.jad_zi.jad_jw();
        }
        return jad_anVar.jad_fs;
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.mdt.service.JADVideoRenderService getVideoRenderService() {
        com.jd.ad.sdk.jad_gj.jad_an jad_anVar = this.mMediatorService;
        if (jad_anVar.jad_iv == null) {
            jad_anVar.jad_iv = new com.jd.ad.sdk.jad_zi.jad_kx();
        }
        return jad_anVar.jad_iv;
    }
}
