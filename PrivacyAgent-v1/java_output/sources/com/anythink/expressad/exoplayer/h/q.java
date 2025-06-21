package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class q extends com.anythink.expressad.exoplayer.h.f<java.lang.Void> {
    private final com.anythink.expressad.exoplayer.h.s a;
    private final int b;
    private int c;

    public static final class a extends com.anythink.expressad.exoplayer.h.p {
        public a(com.anythink.expressad.exoplayer.ae aeVar) {
            super(aeVar);
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int a(int i, int i2, boolean z) {
            int a = this.b.a(i, i2, z);
            return a == -1 ? b(z) : a;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int b(int i, int i2, boolean z) {
            int b = this.b.b(i, i2, z);
            return b == -1 ? a(z) : b;
        }
    }

    public static final class b extends com.anythink.expressad.exoplayer.h.a {
        private final com.anythink.expressad.exoplayer.ae b;
        private final int c;
        private final int d;
        private final int e;

        public b(com.anythink.expressad.exoplayer.ae aeVar, int i) {
            super(false, new com.anythink.expressad.exoplayer.h.aa.b(i));
            this.b = aeVar;
            int c = aeVar.c();
            this.c = c;
            this.d = aeVar.b();
            this.e = i;
            if (c > 0) {
                com.anythink.expressad.exoplayer.k.a.b(i <= Integer.MAX_VALUE / c, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int a(int i) {
            return i / this.c;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return this.d * this.e;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int b(int i) {
            return i / this.d;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int b(java.lang.Object obj) {
            if (obj instanceof java.lang.Integer) {
                return ((java.lang.Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return this.c * this.e;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final com.anythink.expressad.exoplayer.ae c(int i) {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int d(int i) {
            return i * this.c;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final int e(int i) {
            return i * this.d;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        public final java.lang.Object f(int i) {
            return java.lang.Integer.valueOf(i);
        }
    }

    private q(com.anythink.expressad.exoplayer.h.s sVar) {
        this(sVar, (byte) 0);
    }

    private q(com.anythink.expressad.exoplayer.h.s sVar, byte b2) {
        com.anythink.expressad.exoplayer.k.a.a(true);
        this.a = sVar;
        this.b = Integer.MAX_VALUE;
    }

    private void b(com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        this.c = aeVar.c();
        a(this.b != Integer.MAX_VALUE ? new com.anythink.expressad.exoplayer.h.q.b(aeVar, this.b) : new com.anythink.expressad.exoplayer.h.q.a(aeVar), obj);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        return this.b != Integer.MAX_VALUE ? this.a.a(aVar.a(aVar.a % this.c), bVar) : this.a.a(aVar, bVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.c = 0;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.a.a(rVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        a((com.anythink.expressad.exoplayer.h.q) null, this.a);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* synthetic */ void a(java.lang.Void r1, com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        this.c = aeVar.c();
        a(this.b != Integer.MAX_VALUE ? new com.anythink.expressad.exoplayer.h.q.b(aeVar, this.b) : new com.anythink.expressad.exoplayer.h.q.a(aeVar), obj);
    }
}
