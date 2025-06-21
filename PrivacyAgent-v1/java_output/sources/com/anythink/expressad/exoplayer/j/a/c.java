package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
public final class c implements com.anythink.expressad.exoplayer.j.h {
    public static final long a = 2097152;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 0;
    public static final int f = 1;
    private static final int g = -1;
    private static final long h = 102400;
    private boolean A;
    private long B;
    private long C;
    private final com.anythink.expressad.exoplayer.j.a.a i;
    private final com.anythink.expressad.exoplayer.j.h j;
    private final com.anythink.expressad.exoplayer.j.h k;
    private final com.anythink.expressad.exoplayer.j.h l;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.j.a.c.b m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private com.anythink.expressad.exoplayer.j.h q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private android.net.Uri f226s;
    private android.net.Uri t;
    private int u;
    private java.lang.String v;
    private long w;
    private long x;
    private com.anythink.expressad.exoplayer.j.a.e y;
    private boolean z;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    public interface b {
        void a();

        void b();
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    /* renamed from: com.anythink.expressad.exoplayer.j.a.c$c, reason: collision with other inner class name */
    public @interface InterfaceC0204c {
    }

    public c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar) {
        this(aVar, hVar, 0, (byte) 0);
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, int i) {
        this(aVar, hVar, i, (byte) 0);
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, int i, byte b2) {
        this(aVar, hVar, new com.anythink.expressad.exoplayer.j.r(), new com.anythink.expressad.exoplayer.j.a.b(aVar), i, null);
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.h hVar2, com.anythink.expressad.exoplayer.j.g gVar, int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.j.a.c.b bVar) {
        this.i = aVar;
        this.j = hVar2;
        this.n = (i & 1) != 0;
        this.o = (i & 2) != 0;
        this.p = (i & 4) != 0;
        this.l = hVar;
        this.k = new com.anythink.expressad.exoplayer.j.z(hVar, gVar);
        this.m = bVar;
    }

    private static android.net.Uri a(com.anythink.expressad.exoplayer.j.a.a aVar, java.lang.String str, android.net.Uri uri) {
        java.lang.String a2 = aVar.c(str).a(com.google.android.exoplayer2.upstream.cache.ContentMetadata.KEY_REDIRECTED_URI, (java.lang.String) null);
        android.net.Uri parse = a2 != null ? android.net.Uri.parse(a2) : null;
        return parse == null ? uri : parse;
    }

    private void a(boolean z) {
        com.anythink.expressad.exoplayer.j.a.e a2;
        long j;
        com.anythink.expressad.exoplayer.j.k kVar;
        com.anythink.expressad.exoplayer.j.h hVar;
        if (this.A) {
            a2 = null;
        } else if (this.n) {
            try {
                a2 = this.i.a(this.v, this.w);
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
                throw new java.io.InterruptedIOException();
            }
        } else {
            a2 = this.i.b(this.v, this.w);
        }
        if (a2 == null) {
            hVar = this.l;
            kVar = new com.anythink.expressad.exoplayer.j.k(this.f226s, this.w, this.x, this.v, this.u);
        } else if (a2.d) {
            android.net.Uri fromFile = android.net.Uri.fromFile(a2.e);
            long j2 = this.w - a2.b;
            long j3 = a2.c - j2;
            long j4 = this.x;
            if (j4 != -1) {
                j3 = java.lang.Math.min(j3, j4);
            }
            kVar = new com.anythink.expressad.exoplayer.j.k(fromFile, this.w, j2, j3, this.v, this.u);
            hVar = this.j;
        } else {
            if (a2.a()) {
                j = this.x;
            } else {
                j = a2.c;
                long j5 = this.x;
                if (j5 != -1) {
                    j = java.lang.Math.min(j, j5);
                }
            }
            com.anythink.expressad.exoplayer.j.k kVar2 = new com.anythink.expressad.exoplayer.j.k(this.f226s, this.w, j, this.v, this.u);
            com.anythink.expressad.exoplayer.j.h hVar2 = this.k;
            if (hVar2 == null) {
                hVar2 = this.l;
                this.i.a(a2);
                a2 = null;
            }
            kVar = kVar2;
            hVar = hVar2;
        }
        this.C = (this.A || hVar != this.l) ? Long.MAX_VALUE : this.w + 102400;
        if (z) {
            com.anythink.expressad.exoplayer.k.a.b(e());
            if (hVar == this.l) {
                return;
            }
            try {
                h();
            } catch (java.lang.Throwable th) {
                if (a2.b()) {
                    this.i.a(a2);
                }
                throw th;
            }
        }
        if (a2 != null && a2.b()) {
            this.y = a2;
        }
        this.q = hVar;
        this.r = kVar.g == -1;
        long a3 = hVar.a(kVar);
        com.anythink.expressad.exoplayer.j.a.k kVar3 = new com.anythink.expressad.exoplayer.j.a.k();
        if (this.r && a3 != -1) {
            this.x = a3;
            com.anythink.expressad.exoplayer.j.a.j.a(kVar3, this.w + a3);
        }
        if (d()) {
            android.net.Uri a4 = this.q.a();
            this.t = a4;
            if (true ^ this.f226s.equals(a4)) {
                com.anythink.expressad.exoplayer.j.a.j.a(kVar3, this.t);
            } else {
                kVar3.a(com.google.android.exoplayer2.upstream.cache.ContentMetadata.KEY_REDIRECTED_URI);
            }
        }
        if (g()) {
            this.i.a(this.v, kVar3);
        }
    }

