package com.bun.miitmdid.c.j.b;

/* loaded from: classes.dex */
public class b {
    private static android.content.Context a;
    private static boolean b;
    private static com.bun.miitmdid.c.j.b.b c;
    private static com.bun.miitmdid.c.j.b.a d;
    private static com.bun.miitmdid.c.j.b.c e;
    private static com.bun.miitmdid.c.j.b.c f;
    private static com.bun.miitmdid.c.j.b.c g;
    private static java.lang.Object h = new java.lang.Object();
    private static android.os.HandlerThread i;
    private static android.os.Handler j;
    private static java.lang.String k;
    private static java.lang.String l;
    private static java.lang.String m;
    private static java.lang.String n;

    public static class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 11) {
                com.bun.lib.a.a(com.alipay.sdk.m.p0.c.a, "message type valid");
                return;
            }
            try {
                java.lang.String unused = com.bun.miitmdid.c.j.b.b.k = com.bun.miitmdid.c.j.b.b.d.a(message.getData().getInt("type"), message.getData().getString("appid"));
            } catch (java.lang.Exception e) {
                java.lang.String unused2 = com.bun.miitmdid.c.j.b.b.k = "";
                com.bun.lib.a.a(com.alipay.sdk.m.p0.c.a, "exception", e);
            }
            synchronized (com.bun.miitmdid.c.j.b.b.h) {
                com.bun.miitmdid.c.j.b.b.h.notify();
            }
        }
    }

    private b() {
    }

    public static com.bun.miitmdid.c.j.b.b a(android.content.Context context) {
        if (c == null) {
            c = new com.bun.miitmdid.c.j.b.b();
            a = context;
            f();
            d = new com.bun.miitmdid.c.j.b.a(a);
            e();
        }
        return c;
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

    private static void a(android.content.Context context, int i2, java.lang.String str) {
        android.content.ContentResolver contentResolver;
        android.net.Uri parse;
        com.bun.miitmdid.c.j.b.c cVar;
        if (i2 == 0) {
            e = new com.bun.miitmdid.c.j.b.c(c, 0, null);
            context.getContentResolver().registerContentObserver(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, e);
            return;
        }
        if (i2 == 1) {
            f = new com.bun.miitmdid.c.j.b.c(c, 1, str);
            contentResolver = context.getContentResolver();
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
            cVar = f;
        } else {
            if (i2 != 2) {
                return;
            }
            g = new com.bun.miitmdid.c.j.b.c(c, 2, str);
            contentResolver = context.getContentResolver();
            parse = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
            cVar = g;
        }
        contentResolver.registerContentObserver(parse, false, cVar);
    }

    private void b(int i2, java.lang.String str) {
        android.os.Message obtainMessage = j.obtainMessage();
        obtainMessage.what = 11;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        j.sendMessage(obtainMessage);
    }

    public static void e() {
        b = "1".equals(a(com.alipay.sdk.m.p0.c.c, "0"));
    }

    private static void f() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("SqlWorkThread");
        i = handlerThread;
        handlerThread.start();
        j = new com.bun.miitmdid.c.j.b.b.a(i.getLooper());
    }

    public java.lang.String a() {
        if (!b()) {
            return null;
        }
        java.lang.String str = l;
        if (str != null) {
            return str;
        }
        a(0, (java.lang.String) null);
        if (e == null) {
            a(a, 0, null);
        }
        return l;
    }

    public java.lang.String a(java.lang.String str) {
        if (!b()) {
            return null;
        }
        java.lang.String str2 = n;
        if (str2 != null) {
            return str2;
        }
        a(2, str);
        if (g == null && n != null) {
            a(a, 2, str);
        }
        return n;
    }

    public void a(int i2, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        synchronized (h) {
            b(i2, str);
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            try {
                h.wait(2000L);
            } catch (java.lang.InterruptedException e2) {
                e2.printStackTrace();
            }
            if (android.os.SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i2 == 0) {
                    l = k;
                } else if (i2 == 1) {
                    java.lang.String str4 = k;
                    if (str4 != null) {
                        m = str4;
                    } else {
                        str2 = com.alipay.sdk.m.p0.c.a;
                        str3 = "get vaid failed";
                    }
                } else if (i2 == 2) {
                    java.lang.String str5 = k;
                    if (str5 != null) {
                        n = str5;
                    } else {
                        str2 = com.alipay.sdk.m.p0.c.a;
                        str3 = "get aaid failed";
                    }
                }
                k = null;
            } else {
                str2 = com.alipay.sdk.m.p0.c.a;
                str3 = "query timeout";
            }
            com.bun.lib.a.a(str2, str3);
        }
    }

    public java.lang.String b(java.lang.String str) {
        if (!b()) {
            return null;
        }
        java.lang.String str2 = m;
        if (str2 != null) {
            return str2;
        }
        a(1, str);
        if (f == null && m != null) {
            a(a, 1, str);
        }
        return m;
    }

    public boolean b() {
        return b;
    }
}
