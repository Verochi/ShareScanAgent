package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATInitManager extends com.anythink.core.api.ATInitMediation {
    protected static final java.lang.String e = "AT_BAIDU_C2S_";
    private static volatile com.anythink.network.baidu.BaiduATInitManager f;
    java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.anythink.network.baidu.BaiduATBiddingInfo>> a;
    private boolean g;
    boolean b = false;
    java.lang.Boolean c = null;
    int d = 0;
    private final java.lang.Object h = new java.lang.Object();

    public interface InitCallback {
        void onError(java.lang.Throwable th);

        void onSuccess();
    }

    private BaiduATInitManager() {
    }

    private synchronized com.anythink.network.baidu.BaiduATBiddingInfo a(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.String, com.anythink.network.baidu.BaiduATBiddingInfo> map;
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.anythink.network.baidu.BaiduATBiddingInfo>> map2 = this.a;
        if (map2 == null || (map = map2.get(str)) == null) {
            return null;
        }
        return map.remove(str2);
    }

    private synchronized java.lang.String a(java.lang.String str, java.lang.Object obj, double d, java.lang.Object obj2) {
        java.lang.String str2;
        if (this.a == null) {
            this.a = new java.util.concurrent.ConcurrentHashMap(3);
        }
        java.util.Map<java.lang.String, com.anythink.network.baidu.BaiduATBiddingInfo> map = this.a.get(str);
        if (map == null) {
            map = new java.util.concurrent.ConcurrentHashMap<>(2);
            this.a.put(str, map);
        }
        str2 = e + java.util.UUID.randomUUID().toString();
        map.put(str2, new com.anythink.network.baidu.BaiduATBiddingInfo(obj, d, obj2));
        return str2;
    }

    public static void a(com.baidu.mobads.sdk.api.RequestParameters.Builder builder, java.util.Map<java.lang.String, java.lang.Object> map) {
        int intFromMap = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.common.b.h.o.q, -1);
        int intFromMap2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.common.b.h.o.r, -1);
        int intFromMap3 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.common.b.h.o.f164s, -1);
        int intFromMap4 = com.anythink.core.api.ATInitMediation.getIntFromMap(map, com.anythink.core.common.b.h.o.t, -1);
        if (intFromMap != -1) {
            builder.addCustExt(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, java.lang.String.valueOf(intFromMap));
        }
        if (intFromMap2 != -1) {
            builder.addCustExt("B", java.lang.String.valueOf(intFromMap2));
        }
        if (intFromMap3 != -1) {
            builder.addCustExt("C", java.lang.String.valueOf(intFromMap3));
        }
        if (intFromMap4 != -1) {
            builder.addCustExt(androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, java.lang.String.valueOf(intFromMap4));
        }
    }

    private synchronized void b(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.String, com.anythink.network.baidu.BaiduATBiddingInfo> map;
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.anythink.network.baidu.BaiduATBiddingInfo>> map2 = this.a;
        if (map2 != null && (map = map2.get(str)) != null) {
            map.remove(str2);
        }
    }

    public static com.anythink.network.baidu.BaiduATInitManager getInstance() {
        if (f == null) {
            synchronized (com.anythink.network.baidu.BaiduATInitManager.class) {
                if (f == null) {
                    f = new com.anythink.network.baidu.BaiduATInitManager();
                }
            }
        }
        return f;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getAdapterVersion() {
        return "UA_6.2.66.2";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkName() {
        return "Baidu";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkSDKClass() {
        return "com.baidu.mobads.sdk.api.BDAdConfig";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkVersion() {
        return com.anythink.network.baidu.BaiduATConst.getNetworkVersion();
    }

    public void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        initSDK(context, map, null);
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.api.MediationInitCallback mediationInitCallback) {
        initSDK(context, map, false, mediationInitCallback);
    }

    public void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, boolean z, com.anythink.core.api.MediationInitCallback mediationInitCallback) {
        try {
            this.d = com.anythink.core.api.ATSDK.getPersionalizedAdStatus();
        } catch (java.lang.Throwable unused) {
        }
        com.baidu.mobads.sdk.api.MobadsPermissionSettings.setLimitPersonalAds(this.d == 2);
        if (!this.b) {
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionReadDeviceID(true);
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionOAID(true);
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionAppList(true);
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionStorage(true);
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionLocation(true);
        }
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            new java.lang.StringBuilder("MobadsPermissionSettings.getLimitPersonalAdsStatus():").append(com.baidu.mobads.sdk.api.MobadsPermissionSettings.getLimitPersonalAdsStatus());
        }
        if (this.g) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onSuccess();
                return;
            }
            return;
        }
        synchronized (this.h) {
            if (this.g) {
                if (mediationInitCallback != null) {
                    mediationInitCallback.onSuccess();
                }
                return;
            }
            java.lang.String str = (java.lang.String) map.get("app_id");
            try {
                java.lang.Object obj = map.get(com.anythink.core.api.ATAdConst.KEY.WECHAT_APPID);
                java.lang.String obj2 = obj != null ? obj.toString() : "";
                com.baidu.mobads.sdk.api.BDAdConfig.Builder appsid = new com.baidu.mobads.sdk.api.BDAdConfig.Builder().setAppsid(str);
                if (!android.text.TextUtils.isEmpty(obj2)) {
                    appsid.setWXAppid(obj2);
                }
                java.lang.Boolean bool = this.c;
                if (bool != null) {
                    appsid.setHttps(bool.booleanValue());
                }
                appsid.build(context).init();
                this.g = true;
                if (mediationInitCallback != null) {
                    mediationInitCallback.onSuccess();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                if (mediationInitCallback != null) {
                    mediationInitCallback.onFail(th.getMessage());
                }
            }
        }
    }

    public void setBaiduATCustomController(com.anythink.network.baidu.BaiduATCustomController baiduATCustomController) {
        if (baiduATCustomController != null) {
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionReadDeviceID(baiduATCustomController.getPermissionReadDeviceID());
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionLocation(baiduATCustomController.getPermissionLocation());
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionStorage(baiduATCustomController.getPermissionStorage());
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionAppList(baiduATCustomController.getPermissionAppList());
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionOAID(baiduATCustomController.getPermissionOAID());
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionDeviceInfo(baiduATCustomController.getPermissionDeviceInfo());
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionAppUpdate(baiduATCustomController.getPermissionAppUpdate());
            com.baidu.mobads.sdk.api.MobadsPermissionSettings.setPermissionRunningApp(baiduATCustomController.getPermissionRunningApp());
            this.b = true;
        }
    }

    public void setHttps(boolean z) {
        this.c = java.lang.Boolean.valueOf(z);
    }
}
