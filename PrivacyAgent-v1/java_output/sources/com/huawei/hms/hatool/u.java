package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class u {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.util.List<com.huawei.hms.hatool.q> d;
    public java.lang.String e;

    public u(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<com.huawei.hms.hatool.q> list, java.lang.String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = str4;
    }

    public final java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String f = com.huawei.hms.hatool.c.f(str, str2);
        if (android.text.TextUtils.isEmpty(f)) {
            com.huawei.hms.hatool.y.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else {
            if (!"diffprivacy".equals(str2)) {
                return "";
            }
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", f);
    }

    public void a() {
        com.huawei.hms.hatool.n0 l0Var;
        com.huawei.hms.hatool.o0 c;
        java.lang.String str;
        java.lang.String a = a(this.a, this.b);
        if (!android.text.TextUtils.isEmpty(a) || "preins".equals(this.b)) {
            if (!"_hms_config_tag".equals(this.a) && !"_openness_config_tag".equals(this.a)) {
                b();
            }
            com.huawei.hms.hatool.C0546r d = d();
            if (d != null) {
                byte[] a2 = a(d);
                if (a2.length == 0) {
                    str = "request body is empty";
                } else {
                    l0Var = new com.huawei.hms.hatool.i0(a2, a, this.a, this.b, this.e, this.d);
                    c = com.huawei.hms.hatool.o0.b();
                }
            } else {
                l0Var = new com.huawei.hms.hatool.l0(this.d, this.a, this.e, this.b);
                c = com.huawei.hms.hatool.o0.c();
            }
            c.a(l0Var);
            return;
        }
        str = "collectUrl is empty";
        com.huawei.hms.hatool.y.e("hmsSdk", str);
    }

    public final byte[] a(com.huawei.hms.hatool.C0546r c0546r) {
        java.lang.String str;
        try {
            org.json.JSONObject a = c0546r.a();
            if (a != null) {
                return com.huawei.hms.hatool.t0.a(a.toString().getBytes("UTF-8"));
            }
            com.huawei.hms.hatool.y.e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (java.io.UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            com.huawei.hms.hatool.y.e("hmsSdk", str);
            return new byte[0];
        } catch (org.json.JSONException unused2) {
            str = "uploadEvents to json error";
            com.huawei.hms.hatool.y.e("hmsSdk", str);
            return new byte[0];
        }
    }

    public final void b() {
        if (com.huawei.hms.hatool.q0.a(com.huawei.hms.hatool.b.i(), "backup_event", 5242880)) {
            com.huawei.hms.hatool.y.d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        org.json.JSONArray c = c();
        java.lang.String a = com.huawei.hms.hatool.u0.a(this.a, this.b, this.e);
        com.huawei.hms.hatool.y.c("hmsSdk", "Update data cached into backup,spKey: " + a);
        com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "backup_event", a, c.toString());
    }

    public final org.json.JSONArray c() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.huawei.hms.hatool.q> it = this.d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().d());
            } catch (org.json.JSONException unused) {
                com.huawei.hms.hatool.y.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    public final com.huawei.hms.hatool.C0546r d() {
        return com.huawei.hms.hatool.d1.a(this.d, this.a, this.b, this.e, this.c);
    }
}
