package cn.fly.verify;

/* loaded from: classes31.dex */
public class as {
    private static java.lang.String a;
    private static java.lang.Integer b;
    private static java.lang.Integer d;
    private static java.util.List<java.lang.Integer> f;
    private static long h;
    private static long i;
    private static long j;
    private static long k;
    private static long l;
    private static long m;
    private static long n;
    private static java.lang.String o;
    private static java.lang.Object c = new java.lang.Object();
    private static java.lang.Object e = new java.lang.Object();
    private static java.lang.Object g = new java.lang.Object();
    private static final char[] p = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int a(java.lang.String str) {
        try {
            if (!"46000".equals(str) && !"46002".equals(str) && !"46004".equals(str) && !"46007".equals(str) && !"46008".equals(str)) {
                if (!"46001".equals(str) && !"46006".equals(str) && !"46009".equals(str)) {
                    if (!"46003".equals(str) && !"46005".equals(str)) {
                        if (!"46011".equals(str)) {
                            return 0;
                        }
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th, "[FlyVerify][%s][%s] ==>%s", "Util", "isMobileDataEnabled", "Check mobile data encountered exception");
            return 0;
        }
    }

    public static cn.fly.verify.s a(cn.fly.verify.s sVar, int i2, java.lang.String str, java.lang.String str2, int i3, java.lang.Integer num, java.lang.String str3, cn.fly.verify.e eVar) {
        java.lang.String str4;
        if (i3 == 1) {
            cn.fly.verify.f.a().a("use multi operator");
            sVar = new cn.fly.verify.t();
            sVar.a(str, str2, b(i2), eVar);
            sVar.b(i3);
        } else {
            if (i2 == 1) {
                if (sVar == null) {
                    sVar = new cn.fly.verify.t();
                }
                str4 = "CMCC";
            } else if (i2 == 2) {
                if (sVar == null) {
                    sVar = new cn.fly.verify.ae();
                }
                str4 = "CUCC";
            } else if (i2 == 4) {
                if (sVar == null) {
                    sVar = new cn.fly.verify.ac();
                }
                str4 = "CTCC";
            }
            sVar.a(str, str2, str4, eVar);
        }
        sVar.a(num);
        sVar.a(str3);
        return sVar;
    }

    public static java.lang.String a() {
        return a(false);
    }

    public static java.lang.String a(int i2) {
        return i2 == 1 ? "CMCC" : i2 == 2 ? "CUCC" : i2 == 3 ? "CUXW" : i2 == 4 ? "CTCC" : com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    public static java.lang.String a(int i2, java.lang.String str) {
        return str;
    }

    public static java.lang.String a(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter((java.io.Writer) stringWriter, true));
        stringWriter.getBuffer().toString();
        return stringWriter.getBuffer().toString();
    }

    public static java.lang.String a(boolean z) {
        java.lang.String str;
        try {
            str = cn.fly.verify.al.d();
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th, "[FlyVerify][%s][%s] ==>%s", "Util", "getMNC", "Check mobile data encountered exception");
            str = null;
        }
        if (!android.text.TextUtils.isEmpty(str) && !"-1".equalsIgnoreCase(str)) {
            return str;
        }
        if (android.text.TextUtils.isEmpty(a) || z) {
            a = cn.fly.verify.al.l();
        }
        return a;
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            char[] cArr = p;
            sb.append(cArr[(bArr[i2] >> 4) & 15]);
            sb.append(cArr[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c9, code lost:
    
        if (r2 != null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<java.lang.Integer> a(android.content.Context context, java.util.List<java.lang.Integer> list) {
        java.util.ArrayList arrayList;
        android.database.Cursor cursor = null;
        if (list != null && !list.isEmpty()) {
            for (java.lang.Integer num : list) {
                if (num != null && (num.intValue() == 0 || num.intValue() == 1)) {
                    arrayList = new java.util.ArrayList();
                    break;
                }
            }
        }
        arrayList = null;
        if (arrayList == null) {
            return list;
        }
        if (("HUAWEI".equalsIgnoreCase(cn.fly.verify.fh.d.l()) || "HONOR".equalsIgnoreCase(cn.fly.verify.fh.d.l())) && android.os.Build.VERSION.SDK_INT <= 28) {
            try {
                cursor = context.getContentResolver().query(android.net.Uri.parse("content://telephony/siminfo"), new java.lang.String[]{"_id", "sim_id"}, "sim_id>=?", new java.lang.String[]{"0"}, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            int i2 = cursor.getInt(cursor.getColumnIndex("sim_id"));
                            int i3 = cursor.getInt(cursor.getColumnIndex("_id"));
                            int i4 = 0;
                            while (true) {
                                if (i4 >= list.size()) {
                                    break;
                                }
                                int intValue = list.get(i4).intValue();
                                if (intValue != -1 && intValue == i2) {
                                    list.set(i4, java.lang.Integer.valueOf(i3));
                                    cn.fly.verify.f.a().a("fixed = " + i3);
                                    break;
                                }
                                i4++;
                            }
                        } catch (java.lang.Throwable th) {
                            cn.fly.verify.f.a().a(th);
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                try {
                    cn.fly.verify.f.a().a(th2);
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return list;
    }

    public static void a(long j2) {
        h = j2;
    }

    public static void a(cn.fly.verify.ar arVar) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            arVar.b();
        } else {
            arVar.run();
        }
    }

    public static boolean a(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT > 22) {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager.getSimState() == 1 || telephonyManager.getSimState() == 0) {
                    cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "NO SIM");
                    return false;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return true;
    }

    public static int b(boolean z) {
        android.telephony.SubscriptionManager from;
        int activeSubscriptionInfoCount;
        int intValue;
        synchronized (c) {
            if (b == null || z) {
                try {
                    boolean z2 = android.os.Build.VERSION.SDK_INT >= 22 && cn.fly.verify.fh.d.b(com.anythink.china.common.d.a);
                    boolean z3 = cn.fly.verify.ai.a().r() == 1;
                    if (!z3) {
                        cn.fly.verify.f.a().a("not allowed slots");
                    }
                    if (z2 && z3) {
                        from = android.telephony.SubscriptionManager.from(cn.fly.verify.ax.g());
                        activeSubscriptionInfoCount = from.getActiveSubscriptionInfoCount();
                        b = java.lang.Integer.valueOf(activeSubscriptionInfoCount);
                        cn.fly.verify.f.a().a("==== getSimCount");
                    } else {
                        b = -1;
                    }
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.f.a().a(th);
                    b = -1;
                }
                if (b.intValue() == 0 && a(cn.fly.verify.ax.g())) {
                    b = -1;
                }
            }
            intValue = b.intValue();
        }
        return intValue;
    }

    public static java.lang.String b() {
        java.lang.String a2 = a();
        try {
            if (!"46000".equals(a2) && !"46002".equals(a2) && !"46004".equals(a2) && !"46007".equals(a2) && !"46008".equals(a2)) {
                if (!"46001".equals(a2) && !"46006".equals(a2) && !"46009".equals(a2)) {
                    if (!"46003".equals(a2) && !"46005".equals(a2)) {
                        if (!"46011".equals(a2)) {
                            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
                        }
                    }
                    return "CTCC";
                }
                return "CUCC";
            }
            return "CMCC";
        } catch (java.lang.Throwable unused) {
            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    private static java.lang.String b(int i2) {
        return i2 == 1 ? "CMCC" : (i2 == 2 || i2 == 3) ? "CUCC" : i2 == 4 ? "CTCC" : com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    public static java.lang.String b(java.lang.String str) {
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i3]) * 16) + "0123456789ABCDEF".indexOf(charArray[i3 + 1])) & 255);
        }
        return new java.lang.String(bArr);
    }

    public static void b(long j2) {
        i = j2;
    }

    public static boolean b(android.content.Context context) {
        return c(context) == 1;
    }

    public static int c(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT <= 22 || ((android.telephony.TelephonyManager) cn.fly.verify.fh.d.a(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimState() != 1) {
                return ((java.lang.Boolean) cn.fly.verify.fh.d.a(context.getSystemService("connectivity"), "getMobileDataEnabled", new java.lang.Object[0])).booleanValue() ? 1 : 0;
            }
            cn.fly.verify.f.a().a("NO SIM");
            return 0;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            return -1;
        }
    }

    public static int c(boolean z) {
        int intValue;
        synchronized (e) {
            if (d == null || z) {
                try {
                    boolean z2 = cn.fly.verify.ai.a().r() == 1;
                    if (!z2) {
                        cn.fly.verify.f.a().a("not allowed slots");
                    }
                    if (z2) {
                        d = 0;
                        try {
                            java.lang.Class<?> loadClass = cn.fly.verify.ax.g().getClassLoader().loadClass("android.os.SystemProperties");
                            java.lang.String str = ((java.lang.String) loadClass.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(loadClass, "gsm.sim.state")) + ((java.lang.String) loadClass.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(loadClass, "gsm.sim.state.2"));
                            if (!android.text.TextUtils.isEmpty(str)) {
                                java.lang.String[] split = str.split(",");
                                if (split.length > 0) {
                                    for (java.lang.String str2 : split) {
                                        if (!android.text.TextUtils.isEmpty(str2) && !"ABSENT".equals(str2) && !"NOT_READY".equals(str2)) {
                                            d = java.lang.Integer.valueOf(d.intValue() + 1);
                                        }
                                    }
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            cn.fly.verify.f.a().a(th);
                        }
                    } else {
                        d = -1;
                    }
                } catch (java.lang.Throwable th2) {
                    cn.fly.verify.f.a().a(th2);
                    d = -1;
                }
            }
            intValue = d.intValue();
        }
        return intValue;
    }

    public static void c(long j2) {
        j = j2;
    }

    public static boolean c() {
        java.lang.String j2 = cn.fly.verify.al.j();
        return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_2G.equalsIgnoreCase(j2) || com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_3G.equalsIgnoreCase(j2) || com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_4G.equalsIgnoreCase(j2) || com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_5G.equalsIgnoreCase(j2) || com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j2);
    }

    public static byte[] c(java.lang.String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            int digit = java.lang.Character.digit(charArray[i3 + 1], 16) | (java.lang.Character.digit(charArray[i3], 16) << 4);
            if (digit > 127) {
                digit += androidx.core.view.InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i2] = (byte) digit;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
    
        r0 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d() {
        int i2;
        int i3;
        if (cn.fly.verify.ai.a().p() == 0) {
            cn.fly.verify.f.a().a("not allowed sid");
            return -1;
        }
        try {
            i3 = android.os.Build.VERSION.SDK_INT;
        } catch (java.lang.Exception unused) {
            i2 = -1;
        }
        if (i3 >= 30) {
            i2 = android.telephony.SubscriptionManager.getActiveDataSubscriptionId();
        } else {
            if (i3 >= 24) {
                i2 = android.telephony.SubscriptionManager.getDefaultDataSubscriptionId();
            }
            i2 = -1;
        }
        if (i2 == -1) {
            return i2;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Integer.valueOf(i2));
        java.util.List<java.lang.Integer> a2 = a(cn.fly.verify.ax.g(), arrayList);
        return (a2 == null || a2.isEmpty()) ? i2 : a2.get(0).intValue();
    }

    public static java.lang.String d(java.lang.String str) {
        if (str == null) {
            return null;
        }
        byte[] decode = android.util.Base64.decode(str, 2);
        int length = decode.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) (decode[i2] - length);
        }
        try {
            return new java.lang.String(bArr, "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d A[Catch: all -> 0x00b6, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x00b2, B:8:0x00b4, B:34:0x0095, B:36:0x009d, B:38:0x00ab, B:44:0x0087, B:13:0x0009, B:15:0x0011, B:18:0x001c, B:22:0x0029, B:25:0x0036, B:27:0x004d, B:29:0x0053, B:30:0x005e, B:32:0x0064, B:39:0x0078, B:40:0x007d, B:41:0x0080), top: B:3:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<java.lang.Integer> d(boolean z) {
        boolean z2;
        boolean z3;
        java.util.ArrayList arrayList;
        android.telephony.SubscriptionManager from;
        java.util.List<android.telephony.SubscriptionInfo> activeSubscriptionInfoList;
        int subscriptionId;
        java.util.List<java.lang.Integer> list;
        synchronized (g) {
            if (f == null || z) {
                try {
                    z2 = android.os.Build.VERSION.SDK_INT >= 22 && cn.fly.verify.fh.d.b(com.anythink.china.common.d.a);
                    z3 = cn.fly.verify.ai.a().q() == 1;
                    if (!z3) {
                        cn.fly.verify.f.a().a("not allowed sids");
                    }
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.f.a().a(th);
                    f = new java.util.ArrayList();
                }
                if (z2 && z3) {
                    from = android.telephony.SubscriptionManager.from(cn.fly.verify.ax.g());
                    activeSubscriptionInfoList = from.getActiveSubscriptionInfoList();
                    cn.fly.verify.f.a().a("==== getSubIds");
                    if (activeSubscriptionInfoList == null || activeSubscriptionInfoList.isEmpty()) {
                        arrayList = new java.util.ArrayList();
                    } else {
                        f = new java.util.ArrayList();
                        for (android.telephony.SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                            java.util.List<java.lang.Integer> list2 = f;
                            subscriptionId = subscriptionInfo.getSubscriptionId();
                            list2.add(java.lang.Integer.valueOf(subscriptionId));
                        }
                        if (!f.isEmpty()) {
                            java.util.List<java.lang.Integer> a2 = a(cn.fly.verify.ax.g(), f);
                            f = a2;
                            if (a2 == null) {
                                f = new java.util.ArrayList();
                            }
                        }
                    }
                } else {
                    arrayList = new java.util.ArrayList();
                }
                f = arrayList;
                if (!f.isEmpty()) {
                }
            }
            list = f;
        }
        return list;
    }

    public static void d(long j2) {
        k = j2;
    }

    public static boolean d(android.content.Context context) {
        if (context == null) {
            return true;
        }
        return com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(cn.fly.verify.al.j());
    }

    public static java.lang.String e() {
        try {
            return cn.fly.verify.fi.d(cn.fly.verify.ax.g().getPackageManager().getPackageInfo(cn.fly.verify.ax.g().getPackageName(), 64).signatures[0].toByteArray());
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            return null;
        }
    }

    public static void e(long j2) {
        l = j2;
    }

    public static java.lang.String f() {
        try {
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
        }
        if (!android.text.TextUtils.isEmpty(o)) {
            return o;
        }
        java.lang.String a2 = cn.fly.verify.aq.a();
        o = a2;
        if (android.text.TextUtils.isEmpty(a2)) {
            java.lang.String b2 = cn.fly.verify.fi.b(java.util.UUID.randomUUID().toString() + android.os.SystemClock.elapsedRealtimeNanos());
            o = b2;
            cn.fly.verify.aq.a(b2);
        }
        return o;
    }

    public static void f(long j2) {
        m = j2;
    }

    public static java.lang.String g() throws java.lang.Throwable {
        return cn.fly.verify.al.b();
    }

    public static void g(long j2) {
        n = j2;
    }

    public static long h() {
        return h;
    }

    public static long i() {
        return i;
    }

    public static long j() {
        return j;
    }

    public static long k() {
        return k;
    }

    public static long l() {
        return l;
    }

    public static long m() {
        return m;
    }

    public static long n() {
        return n;
    }

    public static int o() {
        int c2 = c(cn.fly.verify.ax.g());
        java.lang.String j2 = cn.fly.verify.al.j();
        if (c2 == 1 && com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j2)) {
            return 1;
        }
        if (c2 == 1 && !"none".equalsIgnoreCase(j2)) {
            return 2;
        }
        if (c2 == 1) {
            return 3;
        }
        if (c2 == -1 && com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j2)) {
            return 4;
        }
        if (c2 == -1 && !"none".equalsIgnoreCase(j2)) {
            return 5;
        }
        if (c2 == -1) {
            return 6;
        }
        if (c2 == 0 && com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j2)) {
            return 7;
        }
        return (c2 != 0 || "none".equalsIgnoreCase(j2)) ? 9 : 8;
    }
}
