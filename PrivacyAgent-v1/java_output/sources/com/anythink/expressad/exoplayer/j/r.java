package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class r implements com.anythink.expressad.exoplayer.j.h {
    private final com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.r> a;
    private java.io.RandomAccessFile b;
    private android.net.Uri c;
    private long d;
    private boolean e;

    public static class a extends java.io.IOException {
        public a(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public r() {
        this(null);
    }

    public r(com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.r> aaVar) {
        this.a = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.b.read(bArr, i, (int) java.lang.Math.min(j, i2));
            if (read > 0) {
                this.d -= read;
                com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.r> aaVar = this.a;
                if (aaVar != null) {
                    aaVar.a(read);
                }
            }
            return read;
        } catch (java.io.IOException e) {
            throw new com.anythink.expressad.exoplayer.j.r.a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        try {
            this.c = kVar.c;
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(kVar.c.getPath(), "r");
            this.b = randomAccessFile;
            randomAccessFile.seek(kVar.f);
            long j = kVar.g;
            if (j == -1) {
                j = this.b.length() - kVar.f;
            }
            this.d = j;
            if (j < 0) {
                throw new java.io.EOFException();
            }
            this.e = true;
            com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.r> aaVar = this.a;
            if (aaVar != null) {
                aaVar.b();
            }
            return this.d;
        } catch (java.io.IOException e) {
            throw new com.anythink.expressad.exoplayer.j.r.a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final android.net.Uri a() {
        return this.c;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.c = null;
        try {
            try {
                java.io.RandomAccessFile randomAccessFile = this.b;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (java.io.IOException e) {
                throw new com.anythink.expressad.exoplayer.j.r.a(e);
            }
        } finally {
            this.b = null;
            if (this.e) {
                this.e = false;
                com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.r> aaVar = this.a;
                if (aaVar != null) {
                    aaVar.c();
                }
            }
        }
    }
}
