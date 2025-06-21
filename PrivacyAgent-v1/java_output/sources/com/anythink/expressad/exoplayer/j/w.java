package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class w implements com.anythink.expressad.exoplayer.j.h {
    private final com.anythink.expressad.exoplayer.j.h a;
    private final com.anythink.expressad.exoplayer.k.v b;
    private final int c;

    public w(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.k.v vVar, int i) {
        this.a = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.b = (com.anythink.expressad.exoplayer.k.v) com.anythink.expressad.exoplayer.k.a.a(vVar);
        this.c = i;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        this.b.a(this.c);
        return this.a.a(bArr, i, i2);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        this.b.a(this.c);
        return this.a.a(kVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    @androidx.annotation.Nullable
    public final android.net.Uri a() {
        return this.a.a();
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.a.b();
    }
}
