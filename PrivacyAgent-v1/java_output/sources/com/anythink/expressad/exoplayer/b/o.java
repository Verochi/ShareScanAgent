package com.anythink.expressad.exoplayer.b;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public final class o extends com.anythink.expressad.exoplayer.f.b implements com.anythink.expressad.exoplayer.k.n {
    private int A;
    private int B;
    private long C;
    private boolean D;
    private boolean E;
    private final android.content.Context r;

    /* renamed from: s, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.b.g.a f206s;
    private final com.anythink.expressad.exoplayer.b.h t;
    private int u;
    private boolean v;
    private boolean w;
    private android.media.MediaFormat x;
    private int y;
    private int z;

    public final class a implements com.anythink.expressad.exoplayer.b.h.c {
        private a() {
        }

        public /* synthetic */ a(com.anythink.expressad.exoplayer.b.o oVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a() {
            com.anythink.expressad.exoplayer.b.o.b(com.anythink.expressad.exoplayer.b.o.this);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i) {
            com.anythink.expressad.exoplayer.b.o.this.f206s.a(i);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i, long j, long j2) {
            com.anythink.expressad.exoplayer.b.o.this.f206s.a(i, j, j2);
        }
    }

    private o(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar) {
        this(context, cVar, null);
    }

    private o(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.g gVar) {
        this(context, cVar, null, handler, gVar);
    }

    private o(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        this(context, cVar, gVar, null, null);
    }

    private o(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.g gVar2) {
        this(context, cVar, gVar, handler, gVar2, null, new com.anythink.expressad.exoplayer.b.f[0]);
    }

    public o(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.g gVar2, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.c cVar2, com.anythink.expressad.exoplayer.b.f... fVarArr) {
        this(context, cVar, gVar, handler, gVar2, new com.anythink.expressad.exoplayer.b.l(cVar2, fVarArr));
    }

    private o(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.g gVar2, com.anythink.expressad.exoplayer.b.h hVar) {
        super(1, cVar, gVar, false);
        this.r = context.getApplicationContext();
        this.t = hVar;
        this.f206s = new com.anythink.expressad.exoplayer.b.g.a(handler, gVar2);
        hVar.a(new com.anythink.expressad.exoplayer.b.o.a(this, (byte) 0));
    }

    private static void C() {
    }

    private static void D() {
    }

    private static void E() {
    }

    private void F() {
        long a2 = this.t.a(v());
        if (a2 != Long.MIN_VALUE) {
            if (!this.E) {
                a2 = java.lang.Math.max(this.C, a2);
            }
            this.C = a2;
            this.E = false;
        }
    }

    private int a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar) {
        android.content.pm.PackageManager packageManager;
        int i = com.anythink.expressad.exoplayer.k.af.a;
        if (i < 24 && "OMX.google.raw.decoder".equals(aVar.c)) {
            if ((i == 23 && (packageManager = this.r.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) ? false : true) {
                return -1;
            }
        }
        return mVar.i;
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    private static android.media.MediaFormat a(com.anythink.expressad.exoplayer.m mVar, java.lang.String str, int i) {
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", mVar.u);
        mediaFormat.setInteger("sample-rate", mVar.v);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.j);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "max-input-size", i);
        if (com.anythink.expressad.exoplayer.k.af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        return mediaFormat;
    }

    private static boolean a(com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        return mVar.h.equals(mVar2.h) && mVar.u == mVar2.u && mVar.v == mVar2.v && mVar.x == 0 && mVar.y == 0 && mVar2.x == 0 && mVar2.y == 0 && mVar.b(mVar2);
    }

    private boolean a(java.lang.String str) {
        int e = com.anythink.expressad.exoplayer.k.o.e(str);
        return e != 0 && this.t.a(e);
    }

    private int b(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar) {
        android.content.pm.PackageManager packageManager;
        int i = com.anythink.expressad.exoplayer.k.af.a;
        if (i < 24 && "OMX.google.raw.decoder".equals(aVar.c)) {
            if ((i == 23 && (packageManager = this.r.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) ? false : true) {
                return -1;
            }
        }
        return mVar.i;
    }

    public static /* synthetic */ boolean b(com.anythink.expressad.exoplayer.b.o oVar) {
        oVar.E = true;
        return true;
    }

    private static boolean b(java.lang.String str) {
        if (com.anythink.expressad.exoplayer.k.af.a >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(com.anythink.expressad.exoplayer.k.af.c)) {
            return false;
        }
        java.lang.String str2 = com.anythink.expressad.exoplayer.k.af.b;
        return str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte");
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final int a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final int a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.m mVar) {
        boolean z;
        int i;
        int i2;
        java.lang.String str = mVar.h;
        boolean z2 = false;
        if (!com.anythink.expressad.exoplayer.k.o.a(str)) {
            return 0;
        }
        int i3 = com.anythink.expressad.exoplayer.k.af.a >= 21 ? 32 : 0;
        boolean a2 = com.anythink.expressad.exoplayer.a.a(gVar, mVar.k);
        if (a2 && a(str) && cVar.a() != null) {
            return i3 | 8 | 4;
        }
        if (("audio/raw".equals(str) && !this.t.a(mVar.w)) || !this.t.a(2)) {
            return 1;
        }
        com.anythink.expressad.exoplayer.d.e eVar = mVar.k;
        if (eVar != null) {
            z = false;
            for (int i4 = 0; i4 < eVar.b; i4++) {
                z |= eVar.a(i4).d;
            }
        } else {
            z = false;
        }
        com.anythink.expressad.exoplayer.f.a a3 = cVar.a(str, z);
        if (a3 == null) {
            return (!z || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!a2) {
            return 2;
        }
        if (com.anythink.expressad.exoplayer.k.af.a < 21 || (((i = mVar.v) == -1 || a3.a(i)) && ((i2 = mVar.u) == -1 || a3.b(i2)))) {
            z2 = true;
        }
        return i3 | 8 | (z2 ? 4 : 3);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final com.anythink.expressad.exoplayer.f.a a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.m mVar, boolean z) {
        com.anythink.expressad.exoplayer.f.a a2;
        return (!a(mVar.h) || (a2 = cVar.a()) == null) ? super.a(cVar, mVar, z) : a2;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar) {
        return this.t.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i, java.lang.Object obj) {
        if (i == 2) {
            this.t.a(((java.lang.Float) obj).floatValue());
        } else if (i != 3) {
            super.a(i, obj);
        } else {
            this.t.a((com.anythink.expressad.exoplayer.b.b) obj);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void a(long j, boolean z) {
        super.a(j, z);
        this.t.i();
        this.C = j;
        this.D = true;
        this.E = true;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
        int i;
        int[] iArr;
        int i2;
        android.media.MediaFormat mediaFormat2 = this.x;
        if (mediaFormat2 != null) {
            i = com.anythink.expressad.exoplayer.k.o.e(mediaFormat2.getString("mime"));
            mediaFormat = this.x;
        } else {
            i = this.y;
        }
        int i3 = i;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.w && integer == 6 && (i2 = this.z) < 6) {
            iArr = new int[i2];
            for (int i4 = 0; i4 < this.z; i4++) {
                iArr[i4] = i4;
            }
        } else {
            iArr = null;
        }
        try {
            this.t.a(i3, integer, integer2, iArr, this.A, this.B);
        } catch (com.anythink.expressad.exoplayer.b.h.a e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(com.anythink.expressad.exoplayer.c.e eVar) {
        if (!this.D || eVar.b()) {
            return;
        }
        if (java.lang.Math.abs(eVar.f - this.C) > 500000) {
            this.C = eVar.f;
        }
        this.D = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (r4.startsWith("heroqlte") == false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    @Override // com.anythink.expressad.exoplayer.f.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.anythink.expressad.exoplayer.f.a aVar, android.media.MediaCodec mediaCodec, com.anythink.expressad.exoplayer.m mVar, android.media.MediaCrypto mediaCrypto) {
        int i;
        java.lang.String str;
        java.lang.String str2;
        android.content.pm.PackageManager packageManager;
        q();
        int i2 = com.anythink.expressad.exoplayer.k.af.a;
        boolean z = true;
        if (i2 < 24 && "OMX.google.raw.decoder".equals(aVar.c)) {
            if ((i2 == 23 && (packageManager = this.r.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) ? false : true) {
                i = -1;
                this.u = i;
                java.lang.String str3 = aVar.c;
                if (i2 < 24 && "OMX.SEC.aac.dec".equals(str3) && "samsung".equals(com.anythink.expressad.exoplayer.k.af.c)) {
                    str2 = com.anythink.expressad.exoplayer.k.af.b;
                    if (!str2.startsWith("zeroflte")) {
                        if (!str2.startsWith("herolte")) {
                        }
                    }
                    this.w = z;
                    this.v = aVar.i;
                    str = aVar.d;
                    if (str == null) {
                        str = "audio/raw";
                    }
                    int i3 = this.u;
                    android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
                    mediaFormat.setString("mime", str);
                    mediaFormat.setInteger("channel-count", mVar.u);
                    mediaFormat.setInteger("sample-rate", mVar.v);
                    com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.j);
                    com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "max-input-size", i3);
                    if (i2 >= 23) {
                        mediaFormat.setInteger("priority", 0);
                    }
                    mediaCodec.configure(mediaFormat, (android.view.Surface) null, mediaCrypto, 0);
                    if (this.v) {
                        this.x = null;
                        return;
                    } else {
                        this.x = mediaFormat;
                        mediaFormat.setString("mime", mVar.h);
                        return;
                    }
                }
                z = false;
                this.w = z;
                this.v = aVar.i;
                str = aVar.d;
                if (str == null) {
                }
                int i32 = this.u;
                android.media.MediaFormat mediaFormat2 = new android.media.MediaFormat();
                mediaFormat2.setString("mime", str);
                mediaFormat2.setInteger("channel-count", mVar.u);
                mediaFormat2.setInteger("sample-rate", mVar.v);
                com.anythink.expressad.exoplayer.f.e.a(mediaFormat2, mVar.j);
                com.anythink.expressad.exoplayer.f.e.a(mediaFormat2, "max-input-size", i32);
                if (i2 >= 23) {
                }
                mediaCodec.configure(mediaFormat2, (android.view.Surface) null, mediaCrypto, 0);
                if (this.v) {
                }
            }
        }
        i = mVar.i;
        this.u = i;
        java.lang.String str32 = aVar.c;
        if (i2 < 24) {
            str2 = com.anythink.expressad.exoplayer.k.af.b;
            if (!str2.startsWith("zeroflte")) {
            }
            this.w = z;
            this.v = aVar.i;
            str = aVar.d;
            if (str == null) {
            }
            int i322 = this.u;
            android.media.MediaFormat mediaFormat22 = new android.media.MediaFormat();
            mediaFormat22.setString("mime", str);
            mediaFormat22.setInteger("channel-count", mVar.u);
            mediaFormat22.setInteger("sample-rate", mVar.v);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat22, mVar.j);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat22, "max-input-size", i322);
            if (i2 >= 23) {
            }
            mediaCodec.configure(mediaFormat22, (android.view.Surface) null, mediaCrypto, 0);
            if (this.v) {
            }
        }
        z = false;
        this.w = z;
        this.v = aVar.i;
        str = aVar.d;
        if (str == null) {
        }
        int i3222 = this.u;
        android.media.MediaFormat mediaFormat222 = new android.media.MediaFormat();
        mediaFormat222.setString("mime", str);
        mediaFormat222.setInteger("channel-count", mVar.u);
        mediaFormat222.setInteger("sample-rate", mVar.v);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat222, mVar.j);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat222, "max-input-size", i3222);
        if (i2 >= 23) {
        }
        mediaCodec.configure(mediaFormat222, (android.view.Surface) null, mediaCrypto, 0);
        if (this.v) {
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(java.lang.String str, long j, long j2) {
        this.f206s.a(str, j, j2);
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void a(boolean z) {
        super.a(z);
        this.f206s.a(((com.anythink.expressad.exoplayer.f.b) this).q);
        int i = r().b;
        if (i != 0) {
            this.t.c(i);
        } else {
            this.t.g();
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final boolean a(long j, long j2, android.media.MediaCodec mediaCodec, java.nio.ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.v && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            ((com.anythink.expressad.exoplayer.f.b) this).q.f++;
            this.t.b();
            return true;
        }
        try {
            if (!this.t.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            ((com.anythink.expressad.exoplayer.f.b) this).q.e++;
            return true;
        } catch (com.anythink.expressad.exoplayer.b.h.b | com.anythink.expressad.exoplayer.b.h.d e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void b(com.anythink.expressad.exoplayer.m mVar) {
        super.b(mVar);
        this.f206s.a(mVar);
        this.y = "audio/raw".equals(mVar.h) ? mVar.w : 2;
        this.z = mVar.u;
        this.A = mVar.x;
        this.B = mVar.y;
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.k.n c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        if (a_() == 2) {
            F();
        }
        return this.C;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v e() {
        return this.t.f();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void n() {
        super.n();
        this.t.a();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void o() {
        F();
        this.t.h();
        super.o();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void p() {
        try {
            this.t.j();
            try {
                super.p();
            } finally {
            }
        } catch (java.lang.Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean u() {
        return this.t.e() || super.u();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return super.v() && this.t.d();
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void w() {
        try {
            this.t.c();
        } catch (com.anythink.expressad.exoplayer.b.h.d e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }
}
