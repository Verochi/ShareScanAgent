package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes26.dex */
class b {
    public static volatile org.repackage.com.meizu.flyme.openidsdk.b g;
    public static boolean h;
    public android.content.BroadcastReceiver f;
    public org.repackage.com.meizu.flyme.openidsdk.OpenId a = new org.repackage.com.meizu.flyme.openidsdk.OpenId("udid");
    public org.repackage.com.meizu.flyme.openidsdk.OpenId b = new org.repackage.com.meizu.flyme.openidsdk.OpenId("oaid");
    public org.repackage.com.meizu.flyme.openidsdk.OpenId d = new org.repackage.com.meizu.flyme.openidsdk.OpenId("vaid");
    public org.repackage.com.meizu.flyme.openidsdk.OpenId c = new org.repackage.com.meizu.flyme.openidsdk.OpenId("aaid");
    public org.repackage.com.meizu.flyme.openidsdk.SupportInfo e = new org.repackage.com.meizu.flyme.openidsdk.SupportInfo();

    public static java.lang.String b(android.content.pm.PackageManager packageManager, java.lang.String str) {
        android.content.pm.ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    public static org.repackage.com.meizu.flyme.openidsdk.ValueData c(android.database.Cursor cursor) {
        java.lang.String str;
        org.repackage.com.meizu.flyme.openidsdk.ValueData valueData = new org.repackage.com.meizu.flyme.openidsdk.ValueData(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    valueData.a = cursor.getString(columnIndex);
                } else {
                    e("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    valueData.b = cursor.getInt(columnIndex2);
                } else {
                    e("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    valueData.c = cursor.getLong(columnIndex3);
                } else {
                    e("parseExpired fail, index < 0.");
                }
                return valueData;
            }
            str = "parseValue fail, cursor is closed.";
        }
        e(str);
        return valueData;
    }

    public static final org.repackage.com.meizu.flyme.openidsdk.b d() {
        if (g == null) {
            synchronized (org.repackage.com.meizu.flyme.openidsdk.b.class) {
                if (g == null) {
                    g = new org.repackage.com.meizu.flyme.openidsdk.b();
                }
            }
        }
        return g;
    }

    public static void e(java.lang.String str) {
    }

    public static void f(boolean z) {
        h = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        if (r7 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        if ("0".equals(r8.a) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(android.content.Context context) {
        e("querySupport version : 1.0.8");
        boolean z = false;
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"supported"}, null);
                if (cursor != null) {
                    org.repackage.com.meizu.flyme.openidsdk.ValueData c = c(cursor);
                    if (1000 == c.b) {
                    }
                    z = true;
                    cursor.close();
                    return z;
                }
            } catch (java.lang.Exception e) {
                e("querySupport, Exception : " + e.getMessage());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static java.lang.String j(android.content.pm.PackageManager packageManager, java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            e("getAppVersion, Exception : " + e.getMessage());
            return null;
        }
    }

    public final java.lang.String a(android.content.Context context, org.repackage.com.meizu.flyme.openidsdk.OpenId openId) {
        java.lang.String str;
        if (openId == null) {
            str = "getId, openId = null.";
        } else {
            if (openId.d()) {
                return openId.b;
            }
            if (h(context, true)) {
                return i(context, openId);
            }
            str = "getId, isSupported = false.";
        }
        e(str);
        return null;
    }

    public final boolean h(android.content.Context context, boolean z) {
        if (this.e.b() && !z) {
            return this.e.e();
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        java.lang.String b = b(packageManager, "com.meizu.flyme.openidsdk");
        if (android.text.TextUtils.isEmpty(b)) {
            return false;
        }
        java.lang.String j = j(packageManager, b);
        if (this.e.b() && this.e.c(j)) {
            e("use same version cache, safeVersion : ".concat(java.lang.String.valueOf(j)));
            return this.e.e();
        }
        this.e.d(j);
        boolean g2 = g(context);
        e("query support, result : ".concat(java.lang.String.valueOf(g2)));
        this.e.a(g2);
        return g2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String i(android.content.Context context, org.repackage.com.meizu.flyme.openidsdk.OpenId openId) {
        java.lang.String str;
        android.database.Cursor query;
        java.lang.String concat;
        e("queryId : " + openId.c);
        ?? r0 = 0;
        r0 = null;
        r0 = 0;
        java.lang.String str2 = null;
        android.database.Cursor cursor = null;
        try {
            try {
                query = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{openId.c}, null);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
            str = null;
        }
        try {
        } catch (java.lang.Exception e2) {
            e = e2;
            str = str2;
            cursor = query;
            e("queryId, Exception : " + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            r0 = str;
            return r0;
        } catch (java.lang.Throwable th2) {
            th = th2;
            r0 = query;
        }
        if (query == null) {
            if (h(context, false)) {
                concat = "forceQuery isSupported : ".concat(java.lang.String.valueOf(h(context, true)));
                e(concat);
                r0 = str2;
            }
            if (query != null) {
            }
            return r0;
        }
        org.repackage.com.meizu.flyme.openidsdk.ValueData c = c(query);
        java.lang.String str3 = c.a;
        openId.c(str3);
        openId.b(c.c);
        openId.a(c.b);
        e(openId.c + " errorCode : " + openId.d);
        r0 = str3;
        if (c.b != 1000) {
            k(context);
            r0 = str3;
            if (!h(context, false)) {
                concat = "not support, forceQuery isSupported: ".concat(java.lang.String.valueOf(h(context, true)));
                str2 = str3;
                e(concat);
                r0 = str2;
            }
        }
        if (query != null) {
            query.close();
        }
        return r0;
        th = th;
        if (r0 != 0) {
            r0.close();
        }
        throw th;
    }

    public final synchronized void k(android.content.Context context) {
        if (this.f != null) {
            return;
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        org.repackage.com.meizu.flyme.openidsdk.a aVar = new org.repackage.com.meizu.flyme.openidsdk.a();
        this.f = aVar;
        context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }
}
