package com.getui.gtc.dyc;

/* loaded from: classes22.dex */
public class f {
    private final com.getui.gtc.dyc.e a;
    private final com.getui.gtc.dyc.g c;
    private final java.util.List<com.getui.gtc.dyc.b.c> d;
    private final java.util.Map<java.lang.String, java.lang.Object> e;

    /* renamed from: com.getui.gtc.dyc.f$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.getui.gtc.dyc.b.b a;
        final /* synthetic */ com.getui.gtc.dyc.h c;

        public AnonymousClass1(com.getui.gtc.dyc.b.b bVar, com.getui.gtc.dyc.h hVar) {
            this.a = bVar;
            this.c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (com.getui.gtc.dyc.f.this.e) {
                if (com.getui.gtc.dyc.f.this.e.get(this.a.b()) == null) {
                    com.getui.gtc.dyc.f.this.e.put(this.a.b(), new java.lang.Object());
                }
            }
            synchronized (com.getui.gtc.dyc.f.this.e.get(this.a.b())) {
                boolean z = this.a.h() <= 0;
                com.getui.gtc.dyc.h a = com.getui.gtc.dyc.f.this.a.a(this.a.b());
                if (!z && a != null && ((this.c == null || (a.f() != null && !a.f().equals(this.c.f()))) && this.a.i() != null)) {
                    com.getui.gtc.dyc.b.c i = this.a.i();
                    com.getui.gtc.dyc.h hVar = this.c;
                    i.a(hVar == null ? null : hVar.f(), a.f());
                }
                if (a == null || com.getui.gtc.dyc.f.this.a(this.a, a)) {
                    if (!z && a != null) {
                        this.a.f(a.d());
                    }
                    try {
                        com.getui.gtc.dyc.h a2 = com.getui.gtc.dyc.f.this.c.a(this.a);
                        if (a2 != null) {
                            if (!android.text.TextUtils.isEmpty(a2.d())) {
                                java.util.Map<java.lang.String, java.lang.String> f = a2.f();
                                if (f != null) {
                                    java.util.Map<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>(f);
                                    for (java.lang.String str : f.keySet()) {
                                        if (str != null && str.endsWith(".gtc_skip")) {
                                            hashMap.remove(str);
                                        }
                                    }
                                    a2.a(hashMap);
                                    com.getui.gtc.dyc.f.this.a.a(this.a.b(), a2);
                                    a2.a(f);
                                    if (this.a.i() != null) {
                                        this.a.i().a(a == null ? null : a.f(), f);
                                    }
                                    java.util.Iterator it = new java.util.ArrayList(com.getui.gtc.dyc.f.this.d).iterator();
                                    while (it.hasNext()) {
                                        ((com.getui.gtc.dyc.b.c) it.next()).a(a == null ? null : a.f(), f);
                                    }
                                }
                            } else if (a != null) {
                                a.a(a2.c());
                                com.getui.gtc.dyc.f.this.a.a(this.a.b(), a);
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.dyc.a.a.a.a(th);
                        java.lang.String message = th.getMessage();
                        if (this.a.i() != null) {
                            this.a.i().b(message);
                            if (this.a.i() instanceof com.getui.gtc.dyc.b.d) {
                                ((com.getui.gtc.dyc.b.d) this.a.i()).a(new java.lang.Exception(th));
                            }
                        }
                        for (com.getui.gtc.dyc.b.c cVar : new java.util.ArrayList(com.getui.gtc.dyc.f.this.d)) {
                            cVar.b(message);
                            if (cVar instanceof com.getui.gtc.dyc.b.d) {
                                ((com.getui.gtc.dyc.b.d) cVar).a(new java.lang.Exception(th));
                            }
                        }
                    }
                }
            }
        }
    }

    public static class a {
        private static final com.getui.gtc.dyc.f a = new com.getui.gtc.dyc.f(null);
    }

    private f() {
        this.a = com.getui.gtc.dyc.e.a();
        this.c = com.getui.gtc.dyc.g.a();
        this.d = new java.util.ArrayList();
        this.e = new java.util.concurrent.ConcurrentHashMap();
    }

    public /* synthetic */ f(com.getui.gtc.dyc.f.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.getui.gtc.dyc.f a() {
        return com.getui.gtc.dyc.f.a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.getui.gtc.dyc.b.b bVar, com.getui.gtc.dyc.h hVar) {
        return (java.lang.System.currentTimeMillis() - hVar.c() <= bVar.h() && bVar.g().equals(hVar.a()) && bVar.c().equals(hVar.e())) ? false : true;
    }

    public java.util.Map<java.lang.String, java.lang.String> a(com.getui.gtc.dyc.b.b bVar) {
        try {
            com.getui.gtc.dyc.h a2 = this.a.a(bVar.b());
            if (a2 == null || a(bVar, a2)) {
                com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.dyc.f.AnonymousClass1(bVar, a2));
            }
            if (a2 == null) {
                return null;
            }
            return a2.f();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dyc.a.a.a.a(th);
            return null;
        }
    }

    public java.util.Map<java.lang.String, java.lang.String> a(java.lang.String str) {
        com.getui.gtc.dyc.h a2 = this.a.a(str);
        if (a2 == null) {
            return null;
        }
        return a2.f();
    }

    public void a(com.getui.gtc.dyc.b.c cVar) {
        synchronized (this.d) {
            if (!this.d.contains(cVar)) {
                this.d.add(cVar);
            }
        }
    }

    public void a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        com.getui.gtc.dyc.h a2 = this.a.a(str);
        java.util.Map<java.lang.String, java.lang.String> f = a2.f();
        f.clear();
        f.putAll(map);
        this.a.a(str, a2);
    }

    public java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> c() {
        java.util.HashMap<java.lang.String, com.getui.gtc.dyc.h> c = this.a.c();
        if (c == null || c.size() <= 0) {
            return null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, com.getui.gtc.dyc.h> entry : c.entrySet()) {
            com.getui.gtc.dyc.h value = entry.getValue();
            if (value.f() != null) {
                hashMap.put(entry.getKey(), value.f());
            }
        }
        return hashMap;
    }

    public void c(com.getui.gtc.dyc.b.c cVar) {
        synchronized (this.d) {
            this.d.remove(cVar);
        }
    }
}
