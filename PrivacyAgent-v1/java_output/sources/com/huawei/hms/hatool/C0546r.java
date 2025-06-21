package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.r, reason: case insensitive filesystem */
/* loaded from: classes22.dex */
public class C0546r implements com.huawei.hms.hatool.s {
    public java.util.List<com.huawei.hms.hatool.q> a;
    public com.huawei.hms.hatool.o b;
    public com.huawei.hms.hatool.p c;
    public com.huawei.hms.hatool.s d;
    public java.lang.String e = "";
    public java.lang.String f;

    public C0546r(java.lang.String str) {
        this.f = str;
    }

    @Override // com.huawei.hms.hatool.s
    public org.json.JSONObject a() {
        java.lang.String str;
        java.util.List<com.huawei.hms.hatool.q> list = this.a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.b == null || this.c == null || this.d == null) {
            str = "model in wrong format";
        } else {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("header", this.b.a());
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            org.json.JSONObject a = this.d.a();
            a.put("properties", this.c.a());
            try {
                a.put("events_global_properties", new org.json.JSONObject(this.e));
            } catch (org.json.JSONException unused) {
                a.put("events_global_properties", this.e);
            }
            jSONObject2.put("events_common", a);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            java.util.Iterator<com.huawei.hms.hatool.q> it = this.a.iterator();
            while (it.hasNext()) {
                org.json.JSONObject a2 = it.next().a();
                if (a2 != null) {
                    jSONArray.put(a2);
                } else {
                    com.huawei.hms.hatool.y.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                java.lang.String a3 = com.huawei.hms.hatool.d.a(com.huawei.hms.hatool.t0.a(jSONObject2.toString().getBytes("UTF-8")), this.f);
                if (android.text.TextUtils.isEmpty(a3)) {
                    com.huawei.hms.hatool.y.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a3);
                return jSONObject;
            } catch (java.io.UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        com.huawei.hms.hatool.y.e("hmsSdk", str);
        return null;
    }

    public void a(com.huawei.hms.hatool.e1 e1Var) {
        this.d = e1Var;
    }

    public void a(com.huawei.hms.hatool.o oVar) {
        this.b = oVar;
    }

    public void a(com.huawei.hms.hatool.p pVar) {
        this.c = pVar;
    }

    public void a(java.lang.String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public void a(java.util.List<com.huawei.hms.hatool.q> list) {
        this.a = list;
    }
}
