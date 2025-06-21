package com.anythink.nativead.api;

/* loaded from: classes12.dex */
public class ATNative {
    private final java.lang.String TAG = com.anythink.nativead.api.ATNative.class.getSimpleName();
    com.anythink.core.common.b.b adLoadListener = new com.anythink.nativead.api.ATNative.AnonymousClass1();
    java.lang.ref.WeakReference<android.app.Activity> mActivityRef;
    com.anythink.nativead.a.a mAdLoadManager;
    com.anythink.core.common.b.c mAdSourceEventListener;
    android.content.Context mContext;
    com.anythink.core.api.ATAdSourceStatusListener mDeveloperStatusListener;
    com.anythink.nativead.api.ATNativeNetworkListener mListener;
    java.lang.String mPlacementId;
    java.util.Map<java.lang.String, java.lang.Object> mTKExtraMap;

    /* renamed from: com.anythink.nativead.api.ATNative$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.b.b {

        /* renamed from: com.anythink.nativead.api.ATNative$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC02331 implements java.lang.Runnable {
            public RunnableC02331() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.nativead.api.ATNativeNetworkListener aTNativeNetworkListener = com.anythink.nativead.api.ATNative.this.mListener;
                if (aTNativeNetworkListener != null) {
                    aTNativeNetworkListener.onNativeAdLoaded();
                }
            }
        }

        /* renamed from: com.anythink.nativead.api.ATNative$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.AdError val$error;

            public AnonymousClass2(com.anythink.core.api.AdError adError) {
                this.val$error = adError;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.nativead.api.ATNativeNetworkListener aTNativeNetworkListener = com.anythink.nativead.api.ATNative.this.mListener;
                if (aTNativeNetworkListener != null) {
                    aTNativeNetworkListener.onNativeAdLoadFail(this.val$error);
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.b.b
        public void onAdLoadFail(com.anythink.core.api.AdError adError) {
            com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.ATNative.AnonymousClass1.AnonymousClass2(adError));
        }

        @Override // com.anythink.core.common.b.b
        public void onAdLoaded() {
            com.anythink.core.common.b.o.a().b(new com.anythink.nativead.api.ATNative.AnonymousClass1.RunnableC02331());
        }
    }

    public ATNative(android.content.Context context, java.lang.String str, com.anythink.nativead.api.ATNativeNetworkListener aTNativeNetworkListener) {
        this.mContext = context.getApplicationContext();
        if (context instanceof android.app.Activity) {
            this.mActivityRef = new java.lang.ref.WeakReference<>((android.app.Activity) context);
        }
        this.mPlacementId = str;
        this.mListener = aTNativeNetworkListener;
        this.mAdLoadManager = com.anythink.nativead.a.a.a(context, str);
    }

    public static void entryAdScenario(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.b.o.a().a(str, str2, "0", (java.util.Map<java.lang.String, java.lang.Object>) null);
    }

    public static void entryAdScenario(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.b.o.a().a(str, str2, "0", map);
    }

    private android.content.Context getContext() {
        android.app.Activity activity;
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mActivityRef;
        return (weakReference == null || (activity = weakReference.get()) == null) ? this.mContext : activity;
    }

    public com.anythink.core.api.ATAdStatusInfo checkAdStatus() {
        if (com.anythink.core.common.b.o.a().f() == null || android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().o()) || android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().p())) {
            return new com.anythink.core.api.ATAdStatusInfo(false, false, null);
        }
        com.anythink.core.api.ATAdStatusInfo a = this.mAdLoadManager.a(getContext(), this.mTKExtraMap);
        com.anythink.core.common.o.o.b(this.mPlacementId, com.anythink.core.common.b.h.m.r, com.anythink.core.common.b.h.m.A, a.toString(), "");
        return a;
    }

    public java.util.List<com.anythink.core.api.ATAdInfo> checkValidAdCaches() {
        com.anythink.nativead.a.a aVar = this.mAdLoadManager;
        if (aVar != null) {
            return aVar.a(getContext());
        }
        return null;
    }

    public com.anythink.nativead.api.NativeAd getNativeAd() {
        com.anythink.core.common.f.b a = this.mAdLoadManager.a("", this.mTKExtraMap);
        if (a != null) {
            return new com.anythink.nativead.api.NativeAd(getContext(), this.mPlacementId, a);
        }
        return null;
    }

    public com.anythink.nativead.api.NativeAd getNativeAd(java.lang.String str) {
        if (!com.anythink.core.common.o.h.c(str)) {
            str = "";
        }
        com.anythink.core.common.f.b a = this.mAdLoadManager.a(str, this.mTKExtraMap);
        if (a != null) {
            return new com.anythink.nativead.api.NativeAd(getContext(), this.mPlacementId, a);
        }
        return null;
    }

    public void makeAdRequest() {
        com.anythink.core.common.o.o.a(this.mPlacementId, com.anythink.core.common.b.h.m.r, com.anythink.core.common.b.h.m.w, com.anythink.core.common.b.h.m.n, "", true);
        this.mAdLoadManager.a(getContext(), this.adLoadListener, this.mAdSourceEventListener, this.mTKExtraMap);
    }

    public void setAdListener(com.anythink.nativead.api.ATNativeNetworkListener aTNativeNetworkListener) {
        this.mListener = aTNativeNetworkListener;
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
}
