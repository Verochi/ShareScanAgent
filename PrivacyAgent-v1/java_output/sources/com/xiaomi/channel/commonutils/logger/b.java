package com.xiaomi.channel.commonutils.logger;

/* loaded from: classes19.dex */
public abstract class b {
    private static int a = 2;
    private static android.content.Context b;
    private static boolean c;
    private static boolean d;
    private static java.lang.String e = "XMPush-" + android.os.Process.myPid();
    private static com.xiaomi.channel.commonutils.logger.LoggerInterface f = new com.xiaomi.channel.commonutils.logger.b.a();
    private static final java.util.HashMap<java.lang.Integer, java.lang.Long> g = new java.util.HashMap<>();
    private static final java.util.HashMap<java.lang.Integer, java.lang.String> h = new java.util.HashMap<>();
    private static final java.lang.Integer i = -1;
    private static java.util.concurrent.atomic.AtomicInteger j = new java.util.concurrent.atomic.AtomicInteger(1);

    public static class a implements com.xiaomi.channel.commonutils.logger.LoggerInterface {
        private java.lang.String a = com.xiaomi.channel.commonutils.logger.b.e;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public final void log(java.lang.String str) {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public final void log(java.lang.String str, java.lang.Throwable th) {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public final void setTag(java.lang.String str) {
            this.a = str;
        }
    }

    public static void a() {
        a = 2;
    }

    private static void a(int i2, java.lang.String str) {
        if (i2 >= a) {
            f.log(str);
        }
    }

    public static void a(android.content.Context context) {
        b = context;
        if (com.xiaomi.push.iu.a(context)) {
            c = true;
        }
        if (com.xiaomi.push.iu.a()) {
            d = true;
        }
    }

    public static void a(com.xiaomi.channel.commonutils.logger.LoggerInterface loggerInterface) {
        f = loggerInterface;
    }

    public static void a(java.lang.Integer num) {
        if (a <= 1) {
            java.util.HashMap<java.lang.Integer, java.lang.Long> hashMap = g;
            if (hashMap.containsKey(num)) {
                long longValue = hashMap.remove(num).longValue();
                java.lang.String remove = h.remove(num);
                long currentTimeMillis = java.lang.System.currentTimeMillis() - longValue;
                f.log(remove + " ends in " + currentTimeMillis + " ms");
            }
        }
    }

    public static void a(java.lang.String str) {
        a(2, g(str));
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(d());
        sb.append("[" + str + "] " + str2);
        a(2, sb.toString());
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        java.lang.String g2 = g(str);
        if (4 >= a) {
            f.log(g2, th);
        }
    }

    public static void a(java.lang.Throwable th) {
        if (4 >= a) {
            f.log("", th);
        }
    }

    public static int b() {
        return a;
    }

    public static void b(java.lang.String str) {
        a(0, g(str));
    }

    public static void c(java.lang.String str) {
        a(1, g(str));
    }

    private static java.lang.String d() {
        return "[Tid:" + java.lang.Thread.currentThread().getId() + "] ";
    }

    public static void d(java.lang.String str) {
        a(4, g(str));
    }

    public static java.lang.Integer e(java.lang.String str) {
        if (a > 1) {
            return i;
        }
        java.lang.Integer valueOf = java.lang.Integer.valueOf(j.incrementAndGet());
        g.put(valueOf, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        h.put(valueOf, str);
        f.log(str + " starts");
        return valueOf;
    }

    public static void f(java.lang.String str) {
        if (c) {
            a(str);
            return;
        }
        g(str);
        if (d) {
            return;
        }
        a(str);
    }

    private static java.lang.String g(java.lang.String str) {
        return d() + str;
    }
}
