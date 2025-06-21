package com.meizu.cloud.pushsdk.d.b;

/* loaded from: classes23.dex */
public abstract class a {
    protected final android.content.Context a;
    protected final com.meizu.cloud.pushsdk.d.b.f b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final java.util.concurrent.TimeUnit f;
    protected final java.util.concurrent.atomic.AtomicBoolean g;
    private final java.lang.String h;
    private final com.meizu.cloud.pushsdk.c.c.g i;
    private android.net.Uri.Builder j;
    private com.meizu.cloud.pushsdk.d.b.d k;
    private com.meizu.cloud.pushsdk.d.b.b l;
    private com.meizu.cloud.pushsdk.d.b.h m;
    private final javax.net.ssl.SSLSocketFactory n;
    private final javax.net.ssl.HostnameVerifier o;
    private java.lang.String p;
    private final long q;
    private final long r;

    /* renamed from: s, reason: collision with root package name */
    private final com.meizu.cloud.pushsdk.c.c.a f419s;

    /* renamed from: com.meizu.cloud.pushsdk.d.b.a$a, reason: collision with other inner class name */
    public static class C0424a {
        protected final java.lang.String a;
        protected final android.content.Context b;
        protected javax.net.ssl.SSLSocketFactory m;
        protected javax.net.ssl.HostnameVerifier n;
        protected com.meizu.cloud.pushsdk.d.b.f c = null;
        protected com.meizu.cloud.pushsdk.d.b.d d = com.meizu.cloud.pushsdk.d.b.d.POST;
        protected com.meizu.cloud.pushsdk.d.b.b e = com.meizu.cloud.pushsdk.d.b.b.Single;
        protected com.meizu.cloud.pushsdk.d.b.h f = com.meizu.cloud.pushsdk.d.b.h.HTTPS;
        protected int g = 5;
        protected int h = 250;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected java.util.concurrent.TimeUnit l = java.util.concurrent.TimeUnit.SECONDS;
        protected com.meizu.cloud.pushsdk.c.c.a o = new com.meizu.cloud.pushsdk.c.c.e();

        public C0424a(java.lang.String str, android.content.Context context, java.lang.Class<? extends com.meizu.cloud.pushsdk.d.b.a> cls) {
            this.a = str;
            this.b = context;
        }

        public com.meizu.cloud.pushsdk.d.b.a.C0424a a(int i) {
            this.g = i;
            return this;
        }

        public com.meizu.cloud.pushsdk.d.b.a.C0424a a(com.meizu.cloud.pushsdk.c.c.a aVar) {
            if (aVar != null) {
                this.o = aVar;
                com.meizu.cloud.pushsdk.d.f.c.c(com.meizu.cloud.pushsdk.d.b.a.C0424a.class.getSimpleName(), "set new call " + aVar, new java.lang.Object[0]);
            }
            return this;
        }

        public com.meizu.cloud.pushsdk.d.b.a.C0424a a(com.meizu.cloud.pushsdk.d.b.b bVar) {
            this.e = bVar;
            return this;
        }

        public com.meizu.cloud.pushsdk.d.b.a.C0424a a(com.meizu.cloud.pushsdk.d.b.f fVar) {
            this.c = fVar;
            return this;
        }

        public com.meizu.cloud.pushsdk.d.b.a.C0424a b(int i) {
            this.h = i;
            return this;
        }

        public com.meizu.cloud.pushsdk.d.b.a.C0424a c(int i) {
            this.i = i;
            return this;
        }
    }

    public a(com.meizu.cloud.pushsdk.d.b.a.C0424a c0424a) {
        java.lang.String simpleName = com.meizu.cloud.pushsdk.d.b.a.class.getSimpleName();
        this.h = simpleName;
        this.i = com.meizu.cloud.pushsdk.c.c.g.a("application/json; charset=utf-8");
        this.g = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.k = c0424a.d;
        this.b = c0424a.c;
        this.a = c0424a.b;
        this.l = c0424a.e;
        this.m = c0424a.f;
        this.n = c0424a.m;
        this.o = c0424a.n;
        this.c = c0424a.g;
        this.d = c0424a.i;
        this.e = c0424a.h;
        this.q = c0424a.j;
        this.r = c0424a.k;
        this.p = c0424a.a;
        this.f = c0424a.l;
        this.f419s = c0424a.o;
        c();
        com.meizu.cloud.pushsdk.d.f.c.c(simpleName, "Emitter created successfully!", new java.lang.Object[0]);
    }

