package com.anythink.core.api;

/* loaded from: classes12.dex */
public class ATSDK {
    private static boolean HAS_INIT = false;
    public static final int NONPERSONALIZED = 1;
    public static final int PERSONALIZED = 0;
    public static final int UNKNOWN = 2;

    /* renamed from: com.anythink.core.api.ATSDK$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.t.a().b();
        }
    }

    /* renamed from: com.anythink.core.api.ATSDK$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.h.k {
        final /* synthetic */ com.anythink.core.api.ATAreaCallback val$atAreaCallback;

        public AnonymousClass2(com.anythink.core.api.ATAreaCallback aTAreaCallback) {
            this.val$atAreaCallback = aTAreaCallback;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            this.val$atAreaCallback.onErrorCallback("Request cancel");
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            this.val$atAreaCallback.onErrorCallback(adError.printStackTrace());
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            try {
                if (!(obj instanceof org.json.JSONObject)) {
                    this.val$atAreaCallback.onErrorCallback("There is no result.");
                    return;
                }
                org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
                if (!jSONObject.has("area")) {
                    this.val$atAreaCallback.onErrorCallback("There is no result.");
                } else {
                    this.val$atAreaCallback.onResultCallback(jSONObject.optString("area"));
                }
            } catch (java.lang.Throwable unused) {
                this.val$atAreaCallback.onErrorCallback("Internal error");
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    private ATSDK() {
    }

    public static void addCustomAdapterConfig(java.lang.String str, com.anythink.core.api.ATCustomAdapterConfig aTCustomAdapterConfig) {
        com.anythink.core.common.b.o.a().a(str, aTCustomAdapterConfig);
    }

    public static void checkIsEuTraffic(android.content.Context context, com.anythink.core.api.NetTrafficeCallback netTrafficeCallback) {
        com.anythink.core.common.b.r.a(context).a(netTrafficeCallback);
    }

    public static void deniedUploadDeviceInfo(java.lang.String... strArr) {
        com.anythink.core.common.b.o.a().a(strArr);
    }

    public static void getArea(com.anythink.core.api.ATAreaCallback aTAreaCallback) {
        if (aTAreaCallback == null) {
            return;
        }
        new com.anythink.core.common.h.e().a(0, (com.anythink.core.common.h.k) new com.anythink.core.api.ATSDK.AnonymousClass2(aTAreaCallback));
    }

    public static int getGDPRDataLevel(android.content.Context context) {
        return com.anythink.core.common.b.r.a(context).a();
    }

    public static int getPersionalizedAdStatus() {
        return com.anythink.core.common.b.o.a().d();
    }

    public static java.lang.String getSDKVersionName() {
        return com.anythink.core.common.o.h.a();
    }

    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2) {
        init(context, str, str2, null);
    }

    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.api.ATNetworkConfig aTNetworkConfig) {
        init(context, str, str2, aTNetworkConfig, null);
    }

