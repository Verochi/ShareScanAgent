package com.alipay.apmobilesecuritysdk.e;

/* loaded from: classes.dex */
public final class i {
    public static java.lang.String a = "";
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static java.lang.String d = "";
    public static java.lang.String e = "";
    public static java.util.Map<java.lang.String, java.lang.String> f = new java.util.HashMap();

    public static synchronized java.lang.String a(java.lang.String str) {
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            java.lang.String str2 = "apdidTokenCache" + str;
            if (f.containsKey(str2)) {
                java.lang.String str3 = f.get(str2);
                if (com.alipay.sdk.m.z.a.b(str3)) {
                    return str3;
                }
            }
            return "";
        }
    }

    public static synchronized void a() {
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
        }
    }

    public static synchronized void a(com.alipay.apmobilesecuritysdk.e.b bVar) {
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            if (bVar != null) {
                a = bVar.a;
                b = bVar.b;
                c = bVar.c;
            }
        }
    }

    public static synchronized void a(com.alipay.apmobilesecuritysdk.e.c cVar) {
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            if (cVar != null) {
                a = cVar.a;
                b = cVar.b;
                d = cVar.d;
                e = cVar.e;
                c = cVar.c;
            }
        }
    }

    public static synchronized void a(java.lang.String str, java.lang.String str2) {
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            java.lang.String str3 = "apdidTokenCache" + str;
            if (f.containsKey(str3)) {
                f.remove(str3);
            }
            f.put(str3, str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        if (r1 < 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(android.content.Context context, java.lang.String str) {
        long j;
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            try {
                j = com.alipay.apmobilesecuritysdk.e.h.a(context);
            } catch (java.lang.Throwable unused) {
            }
        }
        j = 86400000;
        try {
            if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - com.alipay.apmobilesecuritysdk.e.h.h(context, str)) < j) {
                return true;
            }
        } finally {
            return false;
        }
        return false;
    }

    public static synchronized java.lang.String b() {
        java.lang.String str;
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            str = a;
        }
        return str;
    }

    public static void b(java.lang.String str) {
        a = str;
    }

    public static synchronized java.lang.String c() {
        java.lang.String str;
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            str = b;
        }
        return str;
    }

    public static void c(java.lang.String str) {
        b = str;
    }

    public static synchronized java.lang.String d() {
        java.lang.String str;
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            str = d;
        }
        return str;
    }

    public static void d(java.lang.String str) {
        c = str;
    }

    public static synchronized java.lang.String e() {
        java.lang.String str;
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            str = e;
        }
        return str;
    }

    public static void e(java.lang.String str) {
        d = str;
    }

    public static synchronized java.lang.String f() {
        java.lang.String str;
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            str = c;
        }
        return str;
    }

    public static void f(java.lang.String str) {
        e = str;
    }

    public static synchronized com.alipay.apmobilesecuritysdk.e.c g() {
        com.alipay.apmobilesecuritysdk.e.c cVar;
        synchronized (com.alipay.apmobilesecuritysdk.e.i.class) {
            cVar = new com.alipay.apmobilesecuritysdk.e.c(a, b, c, d, e);
        }
        return cVar;
    }

    public static void h() {
        f.clear();
        a = "";
        b = "";
        d = "";
        e = "";
        c = "";
    }
}
