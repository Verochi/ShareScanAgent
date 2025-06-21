package com.vivo.push.cache;

/* loaded from: classes19.dex */
public class ClientConfigManagerImpl implements com.vivo.push.cache.d {
    private static final java.lang.String TAG = "ClientConfigManager";
    private static volatile com.vivo.push.cache.ClientConfigManagerImpl sClientConfigManagerImpl;
    private com.vivo.push.cache.a mAppConfigSettings;
    private android.content.Context mContext;
    private com.vivo.push.cache.e mPushConfigSettings;

    private ClientConfigManagerImpl(android.content.Context context) {
        this.mContext = com.vivo.push.util.ContextDelegate.getContext(context);
        this.mAppConfigSettings = new com.vivo.push.cache.a(this.mContext);
        this.mPushConfigSettings = new com.vivo.push.cache.e(this.mContext);
    }

    public static synchronized com.vivo.push.cache.ClientConfigManagerImpl getInstance(android.content.Context context) {
        com.vivo.push.cache.ClientConfigManagerImpl clientConfigManagerImpl;
        synchronized (com.vivo.push.cache.ClientConfigManagerImpl.class) {
            if (sClientConfigManagerImpl == null) {
                sClientConfigManagerImpl = new com.vivo.push.cache.ClientConfigManagerImpl(context);
            }
            clientConfigManagerImpl = sClientConfigManagerImpl;
        }
        return clientConfigManagerImpl;
    }

    private void prepareAppConfig() {
        com.vivo.push.cache.a aVar = this.mAppConfigSettings;
        if (aVar == null) {
            this.mAppConfigSettings = new com.vivo.push.cache.a(this.mContext);
        } else {
            aVar.c();
        }
    }

    private com.vivo.push.cache.e preparePushConfigSettings() {
        com.vivo.push.cache.e eVar = this.mPushConfigSettings;
        if (eVar == null) {
            this.mPushConfigSettings = new com.vivo.push.cache.e(this.mContext);
        } else {
            eVar.c();
        }
        return this.mPushConfigSettings;
    }

    public void clearPush() {
        this.mAppConfigSettings.d();
    }

    public java.util.Set<java.lang.String> getBlackEventList() {
        return null;
    }

    public java.lang.String getSuitTag() {
        return preparePushConfigSettings().c("CSPT");
    }

    public java.lang.String getValueByKey(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        this.mPushConfigSettings.c();
        return this.mPushConfigSettings.c(str);
    }

    public java.util.Set<java.lang.Long> getWhiteLogList() {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.lang.String valueByKey = getValueByKey("WLL");
        if (!android.text.TextUtils.isEmpty(valueByKey)) {
            for (java.lang.String str : valueByKey.split(",")) {
                try {
                    hashSet.add(java.lang.Long.valueOf(java.lang.Long.parseLong(str)));
                } catch (java.lang.Exception unused) {
                }
            }
        }
        com.vivo.push.util.p.d(TAG, " initWhiteLogList ".concat(java.lang.String.valueOf(hashSet)));
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isCancleBroadcastReceiver() {
        int parseInt;
        java.lang.String c = preparePushConfigSettings().c("PSM");
        if (!android.text.TextUtils.isEmpty(c)) {
            try {
                parseInt = java.lang.Integer.parseInt(c);
            } catch (java.lang.NumberFormatException e) {
                e.printStackTrace();
            }
            return (parseInt & 4) == 0;
        }
        parseInt = 0;
        if ((parseInt & 4) == 0) {
        }
    }

    public boolean isDebug() {
        this.mAppConfigSettings.c();
        return com.vivo.push.cache.a.a(this.mAppConfigSettings.b());
    }

    public boolean isDebug(int i) {
        return com.vivo.push.cache.a.a(i);
    }

    public boolean isEnablePush() {
        prepareAppConfig();
        com.vivo.push.model.a c = this.mAppConfigSettings.c(this.mContext.getPackageName());
        if (c != null) {
            return "1".equals(c.b());
        }
        return true;
    }

    @Override // com.vivo.push.cache.d
    public boolean isInBlackList(long j) {
        java.lang.String c = preparePushConfigSettings().c("BL");
        if (!android.text.TextUtils.isEmpty(c)) {
            for (java.lang.String str : c.split(",")) {
                try {
                    if (!android.text.TextUtils.isEmpty(str) && java.lang.Long.parseLong(str) == j) {
                        return true;
                    }
                } catch (java.lang.NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
