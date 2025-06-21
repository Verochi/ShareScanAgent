package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
public class yl {
    private java.lang.String bt;
    private com.ss.android.downloadlib.addownload.compliance.yl.wg cp;
    private java.lang.String d;
    private java.lang.String es;
    private int kz;
    private java.lang.String o;
    private int t;
    private java.lang.String u;
    private int v;
    private java.lang.String vl;
    private boolean vw;
    private com.ss.android.downloadlib.addownload.compliance.yl.vw wg;
    private int x;
    private int yl = 15;
    private long z;

    public static class vw {
        private java.util.List<com.ss.android.downloadlib.addownload.compliance.yl.vw.C0469vw> bt;
        private java.lang.String es;
        private java.lang.String kz;
        private java.lang.String o;
        private long t;
        private long v;
        private java.lang.String vl;
        private java.lang.String vw;
        private java.lang.String wg;
        private java.lang.String x;
        private java.lang.String yl;
        private java.lang.String z;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.yl$vw$vw, reason: collision with other inner class name */
        public static class C0469vw {
            private java.lang.String vw;
            private java.lang.String wg;

            public void vw(java.lang.String str) {
                this.vw = str;
            }

            public void wg(java.lang.String str) {
                this.wg = str;
            }
        }

        public void bt(java.lang.String str) {
            this.es = str;
        }

        public void kz(java.lang.String str) {
            this.x = str;
        }

        public void o(java.lang.String str) {
            this.z = str;
        }

        public void t(java.lang.String str) {
            this.yl = str;
        }

        public void v(java.lang.String str) {
            this.kz = str;
        }

        public void vw(long j) {
            this.t = j;
        }

        public void vw(java.lang.String str) {
            this.vw = str;
        }

        public void vw(java.util.List<com.ss.android.downloadlib.addownload.compliance.yl.vw.C0469vw> list) {
            this.bt = list;
        }

        public void wg(long j) {
            this.v = j;
        }

        public void wg(java.lang.String str) {
            this.wg = str;
        }

        public void x(java.lang.String str) {
            this.vl = str;
        }

        public void yl(java.lang.String str) {
            this.o = str;
        }
    }

    public static class wg {
        private int vw;
        private java.lang.String wg;

        public void vw(int i) {
            this.vw = i;
        }

        public void vw(java.lang.String str) {
            this.wg = str;
        }
    }

