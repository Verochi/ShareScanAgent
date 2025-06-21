package org.repackage.com.vivo.identifier;

/* loaded from: classes26.dex */
public class IdentifierIdClient {
    public static int A = 0;
    public static int B = 0;
    public static int C = 0;
    public static int D = 0;
    public static int E = 0;
    public static final java.lang.String a = "persist.sys.identifierid";
    public static java.lang.Object c = new java.lang.Object();
    public static android.content.Context d = null;
    public static boolean e = false;
    public static int f = 13;
    public static org.repackage.com.vivo.identifier.IdentifierIdObserver g;
    public static org.repackage.com.vivo.identifier.IdentifierIdObserver h;
    public static org.repackage.com.vivo.identifier.IdentifierIdObserver i;
    public static android.os.HandlerThread j;
    public static android.os.Handler k;
    public static java.lang.String l;
    public static java.lang.String m;
    public static java.lang.String n;
    public static java.lang.String o;
    public static java.lang.String p;
    public static java.lang.String q;
    public static volatile org.repackage.com.vivo.identifier.IdentifierIdClient r;

    /* renamed from: s, reason: collision with root package name */
    public static volatile org.repackage.com.vivo.identifier.DataBaseOperation f507s;
    public static int t;
    public static int u;
    public static int v;
    public static int w;
    public static int x;
    public static int y;
    public static int z;
    public final int b;

