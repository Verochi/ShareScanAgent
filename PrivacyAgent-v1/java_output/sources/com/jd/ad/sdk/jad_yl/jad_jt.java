package com.jd.ad.sdk.jad_yl;

/* loaded from: classes23.dex */
public final class jad_jt {
    public int jad_an;
    public java.lang.String jad_bo;
    public com.jd.ad.sdk.jad_yl.jad_hu jad_cp;

    public static com.jd.ad.sdk.jad_yl.jad_jt jad_an(java.lang.String str) {
        com.jd.ad.sdk.jad_yl.jad_jt jad_jtVar = new com.jd.ad.sdk.jad_yl.jad_jt();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            jad_jtVar.jad_an = jSONObject.optInt("statuscode");
            jad_jtVar.jad_bo = jSONObject.optString("msg");
            jSONObject.optString("id");
            jSONObject.optString("bidid");
            jad_jtVar.jad_cp = com.jd.ad.sdk.jad_yl.jad_hu.jad_an(jSONObject.optJSONObject("seatbid"));
            return jad_jtVar;
        } catch (org.json.JSONException e) {
            throw e;
        }
    }

    public int jad_an() {
        return this.jad_an;
    }

    public java.lang.String jad_bo() {
        return this.jad_bo;
    }

    public com.jd.ad.sdk.jad_yl.jad_hu jad_cp() {
        return this.jad_cp;
    }
}
