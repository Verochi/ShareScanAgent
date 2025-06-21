package com.anythink.expressad.exoplayer.i;

/* loaded from: classes12.dex */
public final class d extends com.anythink.expressad.exoplayer.i.b {
    private final int a;

    @androidx.annotation.Nullable
    private final java.lang.Object b;

    public static final class a implements com.anythink.expressad.exoplayer.i.f.a {
        private final int a;

        @androidx.annotation.Nullable
        private final java.lang.Object b;

        public a() {
            this.a = 0;
            this.b = null;
        }

        private a(int i, @androidx.annotation.Nullable java.lang.Object obj) {
            this.a = i;
            this.b = obj;
        }

        private com.anythink.expressad.exoplayer.i.d b(com.anythink.expressad.exoplayer.h.ae aeVar, int... iArr) {
            com.anythink.expressad.exoplayer.k.a.a(iArr.length == 1);
            return new com.anythink.expressad.exoplayer.i.d(aeVar, iArr[0], this.a, this.b);
        }

        @Override // com.anythink.expressad.exoplayer.i.f.a
        public final /* synthetic */ com.anythink.expressad.exoplayer.i.f a(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr) {
            com.anythink.expressad.exoplayer.k.a.a(iArr.length == 1);
            return new com.anythink.expressad.exoplayer.i.d(aeVar, iArr[0], this.a, this.b);
        }
    }

    public d(com.anythink.expressad.exoplayer.h.ae aeVar, int i) {
        this(aeVar, i, 0, null);
    }

    public d(com.anythink.expressad.exoplayer.h.ae aeVar, int i, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
        super(aeVar, i);
        this.a = i2;
        this.b = obj;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final void a(long j, long j2) {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b() {
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c() {
        return this.a;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    @androidx.annotation.Nullable
    public final java.lang.Object d() {
        return this.b;
    }
}
