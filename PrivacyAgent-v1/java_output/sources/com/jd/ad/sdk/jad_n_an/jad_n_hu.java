package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_hu implements com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener {
    public final /* synthetic */ android.view.ViewGroup jad_n_an;
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_bo;

    public jad_n_hu(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, android.view.ViewGroup viewGroup) {
        this.jad_n_bo = jad_n_ivVar;
        this.jad_n_an = viewGroup;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j, java.lang.String str, int i) {
        com.jd.ad.sdk.nativead.JADNative jADNative = this.jad_n_bo.jad_n_an;
        if (jADNative != null && jADNative.getSlot() != null) {
            this.jad_n_bo.jad_n_an.getSlot().setImm(i);
        }
        com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(this.jad_n_bo, true, str, i);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(java.lang.String str) {
        com.jd.ad.sdk.nativead.JADNative jADNative = this.jad_n_bo.jad_n_an;
        if (jADNative != null && jADNative.getSlot() != null) {
            this.jad_n_bo.jad_n_an.getSlot().setImm(com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(this.jad_n_bo, false, str, com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
        com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(this.jad_n_bo, (android.view.View) this.jad_n_an, false);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(java.lang.String str) {
        com.jd.ad.sdk.nativead.JADNative jADNative = this.jad_n_bo.jad_n_an;
        if (jADNative != null && jADNative.getSlot() != null) {
            this.jad_n_bo.jad_n_an.getSlot().setImm(com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        this.jad_n_bo.jad_n_cp = false;
        com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(this.jad_n_bo, false, str, com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
    }
}
