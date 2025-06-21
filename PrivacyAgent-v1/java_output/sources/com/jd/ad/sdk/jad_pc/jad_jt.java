package com.jd.ad.sdk.jad_pc;

/* loaded from: classes23.dex */
public class jad_jt {
    public java.lang.String jad_an;
    public java.lang.String jad_bo;
    public java.lang.String jad_cp;
    public java.lang.String jad_dq;
    public java.lang.String jad_er;

    public org.json.JSONObject jad_an() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("deviceInfoList", this.jad_an);
            jSONObject.putOpt("screenInfoList", this.jad_bo);
            jSONObject.putOpt("osInfoList", this.jad_cp);
            jSONObject.putOpt("userInfoList", this.jad_dq);
            jSONObject.putOpt("realTimeInfoList", this.jad_er);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
