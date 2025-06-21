package com.ss.android.download.api.model;

/* loaded from: classes19.dex */
public class t {
    private final long bt;
    private final boolean cp;
    private final java.lang.String d;
    private final java.util.List<java.lang.String> es;
    private final org.json.JSONObject j;
    private final java.lang.String kz;
    private final org.json.JSONObject o;
    private final java.lang.String t;
    private final java.lang.String u;
    private final boolean v;
    private final java.lang.Object vl;
    private java.lang.String vw;
    private final java.lang.String wg;
    private final org.json.JSONObject x;
    private final long yl;
    private final int z;

    public static class vw {
        private long bt;
        private java.lang.String cp;
        private java.util.Map<java.lang.String, java.lang.Object> es;
        private java.lang.String j;
        private org.json.JSONObject k;
        private java.lang.String kz;
        private org.json.JSONObject o;
        private java.lang.String t;
        private java.lang.Object u;
        private int vl;
        private java.lang.String vw;
        private java.lang.String wg;
        private org.json.JSONObject x;
        private long yl;
        private java.util.List<java.lang.String> z;
        private boolean v = false;
        private boolean d = false;

        public com.ss.android.download.api.model.t.vw t(java.lang.String str) {
            this.kz = str;
            return this;
        }

        public com.ss.android.download.api.model.t.vw v(java.lang.String str) {
            this.cp = str;
            return this;
        }

        public com.ss.android.download.api.model.t.vw vw(int i) {
            this.vl = i;
            return this;
        }

        public com.ss.android.download.api.model.t.vw vw(long j) {
            this.yl = j;
            return this;
        }

        public com.ss.android.download.api.model.t.vw vw(java.lang.Object obj) {
            this.u = obj;
            return this;
        }

        public com.ss.android.download.api.model.t.vw vw(java.lang.String str) {
            this.wg = str;
            return this;
        }

        public com.ss.android.download.api.model.t.vw vw(java.util.List<java.lang.String> list) {
            this.z = list;
            return this;
        }

        public com.ss.android.download.api.model.t.vw vw(org.json.JSONObject jSONObject) {
            this.o = jSONObject;
            return this;
        }

        public com.ss.android.download.api.model.t.vw vw(boolean z) {
            this.d = z;
            return this;
        }

        public com.ss.android.download.api.model.t vw() {
            if (android.text.TextUtils.isEmpty(this.vw)) {
                this.vw = "umeng";
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (this.o == null) {
                this.o = new org.json.JSONObject();
            }
            try {
                java.util.Map<java.lang.String, java.lang.Object> map = this.es;
                if (map != null && !map.isEmpty()) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.es.entrySet()) {
                        if (!this.o.has(entry.getKey())) {
                            this.o.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.d) {
                    this.j = this.t;
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    this.k = jSONObject2;
                    if (this.v) {
                        jSONObject2.put("ad_extra_data", this.o.toString());
                    } else {
                        java.util.Iterator<java.lang.String> keys = this.o.keys();
                        while (keys.hasNext()) {
                            java.lang.String next = keys.next();
                            this.k.put(next, this.o.get(next));
                        }
                    }
                    this.k.put("category", this.vw);
                    this.k.put("tag", this.wg);
                    this.k.put("value", this.yl);
                    this.k.put("ext_value", this.bt);
                    if (!android.text.TextUtils.isEmpty(this.cp)) {
                        this.k.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_REFER, this.cp);
                    }
                    org.json.JSONObject jSONObject3 = this.x;
                    if (jSONObject3 != null) {
                        this.k = com.ss.android.download.api.t.wg.vw(jSONObject3, this.k);
                    }
                    if (this.v) {
                        if (!this.k.has("log_extra") && !android.text.TextUtils.isEmpty(this.kz)) {
                            this.k.put("log_extra", this.kz);
                        }
                        this.k.put("is_ad_event", "1");
                    }
                }
                if (this.v) {
                    jSONObject.put("ad_extra_data", this.o.toString());
                    if (!jSONObject.has("log_extra") && !android.text.TextUtils.isEmpty(this.kz)) {
                        jSONObject.put("log_extra", this.kz);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.o);
                }
                if (!android.text.TextUtils.isEmpty(this.cp)) {
                    jSONObject.putOpt(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_REFER, this.cp);
                }
                org.json.JSONObject jSONObject4 = this.x;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.t.wg.vw(jSONObject4, jSONObject);
                }
                this.o = jSONObject;
            } catch (java.lang.Exception e) {
                com.ss.android.downloadlib.addownload.z.q().vw(e, "DownloadEventModel build");
            }
            return new com.ss.android.download.api.model.t(this);
        }

        public com.ss.android.download.api.model.t.vw wg(long j) {
            this.bt = j;
            return this;
        }

        public com.ss.android.download.api.model.t.vw wg(java.lang.String str) {
            this.t = str;
            return this;
        }

        public com.ss.android.download.api.model.t.vw wg(org.json.JSONObject jSONObject) {
            this.x = jSONObject;
            return this;
        }

        public com.ss.android.download.api.model.t.vw wg(boolean z) {
            this.v = z;
            return this;
        }
    }

    public t(com.ss.android.download.api.model.t.vw vwVar) {
        this.vw = vwVar.vw;
        this.wg = vwVar.wg;
        this.t = vwVar.t;
        this.v = vwVar.v;
        this.yl = vwVar.yl;
        this.kz = vwVar.kz;
        this.bt = vwVar.bt;
        this.o = vwVar.o;
        this.x = vwVar.x;
        this.es = vwVar.z;
        this.z = vwVar.vl;
        this.vl = vwVar.u;
        this.cp = vwVar.d;
        this.d = vwVar.j;
        this.j = vwVar.k;
        this.u = vwVar.cp;
    }

    public long bt() {
        return this.bt;
    }

    public java.lang.String cp() {
        return this.d;
    }

    public org.json.JSONObject d() {
        return this.j;
    }

    public java.util.List<java.lang.String> es() {
        return this.es;
    }

    public java.lang.String kz() {
        return this.kz;
    }

    public org.json.JSONObject o() {
        return this.o;
    }

    public java.lang.String t() {
        return this.t;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("category: ");
        sb.append(this.vw);
        sb.append("\ttag: ");
        sb.append(this.wg);
        sb.append("\tlabel: ");
        sb.append(this.t);
        sb.append("\nisAd: ");
        sb.append(this.v);
        sb.append("\tadId: ");
        sb.append(this.yl);
        sb.append("\tlogExtra: ");
        sb.append(this.kz);
        sb.append("\textValue: ");
        sb.append(this.bt);
        sb.append("\nextJson: ");
        sb.append(this.o);
        sb.append("\nparamsJson: ");
        sb.append(this.x);
        sb.append("\nclickTrackUrl: ");
        java.util.List<java.lang.String> list = this.es;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.z);
        sb.append("\textraObject: ");
        java.lang.Object obj = this.vl;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.cp);
        sb.append("\tV3EventName: ");
        sb.append(this.d);
        sb.append("\tV3EventParams: ");
        org.json.JSONObject jSONObject = this.j;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public boolean u() {
        return this.cp;
    }

    public boolean v() {
        return this.v;
    }

    public java.lang.Object vl() {
        return this.vl;
    }

    public java.lang.String vw() {
        return this.vw;
    }

    public java.lang.String wg() {
        return this.wg;
    }

    public org.json.JSONObject x() {
        return this.x;
    }

    public long yl() {
        return this.yl;
    }

    public int z() {
        return this.z;
    }
}
