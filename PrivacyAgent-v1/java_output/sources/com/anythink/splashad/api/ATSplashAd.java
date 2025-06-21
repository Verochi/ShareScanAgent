package com.anythink.splashad.api;

/* loaded from: classes12.dex */
public class ATSplashAd {
    public final int DEFAULT_SPLASH_TIMEOUT_TIME;
    final java.lang.String TAG;
    java.lang.ref.WeakReference<android.app.Activity> mActivityWeakRef;
    com.anythink.splashad.a.c mAdLoadManager;
    com.anythink.core.common.b.c mAdSourceEventListener;
    android.content.Context mContext;
    java.lang.String mDefaultAdSourceConfig;
    com.anythink.core.api.ATMediationRequestInfo mDefaultRequestInfo;
    com.anythink.core.api.ATAdSourceStatusListener mDeveloperStatusListener;
    com.anythink.core.api.ATEventInterface mDownloadListener;
    int mFetchAdTimeout;
    com.anythink.splashad.api.ATSplashAdListener mListener;
    java.lang.String mPlacementId;
    java.util.Map<java.lang.String, java.lang.Object> mTKExtraMap;

    /* renamed from: com.anythink.splashad.api.ATSplashAd$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.Map val$finalTkExtraMap;
        final /* synthetic */ int val$loadType;

        /* renamed from: com.anythink.splashad.api.ATSplashAd$1$1, reason: invalid class name and collision with other inner class name */
        public class C02461 extends com.anythink.splashad.a.b {
            boolean hasCacheWhenTimeout = false;
            final /* synthetic */ int val$finalTimeout;

            /* renamed from: com.anythink.splashad.api.ATSplashAd$1$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC02471 implements java.lang.Runnable {
                final /* synthetic */ boolean val$isTimeout;

                public RunnableC02471(boolean z) {
                    this.val$isTimeout = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461 c02461 = com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461.this;
                    com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener = com.anythink.splashad.api.ATSplashAd.this.mListener;
                    if (aTSplashAdListener != null) {
                        aTSplashAdListener.onAdLoaded(!c02461.hasCacheWhenTimeout && this.val$isTimeout);
                    }
                }
            }

            /* renamed from: com.anythink.splashad.api.ATSplashAd$1$1$2, reason: invalid class name */
            public class AnonymousClass2 implements java.lang.Runnable {
                final /* synthetic */ com.anythink.core.api.AdError val$adError;

                public AnonymousClass2(com.anythink.core.api.AdError adError) {
                    this.val$adError = adError;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener = com.anythink.splashad.api.ATSplashAd.this.mListener;
                    if (aTSplashAdListener != null) {
                        aTSplashAdListener.onNoAdError(this.val$adError);
                    }
                }
            }

            /* renamed from: com.anythink.splashad.api.ATSplashAd$1$1$3, reason: invalid class name */
            public class AnonymousClass3 implements java.lang.Runnable {
                final /* synthetic */ com.anythink.core.common.g val$mediationManager;
                final /* synthetic */ java.lang.String val$requestId;

                public AnonymousClass3(java.lang.String str, com.anythink.core.common.g gVar) {
                    this.val$requestId = str;
                    this.val$mediationManager = gVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    java.lang.String str = com.anythink.splashad.api.ATSplashAd.this.mPlacementId;
                    java.lang.String str2 = this.val$requestId;
                    com.anythink.core.common.g gVar = this.val$mediationManager;
                    com.anythink.core.common.n.c.a(str, str2, gVar != null ? gVar.i() : null, "2", (com.anythink.core.common.f.b) null, com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461.this.val$finalTimeout);
                    com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener = com.anythink.splashad.api.ATSplashAd.this.mListener;
                    if (aTSplashAdListener != null) {
                        aTSplashAdListener.onAdLoadTimeout();
                    }
                }
            }

            public C02461(int i) {
                this.val$finalTimeout = i;
            }

