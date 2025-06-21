package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public class e implements android.app.Application.ActivityLifecycleCallbacks {
    public static final java.lang.String a = "start_time";
    public static final java.lang.String b = "end_time";
    public static final java.lang.String c = "psid";
    public static final java.lang.String d = "launch_mode";
    public static final int e = 0;
    public static final int f = 1;
    long g;
    org.json.JSONObject i;
    private final java.lang.String k = com.anythink.core.common.b.e.class.getName();
    java.lang.Runnable j = new com.anythink.core.common.b.e.AnonymousClass1();
    int h = 0;
    private final android.os.Handler l = com.anythink.core.common.o.b.b.a().a(14);

    /* renamed from: com.anythink.core.common.b.e$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.b.e.a(com.anythink.core.common.b.e.this);
        }
    }

    /* renamed from: com.anythink.core.common.b.e$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ long a;

        public AnonymousClass2(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.b.e.a(com.anythink.core.common.b.e.this, this.a);
        }
    }

    /* renamed from: com.anythink.core.common.b.e$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ long a;

        public AnonymousClass3(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.b.e.b(com.anythink.core.common.b.e.this, this.a);
        }
    }

    public e(long j) {
        this.g = j;
    }

    private void a() {
        if (this.i != null) {
            com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.o.a().o() + "playRecord", "");
            this.g = 0L;
            org.json.JSONObject jSONObject = this.i;
            long optLong = jSONObject.optLong("start_time");
            long optLong2 = jSONObject.optLong("end_time");
            java.lang.String optString = jSONObject.optString(c);
            int optInt = jSONObject.optInt(d);
            this.i = null;
            com.anythink.core.common.n.c.a(optInt == 1 ? 3 : 1, optLong, optLong2, optString);
            long j = (optLong2 - optLong) / 1000;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(long j) {
        long j2;
        this.l.removeCallbacks(this.j);
        com.anythink.core.d.a b2 = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        org.json.JSONObject jSONObject = this.i;
        if (jSONObject != null) {
            long optLong = jSONObject.optLong("start_time");
            long optLong2 = jSONObject.optLong("end_time");
            java.lang.String optString = jSONObject.optString(c);
            int optInt = jSONObject.optInt(d);
            if (java.lang.System.currentTimeMillis() - optLong2 > b2.J()) {
                long j3 = (optLong2 - optLong) / 1000;
                com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.o.a().o() + "playRecord", "");
                com.anythink.core.common.n.c.a(optInt == 1 ? 3 : 1, optLong, optLong2, optString);
                j2 = 0;
                this.g = 0L;
                this.i = null;
                if (this.g != j2) {
                    this.h = 1;
                    try {
                        this.g = com.anythink.core.common.b.o.a().a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.o.a().o(), 1);
                    } catch (java.lang.Exception unused) {
                    }
                } else {
                    java.lang.String o = com.anythink.core.common.b.o.a().o();
                    com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, o + "playRecord", "");
                }
                if (this.g == 0) {
                    this.g = java.lang.System.currentTimeMillis();
                }
                java.lang.System.currentTimeMillis();
            }
        }
        j2 = 0;
        this.i = null;
        if (this.g != j2) {
        }
        if (this.g == 0) {
        }
        java.lang.System.currentTimeMillis();
    }

    public static /* synthetic */ void a(com.anythink.core.common.b.e eVar) {
        if (eVar.i != null) {
            com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.o.a().o() + "playRecord", "");
            eVar.g = 0L;
            org.json.JSONObject jSONObject = eVar.i;
            long optLong = jSONObject.optLong("start_time");
            long optLong2 = jSONObject.optLong("end_time");
            java.lang.String optString = jSONObject.optString(c);
            int optInt = jSONObject.optInt(d);
            eVar.i = null;
            com.anythink.core.common.n.c.a(optInt == 1 ? 3 : 1, optLong, optLong2, optString);
            long j = (optLong2 - optLong) / 1000;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.anythink.core.common.b.e eVar, long j) {
        long j2;
        eVar.l.removeCallbacks(eVar.j);
        com.anythink.core.d.a b2 = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
        org.json.JSONObject jSONObject = eVar.i;
        if (jSONObject != null) {
            long optLong = jSONObject.optLong("start_time");
            long optLong2 = jSONObject.optLong("end_time");
            java.lang.String optString = jSONObject.optString(c);
            int optInt = jSONObject.optInt(d);
            if (java.lang.System.currentTimeMillis() - optLong2 > b2.J()) {
                long j3 = (optLong2 - optLong) / 1000;
                com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, com.anythink.core.common.b.o.a().o() + "playRecord", "");
                com.anythink.core.common.n.c.a(optInt == 1 ? 3 : 1, optLong, optLong2, optString);
                j2 = 0;
                eVar.g = 0L;
                eVar.i = null;
                if (eVar.g != j2) {
                    eVar.h = 1;
                    try {
                        eVar.g = com.anythink.core.common.b.o.a().a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.o.a().o(), 1);
                    } catch (java.lang.Exception unused) {
                    }
                } else {
                    java.lang.String o = com.anythink.core.common.b.o.a().o();
                    com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, o + "playRecord", "");
                }
                if (eVar.g == 0) {
                    eVar.g = java.lang.System.currentTimeMillis();
                }
                java.lang.System.currentTimeMillis();
            }
        }
        j2 = 0;
        eVar.i = null;
        if (eVar.g != j2) {
        }
        if (eVar.g == 0) {
        }
        java.lang.System.currentTimeMillis();
    }

    private void b(long j) {
        java.lang.String o = com.anythink.core.common.b.o.a().o();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(c, com.anythink.core.common.b.o.a().q());
            jSONObject.put("start_time", this.g);
            jSONObject.put("end_time", java.lang.System.currentTimeMillis());
            jSONObject.put(d, this.h);
            this.i = jSONObject;
            com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, o + "playRecord", jSONObject.toString());
            jSONObject.toString();
        } catch (java.lang.Exception unused) {
        }
        if (com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(o).L() == 1) {
            this.l.postDelayed(this.j, r5.J());
        }
        java.lang.System.currentTimeMillis();
    }

    public static /* synthetic */ void b(com.anythink.core.common.b.e eVar, long j) {
        java.lang.String o = com.anythink.core.common.b.o.a().o();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(c, com.anythink.core.common.b.o.a().q());
            jSONObject.put("start_time", eVar.g);
            jSONObject.put("end_time", java.lang.System.currentTimeMillis());
            jSONObject.put(d, eVar.h);
            eVar.i = jSONObject;
            com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.p, o + "playRecord", jSONObject.toString());
            jSONObject.toString();
        } catch (java.lang.Exception unused) {
        }
        if (com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(o).L() == 1) {
            eVar.l.postDelayed(eVar.j, r5.J());
        }
        java.lang.System.currentTimeMillis();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        this.l.post(new com.anythink.core.common.b.e.AnonymousClass3(java.lang.System.currentTimeMillis()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        this.l.post(new com.anythink.core.common.b.e.AnonymousClass2(java.lang.System.currentTimeMillis()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
    }
}