    private com.meizu.cloud.pushsdk.c.c.i a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        a(aVar, "");
        this.j.clearQuery();
        java.util.HashMap hashMap = (java.util.HashMap) aVar.a();
        for (java.lang.String str : hashMap.keySet()) {
            this.j.appendQueryParameter(str, (java.lang.String) hashMap.get(str));
        }
        return new com.meizu.cloud.pushsdk.c.c.i.a().a(this.j.build().toString()).a().c();
    }

    private com.meizu.cloud.pushsdk.c.c.i a(java.util.ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList) {
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator<com.meizu.cloud.pushsdk.d.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().a());
        }
        com.meizu.cloud.pushsdk.d.a.b bVar = new com.meizu.cloud.pushsdk.d.a.b("push_group_data", arrayList2);
        com.meizu.cloud.pushsdk.d.f.c.b(this.h, "final SelfDescribingJson " + bVar, new java.lang.Object[0]);
        return new com.meizu.cloud.pushsdk.c.c.i.a().a(this.j.build().toString()).a(com.meizu.cloud.pushsdk.c.c.j.a(this.i, bVar.toString())).c();
    }

    private void a(com.meizu.cloud.pushsdk.c.c.k kVar) {
        if (kVar != null) {
            try {
                if (kVar.b() != null) {
                    kVar.b().close();
                }
            } catch (java.lang.Exception unused) {
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Unable to close source data", new java.lang.Object[0]);
            }
        }
    }

    private void a(com.meizu.cloud.pushsdk.d.a.a aVar, java.lang.String str) {
        if ("".equals(str)) {
            str = com.meizu.cloud.pushsdk.d.f.e.a();
        }
        aVar.a("stm", str);
    }

    private void c() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        com.meizu.cloud.pushsdk.d.f.c.a(this.h, "security " + this.m, new java.lang.Object[0]);
        if (this.m == com.meizu.cloud.pushsdk.d.b.h.HTTP) {
            sb = new java.lang.StringBuilder();
            str = "http://";
        } else {
            sb = new java.lang.StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.p);
        this.j = android.net.Uri.parse(sb.toString()).buildUpon();
        if (this.k == com.meizu.cloud.pushsdk.d.b.d.GET) {
            this.j.appendPath("i");
        } else {
            this.j.appendEncodedPath("push_data_report/mobile");
        }
    }

    public int a(com.meizu.cloud.pushsdk.c.c.i iVar) {
        com.meizu.cloud.pushsdk.c.c.k kVar = null;
        try {
            try {
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Sending request: %s", iVar);
                kVar = this.f419s.a(iVar);
                return kVar.a();
            } catch (java.io.IOException e) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request sending failed: %s", android.util.Log.getStackTraceString(e));
                a(kVar);
                return -1;
            }
        } finally {
            a(kVar);
        }
    }

    public java.util.LinkedList<com.meizu.cloud.pushsdk.d.b.e> a(com.meizu.cloud.pushsdk.d.b.c cVar) {
        int size = cVar.a().size();
        java.util.LinkedList<java.lang.Long> b = cVar.b();
        java.util.LinkedList<com.meizu.cloud.pushsdk.d.b.e> linkedList = new java.util.LinkedList<>();
        long j = 22;
        if (this.k == com.meizu.cloud.pushsdk.d.b.d.GET) {
            for (int i = 0; i < size; i++) {
                java.util.LinkedList linkedList2 = new java.util.LinkedList();
                linkedList2.add(b.get(i));
                com.meizu.cloud.pushsdk.d.a.a aVar = cVar.a().get(i);
                linkedList.add(new com.meizu.cloud.pushsdk.d.b.e(aVar.b() + 22 > this.q, a(aVar), linkedList2));
            }
        } else {
            int i2 = 0;
            while (i2 < size) {
                java.util.LinkedList linkedList3 = new java.util.LinkedList();
                java.util.ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList = new java.util.ArrayList<>();
                long j2 = 0;
                int i3 = i2;
                while (i3 < this.l.a() + i2 && i3 < size) {
                    com.meizu.cloud.pushsdk.d.a.a aVar2 = cVar.a().get(i3);
                    long b2 = aVar2.b() + j;
                    if (b2 + 88 > this.r) {
                        java.util.ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList2 = new java.util.ArrayList<>();
                        java.util.LinkedList linkedList4 = new java.util.LinkedList();
                        arrayList2.add(aVar2);
                        linkedList4.add(b.get(i3));
                        linkedList.add(new com.meizu.cloud.pushsdk.d.b.e(true, a(arrayList2), linkedList4));
                    } else {
                        j2 += b2;
                        if (j2 + 88 + (arrayList.size() - 1) > this.r) {
                            linkedList.add(new com.meizu.cloud.pushsdk.d.b.e(false, a(arrayList), linkedList3));
                            java.util.ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList3 = new java.util.ArrayList<>();
                            java.util.LinkedList linkedList5 = new java.util.LinkedList();
                            arrayList3.add(aVar2);
                            linkedList5.add(b.get(i3));
                            arrayList = arrayList3;
                            linkedList3 = linkedList5;
                            j2 = b2;
                        } else {
                            arrayList.add(aVar2);
                            linkedList3.add(b.get(i3));
                        }
                    }
                    i3++;
                    j = 22;
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new com.meizu.cloud.pushsdk.d.b.e(false, a(arrayList), linkedList3));
                }
                i2 += this.l.a();
                j = 22;
            }
        }
        return linkedList;
    }

    public abstract void a();

    public abstract void a(com.meizu.cloud.pushsdk.d.a.a aVar, boolean z);

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public java.lang.String b() {
        return this.j.clearQuery().build().toString();
    }
}