    public static com.ss.android.downloadlib.addownload.compliance.yl bt(java.lang.String str) {
        com.ss.android.downloadlib.addownload.compliance.yl ylVar = new com.ss.android.downloadlib.addownload.compliance.yl();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.ss.android.downloadlib.addownload.compliance.yl.vw vw2 = vw(jSONObject);
            com.ss.android.downloadlib.addownload.compliance.yl.wg wg2 = wg(jSONObject);
            ylVar.vw(vw2);
            ylVar.vw(wg2);
            ylVar.vw(jSONObject.optInt("show_auth", 0) == 1);
            ylVar.vw(jSONObject.optInt("download_permit"));
            ylVar.wg(jSONObject.optInt("appstore_permit"));
            ylVar.t(jSONObject.optInt("market_online_status", 15));
            ylVar.v(jSONObject.optInt("hijack_permit"));
            ylVar.vw(jSONObject.optString("package_name"));
            ylVar.wg(jSONObject.optString("hijack_url"));
            ylVar.yl(jSONObject.optInt("code"));
            ylVar.t(jSONObject.optString("message"));
            ylVar.vw(jSONObject.optLong("request_duration", 0L));
            ylVar.v(jSONObject.optString("back_web_url"));
            ylVar.yl(jSONObject.optString("hw_app_id"));
            ylVar.kz(jSONObject.optString(com.anythink.expressad.foundation.d.c.O));
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "ComplianceResult fromJson");
        }
        return ylVar;
    }

    private static org.json.JSONArray t(com.ss.android.downloadlib.addownload.compliance.yl.vw vwVar) throws org.json.JSONException {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.List<com.ss.android.downloadlib.addownload.compliance.yl.vw.C0469vw> list = vwVar.bt;
        if (list != null && list.size() > 0) {
            for (com.ss.android.downloadlib.addownload.compliance.yl.vw.C0469vw c0469vw : list) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.putOpt("permission_name", c0469vw.vw);
                jSONObject.putOpt("permission_desc", c0469vw.wg);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    private static com.ss.android.downloadlib.addownload.compliance.yl.vw vw(org.json.JSONObject jSONObject) {
        com.ss.android.downloadlib.addownload.compliance.yl.vw vwVar = new com.ss.android.downloadlib.addownload.compliance.yl.vw();
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                vwVar.vw(optJSONObject.optString("app_name"));
                vwVar.wg(optJSONObject.optString(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                vwVar.vw(com.ss.android.downloadlib.bt.vl.vw(optJSONObject, "update_time"));
                vwVar.wg(com.ss.android.downloadlib.bt.vl.vw(optJSONObject, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE));
                vwVar.t(optJSONObject.optString("developer_name"));
                vwVar.v(optJSONObject.optString("package_name"));
                org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    vw(optJSONArray, arrayList);
                    vwVar.vw(arrayList);
                }
                vwVar.yl(optJSONObject.optString("permission_classify_url"));
                vwVar.kz(optJSONObject.optString("policy_url"));
                vwVar.bt(optJSONObject.optString("icon_url"));
                vwVar.o(optJSONObject.optString("download_url"));
                vwVar.x(optJSONObject.optString("desc_url"));
            }
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "ComplianceResult getAuthInfo");
        }
        return vwVar;
    }

    public static java.lang.String vw(com.ss.android.downloadlib.addownload.compliance.yl ylVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("show_auth", java.lang.Integer.valueOf(ylVar.vw ? 1 : 0));
            jSONObject.putOpt("download_permit", java.lang.Integer.valueOf(ylVar.t));
            jSONObject.putOpt("appstore_permit", java.lang.Integer.valueOf(ylVar.v));
            jSONObject.putOpt("market_online_status", java.lang.Integer.valueOf(ylVar.yl));
            jSONObject.putOpt("hijack_permit", java.lang.Integer.valueOf(ylVar.kz));
            jSONObject.putOpt("package_name", ylVar.bt);
            jSONObject.putOpt("hijack_url", ylVar.o);
            jSONObject.putOpt("code", java.lang.Integer.valueOf(ylVar.x));
            jSONObject.putOpt("message", ylVar.es);
            jSONObject.putOpt("request_duration", java.lang.Long.valueOf(ylVar.z));
            jSONObject.putOpt("auth_info", wg(ylVar.wg));
            jSONObject.putOpt("status", wg(ylVar.cp));
            jSONObject.putOpt("back_web_url", ylVar.d);
            jSONObject.putOpt("hw_app_id", ylVar.vl);
            jSONObject.putOpt(com.anythink.expressad.foundation.d.c.O, ylVar.u);
        } catch (org.json.JSONException e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static void vw(org.json.JSONArray jSONArray, java.util.List<com.ss.android.downloadlib.addownload.compliance.yl.vw.C0469vw> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                com.ss.android.downloadlib.addownload.compliance.yl.vw.C0469vw c0469vw = new com.ss.android.downloadlib.addownload.compliance.yl.vw.C0469vw();
                c0469vw.vw(optJSONObject.optString("permission_name"));
                c0469vw.wg(optJSONObject.optString("permission_desc"));
                list.add(c0469vw);
            }
        }
    }

    private static com.ss.android.downloadlib.addownload.compliance.yl.wg wg(org.json.JSONObject jSONObject) {
        com.ss.android.downloadlib.addownload.compliance.yl.wg wgVar = new com.ss.android.downloadlib.addownload.compliance.yl.wg();
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("status");
            if (optJSONObject != null) {
                wgVar.vw(optJSONObject.optInt("status"));
                wgVar.vw(optJSONObject.optString("message"));
            }
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "ComplianceResult getStatus");
        }
        return wgVar;
    }

    private static org.json.JSONObject wg(com.ss.android.downloadlib.addownload.compliance.yl.vw vwVar) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (vwVar != null) {
            jSONObject.putOpt("app_name", vwVar.vw);
            jSONObject.putOpt(com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, vwVar.wg);
            jSONObject.putOpt("update_time", java.lang.Long.valueOf(vwVar.t));
            jSONObject.putOpt(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, java.lang.Long.valueOf(vwVar.v));
            jSONObject.putOpt("developer_name", vwVar.yl);
            jSONObject.putOpt("policy_url", vwVar.x);
            jSONObject.putOpt("icon_url", vwVar.es);
            jSONObject.putOpt("download_url", vwVar.z);
            jSONObject.putOpt("permissions", t(vwVar));
            jSONObject.putOpt("permission_classify_url", vwVar.o);
            jSONObject.putOpt("desc_url", vwVar.vl);
        }
        return jSONObject;
    }

    private static org.json.JSONObject wg(com.ss.android.downloadlib.addownload.compliance.yl.wg wgVar) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (wgVar != null) {
            jSONObject.putOpt("status", java.lang.Integer.valueOf(wgVar.vw));
            jSONObject.putOpt("message", wgVar.wg);
        }
        return jSONObject;
    }

    public void kz(java.lang.String str) {
        this.u = str;
    }

    public void t(int i) {
        this.yl = i;
    }

    public void t(java.lang.String str) {
        this.es = str;
    }

    public java.lang.String toString() {
        return vw(this);
    }

    public void v(int i) {
        this.kz = i;
    }

    public void v(java.lang.String str) {
        this.d = str;
    }

    public int vw() {
        return this.x;
    }

    public void vw(int i) {
        this.t = i;
    }

    public void vw(long j) {
        this.z = j;
    }

    public void vw(com.ss.android.downloadlib.addownload.compliance.yl.vw vwVar) {
        this.wg = vwVar;
    }

    public void vw(com.ss.android.downloadlib.addownload.compliance.yl.wg wgVar) {
        this.cp = wgVar;
    }

    public void vw(java.lang.String str) {
        this.bt = str;
    }

    public void vw(boolean z) {
        this.vw = z;
    }

    public java.lang.String wg() {
        return this.u;
    }

    public void wg(int i) {
        this.v = i;
    }

    public void wg(java.lang.String str) {
        this.o = str;
    }

    public void yl(int i) {
        this.x = i;
    }

    public void yl(java.lang.String str) {
        this.vl = str;
    }
}
