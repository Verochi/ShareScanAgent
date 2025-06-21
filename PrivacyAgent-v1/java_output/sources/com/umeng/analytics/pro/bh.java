package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
class bh implements com.umeng.analytics.pro.az {
    private static final java.lang.String a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://cn.nubia.provider.deviceid.dataid/oaid"), null, null, null, null);
        if (query != null) {
            r0 = query.moveToNext() ? query.getString(query.getColumnIndex("device_ids_grndid")) : null;
            query.close();
        }
        return r0;
    }
}
