package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class dd extends com.baidu.mobads.sdk.internal.bi {
    private com.baidu.mobads.sdk.api.ExpressInterstitialListener A;
    private com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener B;
    private com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterstitialAdDislikeListener C;
    private com.baidu.mobads.sdk.internal.a D;
    private boolean E;
    private boolean F;
    android.widget.RelativeLayout a;
    public boolean t;
    public boolean u;
    private int v;
    private java.lang.String w;
    private java.lang.String x;
    private int y;
    private int z;

    public dd(android.content.Context context, android.widget.RelativeLayout relativeLayout, java.lang.String str) {
        super(context);
        this.v = 8000;
        this.w = com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.y = 600;
        this.z = 500;
        this.E = false;
        this.a = relativeLayout;
        this.x = str;
    }

    public java.lang.Object a(java.lang.String str) {
        if (this.D != null) {
            return "request_id".equals(str) ? this.D.V() : this.D.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener == null) {
            this.n = false;
            return;
        }
        this.u = false;
        this.n = true;
        iAdInterListener.loadAd(j(), k());
    }

    public void a(int i) {
        this.v = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i, java.lang.String str, java.lang.String str2) {
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i, str);
        }
        super.a(i, str, str2);
    }

    public void a(android.view.MotionEvent motionEvent) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("e_d_t", motionEvent.getDownTime());
            jSONObject.put("e_e_t", motionEvent.getEventTime());
            jSONObject.put("e_a", motionEvent.getAction());
            jSONObject.put("e_x", motionEvent.getX());
            jSONObject.put("e_y", motionEvent.getY());
            jSONObject.put("e_m_s", motionEvent.getMetaState());
            jSONObject.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, "x_event");
            a(jSONObject);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void a(com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.B = interAdDownloadWindowListener;
    }

    public void a(com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.C = interstitialAdDislikeListener;
    }

    public void a(com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener) {
        this.A = expressInterstitialListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.List<com.baidu.mobads.sdk.internal.a> a;
        if (iOAdEvent != null && (a = com.baidu.mobads.sdk.internal.b.a(iOAdEvent.getMessage()).a()) != null && a.size() > 0) {
            this.D = a.get(0);
        }
        this.u = true;
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
    }

    public void a(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.y = width;
            this.z = height;
        }
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, int i, java.lang.String str2) {
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i, str);
        }
        super.a(str, i, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, boolean z) {
        com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            this.o = com.baidu.mobads.sdk.internal.m.a(map);
        } catch (java.lang.Throwable unused) {
            this.o = new java.util.HashMap<>();
        }
    }

    public void a(boolean z, java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.a aVar = this.D;
        if (aVar != null) {
            a(aVar.I(), z, linkedHashMap, biddingListener);
        } else {
            a(this.j, z, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.A.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(java.lang.String str, boolean z) {
        com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.A.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.C;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    public void c(boolean z) {
        this.E = z;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d(java.lang.String str) {
    }

    public void d(boolean z) {
        this.F = z;
    }

    public java.lang.String e() {
        return this.w;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        this.u = false;
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(java.lang.String str) {
        com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(java.lang.String str) {
    }

    public boolean f() {
        return this.u;
    }

    public void g() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        com.baidu.mobads.sdk.api.ExpressInterstitialListener expressInterstitialListener = this.A;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public org.json.JSONObject j() {
        this.f295s = java.lang.System.currentTimeMillis();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, this.w);
            this.m.createProdHandler(jSONObject2);
            this.m.setAdContainer(this.a);
            m();
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, this.w);
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.APID, this.x);
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "1");
            if (!android.text.TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            if (com.baidu.mobads.sdk.internal.cq.a().b()) {
                jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "" + com.baidu.mobads.sdk.internal.ba.b(this.i));
            jSONObject.put("h", "" + com.baidu.mobads.sdk.internal.ba.c(this.i));
            jSONObject.put("msa", 151);
            jSONObject.put("opt", 1);
            jSONObject = com.baidu.mobads.sdk.internal.m.a(jSONObject, b(this.o));
            b(jSONObject);
            return jSONObject;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public org.json.JSONObject k() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.t);
            jSONObject.put(com.baidu.mobads.sdk.api.SplashAd.KEY_POPDIALOG_DOWNLOAD, this.E);
            jSONObject.put("use_dialog_container", this.F);
            jSONObject.put("timeout", this.v);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void u() {
        com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.B;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void v() {
    }

    public com.baidu.mobads.sdk.internal.a x() {
        return this.D;
    }
}
