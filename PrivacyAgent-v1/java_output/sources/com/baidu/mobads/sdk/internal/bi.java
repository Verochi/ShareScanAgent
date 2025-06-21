package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public abstract class bi extends java.util.Observable {
    private static final java.lang.String a = "b_f";
    public static final java.lang.String b = "XAbstractProdTemplate";
    public static final java.lang.String c = "error_message";
    public static final java.lang.String d = "error_code";
    public static final java.lang.String e = "error_uniqueid";
    protected static final java.lang.String f = "instanceInfo";
    protected static final java.lang.String g = "showState";
    protected android.widget.RelativeLayout h;
    protected android.content.Context i;
    protected java.lang.String j;
    public java.util.HashMap<java.lang.String, java.lang.String> o;
    public java.lang.String p;
    public java.lang.String q;
    protected com.baidu.mobads.sdk.internal.bt k = com.baidu.mobads.sdk.internal.bt.a();
    public com.baidu.mobads.sdk.api.IAdInterListener m = null;
    public boolean n = true;
    public int r = -1;

    /* renamed from: s, reason: collision with root package name */
    protected long f295s = 0;
    public com.baidu.mobads.sdk.api.IOAdEventListener l = new com.baidu.mobads.sdk.internal.bi.a();

    public class a implements com.baidu.mobads.sdk.api.IOAdEventListener {
        public a() {
        }

        private java.lang.String a(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
            java.util.Map<java.lang.String, java.lang.Object> data;
            java.lang.Object obj;
            if (iOAdEvent == null) {
                return null;
            }
            java.lang.String message = iOAdEvent.getMessage();
            return (!android.text.TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof java.lang.String)) ? message : (java.lang.String) obj;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
            com.baidu.mobads.sdk.internal.bi.a(new com.baidu.mobads.sdk.internal.bl(this, iOAdEvent));
        }
    }

    public bi(android.content.Context context) {
        this.i = context;
        com.baidu.mobads.sdk.internal.aa.a().a(this.i, new com.baidu.mobads.sdk.internal.bj(this));
    }

    private java.lang.String a(java.lang.String str, org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new org.json.JSONObject();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + android.net.Uri.encode(jSONObject.toString());
    }

    public static void a(java.lang.Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                runnable.run();
            } else {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.baidu.mobads.sdk.internal.bk(runnable));
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public abstract void a();

    public void a(int i, java.lang.String str, java.lang.String str2) {
        r();
    }

    public void a(android.app.Activity activity) {
        if (this.m != null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("setActivity", activity);
            this.m.onAdTaskProcess(a(com.baidu.mobads.sdk.api.IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new org.json.JSONObject()), hashMap);
        }
    }

    public void a(android.view.View view, org.json.JSONObject jSONObject) {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(com.baidu.mobads.sdk.api.IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    public void a(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public void a(java.lang.String str, int i, java.lang.String str2) {
        r();
    }

    public void a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, str);
            com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(com.baidu.mobads.sdk.api.IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, "server_bidding");
            jSONObject.put("msg", str);
            com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(com.baidu.mobads.sdk.api.IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(java.lang.String str, boolean z) {
    }

    public void a(java.lang.String str, boolean z, java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        try {
            if (com.baidu.mobads.sdk.internal.k.a(z, linkedHashMap, biddingListener)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("uniqueId", str);
                jSONObject.put("result", z);
                try {
                    for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : linkedHashMap.entrySet()) {
                        jSONObject.put(java.lang.String.valueOf(entry.getKey()), entry.getValue());
                    }
                } catch (java.lang.Throwable th) {
                    com.baidu.mobads.sdk.internal.ay.f(th.getMessage());
                }
                com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
                if (iAdInterListener != null) {
                    iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (java.util.Map<java.lang.String, java.lang.Object>) null);
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.o = (java.util.HashMap) map;
    }

    public void a(org.json.JSONObject jSONObject) {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(com.baidu.mobads.sdk.api.IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void a(org.json.JSONObject jSONObject, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(com.baidu.mobads.sdk.api.IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void a(boolean z) {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z);
        }
    }

    public boolean a(int i, android.view.KeyEvent keyEvent) {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public org.json.JSONObject b(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            return new org.json.JSONObject(map);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public void b() {
    }

    public void b(int i) {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i);
        }
    }

    public void b(android.view.View view, org.json.JSONObject jSONObject) {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(com.baidu.mobads.sdk.api.IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void b(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            a("bidding data is empty", 2, "");
        }
        if (this.m == null) {
            a("Initialization doesn't finish yet.", 1, "");
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("bidding_data", str);
        a("load_bidding_data", (java.util.Map<java.lang.String, java.lang.Object>) hashMap);
    }

    public void b(java.lang.String str, boolean z) {
    }

    public void b(org.json.JSONObject jSONObject) {
        int i = this.r;
        if (i >= 0 && jSONObject != null) {
            try {
                jSONObject.put(a, i);
            } catch (java.lang.Throwable th) {
                this.k.a(th);
            }
        }
        if (jSONObject != null) {
            try {
                jSONObject.put(com.baidu.mobads.sdk.internal.d.b, this.f295s);
            } catch (java.lang.Throwable th2) {
                this.k.a(th2);
            }
        }
    }

    public void b(boolean z) {
    }

    public void c() {
    }

    public void c(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            a("bidding id is empty", 2, "");
        }
        if (this.m == null) {
            a("Initialization doesn't finish yet.", 1, "");
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.anythink.core.common.c.k.a.c, str);
        a("load_bidding_ad", (java.util.Map<java.lang.String, java.lang.Object>) hashMap);
    }

    public void d() {
    }

    public void d(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public void d(java.lang.String str) {
    }

    public void e(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public void e(java.lang.String str) {
    }

    public void f(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public void f(java.lang.String str) {
    }

    public void g(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        r();
    }

    public void g(java.lang.String str) {
    }

    public void h() {
        this.m = (com.baidu.mobads.sdk.api.IAdInterListener) com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.k, com.baidu.mobads.sdk.internal.bs.a(this.i), (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}, this.i);
        if (this.n) {
            return;
        }
        a();
    }

    public void h(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public void h(java.lang.String str) {
        this.q = str;
    }

    public java.lang.String i(java.lang.String str) {
        com.baidu.mobads.sdk.api.IXAdContainerFactory c2;
        com.baidu.mobads.sdk.internal.aa a2 = com.baidu.mobads.sdk.internal.aa.a();
        if (a2 != null && (c2 = a2.c()) != null) {
            java.lang.Object remoteParam = c2.getRemoteParam(str, new java.lang.Object[0]);
            if (remoteParam instanceof java.lang.String) {
                return (java.lang.String) remoteParam;
            }
        }
        return null;
    }

    public void i() {
        a("SDK未初始化", 1, "");
    }

    public void i(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public org.json.JSONObject j() {
        return new org.json.JSONObject();
    }

    public void j(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public org.json.JSONObject k() {
        return new org.json.JSONObject();
    }

    public void k(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
    }

    public java.lang.String l() {
        org.json.JSONObject j = j();
        org.json.JSONObject k = k();
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("param_info", j);
        hashMap.put("ad_buss_param", k);
        a("get_request_token", (java.util.Map<java.lang.String, java.lang.Object>) hashMap);
        java.lang.Object obj = hashMap.get("request_token");
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        return null;
    }

    public void m() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.c.h, new com.baidu.mobads.sdk.internal.a.c.a());
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.G, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.I, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.K, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.L, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.V, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.q, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.W, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.r, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.M, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.N, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.J, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.C, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ab, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ac, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ad, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.Z, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.U, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ae, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.af, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ag, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ah, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ai, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.aj, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ak, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.al, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.aa, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.am, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.X, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.an, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ao, this.l);
        }
    }

    public void n() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void o() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    public void p() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    public void q() {
    }

    public void r() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public android.view.View w() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }
}
