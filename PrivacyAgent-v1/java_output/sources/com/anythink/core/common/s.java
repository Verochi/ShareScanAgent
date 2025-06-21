package com.anythink.core.common;

/* loaded from: classes12.dex */
public class s {
    public static final java.lang.String a = "s";
    private static volatile com.anythink.core.common.s b;
    private java.util.Map<java.lang.String, com.anythink.core.common.f.ad> c;
    private java.util.List<com.anythink.core.common.f.ad> d;
    private final int f = 5;
    private final int g = 500;
    private java.util.List<java.lang.String> e = java.util.Collections.synchronizedList(new java.util.ArrayList(8));

    /* renamed from: com.anythink.core.common.s$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.h.k {
        final /* synthetic */ com.anythink.core.common.f.ad a;
        final /* synthetic */ boolean b;

        public AnonymousClass1(com.anythink.core.common.f.ad adVar, boolean z) {
            this.a = adVar;
            this.b = z;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            synchronized (com.anythink.core.common.s.this) {
                com.anythink.core.common.s.this.e.remove(this.a.a);
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            java.lang.String str2 = com.anythink.core.common.s.a;
            this.a.a();
            synchronized (com.anythink.core.common.s.this) {
                com.anythink.core.common.s.this.e.remove(this.a.a);
                if (!this.b) {
                    com.anythink.core.common.s.this.b(this.a);
                }
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            java.lang.String str = com.anythink.core.common.s.a;
            this.a.a();
            synchronized (com.anythink.core.common.s.this) {
                com.anythink.core.common.s.this.e.remove(this.a.a);
                if (this.b) {
                    com.anythink.core.common.s.this.a(this.a);
                }
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    private s() {
    }

    public static com.anythink.core.common.s a() {
        if (b == null) {
            synchronized (com.anythink.core.common.s.class) {
                if (b == null) {
                    b = new com.anythink.core.common.s();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.anythink.core.common.f.ad adVar) {
        adVar.a();
        this.c.remove(adVar.a);
        this.d.remove(adVar);
        com.anythink.core.common.c.i.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f())).b(adVar);
    }

    private synchronized void a(com.anythink.core.common.f.ad adVar, boolean z) {
        if (java.lang.System.currentTimeMillis() > adVar.f) {
            adVar.a();
            this.e.remove(adVar.a);
            if (z) {
                a(adVar);
            }
            return;
        }
        if (this.e.contains(adVar.a)) {
            adVar.a();
            return;
        }
        this.e.add(adVar.a);
        if (z) {
            int i = adVar.g + 1;
            adVar.g = i;
            if (i >= 5) {
                adVar.a();
                a(adVar);
            } else {
                b(adVar);
            }
        } else {
            int i2 = adVar.g + 1;
            adVar.g = i2;
            if (i2 >= 5) {
                adVar.a();
                this.e.remove(adVar.a);
                return;
            }
        }
        adVar.a();
        new com.anythink.core.common.h.m(adVar).a(0, (com.anythink.core.common.h.k) new com.anythink.core.common.s.AnonymousClass1(adVar, z));
    }

    public static boolean a(int i) {
        boolean z;
        switch (i) {
            case com.anythink.core.common.h.i.d /* -1003 */:
            case com.anythink.core.common.h.i.c /* -1002 */:
            case com.anythink.core.common.h.i.b /* -1001 */:
            case -1000:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z || ((i < -99 || i >= 200) && i < 400)) {
            return z;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.anythink.core.common.f.ad adVar) {
        if (android.text.TextUtils.isEmpty(adVar.a)) {
            adVar.e = java.lang.System.currentTimeMillis();
            java.lang.String a2 = com.anythink.core.common.o.g.a(adVar.d + adVar.e);
            adVar.a = a2;
            this.c.put(a2, adVar);
            this.d.add(adVar);
        }
        adVar.a();
        com.anythink.core.common.c.i.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f())).a(adVar);
        if (this.d.size() > 500) {
            com.anythink.core.common.f.ad adVar2 = this.d.get(0);
            adVar.a();
            this.e.remove(adVar.a);
            a(adVar2);
        }
    }

    private synchronized void c() {
        try {
            if (this.c == null && this.d == null) {
                com.anythink.core.common.c.i.a c = com.anythink.core.common.c.i.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f())).c();
                this.c = c.b;
                this.d = c.a;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (this.c == null) {
            this.c = new java.util.concurrent.ConcurrentHashMap();
        }
        if (this.d == null) {
            this.d = java.util.Collections.synchronizedList(new java.util.ArrayList());
        }
    }

    public final synchronized void a(java.lang.String str, java.lang.String str2, long j) {
        com.anythink.core.common.f.ad adVar = new com.anythink.core.common.f.ad();
        adVar.b = 2;
        adVar.d = str;
        adVar.c = str2;
        adVar.f = j;
        adVar.a();
        a(adVar, false);
    }

    public final synchronized void b() {
        try {
            c();
            java.util.List<com.anythink.core.common.f.ad> synchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList(this.d));
            if (synchronizedList != null && synchronizedList.size() > 0) {
                for (com.anythink.core.common.f.ad adVar : synchronizedList) {
                    adVar.a();
                    a(adVar, true);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