    private static boolean a(java.io.IOException iOException) {
        for (java.io.IOException iOException2 = iOException; iOException2 != null; iOException2 = iOException2.getCause()) {
            if ((iOException2 instanceof com.anythink.expressad.exoplayer.j.i) && ((com.anythink.expressad.exoplayer.j.i) iOException2).b == 0) {
                return true;
            }
        }
        return false;
    }

    private int b(com.anythink.expressad.exoplayer.j.k kVar) {
        if (this.o && this.z) {
            return 0;
        }
        return (this.p && kVar.g == -1) ? 1 : -1;
    }

    private void b(java.io.IOException iOException) {
        if (f() || (iOException instanceof com.anythink.expressad.exoplayer.j.a.a.C0203a)) {
            this.z = true;
        }
    }

    private void c() {
        this.x = 0L;
        if (g()) {
            this.i.d(this.v, this.w);
        }
    }

    private boolean d() {
        return !f();
    }

    private boolean e() {
        return this.q == this.l;
    }

    private boolean f() {
        return this.q == this.j;
    }

    private boolean g() {
        return this.q == this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h() {
        com.anythink.expressad.exoplayer.j.h hVar = this.q;
        if (hVar == null) {
            return;
        }
        try {
            hVar.b();
        } finally {
            this.q = null;
            this.r = false;
            com.anythink.expressad.exoplayer.j.a.e eVar = this.y;
            if (eVar != null) {
                this.i.a(eVar);
                this.y = null;
            }
        }
    }

    private static void i() {
    }

    private void j() {
        if (this.m == null || this.B <= 0) {
            return;
        }
        this.i.c();
        this.B = 0L;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        if (this.x == 0) {
            return -1;
        }
        try {
            if (this.w >= this.C) {
                a(true);
            }
            int a2 = this.q.a(bArr, i, i2);
            if (a2 != -1) {
                if (f()) {
                    this.B += a2;
                }
                long j = a2;
                this.w += j;
                long j2 = this.x;
                if (j2 != -1) {
                    this.x = j2 - j;
                }
            } else {
                if (!this.r) {
                    long j3 = this.x;
                    if (j3 <= 0) {
                        if (j3 == -1) {
                        }
                    }
                    h();
                    a(false);
                    return a(bArr, i, i2);
                }
                c();
            }
            return a2;
        } catch (java.io.IOException e2) {
            if (this.r) {
                java.lang.Throwable th = e2;
                while (true) {
                    if (th != null) {
                        if ((th instanceof com.anythink.expressad.exoplayer.j.i) && ((com.anythink.expressad.exoplayer.j.i) th).b == 0) {
                            z = true;
                            break;
                        }
                        th = th.getCause();
                    } else {
                        break;
                    }
                }
                if (z) {
                    c();
                    return -1;
                }
            }
            b(e2);
            throw e2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        try {
            java.lang.String a2 = com.anythink.expressad.exoplayer.j.a.f.a(kVar);
            this.v = a2;
            android.net.Uri uri = kVar.c;
            this.f226s = uri;
            android.net.Uri uri2 = null;
            java.lang.String a3 = this.i.c(a2).a(com.google.android.exoplayer2.upstream.cache.ContentMetadata.KEY_REDIRECTED_URI, (java.lang.String) null);
            if (a3 != null) {
                uri2 = android.net.Uri.parse(a3);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.t = uri;
            this.u = kVar.i;
            this.w = kVar.f;
            boolean z = true;
            if (((this.o && this.z) ? (char) 0 : (this.p && kVar.g == -1) ? (char) 1 : (char) 65535) == 65535) {
                z = false;
            }
            this.A = z;
            long j = kVar.g;
            if (j == -1 && !z) {
                long b2 = this.i.b(this.v);
                this.x = b2;
                if (b2 != -1) {
                    long j2 = b2 - kVar.f;
                    this.x = j2;
                    if (j2 <= 0) {
                        throw new com.anythink.expressad.exoplayer.j.i();
                    }
                }
                a(false);
                return this.x;
            }
            this.x = j;
            a(false);
            return this.x;
        } catch (java.io.IOException e2) {
            b(e2);
            throw e2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final android.net.Uri a() {
        return this.t;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f226s = null;
        this.t = null;
        if (this.m != null && this.B > 0) {
            this.i.c();
            this.B = 0L;
        }
        try {
            h();
        } catch (java.io.IOException e2) {
            b(e2);
            throw e2;
        }
    }
}
