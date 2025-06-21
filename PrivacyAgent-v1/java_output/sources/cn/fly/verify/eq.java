package cn.fly.verify;

/* loaded from: classes.dex */
public class eq implements java.lang.Thread.UncaughtExceptionHandler {
    private static java.lang.Thread.UncaughtExceptionHandler a;
    private static volatile boolean b;
    private static volatile boolean c;

    private eq() {
    }

    public static synchronized void a() {
        synchronized (cn.fly.verify.eq.class) {
            if (!b && cn.fly.verify.ds.h && !c) {
                c = true;
                a = java.lang.Thread.getDefaultUncaughtExceptionHandler();
                java.lang.Thread.setDefaultUncaughtExceptionHandler(new cn.fly.verify.eq());
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        try {
            cn.fly.verify.ed.a().a("UE handled, processing...", new java.lang.Object[0]);
            cn.fly.verify.ed.a().d(th);
            java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = a;
            if (uncaughtExceptionHandler == null || (uncaughtExceptionHandler instanceof cn.fly.verify.eq)) {
            }
        } catch (java.lang.Throwable th2) {
            try {
                cn.fly.verify.ed.a().a(th2);
            } finally {
                java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = a;
                if (uncaughtExceptionHandler2 != null && !(uncaughtExceptionHandler2 instanceof cn.fly.verify.eq)) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
