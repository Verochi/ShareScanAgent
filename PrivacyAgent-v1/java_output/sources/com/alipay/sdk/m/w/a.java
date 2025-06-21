package com.alipay.sdk.m.w;

/* loaded from: classes.dex */
public class a {
    public static final java.lang.String a = "CDT";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.util.Pair<java.lang.Long, ?>> g;
    public static java.util.concurrent.ExecutorService h = java.util.concurrent.Executors.newFixedThreadPool(16);

    /* renamed from: com.alipay.sdk.m.w.a$a, reason: collision with other inner class name */
    public interface InterfaceC0045a<T, R> {
        R a(T t);
    }

    public static android.content.Context a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static android.util.Pair<java.lang.Boolean, ?> a(int i, java.util.concurrent.TimeUnit timeUnit, long j) {
        android.util.Pair<java.lang.Long, ?> pair;
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.util.Pair<java.lang.Long, ?>> concurrentHashMap = g;
        if (concurrentHashMap != null && (pair = concurrentHashMap.get(java.lang.Integer.valueOf(i))) != null) {
            java.lang.Long l = (java.lang.Long) pair.first;
            return (l == null || android.os.SystemClock.elapsedRealtime() - l.longValue() > java.util.concurrent.TimeUnit.MILLISECONDS.convert(j, timeUnit)) ? new android.util.Pair<>(java.lang.Boolean.FALSE, null) : new android.util.Pair<>(java.lang.Boolean.TRUE, pair.second);
        }
        return new android.util.Pair<>(java.lang.Boolean.FALSE, null);
    }

    public static <T> T a(int i, long j, java.util.concurrent.TimeUnit timeUnit, com.alipay.sdk.m.w.a.InterfaceC0045a<java.lang.Object, java.lang.Boolean> interfaceC0045a, java.util.concurrent.Callable<T> callable, boolean z, long j2, java.util.concurrent.TimeUnit timeUnit2, com.alipay.sdk.m.s.a aVar, boolean z2) {
        T call;
        try {
            android.util.Pair<java.lang.Boolean, ?> a2 = a(i, timeUnit, j);
            if (((java.lang.Boolean) a2.first).booleanValue() && interfaceC0045a.a(a2.second).booleanValue()) {
                com.alipay.sdk.m.u.e.d("getC", i + " got " + a2.second);
                return (T) a2.second;
            }
            if (z2 && com.alipay.sdk.m.u.n.h()) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "ch_get_main", "" + i);
                com.alipay.sdk.m.u.e.d("getC", i + " skip");
                call = null;
            } else {
                call = z ? h.submit(callable).get(j2, timeUnit2) : callable.call();
                a(i, call);
            }
            com.alipay.sdk.m.u.e.d("getC", i + " new " + call);
            return call;
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(a, "ch_get_e|" + i, th);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ch_get_e|" + i, th);
            com.alipay.sdk.m.u.e.d("getC", i + " err");
            return null;
        }
    }

    public static synchronized void a() {
        synchronized (com.alipay.sdk.m.w.a.class) {
            g = null;
        }
    }

    public static synchronized void a(int i, java.lang.Object obj) {
        synchronized (com.alipay.sdk.m.w.a.class) {
            if (g == null) {
                g = new java.util.concurrent.ConcurrentHashMap<>();
            }
            g.put(java.lang.Integer.valueOf(i), new android.util.Pair<>(java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), obj));
        }
    }
}
