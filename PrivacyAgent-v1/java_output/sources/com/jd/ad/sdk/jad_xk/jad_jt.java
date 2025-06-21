package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_jt {
    public static com.jd.ad.sdk.jad_zm.jad_fs jad_an() {
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        return jad_fsVar;
    }

    public static byte[] jad_an(java.util.concurrent.ConcurrentLinkedQueue<com.jd.ad.sdk.jad_xk.jad_dq> concurrentLinkedQueue) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.jd.ad.sdk.jad_xk.jad_dq> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            org.json.JSONObject jad_an = it.next().jad_an();
            jad_an.put("rts", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            jSONArray.put(jad_an);
        }
        jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, jSONArray);
        com.jd.ad.sdk.logger.Logger.d("XlogReport  data: " + jSONObject);
        java.lang.String ja = com.jd.ad.sdk.fdt.utils.ANEProxy.ja(jSONObject.toString().replace("\\n", " ").replace("\\t", " ").replace("\\r", " "));
        if (android.text.TextUtils.isEmpty(ja)) {
            return null;
        }
        return ja.getBytes(java.nio.charset.StandardCharsets.UTF_8);
    }
}
