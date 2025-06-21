package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_jt implements com.jd.ad.sdk.mdt.service.JADExposureService {
    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.WeakReference<android.view.View>> getNativeExposureFeedShakeViewMap() {
        return com.jd.ad.sdk.jad_iv.jad_an.C0383jad_an.jad_an.jad_bo;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void registerExposureView(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = com.jd.ad.sdk.jad_iv.jad_an.C0383jad_an.jad_an;
        if (jad_anVar.jad_an.get(str) == null) {
            jad_anVar.jad_an.put(str, new com.jd.ad.sdk.jad_iv.jad_dq());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void registerNativeExposureFeedShakeView(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.view.View view) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = com.jd.ad.sdk.jad_iv.jad_an.C0383jad_an.jad_an;
        jad_anVar.getClass();
        if (view != null && jad_anVar.jad_bo.get(str) == null) {
            jad_anVar.jad_bo.put(str, new java.lang.ref.WeakReference<>(view));
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void setViewExposureCallback(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener jADExposureListener) {
        com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = com.jd.ad.sdk.jad_iv.jad_an.C0383jad_an.jad_an.jad_an.get(str);
        if (jad_dqVar == null) {
            return;
        }
        jad_dqVar.jad_fs = new java.lang.ref.WeakReference<>(str);
        jad_dqVar.jad_cp = jADExposureListener;
        jad_dqVar.jad_dq = i;
        jad_dqVar.jad_an = new java.lang.ref.WeakReference<>(view);
        android.view.View jad_bo = jad_dqVar.jad_bo();
        if (jad_bo != null) {
            jad_dqVar.jad_bo = new com.jd.ad.sdk.jad_iv.jad_er(android.os.Looper.getMainLooper(), jad_dqVar);
            if (!androidx.core.view.ViewCompat.isAttachedToWindow(jad_bo)) {
                jad_bo.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_iv.jad_cp(jad_dqVar, jad_bo));
            } else {
                jad_dqVar.jad_bo.sendEmptyMessage(1);
                jad_bo.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_iv.jad_bo(jad_dqVar, jad_bo));
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void setViewForceExposure(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_yl.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = com.jd.ad.sdk.jad_iv.jad_an.C0383jad_an.jad_an.jad_an.get(str);
        if (jad_dqVar == null || (jad_boVar = jad_dqVar.jad_er) == null || jad_boVar.jad_cp) {
            return;
        }
        jad_dqVar.jad_an(true, com.jd.ad.sdk.dl.common.CommonConstants.ExposureType.EXPOSURE_FORCE.getIndex());
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void unregisterExposureView(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = com.jd.ad.sdk.jad_iv.jad_an.C0383jad_an.jad_an;
        if (jad_anVar.jad_an.get(str) != null) {
            com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = jad_anVar.jad_an.get(str);
            jad_dqVar.jad_cp = null;
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar = jad_dqVar.jad_bo;
            if (jad_erVar != null) {
                jad_erVar.removeCallbacksAndMessages(null);
                jad_dqVar.jad_bo = null;
            }
            jad_anVar.jad_an.remove(str);
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void unregisterNativeExposureFeedShakeView(@androidx.annotation.NonNull java.lang.String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = com.jd.ad.sdk.jad_iv.jad_an.C0383jad_an.jad_an;
        if (jad_anVar.jad_bo.get(str) != null) {
            jad_anVar.jad_bo.remove(str);
        }
    }
}
