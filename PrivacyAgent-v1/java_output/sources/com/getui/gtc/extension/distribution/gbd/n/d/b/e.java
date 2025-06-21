package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public final class e extends com.getui.gtc.extension.distribution.gbd.n.d.b.g {
    public com.getui.gtc.extension.distribution.gbd.n.d.b.e.a a;
    public int b;

    public static class a implements java.lang.Cloneable {
        com.getui.gtc.extension.distribution.gbd.n.d.b.h.a a = com.getui.gtc.extension.distribution.gbd.n.d.b.h.a.base;
        public java.nio.charset.Charset b;
        java.nio.charset.CharsetEncoder c;
        boolean d;
        int e;

        public a() {
            java.nio.charset.Charset forName = java.nio.charset.Charset.forName("UTF-8");
            this.b = forName;
            this.c = forName.newEncoder();
            this.d = true;
            this.e = 1;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.b.e.a a(int i) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(i >= 0);
            this.e = i;
            return this;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.b.e.a a(com.getui.gtc.extension.distribution.gbd.n.d.b.h.a aVar) {
            this.a = aVar;
            return this;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.b.e.a a(java.nio.charset.Charset charset) {
            this.b = charset;
            this.c = charset.newEncoder();
            return this;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.b.e.a a(boolean z) {
            this.d = z;
            return this;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.b.h.a b() {
            return this.a;
        }

        private java.nio.charset.Charset c() {
            return this.b;
        }

        private java.nio.charset.CharsetEncoder d() {
            return this.c;
        }

        private boolean e() {
            return this.d;
        }

        private int f() {
            return this.e;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.getui.gtc.extension.distribution.gbd.n.d.b.e.a clone() {
            try {
                com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.e.a) super.clone();
                aVar.a(this.b.name());
                aVar.a = com.getui.gtc.extension.distribution.gbd.n.d.b.h.a.valueOf(this.a.name());
                return aVar;
            } catch (java.lang.CloneNotSupportedException e) {
                throw new java.lang.RuntimeException(e);
            }
        }

        public final com.getui.gtc.extension.distribution.gbd.n.d.b.e.a a(java.lang.String str) {
            a(java.nio.charset.Charset.forName(str));
            return this;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        private b(java.lang.String str, int i) {
        }

        private static int[] a() {
            return (int[]) d.clone();
        }
    }

    public e(java.lang.String str) {
        super(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a("#root"), str);
        this.a = new com.getui.gtc.extension.distribution.gbd.n.d.b.e.a();
        this.b = com.getui.gtc.extension.distribution.gbd.n.d.b.e.b.a;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.e.a A() {
        return this.a;
    }

    private int B() {
        return this.b;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.e a(int i) {
        this.b = i;
        return this;
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        com.getui.gtc.extension.distribution.gbd.n.d.b.e eVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.e(str);
        com.getui.gtc.extension.distribution.gbd.n.d.b.g c = eVar.c(com.baidu.mobads.sdk.internal.a.f);
        c.c(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD);
        c.c("body");
        return eVar;
    }

    private void a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : gVar.e) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.j) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.j jVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.j) iVar;
                if (!com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(jVar.c())) {
                    arrayList.add(jVar);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2 = (com.getui.gtc.extension.distribution.gbd.n.d.b.i) arrayList.get(size);
            gVar.f(iVar2);
            w().b((com.getui.gtc.extension.distribution.gbd.n.d.b.i) new com.getui.gtc.extension.distribution.gbd.n.d.b.j(" ", ""));
            w().b(iVar2);
        }
    }

    private void a(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.e.c i = i(str);
        com.getui.gtc.extension.distribution.gbd.n.d.b.g a2 = i.a();
        if (i.size() > 1) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i2 = 1; i2 < i.size(); i2++) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2 = i.get(i2);
                java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.i> it = gVar2.e.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                gVar2.s();
            }
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                a2.a((com.getui.gtc.extension.distribution.gbd.n.d.b.i) it2.next());
            }
        }
        if (((com.getui.gtc.extension.distribution.gbd.n.d.b.g) a2.d).equals(gVar)) {
            return;
        }
        gVar.a((com.getui.gtc.extension.distribution.gbd.n.d.b.i) a2);
    }

    private void t(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        com.getui.gtc.extension.distribution.gbd.n.d.b.g a2 = i("title").a();
        if (a2 == null) {
            a(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, (com.getui.gtc.extension.distribution.gbd.n.d.b.i) this).c("title").b(str);
        } else {
            a2.b(str);
        }
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g u(java.lang.String str) {
        return new com.getui.gtc.extension.distribution.gbd.n.d.b.g(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(str), this.g);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g v() {
        return a(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, (com.getui.gtc.extension.distribution.gbd.n.d.b.i) this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g w() {
        return a("body", (com.getui.gtc.extension.distribution.gbd.n.d.b.i) this);
    }

    private java.lang.String x() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g a2 = i("title").a();
        return a2 != null ? a2.i().trim() : "";
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.e y() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g a2 = a(com.baidu.mobads.sdk.internal.a.f, (com.getui.gtc.extension.distribution.gbd.n.d.b.i) this);
        if (a2 == null) {
            a2 = c(com.baidu.mobads.sdk.internal.a.f);
        }
        if (a(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, (com.getui.gtc.extension.distribution.gbd.n.d.b.i) this) == null) {
            a2.b((com.getui.gtc.extension.distribution.gbd.n.d.b.i) new com.getui.gtc.extension.distribution.gbd.n.d.b.g(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD), a2.g));
        }
        if (a("body", (com.getui.gtc.extension.distribution.gbd.n.d.b.i) this) == null) {
            a2.c("body");
        }
        a(a(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, (com.getui.gtc.extension.distribution.gbd.n.d.b.i) this));
        a(a2);
        a((com.getui.gtc.extension.distribution.gbd.n.d.b.g) this);
        a(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, a2);
        a("body", a2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.g, com.getui.gtc.extension.distribution.gbd.n.d.b.i
    /* renamed from: z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public com.getui.gtc.extension.distribution.gbd.n.d.b.e d() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.e eVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.e) super.d();
        eVar.a = this.a.clone();
        return eVar;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g a(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        if (iVar.a().equals(str)) {
            return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar;
        }
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.i> it = iVar.e.iterator();
        while (it.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g a2 = a(str, it.next());
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.g, com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String a() {
        return "#document";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final java.lang.String a_() {
        return super.n();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.g
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g b(java.lang.String str) {
        a("body", (com.getui.gtc.extension.distribution.gbd.n.d.b.i) this).b(str);
        return this;
    }
}
