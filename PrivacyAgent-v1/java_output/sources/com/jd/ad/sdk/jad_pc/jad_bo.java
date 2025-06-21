package com.jd.ad.sdk.jad_pc;

/* loaded from: classes23.dex */
public class jad_bo {
    public java.lang.String jad_an;
    public java.lang.String jad_bo;
    public java.lang.String jad_cp;

    public org.json.JSONObject jad_an() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("eu", this.jad_cp);
            jSONObject.putOpt("ou", this.jad_an);
            jSONObject.putOpt("tu", this.jad_bo);
        } catch (org.json.JSONException e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an api ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANApi{ou='");
        jad_an.append(this.jad_an);
        jad_an.append('\'');
        jad_an.append(", tu='");
        jad_an.append(this.jad_bo);
        jad_an.append('\'');
        jad_an.append(", eu='");
        jad_an.append(this.jad_cp);
        jad_an.append('\'');
        jad_an.append('}');
        return jad_an.toString();
    }
}
