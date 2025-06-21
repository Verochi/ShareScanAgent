package com.umeng.analytics.process;

/* loaded from: classes19.dex */
class c {
    private static com.umeng.analytics.process.c a;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.umeng.analytics.process.c.a> b = new java.util.concurrent.ConcurrentHashMap<>();
    private android.content.Context c;

    public static class a {
        private java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger();
        private android.database.sqlite.SQLiteOpenHelper b;
        private android.database.sqlite.SQLiteDatabase c;

        private a() {
        }

        public static com.umeng.analytics.process.c.a a(android.content.Context context, java.lang.String str) {
            android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(context);
            com.umeng.analytics.process.c.a aVar = new com.umeng.analytics.process.c.a();
            aVar.b = com.umeng.analytics.process.b.a(appContext, str);
            return aVar;
        }

        public synchronized android.database.sqlite.SQLiteDatabase a() {
            if (this.a.incrementAndGet() == 1) {
                this.c = this.b.getWritableDatabase();
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

    private c() {
    }

    public static com.umeng.analytics.process.c a(android.content.Context context) {
        if (a == null) {
            synchronized (com.umeng.analytics.process.c.class) {
                if (a == null) {
                    a = new com.umeng.analytics.process.c();
                }
            }
        }
        com.umeng.analytics.process.c cVar = a;
        cVar.c = context;
        return cVar;
    }

    private com.umeng.analytics.process.c.a c(java.lang.String str) {
        if (this.b.get(str) != null) {
            return this.b.get(str);
        }
        com.umeng.analytics.process.c.a a2 = com.umeng.analytics.process.c.a.a(this.c, str);
        this.b.put(str, a2);
        return a2;
    }

    public synchronized android.database.sqlite.SQLiteDatabase a(java.lang.String str) {
        return c(str).a();
    }

    public synchronized void b(java.lang.String str) {
        c(str).b();
    }
}
