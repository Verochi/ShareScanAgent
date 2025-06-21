package com.anythink.expressad.foundation.g.f.d;

/* loaded from: classes12.dex */
public final class b {
    private com.anythink.expressad.foundation.g.f.j a;
    private java.util.LinkedList<com.anythink.expressad.foundation.g.f.d.b.a> c = new java.util.LinkedList<>();
    private int b = 3;

    public class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        private java.lang.String g;
        private java.io.File h;
        private com.anythink.expressad.foundation.g.f.e<java.lang.Void> i;
        private com.anythink.expressad.foundation.g.f.d.a j;
        private int k;

        /* renamed from: com.anythink.expressad.foundation.g.f.d.b$a$1, reason: invalid class name */
        public class AnonymousClass1 extends com.anythink.expressad.foundation.g.f.f<java.lang.Void> {
            boolean a;

            public AnonymousClass1() {
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a() {
                if (this.a) {
                    return;
                }
                com.anythink.expressad.foundation.g.f.d.b.a.c(com.anythink.expressad.foundation.g.f.d.b.a.this);
                com.anythink.expressad.foundation.g.f.d.b.a.this.i.a();
                com.anythink.expressad.foundation.g.f.d.b.a aVar = com.anythink.expressad.foundation.g.f.d.b.a.this;
                com.anythink.expressad.foundation.g.f.d.b.a(com.anythink.expressad.foundation.g.f.d.b.this, aVar);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(long j, long j2) {
                com.anythink.expressad.foundation.g.f.d.b.a.this.i.a(j, j2);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(com.anythink.expressad.foundation.g.f.a.a aVar) {
                if (this.a) {
                    return;
                }
                com.anythink.expressad.foundation.g.f.d.b.a.this.i.a(aVar);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void a(com.anythink.expressad.foundation.g.f.k kVar) {
                if (this.a) {
                    return;
                }
                com.anythink.expressad.foundation.g.f.d.b.a.this.i.a(kVar);
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void b() {
                com.anythink.expressad.foundation.g.f.d.b.a.this.i.b();
            }

            @Override // com.anythink.expressad.foundation.g.f.f, com.anythink.expressad.foundation.g.f.e
            public final void c() {
                com.anythink.expressad.foundation.g.f.d.b.a.this.i.c();
                this.a = true;
            }
        }

        private a(java.io.File file, java.lang.String str, com.anythink.expressad.foundation.g.f.e<java.lang.Void> eVar) {
            this.h = file;
            this.i = eVar;
            this.g = str;
        }

        public /* synthetic */ a(com.anythink.expressad.foundation.g.f.d.b bVar, java.io.File file, java.lang.String str, com.anythink.expressad.foundation.g.f.e eVar, byte b2) {
            this(file, str, (com.anythink.expressad.foundation.g.f.e<java.lang.Void>) eVar);
        }

        private a(com.anythink.expressad.foundation.g.f.d.b bVar, java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.g.f.e<java.lang.Void> eVar) {
            this(new java.io.File(str), str2, eVar);
        }

        public static /* synthetic */ boolean a(com.anythink.expressad.foundation.g.f.d.b.a aVar) {
            if (aVar.k != 0) {
                return false;
            }
            com.anythink.expressad.foundation.g.f.d.a aVar2 = new com.anythink.expressad.foundation.g.f.d.a(aVar.h, aVar.g);
            aVar.j = aVar2;
            aVar2.a((com.anythink.expressad.foundation.g.f.e) aVar.new AnonymousClass1());
            aVar.k = 1;
            com.anythink.expressad.foundation.g.f.d.b.this.a.a((com.anythink.expressad.foundation.g.f.i) aVar.j);
            return true;
        }

        public static /* synthetic */ int c(com.anythink.expressad.foundation.g.f.d.b.a aVar) {
            aVar.k = 3;
            return 3;
        }

        private boolean c() {
            if (this.k != 0) {
                return false;
            }
            com.anythink.expressad.foundation.g.f.d.a aVar = new com.anythink.expressad.foundation.g.f.d.a(this.h, this.g);
            this.j = aVar;
            aVar.a((com.anythink.expressad.foundation.g.f.e) new com.anythink.expressad.foundation.g.f.d.b.a.AnonymousClass1());
            this.k = 1;
            com.anythink.expressad.foundation.g.f.d.b.this.a.a((com.anythink.expressad.foundation.g.f.i) this.j);
            return true;
        }

        private int d() {
            return this.k;
        }

        private boolean e() {
            int i = this.k;
            if (i == 0) {
                this.k = 2;
                com.anythink.expressad.foundation.g.f.d.b.this.b();
                return true;
            }
            if (i != 1) {
                return false;
            }
            this.j.e();
            this.k = 2;
            com.anythink.expressad.foundation.g.f.d.b.this.b();
            return true;
        }

        private boolean f() {
            if (this.k != 2) {
                return false;
            }
            this.k = 0;
            com.anythink.expressad.foundation.g.f.d.b.this.b();
            return true;
        }

        public final boolean a() {
            return this.k == 1;
        }

        public final boolean b() {
            int i = this.k;
            if (i == 4 || i == 3) {
                return false;
            }
            if (i == 1) {
                this.j.e();
            }
            this.k = 4;
            com.anythink.expressad.foundation.g.f.d.b.a(com.anythink.expressad.foundation.g.f.d.b.this, this);
            return true;
        }
    }

    public b(com.anythink.expressad.foundation.g.f.j jVar) {
        this.a = jVar;
    }

    private static com.anythink.expressad.foundation.g.f.d.a a(java.io.File file, java.lang.String str) {
        return new com.anythink.expressad.foundation.g.f.d.a(file, str);
    }

    private com.anythink.expressad.foundation.g.f.d.b.a a(java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.g.f.e<java.lang.Void> eVar) {
        return a(new java.io.File(str), str2, eVar);
    }

    private void a(com.anythink.expressad.foundation.g.f.d.b.a aVar) {
        synchronized (this) {
            this.c.remove(aVar);
        }
        b();
    }

    public static /* synthetic */ void a(com.anythink.expressad.foundation.g.f.d.b bVar, com.anythink.expressad.foundation.g.f.d.b.a aVar) {
        synchronized (bVar) {
            bVar.c.remove(aVar);
        }
        bVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            java.util.Iterator<com.anythink.expressad.foundation.g.f.d.b.a> it = this.c.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().a()) {
                    i++;
                }
            }
            if (i >= this.b) {
                return;
            }
            java.util.Iterator<com.anythink.expressad.foundation.g.f.d.b.a> it2 = this.c.iterator();
            while (it2.hasNext()) {
                if (com.anythink.expressad.foundation.g.f.d.b.a.a(it2.next()) && (i = i + 1) == this.b) {
                    return;
                }
            }
        }
    }

    public final com.anythink.expressad.foundation.g.f.d.b.a a(java.io.File file, java.lang.String str, com.anythink.expressad.foundation.g.f.e<java.lang.Void> eVar) {
        com.anythink.expressad.foundation.g.f.d.b.a aVar = new com.anythink.expressad.foundation.g.f.d.b.a(this, file, str, eVar, (byte) 0);
        synchronized (this) {
            this.c.add(aVar);
        }
        b();
        return aVar;
    }

    public final void a() {
        synchronized (this) {
            while (!this.c.isEmpty()) {
                this.c.get(0).b();
            }
        }
    }
}
