package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATInitManager extends com.anythink.core.api.ATInitMediation {
    public static final java.lang.String TAG = "TTATInitManager";
    private static volatile com.anythink.network.toutiao.TTATInitManager e;
    com.bytedance.sdk.openadsdk.TTCustomController a;
    java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.anythink.network.toutiao.TTATBiddingInfo>> b;
    private boolean h;
    private java.util.List<com.anythink.core.api.MediationInitCallback> j;
    private java.util.Map<java.lang.String, java.lang.ref.WeakReference> g = new java.util.concurrent.ConcurrentHashMap();
    private final java.lang.Object k = new java.lang.Object();
    private final long l = 100;
    int c = 0;
    java.lang.String d = com.anythink.core.c.b.d.a.h;
    private boolean f = true;
    private java.util.concurrent.atomic.AtomicBoolean i = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: com.anythink.network.toutiao.TTATInitManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ int[] c;
        final /* synthetic */ android.content.Context d;

        /* renamed from: com.anythink.network.toutiao.TTATInitManager$1$1, reason: invalid class name and collision with other inner class name */
        public class C02411 implements com.bytedance.sdk.openadsdk.TTAdSdk.Callback {

            /* renamed from: com.anythink.network.toutiao.TTATInitManager$1$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC02421 implements java.lang.Runnable {
                public RunnableC02421() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.network.toutiao.TTATInitManager.b(com.anythink.network.toutiao.TTATInitManager.this);
                    com.anythink.network.toutiao.TTATInitManager.a(com.anythink.network.toutiao.TTATInitManager.this, true, (java.lang.String) null, (java.lang.String) null);
                }
            }

            public C02411() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public final void fail(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATInitManager.a(com.anythink.network.toutiao.TTATInitManager.this, false, java.lang.String.valueOf(i), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public final void success() {
                com.anythink.network.toutiao.TTATInitManager.this.runOnThreadPool(new com.anythink.network.toutiao.TTATInitManager.AnonymousClass1.C02411.RunnableC02421());
            }
        }

        public AnonymousClass1(java.lang.String str, java.lang.String str2, int[] iArr, android.content.Context context) {
            this.a = str;
            this.b = str2;
            this.c = iArr;
            this.d = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.bytedance.sdk.openadsdk.TTAdConfig.Builder supportMultiProcess = new com.bytedance.sdk.openadsdk.TTAdConfig.Builder().appId(this.a).appName(this.b).titleBarTheme(1).directDownloadNetworkType(this.c).supportMultiProcess(false);
                java.lang.String a = com.anythink.network.toutiao.TTATInitManager.this.a();
                if (!android.text.TextUtils.isEmpty(a)) {
                    supportMultiProcess.data(a);
                }
                com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = com.anythink.network.toutiao.TTATInitManager.this.a;
                if (tTCustomController != null) {
                    supportMultiProcess.customController(tTCustomController);
                }
                com.bytedance.sdk.openadsdk.TTAdSdk.init(this.d, supportMultiProcess.build());
                com.bytedance.sdk.openadsdk.TTAdSdk.start(new com.anythink.network.toutiao.TTATInitManager.AnonymousClass1.C02411());
            } catch (java.lang.Throwable th) {
                com.anythink.network.toutiao.TTATInitManager.a(com.anythink.network.toutiao.TTATInitManager.this, false, "", th.getMessage());
            }
        }
    }

    private TTATInitManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a() {
        try {
            if (this.c == com.anythink.core.api.ATSDK.getPersionalizedAdStatus()) {
                return "";
            }
            try {
                this.c = com.anythink.core.api.ATSDK.getPersionalizedAdStatus();
            } catch (java.lang.Throwable unused) {
            }
            java.lang.String str = this.c == 2 ? "0" : "";
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put("value", str);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONArray.put(jSONObject);
            java.lang.String jSONArray2 = jSONArray.toString();
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                "TTPrivateData:".concat(java.lang.String.valueOf(jSONArray2));
            }
            return jSONArray2;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATInitManager tTATInitManager, boolean z, java.lang.String str, java.lang.String str2) {
        synchronized (tTATInitManager.k) {
            int size = tTATInitManager.j.size();
            for (int i = 0; i < size; i++) {
                com.anythink.core.api.MediationInitCallback mediationInitCallback = tTATInitManager.j.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            tTATInitManager.j.clear();
            tTATInitManager.i.set(false);
        }
    }

    private void a(boolean z, java.lang.String str, java.lang.String str2) {
        synchronized (this.k) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                com.anythink.core.api.MediationInitCallback mediationInitCallback = this.j.get(i);
                if (mediationInitCallback != null) {
                    if (z) {
                        mediationInitCallback.onSuccess();
                    } else {
                        mediationInitCallback.onFail(str + " | " + str2);
                    }
                }
            }
            this.j.clear();
            this.i.set(false);
        }
    }

    public static /* synthetic */ boolean b(com.anythink.network.toutiao.TTATInitManager tTATInitManager) {
        tTATInitManager.h = true;
        return true;
    }

    public static com.anythink.network.toutiao.TTATInitManager getInstance() {
        if (e == null) {
            synchronized (com.anythink.network.toutiao.TTATInitManager.class) {
                if (e == null) {
                    e = new com.anythink.network.toutiao.TTATInitManager();
                }
            }
        }
        return e;
    }

    public final synchronized void a(java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.api.BaseAd baseAd, com.bytedance.sdk.openadsdk.TTClientBidding tTClientBidding, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        double parseDouble;
        if (aTBiddingListener != null) {
            if (map != null) {
                if (map.containsKey(this.d)) {
                    try {
                        parseDouble = java.lang.Double.parseDouble(java.lang.String.valueOf(map.get(this.d)));
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    com.anythink.network.toutiao.TTATBiddingNotify tTATBiddingNotify = new com.anythink.network.toutiao.TTATBiddingNotify(tTClientBidding);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(java.lang.System.currentTimeMillis());
                    aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(parseDouble, sb.toString(), tTATBiddingNotify, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), baseAd);
                }
            }
            parseDouble = 0.0d;
            com.anythink.network.toutiao.TTATBiddingNotify tTATBiddingNotify2 = new com.anythink.network.toutiao.TTATBiddingNotify(tTClientBidding);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(java.lang.System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.success(parseDouble, sb2.toString(), tTATBiddingNotify2, com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT), baseAd);
        }
    }

    public final synchronized void a(java.util.Map<java.lang.String, java.lang.Object> map, com.bytedance.sdk.openadsdk.TTClientBidding tTClientBidding, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        a(map, (com.anythink.core.api.BaseAd) null, tTClientBidding, aTBiddingListener);
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getAdapterVersion() {
        return "UA_6.2.66.2";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkName() {
        return "CSJ";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkSDKClass() {
        return "com.bytedance.sdk.openadsdk.TTAdSdk";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkVersion() {
        return com.anythink.network.toutiao.TTATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.util.List getPermissionStatus() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.util.List getProviderStatus() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider");
        arrayList.add("com.bytedance.sdk.openadsdk.TTFileProvider");
        return arrayList;
    }

    public void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        initSDK(context, map, null);
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.api.MediationInitCallback mediationInitCallback) {
        if (com.bytedance.sdk.openadsdk.TTAdSdk.isInitSuccess() || this.h) {
            java.lang.String a = a();
            if (!android.text.TextUtils.isEmpty(a)) {
                com.bytedance.sdk.openadsdk.TTAdSdk.updateAdConfig(new com.bytedance.sdk.openadsdk.TTAdConfig.Builder().data(a).build());
            }
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.k) {
            if (this.i.get()) {
                if (mediationInitCallback != null) {
                    this.j.add(mediationInitCallback);
                }
                return;
            }
            if (this.j == null) {
                this.j = new java.util.ArrayList();
            }
            this.i.set(true);
            java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
            if (mediationInitCallback != null) {
                this.j.add(mediationInitCallback);
            }
            runOnMainThread(new com.anythink.network.toutiao.TTATInitManager.AnonymousClass1(stringFromMap, context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString(), this.f ? new int[]{1, 2, 3, 4, 5} : new int[]{2}, context.getApplicationContext()));
        }
    }

    public void setIsOpenDirectDownload(boolean z) {
        this.f = z;
    }

    public void setTtCustomController(com.bytedance.sdk.openadsdk.TTCustomController tTCustomController) {
        this.a = tTCustomController;
    }
}
