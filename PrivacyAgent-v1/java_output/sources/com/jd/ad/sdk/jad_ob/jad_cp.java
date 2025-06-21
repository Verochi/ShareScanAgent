package com.jd.ad.sdk.jad_ob;

/* loaded from: classes23.dex */
public class jad_cp {
    public static void jad_an(com.jd.ad.sdk.jad_zm.jad_ly.jad_an jad_anVar, java.lang.String str) {
        byte[] bArr;
        java.lang.String jad_an = com.jd.ad.sdk.jad_fq.jad_fs.jad_an("aHR0cHM6Ly9qYW5hcGkuamQuY29tL2Fuc2RrL3YxL2luaXREYXRh");
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        jad_fsVar.jad_bo("Encryption", "AES");
        com.jd.ad.sdk.jad_zm.jad_ly.jad_bo jad_an2 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
        jad_an2.jad_er = jad_an;
        jad_an2.jad_bo = jad_fsVar;
        android.app.Application jad_an3 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("aId", com.jd.ad.sdk.bl.initsdk.JADYunSdk.getAppId());
            jSONObject.put("pId", com.jd.ad.sdk.jad_qd.jad_jw.jad_an(jad_an3));
            jSONObject.put(com.aliyun.svideo.downloader.FileDownloaderModel.CAT, com.jd.ad.sdk.jad_ob.jad_an.jad_an());
            jSONObject.put("t", java.lang.System.currentTimeMillis());
            jSONObject.put("rid", str);
            jSONObject.put(com.anythink.core.common.j.af, com.jd.ad.sdk.jad_qd.jad_jw.jad_bo());
            jSONObject.put(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON, com.jd.ad.sdk.jad_qd.jad_jw.jad_an());
            jSONObject.put("plat", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            jSONObject.put("osv", com.jd.ad.sdk.jad_qd.jad_hu.jad_cp());
            jSONObject.put("sdkv", "2.6.20");
        } catch (org.json.JSONException e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.AN_REQUEST_JSON_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 2, jad_anVar2.jad_an, jad_anVar2.jad_an(e.getMessage()), 0);
        }
        com.jd.ad.sdk.logger.Logger.d("AN API Request: " + jSONObject);
        try {
            bArr = com.jd.ad.sdk.jad_fq.jad_an.jad_bo(jSONObject.toString());
        } catch (java.lang.Exception e2) {
            com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(e2));
            bArr = new byte[0];
        }
        jad_an2.jad_fs = new com.jd.ad.sdk.jad_zm.jad_er(bArr);
        jad_an2.jad_hu = true;
        jad_an2.jad_jt = jad_anVar;
        jad_an2.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_cp);
    }
}
