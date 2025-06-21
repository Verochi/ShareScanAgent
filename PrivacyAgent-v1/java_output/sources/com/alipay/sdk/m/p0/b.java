package com.alipay.sdk.m.p0;

/* loaded from: classes.dex */
public class b {
    public static final java.lang.String b = "VMS_IDLG_SDK_DB";
    public static final java.lang.String c = "content://com.vivo.vms.IdProvider/IdentifierId";
    public static final java.lang.String d = "value";
    public static final java.lang.String e = "OAID";
    public static final java.lang.String f = "AAID";
    public static final java.lang.String g = "VAID";
    public static final java.lang.String h = "OAIDSTATUS";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;
    public android.content.Context a;

    public b(android.content.Context context) {
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(int i2, java.lang.String str) {
        android.net.Uri parse;
        android.net.Uri uri;
        android.database.Cursor query;
        if (i2 == 0) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i2 == 1) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i2 == 2) {
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else {
            if (i2 != 4) {
                uri = null;
                query = this.a.getContentResolver().query(uri, null, null, null, null);
                if (query != null) {
                    r0 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                    query.close();
                }
                return r0;
            }
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
        }
        uri = parse;
        query = this.a.getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
        }
        return r0;
    }
}
