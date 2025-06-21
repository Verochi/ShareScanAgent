package com.alipay.apmobilesecuritysdk.a;

/* loaded from: classes.dex */
public final class a {
    public android.content.Context a;
    public com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    public int c = 4;

    public a(android.content.Context context) {
        this.a = context;
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String b = b(context);
        return com.alipay.sdk.m.z.a.a(b) ? com.alipay.apmobilesecuritysdk.e.h.f(context) : b;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            b();
            java.lang.String a = com.alipay.apmobilesecuritysdk.e.i.a(str);
            if (!com.alipay.sdk.m.z.a.a(a)) {
                return a;
            }
            java.lang.String a2 = com.alipay.apmobilesecuritysdk.e.g.a(context, str);
            com.alipay.apmobilesecuritysdk.e.i.a(str, a2);
            return !com.alipay.sdk.m.z.a.a(a2) ? a2 : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.lang.String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = ((int) (java.lang.Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i = 0; i < 3; i++) {
            try {
                java.lang.String[] split = strArr[i].split(" ");
                if (split != null && split.length == 2) {
                    java.util.Date date = new java.util.Date();
                    java.util.Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    java.util.Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    java.util.Calendar calendar = java.util.Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random);
                    java.util.Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    private com.alipay.sdk.m.f0.c b(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        com.alipay.apmobilesecuritysdk.e.b b;
        com.alipay.apmobilesecuritysdk.e.b c;
        java.lang.String str4 = "";
        try {
            android.content.Context context = this.a;
            com.alipay.sdk.m.f0.d dVar = new com.alipay.sdk.m.f0.d();
            java.lang.String a = com.alipay.sdk.m.z.a.a(map, "appName", "");
            java.lang.String a2 = com.alipay.sdk.m.z.a.a(map, "sessionId", "");
            java.lang.String a3 = com.alipay.sdk.m.z.a.a(map, "rpcVersion", "");
            java.lang.String a4 = a(context, a);
            java.lang.String securityToken = com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper.getSecurityToken(context);
            java.lang.String d = com.alipay.apmobilesecuritysdk.e.h.d(context);
            if (com.alipay.sdk.m.z.a.b(a2)) {
                dVar.c = a2;
            } else {
                dVar.c = a4;
            }
            dVar.d = securityToken;
            dVar.e = d;
            dVar.a = com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM;
            com.alipay.apmobilesecuritysdk.e.c c2 = com.alipay.apmobilesecuritysdk.e.d.c(context);
            if (c2 != null) {
                str2 = c2.a;
                str = c2.c;
            } else {
                str = "";
                str2 = str;
            }
            if (com.alipay.sdk.m.z.a.a(str2) && (c = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = c.a;
                str = c.c;
            }
            com.alipay.apmobilesecuritysdk.e.c b2 = com.alipay.apmobilesecuritysdk.e.d.b();
            if (b2 != null) {
                str4 = b2.a;
                str3 = b2.c;
            } else {
                str3 = "";
            }
            if (com.alipay.sdk.m.z.a.a(str4) && (b = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = b.a;
                str3 = b.c;
            }
            dVar.h = str2;
            dVar.g = str4;
            dVar.j = a3;
            if (com.alipay.sdk.m.z.a.a(str2)) {
                dVar.b = str4;
                str = str3;
            } else {
                dVar.b = str2;
            }
            dVar.i = str;
            dVar.f = com.alipay.apmobilesecuritysdk.d.e.a(context, map);
            return com.alipay.sdk.m.d0.d.b(this.a, this.b.c()).a(dVar);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            java.lang.String b = com.alipay.apmobilesecuritysdk.e.i.b();
            if (!com.alipay.sdk.m.z.a.a(b)) {
                return b;
            }
            com.alipay.apmobilesecuritysdk.e.c b2 = com.alipay.apmobilesecuritysdk.e.d.b(context);
            if (b2 != null) {
                com.alipay.apmobilesecuritysdk.e.i.a(b2);
                java.lang.String str = b2.a;
                if (com.alipay.sdk.m.z.a.b(str)) {
                    return str;
                }
            }
            com.alipay.apmobilesecuritysdk.e.b b3 = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (b3 == null) {
                return "";
            }
            com.alipay.apmobilesecuritysdk.e.i.a(b3);
            java.lang.String str2 = b3.a;
            return com.alipay.sdk.m.z.a.b(str2) ? str2 : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            java.lang.String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i = 0; i < 5; i++) {
                java.lang.String str = strArr[i];
                java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory(), ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x00bb, code lost:
    
        if (com.alipay.sdk.m.z.a.a(b(r9.a)) != false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01fe A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0008, B:5:0x0039, B:8:0x0042, B:12:0x00c0, B:16:0x01e4, B:18:0x01fe, B:20:0x0206, B:22:0x020c, B:26:0x0215, B:28:0x021b, B:34:0x00d4, B:36:0x00ec, B:41:0x00f9, B:42:0x0109, B:43:0x0110, B:48:0x0122, B:50:0x0172, B:52:0x017c, B:53:0x0184, B:55:0x0191, B:57:0x019b, B:58:0x01a3, B:59:0x019f, B:60:0x0180, B:62:0x0057, B:64:0x0065, B:67:0x0070, B:69:0x0076, B:72:0x0081, B:75:0x008a, B:78:0x0097, B:82:0x00a4, B:85:0x00b1), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0206 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0008, B:5:0x0039, B:8:0x0042, B:12:0x00c0, B:16:0x01e4, B:18:0x01fe, B:20:0x0206, B:22:0x020c, B:26:0x0215, B:28:0x021b, B:34:0x00d4, B:36:0x00ec, B:41:0x00f9, B:42:0x0109, B:43:0x0110, B:48:0x0122, B:50:0x0172, B:52:0x017c, B:53:0x0184, B:55:0x0191, B:57:0x019b, B:58:0x01a3, B:59:0x019f, B:60:0x0180, B:62:0x0057, B:64:0x0065, B:67:0x0070, B:69:0x0076, B:72:0x0081, B:75:0x008a, B:78:0x0097, B:82:0x00a4, B:85:0x00b1), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0215 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0008, B:5:0x0039, B:8:0x0042, B:12:0x00c0, B:16:0x01e4, B:18:0x01fe, B:20:0x0206, B:22:0x020c, B:26:0x0215, B:28:0x021b, B:34:0x00d4, B:36:0x00ec, B:41:0x00f9, B:42:0x0109, B:43:0x0110, B:48:0x0122, B:50:0x0172, B:52:0x017c, B:53:0x0184, B:55:0x0191, B:57:0x019b, B:58:0x01a3, B:59:0x019f, B:60:0x0180, B:62:0x0057, B:64:0x0065, B:67:0x0070, B:69:0x0076, B:72:0x0081, B:75:0x008a, B:78:0x0097, B:82:0x00a4, B:85:0x00b1), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0008, B:5:0x0039, B:8:0x0042, B:12:0x00c0, B:16:0x01e4, B:18:0x01fe, B:20:0x0206, B:22:0x020c, B:26:0x0215, B:28:0x021b, B:34:0x00d4, B:36:0x00ec, B:41:0x00f9, B:42:0x0109, B:43:0x0110, B:48:0x0122, B:50:0x0172, B:52:0x017c, B:53:0x0184, B:55:0x0191, B:57:0x019b, B:58:0x01a3, B:59:0x019f, B:60:0x0180, B:62:0x0057, B:64:0x0065, B:67:0x0070, B:69:0x0076, B:72:0x0081, B:75:0x008a, B:78:0x0097, B:82:0x00a4, B:85:0x00b1), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String a;
        boolean z;
        boolean z2;
        int i;
        java.lang.String str;
        com.alipay.sdk.m.g0.a b;
        android.content.Context context;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.a, com.alipay.sdk.m.z.a.a(map, "tid", ""), com.alipay.sdk.m.z.a.a(map, com.alipay.sdk.m.l.b.g, ""), a(this.a));
            a = com.alipay.sdk.m.z.a.a(map, "appName", "");
            b();
            b(this.a);
            a(this.a, a);
            com.alipay.apmobilesecuritysdk.e.i.a();
            z = false;
        } catch (java.lang.Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.a)) {
            com.alipay.apmobilesecuritysdk.d.e.a();
            if (!(!com.alipay.sdk.m.z.a.a(com.alipay.apmobilesecuritysdk.d.e.b(this.a, map), com.alipay.apmobilesecuritysdk.e.i.c()))) {
                java.lang.String a2 = com.alipay.sdk.m.z.a.a(map, "tid", "");
                java.lang.String a3 = com.alipay.sdk.m.z.a.a(map, com.alipay.sdk.m.l.b.g, "");
                if (com.alipay.sdk.m.z.a.b(a2)) {
                    if (!com.alipay.sdk.m.z.a.a(a2, com.alipay.apmobilesecuritysdk.e.i.d())) {
                    }
                }
                if (com.alipay.sdk.m.z.a.b(a3)) {
                    if (!com.alipay.sdk.m.z.a.a(a3, com.alipay.apmobilesecuritysdk.e.i.e())) {
                    }
                }
                if (com.alipay.apmobilesecuritysdk.e.i.a(this.a, a)) {
                    if (!com.alipay.sdk.m.z.a.a(a(this.a, a))) {
                        if (com.alipay.sdk.m.z.a.a(b(this.a))) {
                        }
                        z2 = false;
                        android.content.Context context2 = this.a;
                        com.alipay.sdk.m.a0.b.b();
                        com.alipay.apmobilesecuritysdk.e.h.b(context2, java.lang.String.valueOf(com.alipay.sdk.m.a0.b.n()));
                        if (z2) {
                            new com.alipay.apmobilesecuritysdk.c.b();
                            com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper.startUmidTaskSync(this.a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                            com.alipay.sdk.m.f0.c b2 = b(map);
                            int c = b2 != null ? b2.c() : 2;
                            if (c != 1) {
                                if (c != 3) {
                                    if (b2 != null) {
                                        str = "Server error, result:" + b2.b;
                                    } else {
                                        str = "Server error, returned null";
                                    }
                                    com.alipay.apmobilesecuritysdk.c.a.a(str);
                                    if (com.alipay.sdk.m.z.a.a(a(this.a, a))) {
                                        i = 4;
                                    }
                                } else {
                                    i = 1;
                                }
                                this.c = i;
                                b = com.alipay.sdk.m.d0.d.b(this.a, this.b.c());
                                context = this.a;
                                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                                activeNetworkInfo = connectivityManager == null ? connectivityManager.getActiveNetworkInfo() : null;
                                if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                                    z = true;
                                }
                                if (z && com.alipay.apmobilesecuritysdk.e.h.c(context)) {
                                    new com.alipay.sdk.m.c0.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b).a();
                                }
                                return this.c;
                            }
                            com.alipay.apmobilesecuritysdk.e.h.a(this.a, b2.b());
                            com.alipay.apmobilesecuritysdk.e.h.d(this.a, b2.a());
                            com.alipay.apmobilesecuritysdk.e.h.e(this.a, b2.g);
                            com.alipay.apmobilesecuritysdk.e.h.a(this.a, b2.h);
                            com.alipay.apmobilesecuritysdk.e.h.f(this.a, b2.i);
                            com.alipay.apmobilesecuritysdk.e.h.g(this.a, b2.k);
                            com.alipay.apmobilesecuritysdk.e.i.c(com.alipay.apmobilesecuritysdk.d.e.b(this.a, map));
                            com.alipay.apmobilesecuritysdk.e.i.a(a, b2.d);
                            com.alipay.apmobilesecuritysdk.e.i.b(b2.c);
                            com.alipay.apmobilesecuritysdk.e.i.d(b2.j);
                            java.lang.String a4 = com.alipay.sdk.m.z.a.a(map, "tid", "");
                            if (!com.alipay.sdk.m.z.a.b(a4) || com.alipay.sdk.m.z.a.a(a4, com.alipay.apmobilesecuritysdk.e.i.d())) {
                                a4 = com.alipay.apmobilesecuritysdk.e.i.d();
                            } else {
                                com.alipay.apmobilesecuritysdk.e.i.e(a4);
                            }
                            com.alipay.apmobilesecuritysdk.e.i.e(a4);
                            java.lang.String a5 = com.alipay.sdk.m.z.a.a(map, com.alipay.sdk.m.l.b.g, "");
                            if (!com.alipay.sdk.m.z.a.b(a5) || com.alipay.sdk.m.z.a.a(a5, com.alipay.apmobilesecuritysdk.e.i.e())) {
                                a5 = com.alipay.apmobilesecuritysdk.e.i.e();
                            } else {
                                com.alipay.apmobilesecuritysdk.e.i.f(a5);
                            }
                            com.alipay.apmobilesecuritysdk.e.i.f(a5);
                            com.alipay.apmobilesecuritysdk.e.i.a();
                            com.alipay.apmobilesecuritysdk.e.d.a(this.a, com.alipay.apmobilesecuritysdk.e.i.g());
                            com.alipay.apmobilesecuritysdk.e.d.a();
                            com.alipay.apmobilesecuritysdk.e.a.a(this.a, new com.alipay.apmobilesecuritysdk.e.b(com.alipay.apmobilesecuritysdk.e.i.b(), com.alipay.apmobilesecuritysdk.e.i.c(), com.alipay.apmobilesecuritysdk.e.i.f()));
                            com.alipay.apmobilesecuritysdk.e.a.a();
                            com.alipay.apmobilesecuritysdk.e.g.a(this.a, a, com.alipay.apmobilesecuritysdk.e.i.a(a));
                            com.alipay.apmobilesecuritysdk.e.g.a();
                            com.alipay.apmobilesecuritysdk.e.h.a(this.a, a, java.lang.System.currentTimeMillis());
                        }
                        i = 0;
                        this.c = i;
                        b = com.alipay.sdk.m.d0.d.b(this.a, this.b.c());
                        context = this.a;
                        android.net.ConnectivityManager connectivityManager2 = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager2 == null) {
                        }
                        if (activeNetworkInfo != null) {
                            z = true;
                        }
                        if (z) {
                            new com.alipay.sdk.m.c0.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b).a();
                        }
                        return this.c;
                    }
                }
            }
            z2 = true;
            android.content.Context context22 = this.a;
            com.alipay.sdk.m.a0.b.b();
            com.alipay.apmobilesecuritysdk.e.h.b(context22, java.lang.String.valueOf(com.alipay.sdk.m.a0.b.n()));
            if (z2) {
            }
            i = 0;
            this.c = i;
            b = com.alipay.sdk.m.d0.d.b(this.a, this.b.c());
            context = this.a;
            android.net.ConnectivityManager connectivityManager22 = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager22 == null) {
            }
            if (activeNetworkInfo != null) {
            }
            if (z) {
            }
            return this.c;
        }
        if (!com.alipay.sdk.m.z.a.a(a(this.a, a))) {
        }
        z2 = true;
        android.content.Context context222 = this.a;
        com.alipay.sdk.m.a0.b.b();
        com.alipay.apmobilesecuritysdk.e.h.b(context222, java.lang.String.valueOf(com.alipay.sdk.m.a0.b.n()));
        if (z2) {
        }
        i = 0;
        this.c = i;
        b = com.alipay.sdk.m.d0.d.b(this.a, this.b.c());
        context = this.a;
        android.net.ConnectivityManager connectivityManager222 = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager222 == null) {
        }
        if (activeNetworkInfo != null) {
        }
        if (z) {
        }
        return this.c;
    }
}
