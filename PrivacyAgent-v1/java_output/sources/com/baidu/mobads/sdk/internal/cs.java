package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class cs extends com.baidu.mobads.sdk.internal.bi {
    private java.util.HashMap<java.lang.String, java.lang.Object> a;
    private int t;
    private android.widget.RelativeLayout u;
    private com.baidu.mobads.sdk.api.CpuAdView.CpuAdViewInternalStatusListener v;

    public cs(android.content.Context context, android.widget.RelativeLayout relativeLayout, java.lang.String str, int i, com.baidu.mobads.sdk.api.CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.q = str;
        this.u = relativeLayout;
        this.t = i;
        if (cPUWebAdRequestParam == null) {
            com.baidu.mobads.sdk.internal.ay.c().e("内容联盟模板需要传入 CPUWebAdRequestParam配置信息");
        } else {
            this.a = (java.util.HashMap) cPUWebAdRequestParam.getParameters();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, java.lang.String str, int i3, int i4, java.lang.String str2) {
        com.baidu.mobads.sdk.internal.an.a(i);
        com.baidu.mobads.sdk.internal.an.b(i2);
        com.baidu.mobads.sdk.internal.an.a(new com.baidu.mobads.sdk.internal.cw(this, i3, i4, str2));
        com.baidu.mobads.sdk.internal.an.a(this.i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            java.lang.Object obj = map.get("adInnerPageInterval");
            java.lang.Object obj2 = map.get("adBottomRefreshInterval");
            java.lang.Object obj3 = map.get("adFrontChapterInterval");
            java.lang.Object obj4 = map.get("isShowFeeds");
            java.lang.Object obj5 = map.get("isAdSwitch");
            java.lang.Object obj6 = map.get("showCount");
            java.lang.Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                com.baidu.mobads.sdk.internal.an.a(((java.lang.Integer) obj).intValue());
                com.baidu.mobads.sdk.internal.an.b(((java.lang.Integer) obj2).intValue());
            }
            if ((obj3 instanceof java.lang.Integer) && (obj4 instanceof java.lang.Boolean)) {
                com.baidu.mobads.sdk.internal.an.a(((java.lang.Integer) obj3).intValue(), ((java.lang.Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof java.lang.Integer) {
                com.baidu.mobads.sdk.internal.an.a(((java.lang.Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof java.lang.Integer) && (obj7 instanceof java.lang.Integer)) {
                com.baidu.mobads.sdk.internal.an.a(((java.lang.Integer) obj6).intValue(), ((java.lang.Integer) obj7).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.baidu.mobads.sdk.internal.an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        if (this.m == null) {
            this.n = false;
            return;
        }
        this.n = true;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (this.m != null) {
            try {
                jSONObject.put("channel", this.t);
                jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, "cpu_h5");
                jSONObject.put("timeout", 10000);
                if (!android.text.TextUtils.isEmpty(this.q)) {
                    jSONObject.put("appid", this.q);
                }
                if (this.u != null) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    this.m.createProdHandler(jSONObject2);
                    this.m.setAdContainer(this.u);
                    m();
                    this.m.addEventListener("Update_fbReader_Setting", new com.baidu.mobads.sdk.internal.ct(this));
                    this.m.addEventListener("closeInterstitialAd", new com.baidu.mobads.sdk.internal.cu(this));
                    this.m.addEventListener("feOpenFbReader", new com.baidu.mobads.sdk.internal.cv(this));
                    org.json.JSONObject a = com.baidu.mobads.sdk.internal.m.a(this.a);
                    a.put("isInitNovelSDK", com.baidu.mobads.sdk.internal.an.f());
                    this.m.loadAd(jSONObject, a);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(com.baidu.mobads.sdk.api.CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.v = cpuAdViewInternalStatusListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, int i, java.lang.String str2) {
        com.baidu.mobads.sdk.api.CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.v;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        com.baidu.mobads.sdk.api.CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.v;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (this.v == null || iOAdEvent == null) {
            return;
        }
        this.v.onLpContentStatus(iOAdEvent.getData());
    }

    public android.app.Activity e() {
        return com.baidu.mobads.sdk.internal.an.c();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.Map<java.lang.String, java.lang.Object> data = iOAdEvent.getData();
        java.lang.Boolean bool = (java.lang.Boolean) data.get("isImpressionFeAd");
        java.lang.String str = (java.lang.String) data.get("nums");
        if (this.v != null && bool != null && bool.booleanValue()) {
            this.v.onAdImpression(str);
            return;
        }
        com.baidu.mobads.sdk.api.CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.v;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    public boolean f() {
        return com.baidu.mobads.sdk.internal.an.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.lang.Boolean bool = (java.lang.Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.v != null && bool != null && bool.booleanValue()) {
            this.v.onAdClick();
            return;
        }
        com.baidu.mobads.sdk.api.CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.v;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentClick();
    }
}
