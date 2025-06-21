package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class n implements com.anythink.expressad.exoplayer.j.h {
    private static final java.lang.String a = "DefaultDataSource";
    private static final java.lang.String b = "asset";
    private static final java.lang.String c = "content";
    private static final java.lang.String d = "rtmp";
    private static final java.lang.String e = "rawresource";
    private final android.content.Context f;
    private final com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> g;
    private final com.anythink.expressad.exoplayer.j.h h;
    private com.anythink.expressad.exoplayer.j.h i;
    private com.anythink.expressad.exoplayer.j.h j;
    private com.anythink.expressad.exoplayer.j.h k;
    private com.anythink.expressad.exoplayer.j.h l;
    private com.anythink.expressad.exoplayer.j.h m;
    private com.anythink.expressad.exoplayer.j.h n;
    private com.anythink.expressad.exoplayer.j.h o;

    public n(android.content.Context context, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> aaVar, com.anythink.expressad.exoplayer.j.h hVar) {
        this.f = context.getApplicationContext();
        this.g = aaVar;
        this.h = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
    }

    private n(android.content.Context context, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> aaVar, java.lang.String str, boolean z) {
        this(context, aaVar, str, z, (byte) 0);
    }

    private n(android.content.Context context, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> aaVar, java.lang.String str, boolean z, byte b2) {
        this(context, aaVar, new com.anythink.expressad.exoplayer.j.p(str, null, aaVar, 8000, 8000, z, null));
    }

    private com.anythink.expressad.exoplayer.j.h c() {
        if (this.i == null) {
            this.i = new com.anythink.expressad.exoplayer.j.r(this.g);
        }
        return this.i;
    }

    private com.anythink.expressad.exoplayer.j.h d() {
        if (this.j == null) {
            this.j = new com.anythink.expressad.exoplayer.j.c(this.f, this.g);
        }
        return this.j;
    }

    private com.anythink.expressad.exoplayer.j.h e() {
        if (this.k == null) {
            this.k = new com.anythink.expressad.exoplayer.j.e(this.f, this.g);
        }
        return this.k;
    }

    private com.anythink.expressad.exoplayer.j.h f() {
        if (this.l == null) {
            try {
                this.l = (com.anythink.expressad.exoplayer.j.h) java.lang.Class.forName("com.anythink.expressad.exoplayer.ext.rtmp.RtmpDataSource").getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
            } catch (java.lang.ClassNotFoundException unused) {
            } catch (java.lang.Exception e2) {
                throw new java.lang.RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.l == null) {
                this.l = this.h;
            }
        }
        return this.l;
    }

    private com.anythink.expressad.exoplayer.j.h g() {
        if (this.m == null) {
            this.m = new com.anythink.expressad.exoplayer.j.f();
        }
        return this.m;
    }

    private com.anythink.expressad.exoplayer.j.h h() {
        if (this.n == null) {
            this.n = new com.anythink.expressad.exoplayer.j.y(this.f, this.g);
        }
        return this.n;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        return this.o.a(bArr, i, i2);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.o == null);
        java.lang.String scheme = kVar.c.getScheme();
        if (com.anythink.expressad.exoplayer.k.af.a(kVar.c)) {
            if (kVar.c.getPath().startsWith("/android_asset/")) {
                this.o = d();
            } else {
                if (this.i == null) {
                    this.i = new com.anythink.expressad.exoplayer.j.r(this.g);
                }
                this.o = this.i;
            }
        } else if (b.equals(scheme)) {
            this.o = d();
        } else if ("content".equals(scheme)) {
            if (this.k == null) {
                this.k = new com.anythink.expressad.exoplayer.j.e(this.f, this.g);
            }
            this.o = this.k;
        } else if (d.equals(scheme)) {
            this.o = f();
        } else if ("data".equals(scheme)) {
            if (this.m == null) {
                this.m = new com.anythink.expressad.exoplayer.j.f();
            }
            this.o = this.m;
        } else if ("rawresource".equals(scheme)) {
            if (this.n == null) {
                this.n = new com.anythink.expressad.exoplayer.j.y(this.f, this.g);
            }
            this.o = this.n;
        } else {
            this.o = this.h;
        }
        return this.o.a(kVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final android.net.Uri a() {
        com.anythink.expressad.exoplayer.j.h hVar = this.o;
        if (hVar == null) {
            return null;
        }
        return hVar.a();
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        com.anythink.expressad.exoplayer.j.h hVar = this.o;
        if (hVar != null) {
            try {
                hVar.b();
            } finally {
                this.o = null;
            }
        }
    }
}
