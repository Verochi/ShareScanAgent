package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class e {
    public static java.lang.String a;
    public static java.lang.String b;
    public static java.util.List<com.anythink.core.common.f.s> d;
    static java.lang.String e;
    private static java.lang.String f;
    private static java.lang.String g;
    private static java.lang.String j;
    private static boolean k;
    private static int l;
    private static boolean m;
    private static java.lang.String n;
    private static final org.json.JSONObject h = new org.json.JSONObject();
    private static java.lang.String i = null;
    public static java.lang.String c = "";
    private static volatile java.lang.String o = null;
    private static java.lang.String p = "";
    private static java.lang.String q = "";
    private static java.lang.String r = "";

    /* renamed from: s, reason: collision with root package name */
    private static java.lang.String f180s = "";
    private static int t = 0;
    private static java.lang.String u = "";
    private static java.lang.String v = "";
    private static java.lang.String w = null;
    private static java.lang.String x = "";
    private static java.lang.String y = "";
    private static int z = -1;
    private static int A = -1;
    private static int B = -1;
    private static int C = -1;

    /* renamed from: com.anythink.core.common.o.e$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass1(int i, java.lang.String str) {
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.anythink.core.common.o.e.h) {
                if (com.anythink.core.common.o.e.h.has(java.lang.String.valueOf(this.a))) {
                    return;
                }
                try {
                    com.anythink.core.common.o.e.h.put(java.lang.String.valueOf(this.a), this.b);
                    java.lang.String unused = com.anythink.core.common.o.e.i = com.anythink.core.common.o.e.h.toString();
                } catch (java.lang.Throwable unused2) {
                }
            }
        }
    }

    /* renamed from: com.anythink.core.common.o.e$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String[] b;
        final /* synthetic */ java.util.concurrent.ExecutorService c;

        public AnonymousClass2(android.content.Context context, java.lang.String[] strArr, java.util.concurrent.ExecutorService executorService) {
            this.a = context;
            this.b = strArr;
            this.c = executorService;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    java.lang.Class<?> cls = java.lang.Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                    java.lang.Class<?> cls2 = java.lang.Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                    this.b[0] = (java.lang.String) cls2.getMethod("getId", new java.lang.Class[0]).invoke(cls.getMethod("getAdvertisingIdInfo", android.content.Context.class).invoke(null, this.a), new java.lang.Object[0]);
                } catch (java.lang.Exception unused) {
                }
            } catch (java.lang.Throwable unused2) {
                this.b[0] = new com.anythink.core.common.b.d().a(this.a).a();
            }
            if (!android.text.TextUtils.isEmpty(this.b[0]) && !com.anythink.core.common.o.e.e(this.b[0])) {
                com.anythink.core.common.o.e.a(this.b[0]);
            }
            try {
                synchronized (this.c) {
                    this.c.notifyAll();
                }
            } catch (java.lang.Throwable unused3) {
            }
        }
    }

    private e() {
    }

    private static int a(int i2) {
        if (i2 == 20) {
            return 16;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 13;
            default:
                return -1;
        }
    }

    public static java.lang.String a() {
        if (com.anythink.core.common.b.o.a().c("model")) {
            return "";
        }
        try {
            return !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() ? "" : android.os.Build.MODEL;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        if (context != null) {
            try {
                android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(packageInfo.versionCode);
                return sb.toString();
            } catch (java.lang.Throwable unused) {
            }
        }
        return "";
    }

    public static void a(int i2, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.o.e.AnonymousClass1(i2, str), 13, true);
    }

    public static void a(android.content.Context context) {
        try {
            d();
            l(context);
            j(context);
            i(context);
            g(context);
            a();
            b();
            d(context);
            f();
            f(context);
            c();
            o(context);
            if (com.anythink.core.common.o.i.a(com.anythink.china.common.d.a, context)) {
                java.lang.String simOperator = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
                if (com.anythink.core.common.o.i.b(simOperator) && simOperator.length() > 3) {
                    x = simOperator.substring(0, 3);
                    y = simOperator.substring(3, simOperator.length());
                }
            }
            if (d == null) {
                long longValue = com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "det_hw_time", (java.lang.Long) 0L).longValue();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                d = arrayList;
                arrayList.add(new com.anythink.core.common.f.s(context, longValue, "hw_ver", "com.huawei.appmarket"));
                d.add(new com.anythink.core.common.f.s(context, longValue, "hw_hms_ver", "com.huawei.hwid"));
                d.add(new com.anythink.core.common.f.s(context, longValue, "honor_ver", "com.huawei.appmarket"));
                com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "det_hw_time", java.lang.System.currentTimeMillis());
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static void a(java.lang.String str) {
        g = str;
        com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.f160s, g);
    }

    public static int b(java.lang.String str) {
        int i2 = C;
        if (i2 != -1) {
            return i2;
        }
        C = 0;
        try {
            C = ((java.lang.Integer) com.tencent.mm.opensdk.openapi.IWXAPI.class.getMethod("getWXAppSupportAPI", new java.lang.Class[0]).invoke(c(str), new java.lang.Object[0])).intValue();
        } catch (java.lang.Throwable unused) {
        }
        return C;
    }

    public static java.lang.String b() {
        if (com.anythink.core.common.b.o.a().c("brand")) {
            return "";
        }
        try {
            return !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() ? "" : android.os.Build.BRAND;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String b(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("mcc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.b.o.a().f();
        }
        try {
            return !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() ? "" : x;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.Object c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.tencent.mm.opensdk.openapi.WXAPIFactory.class.getMethod("createWXAPI", android.content.Context.class, java.lang.String.class).invoke(null, com.anythink.core.common.b.o.a().f(), str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String c() {
        if (com.anythink.core.common.b.o.a().c("timezone")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            try {
                if (android.text.TextUtils.isEmpty(v)) {
                    java.lang.String displayName = java.util.TimeZone.getDefault().getDisplayName(false, 0, java.util.Locale.ENGLISH);
                    v = displayName;
                    return displayName;
                }
            } catch (java.lang.Throwable unused) {
            }
            return v;
        } catch (java.lang.Exception unused2) {
            return "";
        }
    }

    public static java.lang.String c(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("mnc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.b.o.a().f();
        }
        try {
            return !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b() ? "" : y;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String d() {
        if (com.anythink.core.common.b.o.a().c("os_vc")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            if (android.text.TextUtils.isEmpty(q)) {
                q = java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT);
            }
            return q;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static synchronized java.lang.String d(android.content.Context context) {
        synchronized (com.anythink.core.common.o.e.class) {
            if (com.anythink.core.common.b.o.a().c("android_id")) {
                return "";
            }
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            com.anythink.core.api.IExHandler b2 = com.anythink.core.common.b.o.a().b();
            if (b2 != null) {
                if (context == null) {
                    context = com.anythink.core.common.b.o.a().f();
                }
                if (n == null) {
                    n = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.v, "");
                }
                if (!android.text.TextUtils.isEmpty(n)) {
                    return n;
                }
                java.lang.String aid = b2.getAid(context);
                n = aid;
                if (!android.text.TextUtils.isEmpty(aid)) {
                    com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.v, n);
                    return n;
                }
            } else {
                n = "";
            }
            return n;
        }
    }

    public static java.lang.String e() {
        if (com.anythink.core.common.b.o.a().c("os_vn")) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(p)) {
            p = android.os.Build.VERSION.RELEASE;
        }
        return p;
    }

    public static java.lang.String e(android.content.Context context) {
        java.lang.String d2;
        if (context == null) {
            return "";
        }
        try {
            d2 = d(context);
        } catch (java.lang.Throwable unused) {
        }
        if (android.text.TextUtils.isEmpty(d2)) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(e)) {
            e = com.anythink.core.common.o.g.b(d2);
        }
        return e;
    }

    public static /* synthetic */ boolean e(java.lang.String str) {
        return java.util.regex.Pattern.matches("^[0-]+$", str);
    }

    public static java.lang.String f() {
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            if (g == null) {
                g = com.anythink.core.common.o.r.b(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.f160s, "");
            }
            return g;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String f(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("language")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            if (!android.text.TextUtils.isEmpty(u)) {
                return u;
            }
            java.lang.String language = context.getResources().getConfiguration().locale.getLanguage();
            u = language;
            return language;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static boolean f(java.lang.String str) {
        return java.util.regex.Pattern.matches("^[0-]+$", str);
    }

    public static int g(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("orient")) {
            return 0;
        }
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        return context.getResources().getConfiguration().orientation == 2 ? 2 : 1;
    }

    public static java.lang.String g() {
        if (com.anythink.core.common.b.o.a().b() == null) {
            return "";
        }
        try {
            return new java.math.BigDecimal((java.lang.System.currentTimeMillis() - android.os.SystemClock.elapsedRealtime()) / 1000.0d).setScale(6, 4).toString();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static org.json.JSONObject h() {
        try {
            return new org.json.JSONObject(i);
        } catch (java.lang.Throwable unused) {
            return new org.json.JSONObject();
        }
    }

    public static boolean h(android.content.Context context) {
        return g(context) == 2;
    }

    public static synchronized java.lang.String i() {
        synchronized (com.anythink.core.common.o.e.class) {
            if (com.anythink.core.common.b.o.a().c("ua")) {
                return "";
            }
            try {
                if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                    return "";
                }
                if (!android.text.TextUtils.isEmpty(o)) {
                    return o;
                }
                if (o == null) {
                    java.lang.String b2 = com.anythink.core.common.o.r.b(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.f, "");
                    o = b2;
                    if (!android.text.TextUtils.isEmpty(b2)) {
                        return o;
                    }
                }
                java.lang.String str = android.os.Build.VERSION.RELEASE;
                java.lang.String a2 = a();
                java.lang.String str2 = android.os.Build.ID;
                if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(a2) || android.text.TextUtils.isEmpty(str2)) {
                    return "";
                }
                return "Mozilla/5.0 (Linux; Android " + str + "; " + a2 + " Build/" + str2 + ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            } catch (java.lang.Exception unused) {
                return "";
            }
        }
    }

    public static java.lang.String i(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("app_vc")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        if (t != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(t);
            return sb.toString();
        }
        try {
            t = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(t);
            return sb2.toString();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String j() {
        if (!android.text.TextUtils.isEmpty(c)) {
            return c;
        }
        java.lang.String G = com.anythink.core.common.b.o.a().G();
        if (!android.text.TextUtils.isEmpty(G)) {
            c = G;
            return G;
        }
        java.lang.String G2 = com.anythink.core.common.b.o.a().G();
        if (android.text.TextUtils.isEmpty(G2)) {
            try {
                java.lang.Class.forName("com.unity3d.player.UnityPlayer");
                G2 = "2";
            } catch (java.lang.Throwable unused) {
                G2 = "1";
            }
            try {
                java.lang.Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
                java.lang.Class.forName("org.cocos2dx.lib.Cocos2dxJavascriptJavaBridge");
                G2 = "4";
            } catch (java.lang.Throwable unused2) {
            }
        }
        c = G2;
        return G2;
    }

    public static java.lang.String j(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("app_vn")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        try {
            if (!android.text.TextUtils.isEmpty(f180s)) {
                return f180s;
            }
            java.lang.String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f180s = str;
            return str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int k() {
        if (A == -1) {
            if (android.text.TextUtils.isEmpty(l())) {
                A = 0;
            } else {
                try {
                    A = 1;
                } catch (java.lang.Throwable unused) {
                    A = 0;
                }
            }
        }
        return A;
    }

    public static java.lang.String k(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("screen")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append((context == null ? com.anythink.core.common.b.o.a().f() : context).getResources().getDisplayMetrics().widthPixels);
            sb.append("*");
            if (context == null) {
                context = com.anythink.core.common.b.o.a().f();
            }
            sb.append(context.getResources().getDisplayMetrics().heightPixels);
            return sb.toString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String l() {
        java.lang.Object obj;
        java.lang.String c2 = com.anythink.core.common.b.o.a().c();
        if (!android.text.TextUtils.isEmpty(c2)) {
            return c2;
        }
        try {
            java.util.Map<java.lang.String, java.lang.Object> l2 = com.anythink.core.common.b.o.a().l();
            if (l2 == null || (obj = l2.get(com.anythink.core.api.ATAdConst.KEY.WECHAT_APPID)) == null) {
                return null;
            }
            return obj.toString();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.String l(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("package_name")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        try {
            if (!android.text.TextUtils.isEmpty(r)) {
                return r;
            }
            java.lang.String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            r = str;
            return str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int m() {
        int i2 = B;
        if (i2 != -1) {
            return i2;
        }
        B = 0;
        try {
            B = ((java.lang.Integer) com.tencent.mm.opensdk.constants.Build.class.getField("SDK_INT").get(null)).intValue();
        } catch (java.lang.Throwable unused) {
        }
        return B;
    }

    public static java.lang.String m(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("it_src")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        try {
            if (!android.text.TextUtils.isEmpty(a)) {
                return a;
            }
            java.lang.String installerPackageName = context.getPackageManager().getInstallerPackageName(l(context));
            a = installerPackageName;
            return installerPackageName;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String n(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (com.anythink.core.common.b.o.a().c("network_type")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                return "";
            }
            if (context == null) {
                return "-1";
            }
            try {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || !com.anythink.core.common.o.i.a("android.permission.ACCESS_NETWORK_STATE", context) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return "-1";
                }
                int i2 = 1;
                if (activeNetworkInfo.getType() == 1) {
                    return "-2";
                }
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager == null) {
                    return "-1";
                }
                int networkType = telephonyManager.getNetworkType();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                if (networkType != 20) {
                    switch (networkType) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i2 = 3;
                            break;
                        case 13:
                            i2 = 13;
                            break;
                        default:
                            i2 = -1;
                            break;
                    }
                } else {
                    i2 = 16;
                }
                sb.append(i2);
                return sb.toString();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return "-1";
            }
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.util.List<com.anythink.core.common.f.s> n() {
        return d;
    }

    public static java.lang.String o() {
        if (com.anythink.core.common.b.o.a().c("amazon_id") || !com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
            return "";
        }
        if (j == null) {
            j = com.anythink.core.common.o.r.b(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.t, "");
        }
        if (android.text.TextUtils.isEmpty(j) && !k) {
            try {
                k = true;
                java.lang.String string = android.provider.Settings.Secure.getString(com.anythink.core.common.b.o.a().f().getContentResolver(), "advertising_id");
                j = string;
                if (android.text.TextUtils.isEmpty(string)) {
                    j = "";
                } else {
                    com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.t, j);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return j;
    }

    public static java.lang.String o(android.content.Context context) {
        java.lang.String str = w;
        if (str != null) {
            if (str == null) {
                w = "";
            }
            return w;
        }
        try {
            java.lang.String str2 = context.getPackageManager().getPackageInfo("com.android.vending", 0).versionName;
            w = str2;
            if (str2 == null) {
                w = "";
            }
            return w;
        } catch (java.lang.Exception unused) {
            w = "";
            return "";
        }
    }

    public static int p() {
        if (!com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
            return -1;
        }
        if (l <= 0 && !m) {
            try {
                m = true;
                l = android.provider.Settings.Secure.getInt(com.anythink.core.common.b.o.a().f().getContentResolver(), "limit_ad_tracking") != 0 ? 2 : 1;
            } catch (java.lang.Throwable unused) {
                l = -1;
            }
        }
        return l;
    }

    public static java.lang.String p(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().b() == null) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(b)) {
            android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            b = java.lang.String.valueOf(displayMetrics.density);
        }
        return b;
    }

    public static void q(android.content.Context context) {
        if (com.anythink.core.common.b.o.a().c("ua")) {
            return;
        }
        try {
            if (com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f()).b()) {
                if (android.text.TextUtils.isEmpty(o)) {
                    o = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.f, "");
                }
                java.lang.String b2 = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.g, "");
                if (android.text.TextUtils.isEmpty(o) || !android.os.Build.VERSION.RELEASE.equals(b2)) {
                    if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
                        android.text.TextUtils.isEmpty(o);
                        return;
                    }
                    o = android.webkit.WebSettings.getDefaultUserAgent(context);
                    com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.f, o);
                    com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.g, android.os.Build.VERSION.RELEASE);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static int r() {
        return android.os.Build.VERSION.SDK_INT;
    }

    public static synchronized void r(android.content.Context context) {
        synchronized (com.anythink.core.common.o.e.class) {
            if (android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().x())) {
                com.anythink.core.api.IExHandler b2 = com.anythink.core.common.b.o.a().b();
                java.lang.String uniqueId = b2 != null ? b2.getUniqueId(context) : "";
                if (android.text.TextUtils.isEmpty(uniqueId)) {
                    uniqueId = s(context);
                }
                if (android.text.TextUtils.isEmpty(uniqueId) || java.util.regex.Pattern.matches("^[0-]+$", uniqueId)) {
                    uniqueId = d(context);
                }
                if (android.text.TextUtils.isEmpty(uniqueId)) {
                    uniqueId = java.util.UUID.randomUUID().toString();
                }
                com.anythink.core.common.b.o.a().l(com.anythink.core.common.o.g.a(uniqueId));
                com.anythink.core.common.n.c.a("", "3", "", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            }
        }
    }

    public static synchronized java.lang.String s(android.content.Context context) {
        synchronized (com.anythink.core.common.o.e.class) {
            if (com.anythink.core.common.b.o.a().c("gaid")) {
                return "";
            }
            java.util.concurrent.ExecutorService newFixedThreadPool = java.util.concurrent.Executors.newFixedThreadPool(2);
            java.lang.String[] strArr = new java.lang.String[1];
            newFixedThreadPool.submit(new com.anythink.core.common.o.e.AnonymousClass2(context, strArr, newFixedThreadPool));
            try {
                synchronized (newFixedThreadPool) {
                    newFixedThreadPool.wait(2000L);
                }
                newFixedThreadPool.shutdown();
                java.lang.String str = strArr[0];
                return str != null ? str : "";
            } catch (java.lang.Exception unused) {
                return "";
            }
        }
    }

    public static int t(android.content.Context context) {
        if (z == -1) {
            z = com.anythink.core.common.o.i.a(context, "com.tencent.mm") ? 1 : 0;
        }
        return z;
    }

    private static int u(android.content.Context context) {
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static int v(android.content.Context context) {
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private static int w(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null) {
            return -1;
        }
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || !com.anythink.core.common.o.i.a("android.permission.ACCESS_NETWORK_STATE", context) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            if (activeNetworkInfo.getType() == 1) {
                return -2;
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getNetworkType();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static void x(android.content.Context context) {
        if (d == null) {
            long longValue = com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "det_hw_time", (java.lang.Long) 0L).longValue();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            d = arrayList;
            arrayList.add(new com.anythink.core.common.f.s(context, longValue, "hw_ver", "com.huawei.appmarket"));
            d.add(new com.anythink.core.common.f.s(context, longValue, "hw_hms_ver", "com.huawei.hwid"));
            d.add(new com.anythink.core.common.f.s(context, longValue, "honor_ver", "com.huawei.appmarket"));
            com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "det_hw_time", java.lang.System.currentTimeMillis());
        }
    }
}
