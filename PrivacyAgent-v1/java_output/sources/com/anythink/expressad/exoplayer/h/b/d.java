package com.anythink.expressad.exoplayer.h.b;

/* loaded from: classes12.dex */
public final class d implements com.anythink.expressad.exoplayer.e.g {
    public final com.anythink.expressad.exoplayer.e.e a;
    private final int b;
    private final com.anythink.expressad.exoplayer.m c;
    private final android.util.SparseArray<com.anythink.expressad.exoplayer.h.b.d.a> d = new android.util.SparseArray<>();
    private boolean e;
    private com.anythink.expressad.exoplayer.h.b.d.b f;
    private com.anythink.expressad.exoplayer.e.k g;
    private com.anythink.expressad.exoplayer.m[] h;

    public static final class a implements com.anythink.expressad.exoplayer.e.m {
        public com.anythink.expressad.exoplayer.m a;
        private final int b;
        private final int c;
        private final com.anythink.expressad.exoplayer.m d;
        private com.anythink.expressad.exoplayer.e.m e;

        public a(int i, int i2, com.anythink.expressad.exoplayer.m mVar) {
            this.b = i;
            this.c = i2;
            this.d = mVar;
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final int a(com.anythink.expressad.exoplayer.e.f fVar, int i, boolean z) {
            return this.e.a(fVar, i, z);
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(long j, int i, int i2, int i3, com.anythink.expressad.exoplayer.e.m.a aVar) {
            this.e.a(j, i, i2, i3, aVar);
        }

        public final void a(com.anythink.expressad.exoplayer.h.b.d.b bVar) {
            if (bVar == null) {
                this.e = new com.anythink.expressad.exoplayer.e.d();
                return;
            }
            com.anythink.expressad.exoplayer.e.m a = bVar.a(this.c);
            this.e = a;
            com.anythink.expressad.exoplayer.m mVar = this.a;
            if (mVar != null) {
                a.a(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(com.anythink.expressad.exoplayer.k.s sVar, int i) {
            this.e.a(sVar, i);
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(com.anythink.expressad.exoplayer.m mVar) {
            com.anythink.expressad.exoplayer.m mVar2 = this.d;
            if (mVar2 != null) {
                mVar = mVar.a(mVar2);
            }
            this.a = mVar;
            this.e.a(mVar);
        }
    }

    public interface b {
        com.anythink.expressad.exoplayer.e.m a(int i);
    }

    private d(com.anythink.expressad.exoplayer.e.e eVar, int i, com.anythink.expressad.exoplayer.m mVar) {
        this.a = eVar;
        this.b = i;
        this.c = mVar;
    }

    private com.anythink.expressad.exoplayer.e.k b() {
        return this.g;
    }

    private com.anythink.expressad.exoplayer.m[] c() {
        return this.h;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final com.anythink.expressad.exoplayer.e.m a(int i, int i2) {
        com.anythink.expressad.exoplayer.h.b.d.a aVar = this.d.get(i);
        if (aVar == null) {
            com.anythink.expressad.exoplayer.k.a.b(this.h == null);
            aVar = new com.anythink.expressad.exoplayer.h.b.d.a(i, i2, i2 == this.b ? this.c : null);
            aVar.a(this.f);
            this.d.put(i, aVar);
        }
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void a(com.anythink.expressad.exoplayer.e.k kVar) {
        this.g = kVar;
    }

    public final void a(com.anythink.expressad.exoplayer.h.b.d.b bVar, long j) {
        this.f = bVar;
        if (!this.e) {
            this.a.a(this);
            if (j != -9223372036854775807L) {
                this.a.a(0L, j);
            }
            this.e = true;
            return;
        }
        com.anythink.expressad.exoplayer.e.e eVar = this.a;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        eVar.a(0L, j);
        for (int i = 0; i < this.d.size(); i++) {
            this.d.valueAt(i).a(bVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void c_() {
        com.anythink.expressad.exoplayer.m[] mVarArr = new com.anythink.expressad.exoplayer.m[this.d.size()];
        for (int i = 0; i < this.d.size(); i++) {
            mVarArr[i] = this.d.valueAt(i).a;
        }
        this.h = mVarArr;
    }
}
