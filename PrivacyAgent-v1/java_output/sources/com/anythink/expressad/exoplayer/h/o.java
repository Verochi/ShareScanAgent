package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class o extends com.anythink.expressad.exoplayer.h.c implements com.anythink.expressad.exoplayer.h.n.c {
    public static final int a = 3;
    public static final int b = 6;
    public static final int c = -1;
    public static final int d = 1048576;
    private final android.net.Uri e;
    private final com.anythink.expressad.exoplayer.j.h.a f;
    private final com.anythink.expressad.exoplayer.e.h g;
    private final int h;
    private final java.lang.String i;
    private final int j;

    @androidx.annotation.Nullable
    private final java.lang.Object k;
    private long l;
    private boolean m;

    @java.lang.Deprecated
    public interface a {
        void a();
    }

    public static final class b extends com.anythink.expressad.exoplayer.h.k {
        private final com.anythink.expressad.exoplayer.h.o.a a;

        public b(com.anythink.expressad.exoplayer.h.o.a aVar) {
            this.a = (com.anythink.expressad.exoplayer.h.o.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        }

        @Override // com.anythink.expressad.exoplayer.h.k, com.anythink.expressad.exoplayer.h.t
        public final void a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar, java.io.IOException iOException, boolean z) {
        }
    }

    public static final class c implements com.anythink.expressad.exoplayer.h.a.c.e {
        private final com.anythink.expressad.exoplayer.j.h.a a;

        @androidx.annotation.Nullable
        private com.anythink.expressad.exoplayer.e.h b;

        @androidx.annotation.Nullable
        private java.lang.String c;

        @androidx.annotation.Nullable
        private java.lang.Object d;
        private int e = -1;
        private int f = 1048576;
        private boolean g;

        public c(com.anythink.expressad.exoplayer.j.h.a aVar) {
            this.a = aVar;
        }

        private com.anythink.expressad.exoplayer.h.o.c a(int i) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.e = i;
            return this;
        }

        private com.anythink.expressad.exoplayer.h.o.c a(com.anythink.expressad.exoplayer.e.h hVar) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.b = hVar;
            return this;
        }

        private com.anythink.expressad.exoplayer.h.o.c a(java.lang.Object obj) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.d = obj;
            return this;
        }

        private com.anythink.expressad.exoplayer.h.o.c a(java.lang.String str) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.c = str;
            return this;
        }

        @java.lang.Deprecated
        private com.anythink.expressad.exoplayer.h.o a(android.net.Uri uri, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.t tVar) {
            com.anythink.expressad.exoplayer.h.o b = b(uri);
            if (handler != null && tVar != null) {
                b.a(handler, tVar);
            }
            return b;
        }

        private com.anythink.expressad.exoplayer.h.o.c b(int i) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.f = i;
            return this;
        }

        @Override // com.anythink.expressad.exoplayer.h.a.c.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.anythink.expressad.exoplayer.h.o b(android.net.Uri uri) {
            this.g = true;
            if (this.b == null) {
                this.b = new com.anythink.expressad.exoplayer.e.c();
            }
            return new com.anythink.expressad.exoplayer.h.o(uri, this.a, this.b, this.e, this.c, this.f, this.d, (byte) 0);
        }

        @Override // com.anythink.expressad.exoplayer.h.a.c.e
        public final int[] a() {
            return new int[]{3};
        }
    }

    private o(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, int i, @androidx.annotation.Nullable java.lang.String str, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
        this.e = uri;
        this.f = aVar;
        this.g = hVar;
        this.h = i;
        this.i = str;
        this.j = i2;
        this.l = -9223372036854775807L;
        this.k = obj;
    }

    public /* synthetic */ o(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, int i, java.lang.String str, int i2, java.lang.Object obj, byte b2) {
        this(uri, aVar, hVar, i, str, i2, obj);
    }

    @java.lang.Deprecated
    private o(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, android.os.Handler handler, com.anythink.expressad.exoplayer.h.o.a aVar2) {
        this(uri, aVar, hVar, handler, aVar2, null);
    }

    @java.lang.Deprecated
    private o(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, android.os.Handler handler, com.anythink.expressad.exoplayer.h.o.a aVar2, java.lang.String str) {
        this(uri, aVar, hVar, handler, aVar2, str, (byte) 0);
    }

    @java.lang.Deprecated
    private o(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, android.os.Handler handler, com.anythink.expressad.exoplayer.h.o.a aVar2, java.lang.String str, byte b2) {
        this(uri, aVar, hVar, -1, str, 1048576, (java.lang.Object) null);
        if (aVar2 == null || handler == null) {
            return;
        }
        a(handler, new com.anythink.expressad.exoplayer.h.o.b(aVar2));
    }

    private void b(long j, boolean z) {
        this.l = j;
        this.m = z;
        a(new com.anythink.expressad.exoplayer.h.ab(this.l, this.m, false, this.k), (java.lang.Object) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        com.anythink.expressad.exoplayer.k.a.a(aVar.a == 0);
        return new com.anythink.expressad.exoplayer.h.n(this.e, this.f.a(), this.g.a(), this.h, a(aVar), this, bVar, this.i, this.j);
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.h.n.c
    public final void a(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.l;
        }
        if (this.l == j && this.m == z) {
            return;
        }
        b(j, z);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        ((com.anythink.expressad.exoplayer.h.n) rVar).f();
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        b(this.l, false);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void b() {
    }
}
