package com.jd.ad.sdk.dl.model;

/* loaded from: classes23.dex */
public class jad_an implements java.io.Serializable {
    public int jad_an;
    public int jad_bo;
    public int jad_cp;
    public int jad_dq;
    public int jad_er;

    public jad_an(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.jad_an = jSONObject.optInt("visible_area");
        this.jad_bo = jSONObject.optInt("width");
        this.jad_cp = jSONObject.optInt("height");
        this.jad_dq = jSONObject.optInt("visible_width");
        this.jad_er = jSONObject.optInt("visible_height");
    }

    public org.json.JSONObject jad_an() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("visible_area", this.jad_an);
            jSONObject.put("width", this.jad_bo);
            jSONObject.put("height", this.jad_cp);
            jSONObject.put("visible_width", this.jad_dq);
            jSONObject.put("visible_height", this.jad_er);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
