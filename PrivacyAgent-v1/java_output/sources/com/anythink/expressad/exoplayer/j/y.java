package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class y implements com.anythink.expressad.exoplayer.j.h {
    public static final java.lang.String a = "rawresource";
    private final android.content.res.Resources b;
    private final com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.y> c;
    private android.net.Uri d;
    private android.content.res.AssetFileDescriptor e;
    private java.io.InputStream f;
    private long g;
    private boolean h;

    public static class a extends java.io.IOException {
        public a(java.io.IOException iOException) {
            super(iOException);
        }

        public a(java.lang.String str) {
            super(str);
        }
    }

    private y(android.content.Context context) {
        this(context, null);
    }

    public y(android.content.Context context, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.y> aaVar) {
        this.b = context.getResources();
        this.c = aaVar;
    }

    private static android.net.Uri a(int i) {
        return android.net.Uri.parse("rawresource:///".concat(java.lang.String.valueOf(i)));
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.g;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) java.lang.Math.min(j, i2);
            } catch (java.io.IOException e) {
                throw new com.anythink.expressad.exoplayer.j.y.a(e);
            }
        }
        int read = this.f.read(bArr, i, i2);
        if (read == -1) {
            if (this.g == -1) {
                return -1;
            }
            throw new com.anythink.expressad.exoplayer.j.y.a(new java.io.EOFException());
        }
        long j2 = this.g;
        if (j2 != -1) {
            this.g = j2 - read;
        }
        com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.y> aaVar = this.c;
        if (aaVar != null) {
            aaVar.a(read);
        }
        return read;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        try {
            android.net.Uri uri = kVar.c;
            this.d = uri;
            if (!android.text.TextUtils.equals("rawresource", uri.getScheme())) {
                throw new com.anythink.expressad.exoplayer.j.y.a("URI must use scheme rawresource");
            }
            try {
                this.e = this.b.openRawResourceFd(java.lang.Integer.parseInt(this.d.getLastPathSegment()));
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(this.e.getFileDescriptor());
                this.f = fileInputStream;
                fileInputStream.skip(this.e.getStartOffset());
                if (this.f.skip(kVar.f) < kVar.f) {
                    throw new java.io.EOFException();
                }
                long j = kVar.g;
                long j2 = -1;
                if (j != -1) {
                    this.g = j;
                } else {
                    long length = this.e.getLength();
                    if (length != -1) {
                        j2 = length - kVar.f;
                    }
                    this.g = j2;
                }
                this.h = true;
                com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.y> aaVar = this.c;
                if (aaVar != null) {
                    aaVar.b();
                }
                return this.g;
            } catch (java.lang.NumberFormatException unused) {
                throw new com.anythink.expressad.exoplayer.j.y.a("Resource identifier must be an integer.");
            }
        } catch (java.io.IOException e) {
            throw new com.anythink.expressad.exoplayer.j.y.a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final android.net.Uri a() {
        return this.d;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.d = null;
        try {
            try {
                java.io.InputStream inputStream = this.f;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f = null;
                try {
                    try {
                        android.content.res.AssetFileDescriptor assetFileDescriptor = this.e;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (java.io.IOException e) {
                        throw new com.anythink.expressad.exoplayer.j.y.a(e);
                    }
                } finally {
                    this.e = null;
                    if (this.h) {
                        this.h = false;
                        com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.y> aaVar = this.c;
                        if (aaVar != null) {
                            aaVar.c();
                        }
                    }
                }
            } catch (java.io.IOException e2) {
                throw new com.anythink.expressad.exoplayer.j.y.a(e2);
            }
        } catch (java.lang.Throwable th) {
            this.f = null;
            try {
                try {
                    android.content.res.AssetFileDescriptor assetFileDescriptor2 = this.e;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.e = null;
                    if (this.h) {
                        this.h = false;
                        com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.y> aaVar2 = this.c;
                        if (aaVar2 != null) {
                            aaVar2.c();
                        }
                    }
                    throw th;
                } catch (java.io.IOException e3) {
                    throw new com.anythink.expressad.exoplayer.j.y.a(e3);
                }
            } finally {
                this.e = null;
                if (this.h) {
                    this.h = false;
                    com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.y> aaVar3 = this.c;
                    if (aaVar3 != null) {
                        aaVar3.c();
                    }
                }
            }
        }
    }
}
