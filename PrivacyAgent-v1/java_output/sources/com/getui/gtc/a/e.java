package com.getui.gtc.a;

/* loaded from: classes22.dex */
public final class e implements com.getui.gtc.a.b {
    private java.lang.String a;
    private boolean b = true;
    private long c = com.heytap.mcssdk.constant.a.g;

    private static java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.getui.gtc.BuildConfig.VERSION_NAME);
        sb.append(",");
        try {
            java.lang.reflect.Method declaredMethod = com.igexin.sdk.PushManager.class.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod2 = com.igexin.sdk.PushManager.class.getDeclaredMethod("getVersion", android.content.Context.class);
            declaredMethod2.setAccessible(true);
            sb.append("GT-".concat(java.lang.String.valueOf((java.lang.String) declaredMethod2.invoke(invoke, com.getui.gtc.base.GtcProvider.context()))));
            sb.append(",");
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.getui.gis.sdk.GInsightManager");
            java.lang.reflect.Method declaredMethod3 = cls.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            declaredMethod3.setAccessible(true);
            java.lang.Object invoke2 = declaredMethod3.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod4 = cls.getDeclaredMethod("version", new java.lang.Class[0]);
            declaredMethod4.setAccessible(true);
            sb.append((java.lang.String) declaredMethod4.invoke(invoke2, new java.lang.Object[0]));
            sb.append(",");
        } catch (java.lang.Throwable unused2) {
        }
        try {
            java.lang.reflect.Method declaredMethod5 = com.getui.gs.sdk.GsManager.class.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            declaredMethod5.setAccessible(true);
            java.lang.Object invoke3 = declaredMethod5.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod6 = com.getui.gs.sdk.GsManager.class.getDeclaredMethod("getVersion", new java.lang.Class[0]);
            declaredMethod6.setAccessible(true);
            sb.append((java.lang.String) declaredMethod6.invoke(invoke3, new java.lang.Object[0]));
            sb.append(",");
        } catch (java.lang.Throwable unused3) {
        }
        try {
            java.lang.Class<?> cls2 = java.lang.Class.forName("com.g.gysdk.GYManager");
            java.lang.reflect.Method declaredMethod7 = cls2.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            declaredMethod7.setAccessible(true);
            java.lang.Object invoke4 = declaredMethod7.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod8 = cls2.getDeclaredMethod("getVersion", new java.lang.Class[0]);
            declaredMethod8.setAccessible(true);
            sb.append((java.lang.String) declaredMethod8.invoke(invoke4, new java.lang.Object[0]));
            sb.append(",");
        } catch (java.lang.Throwable unused4) {
        }
        try {
            java.lang.Class<?> cls3 = java.lang.Class.forName("com.getui.ctid.CTIDManager");
            java.lang.reflect.Method declaredMethod9 = cls3.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            declaredMethod9.setAccessible(true);
            java.lang.Object invoke5 = declaredMethod9.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod10 = cls3.getDeclaredMethod("getVersion", new java.lang.Class[0]);
            declaredMethod10.setAccessible(true);
            sb.append((java.lang.String) declaredMethod10.invoke(invoke5, new java.lang.Object[0]));
            sb.append(",");
        } catch (java.lang.Throwable unused5) {
        }
        try {
            java.lang.reflect.Method declaredMethod11 = java.lang.Class.forName("com.getui.iop.IopManager").getDeclaredMethod("getVersion", new java.lang.Class[0]);
            declaredMethod11.setAccessible(true);
            sb.append((java.lang.String) declaredMethod11.invoke(null, new java.lang.Object[0]));
            sb.append(",");
        } catch (java.lang.Throwable unused6) {
        }
        try {
            java.lang.Class<?> cls4 = java.lang.Class.forName("com.sdk.plus.WusManager");
            java.lang.reflect.Method declaredMethod12 = cls4.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            declaredMethod12.setAccessible(true);
            java.lang.Object invoke6 = declaredMethod12.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod13 = cls4.getDeclaredMethod("getVersion", new java.lang.Class[0]);
            declaredMethod13.setAccessible(true);
            sb.append((java.lang.String) declaredMethod13.invoke(invoke6, new java.lang.Object[0]));
            sb.append(",");
        } catch (java.lang.Throwable unused7) {
        }
        try {
            java.lang.Class<?> cls5 = java.lang.Class.forName("com.getui.oneid.OneIDManager");
            java.lang.reflect.Method declaredMethod14 = cls5.getDeclaredMethod("getInstance", new java.lang.Class[0]);
            declaredMethod14.setAccessible(true);
            java.lang.Object invoke7 = declaredMethod14.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod15 = cls5.getDeclaredMethod("getVersion", new java.lang.Class[0]);
            declaredMethod15.setAccessible(true);
            sb.append((java.lang.String) declaredMethod15.invoke(invoke7, new java.lang.Object[0]));
            sb.append(",");
        } catch (java.lang.Throwable unused8) {
        }
        java.lang.String sb2 = sb.toString();
        return sb2.endsWith(",") ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    private static void a(android.os.Bundle bundle, java.lang.StringBuilder sb, java.lang.String str) {
        java.lang.String string = bundle.getString(str);
        if (android.text.TextUtils.isEmpty(string)) {
            return;
        }
        sb.append(str);
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb.append(string);
        sb.append(",");
    }

    private static java.lang.String b() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.os.Bundle bundle = com.getui.gtc.base.util.CommonUtil.getAppInfoForSelf(com.getui.gtc.base.GtcProvider.context()).metaData;
            if (bundle == null) {
                return "";
            }
            a(bundle, sb, "GETUI_APPID");
            a(bundle, sb, "GETUI_APP_ID");
            a(bundle, sb, com.igexin.push.core.b.b);
            a(bundle, sb, "GI_APPID");
            a(bundle, sb, "GI_APP_ID");
            a(bundle, sb, "GS_APPID");
            a(bundle, sb, "GS_APP_ID");
            a(bundle, sb, "GY_APPID");
            a(bundle, sb, "GY_APP_ID");
            a(bundle, sb, "com.sdk.plus.appid");
            java.lang.String sb2 = sb.toString();
            return sb2.endsWith(",") ? sb2.substring(0, sb2.length() - 1) : sb2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            return "";
        }
    }

    private static java.lang.String c() {
        try {
            if (!d()) {
                return "0,-1";
            }
            return "1," + e();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            return "0,-1";
        }
    }

    private static boolean d() {
        java.lang.String str;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]));
        } catch (java.lang.ClassNotFoundException unused) {
            str = "occured ClassNotFoundException";
            com.getui.gtc.h.c.a.c(str);
            return false;
        } catch (java.lang.NoSuchMethodException unused2) {
            str = "occured NoSuchMethodException";
            com.getui.gtc.h.c.a.c(str);
            return false;
        } catch (java.lang.Exception unused3) {
            str = "occur other problem";
            com.getui.gtc.h.c.a.c(str);
            return false;
        }
    }

    private static java.lang.String e() {
        try {
            java.lang.reflect.Method method = null;
            for (java.lang.reflect.Method method2 : java.lang.Class.forName("android.os.SystemProperties").getMethods()) {
                if (method2.getName().equals(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                    method = method2;
                }
            }
            return method != null ? (java.lang.String) method.invoke(null, com.alipay.sdk.m.c.a.b, "error") : "error";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            return "error";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114 A[Catch: Exception -> 0x012c, TryCatch #0 {Exception -> 0x012c, blocks: (B:35:0x00ff, B:38:0x0114, B:40:0x0129), top: B:34:0x00ff }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        java.lang.String str;
        long currentTimeMillis;
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        java.lang.String str2 = "";
        java.util.Map<java.lang.String, java.lang.String> a = com.getui.gtc.f.c.a(null);
        if (a != null && a.size() > 0) {
            try {
                if (a.containsKey("sdk.gtc.type302.enable")) {
                    this.b = java.lang.Boolean.parseBoolean(a.get("sdk.gtc.type302.enable"));
                }
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.b(e);
            }
            try {
                if (a.containsKey("sdk.gtc.type302.interval")) {
                    this.c = java.lang.Long.parseLong(a.get("sdk.gtc.type302.interval")) * 1000;
                }
            } catch (java.lang.Exception e2) {
                com.getui.gtc.h.c.a.b(e2);
            }
        }
        if (!this.b) {
            com.getui.gtc.h.c.a.b("type 302 is not enabled");
            return;
        }
        if (com.getui.gtc.base.util.CommonUtil.isAppDebugEnable()) {
            com.getui.gtc.h.c.a.b("type 302 is debug, disallow");
            return;
        }
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);
        java.lang.String packageName = com.getui.gtc.base.GtcProvider.context().getPackageName();
        try {
            android.content.pm.PackageInfo a2 = com.getui.gtc.h.d.a.a(packageName);
            str = a2.versionName;
            try {
                str2 = java.lang.String.valueOf(a2.versionCode);
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.h.c.a.b(th);
                this.a = com.getui.gtc.a.a.a(simpleDateFormat.format(new java.util.Date())) + "|" + com.getui.gtc.a.a.a(com.getui.gtc.c.b.d) + "|" + com.getui.gtc.a.a.a(com.getui.gtc.c.b.a) + "|" + com.getui.gtc.a.a.a(packageName) + "|" + com.getui.gtc.a.a.a(str) + "|" + com.getui.gtc.a.a.a(str2) + "|android|" + com.getui.gtc.a.a.a(a()) + "|" + com.getui.gtc.a.a.a(b()) + "|" + c();
                currentTimeMillis = java.lang.System.currentTimeMillis();
                cVar = com.getui.gtc.e.c.a.a;
                if (currentTimeMillis - cVar.a.k >= this.c) {
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = "";
        }
        this.a = com.getui.gtc.a.a.a(simpleDateFormat.format(new java.util.Date())) + "|" + com.getui.gtc.a.a.a(com.getui.gtc.c.b.d) + "|" + com.getui.gtc.a.a.a(com.getui.gtc.c.b.a) + "|" + com.getui.gtc.a.a.a(packageName) + "|" + com.getui.gtc.a.a.a(str) + "|" + com.getui.gtc.a.a.a(str2) + "|android|" + com.getui.gtc.a.a.a(a()) + "|" + com.getui.gtc.a.a.a(b()) + "|" + c();
        try {
            currentTimeMillis = java.lang.System.currentTimeMillis();
            cVar = com.getui.gtc.e.c.a.a;
            if (currentTimeMillis - cVar.a.k >= this.c) {
                return;
            }
            com.getui.gtc.g.a.a(this.a, 302);
            cVar2 = com.getui.gtc.e.c.a.a;
            com.getui.gtc.e.d dVar = cVar2.a;
            if (dVar.a(15, currentTimeMillis)) {
                dVar.k = currentTimeMillis;
            }
        } catch (java.lang.Exception e3) {
            com.getui.gtc.h.c.a.c("type 302 report error: " + e3.toString());
        }
    }
}
