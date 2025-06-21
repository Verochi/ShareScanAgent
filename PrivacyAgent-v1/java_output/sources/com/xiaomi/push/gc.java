package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gc {
    private static com.xiaomi.push.p a = new com.xiaomi.push.p(true);
    private static volatile int b = -1;
    private static long c = java.lang.System.currentTimeMillis();
    private static final java.lang.Object d = new java.lang.Object();
    private static java.util.List<com.xiaomi.push.gc.a> e = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private static java.lang.String f = "";
    private static com.xiaomi.push.a.a g = null;

    public static class a {
        public java.lang.String a;
        public long b;
        public int c;
        public int d;
        public java.lang.String e;
        public long f;

        public a(java.lang.String str, long j, int i, int i2, java.lang.String str2, long j2) {
            this.a = str;
            this.b = j;
            this.c = i;
            this.d = i2;
            this.e = str2;
            this.f = j2;
        }
    }

    public static int a(java.lang.String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (java.io.UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    public static void a(android.content.Context context) {
        b = c(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[LOOP:0: B:26:0x0078->B:51:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(android.content.Context context, java.lang.String str, long j, boolean z, boolean z2, long j2) {
        long j3;
        int b2;
        boolean isEmpty;
        boolean z3;
        int b3 = b(context);
        if (z && z2) {
            long j4 = c;
            c = j2;
            if (j2 - j4 > 30000 && j > 1024) {
                j3 = 2 * j;
                long j5 = j3;
                if (context != null || android.text.TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (b2 = b(context))) {
                    return;
                }
                synchronized (d) {
                    isEmpty = e.isEmpty();
                    com.xiaomi.push.gc.a aVar = new com.xiaomi.push.gc.a(str, j2, b2, z ? 1 : 0, b2 == 0 ? c() : "", j5);
                    java.util.Iterator<com.xiaomi.push.gc.a> it = e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            e.add(aVar);
                            break;
                        }
                        com.xiaomi.push.gc.a next = it.next();
                        if (android.text.TextUtils.equals(aVar.a, next.a) && android.text.TextUtils.equals(aVar.e, next.e) && aVar.c == next.c && aVar.d == next.d && java.lang.Math.abs(aVar.b - next.b) <= 5000) {
                            z3 = true;
                            if (!z3) {
                                next.f += aVar.f;
                                break;
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                }
                if (isEmpty) {
                    a.a(new com.xiaomi.push.gd(context), 5000L);
                    return;
                }
                return;
            }
        }
        j3 = ((b3 == 0 ? 13 : 11) * j) / 10;
        long j52 = j3;
        if (context != null) {
        }
    }

    public static /* synthetic */ void a(android.content.Context context, java.util.List list) {
        try {
            synchronized (com.xiaomi.push.a.a.a) {
                com.xiaomi.push.a.a aVar = g;
                if (aVar == null) {
                    aVar = new com.xiaomi.push.a.a(context);
                    g = aVar;
                }
                android.database.sqlite.SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    java.util.Iterator it = list.iterator();
                    while (it.hasNext()) {
                        com.xiaomi.push.gc.a aVar2 = (com.xiaomi.push.gc.a) it.next();
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        contentValues.put("package_name", aVar2.a);
                        contentValues.put("message_ts", java.lang.Long.valueOf(aVar2.b));
                        contentValues.put("network_type", java.lang.Integer.valueOf(aVar2.c));
                        contentValues.put("bytes", java.lang.Long.valueOf(aVar2.f));
                        contentValues.put("rcv", java.lang.Integer.valueOf(aVar2.d));
                        contentValues.put("imsi", aVar2.e);
                        writableDatabase.insert(com.umeng.analytics.pro.f.F, null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static int b(android.content.Context context) {
        if (b == -1) {
            b = c(context);
        }
        return b;
    }

    private static int c(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    private static synchronized java.lang.String c() {
        synchronized (com.xiaomi.push.gc.class) {
            if (android.text.TextUtils.isEmpty(f)) {
                return "";
            }
            return f;
        }
    }
}
