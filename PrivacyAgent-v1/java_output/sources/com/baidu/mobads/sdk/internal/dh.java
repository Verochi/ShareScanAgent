package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class dh extends com.baidu.mobads.sdk.internal.bi {
    private java.lang.String A;
    private com.baidu.mobads.sdk.internal.a B;
    private com.baidu.mobads.sdk.api.RequestParameters C;
    private boolean a;
    private int t;
    private java.lang.String u;
    private com.baidu.mobads.sdk.api.ScreenVideoAdListener v;
    private final java.lang.String w;
    private int x;
    private int y;
    private java.lang.String z;

    public dh(android.content.Context context, java.lang.String str, boolean z) {
        this(context, str, z, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
    }

    public dh(android.content.Context context, java.lang.String str, boolean z, java.lang.String str2) {
        super(context);
        this.t = 3;
        this.u = str;
        this.a = z;
        this.w = str2;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener == null) {
            this.n = false;
        } else {
            this.n = true;
            iAdInterListener.loadAd(j(), k());
        }
    }

    public void a(int i) {
        this.t = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i, java.lang.String str, java.lang.String str2) {
        super.a(i, str, str2);
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    public void a(android.content.Context context) {
        if (this.m != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.util.HashMap hashMap = new java.util.HashMap();
            try {
                jSONObject.put("msg", "setContext");
                hashMap.put("context", context);
            } catch (org.json.JSONException e) {
                com.baidu.mobads.sdk.internal.bt.a().a(e);
            }
            a(jSONObject, hashMap);
            this.m.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.List<com.baidu.mobads.sdk.internal.a> a;
        if (iOAdEvent != null && (a = com.baidu.mobads.sdk.internal.b.a(iOAdEvent.getMessage()).a()) != null && a.size() > 0) {
            this.B = a.get(0);
        }
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    public void a(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        this.C = requestParameters;
        a(requestParameters.getExt());
    }

    public void a(com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener) {
        this.v = screenVideoAdListener;
    }

    public void a(java.lang.String str) {
        this.z = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, int i, java.lang.String str2) {
        super.a(str, i, str2);
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
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
        com.baidu.mobads.sdk.internal.a aVar = this.B;
        if (aVar != null) {
            a(aVar.I(), z, linkedHashMap, biddingListener);
        } else {
            a(this.j, z, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(boolean z) {
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void e() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    public boolean f() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    public java.lang.String g() {
        com.baidu.mobads.sdk.internal.a aVar = this.B;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float floatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((java.lang.Float) iOAdEvent.getData().get("play_scale")).floatValue();
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(floatValue);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(java.lang.String str) {
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(java.lang.Float.parseFloat(str));
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
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
            m();
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, this.w);
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.APID, this.u);
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "1");
            jSONObject.put("at", "10");
            if (!android.text.TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            android.graphics.Rect a = com.baidu.mobads.sdk.internal.ba.a(this.i);
            this.x = a.width();
            this.y = a.height();
            if (this.i.getResources().getConfiguration().orientation == 2) {
                this.x = a.height();
                this.y = a.width();
            }
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "" + this.x);
            jSONObject.put("h", "" + this.y);
            jSONObject.put("opt", 1);
            if (com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.w)) {
                jSONObject.put("msa", 5285);
            }
            jSONObject = com.baidu.mobads.sdk.internal.m.a(jSONObject, b(this.o));
            b(jSONObject);
            return jSONObject;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    public void j(java.lang.String str) {
        this.A = str;
    }

    public java.lang.Object k(java.lang.String str) {
        if (this.B != null) {
            return "request_id".equals(str) ? this.B.V() : this.B.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public org.json.JSONObject k() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("timeout", 8000);
            jSONObject.put("useSurfaceView", this.a);
            jSONObject.put("downloadConfirmPolicy", this.t);
            jSONObject.put("userid", this.z);
            jSONObject.put("extra", this.A);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void q() {
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void s() {
        com.baidu.mobads.sdk.api.ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public java.lang.String x() {
        com.baidu.mobads.sdk.internal.a aVar = this.B;
        return aVar != null ? aVar.A() : "";
    }
}
