package com.xiaomi.a.b;

/* loaded from: classes19.dex */
public class b {
    private static final int i;
    private static volatile com.xiaomi.a.b.b j;
    public java.util.concurrent.ExecutorService a = java.util.concurrent.Executors.newSingleThreadExecutor();
    java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, com.xiaomi.a.a.d>> b = new java.util.HashMap<>();
    java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.a.a.d>> c = new java.util.HashMap<>();
    public android.content.Context d;
    public com.xiaomi.a.a.a e;
    public java.lang.String f;
    public com.xiaomi.a.c.a g;
    public com.xiaomi.a.c.b h;

    static {
        i = com.xiaomi.push.iu.a() ? 30 : 10;
    }

    private b(android.content.Context context) {
        this.d = context;
    }

    public static com.xiaomi.a.b.b a(android.content.Context context) {
        if (j == null) {
            synchronized (com.xiaomi.a.b.b.class) {
                if (j == null) {
                    j = new com.xiaomi.a.b.b(context);
                }
            }
        }
        return j;
    }

    public static /* synthetic */ void a(com.xiaomi.a.b.b bVar, com.xiaomi.a.a.b bVar2) {
        com.xiaomi.a.c.a aVar = bVar.g;
        if (aVar != null) {
            aVar.a(bVar2);
            if (bVar.f() < 10) {
                bVar.a(new com.xiaomi.a.b.e(bVar), i);
            } else {
                bVar.d();
                com.xiaomi.push.m.a(bVar.d).a("100888");
            }
        }
    }

    public static /* synthetic */ void a(com.xiaomi.a.b.b bVar, com.xiaomi.a.a.c cVar) {
        com.xiaomi.a.c.b bVar2 = bVar.h;
        if (bVar2 != null) {
            bVar2.a(cVar);
            if (bVar.g() < 10) {
                bVar.a(new com.xiaomi.a.b.g(bVar), i);
            } else {
                bVar.e();
                com.xiaomi.push.m.a(bVar.d).a("100889");
            }
        }
    }

    private void a(com.xiaomi.push.m.a aVar, int i2) {
        com.xiaomi.push.m.a(this.d).a(aVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.g.b();
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.h.b();
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.a.a.d>> hashMap = this.c;
        if (hashMap == null) {
            return 0;
        }
        java.util.Iterator<java.lang.String> it = hashMap.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            java.util.ArrayList<com.xiaomi.a.a.d> arrayList = this.c.get(it.next());
            i2 += arrayList != null ? arrayList.size() : 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, com.xiaomi.a.a.d>> hashMap = this.b;
        int i2 = 0;
        if (hashMap != null) {
            java.util.Iterator<java.lang.String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                java.util.HashMap<java.lang.String, com.xiaomi.a.a.d> hashMap2 = this.b.get(it.next());
                if (hashMap2 != null) {
                    java.util.Iterator<java.lang.String> it2 = hashMap2.keySet().iterator();
                    while (it2.hasNext()) {
                        com.xiaomi.a.a.d dVar = hashMap2.get(it2.next());
                        if (dVar instanceof com.xiaomi.a.a.c) {
                            i2 = (int) (i2 + ((com.xiaomi.a.a.c) dVar).b);
                        }
                    }
                }
            }
        }
        return i2;
    }

    public final synchronized com.xiaomi.a.a.a a() {
        if (this.e == null) {
            android.content.Context context = this.d;
            com.xiaomi.a.a.a.C0531a a = new com.xiaomi.a.a.a.C0531a().a(true);
            a.d = com.xiaomi.push.as.a(context);
            a.e = 1048576L;
            com.xiaomi.a.a.a.C0531a b = a.b(false);
            b.f = com.anythink.expressad.d.a.b.aT;
            com.xiaomi.a.a.a.C0531a c = b.c(false);
            c.g = com.anythink.expressad.d.a.b.aT;
            this.e = c.a(context);
        }
        return this.e;
    }

    public final com.xiaomi.a.a.b a(java.lang.String str) {
        com.xiaomi.a.a.b bVar = new com.xiaomi.a.a.b();
        bVar.d = str;
        bVar.c = java.lang.System.currentTimeMillis();
        bVar.b = 5001;
        bVar.a = com.xiaomi.push.ao.a(6);
        bVar.e = 1000;
        bVar.g = 1001;
        bVar.f = "E100004";
        bVar.h = this.d.getPackageName();
        bVar.i = this.f;
        return bVar;
    }

    public final void b() {
        if (a(this.d).a().b) {
            com.xiaomi.push.ap apVar = new com.xiaomi.push.ap(this.d);
            int i2 = (int) a(this.d).a().e;
            if (i2 < 1800) {
                i2 = 1800;
            }
            if (java.lang.System.currentTimeMillis() - com.xiaomi.push.av.a(this.d).a("sp_client_report_status", "event_last_upload_time") > i2 * 1000) {
                com.xiaomi.push.m.a(this.d).a(new com.xiaomi.a.b.i(this, apVar), 10);
            }
            synchronized (com.xiaomi.a.b.b.class) {
                if (!com.xiaomi.push.m.a(this.d).a(apVar, i2, 0)) {
                    com.xiaomi.push.m.a(this.d).a("100886");
                    com.xiaomi.push.m.a(this.d).a(apVar, i2, 0);
                }
            }
        }
    }

    public final void c() {
        if (a(this.d).a().c) {
            com.xiaomi.push.aq aqVar = new com.xiaomi.push.aq(this.d);
            int i2 = (int) a(this.d).a().f;
            if (i2 < 1800) {
                i2 = 1800;
            }
            if (java.lang.System.currentTimeMillis() - com.xiaomi.push.av.a(this.d).a("sp_client_report_status", "perf_last_upload_time") > i2 * 1000) {
                com.xiaomi.push.m.a(this.d).a(new com.xiaomi.a.b.j(this, aqVar), 15);
            }
            synchronized (com.xiaomi.a.b.b.class) {
                if (!com.xiaomi.push.m.a(this.d).a(aqVar, i2, 0)) {
                    com.xiaomi.push.m.a(this.d).a("100887");
                    com.xiaomi.push.m.a(this.d).a(aqVar, i2, 0);
                }
            }
        }
    }
}
