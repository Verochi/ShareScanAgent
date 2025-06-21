package com.alipay.sdk.m.c;

/* loaded from: classes.dex */
public class e implements com.alipay.sdk.m.b.b {
    public static final java.lang.String a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.alipay.sdk.m.b.b
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse(a), null, null, null, null);
        if (query != null) {
            r0 = query.moveToNext() ? query.getString(query.getColumnIndex("device_ids_grndid")) : null;
            query.close();
        }
        return r0;
    }
}