            @Override // com.anythink.splashad.a.b
            public void onAdLoaded(java.lang.String str, boolean z) {
                com.anythink.core.common.b.o.a().b(new com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461.RunnableC02471(z));
            }

            @Override // com.anythink.splashad.a.b
            public void onNoAdError(java.lang.String str, com.anythink.core.api.AdError adError) {
                com.anythink.core.common.b.o.a().b(new com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461.AnonymousClass2(adError));
            }

            @Override // com.anythink.splashad.a.b
            public void onTimeout(java.lang.String str) {
                com.anythink.core.common.g a = com.anythink.splashad.api.ATSplashAd.this.mAdLoadManager.a(str);
                com.anythink.core.common.a.b.a h = a != null ? a.h() : null;
                if (h != null) {
                    h.b();
                }
                com.anythink.splashad.api.ATSplashAd.AnonymousClass1 anonymousClass1 = com.anythink.splashad.api.ATSplashAd.AnonymousClass1.this;
                com.anythink.splashad.api.ATSplashAd aTSplashAd = com.anythink.splashad.api.ATSplashAd.this;
                com.anythink.core.common.f.b b = aTSplashAd.mAdLoadManager.b(aTSplashAd.mContext, anonymousClass1.val$finalTkExtraMap);
                if (b != null) {
                    this.hasCacheWhenTimeout = true;
                    if (a != null) {
                        if (h == null || h.f() != b) {
                            java.lang.String str2 = com.anythink.splashad.api.ATSplashAd.this.mPlacementId;
                            a.a(9);
                        } else {
                            java.lang.String str3 = com.anythink.splashad.api.ATSplashAd.this.mPlacementId;
                            a.a(11);
                        }
                        com.anythink.core.common.n.c.a(com.anythink.splashad.api.ATSplashAd.this.mPlacementId, str, a.i(), "1", b, this.val$finalTimeout);
                        return;
                    }
                }
                com.anythink.core.common.b.o.a().b(new com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461.AnonymousClass3(str, a));
            }
        }

        public AnonymousClass1(int i, java.util.Map map) {
            this.val$loadType = i;
            this.val$finalTkExtraMap = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            boolean z;
            com.anythink.splashad.api.ATSplashAd aTSplashAd = com.anythink.splashad.api.ATSplashAd.this;
            int i2 = aTSplashAd.mFetchAdTimeout;
            if (i2 <= 0) {
                com.anythink.core.d.a b = com.anythink.core.d.b.a(aTSplashAd.mContext).b(com.anythink.core.common.b.o.a().o());
                i = b.af() == 0 ? 5000 : (int) b.af();
                z = false;
            } else {
                i = i2;
                z = true;
            }
            java.lang.ref.WeakReference<android.app.Activity> weakReference = com.anythink.splashad.api.ATSplashAd.this.mActivityWeakRef;
            com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461 c02461 = null;
            android.app.Activity activity = weakReference != null ? weakReference.get() : null;
            if (this.val$loadType == 0) {
                c02461 = new com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461(i);
                c02461.startCountDown(i);
            }
            com.anythink.splashad.api.ATSplashAd.AnonymousClass1.C02461 c024612 = c02461;
            com.anythink.splashad.api.ATSplashAd aTSplashAd2 = com.anythink.splashad.api.ATSplashAd.this;
            com.anythink.splashad.a.c cVar = aTSplashAd2.mAdLoadManager;
            if (activity == null) {
                activity = aTSplashAd2.mContext;
            }
            cVar.a(activity, aTSplashAd2.mDefaultRequestInfo, aTSplashAd2.mDefaultAdSourceConfig, c024612, i, z, this.val$loadType, aTSplashAd2.mAdSourceEventListener, this.val$finalTkExtraMap);
        }
    }

    /* renamed from: com.anythink.splashad.api.ATSplashAd$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.splashad.a.a {

        /* renamed from: com.anythink.splashad.api.ATSplashAd$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.ATAdInfo val$entity;
            final /* synthetic */ boolean val$isSuccess;

            public AnonymousClass1(com.anythink.core.api.ATAdInfo aTAdInfo, boolean z) {
                this.val$entity = aTAdInfo;
                this.val$isSuccess = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener = com.anythink.splashad.api.ATSplashAd.this.mListener;
                if (aTSplashAdListener == null || !(aTSplashAdListener instanceof com.anythink.splashad.api.ATSplashExListener)) {
                    return;
                }
                ((com.anythink.splashad.api.ATSplashExListener) aTSplashAdListener).onDeeplinkCallback(this.val$entity, this.val$isSuccess);
            }
        }

        /* renamed from: com.anythink.splashad.api.ATSplashAd$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC02482 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.ATAdInfo val$adInfo;
            final /* synthetic */ android.content.Context val$context;
            final /* synthetic */ com.anythink.core.api.ATNetworkConfirmInfo val$networkConfirmInfo;

            public RunnableC02482(android.content.Context context, com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                this.val$context = context;
                this.val$adInfo = aTAdInfo;
                this.val$networkConfirmInfo = aTNetworkConfirmInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.splashad.api.ATSplashAd aTSplashAd = com.anythink.splashad.api.ATSplashAd.this;
                com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener = aTSplashAd.mListener;
                if (aTSplashAdListener == null || !(aTSplashAdListener instanceof com.anythink.splashad.api.ATSplashExListener)) {
                    return;
                }
                com.anythink.splashad.api.ATSplashExListener aTSplashExListener = (com.anythink.splashad.api.ATSplashExListener) aTSplashAdListener;
                android.content.Context context = this.val$context;
                if (context == null) {
                    context = aTSplashAd.mContext;
                }
                aTSplashExListener.onDownloadConfirm(context, this.val$adInfo, this.val$networkConfirmInfo);
            }
        }

        /* renamed from: com.anythink.splashad.api.ATSplashAd$2$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.ATAdInfo val$entity;

            public AnonymousClass3(com.anythink.core.api.ATAdInfo aTAdInfo) {
                this.val$entity = aTAdInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener = com.anythink.splashad.api.ATSplashAd.this.mListener;
                if (aTSplashAdListener != null) {
                    aTSplashAdListener.onAdShow(this.val$entity);
                }
            }
        }

        /* renamed from: com.anythink.splashad.api.ATSplashAd$2$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.ATAdInfo val$entity;

            public AnonymousClass4(com.anythink.core.api.ATAdInfo aTAdInfo) {
                this.val$entity = aTAdInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener = com.anythink.splashad.api.ATSplashAd.this.mListener;
                if (aTSplashAdListener != null) {
                    aTSplashAdListener.onAdClick(this.val$entity);
                }
            }
        }

        /* renamed from: com.anythink.splashad.api.ATSplashAd$2$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.ATAdInfo val$entity;
            final /* synthetic */ com.anythink.splashad.api.ATSplashAdExtraInfo val$splashAdExtraInfo;

            public AnonymousClass5(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.splashad.api.ATSplashAdExtraInfo aTSplashAdExtraInfo) {
                this.val$entity = aTAdInfo;
                this.val$splashAdExtraInfo = aTSplashAdExtraInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener = com.anythink.splashad.api.ATSplashAd.this.mListener;
                if (aTSplashAdListener != null) {
                    aTSplashAdListener.onAdDismiss(this.val$entity, this.val$splashAdExtraInfo);
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.anythink.splashad.a.a
        public void onAdClick(com.anythink.core.api.ATAdInfo aTAdInfo) {
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.api.ATSplashAd.AnonymousClass2.AnonymousClass4(aTAdInfo));
        }

        @Override // com.anythink.splashad.a.a
        public void onAdDismiss(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.splashad.api.ATSplashAdExtraInfo aTSplashAdExtraInfo) {
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.api.ATSplashAd.AnonymousClass2.AnonymousClass5(aTAdInfo, aTSplashAdExtraInfo));
        }

        @Override // com.anythink.splashad.a.a
        public void onAdShow(com.anythink.core.api.ATAdInfo aTAdInfo) {
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.api.ATSplashAd.AnonymousClass2.AnonymousClass3(aTAdInfo));
            if (com.anythink.splashad.api.ATSplashAd.this.mAdLoadManager.a((com.anythink.core.api.ATAdStatusInfo) null)) {
                com.anythink.splashad.api.ATSplashAd.this.loadAd(6);
            }
        }

        @Override // com.anythink.splashad.a.a
        public void onDeeplinkCallback(com.anythink.core.api.ATAdInfo aTAdInfo, boolean z) {
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.api.ATSplashAd.AnonymousClass2.AnonymousClass1(aTAdInfo, z));
        }

        @Override // com.anythink.splashad.a.a
        public void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.api.ATSplashAd.AnonymousClass2.RunnableC02482(context, aTAdInfo, aTNetworkConfirmInfo));
        }
    }

    @java.lang.Deprecated
    public ATSplashAd(android.content.Context context, java.lang.String str, com.anythink.core.api.ATMediationRequestInfo aTMediationRequestInfo, com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener) {
        this(context, str, aTMediationRequestInfo, aTSplashAdListener, 0);
    }

    @java.lang.Deprecated
    public ATSplashAd(android.content.Context context, java.lang.String str, com.anythink.core.api.ATMediationRequestInfo aTMediationRequestInfo, com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener, int i) {
        this.TAG = getClass().getSimpleName();
        this.DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mListener = aTSplashAdListener;
        this.mDefaultRequestInfo = aTMediationRequestInfo;
        this.mFetchAdTimeout = i;
        if (context instanceof android.app.Activity) {
            this.mActivityWeakRef = new java.lang.ref.WeakReference<>((android.app.Activity) context);
        }
        com.anythink.core.api.ATMediationRequestInfo aTMediationRequestInfo2 = this.mDefaultRequestInfo;
        if (aTMediationRequestInfo2 != null) {
            aTMediationRequestInfo2.setFormat("4");
        }
        this.mAdLoadManager = com.anythink.splashad.a.c.a(context, str);
    }

    public ATSplashAd(android.content.Context context, java.lang.String str, com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener) {
        this(context, str, aTSplashAdListener, 0, "");
    }

    public ATSplashAd(android.content.Context context, java.lang.String str, com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener, int i, java.lang.String str2) {
        this.TAG = getClass().getSimpleName();
        this.DEFAULT_SPLASH_TIMEOUT_TIME = 5000;
        this.mContext = context.getApplicationContext();
        this.mPlacementId = str;
        this.mListener = aTSplashAdListener;
        this.mDefaultAdSourceConfig = str2;
        this.mFetchAdTimeout = i;
        if (context instanceof android.app.Activity) {
            this.mActivityWeakRef = new java.lang.ref.WeakReference<>((android.app.Activity) context);
        }
        com.anythink.core.api.ATMediationRequestInfo aTMediationRequestInfo = this.mDefaultRequestInfo;
        if (aTMediationRequestInfo != null) {
            aTMediationRequestInfo.setFormat("4");
        }
        this.mAdLoadManager = com.anythink.splashad.a.c.a(context, str);
    }

    public ATSplashAd(android.content.Context context, java.lang.String str, com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener, java.lang.String str2) {
        this(context, str, aTSplashAdListener, 0, str2);
    }

    public static void entryAdScenario(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.b.o.a().a(str, str2, "4", (java.util.Map<java.lang.String, java.lang.Object>) null);
    }

    public static void entryAdScenario(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.b.o.a().a(str, str2, "4", map);
    }

    private com.anythink.core.api.ATAdStatusInfo getAdStatus() {
        if (com.anythink.core.common.b.o.a().f() == null || android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().o()) || android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().p())) {
            return null;
        }
        return this.mAdLoadManager.a(this.mContext, this.mTKExtraMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(int i) {
        com.anythink.core.common.o.o.a(this.mPlacementId, com.anythink.core.common.b.h.m.f162s, com.anythink.core.common.b.h.m.w, com.anythink.core.common.b.h.m.n, "", true);
        com.anythink.core.common.o.b.b.a().a(new com.anythink.splashad.api.ATSplashAd.AnonymousClass1(i, this.mTKExtraMap != null ? new java.util.HashMap(this.mTKExtraMap) : new java.util.HashMap()));
    }

    public com.anythink.core.api.ATAdStatusInfo checkAdStatus() {
        com.anythink.core.api.ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return new com.anythink.core.api.ATAdStatusInfo(false, false, null);
        }
        com.anythink.core.common.o.o.b(this.mPlacementId, com.anythink.core.common.b.h.m.f162s, com.anythink.core.common.b.h.m.A, adStatus.toString(), "");
        return adStatus;
    }

    public java.util.List<com.anythink.core.api.ATAdInfo> checkValidAdCaches() {
        com.anythink.splashad.a.c cVar = this.mAdLoadManager;
        if (cVar != null) {
            return cVar.a(this.mContext);
        }
        return null;
    }

    public boolean isAdReady() {
        com.anythink.core.api.ATAdStatusInfo adStatus = getAdStatus();
        if (adStatus == null) {
            return false;
        }
        boolean isReady = adStatus.isReady();
        com.anythink.core.common.o.o.b(this.mPlacementId, com.anythink.core.common.b.h.m.f162s, com.anythink.core.common.b.h.m.z, java.lang.String.valueOf(isReady), "");
        return isReady;
    }

    public void loadAd() {
        loadAd(0);
    }

    @java.lang.Deprecated
    public void onDestory() {
    }

    public void setAdDownloadListener(com.anythink.core.api.ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    public void setAdListener(com.anythink.splashad.api.ATSplashAdListener aTSplashAdListener) {
        this.mListener = aTSplashAdListener;
    }

    public void setAdSourceStatusListener(com.anythink.core.api.ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (this.mAdSourceEventListener == null) {
            this.mAdSourceEventListener = new com.anythink.core.common.b.c();
        }
        this.mDeveloperStatusListener = aTAdSourceStatusListener;
        this.mAdSourceEventListener.a(aTAdSourceStatusListener);
    }

    public void setLocalExtra(java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.u.a().a(this.mPlacementId, map);
    }

    public void setTKExtra(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.mTKExtraMap == null) {
            this.mTKExtraMap = new java.util.concurrent.ConcurrentHashMap();
        }
        this.mTKExtraMap.clear();
        this.mTKExtraMap.putAll(map);
    }

    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        show(activity, viewGroup, null, "");
    }

    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup, com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo) {
        show(activity, viewGroup, aTSplashSkipInfo, "");
    }

    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup, com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo, java.lang.String str) {
        com.anythink.core.common.o.o.b(this.mPlacementId, com.anythink.core.common.b.h.m.f162s, com.anythink.core.common.b.h.m.y, com.anythink.core.common.b.h.m.n, "");
        if (com.anythink.core.common.b.o.a().f() == null || android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().o()) || android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().p()) || viewGroup == null) {
            return;
        }
        this.mAdLoadManager.a(activity, viewGroup, new com.anythink.splashad.api.ATSplashAd.AnonymousClass2(), this.mDownloadListener, aTSplashSkipInfo, str, this.mTKExtraMap);
    }

    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup, java.lang.String str) {
        if (!com.anythink.core.common.o.h.c(str)) {
            str = "";
        }
        show(activity, viewGroup, null, str);
    }
}
