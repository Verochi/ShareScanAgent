package com.jd.ad.sdk.jad_pc;

/* loaded from: classes23.dex */
public class jad_cp {
    public com.jd.ad.sdk.jad_pc.jad_bo jad_an;
    public com.jd.ad.sdk.jad_pc.jad_dq jad_bo;
    public java.util.List<com.jd.ad.sdk.jad_pc.jad_fs> jad_cp;
    public long jad_dq;
    public long jad_er;
    public java.util.List<com.jd.ad.sdk.jad_pc.jad_hu> jad_hu;
    public com.jd.ad.sdk.jad_pc.jad_an jad_iv;
    public java.util.List<com.jd.ad.sdk.jad_pc.jad_er> jad_jt;
    public com.jd.ad.sdk.jad_pc.jad_jt jad_kx;
    public int jad_fs = 2;
    public int jad_jw = 0;

    public static com.jd.ad.sdk.jad_pc.jad_cp jad_an(@androidx.annotation.Nullable org.json.JSONObject jSONObject) {
        com.jd.ad.sdk.jad_pc.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar;
        com.jd.ad.sdk.jad_pc.jad_an jad_anVar;
        com.jd.ad.sdk.jad_pc.jad_hu jad_huVar;
        com.jd.ad.sdk.jad_pc.jad_er jad_erVar;
        com.jd.ad.sdk.jad_pc.jad_fs jad_fsVar;
        com.jd.ad.sdk.jad_pc.jad_jt jad_jtVar = null;
        if (jSONObject == null) {
            return null;
        }
        com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_pc.jad_cp();
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("api");
        if (optJSONObject == null) {
            jad_boVar = null;
        } else {
            jad_boVar = new com.jd.ad.sdk.jad_pc.jad_bo();
            jad_boVar.jad_cp = optJSONObject.optString("eu");
            jad_boVar.jad_an = optJSONObject.optString("ou");
            jad_boVar.jad_bo = optJSONObject.optString("tu");
        }
        jad_cpVar.jad_an = jad_boVar;
        org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("events");
        if (optJSONObject2 == null) {
            jad_dqVar = null;
        } else {
            jad_dqVar = new com.jd.ad.sdk.jad_pc.jad_dq();
            jad_dqVar.jad_cp = optJSONObject2.optInt("ci");
            jad_dqVar.jad_bo = optJSONObject2.optInt("mn");
            jad_dqVar.jad_an = optJSONObject2.optString("url");
        }
        jad_cpVar.jad_bo = jad_dqVar;
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("ms");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                org.json.JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                if (optJSONObject3 == null) {
                    jad_fsVar = null;
                } else {
                    jad_fsVar = new com.jd.ad.sdk.jad_pc.jad_fs();
                    jad_fsVar.jad_an = optJSONObject3.optInt("id");
                    jad_fsVar.jad_cp = optJSONObject3.optString("sa");
                    jad_fsVar.jad_bo = optJSONObject3.optString("sn");
                }
                arrayList.add(jad_fsVar);
            }
        }
        jad_cpVar.jad_cp = arrayList;
        jad_cpVar.jad_dq = jSONObject.optLong("timeout");
        jad_cpVar.jad_er = jSONObject.optLong("lrf");
        jad_cpVar.jad_fs = jSONObject.optInt("ssp", 2);
        org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray("pls");
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                org.json.JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i2);
                if (optJSONObject4 == null) {
                    jad_erVar = null;
                } else {
                    jad_erVar = new com.jd.ad.sdk.jad_pc.jad_er();
                    jad_erVar.jad_an = optJSONObject4.optString("ak");
                    jad_erVar.jad_bo = optJSONObject4.optInt("t");
                    jad_erVar.jad_cp = optJSONObject4.optInt(com.anythink.expressad.d.a.b.dH);
                    jad_erVar.jad_dq = optJSONObject4.optInt("bs");
                    jad_erVar.jad_er = optJSONObject4.optInt("st");
                    org.json.JSONArray optJSONArray3 = optJSONObject4.optJSONArray("tmp");
                    java.util.ArrayList arrayList3 = new java.util.ArrayList();
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            arrayList3.add(java.lang.Integer.valueOf(optJSONArray3.optInt(i3)));
                        }
                    }
                    jad_erVar.jad_fs = arrayList3;
                    jad_erVar.jad_jt = optJSONObject4.optInt("ds");
                    jad_erVar.jad_hu = optJSONObject4.optInt("r");
                }
                arrayList2.add(jad_erVar);
            }
        }
        jad_cpVar.jad_jt = arrayList2;
        org.json.JSONArray optJSONArray4 = jSONObject.optJSONArray("fcfg");
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                org.json.JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i4);
                if (optJSONObject5 == null) {
                    jad_huVar = null;
                } else {
                    jad_huVar = new com.jd.ad.sdk.jad_pc.jad_hu();
                    jad_huVar.jad_an = optJSONObject5.optInt("mId");
                    jad_huVar.jad_bo = optJSONObject5.optString("tagId");
                }
                arrayList4.add(jad_huVar);
            }
        }
        jad_cpVar.jad_hu = arrayList4;
        org.json.JSONObject optJSONObject6 = jSONObject.optJSONObject("abcfg");
        if (optJSONObject6 == null) {
            jad_anVar = null;
        } else {
            jad_anVar = new com.jd.ad.sdk.jad_pc.jad_an();
            jad_anVar.jad_an = optJSONObject6.optString("crt");
            jad_anVar.jad_na = optJSONObject6.optString("fbdr");
            jad_anVar.jad_bo = optJSONObject6.optString("enpe");
            jad_anVar.jad_cp = (float) optJSONObject6.optDouble("ssvl", 0.0d);
            jad_anVar.jad_dq = (float) optJSONObject6.optDouble("slng", 0.0d);
            jad_anVar.jad_er = (float) optJSONObject6.optDouble("savl", 0.0d);
            jad_anVar.jad_fs = (float) optJSONObject6.optDouble("stvl", 0.0d);
            jad_anVar.jad_jt = (float) optJSONObject6.optDouble("fsvl", 0.0d);
            jad_anVar.jad_hu = (float) optJSONObject6.optDouble("favl", 0.0d);
            jad_anVar.jad_iv = (float) optJSONObject6.optDouble("ftvl", 0.0d);
            jad_anVar.jad_jw = (float) optJSONObject6.optDouble("sang", 0.0d);
            jad_anVar.jad_kx = optJSONObject6.optInt("pcit", com.anythink.expressad.d.a.b.ck);
            jad_anVar.jad_ly = optJSONObject6.optInt("pcdc", 2);
            jad_anVar.jad_mz = optJSONObject6.optInt("pdut", 3);
            jad_anVar.jad_pc = optJSONObject6.optInt("fpif");
            jad_anVar.jad_qd = optJSONObject6.optString("fikc");
            jad_anVar.jad_ob = optJSONObject6.optInt("opro");
            jad_anVar.jad_re = optJSONObject6.optInt("vcdc", 40);
            jad_anVar.jad_sf = optJSONObject6.optString("fbvl");
            jad_anVar.jad_tg = optJSONObject6.optString("ftsv");
            jad_anVar.jad_uh = optJSONObject6.optInt("eaih");
            jad_anVar.jad_vi = optJSONObject6.optInt("abdt");
        }
        jad_cpVar.jad_iv = jad_anVar;
        jad_cpVar.jad_jw = jSONObject.optInt("collectedEnable", 0);
        org.json.JSONObject optJSONObject7 = jSONObject.optJSONObject("collectInfoConfig");
        if (optJSONObject7 != null) {
            jad_jtVar = new com.jd.ad.sdk.jad_pc.jad_jt();
            jad_jtVar.jad_an = optJSONObject7.optString("deviceInfoList");
            jad_jtVar.jad_bo = optJSONObject7.optString("screenInfoList");
            jad_jtVar.jad_cp = optJSONObject7.optString("osInfoList");
            jad_jtVar.jad_dq = optJSONObject7.optString("userInfoList");
            jad_jtVar.jad_er = optJSONObject7.optString("realTimeInfoList");
        }
        jad_cpVar.jad_kx = jad_jtVar;
        return jad_cpVar;
    }

    public org.json.JSONObject jad_an() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.jd.ad.sdk.jad_pc.jad_bo jad_boVar = this.jad_an;
            if (jad_boVar != null) {
                jSONObject.putOpt("api", jad_boVar.jad_an());
            }
            com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar = this.jad_bo;
            if (jad_dqVar != null) {
                jSONObject.putOpt("events", jad_dqVar.jad_an());
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            java.util.List<com.jd.ad.sdk.jad_pc.jad_fs> list = this.jad_cp;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.jad_cp.size(); i++) {
                    com.jd.ad.sdk.jad_pc.jad_fs jad_fsVar = this.jad_cp.get(i);
                    if (jad_fsVar != null) {
                        jSONArray.put(jad_fsVar.jad_an());
                    }
                }
            }
            jSONObject.putOpt("ms", jSONArray);
            jSONObject.putOpt("timeout", java.lang.Long.valueOf(this.jad_dq));
            jSONObject.putOpt("lrf", java.lang.Long.valueOf(this.jad_er));
            jSONObject.putOpt("ssp", java.lang.Integer.valueOf(this.jad_fs));
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            java.util.List<com.jd.ad.sdk.jad_pc.jad_er> list2 = this.jad_jt;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < this.jad_jt.size(); i2++) {
                    com.jd.ad.sdk.jad_pc.jad_er jad_erVar = this.jad_jt.get(i2);
                    if (jad_erVar != null) {
                        jSONArray2.put(jad_erVar.jad_an());
                    }
                }
            }
            jSONObject.putOpt("pls", jSONArray2);
            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
            java.util.List<com.jd.ad.sdk.jad_pc.jad_hu> list3 = this.jad_hu;
            if (list3 != null && list3.size() > 0) {
                for (int i3 = 0; i3 < this.jad_hu.size(); i3++) {
                    com.jd.ad.sdk.jad_pc.jad_hu jad_huVar = this.jad_hu.get(i3);
                    if (jad_huVar != null) {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        try {
                            jSONObject2.putOpt("mId", java.lang.Integer.valueOf(jad_huVar.jad_an));
                            jSONObject2.putOpt("tagId", jad_huVar.jad_bo);
                        } catch (org.json.JSONException e) {
                            e.printStackTrace();
                        }
                        jSONArray3.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("fcfg", jSONArray3);
            com.jd.ad.sdk.jad_pc.jad_an jad_anVar = this.jad_iv;
            if (jad_anVar != null) {
                jSONObject.putOpt("abcfg", jad_anVar.jad_an());
            }
            jSONObject.putOpt("collectedEnable", java.lang.Integer.valueOf(this.jad_jw));
            com.jd.ad.sdk.jad_pc.jad_jt jad_jtVar = this.jad_kx;
            if (jad_jtVar != null) {
                jSONObject.putOpt("collectInfoConfig", jad_jtVar.jad_an());
            }
        } catch (java.lang.Exception e2) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an configuration ");
            jad_an.append(e2.getMessage());
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANConfigurations{api=");
        jad_an.append(this.jad_an);
        jad_an.append(", events=");
        jad_an.append(this.jad_bo);
        jad_an.append(", ms=");
        jad_an.append(this.jad_cp);
        jad_an.append(", timeout=");
        jad_an.append(this.jad_dq);
        jad_an.append(", lrf=");
        jad_an.append(this.jad_er);
        jad_an.append(", pls=");
        jad_an.append(this.jad_jt);
        jad_an.append(", ssp=");
        jad_an.append(this.jad_fs);
        jad_an.append(", fcfg=");
        jad_an.append(this.jad_hu);
        jad_an.append(", abcfg=");
        jad_an.append(this.jad_iv);
        jad_an.append(", collectedEnable=");
        jad_an.append(this.jad_jw);
        jad_an.append(", collectInfoConfig=");
        jad_an.append(this.jad_kx);
        jad_an.append('}');
        return jad_an.toString();
    }
}
