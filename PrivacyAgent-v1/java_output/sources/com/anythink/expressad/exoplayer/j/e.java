package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class e implements com.anythink.expressad.exoplayer.j.h {
    private final android.content.ContentResolver a;
    private final com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.e> b;
    private android.net.Uri c;
    private android.content.res.AssetFileDescriptor d;
    private java.io.FileInputStream e;
    private long f;
    private boolean g;

    public static class a extends java.io.IOException {
        public a(java.io.IOException iOException) {
            super(iOException);
        }
    }

    private e(android.content.Context context) {
        this(context, null);
    }

    public e(android.content.Context context, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.e> aaVar) {
        this.a = context.getContentResolver();
        this.b = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) java.lang.Math.min(j, i2);
            } catch (java.io.IOException e) {
                throw new com.anythink.expressad.exoplayer.j.e.a(e);
            }
        }
        int read = this.e.read(bArr, i, i2);
        if (read == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new com.anythink.expressad.exoplayer.j.e.a(new java.io.EOFException());
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - read;
        }
        com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.e> aaVar = this.b;
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
            android.content.res.AssetFileDescriptor openAssetFileDescriptor = this.a.openAssetFileDescriptor(uri, "r");
            this.d = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new java.io.FileNotFoundException("Could not open file descriptor for: " + this.c);
            }
            this.e = new java.io.FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            long skip = this.e.skip(kVar.f + startOffset) - startOffset;
            if (skip != kVar.f) {
                throw new java.io.EOFException();
            }
            long j = kVar.g;
            long j2 = -1;
            if (j != -1) {
                this.f = j;
            } else {
                long length = this.d.getLength();
                if (length == -1) {
                    java.nio.channels.FileChannel channel = this.e.getChannel();
                    long size = channel.size();
                    if (size != 0) {
                        j2 = size - channel.position();
                    }
                    this.f = j2;
                } else {
                    this.f = length - skip;
                }
            }
            this.g = true;
            com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.e> aaVar = this.b;
            if (aaVar != null) {
                aaVar.b();
            }
            return this.f;
        } catch (java.io.IOException e) {
            throw new com.anythink.expressad.exoplayer.j.e.a(e);
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
                java.io.FileInputStream fileInputStream = this.e;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.e = null;
                try {
                    try {
                        android.content.res.AssetFileDescriptor assetFileDescriptor = this.d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (java.io.IOException e) {
                        throw new com.anythink.expressad.exoplayer.j.e.a(e);
                    }
                } finally {
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.e> aaVar = this.b;
                        if (aaVar != null) {
                            aaVar.c();
                        }
                    }
                }
            } catch (java.io.IOException e2) {
                throw new com.anythink.expressad.exoplayer.j.e.a(e2);
            }
        } catch (java.lang.Throwable th) {
            this.e = null;
            try {
                try {
                    android.content.res.AssetFileDescriptor assetFileDescriptor2 = this.d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.e> aaVar2 = this.b;
                        if (aaVar2 != null) {
                            aaVar2.c();
                        }
                    }
                    throw th;
                } catch (java.io.IOException e3) {
                    throw new com.anythink.expressad.exoplayer.j.e.a(e3);
                }
            } finally {
                this.d = null;
                if (this.g) {
                    this.g = false;
                    com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.e> aaVar3 = this.b;
                    if (aaVar3 != null) {
                        aaVar3.c();
                    }
                }
            }
        }
    }
}
