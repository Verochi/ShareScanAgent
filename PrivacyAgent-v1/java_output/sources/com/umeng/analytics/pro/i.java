package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
class i {
    private static android.database.sqlite.SQLiteOpenHelper b;
    private static android.content.Context d;
    private java.util.concurrent.atomic.AtomicInteger a;
    private android.database.sqlite.SQLiteDatabase c;

    public static class a {
        private static final com.umeng.analytics.pro.i a = new com.umeng.analytics.pro.i(null);

        private a() {
        }
    }

    private i() {
        this.a = new java.util.concurrent.atomic.AtomicInteger();
    }

    public /* synthetic */ i(com.umeng.analytics.pro.i.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.pro.i a(android.content.Context context) {
        if (d == null && context != null) {
            android.content.Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = com.umeng.analytics.pro.h.a(applicationContext);
        }
        return com.umeng.analytics.pro.i.a.a;
    }

    public synchronized android.database.sqlite.SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.c = b.getWritableDatabase();
        }
        return this.c;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
