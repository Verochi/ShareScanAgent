package com.umeng.ccg;

/* loaded from: classes19.dex */
public class b {
    private static volatile boolean a = true;
    private static volatile boolean b = true;
    private static volatile boolean c = true;
    private static volatile boolean d = true;
    private static volatile boolean e = true;
    private static java.util.Map<java.lang.String, java.lang.Boolean> g = new java.util.HashMap();
    private static java.lang.Object f = new java.lang.Object();

    public static void a(boolean z) {
        synchronized (f) {
            d = z;
            g.put(com.umeng.ccg.a.e, java.lang.Boolean.valueOf(z));
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (f) {
            z = a;
        }
        return z;
    }

    public static boolean a(java.lang.String str) {
        boolean booleanValue;
        synchronized (f) {
            booleanValue = g.containsKey(str) ? g.get(str).booleanValue() : true;
        }
        return booleanValue;
    }

    public static void b(boolean z) {
        synchronized (f) {
            e = z;
            g.put(com.umeng.ccg.a.i, java.lang.Boolean.valueOf(z));
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f) {
            z = b;
        }
        return z;
    }

    public static boolean c() {
        boolean z;
        synchronized (f) {
            z = c;
        }
        return z;
    }

    public static boolean d() {
        boolean z;
        synchronized (f) {
            z = d;
        }
        return z;
    }
}
