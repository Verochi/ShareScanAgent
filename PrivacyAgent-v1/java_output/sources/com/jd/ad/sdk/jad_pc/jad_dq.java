package com.jd.ad.sdk.jad_pc;

/* loaded from: classes23.dex */
public class jad_dq {
    public java.lang.String jad_an;
    public int jad_bo;
    public int jad_cp;

    public org.json.JSONObject jad_an() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("url", this.jad_an);
            jSONObject.putOpt("mn", java.lang.Integer.valueOf(this.jad_bo));
            jSONObject.putOpt("ci", java.lang.Integer.valueOf(this.jad_cp));
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an events to json ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANEvents{url='");
        jad_an.append(this.jad_an);
        jad_an.append('\'');
        jad_an.append(", mn=");
        jad_an.append(this.jad_bo);
        jad_an.append(", ci=");
        jad_an.append(this.jad_cp);
        jad_an.append('}');
        return jad_an.toString();
    }
}
