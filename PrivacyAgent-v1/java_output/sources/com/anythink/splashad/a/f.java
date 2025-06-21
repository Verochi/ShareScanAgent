package com.anythink.splashad.a;

/* loaded from: classes12.dex */
public final class f {
    boolean a;
    com.anythink.core.common.n b;
    long c;
    com.anythink.core.common.f.b d;
    java.lang.String e;
    java.lang.String f;
    java.lang.String g;
    int h;
    java.lang.String i;
    java.lang.String j;
    int k = -1;
    java.util.Map<java.lang.String, java.lang.Object> l;
    com.anythink.core.common.f.v m;
    private android.content.Context n;
    private boolean o;

    /* renamed from: com.anythink.splashad.a.f$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.splashad.unitgroup.api.CustomSplashAdapter a;

        public AnonymousClass1(com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter) {
            this.a = customSplashAdapter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = this.a;
            if (customSplashAdapter != null) {
                customSplashAdapter.internalDestory();
            }
        }
    }

    public class a implements com.anythink.core.api.ATCustomLoadListener {
        com.anythink.splashad.unitgroup.api.CustomSplashAdapter a;

        public a(com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter) {
            this.a = customSplashAdapter;
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(com.anythink.core.api.BaseAd... baseAdArr) {
            com.anythink.splashad.a.f.this.a(this.a, baseAdArr);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdDataLoaded() {
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(java.lang.String str, java.lang.String str2) {
            com.anythink.splashad.a.f.this.a(this.a, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, str, str2));
        }
    }

    public f(android.content.Context context) {
        this.n = context.getApplicationContext();
    }

    private void a(com.anythink.core.api.ATMediationRequestInfo aTMediationRequestInfo) {
        this.g = aTMediationRequestInfo.getAdSourceId();
        this.h = aTMediationRequestInfo.getNetworkFirmId();
        this.i = aTMediationRequestInfo.getClassName();
        java.util.Map<java.lang.String, java.lang.Object> requestParamMap = aTMediationRequestInfo.getRequestParamMap();
        this.l = requestParamMap;
        this.k = 4;
        requestParamMap.put("ad_type", 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter, com.anythink.core.api.AdError adError) {
        if (this.a) {
            return;
        }
        if (customSplashAdapter != null) {
            com.anythink.core.common.o.o.a(customSplashAdapter.getTrackingInfo(), com.anythink.core.common.b.h.m.b, com.anythink.core.common.b.h.m.m, adError.printStackTrace());
        }
        this.a = true;
        this.o = false;
        if (customSplashAdapter != null) {
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.a.f.AnonymousClass1(customSplashAdapter));
        }
        com.anythink.core.common.n nVar = this.b;
        if (nVar != null) {
            nVar.a(3, this.m, null, adError);
        }
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter, com.anythink.core.api.BaseAd... baseAdArr) {
        if (this.a) {
            return;
        }
        if (customSplashAdapter != null) {
            customSplashAdapter.getTrackingInfo().d(android.os.SystemClock.elapsedRealtime() - this.c);
            customSplashAdapter.getTrackingInfo().g(customSplashAdapter.getInternalNetworkPlacementId());
            com.anythink.core.common.o.o.a(customSplashAdapter.getTrackingInfo(), com.anythink.core.common.b.h.m.b, com.anythink.core.common.b.h.m.l, "");
            com.anythink.core.common.n.a.a(this.n).a(12, customSplashAdapter.getTrackingInfo());
            com.anythink.core.common.n.a.a(this.n).a(2, customSplashAdapter.getTrackingInfo());
            com.anythink.core.common.f.b bVar = new com.anythink.core.common.f.b();
            bVar.a(customSplashAdapter);
            bVar.c(java.lang.System.currentTimeMillis());
            bVar.b(600000L);
            bVar.a(600000L);
            if (baseAdArr != null && baseAdArr.length > 0) {
                baseAdArr[0].setTrackingInfo(customSplashAdapter.getTrackingInfo().S());
                bVar.a(baseAdArr[0]);
            }
            this.d = bVar;
        }
        this.a = true;
        this.o = false;
        com.anythink.core.common.n nVar = this.b;
        if (nVar != null) {
            nVar.a(3, this.m, null);
        }
        this.b = null;
    }

    private void a(java.lang.String str) {
        this.g = "0";
        this.l = new java.util.HashMap(1);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.g = jSONObject.optString("unit_id");
            this.h = jSONObject.optInt("nw_firm_id");
            this.i = jSONObject.optString(com.anythink.core.common.j.B);
            this.j = jSONObject.optString("content");
            this.k = jSONObject.optInt("ad_type", -1);
            java.util.Map<java.lang.String, java.lang.Object> c = com.anythink.core.common.o.i.c(this.j);
            this.l = c;
            c.put("ad_type", java.lang.Integer.valueOf(this.k));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        com.anythink.core.common.n nVar = this.b;
        if (nVar != null) {
            nVar.a(3, this.m, null);
        }
        this.b = null;
    }

    private void b(com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter, com.anythink.core.api.AdError adError) {
        if (customSplashAdapter != null) {
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.a.f.AnonymousClass1(customSplashAdapter));
        }
        com.anythink.core.common.n nVar = this.b;
        if (nVar != null) {
            nVar.a(3, this.m, null, adError);
        }
        this.b = null;
    }

    private void c() {
        this.b = null;
    }

    private void d() {
        this.d = null;
    }

    private com.anythink.core.common.f.b e() {
        com.anythink.core.common.f.b bVar = this.d;
        if (bVar == null || bVar.c() > 0) {
            return null;
        }
        return this.d;
    }

    private com.anythink.core.common.f.b f() {
        return this.d;
    }

    public final void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.v vVar, com.anythink.core.common.n nVar) {
        java.lang.Object obj;
        this.m = vVar;
        this.b = nVar;
        this.e = str2;
        this.f = str;
        if (android.text.TextUtils.isEmpty(vVar.c)) {
            com.anythink.core.api.ATMediationRequestInfo aTMediationRequestInfo = this.m.b;
            if (aTMediationRequestInfo != null) {
                this.g = aTMediationRequestInfo.getAdSourceId();
                this.h = aTMediationRequestInfo.getNetworkFirmId();
                this.i = aTMediationRequestInfo.getClassName();
                java.util.Map<java.lang.String, java.lang.Object> requestParamMap = aTMediationRequestInfo.getRequestParamMap();
                this.l = requestParamMap;
                this.k = 4;
                requestParamMap.put("ad_type", 4);
            }
        } else {
            java.lang.String str3 = this.m.c;
            this.g = "0";
            this.l = new java.util.HashMap(1);
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str3);
                this.g = jSONObject.optString("unit_id");
                this.h = jSONObject.optInt("nw_firm_id");
                this.i = jSONObject.optString(com.anythink.core.common.j.B);
                this.j = jSONObject.optString("content");
                this.k = jSONObject.optInt("ad_type", -1);
                java.util.Map<java.lang.String, java.lang.Object> c = com.anythink.core.common.o.i.c(this.j);
                this.l = c;
                c.put("ad_type", java.lang.Integer.valueOf(this.k));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.o(this.g);
        com.anythink.core.common.f.h hVar = new com.anythink.core.common.f.h();
        hVar.w(str);
        hVar.x(str2);
        hVar.y(this.h);
        hVar.y("4");
        hVar.l(android.text.TextUtils.isEmpty(this.g) ? "0" : this.g);
        hVar.v("0");
        hVar.I(2);
        hVar.b(true);
        if (!android.text.TextUtils.isEmpty(this.j)) {
            hVar.n(this.j);
        }
        if (!android.text.TextUtils.isEmpty(this.m.c)) {
            hVar.e(8);
        }
        hVar.A(this.k);
        try {
            com.anythink.core.api.ATBaseAdAdapter a2 = com.anythink.core.common.o.j.a(this.i);
            if (!(a2 instanceof com.anythink.splashad.unitgroup.api.CustomSplashAdapter)) {
                throw new java.lang.Exception("The class isn't instanceof CustomSplashAdapter");
            }
            ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) a2).setFetchAdTimeout(this.m.h);
            this.o = true;
            this.a = false;
            this.c = android.os.SystemClock.elapsedRealtime();
            try {
                hVar.u(a2.getInternalNetworkName());
                hVar.u = a2.getInternalNetworkSDKVersion();
                hVar.q = 2;
            } catch (java.lang.Throwable unused) {
            }
            a2.setTrackingInfo(hVar);
            com.anythink.core.common.o.o.a(hVar, com.anythink.core.common.b.h.m.a, com.anythink.core.common.b.h.m.n, "");
            com.anythink.core.common.n.a.a(this.n).a(10, hVar);
            com.anythink.core.common.n.a.a(this.n).a(1, hVar);
            java.util.Map<java.lang.String, java.lang.Object> b = com.anythink.core.common.u.a().b(str);
            if (this.h == 2 && (obj = b.get("admob_content_urls")) != null && (obj instanceof java.util.List)) {
                com.anythink.core.common.n.c.a(this.f, hVar, "admob_content_urls", obj);
            }
            a2.internalLoad(context, this.l, b, new com.anythink.splashad.a.f.a((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) a2));
        } catch (java.lang.Throwable th2) {
            a((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) null, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adapterNotExistError, "", th2.getMessage()));
        }
    }

    public final boolean a() {
        return this.o;
    }
}
