package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_jw implements java.io.Serializable {
    public java.lang.Double jad_an;
    public java.lang.Double jad_bo;

    public jad_jw(org.json.JSONObject jSONObject) {
        java.lang.Double valueOf = java.lang.Double.valueOf(-1.0d);
        this.jad_an = valueOf;
        this.jad_bo = valueOf;
        if (jSONObject == null) {
            return;
        }
        jad_an(jSONObject);
    }

    public org.json.JSONObject jad_an() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, com.anythink.core.common.h.c.C, this.jad_an);
            com.jd.ad.sdk.fdt.utils.JsonUtils.put(jSONObject, "lat", this.jad_bo);
        } catch (java.lang.Exception unused) {
            this.jad_an = java.lang.Double.valueOf(-1.0d);
            this.jad_bo = java.lang.Double.valueOf(-1.0d);
        }
        return jSONObject;
    }

    public final void jad_an(org.json.JSONObject jSONObject) {
        try {
            this.jad_an = java.lang.Double.valueOf(jSONObject.optDouble(com.anythink.core.common.h.c.C, -1.0d));
            this.jad_bo = java.lang.Double.valueOf(jSONObject.optDouble("lat", -1.0d));
        } catch (java.lang.Exception e) {
            this.jad_an = java.lang.Double.valueOf(-1.0d);
            this.jad_bo = java.lang.Double.valueOf(-1.0d);
            com.jd.ad.sdk.logger.Logger.w("parse geo from json ", e.getMessage());
        }
    }

    public java.lang.String toString() {
        return jad_an().toString();
    }
}
