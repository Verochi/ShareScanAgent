package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
class MeizuImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.MeizuImpl";
    private final android.content.Context mContext;

    public MeizuImpl(android.content.Context context) {
        this.mContext = context;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        java.lang.String str = null;
        try {
            android.database.Cursor query = this.mContext.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"oaid"}, null);
            if (query == null || !query.moveToFirst()) {
                return null;
            }
            str = query.getString(query.getColumnIndex("value"));
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "OAID query success: " + str);
            query.close();
            return str;
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            return str;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public boolean isSupported() {
        return true;
    }
}
