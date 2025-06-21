package com.xiaomi.push;

/* loaded from: classes19.dex */
public class gh {
    private static volatile com.xiaomi.push.gh c;
    public final android.content.Context a;
    public java.util.Map<java.lang.String, com.xiaomi.push.gi> b = new java.util.HashMap();

    private gh(android.content.Context context) {
        this.a = context;
    }

    public static com.xiaomi.push.gh a(android.content.Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (c == null) {
            synchronized (com.xiaomi.push.gh.class) {
                if (c == null) {
                    c = new com.xiaomi.push.gh(context);
                }
            }
        }
        return c;
    }

    public final boolean a(com.xiaomi.push.go goVar, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (com.xiaomi.push.service.bc.a(goVar, false)) {
            return false;
        }
        if (android.text.TextUtils.isEmpty(goVar.i)) {
            goVar.i = com.xiaomi.push.service.bc.a();
        }
        goVar.k = str;
        com.xiaomi.push.service.be.a(this.a, goVar);
        return true;
    }
}
