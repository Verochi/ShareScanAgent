package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bt {
    public static final java.lang.String a = "logger";
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = -1;
    private static volatile com.baidu.mobads.sdk.internal.bt i;

    private bt() {
    }

    public static com.baidu.mobads.sdk.internal.bt a() {
        if (i == null) {
            synchronized (com.baidu.mobads.sdk.internal.bt.class) {
                if (i == null) {
                    i = new com.baidu.mobads.sdk.internal.bt();
                }
            }
        }
        return i;
    }

    private java.lang.String e(java.lang.Object[] objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.Object obj : objArr) {
            sb.append(obj);
            sb.append(' ');
        }
        return sb.toString();
    }

    public void a(java.lang.String str) {
        a(a, str);
    }

    public void a(java.lang.String str, java.lang.String str2) {
        if (a(3)) {
            try {
                com.baidu.mobads.sdk.internal.ay.h(str).c(str2);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void a(java.lang.String str, java.lang.Throwable th) {
        if (a(3)) {
            try {
                com.baidu.mobads.sdk.internal.ay.h(a).b(th, str);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void a(java.lang.Throwable th) {
        a("", th);
    }

    public void a(java.lang.Object... objArr) {
        if (a(3)) {
            a(e(objArr));
        }
    }

    public boolean a(int i2) {
        return a(a, i2);
    }

    public boolean a(java.lang.String str, int i2) {
        return true;
    }

    public void b(java.lang.String str) {
        if (a(5)) {
            try {
                com.baidu.mobads.sdk.internal.ay.c().e(str);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void b(java.lang.String str, java.lang.String str2) {
        if (a(4)) {
            try {
                com.baidu.mobads.sdk.internal.ay.c().c(str, str2);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void b(java.lang.String str, java.lang.Throwable th) {
        if (a(5)) {
            try {
                com.baidu.mobads.sdk.internal.ay.c().d(th, str);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void b(java.lang.Throwable th) {
        b("", th);
    }

    public void b(java.lang.Object... objArr) {
        if (a(5)) {
            b(e(objArr));
        }
    }

    public void c(java.lang.String str) {
        if (a(6)) {
            try {
                com.baidu.mobads.sdk.internal.ay.c().f(str);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void c(java.lang.String str, java.lang.Throwable th) {
        if (a(6)) {
            try {
                com.baidu.mobads.sdk.internal.ay.c().e(th, str);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void c(java.lang.Throwable th) {
        c("", th);
    }

    public void c(java.lang.Object... objArr) {
        if (a(6)) {
            c(e(objArr));
        }
    }

    public void d(java.lang.String str) {
        b(a, str);
    }

    public void d(java.lang.String str, java.lang.Throwable th) {
        if (a(4)) {
            try {
                com.baidu.mobads.sdk.internal.ay.c().c(th, str);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void d(java.lang.Object... objArr) {
        if (a(4)) {
            d(e(objArr));
        }
    }
}
