package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATInitManager extends com.anythink.core.api.ATInitMediation {
    public static final java.lang.String TAG = "GDTATInitManager";
    private static volatile com.anythink.network.gdt.GDTATInitManager b;
    private boolean f;
    private java.lang.String g;
    private java.util.Map<java.lang.String, java.lang.ref.WeakReference> c = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Map<java.lang.String, com.qq.e.ads.rewardvideo.RewardVideoAD> d = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Map<java.lang.String, com.qq.e.ads.interstitial2.UnifiedInterstitialAD> e = new java.util.concurrent.ConcurrentHashMap();
    private final java.lang.Object h = new java.lang.Object();
    int a = 0;

    /* renamed from: com.anythink.network.gdt.GDTATInitManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ java.util.Map a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ com.anythink.core.api.ATBidRequestInfoListener c;

        /* renamed from: com.anythink.network.gdt.GDTATInitManager$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC02371 implements java.lang.Runnable {
            public RunnableC02371() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.network.gdt.GDTBidRequestInfo gDTBidRequestInfo;
                synchronized (com.anythink.network.gdt.GDTATInitManager.this.h) {
                    gDTBidRequestInfo = new com.anythink.network.gdt.GDTBidRequestInfo(com.anythink.network.gdt.GDTATInitManager.AnonymousClass1.this.a);
                }
                if (gDTBidRequestInfo.isValid()) {
                    com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener = com.anythink.network.gdt.GDTATInitManager.AnonymousClass1.this.c;
                    if (aTBidRequestInfoListener != null) {
                        aTBidRequestInfoListener.onSuccess(gDTBidRequestInfo);
                        return;
                    }
                    return;
                }
                com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener2 = com.anythink.network.gdt.GDTATInitManager.AnonymousClass1.this.c;
                if (aTBidRequestInfoListener2 != null) {
                    aTBidRequestInfoListener2.onFailed(com.anythink.core.api.ATBidRequestInfo.BIDTOKEN_EMPTY_ERROR_TYPE);
                }
            }
        }

        public AnonymousClass1(java.util.Map map, java.util.Map map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
            this.a = map;
            this.b = map2;
            this.c = aTBidRequestInfoListener;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener = this.c;
            if (aTBidRequestInfoListener != null) {
                aTBidRequestInfoListener.onFailed(com.anythink.core.api.ATBidRequestInfo.INIT_ERROR_TYPE);
            }
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            com.anythink.network.gdt.GDTATInitManager.this.runOnThreadPool(new com.anythink.network.gdt.GDTATInitManager.AnonymousClass1.RunnableC02371());
        }
    }

    private GDTATInitManager() {
    }

    public static int a(android.content.Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    public static com.qq.e.comm.constants.LoadAdParams a(java.util.Map<java.lang.String, java.lang.Object> map) {
        com.qq.e.comm.constants.LoadAdParams loadAdParams = new com.qq.e.comm.constants.LoadAdParams();
        java.util.HashMap hashMap = new java.util.HashMap();
        a(hashMap, map);
        loadAdParams.setDevExtra(hashMap);
        return loadAdParams;
    }

    public static void a(java.util.Map map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        try {
            java.lang.Object obj = map2.get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.STACK_INFO);
            map.put("staIn", obj != null ? obj.toString() : "");
            map.put("meSrc", "299");
            java.lang.Object obj2 = map2.get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.MEDIATION_WF_ID);
            map.put("thrmei", obj2 != null ? obj2.toString() : "");
        } catch (java.lang.Exception unused) {
        }
    }

    private void c() {
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.ref.WeakReference> entry : this.c.entrySet()) {
                if (entry.getValue().get() == null) {
                    this.c.remove(entry.getKey());
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static com.anythink.network.gdt.GDTATInitManager getInstance() {
        if (b == null) {
            synchronized (com.anythink.network.gdt.GDTATInitManager.class) {
                if (b == null) {
                    b = new com.anythink.network.gdt.GDTATInitManager();
                }
            }
        }
        return b;
    }

    public final void a() {
        this.d.clear();
    }

    public final void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        getInstance().initSDK(context, map, new com.anythink.network.gdt.GDTATInitManager.AnonymousClass1(map, map2, aTBidRequestInfoListener));
    }

    public final void a(java.lang.String str, com.qq.e.ads.interstitial2.UnifiedInterstitialAD unifiedInterstitialAD) {
        this.e.clear();
        this.e.put(str, unifiedInterstitialAD);
    }

    public final void a(java.lang.String str, com.qq.e.ads.rewardvideo.RewardVideoAD rewardVideoAD) {
        this.d.clear();
        this.d.put(str, rewardVideoAD);
    }

    public final void a(java.lang.String str, java.lang.ref.WeakReference weakReference) {
        try {
            this.c.put(str, weakReference);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void b() {
        this.e.clear();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.util.List getActivityStatus() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("com.qq.e.ads.ADActivity");
        arrayList.add("com.qq.e.ads.PortraitADActivity");
        arrayList.add("com.qq.e.ads.LandscapeADActivity");
        arrayList.add("com.qq.e.ads.RewardvideoPortraitADActivity");
        arrayList.add("com.qq.e.ads.RewardvideoLandscapeADActivity");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getAdapterVersion() {
        return "UA_6.2.66.2";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkName() {
        return "Tencent";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkSDKClass() {
        return "com.qq.e.ads.ADActivity";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkVersion() {
        return com.anythink.network.gdt.GDTATConst.getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.util.List getServiceStatus() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("com.qq.e.comm.DownloadService");
        return arrayList;
    }

    public synchronized void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        initSDK(context, map, null);
    }

    @Override // com.anythink.core.api.ATInitMediation
    public synchronized void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.api.MediationInitCallback mediationInitCallback) {
        try {
            this.a = com.anythink.core.api.ATSDK.getPersionalizedAdStatus();
        } catch (java.lang.Throwable unused) {
        }
        if (this.a == 2) {
            com.qq.e.comm.managers.setting.GlobalSetting.setPersonalizedState(1);
        } else {
            com.qq.e.comm.managers.setting.GlobalSetting.setPersonalizedState(0);
        }
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            new java.lang.StringBuilder("GlobalSetting.getPersonalizedState():").append(com.qq.e.comm.managers.setting.GlobalSetting.getPersonalizedState());
        }
        c();
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "app_id");
        if (map.containsKey(com.anythink.core.api.ATInitMediation.KEY_LOCAL)) {
            this.g = stringFromMap;
        } else {
            java.lang.String str = this.g;
            if (str != null && !android.text.TextUtils.equals(str, stringFromMap)) {
                checkToSaveInitData(getNetworkName(), map, this.g);
                this.g = null;
            }
        }
        if (!this.f) {
            com.qq.e.comm.managers.GDTAdSdk.init(context.getApplicationContext(), stringFromMap);
            this.f = true;
        }
        if (mediationInitCallback != null) {
            mediationInitCallback.onSuccess();
        }
    }

    public void setGDTATCustomController(com.anythink.network.gdt.GDTATCustomController gDTATCustomController) {
        if (gDTATCustomController != null) {
            com.qq.e.comm.managers.setting.GlobalSetting.setAgreePrivacyStrategy(gDTATCustomController.getAgreePrivacyStrategy());
            try {
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("mac_address", java.lang.Boolean.valueOf(gDTATCustomController.isCanUseMacAddress()));
                hashMap.put("android_id", java.lang.Boolean.valueOf(gDTATCustomController.isCanUseAndroidId()));
                hashMap.put("device_id", java.lang.Boolean.valueOf(gDTATCustomController.isCanUseDeviceId()));
                com.qq.e.comm.managers.setting.GlobalSetting.setAgreeReadPrivacyInfo(hashMap);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
