package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
class NubiaImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.NubiaImpl";
    private final android.content.Context mContext;

    public NubiaImpl(android.content.Context context) {
        this.mContext = context;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        android.content.ContentProviderClient acquireContentProviderClient;
        if (!isSupported()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Only supports Android 10.0 and above for Nubia");
            return null;
        }
        try {
            acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(android.net.Uri.parse("content://cn.nubia.identity/identity"));
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
        }
        if (acquireContentProviderClient == null) {
            return null;
        }
        android.os.Bundle call = acquireContentProviderClient.call("getOAID", null, null);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            acquireContentProviderClient.close();
        } else {
            acquireContentProviderClient.release();
        }
        if (call == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "OAID query failed: bundle is null");
            return null;
        }
        r2 = call.getInt("code", -1) == 0 ? call.getString("id") : null;
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "OAID query success: " + r2);
        return r2;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public boolean isSupported() {
        return android.os.Build.VERSION.SDK_INT >= 29;
    }
}
