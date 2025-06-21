package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ae extends com.baidu.mobads.sdk.internal.bi {
    public static final int a = 17;
    private static final java.lang.String t = "javascript:";
    private com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener A;
    private com.baidu.mobads.sdk.api.NativeCPUManager B;
    private int C;
    private int D;
    private boolean E;
    private java.lang.String F;
    private int u;
    private int v;
    private int[] w;
    private boolean x;
    private int y;
    private java.util.HashMap<java.lang.String, java.lang.Object> z;

    public ae(android.content.Context context) {
        super(context);
        this.C = 5;
        this.D = 60;
    }

    public ae(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.NativeCPUManager nativeCPUManager) {
        super(context);
        this.C = 5;
        this.D = 60;
        this.q = str;
        this.B = nativeCPUManager;
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

    private java.lang.String j(java.lang.String str) {
        com.baidu.mobads.sdk.api.IXAdContainerFactory c;
        com.baidu.mobads.sdk.internal.aa a2 = com.baidu.mobads.sdk.internal.aa.a();
        if (a2 != null && (c = a2.c()) != null) {
            java.lang.Object remoteParam = c.getRemoteParam(str, new java.lang.Object[0]);
            if (remoteParam instanceof java.lang.String) {
                return (java.lang.String) remoteParam;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
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
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, "cpu");
            this.m.createProdHandler(jSONObject3);
            m();
            this.m.addEventListener("Update_fbReader_Setting", new com.baidu.mobads.sdk.internal.af(this));
            this.m.addEventListener("closeInterstitialAd", new com.baidu.mobads.sdk.internal.ag(this));
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, "cpu");
            jSONObject.put("appsid", this.q);
            jSONObject.put("pageIndex", this.v);
            jSONObject.put("pageSize", this.u);
            jSONObject.put("channels", this.w);
            jSONObject.put("showAd", this.x);
            jSONObject.put("openActivitylink", this.F);
            if (!android.text.TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            jSONObject2.put("timeout", this.y);
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = this.z;
            if (hashMap == null || hashMap.isEmpty()) {
                com.baidu.mobads.sdk.internal.ay.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = com.baidu.mobads.sdk.internal.m.a(this.z);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.E);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        this.m.loadAd(jSONObject, jSONObject2);
    }

    public void a(int i) {
        this.y = i;
    }

    public void a(int i, int i2, int[] iArr, boolean z, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        this.v = i;
        this.u = i2;
        this.w = iArr;
        this.x = z;
        this.z = hashMap;
        this.E = com.baidu.mobads.sdk.internal.an.f();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i, java.lang.String str, java.lang.String str2) {
        super.a(i, str, str2);
        com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    public void a(android.webkit.WebView webView, org.json.JSONObject jSONObject) {
        com.baidu.mobads.sdk.internal.bi.a(new com.baidu.mobads.sdk.internal.ai(this, jSONObject, webView));
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (this.A != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator it = ((java.util.List) iOAdEvent.getData().get("cpuAdList")).iterator();
            while (it.hasNext()) {
                com.baidu.mobads.sdk.api.NativeCPUAdData nativeCPUAdData = new com.baidu.mobads.sdk.api.NativeCPUAdData(this.i, it.next(), this.z);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.A.onAdLoaded(arrayList);
        }
    }

    public void a(com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener cPUAdListener) {
        this.A = cPUAdListener;
    }

    public void a(java.lang.String str) {
        this.F = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, int i, java.lang.String str2) {
        super.a(str, i, str2);
        com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            java.util.Map<java.lang.String, java.lang.Object> data = iOAdEvent.getData();
            java.lang.Integer num = (java.lang.Integer) data.get(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION);
            java.lang.String str = (java.lang.String) data.get("mislikereason");
            com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener cPUAdListener = this.A;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        try {
            if (this.A == null || iOAdEvent == null) {
                return;
            }
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = (java.util.HashMap) iOAdEvent.getData();
            this.A.onLpCustomEventCallBack(hashMap, new com.baidu.mobads.sdk.internal.ah(this, hashMap.get("activity")));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        com.baidu.mobads.sdk.internal.an.a(this.C);
        com.baidu.mobads.sdk.internal.an.b(this.D);
        com.baidu.mobads.sdk.internal.an.a(new com.baidu.mobads.sdk.internal.aj(this));
    }

    public android.app.Activity f() {
        return com.baidu.mobads.sdk.internal.an.c();
    }

    public boolean g() {
        return com.baidu.mobads.sdk.internal.an.d();
    }
}
