package com.meizu.cloud.pushsdk.d.e;

/* loaded from: classes23.dex */
public class b {
    private static final java.lang.String a = "b";
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private int e;
    private final java.lang.String f = "SQLITE";
    private final java.util.concurrent.atomic.AtomicBoolean g = new java.util.concurrent.atomic.AtomicBoolean(false);
    private long h;
    private final long i;
    private final long j;
    private final android.content.Context k;

    public b(long j, long j2, java.util.concurrent.TimeUnit timeUnit, android.content.Context context) {
        this.c = null;
        this.e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        java.util.Map f = f();
        if (f != null) {
            try {
                java.lang.String obj = f.get("userId").toString();
                java.lang.String obj2 = f.get("sessionId").toString();
                int intValue = ((java.lang.Integer) f.get("sessionIndex")).intValue();
                this.b = obj;
                this.e = intValue;
                this.c = obj2;
            } catch (java.lang.Exception e) {
                com.meizu.cloud.pushsdk.d.f.c.a(a, "Exception occurred retrieving session info from file: %s", e.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.d.f.c.c(a, "Tracker Session Object created.", new java.lang.Object[0]);
        }
        this.b = com.meizu.cloud.pushsdk.d.f.e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Tracker Session Object created.", new java.lang.Object[0]);
    }

    private void d() {
        this.d = this.c;
        this.c = com.meizu.cloud.pushsdk.d.f.e.b();
        this.e++;
        java.lang.String str = a;
        com.meizu.cloud.pushsdk.d.f.c.b(str, "Session information is updated:", new java.lang.Object[0]);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Session ID: %s", this.c);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Previous Session ID: %s", this.d);
        com.meizu.cloud.pushsdk.d.f.c.b(str, " + Session Index: %s", java.lang.Integer.valueOf(this.e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private java.util.Map f() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.h = java.lang.System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.d.a.b a() {
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Getting session context...", new java.lang.Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.d.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.d.f.c.b(a, "Checking and updating session information.", new java.lang.Object[0]);
        if (com.meizu.cloud.pushsdk.d.f.e.a(this.h, java.lang.System.currentTimeMillis(), this.g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public java.util.Map c() {
        java.util.HashMap hashMap = new java.util.HashMap(8);
        hashMap.put("userId", this.b);
        hashMap.put("sessionId", this.c);
        hashMap.put("previousSessionId", this.d);
        hashMap.put("sessionIndex", java.lang.Integer.valueOf(this.e));
        hashMap.put("storageMechanism", "SQLITE");
        return hashMap;
    }
}
