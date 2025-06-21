package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public class r {
    private static volatile com.anythink.core.common.b.r d;
    android.content.Context b;
    int c;
    final int a = -100;
    private java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> e = new java.util.concurrent.ConcurrentHashMap<>(5);

    /* renamed from: com.anythink.core.common.b.r$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATGDPRAuthCallback a;
        final /* synthetic */ android.content.Context b;

        public AnonymousClass1(com.anythink.core.api.ATGDPRAuthCallback aTGDPRAuthCallback, android.content.Context context) {
            this.a = aTGDPRAuthCallback;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.activity.ATGdprAuthActivity.mCallback = this.a;
            android.content.Intent intent = new android.content.Intent(this.b, (java.lang.Class<?>) com.anythink.core.activity.ATGdprAuthActivity.class);
            intent.setFlags(268435456);
            this.b.startActivity(intent);
        }
    }

    /* renamed from: com.anythink.core.common.b.r$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.h.k {
        final /* synthetic */ com.anythink.core.api.NetTrafficeCallback a;

        public AnonymousClass2(com.anythink.core.api.NetTrafficeCallback netTrafficeCallback) {
            this.a = netTrafficeCallback;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            com.anythink.core.api.NetTrafficeCallback netTrafficeCallback = this.a;
            if (netTrafficeCallback != null) {
                netTrafficeCallback.onErrorCallback(adError.printStackTrace());
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            try {
                if (!(obj instanceof org.json.JSONObject)) {
                    com.anythink.core.api.NetTrafficeCallback netTrafficeCallback = this.a;
                    if (netTrafficeCallback != null) {
                        netTrafficeCallback.onErrorCallback("There is no result.");
                        return;
                    }
                    return;
                }
                org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
                if (!jSONObject.has("is_eu")) {
                    com.anythink.core.api.NetTrafficeCallback netTrafficeCallback2 = this.a;
                    if (netTrafficeCallback2 != null) {
                        netTrafficeCallback2.onErrorCallback("There is no result.");
                        return;
                    }
                    return;
                }
                if (jSONObject.optInt("is_eu") == 1) {
                    com.anythink.core.api.NetTrafficeCallback netTrafficeCallback3 = this.a;
                    if (netTrafficeCallback3 != null) {
                        netTrafficeCallback3.onResultCallback(true);
                        return;
                    }
                    return;
                }
                com.anythink.core.api.NetTrafficeCallback netTrafficeCallback4 = this.a;
                if (netTrafficeCallback4 != null) {
                    netTrafficeCallback4.onResultCallback(false);
                }
            } catch (java.lang.Throwable unused) {
                com.anythink.core.api.NetTrafficeCallback netTrafficeCallback5 = this.a;
                if (netTrafficeCallback5 != null) {
                    netTrafficeCallback5.onErrorCallback("Internal error");
                }
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.core.common.b.r$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.core.common.b.r.this.c(this.a)) {
                return;
            }
            com.anythink.core.common.b.r a = com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f());
            com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
            if (a.c == 2 && b.ae() == 1 && b.Q() == 0) {
                com.anythink.core.common.n.c.a(1, a.c, b.ae(), this.a);
            }
            if (a.c == 1 && b.ac() == 0 && b.ae() == 0) {
                com.anythink.core.common.n.c.a(2, a.c, b.ae(), this.a);
            }
            com.anythink.core.common.b.r.this.e.put(java.lang.Integer.valueOf(this.a), java.lang.Boolean.TRUE);
        }
    }

    private r(android.content.Context context) {
        this.c = 2;
        if (context != null) {
            this.b = context.getApplicationContext();
        }
        this.c = com.anythink.core.common.o.r.b(this.b, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.f, 2);
    }

    public static com.anythink.core.common.b.r a(android.content.Context context) {
        if (d == null) {
            synchronized (com.anythink.core.common.b.r.class) {
                if (d == null) {
                    d = new com.anythink.core.common.b.r(context);
                }
            }
        }
        return d;
    }

    public final int a() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
        com.anythink.core.common.o.r.a(this.b, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.f, i);
    }

    public final void a(android.content.Context context, com.anythink.core.api.ATGDPRAuthCallback aTGDPRAuthCallback) {
        com.anythink.core.common.b.o.a().b(new com.anythink.core.common.b.r.AnonymousClass1(aTGDPRAuthCallback, context));
    }

    public final void a(com.anythink.core.api.NetTrafficeCallback netTrafficeCallback) {
        int b = com.anythink.core.common.o.r.b(this.b, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.l, -100);
        if (b == -100) {
            new com.anythink.core.common.h.j().a(0, (com.anythink.core.common.h.k) new com.anythink.core.common.b.r.AnonymousClass2(netTrafficeCallback));
            return;
        }
        if (b == 1) {
            if (netTrafficeCallback != null) {
                netTrafficeCallback.onResultCallback(true);
            }
        } else if (netTrafficeCallback != null) {
            netTrafficeCallback.onResultCallback(false);
        }
    }

    public final void b(int i) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.b.r.AnonymousClass3(i), 13, true);
    }

    public final boolean b() {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(this.b).b(com.anythink.core.common.b.o.a().o());
        if (b == null || b.O()) {
            return this.c != 1;
        }
        if (b.ae() == 0) {
            return true;
        }
        int i = this.c;
        if (b.ac() == 1) {
            i = b.ab();
        }
        return i == 0;
    }

    public final boolean c() {
        com.anythink.core.d.a b = com.anythink.core.d.b.a(this.b).b(com.anythink.core.common.b.o.a().o());
        return (b == null || b.O()) ? this.c != 1 : this.c == 2 ? b.ae() == 0 : b.ac() == 1 ? b.ab() == 0 : this.c == 0 || b.ae() == 0;
    }

    public final boolean c(int i) {
        return this.e.get(java.lang.Integer.valueOf(i)) != null && this.e.get(java.lang.Integer.valueOf(i)).booleanValue();
    }

    public final boolean d() {
        return com.anythink.core.common.o.r.b(this.b, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.l, -100) == 1;
    }
}
