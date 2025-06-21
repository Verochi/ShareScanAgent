package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class m {
    public static final java.lang.String a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static java.lang.String a(android.content.Context context) {
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse(a), null, null, null, null);
        if (query != null && query.getCount() > 0) {
            r0 = query.moveToFirst() ? query.getString(query.getColumnIndex("url")) : null;
            query.close();
        }
        return r0;
    }

    public static java.lang.String b(android.content.Context context) {
        if (com.alipay.sdk.app.EnvUtils.isSandBox()) {
            return com.alipay.sdk.m.l.a.b;
        }
        if (context == null) {
            return com.alipay.sdk.m.l.a.a;
        }
        java.lang.String str = com.alipay.sdk.m.l.a.a;
        return android.text.TextUtils.isEmpty(str) ? com.alipay.sdk.m.l.a.a : str;
    }
}
