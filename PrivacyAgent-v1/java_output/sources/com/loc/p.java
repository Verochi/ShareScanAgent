package com.loc;

/* loaded from: classes23.dex */
public final class p {
    private static boolean A = false;
    private static java.lang.String B = "";
    private static boolean C = false;
    private static java.lang.String D = "";
    private static java.lang.String E = "";
    private static java.lang.String F = "";
    private static boolean G = false;
    private static boolean H = false;
    private static java.lang.String I = "";
    private static boolean J = false;
    private static boolean K = false;
    private static long L = 0;
    private static int M = 0;
    private static java.lang.String N = null;
    private static java.lang.String O = "";
    private static boolean P = true;
    private static boolean Q = false;
    private static java.lang.String R = "";
    private static boolean S = false;
    private static int T = -1;
    private static boolean U = false;
    private static int V = -1;
    private static boolean W = false;
    private static volatile com.loc.p.b X = null;
    static java.lang.String a = "";
    static java.lang.String b = "";
    static volatile boolean c = true;
    public static boolean d = false;
    static java.lang.String e = "";
    static boolean f = false;
    public static com.loc.p.a g = null;
    static int h = -1;
    static java.lang.String i = "";
    static java.lang.String j = "";
    private static java.lang.String k = null;
    private static boolean l = false;
    private static java.lang.String m = "";
    private static volatile boolean n = false;
    private static java.lang.String o = "";
    private static boolean p = false;
    private static boolean q = true;
    private static java.lang.String r = null;

    /* renamed from: s, reason: collision with root package name */
    private static android.os.IBinder f417s = null;
    private static boolean t = false;
    private static boolean u = false;
    private static java.lang.String v = "";
    private static java.lang.String w = "";
    private static boolean x = false;
    private static boolean y = false;
    private static java.lang.String z = "";