    @java.lang.Deprecated
    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.api.ATNetworkConfig aTNetworkConfig, com.anythink.core.api.ATSDKInitListener aTSDKInitListener) {
        try {
            if (context == null) {
                if (aTSDKInitListener != null) {
                    aTSDKInitListener.onFail("init: Context is null!");
                }
            } else {
                com.anythink.core.common.b.o.a().a(context, str, str2, aTNetworkConfig);
                if (aTSDKInitListener != null) {
                    aTSDKInitListener.onSuccess();
                }
                com.anythink.core.common.b.o.a();
                com.anythink.core.common.b.o.a(new com.anythink.core.api.ATSDK.AnonymousClass1());
            }
        } catch (java.lang.Error | java.lang.Exception unused) {
        }
    }

    public static void initCustomMap(java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.b.o.a().a(map);
    }

    public static void initPlacementCustomMap(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.b.o.a().a(str, map);
    }

    public static void integrationChecking(android.content.Context context) {
        com.anythink.core.common.b.o.a().b(context);
    }

    public static boolean isCnSDK() {
        return com.anythink.core.common.b.o.a().b() != null;
    }

    public static boolean isEUTraffic(android.content.Context context) {
        return com.anythink.core.common.b.r.a(context).d();
    }

    public static boolean isNetworkLogDebug() {
        return com.anythink.core.common.b.o.a().A();
    }

    public static void setATAdFilter(java.lang.String[] strArr, com.anythink.core.api.IATAdFilter iATAdFilter) {
        com.anythink.core.common.b.o.a().a(strArr, iATAdFilter);
    }

    public static void setATPrivacyConfig(com.anythink.core.api.ATPrivacyConfig aTPrivacyConfig) {
        com.anythink.core.common.b.o.a().a(aTPrivacyConfig);
    }

    public static void setAdLogoVisible(boolean z) {
        com.anythink.core.common.b.o.a().c(z);
    }

    public static void setChannel(java.lang.String str) {
        if (com.anythink.core.common.o.h.a(str)) {
            com.anythink.core.common.b.o.a().e(str);
        }
    }

    public static void setDebuggerConfig(android.content.Context context, java.lang.String str, com.anythink.core.api.ATDebuggerConfig aTDebuggerConfig) {
        com.anythink.core.common.b.o.a().a(context, str, aTDebuggerConfig);
    }

    public static void setExcludePackageList(java.util.List<java.lang.String> list) {
        com.anythink.core.common.b.o.a().a(list);
    }

    public static void setFilterAdSourceIdList(java.lang.String str, java.util.List<java.lang.String> list) {
        com.anythink.core.common.b.o.a().a(str, list);
    }

    public static void setFilterNetworkFirmIdList(java.lang.String str, java.util.List<java.lang.String> list) {
        com.anythink.core.common.b.o.a().b(str, list);
    }

    public static void setGDPRUploadDataLevel(android.content.Context context, int i) {
        if (context == null) {
            return;
        }
        if (i == 0 || i == 1) {
            com.anythink.core.common.b.r.a(context).a(i);
        }
    }

    public static void setInitType(int i) {
        com.anythink.core.common.b.o.a().b(i);
    }

    public static void setLocalStrategyAssetPath(android.content.Context context, java.lang.String str) {
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.a(context, str);
    }

    public static void setLocation(android.location.Location location) {
        com.anythink.core.common.b.o.a().a(location);
    }

    public static void setNetworkLogDebug(boolean z) {
        com.anythink.core.common.b.o.a().b(z);
    }

    public static void setPersonalizedAdStatus(int i) {
        com.anythink.core.common.b.o.a().a(i);
    }

    public static void setSharedPlacementConfig(com.anythink.core.api.ATSharedPlacementConfig aTSharedPlacementConfig) {
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.a(aTSharedPlacementConfig);
    }

    public static void setSubChannel(java.lang.String str) {
        if (com.anythink.core.common.o.h.b(str)) {
            com.anythink.core.common.b.o.a().f(str);
        }
    }

    public static void setSystemDevFragmentType(java.lang.String str) {
        com.anythink.core.common.b.o.a().q(str);
    }

    public static void setUseHTTP(boolean z) {
        com.anythink.core.common.b.o.a().d(z);
    }

    public static void setWXAppId(java.lang.String str) {
        com.anythink.core.common.b.o.a().a(str);
    }

    public static void setWXStatus(boolean z) {
        com.anythink.core.common.b.o.a().a(z);
    }

    public static void showGdprAuth(android.content.Context context) {
        com.anythink.core.common.b.r.a(context).a(context, null);
    }

    public static void showGdprAuth(android.content.Context context, com.anythink.core.api.ATGDPRAuthCallback aTGDPRAuthCallback) {
        com.anythink.core.common.b.r.a(context).a(context, aTGDPRAuthCallback);
    }

    public static void testModeDeviceInfo(android.content.Context context, com.anythink.core.api.DeviceInfoCallback deviceInfoCallback) {
        com.anythink.core.common.b.o.a().a(context, deviceInfoCallback);
    }
}
