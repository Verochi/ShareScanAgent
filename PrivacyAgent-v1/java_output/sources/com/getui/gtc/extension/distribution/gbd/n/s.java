package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class s {
    public static final android.net.Uri a = android.net.Uri.parse("content://com.sina.weibo.sdkProvider/query/deviceId");
    public static final java.lang.String b = "device_id";
    private static final java.lang.String c = "GBD_weibo";
    private static com.getui.gtc.extension.distribution.gbd.n.s d;
    private android.content.Context e = com.getui.gtc.extension.distribution.gbd.d.c.d;

    private s() {
    }

    private static com.getui.gtc.extension.distribution.gbd.n.s a() {
        if (d == null) {
            d = new com.getui.gtc.extension.distribution.gbd.n.s();
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        r0 = "weibo divecid = ".concat(java.lang.String.valueOf(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r5 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String b() {
        java.lang.String concat;
        android.content.Context context = this.e;
        java.lang.String str = "none";
        if (context == null) {
            concat = "weibo divecid = nonecontext = null";
        } else {
            android.database.Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(a, new java.lang.String[]{"device_id"}, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    str = cursor.getString(cursor.getColumnIndex("device_id"));
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(c, th.toString());
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, concat);
        return str;
    }
}