    /* renamed from: org.repackage.com.vivo.identifier.IdentifierIdClient$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (org.repackage.com.vivo.identifier.IdentifierIdClient.t + org.repackage.com.vivo.identifier.IdentifierIdClient.u + org.repackage.com.vivo.identifier.IdentifierIdClient.z + org.repackage.com.vivo.identifier.IdentifierIdClient.C + org.repackage.com.vivo.identifier.IdentifierIdClient.v + org.repackage.com.vivo.identifier.IdentifierIdClient.w + org.repackage.com.vivo.identifier.IdentifierIdClient.B + org.repackage.com.vivo.identifier.IdentifierIdClient.C + org.repackage.com.vivo.identifier.IdentifierIdClient.x + org.repackage.com.vivo.identifier.IdentifierIdClient.y + org.repackage.com.vivo.identifier.IdentifierIdClient.D + org.repackage.com.vivo.identifier.IdentifierIdClient.E > 0) {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("oaid", org.repackage.com.vivo.identifier.IdentifierIdClient.this.g(org.repackage.com.vivo.identifier.IdentifierIdClient.t, org.repackage.com.vivo.identifier.IdentifierIdClient.u, org.repackage.com.vivo.identifier.IdentifierIdClient.z, org.repackage.com.vivo.identifier.IdentifierIdClient.A));
                contentValues.put("vaid", org.repackage.com.vivo.identifier.IdentifierIdClient.this.g(org.repackage.com.vivo.identifier.IdentifierIdClient.v, org.repackage.com.vivo.identifier.IdentifierIdClient.w, org.repackage.com.vivo.identifier.IdentifierIdClient.B, org.repackage.com.vivo.identifier.IdentifierIdClient.C));
                contentValues.put("aaid", org.repackage.com.vivo.identifier.IdentifierIdClient.this.g(org.repackage.com.vivo.identifier.IdentifierIdClient.x, org.repackage.com.vivo.identifier.IdentifierIdClient.y, org.repackage.com.vivo.identifier.IdentifierIdClient.D, org.repackage.com.vivo.identifier.IdentifierIdClient.E));
                org.repackage.com.vivo.identifier.IdentifierIdClient.f507s.c(7, com.igexin.assist.util.AssistUtils.BRAND_VIVO, new android.content.ContentValues[]{contentValues});
                int unused = org.repackage.com.vivo.identifier.IdentifierIdClient.t = org.repackage.com.vivo.identifier.IdentifierIdClient.u = org.repackage.com.vivo.identifier.IdentifierIdClient.v = org.repackage.com.vivo.identifier.IdentifierIdClient.w = org.repackage.com.vivo.identifier.IdentifierIdClient.x = org.repackage.com.vivo.identifier.IdentifierIdClient.y = 0;
                int unused2 = org.repackage.com.vivo.identifier.IdentifierIdClient.z = org.repackage.com.vivo.identifier.IdentifierIdClient.A = org.repackage.com.vivo.identifier.IdentifierIdClient.B = org.repackage.com.vivo.identifier.IdentifierIdClient.C = org.repackage.com.vivo.identifier.IdentifierIdClient.D = org.repackage.com.vivo.identifier.IdentifierIdClient.E = 0;
            }
        }
    }

    /* renamed from: org.repackage.com.vivo.identifier.IdentifierIdClient$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.Handler {
        public AnonymousClass2(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 11) {
                int i = message.getData().getInt("type");
                try {
                    java.lang.String a = org.repackage.com.vivo.identifier.IdentifierIdClient.f507s.a(i, message.getData().getString("appid"));
                    if (i == 0) {
                        java.lang.String unused = org.repackage.com.vivo.identifier.IdentifierIdClient.l = a;
                        org.repackage.com.vivo.identifier.IdentifierIdClient.z(8, org.repackage.com.vivo.identifier.IdentifierIdClient.l);
                    } else if (i == 1) {
                        if (a != null) {
                            java.lang.String unused2 = org.repackage.com.vivo.identifier.IdentifierIdClient.m = a;
                        }
                        org.repackage.com.vivo.identifier.IdentifierIdClient.z(9, org.repackage.com.vivo.identifier.IdentifierIdClient.m);
                    } else if (i == 2) {
                        if (a != null) {
                            java.lang.String unused3 = org.repackage.com.vivo.identifier.IdentifierIdClient.n = a;
                        }
                        org.repackage.com.vivo.identifier.IdentifierIdClient.z(10, org.repackage.com.vivo.identifier.IdentifierIdClient.n);
                    } else if (i != 3) {
                        if (i == 4) {
                            java.lang.String unused4 = org.repackage.com.vivo.identifier.IdentifierIdClient.p = a;
                        } else if (i == 5 && a != null) {
                            java.lang.String unused5 = org.repackage.com.vivo.identifier.IdentifierIdClient.q = a;
                        }
                    } else if (a != null) {
                        java.lang.String unused6 = org.repackage.com.vivo.identifier.IdentifierIdClient.o = a;
                    }
                } catch (java.lang.Exception e) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("readException:");
                    sb.append(e.toString());
                }
                synchronized (org.repackage.com.vivo.identifier.IdentifierIdClient.c) {
                    org.repackage.com.vivo.identifier.IdentifierIdClient.c.notify();
                }
            }
        }
    }

    public IdentifierIdClient() {
        d();
        f507s = new org.repackage.com.vivo.identifier.DataBaseOperation(d);
        this.b = w(d);
    }

    public static void d() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("SqlWorkThread");
        j = handlerThread;
        handlerThread.start();
        k = new org.repackage.com.vivo.identifier.IdentifierIdClient.AnonymousClass2(j.getLooper());
    }

    public static void e() {
        e = "1".equals(i(com.alipay.sdk.m.p0.c.c, "0")) || "1".equals(i(a, "0"));
    }

    public static java.lang.String i(java.lang.String str, java.lang.String str2) {
        try {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
                return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, "0");
            } catch (java.lang.Exception e2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("getProperty: invoke is error");
                sb.append(e2.getMessage());
                return str2;
            }
        } catch (java.lang.Throwable unused) {
            return str2;
        }
    }

    public static org.repackage.com.vivo.identifier.IdentifierIdClient k(android.content.Context context) {
        if (d == null) {
            if (context == null) {
                return null;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            d = context;
        }
        if (r == null) {
            synchronized (org.repackage.com.vivo.identifier.IdentifierIdClient.class) {
                if (r == null) {
                    r = new org.repackage.com.vivo.identifier.IdentifierIdClient();
                    r.c();
                }
            }
        }
        return r;
    }

    public static synchronized void m(android.content.Context context, int i2, java.lang.String str) {
        synchronized (org.repackage.com.vivo.identifier.IdentifierIdClient.class) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (i == null) {
                            i = new org.repackage.com.vivo.identifier.IdentifierIdObserver(r, 2, str);
                            context.getContentResolver().registerContentObserver(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, i);
                        }
                    }
                } else if (h == null) {
                    h = new org.repackage.com.vivo.identifier.IdentifierIdObserver(r, 1, str);
                    context.getContentResolver().registerContentObserver(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, h);
                }
            } else if (g == null) {
                g = new org.repackage.com.vivo.identifier.IdentifierIdObserver(r, 0, null);
                context.getContentResolver().registerContentObserver(android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, g);
            }
        }
    }

    public static boolean n() {
        if (!e) {
            e();
        }
        return e;
    }

    public static org.repackage.com.vivo.identifier.IdentifierIdClient t(android.content.Context context) {
        if (n()) {
            return k(context);
        }
        return null;
    }

    public static int w(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void z(int i2, java.lang.String str) {
        if (i2 == 0) {
            if (str == null) {
                u++;
                return;
            } else {
                t++;
            }
        }
        if (i2 == 1) {
            if (str == null) {
                w++;
                return;
            } else {
                v++;
                return;
            }
        }
        if (i2 == 2) {
            if (str == null) {
                y++;
                return;
            } else {
                x++;
                return;
            }
        }
        switch (i2) {
            case 8:
                if (str != null) {
                    z++;
                    break;
                } else {
                    A++;
                    break;
                }
            case 9:
                if (str != null) {
                    B++;
                    break;
                } else {
                    C++;
                    break;
                }
            case 10:
                if (str != null) {
                    D++;
                    break;
                } else {
                    E++;
                    break;
                }
        }
    }

    public java.lang.String B() {
        java.lang.String str = l;
        if (str != null) {
            z(0, str);
            return l;
        }
        D(0, null);
        if (g == null) {
            m(d, 0, null);
        }
        z(0, l);
        return l;
    }

    public final void D(int i2, java.lang.String str) {
        l(i2, str);
    }

    public java.lang.String F() {
        java.lang.String str = m;
        if (str != null) {
            z(1, str);
            return m;
        }
        H(1, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        if (h == null) {
            m(d, 1, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        }
        z(1, m);
        return m;
    }

    public final void H(int i2, java.lang.String str) {
        synchronized (c) {
            l(i2, str);
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            try {
                c.wait(2000L);
            } catch (java.lang.InterruptedException unused) {
            }
            int i3 = ((android.os.SystemClock.uptimeMillis() - uptimeMillis) > 2000L ? 1 : ((android.os.SystemClock.uptimeMillis() - uptimeMillis) == 2000L ? 0 : -1));
        }
    }

    public java.lang.String J() {
        java.lang.String str = m;
        if (str != null) {
            z(1, str);
            return m;
        }
        D(1, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        if (h == null) {
            m(d, 1, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        }
        z(1, m);
        return m;
    }

    public java.lang.String M() {
        java.lang.String str = n;
        if (str != null) {
            z(2, str);
            return n;
        }
        H(2, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        if (i == null) {
            m(d, 2, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        }
        z(2, n);
        return n;
    }

    public java.lang.String O() {
        java.lang.String str = n;
        if (str != null) {
            z(2, str);
            return n;
        }
        D(2, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        if (i == null) {
            m(d, 2, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        }
        z(2, n);
        return n;
    }

    public java.lang.String Q() {
        H(4, null);
        return p;
    }

    public java.lang.String S() {
        java.lang.String str = q;
        if (str != null) {
            return str;
        }
        H(5, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        return q;
    }

    public java.lang.String U() {
        java.lang.String str = q;
        if (str != null) {
            return str;
        }
        D(5, com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        return q;
    }

    public final void c() {
        java.util.concurrent.Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new org.repackage.com.vivo.identifier.IdentifierIdClient.AnonymousClass1(), 600L, 600L, java.util.concurrent.TimeUnit.SECONDS);
    }

    public final java.lang.String g(int i2, int i3, int i4, int i5) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    public void l(int i2, java.lang.String str) {
        android.os.Message obtainMessage = k.obtainMessage();
        obtainMessage.what = 11;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        k.sendMessage(obtainMessage);
    }

    public boolean o(java.util.List<java.lang.String> list) {
        if (this.b >= f && list != null && list.size() != 0) {
            try {
                android.content.ContentValues[] contentValuesArr = new android.content.ContentValues[list.size()];
                java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(java.lang.System.currentTimeMillis()));
                for (int i2 = 0; i2 < list.size(); i2++) {
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    java.lang.String[] split = list.get(i2).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    if (split.length != 2) {
                        return false;
                    }
                    java.lang.String str = split[0];
                    java.lang.String str2 = split[1];
                    contentValues.put("packageName", str);
                    contentValues.put("uid", str2);
                    contentValues.put("value", format);
                    contentValuesArr[i2] = contentValues;
                }
                return f507s.c(6, com.igexin.assist.util.AssistUtils.BRAND_VIVO, contentValuesArr);
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }

    public java.lang.String q() {
        java.lang.String str = o;
        if (str != null) {
            return str;
        }
        H(3, null);
        return o;
    }

    public java.util.List s(java.util.List<java.lang.String> list) {
        if (this.b >= f && list != null && list.size() != 0) {
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    java.lang.String[] split = list.get(i2).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    if (split.length == 2) {
                        arrayList.add(java.lang.Boolean.valueOf(f507s.b(6, com.igexin.assist.util.AssistUtils.BRAND_VIVO, split[0], split[1])));
                    }
                }
                return arrayList;
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public java.lang.String x() {
        java.lang.String str = l;
        if (str != null) {
            z(0, str);
            return l;
        }
        H(0, null);
        if (g == null) {
            m(d, 0, null);
        }
        z(0, l);
        return l;
    }
}
