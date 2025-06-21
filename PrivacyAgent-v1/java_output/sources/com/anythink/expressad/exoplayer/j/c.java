package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class c implements com.anythink.expressad.exoplayer.j.h {
    private final android.content.res.AssetManager a;
    private final com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.c> b;
    private android.net.Uri c;
    private java.io.InputStream d;
    private long e;
    private boolean f;

    public static final class a extends java.io.IOException {
        public a(java.io.IOException iOException) {
            super(iOException);
        }
    }

    private c(android.content.Context context) {
        this(context, null);
    }

    public c(android.content.Context context, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.c> aaVar) {
        this.a = context.getAssets();
        this.b = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) java.lang.Math.min(j, i2);
            } catch (java.io.IOException e) {
                throw new com.anythink.expressad.exoplayer.j.c.a(e);
            }
        }
        int read = this.d.read(bArr, i, i2);
        if (read == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new com.anythink.expressad.exoplayer.j.c.a(new java.io.EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - read;
        }
        com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.c> aaVar = this.b;
        if (aaVar != null) {
            aaVar.a(read);
        }
        return read;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        try {
            android.net.Uri uri = kVar.c;
            this.c = uri;
            java.lang.String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                path = path.substring(1);
            }
            java.io.InputStream open = this.a.open(path, 1);
            this.d = open;
            if (open.skip(kVar.f) < kVar.f) {
                throw new java.io.EOFException();
            }
            long j = kVar.g;
            if (j != -1) {
                this.e = j;
            } else {
                long available = this.d.available();
                this.e = available;
                if (available == 2147483647L) {
                    this.e = -1L;
                }
            }
            this.f = true;
            com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.c> aaVar = this.b;
            if (aaVar != null) {
                aaVar.b();
            }
            return this.e;
        } catch (java.io.IOException e) {
            throw new com.anythink.expressad.exoplayer.j.c.a(e);
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
                java.io.InputStream inputStream = this.d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (java.io.IOException e) {
                throw new com.anythink.expressad.exoplayer.j.c.a(e);
            }
        } finally {
            this.d = null;
            if (this.f) {
                this.f = false;
                com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.c> aaVar = this.b;
                if (aaVar != null) {
                    aaVar.c();
                }
            }
        }
    }
}
