package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class z {
    private static java.lang.String[] a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
    private static java.lang.String[] b = {"android.permission.INTERNET", com.anythink.china.common.d.a, "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", com.anythink.china.common.d.b, "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
    private static java.lang.String[] c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
    private static java.lang.String[] d = {"com.vivo.push.sdk.RegistrationReceiver"};
    private static java.lang.String[] e = new java.lang.String[0];
    private static java.util.Map<java.lang.String, android.os.Bundle> f = new java.util.concurrent.ConcurrentHashMap();

    public static long a(android.content.Context context) {
        java.lang.String b2 = com.vivo.push.util.t.b(context);
        if (!android.text.TextUtils.isEmpty(b2)) {
            return a(context, b2);
        }
        com.vivo.push.util.p.a("Utility", "systemPushPkgName is null");
        return -1L;
    }

    public static long a(android.content.Context context, java.lang.String str) {
        java.lang.Object a2 = a(context, str, "com.vivo.push.sdk_version");
        if (a2 == null) {
            a2 = a(context, str, "sdk_version");
        }
        if (a2 == null) {
            com.vivo.push.util.p.a("Utility", "getSdkVersionCode sdk version is null");
            return -1L;
        }
        try {
            return java.lang.Long.parseLong(a2.toString());
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.vivo.push.util.p.a("Utility", "getSdkVersionCode error ", e2);
            return -1L;
        }
    }

    public static java.lang.Object a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundle;
        if (context == null || str2 == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.util.Map<java.lang.String, android.os.Bundle> map = f;
            java.lang.Object obj = (map == null || map.size() <= 0 || (bundle = f.get(str)) == null) ? null : bundle.get(str2);
            if (obj != null) {
                return obj;
            }
            try {
                android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                java.lang.Object obj2 = r0 != null ? r0.get(str2) : obj;
                try {
                    if (f.size() > 300) {
                        return obj2;
                    }
                    f.put(str, r0);
                    return obj2;
                } catch (java.lang.Exception e2) {
                    r0 = obj2;
                    e = e2;
                    com.vivo.push.util.p.a("Utility", "getMetaValue::".concat(java.lang.String.valueOf(e)));
                    return r0;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                r0 = obj;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
        }
    }

    public static java.lang.Object a(java.lang.String str, java.lang.String str2) {
        java.lang.Class<?> cls = java.lang.Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    public static void a(android.content.Context context, android.content.Intent intent) {
        java.lang.String b2 = com.vivo.push.util.t.b(context);
        java.lang.String stringExtra = intent.getStringExtra("client_pkgname");
        if (android.text.TextUtils.isEmpty(b2)) {
            com.vivo.push.util.p.a("Utility", "illegality abe adapter : push pkg is null");
            return;
        }
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            com.vivo.push.util.p.a("Utility", "illegality abe adapter : src pkg is null");
            return;
        }
        if (b2.equals(context.getPackageName())) {
            com.vivo.push.util.p.a("Utility", "illegality abe adapter : abe is not pushservice");
            return;
        }
        if (b2.equals(stringExtra)) {
            com.vivo.push.util.p.a("Utility", "illegality abe adapter : pushPkg = " + b2 + " ; srcPkg = " + stringExtra);
            return;
        }
        com.vivo.push.util.p.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + b2);
        intent.setPackage(b2);
        intent.setClassName(b2, "com.vivo.push.sdk.service.PushService");
        context.startService(intent);
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        android.content.Intent intent = new android.content.Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new com.vivo.push.util.VivoPushException("localPackageManager is null");
            }
            if (z) {
                java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                    throw new com.vivo.push.util.VivoPushException("checkModule " + intent + " has no receivers");
                }
                java.util.Iterator<android.content.pm.ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    if (str2.equals(it.next().activityInfo.name)) {
                        return;
                    }
                }
                throw new com.vivo.push.util.VivoPushException(str2 + " is missing");
            }
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                throw new com.vivo.push.util.VivoPushException("checkModule " + intent + " has no services");
            }
            for (android.content.pm.ResolveInfo resolveInfo : queryIntentServices) {
                if (str2.equals(resolveInfo.serviceInfo.name)) {
                    if (resolveInfo.serviceInfo.exported) {
                        return;
                    }
                    throw new com.vivo.push.util.VivoPushException(resolveInfo.serviceInfo.name + " exported is false");
                }
            }
            throw new com.vivo.push.util.VivoPushException(str2 + " is missing");
        } catch (java.lang.Exception e2) {
            com.vivo.push.util.p.a("Utility", "error  " + e2.getMessage());
            throw new com.vivo.push.util.VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    private static void a(android.content.pm.ComponentInfo componentInfo, java.lang.String str) {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (java.lang.String str2 : a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new com.vivo.push.util.VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    private static void a(java.lang.String str, android.content.pm.ComponentInfo[] componentInfoArr, java.lang.String str2) {
        for (android.content.pm.ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new com.vivo.push.util.VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new com.vivo.push.util.VivoPushException(str + " module Push-SDK need is not exist");
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        java.lang.Object a2 = a(context, str, "com.vivo.push.app_id");
        if (a2 != null) {
            return a2.toString();
        }
        java.lang.Object a3 = a(context, str, "app_id");
        return a3 != null ? a3.toString() : "";
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        try {
            str3 = (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(null, str);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c7, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(android.content.Context context) {
        java.lang.String obj;
        int i;
        com.vivo.push.util.p.d("Utility", "check PushService AndroidManifest declearation !");
        java.lang.String b2 = com.vivo.push.util.t.b(context);
        boolean d2 = com.vivo.push.util.t.d(context, context.getPackageName());
        boolean e2 = com.vivo.push.util.t.e(context, context.getPackageName());
        boolean c2 = com.vivo.push.util.t.c(context, context.getPackageName());
        if (e2) {
            a = new java.lang.String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
            b = new java.lang.String[]{"android.permission.INTERNET", com.anythink.china.common.d.a, "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", com.anythink.china.common.d.b, "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
            c = new java.lang.String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
            d = new java.lang.String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        } else {
            if (!c2 && !d2) {
                throw new com.vivo.push.util.VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
            }
            if (c2) {
                c = new java.lang.String[]{"com.vivo.push.sdk.service.CommandClientService"};
            } else {
                c = new java.lang.String[]{"com.vivo.push.sdk.service.CommandService"};
            }
            d = new java.lang.String[0];
            a = new java.lang.String[0];
            if (d2) {
                b = new java.lang.String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
            } else {
                b = new java.lang.String[]{"android.permission.INTERNET"};
            }
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new com.vivo.push.util.VivoPushException("localPackageManager is null");
            }
            java.lang.String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                throw new com.vivo.push.util.VivoPushException("Permissions is null!");
            }
            java.lang.String[] strArr2 = b;
            int length = strArr2.length;
            int i2 = 0;
            while (i2 < length) {
                java.lang.String str = strArr2[i2];
                int length2 = strArr.length;
                while (i < length2) {
                    i = str.equals(strArr[i]) ? 0 : i + 1;
                }
                throw new com.vivo.push.util.VivoPushException("permission : " + str + "  check fail : " + java.util.Arrays.toString(strArr));
            }
            f(context, b2);
            d(context, b2);
            e(context, b2);
            try {
                if (a(context, context.getPackageName(), "local_iv") == null) {
                    throw new com.vivo.push.util.VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
                }
                java.lang.String packageName = context.getPackageName();
                java.lang.Object a2 = a(context, packageName, "com.vivo.push.api_key");
                if (a2 != null) {
                    obj = a2.toString();
                } else {
                    java.lang.Object a3 = a(context, packageName, "api_key");
                    obj = a3 != null ? a3.toString() : "";
                }
                if (android.text.TextUtils.isEmpty(obj)) {
                    throw new com.vivo.push.util.VivoPushException("com.vivo.push.api_key is null");
                }
                if (android.text.TextUtils.isEmpty(b(context, context.getPackageName()))) {
                    throw new com.vivo.push.util.VivoPushException("com.vivo.push.app_id is null");
                }
                if ((d2 || e2) && a(context, context.getPackageName()) == -1) {
                    throw new com.vivo.push.util.VivoPushException("sdkversion is null");
                }
                if (e2) {
                    a(context, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
                    a(context, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
                }
            } catch (java.lang.Exception e3) {
                throw new com.vivo.push.util.VivoPushException("getMetaValue error " + e3.getMessage());
            }
        } catch (java.lang.Exception e4) {
            throw new com.vivo.push.util.VivoPushException(e4.getMessage());
        }
    }

    public static boolean b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.database.Cursor cursor = null;
        try {
            try {
                try {
                } catch (java.lang.Exception e2) {
                    com.vivo.push.util.p.a("Utility", "isOverdue", e2);
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            } catch (java.lang.Exception e3) {
                com.vivo.push.util.p.a("Utility", "close", e3);
            }
            if (context == null) {
                com.vivo.push.util.p.a("Utility", com.anythink.expressad.foundation.g.b.b.a);
                return false;
            }
            android.database.Cursor query = context.getContentResolver().query(com.vivo.push.p.c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new java.lang.String[]{str, str2, "323"}, null);
            if (query == null) {
                com.vivo.push.util.p.a("Utility", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (java.lang.Exception e4) {
                        com.vivo.push.util.p.a("Utility", "close", e4);
                    }
                }
                return false;
            }
            if (!query.moveToFirst()) {
                query.close();
                return false;
            }
            boolean parseBoolean = java.lang.Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
            try {
                query.close();
            } catch (java.lang.Exception e5) {
                com.vivo.push.util.p.a("Utility", "close", e5);
            }
            return parseBoolean;
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (java.lang.Exception e6) {
                    com.vivo.push.util.p.a("Utility", "close", e6);
                }
            }
            throw th;
        }
    }

    public static java.lang.String c(android.content.Context context, java.lang.String str) {
        java.lang.Object a2 = a(context, str, "verification_status");
        return a2 != null ? a2.toString() : "";
    }

    public static java.security.PublicKey c(android.content.Context context) {
        android.database.Cursor query = context.getContentResolver().query(com.vivo.push.p.a, null, null, null, null);
        if (query == null) {
            return null;
        }
        while (query.moveToNext()) {
            try {
                try {
                    if ("pushkey".equals(query.getString(query.getColumnIndex("name")))) {
                        java.lang.String string = query.getString(query.getColumnIndex("value"));
                        com.vivo.push.util.p.d("Utility", "result key : ".concat(java.lang.String.valueOf(string)));
                        return com.vivo.push.util.u.a(string);
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                try {
                    query.close();
                } catch (java.lang.Exception unused) {
                }
            }
        }
        try {
            query.close();
        } catch (java.lang.Exception unused2) {
        }
        return null;
    }

    private static void d(android.content.Context context, java.lang.String str) {
        try {
            if (context.getPackageManager() == null) {
                throw new com.vivo.push.util.VivoPushException("localPackageManager is null");
            }
            android.content.pm.ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new com.vivo.push.util.VivoPushException("serviceInfos is null");
            }
            for (java.lang.String str2 : c) {
                a(str2, serviceInfoArr, str);
            }
        } catch (java.lang.Exception e2) {
            throw new com.vivo.push.util.VivoPushException("error " + e2.getMessage());
        }
    }

    public static boolean d(android.content.Context context) {
        android.database.Cursor cursor = null;
        try {
            try {
                try {
                } catch (java.lang.Exception e2) {
                    com.vivo.push.util.p.a("Utility", "isSupport", e2);
                    if (0 != 0) {
                        cursor.close();
                    }
                }
            } catch (java.lang.Exception e3) {
                com.vivo.push.util.p.a("Utility", "close", e3);
            }
            if (context == null) {
                com.vivo.push.util.p.a("Utility", com.anythink.expressad.foundation.g.b.b.a);
                return false;
            }
            java.lang.String packageName = context.getPackageName();
            android.database.Cursor query = context.getContentResolver().query(com.vivo.push.p.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new java.lang.String[]{"323", packageName, java.lang.String.valueOf(context.getPackageManager().getPackageInfo(packageName, 0).versionCode)}, null);
            if (query == null) {
                com.vivo.push.util.p.a("Utility", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (java.lang.Exception e4) {
                        com.vivo.push.util.p.a("Utility", "close", e4);
                    }
                }
                return false;
            }
            if (!query.moveToFirst() || (query.getInt(query.getColumnIndex("permission")) & 1) == 0) {
                query.close();
                return false;
            }
            try {
                query.close();
            } catch (java.lang.Exception e5) {
                com.vivo.push.util.p.a("Utility", "close", e5);
            }
            return true;
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (java.lang.Exception e6) {
                    com.vivo.push.util.p.a("Utility", "close", e6);
                }
            }
            throw th;
        }
    }

    private static void e(android.content.Context context, java.lang.String str) {
        if (e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() == null) {
                throw new com.vivo.push.util.VivoPushException("localPackageManager is null");
            }
            android.content.pm.ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr == null) {
                throw new com.vivo.push.util.VivoPushException("activityInfos is null");
            }
            for (java.lang.String str2 : e) {
                a(str2, activityInfoArr, str);
            }
        } catch (java.lang.Exception e2) {
            throw new com.vivo.push.util.VivoPushException("error " + e2.getMessage());
        }
    }

    private static void f(android.content.Context context, java.lang.String str) {
        try {
            if (context.getPackageManager() == null) {
                throw new com.vivo.push.util.VivoPushException("localPackageManager is null");
            }
            android.content.pm.ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new com.vivo.push.util.VivoPushException("receivers is null");
            }
            for (java.lang.String str2 : d) {
                a(str2, activityInfoArr, str);
            }
        } catch (java.lang.Exception e2) {
            throw new com.vivo.push.util.VivoPushException(e2.getMessage());
        }
    }
}
