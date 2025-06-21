package com.uc.crashsdk.a;

/* loaded from: classes19.dex */
public class f {
    static final /* synthetic */ boolean a = true;
    private static volatile android.os.HandlerThread b;
    private static volatile android.os.HandlerThread c;
    private static volatile android.os.HandlerThread d;
    private static android.os.Handler e;
    private static android.os.Handler f;
    private static android.os.Handler g;
    private static android.os.Handler h;
    private static final java.util.HashMap<java.lang.Object, java.lang.Object[]> i = new java.util.HashMap<>();

    public static android.os.Handler a(int i2) {
        if (i2 == 0) {
            if (b == null) {
                a();
            }
            return e;
        }
        if (i2 == 1) {
            if (c == null) {
                b();
            }
            return f;
        }
        if (i2 == 2) {
            if (g == null) {
                g = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            return g;
        }
        if (i2 == 3) {
            if (h == null) {
                c();
            }
            return h;
        }
        throw new java.lang.RuntimeException("unknown thread type: " + i2);
    }

    private static synchronized void a() {
        synchronized (com.uc.crashsdk.a.f.class) {
            if (b == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("CrashSDKBkgdHandler", 10);
                b = handlerThread;
                handlerThread.start();
                e = new android.os.Handler(b.getLooper());
            }
        }
    }

    public static void a(int i2, java.lang.Object[] objArr) {
        if (i2 != 10) {
            if (!a) {
                throw new java.lang.AssertionError();
            }
        } else {
            if (!a && objArr == null) {
                throw new java.lang.AssertionError();
            }
            java.lang.Runnable runnable = (java.lang.Runnable) objArr[0];
            java.util.HashMap<java.lang.Object, java.lang.Object[]> hashMap = i;
            synchronized (hashMap) {
                if (hashMap.get(runnable) != null) {
                    hashMap.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    public static void a(java.lang.Runnable runnable) {
        java.lang.Object[] objArr;
        if (runnable == null) {
            return;
        }
        java.util.HashMap<java.lang.Object, java.lang.Object[]> hashMap = i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int intValue = ((java.lang.Integer) objArr[1]).intValue();
        android.os.Handler handler = intValue != 0 ? intValue != 1 ? intValue != 2 ? null : g : f : e;
        if (handler != null) {
            handler.removeCallbacks((java.lang.Runnable) objArr[0]);
        }
        synchronized (hashMap) {
            if (hashMap.get(runnable) != null) {
                hashMap.remove(runnable);
            }
        }
    }

    public static boolean a(int i2, java.lang.Runnable runnable) {
        return a(i2, runnable, 0L);
    }

    public static boolean a(int i2, java.lang.Runnable runnable, long j) {
        android.os.Handler a2;
        if (runnable == null || (a2 = a(i2)) == null) {
            return false;
        }
        com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(10, new java.lang.Object[]{runnable});
        java.util.HashMap<java.lang.Object, java.lang.Object[]> hashMap = i;
        synchronized (hashMap) {
            hashMap.put(runnable, new java.lang.Object[]{eVar, java.lang.Integer.valueOf(i2)});
        }
        return a2.postDelayed(eVar, j);
    }

    private static synchronized void b() {
        synchronized (com.uc.crashsdk.a.f.class) {
            if (c == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("CrashSDKNormalHandler", 0);
                c = handlerThread;
                handlerThread.start();
                f = new android.os.Handler(c.getLooper());
            }
        }
    }

    public static boolean b(java.lang.Runnable runnable) {
        java.lang.Object[] objArr;
        if (runnable == null) {
            return false;
        }
        java.util.HashMap<java.lang.Object, java.lang.Object[]> hashMap = i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void c() {
        synchronized (com.uc.crashsdk.a.f.class) {
            if (d == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("CrashSDKAnrHandler", 0);
                d = handlerThread;
                handlerThread.start();
                h = new android.os.Handler(d.getLooper());
            }
        }
    }
}
