package com.alipay.sdk.m.p0;

/* loaded from: classes.dex */
public class c {
    public static java.lang.String A = null;
    public static volatile com.alipay.sdk.m.p0.c B = null;
    public static volatile com.alipay.sdk.m.p0.b C = null;
    public static final java.lang.String a = "VMS_IDLG_SDK_Client";
    public static final java.lang.String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    public static final java.lang.String c = "persist.sys.identifierid.supported";
    public static final java.lang.String d = "appid";
    public static final java.lang.String e = "type";
    public static final java.lang.String f = "OAID";
    public static final java.lang.String g = "VAID";
    public static final java.lang.String h = "AAID";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;
    public static final int m = 11;
    public static final int n = 2000;
    public static android.content.Context o;
    public static boolean p;
    public static com.alipay.sdk.m.p0.d q;
    public static com.alipay.sdk.m.p0.d r;

    /* renamed from: s, reason: collision with root package name */
    public static com.alipay.sdk.m.p0.d f85s;
    public static java.lang.Object t = new java.lang.Object();
    public static android.os.HandlerThread u;
    public static android.os.Handler v;
    public static java.lang.String w;
    public static java.lang.String x;
    public static java.lang.String y;
    public static java.lang.String z;

    public static class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 11) {
                java.lang.String unused = com.alipay.sdk.m.p0.c.w = com.alipay.sdk.m.p0.c.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
                synchronized (com.alipay.sdk.m.p0.c.t) {
                    com.alipay.sdk.m.p0.c.t.notify();
                }
            }
        }
    }

    public static com.alipay.sdk.m.p0.c a(android.content.Context context) {
        if (B == null) {
            synchronized (com.alipay.sdk.m.p0.c.class) {
                o = context.getApplicationContext();
                B = new com.alipay.sdk.m.p0.c();
            }
        }
        if (C == null) {
            synchronized (com.alipay.sdk.m.p0.c.class) {
                o = context.getApplicationContext();
                g();
                C = new com.alipay.sdk.m.p0.b(o);
                f();
            }
        }
        return B;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
                return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, "unknown");
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (java.lang.Throwable unused) {
            return str2;
        }
    }

    public static void a(android.content.Context context, int i2, java.lang.String str) {
        if (i2 == 0) {
            q = new com.alipay.sdk.m.p0.d(B, 0, null);
            context.getContentResolver().registerContentObserver(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q);
            return;
        }
        if (i2 == 1) {
            r = new com.alipay.sdk.m.p0.d(B, 1, str);
            context.getContentResolver().registerContentObserver(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
            return;
        }
        if (i2 != 2) {
            return;
        }
        f85s = new com.alipay.sdk.m.p0.d(B, 2, str);
        context.getContentResolver().registerContentObserver(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, f85s);
    }

    private void b(int i2, java.lang.String str) {
        android.os.Message obtainMessage = v.obtainMessage();
        obtainMessage.what = 11;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        v.sendMessage(obtainMessage);
    }

    public static void f() {
        p = "1".equals(a(c, "0"));
    }

    public static void g() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("SqlWorkThread");
        u = handlerThread;
        handlerThread.start();
        v = new com.alipay.sdk.m.p0.c.a(u.getLooper());
    }

    public java.lang.String a() {
        if (!c()) {
            return null;
        }
        java.lang.String str = x;
        if (str != null) {
            return str;
        }
        a(0, (java.lang.String) null);
        if (q == null) {
            a(o, 0, null);
        }
        return x;
    }

    public java.lang.String a(java.lang.String str) {
        if (!c()) {
            return null;
        }
        java.lang.String str2 = z;
        if (str2 != null) {
            return str2;
        }
        a(2, str);
        if (f85s == null && z != null) {
            a(o, 2, str);
        }
        return z;
    }

    public void a(int i2, java.lang.String str) {
        synchronized (t) {
            b(i2, str);
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            try {
                t.wait(2000L);
            } catch (java.lang.InterruptedException e2) {
                e2.printStackTrace();
            }
            if (android.os.SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i2 == 0) {
                    x = w;
                    w = null;
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        java.lang.String str2 = w;
                        if (str2 != null) {
                            z = str2;
                            w = null;
                        }
                    } else if (i2 != 4) {
                    }
                    A = w;
                    w = null;
                } else {
                    java.lang.String str3 = w;
                    if (str3 != null) {
                        y = str3;
                        w = null;
                    }
                }
            }
        }
    }

    public java.lang.String b() {
        if (!c()) {
            return null;
        }
        a(4, (java.lang.String) null);
        return A;
    }

    public java.lang.String b(java.lang.String str) {
        if (!c()) {
            return null;
        }
        java.lang.String str2 = y;
        if (str2 != null) {
            return str2;
        }
        a(1, str);
        if (r == null && y != null) {
            a(o, 1, str);
        }
        return y;
    }

    public boolean c() {
        return p;
    }
}
