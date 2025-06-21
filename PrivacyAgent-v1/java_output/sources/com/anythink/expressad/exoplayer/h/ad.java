package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class ad extends com.anythink.expressad.exoplayer.h.c {
    public static final int a = 3;
    private final com.anythink.expressad.exoplayer.j.k b;
    private final com.anythink.expressad.exoplayer.j.h.a c;
    private final com.anythink.expressad.exoplayer.m d;
    private final long e;
    private final int f;
    private final boolean g;
    private final com.anythink.expressad.exoplayer.ae h;

    @java.lang.Deprecated
    public interface a {
        void a();
    }

    public static final class b extends com.anythink.expressad.exoplayer.h.k {
        private final com.anythink.expressad.exoplayer.h.ad.a a;
        private final int b;

        public b(com.anythink.expressad.exoplayer.h.ad.a aVar, int i) {
            this.a = (com.anythink.expressad.exoplayer.h.ad.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
            this.b = i;
        }

        @Override // com.anythink.expressad.exoplayer.h.k, com.anythink.expressad.exoplayer.h.t
        public final void a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar, java.io.IOException iOException, boolean z) {
        }
    }

    public static final class c {
        private final com.anythink.expressad.exoplayer.j.h.a a;
        private int b = 3;
        private boolean c;
        private boolean d;

        @androidx.annotation.Nullable
        private java.lang.Object e;

        private c(com.anythink.expressad.exoplayer.j.h.a aVar) {
            this.a = (com.anythink.expressad.exoplayer.j.h.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        }

        private com.anythink.expressad.exoplayer.h.ad.c a(int i) {
            com.anythink.expressad.exoplayer.k.a.b(!this.d);
            this.b = i;
            return this;
        }

        private com.anythink.expressad.exoplayer.h.ad.c a(java.lang.Object obj) {
            com.anythink.expressad.exoplayer.k.a.b(!this.d);
            this.e = obj;
            return this;
        }

        private com.anythink.expressad.exoplayer.h.ad.c a(boolean z) {
            com.anythink.expressad.exoplayer.k.a.b(!this.d);
            this.c = z;
            return this;
        }

        private com.anythink.expressad.exoplayer.h.ad a(android.net.Uri uri, com.anythink.expressad.exoplayer.m mVar, long j) {
            this.d = true;
            return new com.anythink.expressad.exoplayer.h.ad(uri, this.a, mVar, j, this.b, this.c, this.e, (byte) 0);
        }

        @java.lang.Deprecated
        private com.anythink.expressad.exoplayer.h.ad a(android.net.Uri uri, com.anythink.expressad.exoplayer.m mVar, long j, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.t tVar) {
            this.d = true;
            com.anythink.expressad.exoplayer.h.ad adVar = new com.anythink.expressad.exoplayer.h.ad(uri, this.a, mVar, j, this.b, this.c, this.e, (byte) 0);
            if (handler != null && tVar != null) {
                adVar.a(handler, tVar);
            }
            return adVar;
        }
    }

    @java.lang.Deprecated
    private ad(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j) {
        this(uri, aVar, mVar, j, (byte) 0);
    }

    @java.lang.Deprecated
    private ad(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j, byte b2) {
        this(uri, aVar, mVar, j, 3, false, null);
    }

    @java.lang.Deprecated
    private ad(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j, int i, android.os.Handler handler, com.anythink.expressad.exoplayer.h.ad.a aVar2, int i2, boolean z) {
        this(uri, aVar, mVar, j, i, z, null);
        if (handler == null || aVar2 == null) {
            return;
        }
        a(handler, new com.anythink.expressad.exoplayer.h.ad.b(aVar2, i2));
    }

    private ad(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j, int i, boolean z, @androidx.annotation.Nullable java.lang.Object obj) {
        this.c = aVar;
        this.d = mVar;
        this.e = j;
        this.f = i;
        this.g = z;
        this.b = new com.anythink.expressad.exoplayer.j.k(uri);
        this.h = new com.anythink.expressad.exoplayer.h.ab(j, true, false, obj);
    }

    public /* synthetic */ ad(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j, int i, boolean z, java.lang.Object obj, byte b2) {
        this(uri, aVar, mVar, j, i, z, obj);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        com.anythink.expressad.exoplayer.k.a.a(aVar.a == 0);
        return new com.anythink.expressad.exoplayer.h.ac(this.b, this.c, this.d, this.e, this.f, a(aVar), this.g);
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        ((com.anythink.expressad.exoplayer.h.ac) rVar).f();
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        a(this.h, (java.lang.Object) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void b() {
    }
}
