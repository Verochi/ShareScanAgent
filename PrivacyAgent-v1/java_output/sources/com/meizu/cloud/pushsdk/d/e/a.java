package com.meizu.cloud.pushsdk.d.e;

/* loaded from: classes23.dex */
public abstract class a {
    private static final java.lang.String n = "a";
    protected com.meizu.cloud.pushsdk.d.b.a b;
    protected com.meizu.cloud.pushsdk.d.e.c c;
    protected com.meizu.cloud.pushsdk.d.e.b d;
    protected final java.lang.String e;
    protected final java.lang.String f;
    protected final boolean g;
    protected final com.meizu.cloud.pushsdk.d.f.b h;
    protected final boolean i;
    protected final long j;
    protected final int k;
    protected final java.util.concurrent.TimeUnit l;
    protected final java.lang.String a = com.meizu.cloud.pushsdk.PushManager.TAG;
    protected final java.util.concurrent.atomic.AtomicBoolean m = new java.util.concurrent.atomic.AtomicBoolean(true);

    /* renamed from: com.meizu.cloud.pushsdk.d.e.a$a, reason: collision with other inner class name */
    public static class C0427a {
        protected final com.meizu.cloud.pushsdk.d.b.a a;
        protected final java.lang.String b;
        protected final java.lang.String c;
        protected final android.content.Context d;
        protected com.meizu.cloud.pushsdk.d.e.c e = null;
        protected boolean f = false;
        protected com.meizu.cloud.pushsdk.d.f.b g = com.meizu.cloud.pushsdk.d.f.b.OFF;
        protected boolean h = false;
        protected long i = 600;
        protected long j = 300;
        protected long k = 15;
        protected int l = 10;
        protected java.util.concurrent.TimeUnit m = java.util.concurrent.TimeUnit.SECONDS;

        public C0427a(com.meizu.cloud.pushsdk.d.b.a aVar, java.lang.String str, java.lang.String str2, android.content.Context context, java.lang.Class<? extends com.meizu.cloud.pushsdk.d.e.a> cls) {
            this.a = aVar;
            this.b = str;
            this.c = str2;
            this.d = context;
        }

        public com.meizu.cloud.pushsdk.d.e.a.C0427a a(int i) {
            this.l = i;
            return this;
        }

        public com.meizu.cloud.pushsdk.d.e.a.C0427a a(com.meizu.cloud.pushsdk.d.e.c cVar) {
            this.e = cVar;
            return this;
        }

        public com.meizu.cloud.pushsdk.d.e.a.C0427a a(com.meizu.cloud.pushsdk.d.f.b bVar) {
            this.g = bVar;
            return this;
        }

        public com.meizu.cloud.pushsdk.d.e.a.C0427a a(java.lang.Boolean bool) {
            this.f = bool.booleanValue();
            return this;
        }
    }

    public a(com.meizu.cloud.pushsdk.d.e.a.C0427a c0427a) {
        this.b = c0427a.a;
        this.f = c0427a.c;
        this.g = c0427a.f;
        this.e = c0427a.b;
        this.c = c0427a.e;
        this.h = c0427a.g;
        boolean z = c0427a.h;
        this.i = z;
        this.j = c0427a.k;
        int i = c0427a.l;
        this.k = i < 2 ? 2 : i;
        this.l = c0427a.m;
        if (z) {
            this.d = new com.meizu.cloud.pushsdk.d.e.b(c0427a.i, c0427a.j, c0427a.m, c0427a.d);
        }
        com.meizu.cloud.pushsdk.d.f.c.a(c0427a.g);
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Tracker created successfully.", new java.lang.Object[0]);
    }

    private com.meizu.cloud.pushsdk.d.a.b a(java.util.List<com.meizu.cloud.pushsdk.d.a.b> list) {
        if (this.i) {
            list.add(this.d.a());
        }
        com.meizu.cloud.pushsdk.d.e.c cVar = this.c;
        if (cVar != null) {
            if (!cVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("geolocation", this.c.a()));
            }
            if (!this.c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("mobileinfo", this.c.b()));
            }
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.Iterator<com.meizu.cloud.pushsdk.d.a.b> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().a());
        }
        return new com.meizu.cloud.pushsdk.d.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.d.a.c cVar, java.util.List<com.meizu.cloud.pushsdk.d.a.b> list, boolean z) {
        if (this.c != null) {
            cVar.a(new java.util.HashMap(this.c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.b.a(cVar, z);
    }

    public void a() {
        if (this.m.get()) {
            b().a();
        }
    }

    public void a(com.meizu.cloud.pushsdk.d.c.b bVar, boolean z) {
        if (this.m.get()) {
            a(bVar.e(), bVar.a(), z);
        }
    }

    public void a(com.meizu.cloud.pushsdk.d.e.c cVar) {
        this.c = cVar;
    }

    public com.meizu.cloud.pushsdk.d.b.a b() {
        return this.b;
    }
}
