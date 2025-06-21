package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class t {
    private static java.lang.Boolean a;
    private static java.lang.String b;

    public static com.vivo.push.model.b a(android.content.Context context) {
        com.vivo.push.model.b bVar;
        com.vivo.push.model.b f;
        java.lang.String str;
        java.lang.String str2;
        java.lang.StringBuilder sb;
        android.content.Context applicationContext = com.vivo.push.util.ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.b d = d(applicationContext);
        if (d != null) {
            com.vivo.push.util.p.d("PushPackageUtils", "get system push info :".concat(java.lang.String.valueOf(d)));
            return d;
        }
        java.util.List<java.lang.String> e = e(applicationContext);
        com.vivo.push.model.b f2 = f(applicationContext, applicationContext.getPackageName());
        if (e.size() <= 0) {
            if (f2 != null && f2.d()) {
                d = f2;
            }
            com.vivo.push.util.p.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            com.vivo.push.model.b bVar2 = null;
            java.lang.String a2 = com.vivo.push.util.y.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (android.text.TextUtils.isEmpty(a2) || !a(applicationContext, a2, "com.vivo.pushservice.action.METHOD") || (bVar = f(applicationContext, a2)) == null || !bVar.d()) {
                bVar = null;
            }
            if (f2 == null || !f2.d()) {
                f2 = null;
            }
            if (bVar == null) {
                bVar = null;
            }
            if (f2 == null || (bVar != null && (!f2.c() ? !(bVar.c() || f2.b() > bVar.b()) : !(bVar.c() && f2.b() > bVar.b())))) {
                f2 = bVar;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            if (f2 == null) {
                f2 = null;
            } else if (f2.c()) {
                bVar2 = f2;
                f2 = null;
            }
            int size = e.size();
            for (int i = 0; i < size; i++) {
                java.lang.String str3 = e.get(i);
                if (!android.text.TextUtils.isEmpty(str3) && (f = f(applicationContext, str3)) != null) {
                    hashMap.put(str3, f);
                    if (f.d()) {
                        if (f.c()) {
                            if (bVar2 == null || f.b() > bVar2.b()) {
                                bVar2 = f;
                            }
                        } else if (f2 == null || f.b() > f2.b()) {
                            f2 = f;
                        }
                    }
                }
            }
            if (f2 != null) {
                d = f2;
            } else {
                com.vivo.push.util.p.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                d = bVar2;
            }
        }
        if (d != null) {
            if (d.c()) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("查找最优包为:");
                sb2.append(d.a());
                sb2.append("(");
                sb2.append(d.b());
                str2 = ", Black)";
                sb2.append(", Black)");
                com.vivo.push.util.p.a(applicationContext, sb2.toString());
                sb = new java.lang.StringBuilder("finSuitablePushPackage");
            } else {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder("查找最优包为:");
                sb3.append(d.a());
                sb3.append("(");
                sb3.append(d.b());
                str2 = ")";
                sb3.append(")");
                com.vivo.push.util.p.a(applicationContext, sb3.toString());
                sb = new java.lang.StringBuilder("finSuitablePushPackage");
            }
            sb.append(d.a());
            sb.append("(");
            sb.append(d.b());
            sb.append(str2);
            str = sb.toString();
        } else {
            com.vivo.push.util.p.b(applicationContext, "查找最优包为空!");
            str = "finSuitablePushPackage is null";
        }
        com.vivo.push.util.p.d("PushPackageUtils", str);
        return d;
    }

    private static boolean a(android.content.Context context, long j) {
        com.vivo.push.cache.d a2 = com.vivo.push.cache.b.a().a(context);
        if (a2 != null) {
            return a2.isInBlackList(j);
        }
        return false;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        android.content.pm.ServiceInfo serviceInfo;
        if (!android.text.TextUtils.isEmpty(str) && context != null) {
            android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                int size = queryIntentServices.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    android.content.pm.ResolveInfo resolveInfo = queryIntentServices.get(i);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        java.lang.String str2 = serviceInfo.name;
                        boolean z2 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new android.content.ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z3);
                        }
                    }
                }
                return z;
            }
            com.vivo.push.util.p.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.util.List<android.content.pm.ResolveInfo> list;
        android.content.Intent intent = new android.content.Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (java.lang.Exception unused) {
            list = null;
        }
        return list != null && list.size() > 0;
    }

    public static int b(android.content.Context context, java.lang.String str) {
        int i = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0097 -> B:27:0x00af). Please report as a decompilation issue!!! */
    public static java.lang.String b(android.content.Context context) {
        java.lang.String str;
        android.database.Cursor query;
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                try {
                    query = context.getContentResolver().query(com.vivo.push.p.a, null, null, null, null);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (java.lang.Exception e) {
                            com.vivo.push.util.p.a("PushPackageUtils", "close", e);
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                str = null;
            }
        } catch (java.lang.Exception e3) {
            com.vivo.push.util.p.a("PushPackageUtils", "close", e3);
        }
        if (query != null) {
            boolean z = false;
            str = null;
            while (query.moveToNext()) {
                try {
                    if ("pushPkgName".equals(query.getString(query.getColumnIndex("name")))) {
                        str = query.getString(query.getColumnIndex("value"));
                    } else if ("pushEnable".equals(query.getString(query.getColumnIndex("name")))) {
                        z = java.lang.Boolean.parseBoolean(query.getString(query.getColumnIndex("value")));
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                }
            }
            b = str;
            if (android.text.TextUtils.isEmpty(str)) {
                try {
                    query.close();
                } catch (java.lang.Exception e5) {
                    com.vivo.push.util.p.a("PushPackageUtils", "close", e5);
                }
                return null;
            }
            if (z) {
                query.close();
                return str;
            }
            try {
                query.close();
            } catch (java.lang.Exception e6) {
                com.vivo.push.util.p.a("PushPackageUtils", "close", e6);
            }
            return null;
        }
        try {
            com.vivo.push.util.p.a("PushPackageUtils", "cursor is null");
            if (query != null) {
                try {
                    query.close();
                } catch (java.lang.Exception e7) {
                    com.vivo.push.util.p.a("PushPackageUtils", "close", e7);
                }
            }
            return null;
        } catch (java.lang.Exception e8) {
            e = e8;
            str = null;
        }
        cursor = query;
        com.vivo.push.util.p.a("PushPackageUtils", "getSystemPush", e);
        if (cursor != null) {
            cursor.close();
        }
        return str;
    }

    public static boolean c(android.content.Context context) {
        android.content.pm.ProviderInfo resolveContentProvider;
        java.lang.Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        java.lang.String str = null;
        if (context != null && !android.text.TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        java.lang.Boolean valueOf = java.lang.Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        a = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean c(android.content.Context context, java.lang.String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    private static com.vivo.push.model.b d(android.content.Context context) {
        java.lang.String b2 = b(context);
        android.content.pm.ApplicationInfo applicationInfo = null;
        if (android.text.TextUtils.isEmpty(b2)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(b2);
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b2, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(com.vivo.push.util.z.a(context, b2));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, b2));
            return bVar;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e);
            return null;
        }
    }

    public static boolean d(android.content.Context context, java.lang.String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    private static java.util.List<java.lang.String> e(android.content.Context context) {
        java.util.List<android.content.pm.ResolveInfo> list;
        com.vivo.push.util.g.a("findAllCoreClientPush");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new android.content.Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
        } catch (java.lang.Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                android.content.pm.ResolveInfo resolveInfo = list.get(i);
                if (resolveInfo != null) {
                    java.lang.String str = resolveInfo.serviceInfo.packageName;
                    if (!android.text.TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            com.vivo.push.util.p.d("PushPackageUtils", "get all push packages is null");
        }
        return arrayList;
    }

    public static boolean e(android.content.Context context, java.lang.String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static com.vivo.push.model.b f(android.content.Context context, java.lang.String str) {
        android.content.pm.ApplicationInfo applicationInfo;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
                try {
                    android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        bVar.a(packageInfo.versionCode);
                        bVar.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        bVar.a(com.vivo.push.util.z.a(context, str));
                    }
                    bVar.b(a(context, str));
                    bVar.a(a(context, bVar.b()));
                    return bVar;
                } catch (java.lang.Exception e) {
                    com.vivo.push.util.p.a("PushPackageUtils", "getPushPackageInfo exception: ", e);
                }
            }
        }
        return null;
    }

    private static java.lang.String g(android.content.Context context, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && context != null) {
            try {
                android.content.pm.Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] digest = java.security.MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                for (byte b2 : digest) {
                    java.lang.String upperCase = java.lang.Integer.toHexString(b2 & 255).toUpperCase(java.util.Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (java.lang.Exception e) {
                com.vivo.push.util.p.a("PushPackageUtils", " getSignatureSHA exception ".concat(java.lang.String.valueOf(e)));
            }
        }
        return null;
    }
}
