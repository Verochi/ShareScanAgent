package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class cx extends com.baidu.mobads.sdk.internal.bi {
    public static final java.lang.String A = "pre_chapter_adstart_countdown";
    public static final java.lang.String B = "try_get_cuid";
    private static final java.lang.String J = "cx";
    public static final java.lang.String a = "enter_refresh_bookstore";
    public static final java.lang.String t = "enter_reader";
    public static final java.lang.String u = "notify_impression";
    public static final java.lang.String v = "request_int_ad_view";
    public static final java.lang.String w = "request_banner_ad_view";
    public static final java.lang.String x = "request_bookstore_bottom_view";
    public static final java.lang.String y = "request_shelf_ad_view";
    public static final java.lang.String z = "reader_background_status_change";
    public java.util.HashMap<java.lang.String, java.lang.Object> C;
    public java.lang.String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public java.lang.String I;
    private com.baidu.mobads.sdk.api.CPUNovelAd.CpuNovelListener K;
    private java.lang.ref.SoftReference<android.widget.RelativeLayout> L;

    public cx(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.E = 5;
        this.F = 60;
        this.G = 0;
        this.H = 10006;
        this.I = "";
        this.D = str;
        this.C = (java.util.HashMap) cPUWebAdRequestParam.getParameters();
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
            java.lang.Object obj8 = map.get("motivateDeeplinkAdSwitch");
            java.lang.Object obj9 = map.get("motivateDeeplinkAdFrequency");
            java.lang.Object obj10 = map.get("motivateDeeplinkAdExpTime");
            java.lang.Object obj11 = map.get("motivateDeeplinkNoAdTime");
            java.lang.Object obj12 = map.get("isStartRewardAdTimer");
            java.lang.Object obj13 = map.get("temporaryAdDensitySwitch");
            java.lang.Object obj14 = map.get("temporaryAdDensityTimes");
            java.lang.Object obj15 = map.get("temporaryAdDensityScreen");
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
            if ((obj8 instanceof java.lang.Boolean) && (obj9 instanceof java.lang.Integer) && (obj10 instanceof java.lang.Integer) && (obj11 instanceof java.lang.Integer)) {
                com.baidu.mobads.sdk.internal.an.a(((java.lang.Boolean) obj8).booleanValue(), ((java.lang.Integer) obj9).intValue(), ((java.lang.Integer) obj10).intValue(), ((java.lang.Integer) obj11).intValue());
            }
            if ((obj12 instanceof java.lang.Boolean) && ((java.lang.Boolean) obj12).booleanValue()) {
                com.baidu.mobads.sdk.internal.an.h();
            }
            if ((obj13 instanceof java.lang.Boolean) && ((java.lang.Boolean) obj13).booleanValue() && (obj14 instanceof java.lang.Integer) && (obj15 instanceof java.lang.Integer)) {
                com.baidu.mobads.sdk.internal.an.b(((java.lang.Integer) obj14).intValue(), ((java.lang.Integer) obj15).intValue());
            } else {
                com.baidu.mobads.sdk.internal.an.b(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.baidu.mobads.sdk.internal.an.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        e();
        if (this.m == null) {
            this.n = false;
            return;
        }
        this.n = true;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, "novel");
            this.m.createProdHandler(jSONObject);
            m();
            this.m.addEventListener("Update_fbReader_Setting", new com.baidu.mobads.sdk.internal.cy(this));
            this.m.addEventListener("closeInterstitialAd", new com.baidu.mobads.sdk.internal.cz(this));
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (!android.text.TextUtils.isEmpty(this.D)) {
                jSONObject2.put("appid", this.D);
            }
            jSONObject2.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, "novel");
            this.m.loadAd(jSONObject2, com.baidu.mobads.sdk.internal.m.a(this.C));
        } catch (java.lang.Throwable th) {
            this.k.c(J, th);
        }
    }

    public void a(com.baidu.mobads.sdk.api.CPUNovelAd.CpuNovelListener cpuNovelListener) {
        this.K = cpuNovelListener;
    }

    public void e() {
        com.baidu.mobads.sdk.internal.an.a(this.E);
        com.baidu.mobads.sdk.internal.an.b(this.F);
        com.baidu.mobads.sdk.internal.an.a(new com.baidu.mobads.sdk.internal.da(this));
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        com.baidu.mobads.sdk.api.CPUNovelAd.CpuNovelListener cpuNovelListener = this.K;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdImpression();
        }
    }

    public android.app.Activity f() {
        return com.baidu.mobads.sdk.internal.an.c();
    }

    public boolean g() {
        return com.baidu.mobads.sdk.internal.an.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        com.baidu.mobads.sdk.api.CPUNovelAd.CpuNovelListener cpuNovelListener = this.K;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public android.view.View w() {
        android.view.View a2 = com.baidu.mobads.sdk.internal.an.a(this.i);
        if (a2 instanceof android.widget.FrameLayout) {
            android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this.i);
            this.L = new java.lang.ref.SoftReference<>(relativeLayout);
            relativeLayout.setId(33);
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, com.baidu.mobads.sdk.internal.ba.a(this.i, 53.0f));
            layoutParams.gravity = 80;
            ((android.widget.FrameLayout) a2).addView(relativeLayout, layoutParams);
            if (com.baidu.mobads.sdk.internal.bm.a((android.content.Context) null).a() >= 18) {
                relativeLayout.getViewTreeObserver().addOnWindowFocusChangeListener(new com.baidu.mobads.sdk.internal.db(this, relativeLayout));
            }
        }
        return a2;
    }

    public boolean x() {
        return com.baidu.mobads.sdk.internal.an.e();
    }

    public void y() {
        com.baidu.mobads.sdk.internal.an.g();
    }
}
