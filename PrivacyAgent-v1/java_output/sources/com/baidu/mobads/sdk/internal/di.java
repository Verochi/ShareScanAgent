package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class di extends com.baidu.mobads.sdk.internal.bi {
    private static int J;
    private static com.baidu.mobads.sdk.internal.di P;
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private com.baidu.mobads.sdk.api.SplashAdListener K;
    private com.baidu.mobads.sdk.api.SplashAd.OnFinishListener L;
    private com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener M;
    private com.baidu.mobads.sdk.api.SplashAd.SplashCardAdListener N;
    private com.baidu.mobads.sdk.api.RequestParameters O;
    private com.baidu.mobads.sdk.internal.a Q;
    private com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener R;
    private java.util.HashMap<java.lang.String, java.lang.String> S;
    protected int a;
    protected int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    private android.widget.RelativeLayout y;
    private java.lang.String z;

    public di(android.content.Context context, java.lang.String str, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context);
        this.I = 60;
        this.a = 67;
        this.t = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
        this.v = false;
        this.w = false;
        this.x = false;
        this.z = str;
        this.A = i;
        this.B = i2;
        this.C = i3;
        this.D = i4;
        this.E = z;
        this.F = z2;
        this.G = z4;
        this.H = z3;
    }

    public static void a(android.app.Activity activity, org.json.JSONObject jSONObject, com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener) {
        com.baidu.mobads.sdk.internal.di diVar = P;
        if (diVar != null) {
            diVar.a(splashFocusAdListener);
            java.util.HashMap hashMap = new java.util.HashMap();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                try {
                    jSONObject2.putOpt(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    P.a(jSONObject2, hashMap);
                } finally {
                    P = null;
                }
            } catch (org.json.JSONException e) {
                com.baidu.mobads.sdk.internal.bt.a().c(e);
            } catch (java.lang.Throwable th) {
                com.baidu.mobads.sdk.internal.bt.a().c(th);
            }
        }
    }

    private void b(android.content.Intent intent, com.baidu.mobads.sdk.api.SplashAd.OnFinishListener onFinishListener) {
        android.content.Context context = this.i;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof android.app.Activity)) {
            intent.addFlags(268435456);
        }
        this.i.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        android.content.Context context2 = this.i;
        if (context2 instanceof android.app.Activity) {
            ((android.app.Activity) context2).finish();
        }
    }

    public static void e(int i) {
        J = i;
    }

    private java.lang.String k(java.lang.String str) {
        if (this.O == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.util.Map<java.lang.String, java.lang.String> extras = this.O.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (java.lang.Throwable th) {
            this.k.d(com.baidu.mobads.sdk.internal.bi.b, th);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener == null) {
            this.n = false;
            return;
        }
        this.n = true;
        if (!this.u) {
            iAdInterListener.setAdContainer(this.y);
        }
        this.m.loadAd(j(), k());
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i, java.lang.String str, java.lang.String str2) {
        this.x = true;
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i, str, str2);
    }

    public void a(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable com.baidu.mobads.sdk.api.SplashAd.OnFinishListener onFinishListener) {
        try {
            if (this.v || intent == null || this.m == null || this.x || !(this.i instanceof android.app.Activity)) {
                b(intent, onFinishListener);
                return;
            }
            this.L = onFinishListener;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.util.HashMap hashMap = new java.util.HashMap();
            try {
                jSONObject.putOpt(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, "splash_focus_start_activity");
                hashMap.put("splash_focus_user_intent", intent);
            } catch (org.json.JSONException e) {
                com.baidu.mobads.sdk.internal.bt.a().a(e);
            }
            this.m.removeAllListeners();
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.Y, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.L, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.G, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.V, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.W, this.l);
            a(jSONObject, hashMap);
            this.K = null;
            P = this;
            com.baidu.mobads.sdk.internal.bd.a().a(new com.baidu.mobads.sdk.internal.dj(this), 3L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
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

    public void a(android.widget.RelativeLayout relativeLayout) {
        this.y = relativeLayout;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.List<com.baidu.mobads.sdk.internal.a> a;
        if (iOAdEvent != null && (a = com.baidu.mobads.sdk.internal.b.a(iOAdEvent.getMessage()).a()) != null && a.size() > 0) {
            this.Q = a.get(0);
        }
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    public void a(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        this.O = requestParameters;
        c(requestParameters.getExt());
    }

    public void a(com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.R = splashAdDownloadDialogListener;
    }

    public void a(com.baidu.mobads.sdk.api.SplashAd.SplashCardAdListener splashCardAdListener) {
        this.N = splashCardAdListener;
        this.w = false;
    }

    public void a(com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.M = splashFocusAdListener;
        this.w = false;
    }

    public void a(com.baidu.mobads.sdk.api.SplashAdListener splashAdListener) {
        this.K = splashAdListener;
    }

    public void a(java.lang.String str) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("msg", str);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (org.json.JSONException e) {
                com.baidu.mobads.sdk.internal.bt.a().a(e);
            }
            a(jSONObject, hashMap);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, int i, java.lang.String str2) {
        this.x = true;
        if (this.K != null) {
            a(i + "==" + str);
            this.K.onAdFailed(str);
        }
        super.a(str, i, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, boolean z) {
        com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(boolean z, java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.a aVar = this.Q;
        if (aVar != null) {
            a(aVar.I(), z, linkedHashMap, biddingListener);
        } else {
            a(this.j, z, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
            ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(java.lang.String str, boolean z) {
        com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    public boolean b(android.app.Activity activity) {
        java.util.HashMap hashMap = new java.util.HashMap();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            this.m.removeAllListeners();
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.L, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.G, this.l);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.V, this.l);
            this.K = null;
            jSONObject.putOpt(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, "splash_focus_card");
            hashMap.put("splash_focus_activity", activity);
            a(jSONObject, hashMap);
            java.lang.Object obj = hashMap.get("splash_focus_card_show");
            if (obj instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) obj).booleanValue();
            }
            return false;
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().c(e);
            return false;
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th);
            return false;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
            ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c();
    }

    public void c(int i) {
        this.t = i;
    }

    public void c(java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            this.S = com.baidu.mobads.sdk.internal.m.a(map);
        } catch (java.lang.Throwable unused) {
            this.S = new java.util.HashMap<>();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
            ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onLpClosed();
        }
        com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    public void d(int i) {
        this.I = i;
    }

    public void e() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener;
        if (this.u || (iAdInterListener = this.m) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.y);
        this.m.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
            return;
        }
        ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdExposed();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(java.lang.String str) {
        com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(java.lang.String str) {
        com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpShow();
    }

    public boolean f() {
        java.util.HashMap hashMap = new java.util.HashMap();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, "splash_focus_card_enable");
            a(jSONObject, hashMap);
            java.lang.Object obj = hashMap.get("splash_focus_card_enable");
            if (obj instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) obj).booleanValue();
            }
            return false;
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().c(e);
            return false;
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th);
            return false;
        }
    }

    public com.baidu.mobads.sdk.internal.a g() {
        return this.Q;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (this.w) {
            return;
        }
        this.w = true;
        java.util.Map<java.lang.String, java.lang.Object> data = iOAdEvent.getData();
        if (this.M != null && data != null && data.containsKey("splash_close_reason")) {
            this.M.onAdClose();
            return;
        }
        com.baidu.mobads.sdk.api.SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClose();
            return;
        }
        super.g(iOAdEvent);
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
            return;
        }
        ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(java.lang.String str) {
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener == null || !(splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
            return;
        }
        ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdSkip();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        this.v = true;
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
            ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdClick();
        }
        com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
        com.baidu.mobads.sdk.api.SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClick();
        }
    }

    public java.lang.Object j(java.lang.String str) {
        if (this.Q != null) {
            return "request_id".equals(str) ? this.Q.V() : this.Q.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public org.json.JSONObject j() {
        java.lang.String str = "1";
        this.f295s = java.lang.System.currentTimeMillis();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.m.createProdHandler(jSONObject2);
            m();
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.APID, this.z);
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "1");
            jSONObject.put("at", "26");
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "" + this.A);
            jSONObject.put("h", "" + this.B);
            jSONObject.put("msa", 399);
            if (!android.text.TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            java.lang.String k = k(com.baidu.mobads.sdk.api.SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!android.text.TextUtils.isEmpty(k)) {
                if (!java.lang.Boolean.parseBoolean(k)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = com.baidu.mobads.sdk.internal.m.a(jSONObject, b(this.S));
            b(jSONObject);
            return jSONObject;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public org.json.JSONObject k() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("timeout", this.D);
            jSONObject.put("splashTipStyle", this.C);
            jSONObject.put("bitmapDisplayMode", J);
            jSONObject.put("countDownNew", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            jSONObject.put("Display_Down_Info", "" + this.E);
            jSONObject.put("popDialogIfDl", "" + this.F);
            jSONObject.put("limitRegionClick", "" + this.G);
            jSONObject.put("displayClickButton", "" + this.H);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.u);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.I);
            jSONObject.put("twistLogoHeightDp", this.a);
            jSONObject.put("twistBgColor", this.t);
            com.baidu.mobads.sdk.api.RequestParameters requestParameters = this.O;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            return com.baidu.mobads.sdk.internal.m.a(jSONObject, b(this.o));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void q() {
        com.baidu.mobads.sdk.api.SplashAdListener splashAdListener = this.K;
        if (splashAdListener != null && (splashAdListener instanceof com.baidu.mobads.sdk.api.SplashInteractionListener)) {
            ((com.baidu.mobads.sdk.api.SplashInteractionListener) splashAdListener).onAdPresent();
        }
        com.baidu.mobads.sdk.api.SplashAd.SplashFocusAdListener splashFocusAdListener = this.M;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdIconShow();
        }
        com.baidu.mobads.sdk.api.SplashAd.SplashCardAdListener splashCardAdListener = this.N;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void t() {
        com.baidu.mobads.sdk.api.SplashAd.OnFinishListener onFinishListener = this.L;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.L = null;
        } else {
            android.content.Context context = this.i;
            if (context instanceof android.app.Activity) {
                ((android.app.Activity) context).finish();
            }
        }
        this.i = null;
        this.y = null;
        super.t();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void u() {
        com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void v() {
        com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.R;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof com.baidu.mobads.sdk.api.SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpClose();
    }
}
