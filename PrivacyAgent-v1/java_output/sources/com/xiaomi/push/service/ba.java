package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ba implements com.xiaomi.push.service.v {
    private static volatile com.xiaomi.push.service.ba f;
    android.content.Context a;
    private android.content.SharedPreferences b;
    private long c;
    private volatile boolean d = false;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.xiaomi.push.service.ba.a> e = new java.util.concurrent.ConcurrentHashMap<>();

    public static abstract class a implements java.lang.Runnable {
        java.lang.String c;
        long d = 172800;

        public a(java.lang.String str) {
            this.c = str;
        }

        public abstract void a(com.xiaomi.push.service.ba baVar);

        @Override // java.lang.Runnable
        public void run() {
            if (com.xiaomi.push.service.ba.f == null || !com.xiaomi.push.ai.c(com.xiaomi.push.service.ba.f.a)) {
                return;
            }
            if (java.lang.System.currentTimeMillis() - com.xiaomi.push.service.ba.f.b.getLong(":ts-" + this.c, 0L) > this.d || com.xiaomi.push.j.a()) {
                com.xiaomi.push.service.ba.f.b.edit().putLong(":ts-" + this.c, java.lang.System.currentTimeMillis()).apply();
                a(com.xiaomi.push.service.ba.f);
            }
        }
    }

    private ba(android.content.Context context) {
        this.a = context.getApplicationContext();
        this.b = context.getSharedPreferences("sync", 0);
    }

    public static com.xiaomi.push.service.ba a(android.content.Context context) {
        if (f == null) {
            synchronized (com.xiaomi.push.service.ba.class) {
                if (f == null) {
                    f = new com.xiaomi.push.service.ba(context);
                }
            }
        }
        return f;
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        f.b.edit().putString(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2, str3).apply();
    }

    public static /* synthetic */ boolean b(com.xiaomi.push.service.ba baVar) {
        baVar.d = false;
        return false;
    }

    public final java.lang.String a(java.lang.String str, java.lang.String str2) {
        return this.b.getString(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2, "");
    }

    @Override // com.xiaomi.push.service.v
    public final void a() {
        if (this.d) {
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.c < 3600000) {
            return;
        }
        this.c = currentTimeMillis;
        this.d = true;
        com.xiaomi.push.m.a(this.a).a(new com.xiaomi.push.service.bb(this), (int) (java.lang.Math.random() * 10.0d));
    }

    public final void a(com.xiaomi.push.service.ba.a aVar) {
        if (this.e.putIfAbsent(aVar.c, aVar) == null) {
            com.xiaomi.push.m.a(this.a).a(aVar, ((int) (java.lang.Math.random() * 30.0d)) + 10);
        }
    }
}
