package com.jd.ad.sdk.jad_ob;

/* loaded from: classes23.dex */
public class jad_an {
    public static long jad_an() {
        java.lang.Object jad_an;
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        java.lang.Class cls = java.lang.Long.TYPE;
        jad_anVar.getClass();
        if (android.text.TextUtils.isEmpty(com.aliyun.svideo.downloader.FileDownloaderModel.CAT)) {
            jad_an = null;
        } else {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an(com.aliyun.svideo.downloader.FileDownloaderModel.CAT);
            jad_an2.append(com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId());
            jad_an = jad_anVar.jad_an(jad_an2.toString(), (java.lang.Class<java.lang.Object>) cls);
        }
        long longValue = (jad_an == null || !(jad_an instanceof java.lang.Long)) ? 0L : ((java.lang.Long) jad_an).longValue();
        if (com.jd.ad.sdk.jad_re.jad_an.jad_bo()) {
            return longValue;
        }
        return 0L;
    }
}
