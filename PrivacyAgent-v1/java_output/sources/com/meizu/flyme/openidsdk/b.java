package com.meizu.flyme.openidsdk;

/* loaded from: classes23.dex */
public class b {
    public static volatile com.meizu.flyme.openidsdk.b g;
    public static boolean h;
    public java.lang.Boolean e;
    public android.content.BroadcastReceiver f;
    public com.meizu.flyme.openidsdk.OpenId a = new com.meizu.flyme.openidsdk.OpenId("udid");
    public com.meizu.flyme.openidsdk.OpenId b = new com.meizu.flyme.openidsdk.OpenId("oaid");
    public com.meizu.flyme.openidsdk.OpenId d = new com.meizu.flyme.openidsdk.OpenId("vaid");
    public com.meizu.flyme.openidsdk.OpenId c = new com.meizu.flyme.openidsdk.OpenId("aaid");

    public static com.meizu.flyme.openidsdk.ValueData a(android.database.Cursor cursor) {
        java.lang.String str;
        com.meizu.flyme.openidsdk.ValueData valueData = new com.meizu.flyme.openidsdk.ValueData(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    valueData.a = cursor.getString(columnIndex);
                } else {
                    b("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    valueData.b = cursor.getInt(columnIndex2);
                } else {
                    b("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    valueData.c = cursor.getLong(columnIndex3);
                } else {
                    b("parseExpired fail, index < 0.");
                }
                return valueData;
            }
            str = "parseValue fail, cursor is closed.";
        }
        b(str);
        return valueData;
    }

    public static final com.meizu.flyme.openidsdk.b a() {
        if (g == null) {
            synchronized (com.meizu.flyme.openidsdk.b.class) {
                g = new com.meizu.flyme.openidsdk.b();
            }
        }
        return g;
    }

    public static void b(java.lang.String str) {
    }

    public com.meizu.flyme.openidsdk.OpenId a(java.lang.String str) {
        if ("oaid".equals(str)) {
            return this.b;
        }
        if ("vaid".equals(str)) {
            return this.d;
        }
        if ("aaid".equals(str)) {
            return this.c;
        }
        if ("udid".equals(str)) {
            return this.a;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a6, code lost:
    
        if (r2 == null) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String a(android.content.Context context, com.meizu.flyme.openidsdk.OpenId openId) {
        java.lang.String str;
        android.database.Cursor cursor;
        boolean a;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        ?? r0 = 0;
        r0 = null;
        r0 = 0;
        java.lang.String str3 = null;
        android.database.Cursor cursor2 = null;
        if (openId == null) {
            return null;
        }
        if (openId.a()) {
            return openId.b;
        }
        b("queryId : " + openId.c);
        try {
            try {
                cursor = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{openId.c}, null);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
            str = null;
        }
        try {
            if (cursor != null) {
                com.meizu.flyme.openidsdk.ValueData a2 = a(cursor);
                java.lang.String str4 = a2.a;
                openId.a(str4);
                openId.a(a2.c);
                openId.a(a2.b);
                b(openId.c + " errorCode : " + openId.d);
                r0 = str4;
                if (a2.b != 1000) {
                    a(context);
                    r0 = str4;
                    if (!a(context, false)) {
                        a = a(context, true);
                        sb = new java.lang.StringBuilder();
                        str2 = "not support, forceQuery isSupported: ";
                        str3 = str4;
                        sb.append(str2);
                        sb.append(a);
                        b(sb.toString());
                        r0 = str3;
                    }
                }
            } else if (a(context, false)) {
                a = a(context, true);
                sb = new java.lang.StringBuilder();
                str2 = "forceQuery isSupported : ";
                sb.append(str2);
                sb.append(a);
                b(sb.toString());
                r0 = str3;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            str = str3;
            cursor2 = cursor;
            b("queryId, Exception : " + e.getMessage());
            if (cursor2 == null) {
                r0 = str;
                return r0;
            }
            cursor = cursor2;
            r0 = str;
            cursor.close();
            return r0;
        } catch (java.lang.Throwable th2) {
            th = th2;
            r0 = cursor;
        }
        th = th;
        if (r0 != 0) {
            r0.close();
        }
        throw th;
    }

    public final synchronized void a(android.content.Context context) {
        if (this.f != null) {
            return;
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        com.meizu.flyme.openidsdk.a aVar = new com.meizu.flyme.openidsdk.a();
        this.f = aVar;
        context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        if (r8 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        if (r8 == null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(android.content.Context context, boolean z) {
        java.lang.Throwable th;
        android.database.Cursor cursor;
        android.content.pm.PackageManager packageManager;
        java.lang.Boolean bool = this.e;
        if (bool != null && !z) {
            return bool.booleanValue();
        }
        if (!((context == null || (packageManager = context.getPackageManager()) == null || packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) ? false : true)) {
            b("is not Supported, for isLegalProvider : false");
            this.e = java.lang.Boolean.FALSE;
            return false;
        }
        java.lang.String str = null;
        try {
            cursor = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"supported"}, null);
            if (cursor != null) {
                try {
                    try {
                        str = a(cursor).a;
                    } catch (java.lang.Exception e) {
                        e = e;
                        b("querySupport, Exception : " + e.getMessage());
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        cursor.close();
        b("querySupport, result : " + str);
        java.lang.Boolean valueOf = java.lang.Boolean.valueOf("0".equals(str));
        this.e = valueOf;
        return valueOf.booleanValue();
    }
}
