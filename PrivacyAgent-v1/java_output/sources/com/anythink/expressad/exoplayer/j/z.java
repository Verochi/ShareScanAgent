package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class z implements com.anythink.expressad.exoplayer.j.h {
    private final com.anythink.expressad.exoplayer.j.h a;
    private final com.anythink.expressad.exoplayer.j.g b;
    private boolean c;
    private long d;

    public z(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.g gVar) {
        this.a = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.b = (com.anythink.expressad.exoplayer.j.g) com.anythink.expressad.exoplayer.k.a.a(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (this.d == 0) {
            return -1;
        }
        int a = this.a.a(bArr, i, i2);
        if (a > 0) {
            this.b.a(bArr, i, a);
            long j = this.d;
            if (j != -1) {
                this.d = j - a;
            }
        }
        return a;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        long a = this.a.a(kVar);
        this.d = a;
        if (a == 0) {
            return 0L;
        }
        if (kVar.g == -1 && a != -1) {
            kVar = new com.anythink.expressad.exoplayer.j.k(kVar.c, kVar.e, kVar.f, a, kVar.h, kVar.i);
        }
        this.c = true;
        this.b.a(kVar);
        return this.d;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final android.net.Uri a() {
        return this.a.a();
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        try {
            this.a.b();
        } finally {
            if (this.c) {
                this.c = false;
                this.b.a();
            }
        }
    }
}
