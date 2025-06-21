package com.jd.ad.sdk.jad_pc;

/* loaded from: classes23.dex */
public class jad_er {
    public java.lang.String jad_an;
    public int jad_bo;
    public int jad_cp;
    public int jad_dq;
    public int jad_er;
    public java.util.List<java.lang.Integer> jad_fs;
    public int jad_hu;
    public int jad_jt;

    public org.json.JSONObject jad_an() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("ak", this.jad_an);
            jSONObject.putOpt("t", java.lang.Integer.valueOf(this.jad_bo));
            jSONObject.putOpt(com.anythink.expressad.d.a.b.dH, java.lang.Integer.valueOf(this.jad_cp));
            jSONObject.putOpt("bs", java.lang.Integer.valueOf(this.jad_dq));
            jSONObject.putOpt("st", java.lang.Integer.valueOf(this.jad_er));
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            java.util.List<java.lang.Integer> list = this.jad_fs;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.jad_fs.size(); i++) {
                    jSONArray.put(this.jad_fs.get(i));
                }
            }
            jSONObject.putOpt("tmp", jSONArray);
            jSONObject.putOpt("ds", java.lang.Integer.valueOf(this.jad_jt));
            jSONObject.putOpt("r", java.lang.Integer.valueOf(this.jad_hu));
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an placement ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANPlacement{ak='");
        jad_an.append(this.jad_an);
        jad_an.append('\'');
        jad_an.append(", t=");
        jad_an.append(this.jad_bo);
        jad_an.append(", m=");
        jad_an.append(this.jad_cp);
        jad_an.append(", bs=");
        jad_an.append(this.jad_dq);
        jad_an.append(", st=");
        jad_an.append(this.jad_er);
        jad_an.append(", tmp=");
        jad_an.append(this.jad_fs);
        jad_an.append(", ds=");
        jad_an.append(this.jad_jt);
        jad_an.append(", r=");
        jad_an.append(this.jad_hu);
        jad_an.append('}');
        return jad_an.toString();
    }
}
