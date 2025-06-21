package com.alipay.sdk.m.i0;

/* loaded from: classes.dex */
public class f {
    public static volatile com.alipay.sdk.m.i0.f g;
    public static boolean h;
    public android.content.BroadcastReceiver f;
    public com.alipay.sdk.m.i0.a a = new com.alipay.sdk.m.i0.a("udid");
    public com.alipay.sdk.m.i0.a b = new com.alipay.sdk.m.i0.a("oaid");
    public com.alipay.sdk.m.i0.a d = new com.alipay.sdk.m.i0.a("vaid");
    public com.alipay.sdk.m.i0.a c = new com.alipay.sdk.m.i0.a("aaid");
    public com.alipay.sdk.m.i0.c e = new com.alipay.sdk.m.i0.c();

    public static com.alipay.sdk.m.i0.d a(android.database.Cursor cursor) {
        java.lang.String str;
        com.alipay.sdk.m.i0.d dVar = new com.alipay.sdk.m.i0.d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    dVar.a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return dVar;
    }

    public static final com.alipay.sdk.m.i0.f a() {
        if (g == null) {
            synchronized (com.alipay.sdk.m.i0.f.class) {
                if (g == null) {
                    g = new com.alipay.sdk.m.i0.f();
                }
            }
        }
        return g;
    }

    public static java.lang.String a(android.content.pm.PackageManager packageManager, java.lang.String str) {
        android.content.pm.ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    public static void a(java.lang.String str) {
    }

    public static void a(boolean z) {
        h = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        if ("0".equals(r8.a) != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r7 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        if (r7 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(android.content.Context context) {
        a("querySupport version : 1.0.8");
        boolean z = false;
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"supported"}, null);
                if (cursor != null) {
                    com.alipay.sdk.m.i0.d a = a(cursor);
                    if (1000 == a.b) {
                    }
                    z = true;
                    cursor.close();
                    return z;
                }
            } catch (java.lang.Exception e) {
                a("querySupport, Exception : " + e.getMessage());
            }
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String b(android.content.Context context, com.alipay.sdk.m.i0.a aVar) {
        java.lang.String str;
        android.database.Cursor cursor;
        java.lang.String str2;
        java.lang.String valueOf;
        a("queryId : " + aVar.c);
        android.database.Cursor cursor2 = null;
        r0 = null;
        r0 = null;
        java.lang.String str3 = null;
        cursor2 = null;
        try {
            try {
                cursor = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{aVar.c}, null);
            } catch (java.lang.Exception e) {
                e = e;
                str = null;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
        } catch (java.lang.Exception e2) {
            e = e2;
            str = str3;
            cursor2 = cursor;
            a("queryId, Exception : " + e.getMessage());
            if (cursor2 == null) {
                return str;
            }
            cursor = cursor2;
            str3 = str;
            cursor.close();
            return str3;
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        if (cursor == null) {
            if (a(context, false)) {
                str2 = "forceQuery isSupported : ";
                valueOf = java.lang.String.valueOf(a(context, true));
                a(str2.concat(valueOf));
            }
            if (cursor == null) {
            }
            cursor.close();
            return str3;
        }
        com.alipay.sdk.m.i0.d a = a(cursor);
        str3 = a.a;
        aVar.a(str3);
        aVar.a(a.c);
        aVar.a(a.b);
        a(aVar.c + " errorCode : " + aVar.d);
        if (a.b != 1000) {
            b(context);
            if (!a(context, false)) {
                str2 = "not support, forceQuery isSupported: ";
                valueOf = java.lang.String.valueOf(a(context, true));
                a(str2.concat(valueOf));
            }
        }
        if (cursor == null) {
            return str3;
        }
        cursor.close();
        return str3;
    }

    public static java.lang.String b(android.content.pm.PackageManager packageManager, java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            a("getAppVersion, Exception : " + e.getMessage());
            return null;
        }
    }

    private synchronized void b(android.content.Context context) {
        if (this.f != null) {
            return;
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        com.alipay.sdk.m.i0.e eVar = new com.alipay.sdk.m.i0.e();
        this.f = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    public final java.lang.String a(android.content.Context context, com.alipay.sdk.m.i0.a aVar) {
        java.lang.String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.a()) {
                return aVar.b;
            }
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    public final boolean a(android.content.Context context, boolean z) {
        if (this.e.a() && !z) {
            return this.e.b();
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        java.lang.String a = a(packageManager, "com.meizu.flyme.openidsdk");
        if (android.text.TextUtils.isEmpty(a)) {
            return false;
        }
        java.lang.String b = b(packageManager, a);
        if (this.e.a() && this.e.a(b)) {
            a("use same version cache, safeVersion : ".concat(java.lang.String.valueOf(b)));
            return this.e.b();
        }
        this.e.b(b);
        boolean a2 = a(context);
        a("query support, result : ".concat(java.lang.String.valueOf(a2)));
        this.e.a(a2);
        return a2;
    }
}
