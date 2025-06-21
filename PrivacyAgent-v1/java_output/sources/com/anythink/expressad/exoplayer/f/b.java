package com.anythink.expressad.exoplayer.f;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public abstract class b extends com.anythink.expressad.exoplayer.a {
    private static final int A = 1;
    private static final int B = 2;
    private static final byte[] C = com.anythink.expressad.exoplayer.k.af.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int D = 32;
    protected static final int n = 0;
    protected static final int o = 1;
    protected static final int p = 3;
    private static final java.lang.String r = "MediaCodecRenderer";

    /* renamed from: s, reason: collision with root package name */
    private static final long f218s = 1000;
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 0;
    private static final int x = 1;
    private static final int y = 2;
    private static final int z = 0;
    private final com.anythink.expressad.exoplayer.f.c E;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> F;
    private final boolean G;
    private final com.anythink.expressad.exoplayer.c.e H;
    private final com.anythink.expressad.exoplayer.c.e I;
    private final com.anythink.expressad.exoplayer.n J;
    private final java.util.List<java.lang.Long> K;
    private final android.media.MediaCodec.BufferInfo L;
    private com.anythink.expressad.exoplayer.m M;
    private com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> N;
    private com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> O;
    private android.media.MediaCodec P;
    private com.anythink.expressad.exoplayer.f.a Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private java.nio.ByteBuffer[] aa;
    private java.nio.ByteBuffer[] ab;
    private long ac;
    private int ad;
    private int ae;
    private java.nio.ByteBuffer af;
    private boolean ag;
    private boolean ah;
    private int ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    protected com.anythink.expressad.exoplayer.c.d q;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* renamed from: com.anythink.expressad.exoplayer.f.b$b, reason: collision with other inner class name */
    public static class C0192b extends java.lang.Exception {
        private static final int e = -50000;
        private static final int f = -49999;
        private static final int g = -49998;
        public final java.lang.String a;
        public final boolean b;
        public final java.lang.String c;
        public final java.lang.String d;

        public C0192b(com.anythink.expressad.exoplayer.m mVar, java.lang.Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + mVar, th);
            this.a = mVar.h;
            this.b = z;
            this.c = null;
            this.d = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + java.lang.Math.abs(i);
        }

        public C0192b(com.anythink.expressad.exoplayer.m mVar, java.lang.Throwable th, boolean z, java.lang.String str) {
            super("Decoder init failed: " + str + ", " + mVar, th);
            this.a = mVar.h;
            this.b = z;
            this.c = str;
            java.lang.String str2 = null;
            if (com.anythink.expressad.exoplayer.k.af.a >= 21 && (th instanceof android.media.MediaCodec.CodecException)) {
                str2 = ((android.media.MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            this.d = str2;
        }

        private static java.lang.String a(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + java.lang.Math.abs(i);
        }

        @android.annotation.TargetApi(21)
        private static java.lang.String a(java.lang.Throwable th) {
            if (th instanceof android.media.MediaCodec.CodecException) {
                return ((android.media.MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface c {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface d {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface e {
    }

    public b(int i, com.anythink.expressad.exoplayer.f.c cVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, boolean z2) {
        super(i);
        com.anythink.expressad.exoplayer.k.a.b(com.anythink.expressad.exoplayer.k.af.a >= 16);
        this.E = (com.anythink.expressad.exoplayer.f.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
        this.F = gVar;
        this.G = false;
        this.H = new com.anythink.expressad.exoplayer.c.e(0);
        this.I = com.anythink.expressad.exoplayer.c.e.e();
        this.J = new com.anythink.expressad.exoplayer.n();
        this.K = new java.util.ArrayList();
        this.L = new android.media.MediaCodec.BufferInfo();
        this.ai = 0;
        this.aj = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0157 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean C() {
        int position;
        int a2;
        boolean z2;
        android.media.MediaCodec mediaCodec = this.P;
        if (mediaCodec == null || this.aj == 2 || this.am) {
            return false;
        }
        if (this.ad < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.ad = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            this.H.e = com.anythink.expressad.exoplayer.k.af.a >= 21 ? this.P.getInputBuffer(dequeueInputBuffer) : this.aa[dequeueInputBuffer];
            this.H.a();
        }
        if (this.aj == 1) {
            if (!this.U) {
                this.al = true;
                this.P.queueInputBuffer(this.ad, 0, 0, 0L, 4);
                G();
            }
            this.aj = 2;
            return false;
        }
        if (this.Y) {
            this.Y = false;
            java.nio.ByteBuffer byteBuffer = this.H.e;
            byte[] bArr = C;
            byteBuffer.put(bArr);
            this.P.queueInputBuffer(this.ad, 0, bArr.length, 0L, 0);
            G();
            this.ak = true;
            return true;
        }
        if (this.ao) {
            a2 = -4;
            position = 0;
        } else {
            if (this.ai == 1) {
                for (int i = 0; i < this.M.j.size(); i++) {
                    this.H.e.put(this.M.j.get(i));
                }
                this.ai = 2;
            }
            position = this.H.e.position();
            a2 = a(this.J, this.H, false);
        }
        if (a2 == -3) {
            return false;
        }
        if (a2 == -5) {
            if (this.ai == 2) {
                this.H.a();
                this.ai = 1;
            }
            b(this.J.a);
            return true;
        }
        if (this.H.c()) {
            if (this.ai == 2) {
                this.H.a();
                this.ai = 1;
            }
            this.am = true;
            if (!this.ak) {
                L();
                return false;
            }
            try {
                if (!this.U) {
                    this.al = true;
                    this.P.queueInputBuffer(this.ad, 0, 0, 0L, 4);
                    G();
                }
                return false;
            } catch (java.lang.Exception e2) {
                throw com.anythink.expressad.exoplayer.g.a(e2, s());
            }
        }
        if (this.ap && !this.H.d()) {
            this.H.a();
            if (this.ai == 2) {
                this.ai = 1;
            }
            return true;
        }
        this.ap = false;
        boolean g = this.H.g();
        com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar = this.N;
        if (fVar != null && (g || !this.G)) {
            int e3 = fVar.e();
            if (e3 == 1) {
                throw com.anythink.expressad.exoplayer.g.a(this.N.f(), s());
            }
            if (e3 != 4) {
                z2 = true;
                this.ao = z2;
                if (!z2) {
                    return false;
                }
                if (this.S && !g) {
                    com.anythink.expressad.exoplayer.k.p.a(this.H.e);
                    if (this.H.e.position() == 0) {
                        return true;
                    }
                    this.S = false;
                }
                try {
                    com.anythink.expressad.exoplayer.c.e eVar = this.H;
                    long j = eVar.f;
                    if (eVar.b()) {
                        this.K.add(java.lang.Long.valueOf(j));
                    }
                    this.H.h();
                    a(this.H);
                    if (g) {
                        android.media.MediaCodec.CryptoInfo a3 = this.H.d.a();
                        if (position != 0) {
                            if (a3.numBytesOfClearData == null) {
                                a3.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = a3.numBytesOfClearData;
                            iArr[0] = iArr[0] + position;
                        }
                        this.P.queueSecureInputBuffer(this.ad, 0, a3, j, 0);
                    } else {
                        this.P.queueInputBuffer(this.ad, 0, this.H.e.limit(), j, 0);
                    }
                    G();
                    this.ak = true;
                    this.ai = 0;
                    this.q.c++;
                    return true;
                } catch (java.lang.Exception e4) {
                    throw com.anythink.expressad.exoplayer.g.a(e4, s());
                }
            }
        }
        z2 = false;
        this.ao = z2;
        if (!z2) {
        }
    }

    private void D() {
        if (com.anythink.expressad.exoplayer.k.af.a < 21) {
            this.aa = this.P.getInputBuffers();
            this.ab = this.P.getOutputBuffers();
        }
    }

    private void E() {
        if (com.anythink.expressad.exoplayer.k.af.a < 21) {
            this.aa = null;
            this.ab = null;
        }
    }

    private boolean F() {
        return this.ae >= 0;
    }

    private void G() {
        this.ad = -1;
        this.H.e = null;
    }

    private void H() {
        this.ae = -1;
        this.af = null;
    }

    private static long I() {
        return 0L;
    }

    private void J() {
        android.media.MediaFormat outputFormat = this.P.getOutputFormat();
        if (this.R != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.Z = true;
            return;
        }
        if (this.X) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.P, outputFormat);
    }

    private void K() {
        if (com.anythink.expressad.exoplayer.k.af.a < 21) {
            this.ab = this.P.getOutputBuffers();
        }
    }

    private void L() {
        if (this.aj == 2) {
            A();
            x();
        } else {
            this.an = true;
            w();
        }
    }

    private static boolean M() {
        if (!"Amazon".equals(com.anythink.expressad.exoplayer.k.af.c)) {
            return false;
        }
        java.lang.String str = com.anythink.expressad.exoplayer.k.af.d;
        return "AFTM".equals(str) || "AFTB".equals(str);
    }

    private static android.media.MediaCodec.CryptoInfo a(com.anythink.expressad.exoplayer.c.e eVar, int i) {
        android.media.MediaCodec.CryptoInfo a2 = eVar.d.a();
        if (i == 0) {
            return a2;
        }
        if (a2.numBytesOfClearData == null) {
            a2.numBytesOfClearData = new int[1];
        }
        int[] iArr = a2.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return a2;
    }

    private void a(com.anythink.expressad.exoplayer.f.b.C0192b c0192b) {
        throw com.anythink.expressad.exoplayer.g.a(c0192b, s());
    }

    private static boolean a(java.lang.String str) {
        int i = com.anythink.expressad.exoplayer.k.af.a;
        if (i < 18) {
            return true;
        }
        if (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (i == 19 && com.anythink.expressad.exoplayer.k.af.d.startsWith("SM-G800")) {
            return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
        }
        return false;
    }

    private static boolean a(java.lang.String str, com.anythink.expressad.exoplayer.m mVar) {
        return com.anythink.expressad.exoplayer.k.af.a < 21 && mVar.j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static int b(java.lang.String str) {
        int i = com.anythink.expressad.exoplayer.k.af.a;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            java.lang.String str2 = com.anythink.expressad.exoplayer.k.af.d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        java.lang.String str3 = com.anythink.expressad.exoplayer.k.af.b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private java.nio.ByteBuffer b(int i) {
        return com.anythink.expressad.exoplayer.k.af.a >= 21 ? this.P.getInputBuffer(i) : this.aa[i];
    }

    private boolean b(long j, long j2) {
        boolean a2;
        int dequeueOutputBuffer;
        boolean z2;
        if (!F()) {
            if (this.W && this.al) {
                try {
                    dequeueOutputBuffer = this.P.dequeueOutputBuffer(this.L, 0L);
                } catch (java.lang.IllegalStateException unused) {
                    L();
                    if (this.an) {
                        A();
                    }
                    return false;
                }
            } else {
                dequeueOutputBuffer = this.P.dequeueOutputBuffer(this.L, 0L);
            }
            if (dequeueOutputBuffer < 0) {
                if (dequeueOutputBuffer == -2) {
                    android.media.MediaFormat outputFormat = this.P.getOutputFormat();
                    if (this.R != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                        this.Z = true;
                    } else {
                        if (this.X) {
                            outputFormat.setInteger("channel-count", 1);
                        }
                        a(this.P, outputFormat);
                    }
                    return true;
                }
                if (dequeueOutputBuffer == -3) {
                    if (com.anythink.expressad.exoplayer.k.af.a < 21) {
                        this.ab = this.P.getOutputBuffers();
                    }
                    return true;
                }
                if (this.U && (this.am || this.aj == 2)) {
                    L();
                }
                return false;
            }
            if (this.Z) {
                this.Z = false;
                this.P.releaseOutputBuffer(dequeueOutputBuffer, false);
                return true;
            }
            android.media.MediaCodec.BufferInfo bufferInfo = this.L;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                L();
                return false;
            }
            this.ae = dequeueOutputBuffer;
            java.nio.ByteBuffer outputBuffer = com.anythink.expressad.exoplayer.k.af.a >= 21 ? this.P.getOutputBuffer(dequeueOutputBuffer) : this.ab[dequeueOutputBuffer];
            this.af = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(this.L.offset);
                java.nio.ByteBuffer byteBuffer = this.af;
                android.media.MediaCodec.BufferInfo bufferInfo2 = this.L;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            long j3 = this.L.presentationTimeUs;
            int size = this.K.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z2 = false;
                    break;
                }
                if (this.K.get(i).longValue() == j3) {
                    this.K.remove(i);
                    z2 = true;
                    break;
                }
                i++;
            }
            this.ag = z2;
        }
        if (this.W && this.al) {
            try {
                android.media.MediaCodec mediaCodec = this.P;
                java.nio.ByteBuffer byteBuffer2 = this.af;
                int i2 = this.ae;
                android.media.MediaCodec.BufferInfo bufferInfo3 = this.L;
                a2 = a(j, j2, mediaCodec, byteBuffer2, i2, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.ag);
            } catch (java.lang.IllegalStateException unused2) {
                L();
                if (this.an) {
                    A();
                }
                return false;
            }
        } else {
            android.media.MediaCodec mediaCodec2 = this.P;
            java.nio.ByteBuffer byteBuffer3 = this.af;
            int i3 = this.ae;
            android.media.MediaCodec.BufferInfo bufferInfo4 = this.L;
            a2 = a(j, j2, mediaCodec2, byteBuffer3, i3, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.ag);
        }
        if (a2) {
            c(this.L.presentationTimeUs);
            boolean z3 = (this.L.flags & 4) != 0;
            H();
            if (!z3) {
                return true;
            }
            L();
        }
        return false;
    }

    private static boolean b(com.anythink.expressad.exoplayer.f.a aVar) {
        java.lang.String str = aVar.c;
        if (com.anythink.expressad.exoplayer.k.af.a > 17 || !("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) {
            return "Amazon".equals(com.anythink.expressad.exoplayer.k.af.c) && "AFTS".equals(com.anythink.expressad.exoplayer.k.af.d) && aVar.h;
        }
        return true;
    }

    private static boolean b(java.lang.String str, com.anythink.expressad.exoplayer.m mVar) {
        return com.anythink.expressad.exoplayer.k.af.a <= 18 && mVar.u == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private boolean b(boolean z2) {
        com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar = this.N;
        if (fVar == null || (!z2 && this.G)) {
            return false;
        }
        int e2 = fVar.e();
        if (e2 != 1) {
            return e2 != 4;
        }
        throw com.anythink.expressad.exoplayer.g.a(this.N.f(), s());
    }

    private java.nio.ByteBuffer c(int i) {
        return com.anythink.expressad.exoplayer.k.af.a >= 21 ? this.P.getOutputBuffer(i) : this.ab[i];
    }

    private static boolean c(java.lang.String str) {
        int i = com.anythink.expressad.exoplayer.k.af.a;
        if (i <= 23 && "OMX.google.vorbis.decoder".equals(str)) {
            return true;
        }
        if (i > 19 || !"hb2000".equals(com.anythink.expressad.exoplayer.k.af.b)) {
            return false;
        }
        return "OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str);
    }

    private boolean d(long j) {
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            if (this.K.get(i).longValue() == j) {
                this.K.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean d(java.lang.String str) {
        return com.anythink.expressad.exoplayer.k.af.a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public void A() {
        this.ac = -9223372036854775807L;
        G();
        H();
        this.ao = false;
        this.ag = false;
        this.K.clear();
        if (com.anythink.expressad.exoplayer.k.af.a < 21) {
            this.aa = null;
            this.ab = null;
        }
        this.Q = null;
        this.ah = false;
        this.ak = false;
        this.S = false;
        this.T = false;
        this.R = 0;
        this.U = false;
        this.V = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.al = false;
        this.ai = 0;
        this.aj = 0;
        android.media.MediaCodec mediaCodec = this.P;
        if (mediaCodec != null) {
            this.q.b++;
            try {
                mediaCodec.stop();
                try {
                    this.P.release();
                    this.P = null;
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar = this.N;
                    if (fVar == null || this.O == fVar) {
                        return;
                    }
                    try {
                        this.F.a(fVar);
                    } finally {
                    }
                } catch (java.lang.Throwable th) {
                    this.P = null;
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar2 = this.N;
                    if (fVar2 != null && this.O != fVar2) {
                        try {
                            this.F.a(fVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                try {
                    this.P.release();
                    this.P = null;
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar3 = this.N;
                    if (fVar3 != null && this.O != fVar3) {
                        try {
                            this.F.a(fVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (java.lang.Throwable th3) {
                    this.P = null;
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar4 = this.N;
                    if (fVar4 != null && this.O != fVar4) {
                        try {
                            this.F.a(fVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public void B() {
        this.ac = -9223372036854775807L;
        G();
        H();
        this.ap = true;
        this.ao = false;
        this.ag = false;
        this.K.clear();
        this.Y = false;
        this.Z = false;
        if (this.T || (this.V && this.al)) {
            A();
            x();
        } else if (this.aj != 0) {
            A();
            x();
        } else {
            this.P.flush();
            this.ak = false;
        }
        if (!this.ah || this.M == null) {
            return;
        }
        this.ai = 1;
    }

    public int a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        return 0;
    }

    public abstract int a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.m mVar);

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        try {
            return a(this.E, this.F, mVar);
        } catch (com.anythink.expressad.exoplayer.f.d.b e2) {
            throw com.anythink.expressad.exoplayer.g.a(e2, s());
        }
    }

    public com.anythink.expressad.exoplayer.f.a a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.m mVar, boolean z2) {
        return cVar.a(mVar.h, z2);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j, long j2) {
        if (this.an) {
            w();
            return;
        }
        if (this.M == null) {
            this.I.a();
            int a2 = a(this.J, this.I, true);
            if (a2 != -5) {
                if (a2 == -4) {
                    com.anythink.expressad.exoplayer.k.a.b(this.I.c());
                    this.am = true;
                    L();
                    return;
                }
                return;
            }
            b(this.J.a);
        }
        x();
        if (this.P != null) {
            com.anythink.expressad.exoplayer.k.ad.a("drainAndFeed");
            while (b(j, j2)) {
            }
            while (C()) {
            }
            com.anythink.expressad.exoplayer.k.ad.a();
            return;
        }
        this.q.d += b(j);
        this.I.a();
        int a3 = a(this.J, this.I, false);
        if (a3 == -5) {
            b(this.J.a);
        } else if (a3 == -4) {
            com.anythink.expressad.exoplayer.k.a.b(this.I.c());
            this.am = true;
            L();
        }
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void a(long j, boolean z2) {
        this.am = false;
        this.an = false;
        if (this.P != null) {
            B();
        }
    }

    public void a(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
    }

    public void a(com.anythink.expressad.exoplayer.c.e eVar) {
    }

    public abstract void a(com.anythink.expressad.exoplayer.f.a aVar, android.media.MediaCodec mediaCodec, com.anythink.expressad.exoplayer.m mVar, android.media.MediaCrypto mediaCrypto);

    public void a(java.lang.String str, long j, long j2) {
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void a(boolean z2) {
        this.q = new com.anythink.expressad.exoplayer.c.d();
    }

    public abstract boolean a(long j, long j2, android.media.MediaCodec mediaCodec, java.nio.ByteBuffer byteBuffer, int i, int i2, long j3, boolean z2);

    public boolean a(com.anythink.expressad.exoplayer.f.a aVar) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        if (r6.n == r0.n) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.anythink.expressad.exoplayer.m mVar) {
        int a2;
        com.anythink.expressad.exoplayer.m mVar2 = this.M;
        this.M = mVar;
        if (!com.anythink.expressad.exoplayer.k.af.a(mVar.k, mVar2 == null ? null : mVar2.k)) {
            if (this.M.k != null) {
                com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar = this.F;
                if (gVar == null) {
                    throw com.anythink.expressad.exoplayer.g.a(new java.lang.IllegalStateException("Media requires a DrmSessionManager"), s());
                }
                com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> a3 = gVar.a(android.os.Looper.myLooper(), this.M.k);
                this.O = a3;
                if (a3 == this.N) {
                    this.F.a(a3);
                }
            } else {
                this.O = null;
            }
        }
        boolean z2 = false;
        if (this.O == this.N && this.P != null && (a2 = a(this.Q, mVar2, this.M)) != 0) {
            if (a2 != 1) {
                if (a2 != 3) {
                    throw new java.lang.IllegalStateException();
                }
                this.ah = true;
                this.ai = 1;
                int i = this.R;
                if (i != 2) {
                    if (i == 1) {
                        com.anythink.expressad.exoplayer.m mVar3 = this.M;
                        if (mVar3.m == mVar2.m) {
                        }
                    }
                    this.Y = z2;
                }
                z2 = true;
                this.Y = z2;
            }
            z2 = true;
        }
        if (z2) {
            return;
        }
        if (this.ak) {
            this.aj = 1;
        } else {
            A();
            x();
        }
    }

    public void c(long j) {
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.z
    public final int m() {
        return 8;
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void n() {
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void o() {
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void p() {
        this.M = null;
        try {
            A();
            try {
                com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar = this.N;
                if (fVar != null) {
                    this.F.a(fVar);
                }
                try {
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar2 = this.O;
                    if (fVar2 != null && fVar2 != this.N) {
                        this.F.a(fVar2);
                    }
                } finally {
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar3 = this.O;
                    if (fVar3 != null && fVar3 != this.N) {
                        this.F.a(fVar3);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (java.lang.Throwable th2) {
            try {
                if (this.N != null) {
                    this.F.a(this.N);
                }
                try {
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar4 = this.O;
                    if (fVar4 != null && fVar4 != this.N) {
                        this.F.a(fVar4);
                    }
                    throw th2;
                } finally {
                }
            } catch (java.lang.Throwable th3) {
                try {
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar5 = this.O;
                    if (fVar5 != null && fVar5 != this.N) {
                        this.F.a(fVar5);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.y
    public boolean u() {
        if (this.M == null || this.ao) {
            return false;
        }
        if (t() || F()) {
            return true;
        }
        return this.ac != -9223372036854775807L && android.os.SystemClock.elapsedRealtime() < this.ac;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public boolean v() {
        return this.an;
    }

    public void w() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:34|(2:38|(21:46|47|(1:124)(1:53)|54|(1:123)(1:68)|69|(1:122)(1:75)|76|(1:115)(1:80)|81|(1:107)(1:85)|86|(1:92)|93|94|95|(1:97)|99|(1:101)(1:104)|102|103))|125|(2:131|(27:139|47|(1:49)|124|54|(1:57)|123|69|(2:71|73)|116|122|76|(1:78)|115|81|(1:83)|107|86|(3:88|90|92)|93|94|95|(0)|99|(0)(0)|102|103))|140|47|(0)|124|54|(0)|123|69|(0)|116|122|76|(0)|115|81|(0)|107|86|(0)|93|94|95|(0)|99|(0)(0)|102|103) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x026e, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x026f, code lost:
    
        a(new com.anythink.expressad.exoplayer.f.b.C0192b(r15.M, r2, r1, r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0164 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025d A[Catch: Exception -> 0x026e, TRY_LEAVE, TryCatch #0 {Exception -> 0x026e, blocks: (B:95:0x0218, B:97:0x025d), top: B:94:0x0218 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x() {
        com.anythink.expressad.exoplayer.m mVar;
        android.media.MediaCrypto mediaCrypto;
        boolean z2;
        int i;
        boolean z3;
        if (this.P != null || (mVar = this.M) == null) {
            return;
        }
        com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> fVar = this.O;
        this.N = fVar;
        java.lang.String str = mVar.h;
        boolean z4 = false;
        if (fVar != null) {
            com.anythink.expressad.exoplayer.d.k g = fVar.g();
            if (g != null) {
                mediaCrypto = g.a();
                z2 = g.a(str);
            } else {
                if (this.N.f() == null) {
                    return;
                }
                mediaCrypto = null;
                z2 = false;
            }
            if ("Amazon".equals(com.anythink.expressad.exoplayer.k.af.c)) {
                java.lang.String str2 = com.anythink.expressad.exoplayer.k.af.d;
                if ("AFTM".equals(str2) || "AFTB".equals(str2)) {
                    z3 = true;
                    if (z3) {
                        int e2 = this.N.e();
                        if (e2 == 1) {
                            throw com.anythink.expressad.exoplayer.g.a(this.N.f(), s());
                        }
                        if (e2 != 4) {
                            return;
                        }
                    }
                }
            }
            z3 = false;
            if (z3) {
            }
        } else {
            mediaCrypto = null;
            z2 = false;
        }
        if (this.Q == null) {
            try {
                com.anythink.expressad.exoplayer.f.a a2 = a(this.E, this.M, z2);
                this.Q = a2;
                if (a2 == null && z2) {
                    com.anythink.expressad.exoplayer.f.a a3 = a(this.E, this.M, false);
                    this.Q = a3;
                    if (a3 != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("Drm session requires secure decoder for ");
                        sb.append(str);
                        sb.append(", but no secure decoder available. Trying to proceed with ");
                        sb.append(this.Q.c);
                        sb.append(".");
                    }
                }
            } catch (com.anythink.expressad.exoplayer.f.d.b e3) {
                a(new com.anythink.expressad.exoplayer.f.b.C0192b(this.M, e3, z2, -49998));
            }
            if (this.Q == null) {
                a(new com.anythink.expressad.exoplayer.f.b.C0192b(this.M, (java.lang.Throwable) null, z2, -49999));
            }
        }
        if (a(this.Q)) {
            java.lang.String str3 = this.Q.c;
            int i2 = com.anythink.expressad.exoplayer.k.af.a;
            if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str3)) {
                java.lang.String str4 = com.anythink.expressad.exoplayer.k.af.d;
                if (str4.startsWith("SM-T585") || str4.startsWith("SM-A510") || str4.startsWith("SM-A520") || str4.startsWith("SM-J700")) {
                    i = 2;
                    this.R = i;
                    this.S = i2 >= 21 && this.M.j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str3);
                    this.T = i2 >= 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str3) || "OMX.SEC.avc.dec.secure".equals(str3))) || (i2 == 19 && com.anythink.expressad.exoplayer.k.af.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str3) || "OMX.Exynos.avc.dec.secure".equals(str3)));
                    com.anythink.expressad.exoplayer.f.a aVar = this.Q;
                    java.lang.String str5 = aVar.c;
                    this.U = (i2 > 17 && ("OMX.rk.video_decoder.avc".equals(str5) || "OMX.allwinner.video.decoder.avc".equals(str5))) || ("Amazon".equals(com.anythink.expressad.exoplayer.k.af.c) && "AFTS".equals(com.anythink.expressad.exoplayer.k.af.d) && aVar.h);
                    this.V = (i2 > 23 && "OMX.google.vorbis.decoder".equals(str3)) || (i2 <= 19 && "hb2000".equals(com.anythink.expressad.exoplayer.k.af.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str3) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str3)));
                    this.W = i2 != 21 && "OMX.google.aac.decoder".equals(str3);
                    com.anythink.expressad.exoplayer.m mVar2 = this.M;
                    if (i2 <= 18 && mVar2.u == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str3)) {
                        z4 = true;
                    }
                    this.X = z4;
                    long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                    com.anythink.expressad.exoplayer.k.ad.a("createCodec:".concat(java.lang.String.valueOf(str3)));
                    this.P = android.media.MediaCodec.createByCodecName(str3);
                    com.anythink.expressad.exoplayer.k.ad.a();
                    com.anythink.expressad.exoplayer.k.ad.a("configureCodec");
                    a(this.Q, this.P, this.M, mediaCrypto);
                    com.anythink.expressad.exoplayer.k.ad.a();
                    com.anythink.expressad.exoplayer.k.ad.a("startCodec");
                    this.P.start();
                    com.anythink.expressad.exoplayer.k.ad.a();
                    long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                    a(str3, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    if (i2 < 21) {
                        this.aa = this.P.getInputBuffers();
                        this.ab = this.P.getOutputBuffers();
                    }
                    this.ac = a_() == 2 ? android.os.SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    G();
                    H();
                    this.ap = true;
                    this.q.a++;
                }
            }
            if (i2 < 24 && ("OMX.Nvidia.h264.decode".equals(str3) || "OMX.Nvidia.h264.decode.secure".equals(str3))) {
                java.lang.String str6 = com.anythink.expressad.exoplayer.k.af.b;
                if ("flounder".equals(str6) || "flounder_lte".equals(str6) || "grouper".equals(str6) || "tilapia".equals(str6)) {
                    i = 1;
                    this.R = i;
                    this.S = i2 >= 21 && this.M.j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str3);
                    this.T = i2 >= 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str3) || "OMX.SEC.avc.dec.secure".equals(str3))) || (i2 == 19 && com.anythink.expressad.exoplayer.k.af.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str3) || "OMX.Exynos.avc.dec.secure".equals(str3)));
                    com.anythink.expressad.exoplayer.f.a aVar2 = this.Q;
                    java.lang.String str52 = aVar2.c;
                    this.U = (i2 > 17 && ("OMX.rk.video_decoder.avc".equals(str52) || "OMX.allwinner.video.decoder.avc".equals(str52))) || ("Amazon".equals(com.anythink.expressad.exoplayer.k.af.c) && "AFTS".equals(com.anythink.expressad.exoplayer.k.af.d) && aVar2.h);
                    this.V = (i2 > 23 && "OMX.google.vorbis.decoder".equals(str3)) || (i2 <= 19 && "hb2000".equals(com.anythink.expressad.exoplayer.k.af.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str3) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str3)));
                    this.W = i2 != 21 && "OMX.google.aac.decoder".equals(str3);
                    com.anythink.expressad.exoplayer.m mVar22 = this.M;
                    if (i2 <= 18) {
                        z4 = true;
                    }
                    this.X = z4;
                    long elapsedRealtime3 = android.os.SystemClock.elapsedRealtime();
                    com.anythink.expressad.exoplayer.k.ad.a("createCodec:".concat(java.lang.String.valueOf(str3)));
                    this.P = android.media.MediaCodec.createByCodecName(str3);
                    com.anythink.expressad.exoplayer.k.ad.a();
                    com.anythink.expressad.exoplayer.k.ad.a("configureCodec");
                    a(this.Q, this.P, this.M, mediaCrypto);
                    com.anythink.expressad.exoplayer.k.ad.a();
                    com.anythink.expressad.exoplayer.k.ad.a("startCodec");
                    this.P.start();
                    com.anythink.expressad.exoplayer.k.ad.a();
                    long elapsedRealtime22 = android.os.SystemClock.elapsedRealtime();
                    a(str3, elapsedRealtime22, elapsedRealtime22 - elapsedRealtime3);
                    if (i2 < 21) {
                    }
                    this.ac = a_() == 2 ? android.os.SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    G();
                    H();
                    this.ap = true;
                    this.q.a++;
                }
            }
            i = 0;
            this.R = i;
            this.S = i2 >= 21 && this.M.j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str3);
            this.T = i2 >= 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str3) || "OMX.SEC.avc.dec.secure".equals(str3))) || (i2 == 19 && com.anythink.expressad.exoplayer.k.af.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str3) || "OMX.Exynos.avc.dec.secure".equals(str3)));
            com.anythink.expressad.exoplayer.f.a aVar22 = this.Q;
            java.lang.String str522 = aVar22.c;
            this.U = (i2 > 17 && ("OMX.rk.video_decoder.avc".equals(str522) || "OMX.allwinner.video.decoder.avc".equals(str522))) || ("Amazon".equals(com.anythink.expressad.exoplayer.k.af.c) && "AFTS".equals(com.anythink.expressad.exoplayer.k.af.d) && aVar22.h);
            this.V = (i2 > 23 && "OMX.google.vorbis.decoder".equals(str3)) || (i2 <= 19 && "hb2000".equals(com.anythink.expressad.exoplayer.k.af.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str3) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str3)));
            this.W = i2 != 21 && "OMX.google.aac.decoder".equals(str3);
            com.anythink.expressad.exoplayer.m mVar222 = this.M;
            if (i2 <= 18) {
            }
            this.X = z4;
            long elapsedRealtime32 = android.os.SystemClock.elapsedRealtime();
            com.anythink.expressad.exoplayer.k.ad.a("createCodec:".concat(java.lang.String.valueOf(str3)));
            this.P = android.media.MediaCodec.createByCodecName(str3);
            com.anythink.expressad.exoplayer.k.ad.a();
            com.anythink.expressad.exoplayer.k.ad.a("configureCodec");
            a(this.Q, this.P, this.M, mediaCrypto);
            com.anythink.expressad.exoplayer.k.ad.a();
            com.anythink.expressad.exoplayer.k.ad.a("startCodec");
            this.P.start();
            com.anythink.expressad.exoplayer.k.ad.a();
            long elapsedRealtime222 = android.os.SystemClock.elapsedRealtime();
            a(str3, elapsedRealtime222, elapsedRealtime222 - elapsedRealtime32);
            if (i2 < 21) {
            }
            this.ac = a_() == 2 ? android.os.SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            G();
            H();
            this.ap = true;
            this.q.a++;
        }
    }

    public final android.media.MediaCodec y() {
        return this.P;
    }

    public final com.anythink.expressad.exoplayer.f.a z() {
        return this.Q;
    }
}
