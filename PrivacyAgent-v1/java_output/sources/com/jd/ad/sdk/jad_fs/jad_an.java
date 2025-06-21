package com.jd.ad.sdk.jad_fs;

/* loaded from: classes23.dex */
public class jad_an {
    public final java.util.List<com.jd.ad.sdk.jad_fs.jad_dq> jad_an = new java.util.ArrayList();
    public com.jd.ad.sdk.jad_fs.jad_dq jad_bo;
    public com.jd.ad.sdk.jad_fs.jad_dq jad_cp;

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0044, code lost:
    
        if (com.jd.ad.sdk.jad_qd.jad_an.jad_an(com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_FORMAT, true) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String jad_an() {
        int i;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            android.app.Application jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
            jSONObject.putOpt("jbr", java.lang.Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_tg()));
            jSONObject.putOpt("sof", java.lang.Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_zm()));
            jSONObject.putOpt(com.getui.gtc.extension.distribution.gbd.f.h.n, java.lang.Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_cp(jad_an)));
            jSONObject.putOpt("em", java.lang.Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_uh()));
            i = 1;
        } catch (org.json.JSONException e) {
            com.jd.ad.sdk.logger.Logger.d("getCheatParams Exception: " + e);
        }
        i = -1;
        jSONObject.putOpt(com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_FORMAT, java.lang.Integer.valueOf(i));
        jSONObject.putOpt("hoo", com.jd.ad.sdk.jad_qd.jad_an.jad_vi());
        jSONObject.putOpt(com.igexin.sdk.PushBuildConfig.sdk_conf_channelid, com.jd.ad.sdk.jad_qd.jad_an.jad_wj());
        jSONObject.putOpt("dbg", com.jd.ad.sdk.jad_qd.jad_an.jad_sf());
        jSONObject.putOpt("clo", "NA");
        jSONObject.putOpt("pac", com.jd.ad.sdk.jad_qd.jad_an.jad_an());
        jSONObject.putOpt("soa", com.jd.ad.sdk.jad_qd.jad_an.jad_qd());
        com.jd.ad.sdk.logger.Logger.d("Cheat AC Params: " + jSONObject);
        return jSONObject.toString();
        return jSONObject.toString();
    }

    public final java.lang.String jad_an(java.util.List<com.jd.ad.sdk.jad_fs.jad_dq> list, int i) {
        if (i < 1 || list.size() < i) {
            return "";
        }
        int floor = (int) java.lang.Math.floor(list.size() / i);
        if (floor > 9) {
            floor = 9;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        while (i2 < floor) {
            i2++;
            arrayList.add(list.get((i * i2) - 1));
        }
        long j = ((com.jd.ad.sdk.jad_fs.jad_dq) arrayList.get(0)).jad_an;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.jd.ad.sdk.jad_fs.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_fs.jad_dq) it.next();
            sb.append("|");
            sb.append(jad_dqVar.jad_bo);
            sb.append(",");
            sb.append(jad_dqVar.jad_cp);
            sb.append(",");
            sb.append(jad_dqVar.jad_an - j);
            j = jad_dqVar.jad_an;
        }
        return sb.toString();
    }
}
