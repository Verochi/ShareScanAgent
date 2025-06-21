package com.sensorsdata.analytics.android.sdk.core.business;

/* loaded from: classes19.dex */
public class SAPropertyManager {
    private java.util.Map<java.lang.String, java.lang.String> mLimitKeys;

    public static class Holder {
        public static com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager INSTANCE = new com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager(null);
    }

    private SAPropertyManager() {
        this.mLimitKeys = new java.util.HashMap();
    }

    public /* synthetic */ SAPropertyManager(com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager getInstance() {
        return com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager.Holder.INSTANCE;
    }

    public java.lang.String getLimitValue(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map = this.mLimitKeys;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public boolean isLimitKey(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map = this.mLimitKeys;
        return map != null && map.containsKey(str);
    }

    public void registerLimitKeys(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            this.mLimitKeys.putAll(map);
        }
    }
}
