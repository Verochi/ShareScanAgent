package com.sijla.b;

/* loaded from: classes19.dex */
public final class d {
    public static java.lang.String a;
    private static boolean b;
    private static boolean c;
    private static final com.sijla.b.d.a d = new com.sijla.b.d.a((byte) 0);

    public static class a {
        public long a;

        private a() {
            this.a = java.lang.System.currentTimeMillis();
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static synchronized void a(android.app.Application application) {
        synchronized (com.sijla.b.d.class) {
            if (b) {
                return;
            }
            try {
                b = true;
                com.sijla.b.a.a(application);
                d.a = java.lang.System.currentTimeMillis();
                application.registerActivityLifecycleCallbacks(new com.sijla.b.e(application));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static /* synthetic */ boolean b() {
        c = true;
        return true;
    }
}
