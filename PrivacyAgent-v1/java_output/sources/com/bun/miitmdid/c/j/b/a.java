package com.bun.miitmdid.c.j.b;

/* loaded from: classes.dex */
public class a {
    private android.content.Context a;

    public a(android.content.Context context) {
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(int i, java.lang.String str) {
        java.lang.String str2;
        android.net.Uri parse;
        android.database.Cursor query;
        java.lang.StringBuilder sb;
        java.lang.String str3;
        if (i != 0) {
            if (i == 1) {
                sb = new java.lang.StringBuilder();
                str3 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            } else {
                if (i != 2) {
                    parse = null;
                    query = this.a.getContentResolver().query(parse, null, null, null, null);
                    if (query == null) {
                        r0 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                        query.close();
                    } else {
                        com.bun.lib.a.a(com.alipay.sdk.m.p0.b.b, "return cursor is null,return");
                    }
                    return r0;
                }
                sb = new java.lang.StringBuilder();
                str3 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
            }
            sb.append(str3);
            sb.append(str);
            str2 = sb.toString();
        } else {
            str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        }
        parse = android.net.Uri.parse(str2);
        query = this.a.getContentResolver().query(parse, null, null, null, null);
        if (query == null) {
        }
        return r0;
    }
}
