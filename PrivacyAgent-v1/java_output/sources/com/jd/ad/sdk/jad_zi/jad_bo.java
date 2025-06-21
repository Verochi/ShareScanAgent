package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_bo implements com.jd.ad.sdk.mdt.service.JADAdVideoLoadService {
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.jd.ad.sdk.jad_ly.jad_bo> jad_an = new java.util.concurrent.ConcurrentHashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:20:0x0031 A[Catch: all -> 0x005f, Exception -> 0x0061, TryCatch #0 {Exception -> 0x0061, blocks: (B:6:0x000c, B:8:0x0012, B:11:0x0019, B:15:0x0023, B:20:0x0031, B:24:0x003f, B:28:0x0050), top: B:5:0x000c, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[Catch: all -> 0x005f, Exception -> 0x0061, TryCatch #0 {Exception -> 0x0061, blocks: (B:6:0x000c, B:8:0x0012, B:11:0x0019, B:15:0x0023, B:20:0x0031, B:24:0x003f, B:28:0x0050), top: B:5:0x000c, outer: #1 }] */
    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadAdVideo(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull java.lang.String str3, @androidx.annotation.NonNull com.jd.ad.sdk.bl.video.listener.VideoLoadListener videoLoadListener) {
        boolean z;
        com.jd.ad.sdk.jad_ly.jad_bo jad_boVar = this.jad_an.get(str);
        if (jad_boVar == null) {
            if (videoLoadListener != null) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_REGISTER_AD_SERVICE_ERROR;
                videoLoadListener.onLoadFailure(jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]));
                return;
            }
            return;
        }
        synchronized (jad_boVar) {
            try {
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.d("load video Ad response body is exception:" + e);
            }
            if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str3)) {
                int i = android.os.Build.VERSION.SDK_INT;
                if (i >= 23 && i < 29 && androidx.core.content.ContextCompat.checkSelfPermission(context, com.anythink.china.common.d.b) != 0) {
                    z = false;
                    if (z) {
                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_VIDEO_AD_SERVICE_PERMISSION_ERROR;
                        jad_boVar.jad_an(videoLoadListener, jad_anVar2.jad_an, jad_anVar2.jad_an(new java.lang.String[0]));
                    } else {
                        com.jd.ad.sdk.jad_ep.jad_cp.jad_an.execute(new com.jd.ad.sdk.jad_ly.jad_an(jad_boVar, str2, videoLoadListener, context, str3));
                        return;
                    }
                }
                z = true;
                if (z) {
                }
            }
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_VIDEO_URL_IS_NULL_ERROR;
            jad_boVar.jad_an(videoLoadListener, jad_anVar3.jad_an, jad_anVar3.jad_an(new java.lang.String[0]));
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    public void registerAd(java.lang.String str) {
        if (this.jad_an.get(str) == null) {
            this.jad_an.put(str, new com.jd.ad.sdk.jad_ly.jad_bo());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    public void unregisterAd(@androidx.annotation.NonNull java.lang.String str) {
        if (this.jad_an.get(str) == null) {
            return;
        }
        this.jad_an.remove(str);
    }
}