    /* renamed from: com.loc.p$1, reason: invalid class name */
    public class AnonymousClass1 extends com.loc.cu {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.loc.cu
        public final void a() {
            try {
                java.util.Map<java.lang.String, java.lang.String> b = com.loc.p.g.b();
                java.lang.String a = com.loc.p.g.a(com.loc.p.f(this.a), "", "", com.loc.p.n());
                if (android.text.TextUtils.isEmpty(a)) {
                    return;
                }
                com.loc.bp.a();
                java.lang.String a2 = com.loc.p.g.a(this.a, new java.lang.String(com.loc.bp.a(com.loc.p.g.a(a.getBytes(), b)).a));
                if (android.text.TextUtils.isEmpty(a2)) {
                    return;
                }
                com.loc.p.b = a2;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.loc.p$2, reason: invalid class name */
    public class AnonymousClass2 extends com.loc.cu {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // com.loc.cu
        public final void a() {
            com.loc.p.A(this.a);
            com.loc.p.r();
        }
    }

    public interface a {
        com.loc.bu a(byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map);

        java.lang.String a();

        java.lang.String a(android.content.Context context, java.lang.String str);

        java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

        java.util.Map<java.lang.String, java.lang.String> b();
    }

    public static class b {
        private static android.content.Context a;
        private static android.content.BroadcastReceiver b;
        private static android.net.ConnectivityManager c;
        private static android.net.NetworkRequest d;
        private static android.net.ConnectivityManager.NetworkCallback e;

        /* renamed from: com.loc.p$b$1, reason: invalid class name */
        public class AnonymousClass1 extends android.content.BroadcastReceiver {
            public AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(android.content.Context context, android.content.Intent intent) {
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                if (com.loc.y.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    com.loc.p.q();
                }
            }
        }

        /* renamed from: com.loc.p$b$2, reason: invalid class name */
        public class AnonymousClass2 extends android.net.ConnectivityManager.NetworkCallback {
            public AnonymousClass2() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(android.net.Network network) {
                super.onAvailable(network);
                com.loc.p.q();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(android.net.Network network) {
                super.onLost(network);
                com.loc.p.q();
            }
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        public final void a(android.content.Context context) {
            if (android.os.Build.VERSION.SDK_INT < 24) {
                if (context == null || b != null) {
                    return;
                }
                b = new com.loc.p.b.AnonymousClass1();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(com.loc.y.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(b, intentFilter);
                return;
            }
            if (com.loc.p.b(context, com.loc.y.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && c == null) {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                c = connectivityManager;
                if (connectivityManager != null) {
                    d = new android.net.NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    com.loc.p.b.AnonymousClass2 anonymousClass2 = new com.loc.p.b.AnonymousClass2();
                    e = anonymousClass2;
                    c.registerNetworkCallback(d, anonymousClass2);
                    a = context;
                }
            }
        }
    }

    public static class c implements android.content.ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            android.os.IBinder unused = com.loc.p.f417s = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String A(android.content.Context context) {
        java.lang.String c2 = com.loc.y.c("IeGlhb21p");
        java.lang.String str = android.os.Build.MANUFACTURER;
        if (!c2.equalsIgnoreCase(str)) {
            java.lang.String c3 = com.loc.y.c("IeGlhb21p");
            java.lang.String str2 = android.os.Build.BRAND;
            if (!c3.equalsIgnoreCase(str2) && !com.loc.y.c("IUkVETUk=").equalsIgnoreCase(str) && !com.loc.y.c("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (com.loc.y.c("Idml2bw").equalsIgnoreCase(str) || com.loc.y.c("Idml2bw").equalsIgnoreCase(str2)) {
                    return z(context);
                }
                if (com.loc.y.c("IaHVhd2Vp").equalsIgnoreCase(str) || com.loc.y.c("IaHVhd2Vp").equalsIgnoreCase(str2) || com.loc.y.c("ISE9OT1I=").equalsIgnoreCase(str)) {
                    return a(context, 2);
                }
                if (com.loc.y.c("Mc2Ftc3VuZw").equalsIgnoreCase(str) || com.loc.y.c("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                    return a(context, 4);
                }
                if (com.loc.y.c("IT1BQTw").equalsIgnoreCase(str) || com.loc.y.c("IT1BQTw").equalsIgnoreCase(str2) || com.loc.y.c("MT25lUGx1cw").equalsIgnoreCase(str) || com.loc.y.c("MT25lUGx1cw").equalsIgnoreCase(str2) || com.loc.y.c("IUkVBTE1F").equalsIgnoreCase(str2)) {
                    return a(context, 5);
                }
                p = true;
                return o;
            }
        }
        return y(context);
    }

    private static java.lang.String B(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(I)) {
            return I;
        }
        try {
            java.lang.String b2 = com.loc.be.b(context, "open_common", "a1", "");
            if (android.text.TextUtils.isEmpty(b2)) {
                I = "amap" + java.util.UUID.randomUUID().toString().replace("_", "").toLowerCase();
                android.content.SharedPreferences.Editor a2 = com.loc.be.a(context, "open_common");
                com.loc.be.a(a2, "a1", com.loc.y.b(I));
                com.loc.be.a(a2);
            } else {
                I = com.loc.y.c(b2);
            }
            return I;
        } catch (java.lang.Throwable unused) {
            return I;
        }
    }

    private static java.lang.String C(android.content.Context context) {
        if (S) {
            return R;
        }
        L(context);
        android.telephony.TelephonyManager G2 = G(context);
        if (G2 == null) {
            return R;
        }
        java.lang.String simOperatorName = G2.getSimOperatorName();
        R = simOperatorName;
        if (android.text.TextUtils.isEmpty(simOperatorName)) {
            R = G2.getNetworkOperatorName();
        }
        S = true;
        return R;
    }

    private static int D(android.content.Context context) {
        if (U) {
            return T;
        }
        L(context);
        if (context == null || !b(context, com.loc.y.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return T;
        }
        android.net.ConnectivityManager E2 = E(context);
        if (E2 == null) {
            return T;
        }
        android.net.NetworkInfo activeNetworkInfo = E2.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            U = true;
            return T;
        }
        int type = activeNetworkInfo.getType();
        T = type;
        U = true;
        return type;
    }

    private static android.net.ConnectivityManager E(android.content.Context context) {
        return (android.net.ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int F(android.content.Context context) {
        android.net.ConnectivityManager E2;
        if (W) {
            return V;
        }
        L(context);
        if (b(context, com.loc.y.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (E2 = E(context)) != null) {
            android.net.NetworkInfo activeNetworkInfo = E2.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                V = activeNetworkInfo.getSubtype();
                W = true;
            }
            return V;
        }
        return V;
    }

    private static android.telephony.TelephonyManager G(android.content.Context context) {
        return (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
    }

    private static java.lang.String H(android.content.Context context) {
        java.lang.String str;
        if (!c) {
            return "";
        }
        try {
            str = I(context);
        } catch (java.lang.Throwable unused) {
            str = null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            c = false;
            return "";
        }
        try {
            byte[] bytes = com.loc.y.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new java.lang.String(com.loc.q.a(com.loc.y.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), com.loc.q.b(str), bytes), "UTF-8");
        } catch (java.lang.Throwable unused2) {
            c = false;
            return "";
        }
    }

    private static java.lang.String I(android.content.Context context) {
        java.lang.String str;
        try {
            str = J(context);
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        return !android.text.TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(com.loc.y.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(com.loc.t.a(com.loc.y.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static java.lang.String J(android.content.Context context) {
        java.io.RandomAccessFile randomAccessFile;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.String str;
        java.lang.String[] split;
        java.lang.String a2 = com.loc.t.a(com.loc.y.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        java.lang.String K2 = K(context);
        if (android.text.TextUtils.isEmpty(K2)) {
            return "";
        }
        java.io.File file = new java.io.File(K2 + java.io.File.separator + com.loc.y.c("KYmFja3Vwcw"), com.loc.y.c("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                randomAccessFile = new java.io.RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = randomAccessFile.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (java.lang.Throwable unused) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            a(byteArrayOutputStream2);
                            a(randomAccessFile);
                            return "";
                        }
                    }
                    str = new java.lang.String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (java.lang.Throwable unused2) {
                }
            } catch (java.lang.Throwable unused3) {
                randomAccessFile = null;
            }
            if (!android.text.TextUtils.isEmpty(str) && str.contains(com.loc.y.c("SIw")) && (split = str.split(com.loc.y.c("SIw"))) != null && split.length == 2 && android.text.TextUtils.equals(a2, split[0])) {
                java.lang.String str2 = split[1];
                a(byteArrayOutputStream);
                a(randomAccessFile);
                return str2;
            }
            a(byteArrayOutputStream);
            a(randomAccessFile);
        }
        return "";
    }

    private static java.lang.String K(android.content.Context context) {
        try {
            java.io.File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static synchronized com.loc.p.b L(android.content.Context context) {
        synchronized (com.loc.p.class) {
            if (X == null) {
                if (context == null) {
                    return null;
                }
                com.loc.p.b bVar = new com.loc.p.b();
                X = bVar;
                bVar.a(context.getApplicationContext());
            }
            return X;
        }
    }

    public static java.lang.String a() {
        return k;
    }

    public static java.lang.String a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        if (context == null) {
            return "";
        }
        java.lang.String H2 = H(context);
        b = H2;
        if (!android.text.TextUtils.isEmpty(H2)) {
            return b;
        }
        if (c() == null || n) {
            return "";
        }
        n = true;
        com.loc.ct.a().b(new com.loc.p.AnonymousClass1(context));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String a(android.content.Context context, int i2) {
        java.lang.String c2;
        boolean z2;
        try {
            android.content.Intent intent = new android.content.Intent();
            if (i2 == 2) {
                intent.setAction(com.loc.y.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(com.loc.y.c("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(com.loc.y.c("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), com.loc.y.c("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i2 != 5) {
                    p = true;
                    return o;
                }
                intent.setClassName(com.loc.y.c("YY29tLmhleXRhcC5vcGVuaWQ"), com.loc.y.c("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(com.loc.y.c("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            com.loc.p.c cVar = new com.loc.p.c();
            if (context.bindService(intent, cVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && android.text.TextUtils.isEmpty(o)) {
                    i3++;
                    if (f417s != null) {
                        android.os.Parcel obtain = android.os.Parcel.obtain();
                        android.os.Parcel obtain2 = android.os.Parcel.obtain();
                        if (i2 == 2) {
                            c2 = com.loc.y.c("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U");
                        } else if (i2 == 4) {
                            c2 = com.loc.y.c("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ");
                        } else if (i2 != 5) {
                            z2 = false;
                            if (z2) {
                                try {
                                    f417s.transact(1, obtain, obtain2, 0);
                                    obtain2.readException();
                                    o = obtain2.readString();
                                } finally {
                                    try {
                                    } catch (java.lang.Throwable th) {
                                    }
                                }
                            }
                            obtain2.recycle();
                            obtain.recycle();
                        } else {
                            obtain.writeInterfaceToken(com.loc.y.c("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                            obtain.writeString(context.getPackageName());
                            obtain.writeString(x(context));
                            obtain.writeString(com.loc.y.c("IT1VJRA"));
                            z2 = true;
                            if (z2) {
                            }
                            obtain2.recycle();
                            obtain.recycle();
                        }
                        obtain.writeInterfaceToken(c2);
                        z2 = true;
                        if (z2) {
                        }
                        obtain2.recycle();
                        obtain.recycle();
                    }
                    java.lang.Thread.sleep(15L);
                }
                context.unbindService(cVar);
                f417s = null;
            }
            return o;
        } catch (java.lang.Throwable th2) {
            com.loc.at.a(th2, "oa", java.lang.String.valueOf(i2));
            p = true;
            return o;
        }
    }

    public static void a(com.loc.p.a aVar) {
        if (g == null) {
            g = aVar;
        }
    }

    private static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(java.lang.String str) {
        k = str;
    }

    public static void a(boolean z2) {
        q = z2;
    }

    public static java.lang.String b() {
        try {
            if (!android.text.TextUtils.isEmpty(e)) {
                return e;
            }
            com.loc.p.a aVar = g;
            return aVar == null ? "" : aVar.a();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            return C(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(android.content.Context context, java.lang.String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static int c(android.content.Context context) {
        try {
            return F(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static com.loc.p.a c() {
        return g;
    }

    public static int d(android.content.Context context) {
        try {
            return D(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static java.lang.String d() {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            java.lang.String n2 = n();
            return n2.length() < 5 ? "" : n2.substring(3, 5);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static java.lang.String e() {
        return "";
    }

    public static java.lang.String e(android.content.Context context) {
        if (!q || p) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(o) && !t) {
            if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                com.loc.ct.a().b(new com.loc.p.AnonymousClass2(context));
                return o;
            }
            t = true;
            return A(context);
        }
        return o;
    }

    public static java.lang.String f() {
        return "";
    }

    public static java.lang.String f(android.content.Context context) {
        java.lang.String str;
        if (u) {
            java.lang.String str2 = a;
            return str2 == null ? "" : str2;
        }
        try {
            str = a;
        } catch (java.lang.Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return a;
        }
        if (b(context, com.loc.y.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            a = android.provider.Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!android.text.TextUtils.isEmpty(a)) {
            u = true;
            return a;
        }
        try {
            java.lang.String v2 = v(context);
            a = v2;
            if (!android.text.TextUtils.isEmpty(v2)) {
                u = true;
                return a;
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            a = w(context);
            u = true;
        } catch (java.lang.Throwable unused3) {
        }
        java.lang.String str3 = a;
        return str3 == null ? "" : str3;
    }

    public static java.lang.String g() {
        return "";
    }

    public static java.lang.String g(android.content.Context context) {
        try {
            android.telephony.TelephonyManager G2 = G(context);
            if (G2 == null) {
                return "";
            }
            java.lang.String networkOperator = G2.getNetworkOperator();
            if (!android.text.TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String h() {
        return z;
    }

    public static java.lang.String h(android.content.Context context) {
        android.telephony.TelephonyManager G2;
        if (C) {
            return B;
        }
        try {
            L(context);
            G2 = G(context);
        } catch (java.lang.Throwable unused) {
        }
        if (G2 == null) {
            return B;
        }
        java.lang.String networkOperator = G2.getNetworkOperator();
        if (!android.text.TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            B = networkOperator.substring(3);
            C = true;
            return B;
        }
        C = true;
        return B;
    }

    public static int i(android.content.Context context) {
        try {
            return F(context);
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static java.lang.String[] i() {
        return new java.lang.String[]{"", ""};
    }

    public static int j(android.content.Context context) {
        try {
            return D(context);
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static java.lang.String j() {
        return i;
    }

    public static android.net.NetworkInfo k(android.content.Context context) {
        android.net.ConnectivityManager E2;
        if (b(context, com.loc.y.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (E2 = E(context)) != null) {
            return E2.getActiveNetworkInfo();
        }
        return null;
    }

    public static java.lang.String k() {
        return E;
    }

    public static java.lang.String l(android.content.Context context) {
        try {
            android.net.NetworkInfo k2 = k(context);
            if (k2 == null) {
                return null;
            }
            return k2.getExtraInfo();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static void l() {
        try {
            com.loc.as.a();
        } catch (java.lang.Throwable unused) {
        }
    }

    public static java.lang.String m() {
        return "";
    }

    public static java.lang.String m(android.content.Context context) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        try {
            str = D;
        } catch (java.lang.Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return D;
        }
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (i3 > i2) {
            sb = new java.lang.StringBuilder();
            sb.append(i2);
            sb.append("*");
            sb.append(i3);
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(i3);
            sb.append("*");
            sb.append(i2);
        }
        D = sb.toString();
        return D;
    }

    public static java.lang.String n() {
        return "";
    }

    public static java.lang.String n(android.content.Context context) {
        try {
            if (!b(context, com.loc.y.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return O;
            }
            android.telephony.TelephonyManager G2 = G(context);
            return G2 == null ? "" : G2.getNetworkOperatorName();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static long o() {
        long j2 = L;
        if (j2 != 0) {
            return j2;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getRootDirectory().getAbsolutePath());
            android.os.StatFs statFs2 = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getAbsolutePath());
            L = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576);
        } catch (java.lang.Throwable unused) {
        }
        return L;
    }

    public static java.lang.String o(android.content.Context context) {
        android.net.ConnectivityManager E2;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            return (!b(context, com.loc.y.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (E2 = E(context)) == null || (activeNetworkInfo = E2.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String p() {
        if (!android.text.TextUtils.isEmpty(N)) {
            return N;
        }
        java.lang.String property = java.lang.System.getProperty("os.arch");
        N = property;
        return property;
    }

    public static java.lang.String p(android.content.Context context) {
        try {
            java.lang.String k2 = k();
            try {
                if (android.text.TextUtils.isEmpty(k2)) {
                    k2 = a(context);
                }
                if (android.text.TextUtils.isEmpty(k2)) {
                    k2 = f(context);
                }
                if (android.text.TextUtils.isEmpty(k2)) {
                    k2 = e(context);
                }
                if (android.text.TextUtils.isEmpty(k2)) {
                    k2 = g();
                }
                return android.text.TextUtils.isEmpty(k2) ? B(context) : k2;
            } catch (java.lang.Throwable unused) {
                return k2;
            }
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    public static java.lang.String q(android.content.Context context) {
        return k() + "#" + a(context) + "#" + p(context);
    }

    public static void q() {
        T = -1;
        U = false;
        V = -1;
        W = false;
        R = "";
        S = false;
        B = "";
        C = false;
    }

    public static int r(android.content.Context context) {
        int i2 = M;
        if (i2 != 0) {
            return i2;
        }
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0;
        }
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i3 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        M = i3;
        return i3;
    }

    public static /* synthetic */ boolean r() {
        t = true;
        return true;
    }

    public static java.lang.String s(android.content.Context context) {
        try {
            return C(context);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String t(android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(m)) {
                m = com.loc.af.a(context);
            }
        } catch (java.lang.Throwable unused) {
        }
        return m;
    }

    private static java.lang.String v(android.content.Context context) {
        try {
            java.lang.String b2 = com.loc.be.b(context, "Alvin2", "UTDID2", "");
            return android.text.TextUtils.isEmpty(b2) ? com.loc.be.b(context, "Alvin2", "UTDID", "") : b2;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static java.lang.String w(android.content.Context context) {
        java.io.FileInputStream fileInputStream;
        org.xmlpull.v1.XmlPullParser newPullParser;
        int eventType;
        try {
            java.io.File file = new java.io.File(context.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
            newPullParser = android.util.Xml.newPullParser();
            fileInputStream = new java.io.FileInputStream(file);
        } catch (java.lang.Throwable unused) {
            fileInputStream = null;
        }
        try {
            newPullParser.setInput(fileInputStream, "utf-8");
            boolean z2 = false;
            for (eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        z2 = false;
                    } else if (eventType == 4 && z2) {
                        java.lang.String text = newPullParser.getText();
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Throwable unused2) {
                        }
                        return text;
                    }
                } else if (newPullParser.getAttributeCount() > 0) {
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i2 = 0; i2 < attributeCount; i2++) {
                        java.lang.String attributeValue = newPullParser.getAttributeValue(i2);
                        if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                            z2 = true;
                        }
                    }
                }
            }
        } catch (java.lang.Throwable unused3) {
            if (fileInputStream == null) {
                return "";
            }
            fileInputStream.close();
            return "";
        }
        try {
            fileInputStream.close();
            return "";
        } catch (java.lang.Throwable unused4) {
            return "";
        }
    }

    private static java.lang.String x(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(r)) {
                return r;
            }
            byte[] digest = java.security.MessageDigest.getInstance(com.loc.y.c("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b2 : digest) {
                stringBuffer.append(java.lang.Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            java.lang.String stringBuffer2 = stringBuffer.toString();
            if (!android.text.TextUtils.isEmpty(stringBuffer2)) {
                r = stringBuffer2;
            }
            return stringBuffer2;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static java.lang.String y(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(com.loc.y.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            java.lang.Object invoke = cls.getMethod(com.loc.y.c("MZ2V0T0FJRA"), android.content.Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                java.lang.String str = (java.lang.String) invoke;
                o = str;
                return str;
            }
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "oa", "xm");
            p = true;
        }
        return o;
    }

    private static java.lang.String z(android.content.Context context) {
        try {
            android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse(com.loc.y.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        }
                        if (com.loc.y.c("IdmFsdWU").equals(query.getColumnName(i2))) {
                            o = query.getString(i2);
                            break;
                        }
                        i2++;
                    }
                }
                query.close();
            }
        } catch (java.lang.Throwable th) {
            p = true;
            com.loc.at.a(th, "oa", com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        }
        return o;
    }
}
