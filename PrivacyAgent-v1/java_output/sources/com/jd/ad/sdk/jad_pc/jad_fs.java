package com.jd.ad.sdk.jad_pc;

/* loaded from: classes23.dex */
public class jad_fs {
    public int jad_an;
    public java.lang.String jad_bo;
    public java.lang.String jad_cp;

    public org.json.JSONObject jad_an() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("id", java.lang.Integer.valueOf(this.jad_an));
            jSONObject.putOpt("sn", this.jad_bo);
            jSONObject.putOpt("sa", this.jad_cp);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an third info ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANThirdPlatformInfo{id=");
        jad_an.append(this.jad_an);
        jad_an.append(", sn='");
        jad_an.append(this.jad_bo);
        jad_an.append('\'');
        jad_an.append(", sa='");
        jad_an.append(this.jad_cp);
        jad_an.append('\'');
        jad_an.append('}');
        return jad_an.toString();
    }
}
