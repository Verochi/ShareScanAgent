package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ez {
    private static java.lang.String A = "";
    private static java.lang.String B = "";
    private static boolean C = false;
    private static boolean D = false;
    private static java.lang.String E = "";
    private static boolean F = false;
    private static boolean G = false;
    private static long H = 0;
    private static int I = 0;
    private static java.lang.String J = null;
    private static java.lang.String K = "";
    private static boolean L = true;
    private static boolean M = false;
    private static java.lang.String N = "";
    private static boolean O = false;
    private static int P = -1;
    private static boolean Q = false;
    private static int R = -1;
    private static boolean S = false;
    private static volatile com.amap.api.mapcore.util.ez.b T = null;
    static java.lang.String a = "";
    static java.lang.String b = "";
    static volatile boolean c = true;
    public static boolean d = false;
    static java.lang.String e = "";
    static boolean f = false;
    public static com.amap.api.mapcore.util.ez.a g = null;
    static int h = -1;
    static java.lang.String i = "";
    static java.lang.String j = "";
    private static java.lang.String k = null;
    private static boolean l = false;
    private static volatile boolean m = false;
    private static java.lang.String n = "";
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = false;
    private static java.lang.String r = "";

    /* renamed from: s, reason: collision with root package name */
    private static java.lang.String f130s = "";
    private static boolean t = false;
    private static boolean u = false;
    private static java.lang.String v = "";
    private static boolean w = false;
    private static java.lang.String x = "";
    private static boolean y = false;
    private static java.lang.String z = "";

    /* renamed from: com.amap.api.mapcore.util.ez$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            try {
                java.util.Map<java.lang.String, java.lang.String> b = com.amap.api.mapcore.util.ez.g.b();
                java.lang.String a = com.amap.api.mapcore.util.ez.g.a(com.amap.api.mapcore.util.ez.h(this.a), "", "", com.amap.api.mapcore.util.ez.v(this.a));
                if (android.text.TextUtils.isEmpty(a)) {
                    return;
                }
                com.amap.api.mapcore.util.hb.a();
                java.lang.String a2 = com.amap.api.mapcore.util.ez.g.a(this.a, new java.lang.String(com.amap.api.mapcore.util.hb.b(com.amap.api.mapcore.util.ez.g.a(a.getBytes(), b)).a));
                if (android.text.TextUtils.isEmpty(a2)) {
                    return;
                }
                com.amap.api.mapcore.util.ez.b = a2;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.ez$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.amap.api.mapcore.util.ez.D(this.a);
            com.amap.api.mapcore.util.ez.h();
        }
    }

    public interface a {
        com.amap.api.mapcore.util.hi a(byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map);

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

        /* renamed from: com.amap.api.mapcore.util.ez$b$1, reason: invalid class name */
        public class AnonymousClass1 extends android.content.BroadcastReceiver {
            public AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(android.content.Context context, android.content.Intent intent) {
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                if (com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    com.amap.api.mapcore.util.ez.g();
                }
            }
        }

        /* renamed from: com.amap.api.mapcore.util.ez$b$2, reason: invalid class name */
        public class AnonymousClass2 extends android.net.ConnectivityManager.NetworkCallback {
            public AnonymousClass2() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(android.net.Network network) {
                super.onAvailable(network);
                com.amap.api.mapcore.util.ez.g();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(android.net.Network network) {
                super.onLost(network);
                com.amap.api.mapcore.util.ez.g();
            }
        }

        @android.annotation.SuppressLint({"WrongConstant"})
        public final void a(android.content.Context context) {
            if (android.os.Build.VERSION.SDK_INT < 24) {
                if (context == null || b != null) {
                    return;
                }
                b = new com.amap.api.mapcore.util.ez.b.AnonymousClass1();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(b, intentFilter);
                return;
            }
            if (com.amap.api.mapcore.util.ez.c(context, com.amap.api.mapcore.util.fi.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && c == null) {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                c = connectivityManager;
                if (connectivityManager != null) {
                    d = new android.net.NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    com.amap.api.mapcore.util.ez.b.AnonymousClass2 anonymousClass2 = new com.amap.api.mapcore.util.ez.b.AnonymousClass2();
                    e = anonymousClass2;
                    c.registerNetworkCallback(d, anonymousClass2);
                    a = context;
                }
            }
        }
    }

    public static class c implements android.content.ServiceConnection {
        private static java.lang.String a;
        private android.content.Context b;
        private int c;

        public c(android.content.Context context, int i) {
            this.b = context;
            this.c = i;
        }

        private java.lang.String a() {
            try {
                if (!android.text.TextUtils.isEmpty(a)) {
                    return a;
                }
                byte[] digest = java.security.MessageDigest.getInstance(com.amap.api.mapcore.util.fi.c("IU0hBMQ")).digest(this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures[0].toByteArray());
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                for (byte b : digest) {
                    stringBuffer.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                }
                java.lang.String stringBuffer2 = stringBuffer.toString();
                if (!android.text.TextUtils.isEmpty(stringBuffer2)) {
                    a = stringBuffer2;
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
                int i = this.c;
                if (i == 2) {
                    obtain.writeInterfaceToken(com.amap.api.mapcore.util.fi.c("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                } else if (i == 4) {
                    obtain.writeInterfaceToken(com.amap.api.mapcore.util.fi.c("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                } else {
                    if (i != 5) {
                        z = false;
                        if (z) {
                            iBinder.transact(1, obtain, obtain2, 0);
                            obtain2.readException();
                            java.lang.String unused = com.amap.api.mapcore.util.ez.n = obtain2.readString();
                        }
                    }
                    obtain.writeInterfaceToken(com.amap.api.mapcore.util.fi.c("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                    obtain.writeString(this.b.getPackageName());
                    obtain.writeString(a());
                    obtain.writeString(com.amap.api.mapcore.util.fi.c("IT1VJRA"));
                }
                z = true;
                if (z) {
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.amap.api.mapcore.util.ga.a(th, "oac", java.lang.String.valueOf(this.c));
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

    private static java.lang.String A(android.content.Context context) {
        java.io.FileInputStream fileInputStream = null;
        try {
            if (com.amap.api.mapcore.util.fi.a(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(android.os.Environment.getExternalStorageState())) {
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

    private static java.lang.String B(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(com.amap.api.mapcore.util.fi.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            java.lang.Object invoke = cls.getMethod(com.amap.api.mapcore.util.fi.c("MZ2V0T0FJRA"), android.content.Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                java.lang.String str = (java.lang.String) invoke;
                n = str;
                return str;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "oa", "xm");
            o = true;
        }
        return n;
    }

    private static java.lang.String C(android.content.Context context) {
        try {
            android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse(com.amap.api.mapcore.util.fi.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        }
                        if (com.amap.api.mapcore.util.fi.c("IdmFsdWU").equals(query.getColumnName(i2))) {
                            n = query.getString(i2);
                            break;
                        }
                        i2++;
                    }
                }
                query.close();
            }
        } catch (java.lang.Throwable th) {
            o = true;
            com.amap.api.mapcore.util.ga.a(th, "oa", com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String D(android.content.Context context) {
        java.lang.String c2 = com.amap.api.mapcore.util.fi.c("IeGlhb21p");
        java.lang.String str = android.os.Build.MANUFACTURER;
        if (!c2.equalsIgnoreCase(str)) {
            java.lang.String c3 = com.amap.api.mapcore.util.fi.c("IeGlhb21p");
            java.lang.String str2 = android.os.Build.BRAND;
            if (!c3.equalsIgnoreCase(str2) && !com.amap.api.mapcore.util.fi.c("IUkVETUk=").equalsIgnoreCase(str) && !com.amap.api.mapcore.util.fi.c("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (com.amap.api.mapcore.util.fi.c("Idml2bw").equalsIgnoreCase(str) || com.amap.api.mapcore.util.fi.c("Idml2bw").equalsIgnoreCase(str2)) {
                    return C(context);
                }
                if (com.amap.api.mapcore.util.fi.c("IaHVhd2Vp").equalsIgnoreCase(str) || com.amap.api.mapcore.util.fi.c("IaHVhd2Vp").equalsIgnoreCase(str2) || com.amap.api.mapcore.util.fi.c("ISE9OT1I=").equalsIgnoreCase(str)) {
                    return a(context, 2);
                }
                if (com.amap.api.mapcore.util.fi.c("Mc2Ftc3VuZw").equalsIgnoreCase(str) || com.amap.api.mapcore.util.fi.c("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                    return a(context, 4);
                }
                if (com.amap.api.mapcore.util.fi.c("IT1BQTw").equalsIgnoreCase(str) || com.amap.api.mapcore.util.fi.c("IT1BQTw").equalsIgnoreCase(str2) || com.amap.api.mapcore.util.fi.c("MT25lUGx1cw").equalsIgnoreCase(str) || com.amap.api.mapcore.util.fi.c("MT25lUGx1cw").equalsIgnoreCase(str2) || com.amap.api.mapcore.util.fi.c("IUkVBTE1F").equalsIgnoreCase(str2)) {
                    return a(context, 5);
                }
                o = true;
                return n;
            }
        }
        return B(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:3:0x0002, B:4:0x000e, B:6:0x0014, B:9:0x0026, B:11:0x002c, B:18:0x003e, B:21:0x0048, B:23:0x005a, B:25:0x005f, B:28:0x006a, B:30:0x0070, B:31:0x0078, B:34:0x0037), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String E(android.content.Context context) {
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

    private static android.net.NetworkInfo F(android.content.Context context) {
        android.net.ConnectivityManager L2;
        if (c(context, com.amap.api.mapcore.util.fi.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (L2 = L(context)) != null) {
            return L2.getActiveNetworkInfo();
        }
        return null;
    }

    private static java.lang.String G(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(E)) {
            return E;
        }
        try {
            java.lang.String b2 = com.amap.api.mapcore.util.gq.b(context, "open_common", "a1", "");
            if (android.text.TextUtils.isEmpty(b2)) {
                E = "amap" + java.util.UUID.randomUUID().toString().replace("_", "").toLowerCase();
                android.content.SharedPreferences.Editor a2 = com.amap.api.mapcore.util.gq.a(context, "open_common");
                com.amap.api.mapcore.util.gq.a(a2, "a1", com.amap.api.mapcore.util.fi.b(E));
                com.amap.api.mapcore.util.gq.a(a2);
            } else {
                E = com.amap.api.mapcore.util.fi.c(b2);
            }
        } catch (java.lang.Throwable unused) {
        }
        return E;
    }

    private static boolean H(android.content.Context context) {
        int simState;
        android.telephony.TelephonyManager N2 = N(context);
        return (N2 == null || (simState = N2.getSimState()) == 0 || simState == 1) ? false : true;
    }

    private static java.lang.String I(android.content.Context context) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        boolean H2 = H(context);
        if (L != H2) {
            if (H2) {
                K = "";
                M = false;
            }
            L = H2;
        }
        java.lang.String str = K;
        if ((str == null || "".equals(str)) && !M) {
            if (!L) {
                return "";
            }
            if (!c(context, com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return K;
            }
            android.telephony.TelephonyManager N2 = N(context);
            if (N2 == null) {
                return "";
            }
            java.lang.reflect.Method a2 = com.amap.api.mapcore.util.fi.a(N2.getClass(), "UZ2V0U3Vic2NyaWJlcklk", (java.lang.Class<?>[]) new java.lang.Class[0]);
            if (a2 != null) {
                K = (java.lang.String) a2.invoke(N2, new java.lang.Object[0]);
            }
            if (K == null) {
                K = "";
            }
            M = true;
            return K;
        }
        return K;
    }

    private static java.lang.String J(android.content.Context context) {
        android.telephony.TelephonyManager N2;
        if (O) {
            return N;
        }
        S(context);
        if (c(context, com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (N2 = N(context)) != null) {
            java.lang.String simOperatorName = N2.getSimOperatorName();
            N = simOperatorName;
            if (android.text.TextUtils.isEmpty(simOperatorName)) {
                N = N2.getNetworkOperatorName();
            }
            O = true;
            return N;
        }
        return N;
    }

    private static int K(android.content.Context context) {
        if (Q) {
            return P;
        }
        S(context);
        if (context == null || !c(context, com.amap.api.mapcore.util.fi.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return P;
        }
        android.net.ConnectivityManager L2 = L(context);
        if (L2 == null) {
            return P;
        }
        android.net.NetworkInfo activeNetworkInfo = L2.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            Q = true;
            return P;
        }
        int type = activeNetworkInfo.getType();
        P = type;
        Q = true;
        return type;
    }

    private static android.net.ConnectivityManager L(android.content.Context context) {
        return (android.net.ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int M(android.content.Context context) {
        android.telephony.TelephonyManager N2;
        if (S) {
            return R;
        }
        S(context);
        if (c(context, com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (N2 = N(context)) != null) {
            int networkType = N2.getNetworkType();
            R = networkType;
            S = true;
            return networkType;
        }
        return R;
    }

    private static android.telephony.TelephonyManager N(android.content.Context context) {
        return (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
    }

    private static java.lang.String O(android.content.Context context) {
        java.lang.String str;
        if (!c) {
            return "";
        }
        try {
            str = P(context);
        } catch (java.lang.Throwable unused) {
            str = null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            c = false;
            return "";
        }
        try {
            byte[] bytes = com.amap.api.mapcore.util.fi.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new java.lang.String(com.amap.api.mapcore.util.fa.a(com.amap.api.mapcore.util.fi.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), com.amap.api.mapcore.util.fa.b(str), bytes), "UTF-8");
        } catch (java.lang.Throwable unused2) {
            c = false;
            return "";
        }
    }

    private static java.lang.String P(android.content.Context context) {
        java.lang.String str;
        try {
            str = Q(context);
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        return !android.text.TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(com.amap.api.mapcore.util.fi.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(com.amap.api.mapcore.util.fd.b(com.amap.api.mapcore.util.fi.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static java.lang.String Q(android.content.Context context) {
        java.io.RandomAccessFile randomAccessFile;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.String str;
        java.lang.String[] split;
        java.lang.String b2 = com.amap.api.mapcore.util.fd.b(com.amap.api.mapcore.util.fi.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        java.lang.String R2 = R(context);
        if (android.text.TextUtils.isEmpty(R2)) {
            return "";
        }
        java.io.File file = new java.io.File(R2 + java.io.File.separator + com.amap.api.mapcore.util.fi.c("KYmFja3Vwcw"), com.amap.api.mapcore.util.fi.c("MLmFkaXU"));
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
            if (!android.text.TextUtils.isEmpty(str) && str.contains(com.amap.api.mapcore.util.fi.c("SIw")) && (split = str.split(com.amap.api.mapcore.util.fi.c("SIw"))) != null && split.length == 2 && android.text.TextUtils.equals(b2, split[0])) {
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

    private static java.lang.String R(android.content.Context context) {
        try {
            android.os.storage.StorageManager storageManager = (android.os.storage.StorageManager) context.getSystemService("storage");
            java.lang.Class<?> cls = java.lang.Class.forName(com.amap.api.mapcore.util.fi.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            java.lang.reflect.Method method = storageManager.getClass().getMethod(com.amap.api.mapcore.util.fi.c("MZ2V0Vm9sdW1lTGlzdA"), new java.lang.Class[0]);
            java.lang.reflect.Method method2 = cls.getMethod(com.amap.api.mapcore.util.fi.c("FZ2V0UGF0aA"), new java.lang.Class[0]);
            java.lang.reflect.Method method3 = cls.getMethod(com.amap.api.mapcore.util.fi.c("DaXNSZW1vdmFibGU"), new java.lang.Class[0]);
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

    private static synchronized com.amap.api.mapcore.util.ez.b S(android.content.Context context) {
        synchronized (com.amap.api.mapcore.util.ez.class) {
            if (T == null) {
                if (context == null) {
                    return null;
                }
                com.amap.api.mapcore.util.ez.b bVar = new com.amap.api.mapcore.util.ez.b();
                T = bVar;
                bVar.a(context.getApplicationContext());
            }
            return T;
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
        java.lang.String O2 = O(context);
        b = O2;
        if (!android.text.TextUtils.isEmpty(O2)) {
            return b;
        }
        if (c() == null || m) {
            return "";
        }
        m = true;
        com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.ez.AnonymousClass1(context));
        return "";
    }

    private static java.lang.String a(android.content.Context context, int i2) {
        try {
            android.content.Intent intent = new android.content.Intent();
            if (i2 == 2) {
                intent.setAction(com.amap.api.mapcore.util.fi.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(com.amap.api.mapcore.util.fi.c("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(com.amap.api.mapcore.util.fi.c("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), com.amap.api.mapcore.util.fi.c("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else {
                if (i2 != 5) {
                    o = true;
                    return n;
                }
                intent.setClassName(com.amap.api.mapcore.util.fi.c("YY29tLmhleXRhcC5vcGVuaWQ"), com.amap.api.mapcore.util.fi.c("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(com.amap.api.mapcore.util.fi.c("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            com.amap.api.mapcore.util.ez.c cVar = new com.amap.api.mapcore.util.ez.c(context, i2);
            if (context.bindService(intent, cVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && android.text.TextUtils.isEmpty(n)) {
                    i3++;
                    java.lang.Thread.sleep(15L);
                }
                context.unbindService(cVar);
            }
            return n;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "oa", java.lang.String.valueOf(i2));
            o = true;
            return n;
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            if (android.text.TextUtils.isEmpty(i) && !D) {
                android.telephony.TelephonyManager N2 = N(context);
                if (h == -1) {
                    java.lang.reflect.Method a2 = com.amap.api.mapcore.util.fi.a(android.telephony.TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", (java.lang.Class<?>[]) new java.lang.Class[0]);
                    if (a2 != null) {
                        try {
                            h = ((java.lang.Integer) a2.invoke(N2, new java.lang.Object[0])).intValue();
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    h = 0;
                }
                java.lang.reflect.Method a3 = com.amap.api.mapcore.util.fi.a(android.telephony.TelephonyManager.class, "MZ2V0SW1laQ=", (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.Integer.TYPE});
                if (a3 == null) {
                    h = 0;
                    D = true;
                    return "";
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (int i2 = 0; i2 < h; i2++) {
                    try {
                        sb.append((java.lang.String) a3.invoke(N2, java.lang.Integer.valueOf(i2)));
                        sb.append(str);
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                java.lang.String sb2 = sb.toString();
                if (sb2.length() == 0) {
                    h = 0;
                    D = true;
                    return "";
                }
                java.lang.String substring = sb2.substring(0, sb2.length() - 1);
                i = substring;
                D = true;
                return substring;
            }
            return i;
        } catch (java.lang.Throwable unused3) {
            return "";
        }
    }

    public static void a(com.amap.api.mapcore.util.ez.a aVar) {
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

    public static java.lang.String b() {
        try {
            if (!android.text.TextUtils.isEmpty(e)) {
                return e;
            }
            com.amap.api.mapcore.util.ez.a aVar = g;
            return aVar == null ? "" : aVar.a();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            return J(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static com.amap.api.mapcore.util.ez.a c() {
        return g;
    }

    public static java.lang.String c(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            java.lang.String v2 = v(context);
            if (v2 != null && v2.length() >= 5) {
                return v2.substring(3, 5);
            }
            return "";
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(android.content.Context context, java.lang.String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static int d(android.content.Context context) {
        try {
            return M(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static java.lang.String[] d() {
        return new java.lang.String[]{"", ""};
    }

    public static int e(android.content.Context context) {
        try {
            return K(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static long e() {
        long j2 = H;
        if (j2 != 0) {
            return j2;
        }
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getRootDirectory().getAbsolutePath());
            android.os.StatFs statFs2 = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getAbsolutePath());
            H = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576);
        } catch (java.lang.Throwable unused) {
        }
        return H;
    }

    public static java.lang.String f() {
        if (!android.text.TextUtils.isEmpty(J)) {
            return J;
        }
        java.lang.String property = java.lang.System.getProperty("os.arch");
        J = property;
        return property;
    }

    public static java.lang.String f(android.content.Context context) {
        try {
            return I(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static java.lang.String g(android.content.Context context) {
        if (o) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(n) && !p) {
            if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.ez.AnonymousClass2(context));
                return n;
            }
            p = true;
            return D(context);
        }
        return n;
    }

    public static void g() {
        P = -1;
        Q = false;
        R = -1;
        S = false;
        N = "";
        O = false;
        x = "";
        y = false;
    }

    public static java.lang.String h(android.content.Context context) {
        java.lang.String str;
        if (q) {
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
        if (c(context, com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            a = android.provider.Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!android.text.TextUtils.isEmpty(a)) {
            q = true;
            return a;
        }
        try {
            java.lang.String z2 = z(context);
            a = z2;
            if (!android.text.TextUtils.isEmpty(z2)) {
                q = true;
                return a;
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            a = A(context);
            q = true;
        } catch (java.lang.Throwable unused3) {
        }
        java.lang.String str3 = a;
        return str3 == null ? "" : str3;
    }

    public static /* synthetic */ boolean h() {
        p = true;
        return true;
    }

    public static java.lang.String i(android.content.Context context) {
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(f130s) && !t) {
            if (!c(context, com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return "";
            }
            if (i2 >= 26) {
                java.lang.String str = (java.lang.String) com.amap.api.mapcore.util.fi.a(android.os.Build.class, "MZ2V0U2VyaWFs", (java.lang.Class<?>[]) new java.lang.Class[0]).invoke(android.os.Build.class, new java.lang.Object[0]);
                t = true;
                return str;
            }
            f130s = android.os.Build.SERIAL;
            t = true;
            java.lang.String str2 = f130s;
            return str2 == null ? "" : str2;
        }
        return f130s;
    }

    public static java.lang.String j(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(r) && !u) {
            try {
                java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), com.amap.api.mapcore.util.fi.c(new java.lang.String(com.amap.api.mapcore.util.fx.a(13))));
                r = string;
                u = true;
                return string == null ? "" : string;
            } catch (java.lang.Throwable unused) {
                return r;
            }
        }
        return r;
    }

    public static java.lang.String k(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30) {
            try {
                java.lang.String str = v;
                if ((str == null || "".equals(str)) && !w && c(context, com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                    if (wifiManager == null) {
                        return "";
                    }
                    v = wifiManager.getConnectionInfo().getMacAddress();
                    if (com.amap.api.mapcore.util.fi.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(v) || com.amap.api.mapcore.util.fi.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(v)) {
                        v = E(context);
                    }
                    w = true;
                }
                return v;
            } catch (java.lang.Throwable unused) {
            }
        }
        return v;
    }

    public static java.lang.String l(android.content.Context context) {
        android.telephony.TelephonyManager N2;
        if (y) {
            return x;
        }
        try {
            S(context);
            N2 = N(context);
        } catch (java.lang.Throwable unused) {
        }
        if (N2 == null) {
            return x;
        }
        java.lang.String networkOperator = N2.getNetworkOperator();
        if (!android.text.TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            x = networkOperator.substring(3);
            y = true;
            return x;
        }
        y = true;
        return x;
    }

    public static int m(android.content.Context context) {
        try {
            return M(context);
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static int n(android.content.Context context) {
        try {
            return K(context);
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static java.lang.String o(android.content.Context context) {
        try {
            android.net.NetworkInfo F2 = F(context);
            if (F2 == null) {
                return null;
            }
            return F2.getExtraInfo();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String p(android.content.Context context) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        try {
            str = z;
        } catch (java.lang.Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return z;
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
        z = sb.toString();
        return z;
    }

    public static java.lang.String q(android.content.Context context) {
        android.net.ConnectivityManager L2;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            return (!c(context, com.amap.api.mapcore.util.fi.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (L2 = L(context)) == null || (activeNetworkInfo = L2.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String r(android.content.Context context) {
        try {
            java.lang.String s2 = s(context);
            try {
                if (android.text.TextUtils.isEmpty(s2)) {
                    s2 = a(context);
                }
                if (android.text.TextUtils.isEmpty(s2)) {
                    s2 = h(context);
                }
                if (android.text.TextUtils.isEmpty(s2)) {
                    s2 = g(context);
                }
                if (android.text.TextUtils.isEmpty(s2)) {
                    s2 = j(context);
                }
                return android.text.TextUtils.isEmpty(s2) ? G(context) : s2;
            } catch (java.lang.Throwable unused) {
                return s2;
            }
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    public static java.lang.String s(android.content.Context context) {
        int i2;
        try {
            i2 = android.os.Build.VERSION.SDK_INT;
        } catch (java.lang.Throwable unused) {
        }
        if (i2 >= 29) {
            return "";
        }
        java.lang.String str = A;
        if ((str == null || "".equals(str)) && !F && c(context, com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            android.telephony.TelephonyManager N2 = N(context);
            if (N2 == null) {
                return "";
            }
            java.lang.reflect.Method a2 = com.amap.api.mapcore.util.fi.a(N2.getClass(), "QZ2V0RGV2aWNlSWQ", (java.lang.Class<?>[]) new java.lang.Class[0]);
            if (i2 >= 26) {
                a2 = com.amap.api.mapcore.util.fi.a(N2.getClass(), "QZ2V0SW1laQ==", (java.lang.Class<?>[]) new java.lang.Class[0]);
            }
            if (a2 != null) {
                A = (java.lang.String) a2.invoke(N2, new java.lang.Object[0]);
            }
            if (A == null) {
                A = "";
            }
            F = true;
            return A;
        }
        return A;
    }

    public static java.lang.String t(android.content.Context context) {
        return s(context) + "#" + a(context) + "#" + r(context);
    }

    public static java.lang.String u(android.content.Context context) {
        java.lang.String str;
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        try {
            str = B;
        } catch (java.lang.Throwable unused) {
        }
        if ((str == null || "".equals(str)) && c(context, com.amap.api.mapcore.util.fi.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            android.telephony.TelephonyManager N2 = N(context);
            if (N2 == null) {
                return "";
            }
            if (G) {
                return B;
            }
            if (i2 >= 26) {
                java.lang.reflect.Method a2 = com.amap.api.mapcore.util.fi.a(N2.getClass(), "QZ2V0TWVpZA==", (java.lang.Class<?>[]) new java.lang.Class[0]);
                if (a2 != null) {
                    B = (java.lang.String) a2.invoke(N2, new java.lang.Object[0]);
                }
                if (B == null) {
                    B = "";
                }
                G = true;
            }
            return B;
        }
        return B;
    }

    public static java.lang.String v(android.content.Context context) {
        try {
            return I(context);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static int w(android.content.Context context) {
        int i2 = I;
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
        I = i3;
        return i3;
    }

    public static java.lang.String x(android.content.Context context) {
        try {
            return J(context);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static java.lang.String z(android.content.Context context) {
        try {
            java.lang.String b2 = com.amap.api.mapcore.util.gq.b(context, "Alvin2", "UTDID2", "");
            return android.text.TextUtils.isEmpty(b2) ? com.amap.api.mapcore.util.gq.b(context, "Alvin2", "UTDID", "") : b2;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
