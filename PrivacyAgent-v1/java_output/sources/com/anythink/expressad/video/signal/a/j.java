package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public class j extends com.anythink.expressad.video.signal.a.c {
    private static final java.lang.String t = "j";
    private static final java.lang.String y = "camp_position";
    private java.util.List<com.anythink.expressad.foundation.d.c> A;
    private int B;
    private java.lang.String C = "";
    private java.lang.String D = "";
    private boolean E = false;
    private boolean F = false;
    private boolean G = true;
    private android.app.Activity u;
    private java.lang.String v;
    private java.lang.String w;
    private android.content.Context x;
    private com.anythink.expressad.foundation.d.c z;

    public j(android.app.Activity activity, com.anythink.expressad.foundation.d.c cVar) {
        this.u = activity;
        this.z = cVar;
    }

    public j(android.app.Activity activity, com.anythink.expressad.foundation.d.c cVar, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.u = activity;
        this.z = cVar;
        this.A = list;
    }

    private static org.json.JSONObject A() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.alipay.sdk.m.p.e.p, new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.o.a().f()).a());
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private org.json.JSONObject B() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("playVideoMute", this.f278s);
            jSONObject2.put("instanceId", this.C);
            jSONObject.put("sdkSetting", jSONObject2);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private org.json.JSONObject C() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.anythink.expressad.videocommon.e.d dVar = this.o;
        return dVar != null ? dVar.R() : jSONObject;
    }

    private static org.json.JSONObject D() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.anythink.expressad.videocommon.e.a b = com.anythink.expressad.videocommon.e.c.a().b();
        return b != null ? b.k() : jSONObject;
    }

    private static boolean E() {
        return false;
    }

    private com.anythink.expressad.foundation.d.c a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        if (android.text.TextUtils.isEmpty(str)) {
            return cVar;
        }
        if (android.text.TextUtils.isEmpty(str) && cVar == null) {
            return null;
        }
        if (str.contains("notice")) {
            try {
                org.json.JSONObject a = com.anythink.expressad.foundation.d.c.a(cVar);
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (jSONObject.opt(com.anythink.expressad.foundation.d.h.cv) == null) {
                    jSONObject.put(com.anythink.expressad.foundation.d.h.cv, "");
                }
                try {
                    if (!jSONObject.has(com.anythink.expressad.foundation.d.c.O)) {
                        a.put(com.anythink.expressad.foundation.d.c.O, "");
                    }
                } catch (java.lang.Exception unused) {
                }
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    a.put(next, jSONObject.getString(next));
                }
                com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(a);
                a(a, b);
                return b;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                return cVar;
            }
        }
        try {
            org.json.JSONObject a2 = com.anythink.expressad.foundation.d.c.a(cVar);
            com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(a2);
            if (b2 == null) {
                b2 = cVar;
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                a(a2, b2);
                org.json.JSONObject optJSONObject = new org.json.JSONObject(str).optJSONObject(com.anythink.expressad.foundation.g.a.ce);
                if (optJSONObject != null) {
                    java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.b(this.u, java.lang.Integer.valueOf(optJSONObject.getString(com.anythink.expressad.foundation.g.a.cc)).intValue()));
                    java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.b(this.u, java.lang.Integer.valueOf(optJSONObject.getString(com.anythink.expressad.foundation.g.a.cd)).intValue()));
                }
                b2.p(b2.ad());
                java.lang.String ah = b2.ah();
                if (optJSONObject != null) {
                    java.util.Iterator<java.lang.String> keys2 = optJSONObject.keys();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (keys2.hasNext()) {
                        sb.append("&");
                        java.lang.String next2 = keys2.next();
                        java.lang.String optString = optJSONObject.optString(next2);
                        if (com.anythink.expressad.foundation.g.a.cc.equals(next2) || com.anythink.expressad.foundation.g.a.cd.equals(next2)) {
                            optString = java.lang.String.valueOf(com.anythink.expressad.foundation.h.t.b(this.u, java.lang.Integer.valueOf(optString).intValue()));
                        }
                        sb.append(next2);
                        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(optString);
                    }
                    b2.q(ah + ((java.lang.Object) sb));
                }
            }
            return b2;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return cVar;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return cVar;
        }
    }

    private void a(org.json.JSONObject jSONObject) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            java.lang.String obj = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmTitle" + this.n, "").toString();
            java.lang.String obj2 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmContent" + this.n, "").toString();
            java.lang.String obj3 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_CancelText" + this.n, "").toString();
            java.lang.String obj4 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmText" + this.n, "").toString();
            if (!android.text.TextUtils.isEmpty(obj)) {
                jSONObject.put(com.anythink.expressad.d.a.b.ct, obj);
            }
            if (!android.text.TextUtils.isEmpty(obj2)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cu, obj2);
            }
            if (!android.text.TextUtils.isEmpty(obj3)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cv, obj3);
            }
            if (!android.text.TextUtils.isEmpty(obj4)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cx, obj4);
            }
            if (android.text.TextUtils.isEmpty(obj4)) {
                return;
            }
            jSONObject.put(com.anythink.expressad.d.a.b.cw, obj4);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(org.json.JSONObject jSONObject, com.anythink.expressad.foundation.d.c cVar) {
        try {
            java.lang.String optString = jSONObject.optString("unitId");
            if (android.text.TextUtils.isEmpty(optString)) {
                return;
            }
            cVar.l(optString);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.anythink.expressad.foundation.d.c cVar) {
        int i;
        java.lang.String queryParameter;
        try {
            queryParameter = android.net.Uri.parse(cVar.ah()).getQueryParameter(com.anythink.expressad.foundation.g.a.cf);
        } catch (java.lang.Throwable unused) {
        }
        if (!android.text.TextUtils.isEmpty(queryParameter)) {
            i = java.lang.Integer.parseInt(queryParameter);
            this.r.a(cVar, i == 2);
            u().a(this.r);
            u();
        }
        i = 0;
        this.r.a(cVar, i == 2);
        u().a(this.r);
        u();
    }

    private void c(boolean z) {
        this.G = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x0019, B:7:0x0023, B:9:0x002d, B:11:0x0033), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x0019, B:7:0x0023, B:9:0x002d, B:11:0x0033), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(com.anythink.expressad.foundation.d.c cVar) {
        long j;
        try {
            if (!android.text.TextUtils.isEmpty(com.anythink.expressad.foundation.b.a.b().e())) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
                if (b != null) {
                    j = b.l() * 1000;
                    com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
                    long c = b2 != null ? b2.c() : 0L;
                    if (cVar == null) {
                        return cVar.a(c, j);
                    }
                    return false;
                }
            }
            j = 0;
            com.anythink.expressad.videocommon.e.a b22 = com.anythink.expressad.videocommon.e.c.a().b();
            if (b22 != null) {
            }
            if (cVar == null) {
            }
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private void e(java.lang.String str) {
        java.util.List<com.anythink.expressad.foundation.d.c> list;
        if (this.z == null || (list = this.A) == null || list.size() == 0) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has(y)) {
                this.z = this.A.get(jSONObject.getInt(y));
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean s() {
        return this.G;
    }

    private java.lang.String t() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.o.a().f());
        try {
            jSONObject.put("unit_id", this.n);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("instanceId", this.C);
            jSONObject2.put("rootViewInstanceId", this.D);
            jSONObject2.put("isRootTemplateWebView", this.E);
            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.anythink.expressad.out.b.a + ",3.0.1");
            jSONObject2.put("playVideoMute", this.f278s);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(com.alipay.sdk.m.p.e.p, cVar.a());
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.A;
            if (list == null || list.size() <= 0) {
                jSONArray.put(com.anythink.expressad.foundation.d.c.a(this.z));
            } else {
                for (com.anythink.expressad.foundation.d.c cVar2 : this.A) {
                    jSONArray.put(com.anythink.expressad.foundation.d.c.a(cVar2, cVar2.at(), c(cVar2)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", C());
            java.lang.String e = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            java.lang.String a = com.anythink.expressad.d.b.a(e);
            if (!android.text.TextUtils.isEmpty(a)) {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(a);
                a(jSONObject3);
                com.anythink.expressad.d.b.a();
                java.lang.String b = com.anythink.expressad.d.b.b(this.n);
                if (!android.text.TextUtils.isEmpty(b)) {
                    jSONObject3.put("ivreward", new org.json.JSONObject(b));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", D());
            if (!android.text.TextUtils.isEmpty(this.n)) {
                jSONObject.put("unit_id", this.n);
            }
            jSONObject.put("rw_plus", this.F ? "1" : "0");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private com.anythink.expressad.a.a u() {
        if (this.q == null) {
            this.q = new com.anythink.expressad.a.a(com.anythink.core.common.b.o.a().f(), this.n);
        }
        return this.q;
    }

    private org.json.JSONObject v() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.o.a().f());
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("playVideoMute", this.f278s);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(com.alipay.sdk.m.p.e.p, cVar.a());
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONArray.put(com.anythink.expressad.foundation.d.c.a(this.z));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", C());
            java.lang.String e = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            java.lang.String a = com.anythink.expressad.d.b.a(e);
            if (!android.text.TextUtils.isEmpty(a)) {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(a);
                a(jSONObject3);
                com.anythink.expressad.d.b.a();
                java.lang.String b = com.anythink.expressad.d.b.b(this.n);
                if (!android.text.TextUtils.isEmpty(b)) {
                    jSONObject3.put("ivreward", b);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", D());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private static org.json.JSONObject w() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.anythink.expressad.out.b.a + ",3.0.1");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private org.json.JSONObject x() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (!android.text.TextUtils.isEmpty(this.n)) {
                jSONObject.put("unit_id", this.n);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static org.json.JSONObject y() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.String e = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            java.lang.String a = com.anythink.expressad.d.b.a(e);
            if (!android.text.TextUtils.isEmpty(a)) {
                jSONObject.put("appSetting", new org.json.JSONObject(a));
            }
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject;
    }

    private org.json.JSONObject z() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.anythink.expressad.videocommon.e.d dVar = this.o;
            if (dVar != null) {
                jSONObject.put("unitSetting", dVar.R());
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(int i, java.lang.String str) {
        super.a(i, str);
        if (i != 2) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("event", "event");
            java.lang.String optString2 = jSONObject.optString("template", "-1");
            java.lang.String optString3 = jSONObject.optString("layout", "-1");
            java.lang.String optString4 = jSONObject.optString("unit_id", this.n);
            this.u.getApplication();
            int a = com.anythink.expressad.foundation.h.k.a();
            new com.anythink.expressad.foundation.d.r(com.anythink.expressad.foundation.d.r.j, optString, optString2, optString3, optString4, this.z.aZ(), a, com.anythink.expressad.foundation.h.k.a(this.u.getApplication(), a));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(android.app.Activity activity) {
        this.u = activity;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(android.content.Context context) {
        this.x = context;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.z = cVar;
    }

    public final void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.A = list;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.w = str;
    }

    public final void b(boolean z) {
        this.F = z;
    }

    public final void c(java.lang.String str) {
        this.C = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b2  */
    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void click(int i, java.lang.String str) {
        int i2;
        java.lang.String queryParameter;
        java.util.List<com.anythink.expressad.foundation.d.c> list;
        int p;
        java.util.List<com.anythink.expressad.foundation.d.c> list2;
        super.click(i, str);
        com.anythink.expressad.foundation.d.c cVar = this.z;
        if (cVar != null && cVar.k() == 5 && this.z != null && (list2 = this.A) != null && list2.size() != 0) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (jSONObject.has(y)) {
                    this.z = this.A.get(jSONObject.getInt(y));
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        boolean z = true;
        try {
            if (i != 1) {
                if (i != 3) {
                    return;
                }
                com.anythink.expressad.foundation.d.c cVar2 = this.z;
                if (cVar2 == null || cVar2.g() <= -2) {
                    com.anythink.expressad.videocommon.e.d dVar = this.o;
                    p = dVar != null ? dVar.p() : 1;
                } else {
                    p = this.z.g();
                }
                if (p == -1) {
                    a(new com.anythink.expressad.video.signal.a.c.b(this, this.r));
                }
                click(1, str);
                return;
            }
            if (this.z == null && (list = this.A) != null && list.size() > 0) {
                this.z = this.A.get(0);
            }
            com.anythink.expressad.foundation.d.c cVar3 = this.z;
            if (cVar3 == null) {
                return;
            }
            com.anythink.expressad.foundation.d.c a = a(str, cVar3);
            try {
                queryParameter = android.net.Uri.parse(a.ah()).getQueryParameter(com.anythink.expressad.foundation.g.a.cf);
            } catch (java.lang.Throwable unused) {
            }
            if (!android.text.TextUtils.isEmpty(queryParameter)) {
                i2 = java.lang.Integer.parseInt(queryParameter);
                com.anythink.expressad.video.signal.c.a aVar = this.r;
                if (i2 == 2) {
                    z = false;
                }
                aVar.a(a, z);
                u().a(this.r);
                u();
            }
            i2 = 0;
            com.anythink.expressad.video.signal.c.a aVar2 = this.r;
            if (i2 == 2) {
            }
            aVar2.a(a, z);
            u().a(this.r);
            u();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public final void d(java.lang.String str) {
        this.D = str;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final java.lang.String h(int i) {
        switch (i) {
            case 1:
                return w().toString();
            case 2:
                return x().toString();
            case 3:
                return y().toString();
            case 4:
                return z().toString();
            case 5:
                return A().toString();
            case 6:
                return B().toString();
            default:
                return v().toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i, java.lang.String str) {
        super.handlerH5Exception(i, str);
        try {
            this.r.a(i, str);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final java.lang.String i() {
        this.r.c();
        this.e = true;
        if (android.text.TextUtils.isEmpty(this.v)) {
            this.v = t();
        }
        return this.v;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void j() {
        super.j();
        try {
            android.app.Activity activity = this.u;
            if (activity != null) {
                activity.finish();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public final void j(int i) {
        this.B = i;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void l() {
        super.l();
        com.anythink.expressad.video.signal.c.a aVar = this.r;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final java.lang.String o() {
        return this.w;
    }

    public final void p() {
        this.E = true;
    }

    public final void q() {
        this.v = "";
    }

    public final int r() {
        return this.B;
    }
}
