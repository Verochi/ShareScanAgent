package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bm {
    public static java.lang.String A = "";
    public static boolean B = false;
    public static boolean C = false;
    public static long D = 0;
    public static int E = 0;
    public static java.lang.String F = null;
    public static java.lang.String G = "";
    public static boolean H = true;
    public static boolean I = false;
    public static java.lang.String J = "";
    public static boolean K = false;
    public static int L = -1;
    public static boolean M = false;
    public static int N = -1;
    public static boolean O = false;
    public static volatile com.amap.api.col.s.bm.b P = null;
    public static java.lang.String a = "";
    public static java.lang.String b = "";
    public static volatile boolean c = true;
    public static boolean d = false;
    public static java.lang.String e = "";
    public static java.lang.String f = null;
    public static com.amap.api.col.s.bm.a g = null;
    public static volatile boolean h = false;
    public static java.lang.String i = "";
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static java.lang.String m = "";
    public static java.lang.String n = "";
    public static boolean o = false;
    public static boolean p = false;
    public static java.lang.String q = "";
    public static boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    public static java.lang.String f109s = "";
    public static boolean t = false;
    public static java.lang.String u = "";
    public static java.lang.String v = "";
    public static java.lang.String w = "";
    public static int x = -1;
    public static java.lang.String y = "";
    public static boolean z;

    /* renamed from: com.amap.api.col.s.bm$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.col.s.ec {
        public final /* synthetic */ android.content.Context t;

        public AnonymousClass1(android.content.Context context) {
            this.t = context;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            try {
                java.util.Map<java.lang.String, java.lang.String> b = com.amap.api.col.s.bm.g.b();
                java.lang.String a = com.amap.api.col.s.bm.g.a(com.amap.api.col.s.bm.h(this.t), "", "", com.amap.api.col.s.bm.t(this.t));
                if (android.text.TextUtils.isEmpty(a)) {
                    return;
                }
                com.amap.api.col.s.cx.a();
                java.lang.String a2 = com.amap.api.col.s.bm.g.a(this.t, new java.lang.String(com.amap.api.col.s.cx.a(com.amap.api.col.s.bm.g.a(a.getBytes(), b)).a));
                if (android.text.TextUtils.isEmpty(a2)) {
                    return;
                }
                com.amap.api.col.s.bm.b = a2;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bm$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.amap.api.col.s.ec {
        public final /* synthetic */ android.content.Context t;

        public AnonymousClass2(android.content.Context context) {
            this.t = context;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            com.amap.api.col.s.bm.o(this.t);
            com.amap.api.col.s.bm.P();
        }
    }

    public interface a {
        com.amap.api.col.s.dd a(byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map);

        java.lang.String a();

        java.lang.String a(android.content.Context context, java.lang.String str);

        java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

        java.util.Map<java.lang.String, java.lang.String> b();
    }

    public static class b {
        public static android.content.Context a;
        public static android.content.BroadcastReceiver b;
        public static android.net.ConnectivityManager c;
        public static android.net.NetworkRequest d;
        public static android.net.ConnectivityManager.NetworkCallback e;

        /* renamed from: com.amap.api.col.s.bm$b$1, reason: invalid class name */
        public class AnonymousClass1 extends android.content.BroadcastReceiver {
            public AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(android.content.Context context, android.content.Intent intent) {
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                if (com.amap.api.col.s.bu.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    com.amap.api.col.s.bm.g();
                }
            }
        }

        /* renamed from: com.amap.api.col.s.bm$b$2, reason: invalid class name */
        public class AnonymousClass2 extends android.net.ConnectivityManager.NetworkCallback {
            public AnonymousClass2() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(android.net.Network network) {
                super.onAvailable(network);
                com.amap.api.col.s.bm.g();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(android.net.Network network) {
                super.onLost(network);
                com.amap.api.col.s.bm.g();
            }
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        public final void a(android.content.Context context) {
            if (android.os.Build.VERSION.SDK_INT < 24) {
                if (context == null || b != null) {
                    return;
                }
                b = new com.amap.api.col.s.bm.b.AnonymousClass1();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(com.amap.api.col.s.bu.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(b, intentFilter);
                return;
            }
            if (com.amap.api.col.s.bm.N(context, com.amap.api.col.s.bu.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && c == null) {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                c = connectivityManager;
                if (connectivityManager != null) {
                    d = new android.net.NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    com.amap.api.col.s.bm.b.AnonymousClass2 anonymousClass2 = new com.amap.api.col.s.bm.b.AnonymousClass2();
                    e = anonymousClass2;
                    c.registerNetworkCallback(d, anonymousClass2);
                    a = context;
                }
            }
        }
    }

    public static class c implements android.content.ServiceConnection {
        public static java.lang.String u;
        public android.content.Context n;
        public int t;

        public c(android.content.Context context, int i) {
            this.n = context;
            this.t = i;
        }

        public final java.lang.String a() {
            try {
                if (!android.text.TextUtils.isEmpty(u)) {
                    return u;
                }
                byte[] digest = java.security.MessageDigest.getInstance(com.amap.api.col.s.bu.c("IU0hBMQ")).digest(this.n.getPackageManager().getPackageInfo(this.n.getPackageName(), 64).signatures[0].toByteArray());
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                for (byte b : digest) {
                    stringBuffer.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                }
                java.lang.String stringBuffer2 = stringBuffer.toString();
                if (!android.text.TextUtils.isEmpty(stringBuffer2)) {
                    u = stringBuffer2;
                }
                return stringBuffer2;
            } catch (java.lang.Throwable unused) {
                return "";
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0050 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:3:0x0008, B:11:0x0050, B:16:0x0017, B:18:0x003a, B:19:0x0044), top: B:2:0x0008 }] */
        @Override // android.content.ServiceConnection
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            boolean z;
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                int i = this.t;
                if (i == 2) {
                    obtain.writeInterfaceToken(com.amap.api.col.s.bu.c("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                } else if (i == 4) {
                    obtain.writeInterfaceToken(com.amap.api.col.s.bu.c("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                } else {
                    if (i != 5) {
                        z = false;
                        if (z) {
                            iBinder.transact(1, obtain, obtain2, 0);
                            obtain2.readException();
                            java.lang.String unused = com.amap.api.col.s.bm.i = obtain2.readString();
                        }
                    }
                    obtain.writeInterfaceToken(com.amap.api.col.s.bu.c("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                    obtain.writeString(this.n.getPackageName());
                    obtain.writeString(a());
                    obtain.writeString(com.amap.api.col.s.bu.c("IT1VJRA"));
                }
                z = true;
                if (z) {
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.amap.api.col.s.cg.a(th, "oac", java.lang.String.valueOf(this.t));
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public static int A(android.content.Context context) {
        if (M) {
            return L;
        }
        I(context);
        if (context == null || !N(context, com.amap.api.col.s.bu.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return L;
        }
        android.net.ConnectivityManager B2 = B(context);
        if (B2 == null) {
            return L;
        }
        android.net.NetworkInfo activeNetworkInfo = B2.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            M = true;
            return L;
        }
        int type = activeNetworkInfo.getType();
        L = type;
        M = true;
        return type;
    }

    public static android.net.ConnectivityManager B(android.content.Context context) {
        return (android.net.ConnectivityManager) context.getSystemService("connectivity");
    }

    public static int C(android.content.Context context) {
        android.telephony.TelephonyManager D2;
        if (O) {
            return N;
        }
        I(context);
        if (N(context, com.amap.api.col.s.bu.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (D2 = D(context)) != null) {
            int networkType = D2.getNetworkType();
            N = networkType;
            O = true;
            return networkType;
        }
        return N;
    }

    public static android.telephony.TelephonyManager D(android.content.Context context) {
        return (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
    }

    public static java.lang.String E(android.content.Context context) {
        java.lang.String str;
        if (!c) {
            return "";
        }
        try {
            str = F(context);
        } catch (java.lang.Throwable unused) {
            str = null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            c = false;
            return "";
        }
        try {
            byte[] bytes = com.amap.api.col.s.bu.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new java.lang.String(com.amap.api.col.s.bn.a(com.amap.api.col.s.bu.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), com.amap.api.col.s.bn.b(str), bytes), "UTF-8");
        } catch (java.lang.Throwable unused2) {
            c = false;
            return "";
        }
    }

    public static java.lang.String F(android.content.Context context) {
        java.lang.String str;
        try {
            str = G(context);
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        return !android.text.TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(com.amap.api.col.s.bu.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(com.amap.api.col.s.bq.a(com.amap.api.col.s.bu.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    public static java.lang.String G(android.content.Context context) {
        java.io.RandomAccessFile randomAccessFile;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.String str;
        java.lang.String[] split;
        java.lang.String a2 = com.amap.api.col.s.bq.a(com.amap.api.col.s.bu.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        java.lang.String H2 = H(context);
        if (android.text.TextUtils.isEmpty(H2)) {
            return "";
        }
        java.io.File file = new java.io.File(H2 + java.io.File.separator + com.amap.api.col.s.bu.c("KYmFja3Vwcw"), com.amap.api.col.s.bu.c("MLmFkaXU"));
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
                            L(byteArrayOutputStream2);
                            L(randomAccessFile);
                            return "";
                        }
                    }
                    str = new java.lang.String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (java.lang.Throwable unused2) {
                }
            } catch (java.lang.Throwable unused3) {
                randomAccessFile = null;
            }
            if (!android.text.TextUtils.isEmpty(str) && str.contains(com.amap.api.col.s.bu.c("SIw")) && (split = str.split(com.amap.api.col.s.bu.c("SIw"))) != null && split.length == 2 && android.text.TextUtils.equals(a2, split[0])) {
                java.lang.String str2 = split[1];
                L(byteArrayOutputStream);
                L(randomAccessFile);
                return str2;
            }
            L(byteArrayOutputStream);
            L(randomAccessFile);
        }
        return "";
    }

    public static java.lang.String H(android.content.Context context) {
        try {
            android.os.storage.StorageManager storageManager = (android.os.storage.StorageManager) context.getSystemService("storage");
            java.lang.Class<?> cls = java.lang.Class.forName(com.amap.api.col.s.bu.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            java.lang.reflect.Method method = storageManager.getClass().getMethod(com.amap.api.col.s.bu.c("MZ2V0Vm9sdW1lTGlzdA"), new java.lang.Class[0]);
            java.lang.reflect.Method method2 = cls.getMethod(com.amap.api.col.s.bu.c("FZ2V0UGF0aA"), new java.lang.Class[0]);
            java.lang.reflect.Method method3 = cls.getMethod(com.amap.api.col.s.bu.c("DaXNSZW1vdmFibGU"), new java.lang.Class[0]);
            java.lang.Object invoke = method.invoke(storageManager, new java.lang.Object[0]);
            int length = java.lang.reflect.Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                java.lang.Object obj = java.lang.reflect.Array.get(invoke, i2);
                java.lang.String str = (java.lang.String) method2.invoke(obj, new java.lang.Object[0]);
                if (!((java.lang.Boolean) method3.invoke(obj, new java.lang.Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static synchronized com.amap.api.col.s.bm.b I(android.content.Context context) {
        synchronized (com.amap.api.col.s.bm.class) {
            if (P == null) {
                if (context == null) {
                    return null;
                }
                com.amap.api.col.s.bm.b bVar = new com.amap.api.col.s.bm.b();
                P = bVar;
                bVar.a(context.getApplicationContext());
            }
            return P;
        }
    }

    public static java.lang.String J(android.content.Context context, int i2) {
        try {
            android.content.Intent intent = new android.content.Intent();
            if (i2 == 2) {
                intent.setAction(com.amap.api.col.s.bu.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(com.amap.api.col.s.bu.c("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(com.amap.api.col.s.bu.c("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), com.amap.api.col.s.bu.c("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i2 != 5) {
                    j = true;
                    return i;
                }
                intent.setClassName(com.amap.api.col.s.bu.c("YY29tLmhleXRhcC5vcGVuaWQ"), com.amap.api.col.s.bu.c("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(com.amap.api.col.s.bu.c("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            com.amap.api.col.s.bm.c cVar = new com.amap.api.col.s.bm.c(context, i2);
            if (context.bindService(intent, cVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && android.text.TextUtils.isEmpty(i)) {
                    i3++;
                    java.lang.Thread.sleep(15L);
                }
                context.unbindService(cVar);
            }
            return i;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "oa", java.lang.String.valueOf(i2));
            j = true;
            return i;
        }
    }

    public static void L(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static boolean N(android.content.Context context, java.lang.String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static java.lang.String[] O() {
        return new java.lang.String[]{"", ""};
    }

    public static /* synthetic */ boolean P() {
        k = true;
        return true;
    }

    public static java.lang.String Q(android.content.Context context) {
        android.telephony.TelephonyManager D2;
        if (t) {
            return f109s;
        }
        try {
            I(context);
            D2 = D(context);
        } catch (java.lang.Throwable unused) {
        }
        if (D2 == null) {
            return f109s;
        }
        java.lang.String networkOperator = D2.getNetworkOperator();
        if (!android.text.TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f109s = networkOperator.substring(3);
            t = true;
            return f109s;
        }
        t = true;
        return f109s;
    }

    public static java.lang.String R(android.content.Context context) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        try {
            str = u;
        } catch (java.lang.Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return u;
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
        u = sb.toString();
        return u;
    }

    public static java.lang.String S(android.content.Context context) {
        try {
            return z(context);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String U(android.content.Context context) {
        try {
            java.lang.String b2 = com.amap.api.col.s.cm.b(context, "Alvin2", "UTDID2", "");
            return android.text.TextUtils.isEmpty(b2) ? com.amap.api.col.s.cm.b(context, "Alvin2", "UTDID", "") : b2;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String V(android.content.Context context) {
        java.io.FileInputStream fileInputStream = null;
        try {
            if (com.amap.api.col.s.bu.a(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(android.os.Environment.getExternalStorageState())) {
                java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                org.xmlpull.v1.XmlPullParser newPullParser = android.util.Xml.newPullParser();
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z2 = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z2 = false;
                            } else if (eventType == 4 && z2) {
                                java.lang.String text = newPullParser.getText();
                                try {
                                    fileInputStream2.close();
                                } catch (java.lang.Throwable unused) {
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
                    fileInputStream = fileInputStream2;
                } catch (java.lang.Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                        return "";
                    }
                    fileInputStream.close();
                    return "";
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (java.lang.Throwable unused3) {
        }
        try {
            fileInputStream.close();
            return "";
        } catch (java.lang.Throwable unused4) {
            return "";
        }
    }

    public static java.lang.String W(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(com.amap.api.col.s.bu.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            java.lang.Object invoke = cls.getMethod(com.amap.api.col.s.bu.c("MZ2V0T0FJRA"), android.content.Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                java.lang.String str = (java.lang.String) invoke;
                i = str;
                return str;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "oa", "xm");
            j = true;
        }
        return i;
    }

    public static java.lang.String a() {
        return f;
    }

    public static java.lang.String a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(b)) {
            return b;
        }
        if (context == null) {
            return "";
        }
        java.lang.String E2 = E(context);
        b = E2;
        if (!android.text.TextUtils.isEmpty(E2)) {
            return b;
        }
        if (c() == null || h) {
            return "";
        }
        h = true;
        com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.bm.AnonymousClass1(context));
        return "";
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            if (android.text.TextUtils.isEmpty(y) && !z) {
                android.telephony.TelephonyManager D2 = D(context);
                if (x == -1) {
                    java.lang.reflect.Method a2 = com.amap.api.col.s.bu.a(android.telephony.TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", (java.lang.Class<?>[]) new java.lang.Class[0]);
                    if (a2 != null) {
                        try {
                            x = ((java.lang.Integer) a2.invoke(D2, new java.lang.Object[0])).intValue();
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    x = 0;
                }
                java.lang.reflect.Method a3 = com.amap.api.col.s.bu.a(android.telephony.TelephonyManager.class, "MZ2V0SW1laQ=", (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.Integer.TYPE});
                if (a3 == null) {
                    x = 0;
                    z = true;
                    return "";
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (int i2 = 0; i2 < x; i2++) {
                    try {
                        sb.append((java.lang.String) a3.invoke(D2, java.lang.Integer.valueOf(i2)));
                        sb.append(str);
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                java.lang.String sb2 = sb.toString();
                if (sb2.length() == 0) {
                    x = 0;
                    z = true;
                    return "";
                }
                java.lang.String substring = sb2.substring(0, sb2.length() - 1);
                y = substring;
                z = true;
                return substring;
            }
            return y;
        } catch (java.lang.Throwable unused3) {
            return "";
        }
    }

    public static void a(com.amap.api.col.s.bm.a aVar) {
        if (g == null) {
            g = aVar;
        }
    }

    public static java.lang.String b() {
        try {
            if (!android.text.TextUtils.isEmpty(e)) {
                return e;
            }
            com.amap.api.col.s.bm.a aVar = g;
            return aVar == null ? "" : aVar.a();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            return z(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static com.amap.api.col.s.bm.a c() {
        return g;
    }

    public static java.lang.String c(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            java.lang.String t2 = t(context);
            if (t2 != null && t2.length() >= 5) {
                return t2.substring(3, 5);
            }
            return "";
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int d(android.content.Context context) {
        try {
            return C(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int e(android.content.Context context) {
        try {
            return A(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static long e() {
        long j2 = D;
        if (j2 != 0) {
            return j2;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getRootDirectory().getAbsolutePath());
            android.os.StatFs statFs2 = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getAbsolutePath());
            D = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576);
        } catch (java.lang.Throwable unused) {
        }
        return D;
    }

    public static java.lang.String f() {
        if (!android.text.TextUtils.isEmpty(F)) {
            return F;
        }
        java.lang.String property = java.lang.System.getProperty("os.arch");
        F = property;
        return property;
    }

    public static java.lang.String f(android.content.Context context) {
        try {
            return y(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static java.lang.String g(android.content.Context context) {
        if (j) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(i) && !k) {
            if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.bm.AnonymousClass2(context));
                return i;
            }
            k = true;
            return o(context);
        }
        return i;
    }

    public static void g() {
        L = -1;
        M = false;
        N = -1;
        O = false;
        J = "";
        K = false;
        f109s = "";
        t = false;
    }

    public static java.lang.String h(android.content.Context context) {
        java.lang.String str;
        if (l) {
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
        if (N(context, com.amap.api.col.s.bu.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            a = android.provider.Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!android.text.TextUtils.isEmpty(a)) {
            l = true;
            return a;
        }
        try {
            java.lang.String U = U(context);
            a = U;
            if (!android.text.TextUtils.isEmpty(U)) {
                l = true;
                return a;
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            a = V(context);
            l = true;
        } catch (java.lang.Throwable unused3) {
        }
        java.lang.String str3 = a;
        return str3 == null ? "" : str3;
    }

    public static java.lang.String i(android.content.Context context) {
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(n) && !o) {
            if (!N(context, com.amap.api.col.s.bu.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return "";
            }
            if (i2 >= 26) {
                java.lang.String str = (java.lang.String) com.amap.api.col.s.bu.a(android.os.Build.class, "MZ2V0U2VyaWFs", (java.lang.Class<?>[]) new java.lang.Class[0]).invoke(android.os.Build.class, new java.lang.Object[0]);
                o = true;
                return str;
            }
            n = android.os.Build.SERIAL;
            o = true;
            java.lang.String str2 = n;
            return str2 == null ? "" : str2;
        }
        return n;
    }

    public static java.lang.String j(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(m) && !p) {
            try {
                java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.amap.api.col.s.bu.c(new java.lang.String(com.amap.api.col.s.cd.a(13))));
                m = string;
                p = true;
                return string == null ? "" : string;
            } catch (java.lang.Throwable unused) {
                return m;
            }
        }
        return m;
    }

    public static java.lang.String k(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30) {
            try {
                java.lang.String str = q;
                if ((str == null || "".equals(str)) && !r && N(context, com.amap.api.col.s.bu.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                    if (wifiManager == null) {
                        return "";
                    }
                    q = wifiManager.getConnectionInfo().getMacAddress();
                    if (com.amap.api.col.s.bu.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(q) || com.amap.api.col.s.bu.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(q)) {
                        q = v(context);
                    }
                    r = true;
                }
                return q;
            } catch (java.lang.Throwable unused) {
            }
        }
        return q;
    }

    public static java.lang.String l(android.content.Context context) {
        try {
            android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse(com.amap.api.col.s.bu.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        }
                        if (com.amap.api.col.s.bu.c("IdmFsdWU").equals(query.getColumnName(i2))) {
                            i = query.getString(i2);
                            break;
                        }
                        i2++;
                    }
                }
                query.close();
            }
        } catch (java.lang.Throwable th) {
            j = true;
            com.amap.api.col.s.cg.a(th, "oa", com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        }
        return i;
    }

    public static int m(android.content.Context context) {
        try {
            return C(context);
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static int n(android.content.Context context) {
        try {
            return A(context);
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static java.lang.String o(android.content.Context context) {
        java.lang.String c2 = com.amap.api.col.s.bu.c("IeGlhb21p");
        java.lang.String str = android.os.Build.MANUFACTURER;
        if (c2.equalsIgnoreCase(str)) {
            return W(context);
        }
        if (com.amap.api.col.s.bu.c("Idml2bw").equalsIgnoreCase(str)) {
            return l(context);
        }
        if (com.amap.api.col.s.bu.c("IaHVhd2Vp").equalsIgnoreCase(str)) {
            return J(context, 2);
        }
        if (com.amap.api.col.s.bu.c("Mc2Ftc3VuZw").equalsIgnoreCase(str)) {
            return J(context, 4);
        }
        if (com.amap.api.col.s.bu.c("IT1BQTw").equalsIgnoreCase(str) || com.amap.api.col.s.bu.c("MT25lUGx1cw").equalsIgnoreCase(str)) {
            return J(context, 5);
        }
        j = true;
        return i;
    }

    public static java.lang.String p(android.content.Context context) {
        android.net.ConnectivityManager B2;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            return (!N(context, com.amap.api.col.s.bu.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (B2 = B(context)) == null || (activeNetworkInfo = B2.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String q(android.content.Context context) {
        try {
            java.lang.String r2 = r(context);
            try {
                if (android.text.TextUtils.isEmpty(r2)) {
                    r2 = a(context);
                }
                if (android.text.TextUtils.isEmpty(r2)) {
                    r2 = h(context);
                }
                if (android.text.TextUtils.isEmpty(r2)) {
                    r2 = g(context);
                }
                if (android.text.TextUtils.isEmpty(r2)) {
                    r2 = j(context);
                }
                return android.text.TextUtils.isEmpty(r2) ? w(context) : r2;
            } catch (java.lang.Throwable unused) {
                return r2;
            }
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    public static java.lang.String r(android.content.Context context) {
        int i2;
        try {
            i2 = android.os.Build.VERSION.SDK_INT;
        } catch (java.lang.Throwable unused) {
        }
        if (i2 >= 29) {
            return "";
        }
        java.lang.String str = v;
        if ((str == null || "".equals(str)) && !B && N(context, com.amap.api.col.s.bu.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            android.telephony.TelephonyManager D2 = D(context);
            if (D2 == null) {
                return "";
            }
            java.lang.reflect.Method a2 = com.amap.api.col.s.bu.a(D2.getClass(), "QZ2V0RGV2aWNlSWQ", (java.lang.Class<?>[]) new java.lang.Class[0]);
            if (i2 >= 26) {
                a2 = com.amap.api.col.s.bu.a(D2.getClass(), "QZ2V0SW1laQ==", (java.lang.Class<?>[]) new java.lang.Class[0]);
            }
            if (a2 != null) {
                v = (java.lang.String) a2.invoke(D2, new java.lang.Object[0]);
            }
            if (v == null) {
                v = "";
            }
            B = true;
            return v;
        }
        return v;
    }

    public static java.lang.String s(android.content.Context context) {
        java.lang.String str;
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        try {
            str = w;
        } catch (java.lang.Throwable unused) {
        }
        if ((str == null || "".equals(str)) && N(context, com.amap.api.col.s.bu.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            android.telephony.TelephonyManager D2 = D(context);
            if (D2 == null) {
                return "";
            }
            if (C) {
                return w;
            }
            if (i2 >= 26) {
                java.lang.reflect.Method a2 = com.amap.api.col.s.bu.a(D2.getClass(), "QZ2V0TWVpZA==", (java.lang.Class<?>[]) new java.lang.Class[0]);
                if (a2 != null) {
                    w = (java.lang.String) a2.invoke(D2, new java.lang.Object[0]);
                }
                if (w == null) {
                    w = "";
                }
                C = true;
            }
            return w;
        }
        return w;
    }

    public static java.lang.String t(android.content.Context context) {
        try {
            return y(context);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static int u(android.content.Context context) {
        int i2 = E;
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
        E = i3;
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:3:0x0002, B:4:0x000e, B:6:0x0014, B:9:0x0026, B:11:0x002c, B:18:0x003e, B:21:0x0048, B:23:0x005a, B:25:0x005f, B:28:0x006a, B:30:0x0070, B:31:0x0078, B:34:0x0037), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String v(android.content.Context context) {
        byte[] hardwareAddress;
        try {
            for (java.net.NetworkInterface networkInterface : java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    if (android.os.Build.VERSION.SDK_INT >= 30 && context.getApplicationInfo().targetSdkVersion >= 30) {
                        hardwareAddress = null;
                        if (hardwareAddress != null) {
                            return "";
                        }
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b2 : hardwareAddress) {
                            java.lang.String upperCase = java.lang.Integer.toHexString(b2 & 255).toUpperCase();
                            if (upperCase.length() == 1) {
                                sb.append("0");
                            }
                            sb.append(upperCase);
                            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                    hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress != null) {
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return "";
    }

    public static java.lang.String w(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(A)) {
            return A;
        }
        try {
            java.lang.String b2 = com.amap.api.col.s.cm.b(context, "open_common", "a1", "");
            if (android.text.TextUtils.isEmpty(b2)) {
                A = "amap" + java.util.UUID.randomUUID().toString().replace("_", "").toLowerCase();
                android.content.SharedPreferences.Editor a2 = com.amap.api.col.s.cm.a(context, "open_common");
                com.amap.api.col.s.cm.a(a2, "a1", com.amap.api.col.s.bu.b(A));
                com.amap.api.col.s.cm.a(a2);
            } else {
                A = com.amap.api.col.s.bu.c(b2);
            }
        } catch (java.lang.Throwable unused) {
        }
        return A;
    }

    public static boolean x(android.content.Context context) {
        int simState;
        android.telephony.TelephonyManager D2 = D(context);
        return (D2 == null || (simState = D2.getSimState()) == 0 || simState == 1) ? false : true;
    }

    public static java.lang.String y(android.content.Context context) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        boolean x2 = x(context);
        if (H != x2) {
            if (x2) {
                G = "";
                I = false;
            }
            H = x2;
        }
        java.lang.String str = G;
        if ((str == null || "".equals(str)) && !I) {
            if (!H) {
                return "";
            }
            if (!N(context, com.amap.api.col.s.bu.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return G;
            }
            android.telephony.TelephonyManager D2 = D(context);
            if (D2 == null) {
                return "";
            }
            java.lang.reflect.Method a2 = com.amap.api.col.s.bu.a(D2.getClass(), "UZ2V0U3Vic2NyaWJlcklk", (java.lang.Class<?>[]) new java.lang.Class[0]);
            if (a2 != null) {
                G = (java.lang.String) a2.invoke(D2, new java.lang.Object[0]);
            }
            if (G == null) {
                G = "";
            }
            I = true;
            return G;
        }
        return G;
    }

    public static java.lang.String z(android.content.Context context) {
        android.telephony.TelephonyManager D2;
        if (K) {
            return J;
        }
        I(context);
        if (N(context, com.amap.api.col.s.bu.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (D2 = D(context)) != null) {
            java.lang.String simOperatorName = D2.getSimOperatorName();
            J = simOperatorName;
            if (android.text.TextUtils.isEmpty(simOperatorName)) {
                J = D2.getNetworkOperatorName();
            }
            K = true;
            return J;
        }
        return J;
    }
}
