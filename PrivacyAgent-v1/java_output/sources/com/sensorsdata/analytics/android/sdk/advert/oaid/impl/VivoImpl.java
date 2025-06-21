package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
class VivoImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.VivoImpl";
    private final android.content.Context mContext;

    public VivoImpl(android.content.Context context) {
        this.mContext = context;
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        java.lang.String str;
        android.database.Cursor cursor = null;
        r1 = null;
        r1 = null;
        java.lang.String str2 = null;
        try {
            android.database.Cursor query = this.mContext.getContentResolver().query(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && ((str2 = query.getString(query.getColumnIndex("value"))) == null || str2.length() == 0)) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "OAID query failed");
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    str = str2;
                    cursor = query;
                    try {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
                        return str;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (query == null) {
                return str2;
            }
            query.close();
            return str2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public boolean isSupported() {
        try {
            if (android.os.Build.VERSION.SDK_INT < 28) {
                return false;
            }
            return com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom.sysProperty(com.alipay.sdk.m.p0.c.c, "0").equals("1");
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            return false;
        }
    }
}
