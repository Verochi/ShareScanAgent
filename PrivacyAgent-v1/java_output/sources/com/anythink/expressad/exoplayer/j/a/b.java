package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
public final class b implements com.anythink.expressad.exoplayer.j.g {
    public static final int a = 20480;
    private final com.anythink.expressad.exoplayer.j.a.a b;
    private final long c;
    private final int d;
    private final boolean e;
    private com.anythink.expressad.exoplayer.j.k f;
    private java.io.File g;
    private java.io.OutputStream h;
    private java.io.FileOutputStream i;
    private long j;
    private long k;
    private com.anythink.expressad.exoplayer.k.x l;

    public static class a extends com.anythink.expressad.exoplayer.j.a.a.C0203a {
        public a(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public b(com.anythink.expressad.exoplayer.j.a.a aVar) {
        this(aVar, 2097152L, 20480, true);
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j, int i) {
        this(aVar, j, i, true);
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j, int i, boolean z) {
        this.b = (com.anythink.expressad.exoplayer.j.a.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        this.c = j;
        this.d = i;
        this.e = z;
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j, boolean z) {
        this(aVar, j, 20480, z);
    }

    private void b() {
        long j = this.f.g;
        if (j != -1) {
            java.lang.Math.min(j - this.k, this.c);
        }
        com.anythink.expressad.exoplayer.j.a.a aVar = this.b;
        com.anythink.expressad.exoplayer.j.k kVar = this.f;
        this.g = aVar.c(kVar.h, kVar.e + this.k);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(this.g);
        this.i = fileOutputStream;
        if (this.d > 0) {
            com.anythink.expressad.exoplayer.k.x xVar = this.l;
            if (xVar == null) {
                this.l = new com.anythink.expressad.exoplayer.k.x(this.i, this.d);
            } else {
                xVar.a(fileOutputStream);
            }
            this.h = this.l;
        } else {
            this.h = fileOutputStream;
        }
        this.j = 0L;
    }

    private void c() {
        java.io.OutputStream outputStream = this.h;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            if (this.e) {
                this.i.getFD().sync();
            }
            com.anythink.expressad.exoplayer.k.af.a(this.h);
            this.h = null;
            java.io.File file = this.g;
            this.g = null;
            this.b.a(file);
        } catch (java.lang.Throwable th) {
            com.anythink.expressad.exoplayer.k.af.a(this.h);
            this.h = null;
            java.io.File file2 = this.g;
            this.g = null;
            file2.delete();
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a() {
        if (this.f == null) {
            return;
        }
        try {
            c();
        } catch (java.io.IOException e) {
            throw new com.anythink.expressad.exoplayer.j.a.b.a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a(com.anythink.expressad.exoplayer.j.k kVar) {
        if (kVar.g == -1 && !kVar.a(2)) {
            this.f = null;
            return;
        }
        this.f = kVar;
        this.k = 0L;
        try {
            b();
        } catch (java.io.IOException e) {
            throw new com.anythink.expressad.exoplayer.j.a.b.a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a(byte[] bArr, int i, int i2) {
        if (this.f == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.j == this.c) {
                    c();
                    b();
                }
                int min = (int) java.lang.Math.min(i2 - i3, this.c - this.j);
                this.h.write(bArr, i + i3, min);
                i3 += min;
                long j = min;
                this.j += j;
                this.k += j;
            } catch (java.io.IOException e) {
                throw new com.anythink.expressad.exoplayer.j.a.b.a(e);
            }
        }
    }
}
