package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public final class l implements com.anythink.expressad.exoplayer.b.h {
    public static boolean b = false;
    public static boolean c = false;
    private static final long d = 250000;
    private static final long e = 750000;
    private static final long f = 250000;
    private static final int g = 4;
    private static final int h = -2;
    private static final int i = 0;
    private static final int j = 1;
    private static final int k = 1;

    @android.annotation.SuppressLint({"InlinedApi"})
    private static final int l = 1;
    private static final java.lang.String m = "AudioTrack";
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.b.h.c A;

    @androidx.annotation.Nullable
    private android.media.AudioTrack B;
    private android.media.AudioTrack C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private com.anythink.expressad.exoplayer.b.b J;
    private boolean K;
    private boolean L;
    private int M;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.v N;
    private com.anythink.expressad.exoplayer.v O;
    private long P;
    private long Q;

    @androidx.annotation.Nullable
    private java.nio.ByteBuffer R;
    private int S;
    private int T;
    private long U;
    private long V;
    private int W;
    private long X;
    private long Y;
    private int Z;
    private int aa;
    private long ab;
    private float ac;
    private com.anythink.expressad.exoplayer.b.f[] ad;
    private java.nio.ByteBuffer[] ae;

    @androidx.annotation.Nullable
    private java.nio.ByteBuffer af;

    @androidx.annotation.Nullable
    private java.nio.ByteBuffer ag;
    private byte[] ah;
    private int ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private int am;
    private boolean an;
    private long ao;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.b.c q;
    private final com.anythink.expressad.exoplayer.b.l.a r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f205s;
    private final com.anythink.expressad.exoplayer.b.k t;
    private final com.anythink.expressad.exoplayer.b.u u;
    private final com.anythink.expressad.exoplayer.b.f[] v;
    private final com.anythink.expressad.exoplayer.b.f[] w;
    private final android.os.ConditionVariable x;
    private final com.anythink.expressad.exoplayer.b.j y;
    private final java.util.ArrayDeque<com.anythink.expressad.exoplayer.b.l.d> z;

    /* renamed from: com.anythink.expressad.exoplayer.b.l$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ android.media.AudioTrack a;

        public AnonymousClass1(android.media.AudioTrack audioTrack) {
            this.a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                this.a.flush();
                this.a.release();
            } finally {
                com.anythink.expressad.exoplayer.b.l.this.x.open();
            }
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.b.l$2, reason: invalid class name */
    public class AnonymousClass2 extends java.lang.Thread {
        final /* synthetic */ android.media.AudioTrack a;

        public AnonymousClass2(android.media.AudioTrack audioTrack) {
            this.a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            this.a.release();
        }
    }

    public interface a {
        long a(long j);

        com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar);

        com.anythink.expressad.exoplayer.b.f[] a();

        long b();
    }

    public static class b implements com.anythink.expressad.exoplayer.b.l.a {
        private final com.anythink.expressad.exoplayer.b.f[] a;
        private final com.anythink.expressad.exoplayer.b.q b;
        private final com.anythink.expressad.exoplayer.b.t c;

        public b(com.anythink.expressad.exoplayer.b.f... fVarArr) {
            com.anythink.expressad.exoplayer.b.f[] fVarArr2 = (com.anythink.expressad.exoplayer.b.f[]) java.util.Arrays.copyOf(fVarArr, fVarArr.length + 2);
            this.a = fVarArr2;
            com.anythink.expressad.exoplayer.b.q qVar = new com.anythink.expressad.exoplayer.b.q();
            this.b = qVar;
            com.anythink.expressad.exoplayer.b.t tVar = new com.anythink.expressad.exoplayer.b.t();
            this.c = tVar;
            fVarArr2[fVarArr.length] = qVar;
            fVarArr2[fVarArr.length + 1] = tVar;
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final long a(long j) {
            return this.c.a(j);
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar) {
            this.b.a(vVar.d);
            return new com.anythink.expressad.exoplayer.v(this.c.a(vVar.b), this.c.b(vVar.c), vVar.d);
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final com.anythink.expressad.exoplayer.b.f[] a() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final long b() {
            return this.b.j();
        }
    }

    public static final class c extends java.lang.RuntimeException {
        private c(java.lang.String str) {
            super(str);
        }

        public /* synthetic */ c(java.lang.String str, byte b) {
            this(str);
        }
    }

    public static final class d {
        private final com.anythink.expressad.exoplayer.v a;
        private final long b;
        private final long c;

        private d(com.anythink.expressad.exoplayer.v vVar, long j, long j2) {
            this.a = vVar;
            this.b = j;
            this.c = j2;
        }

        public /* synthetic */ d(com.anythink.expressad.exoplayer.v vVar, long j, long j2, byte b) {
            this(vVar, j, j2);
        }
    }

    public final class e implements com.anythink.expressad.exoplayer.b.j.a {
        private e() {
        }

        public /* synthetic */ e(com.anythink.expressad.exoplayer.b.l lVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(int i, long j) {
            if (com.anythink.expressad.exoplayer.b.l.this.A != null) {
                com.anythink.expressad.exoplayer.b.l.this.A.a(i, j, android.os.SystemClock.elapsedRealtime() - com.anythink.expressad.exoplayer.b.l.this.ao);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(long j) {
            "Ignoring impossibly large audio latency: ".concat(java.lang.String.valueOf(j));
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(long j, long j2, long j3, long j4) {
            java.lang.String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + com.anythink.expressad.exoplayer.b.l.this.r() + ", " + com.anythink.expressad.exoplayer.b.l.this.s();
            if (com.anythink.expressad.exoplayer.b.l.c) {
                throw new com.anythink.expressad.exoplayer.b.l.c(str, (byte) 0);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void b(long j, long j2, long j3, long j4) {
            java.lang.String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + com.anythink.expressad.exoplayer.b.l.this.r() + ", " + com.anythink.expressad.exoplayer.b.l.this.s();
            if (com.anythink.expressad.exoplayer.b.l.c) {
                throw new com.anythink.expressad.exoplayer.b.l.c(str, (byte) 0);
            }
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface f {
    }

    private l(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.c cVar, com.anythink.expressad.exoplayer.b.l.a aVar) {
        this.q = cVar;
        this.r = (com.anythink.expressad.exoplayer.b.l.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        this.f205s = false;
        this.x = new android.os.ConditionVariable(true);
        this.y = new com.anythink.expressad.exoplayer.b.j(new com.anythink.expressad.exoplayer.b.l.e(this, (byte) 0));
        com.anythink.expressad.exoplayer.b.k kVar = new com.anythink.expressad.exoplayer.b.k();
        this.t = kVar;
        com.anythink.expressad.exoplayer.b.u uVar = new com.anythink.expressad.exoplayer.b.u();
        this.u = uVar;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Collections.addAll(arrayList, new com.anythink.expressad.exoplayer.b.p(), kVar, uVar);
        java.util.Collections.addAll(arrayList, aVar.a());
        this.v = (com.anythink.expressad.exoplayer.b.f[]) arrayList.toArray(new com.anythink.expressad.exoplayer.b.f[arrayList.size()]);
        this.w = new com.anythink.expressad.exoplayer.b.f[]{new com.anythink.expressad.exoplayer.b.n()};
        this.ac = 1.0f;
        this.aa = 0;
        this.J = com.anythink.expressad.exoplayer.b.b.a;
        this.am = 0;
        this.O = com.anythink.expressad.exoplayer.v.a;
        this.aj = -1;
        this.ad = new com.anythink.expressad.exoplayer.b.f[0];
        this.ae = new java.nio.ByteBuffer[0];
        this.z = new java.util.ArrayDeque<>();
    }

    public l(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.c cVar, com.anythink.expressad.exoplayer.b.f[] fVarArr) {
        this(cVar, fVarArr, (byte) 0);
    }

    private l(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.c cVar, com.anythink.expressad.exoplayer.b.f[] fVarArr, byte b2) {
        this(cVar, new com.anythink.expressad.exoplayer.b.l.b(fVarArr));
    }

    private static int a(int i2, java.nio.ByteBuffer byteBuffer) {
        if (i2 == 7 || i2 == 8) {
            return com.anythink.expressad.exoplayer.b.m.a(byteBuffer);
        }
        if (i2 == 5) {
            return com.anythink.expressad.exoplayer.b.a.a();
        }
        if (i2 == 6) {
            return com.anythink.expressad.exoplayer.b.a.a(byteBuffer);
        }
        if (i2 != 14) {
            throw new java.lang.IllegalStateException("Unexpected audio encoding: ".concat(java.lang.String.valueOf(i2)));
        }
        int b2 = com.anythink.expressad.exoplayer.b.a.b(byteBuffer);
        if (b2 == -1) {
            return 0;
        }
        return com.anythink.expressad.exoplayer.b.a.a(byteBuffer, b2) * 16;
    }

    @android.annotation.TargetApi(21)
    private static int a(android.media.AudioTrack audioTrack, java.nio.ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @android.annotation.TargetApi(21)
    private int a(android.media.AudioTrack audioTrack, java.nio.ByteBuffer byteBuffer, int i2, long j2) {
        if (this.R == null) {
            java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(16);
            this.R = allocate;
            allocate.order(java.nio.ByteOrder.BIG_ENDIAN);
            this.R.putInt(1431633921);
        }
        if (this.S == 0) {
            this.R.putInt(4, i2);
            this.R.putLong(8, j2 * 1000);
            this.R.position(0);
            this.S = i2;
        }
        int remaining = this.R.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.R, remaining, 1);
            if (write < 0) {
                this.S = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        int write2 = audioTrack.write(byteBuffer, i2, 1);
        if (write2 < 0) {
            this.S = 0;
            return write2;
        }
        this.S -= write2;
        return write2;
    }

    private void a(long j2) {
        java.nio.ByteBuffer byteBuffer;
        int length = this.ad.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.ae[i2 - 1];
            } else {
                byteBuffer = this.af;
                if (byteBuffer == null) {
                    byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j2);
            } else {
                com.anythink.expressad.exoplayer.b.f fVar = this.ad[i2];
                fVar.a(byteBuffer);
                java.nio.ByteBuffer f2 = fVar.f();
                this.ae[i2] = f2;
                if (f2.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i2--;
            }
        }
    }

    @android.annotation.TargetApi(21)
    private static void a(android.media.AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private long b(long j2) {
        long j3;
        long a2;
        com.anythink.expressad.exoplayer.b.l.d dVar = null;
        while (!this.z.isEmpty() && j2 >= this.z.getFirst().c) {
            dVar = this.z.remove();
        }
        if (dVar != null) {
            this.O = dVar.a;
            this.Q = dVar.c;
            this.P = dVar.b - this.ab;
        }
        if (this.O.b == 1.0f) {
            return (j2 + this.P) - this.Q;
        }
        if (this.z.isEmpty()) {
            j3 = this.P;
            a2 = this.r.a(j2 - this.Q);
        } else {
            j3 = this.P;
            a2 = com.anythink.expressad.exoplayer.k.af.a(j2 - this.Q, this.O.b);
        }
        return j3 + a2;
    }

    private static void b(android.media.AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void b(java.nio.ByteBuffer byteBuffer, long j2) {
        if (byteBuffer.hasRemaining()) {
            java.nio.ByteBuffer byteBuffer2 = this.ag;
            int i2 = 0;
            if (byteBuffer2 != null) {
                com.anythink.expressad.exoplayer.k.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.ag = byteBuffer;
                if (com.anythink.expressad.exoplayer.k.af.a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.ah;
                    if (bArr == null || bArr.length < remaining) {
                        this.ah = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.ah, 0, remaining);
                    byteBuffer.position(position);
                    this.ai = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (com.anythink.expressad.exoplayer.k.af.a < 21) {
                int b2 = this.y.b(this.X);
                if (b2 > 0) {
                    i2 = this.C.write(this.ah, this.ai, java.lang.Math.min(remaining2, b2));
                    if (i2 > 0) {
                        this.ai += i2;
                        byteBuffer.position(byteBuffer.position() + i2);
                    }
                }
            } else if (this.an) {
                com.anythink.expressad.exoplayer.k.a.b(j2 != -9223372036854775807L);
                i2 = a(this.C, byteBuffer, remaining2, j2);
            } else {
                i2 = this.C.write(byteBuffer, remaining2, 1);
            }
            this.ao = android.os.SystemClock.elapsedRealtime();
            if (i2 < 0) {
                throw new com.anythink.expressad.exoplayer.b.h.d(i2);
            }
            boolean z = this.D;
            if (z) {
                this.X += i2;
            }
            if (i2 == remaining2) {
                if (!z) {
                    this.Y += this.Z;
                }
                this.ag = null;
            }
        }
    }

    private long c(long j2) {
        return j2 + e(this.r.b());
    }

    private long d(long j2) {
        return (j2 * 1000000) / this.F;
    }

    private static android.media.AudioTrack d(int i2) {
        return new android.media.AudioTrack(3, 4000, 4, 2, 2, 0, i2);
    }

    private long e(long j2) {
        return (j2 * 1000000) / this.G;
    }

    private long f(long j2) {
        return (j2 * this.G) / 1000000;
    }

    private void k() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.anythink.expressad.exoplayer.b.f fVar : v()) {
            if (fVar.a()) {
                arrayList.add(fVar);
            } else {
                fVar.h();
            }
        }
        int size = arrayList.size();
        this.ad = (com.anythink.expressad.exoplayer.b.f[]) arrayList.toArray(new com.anythink.expressad.exoplayer.b.f[size]);
        this.ae = new java.nio.ByteBuffer[size];
        l();
    }

    private void l() {
        int i2 = 0;
        while (true) {
            com.anythink.expressad.exoplayer.b.f[] fVarArr = this.ad;
            if (i2 >= fVarArr.length) {
                return;
            }
            com.anythink.expressad.exoplayer.b.f fVar = fVarArr[i2];
            fVar.h();
            this.ae[i2] = fVar.f();
            i2++;
        }
    }

    private void m() {
        this.x.block();
        android.media.AudioTrack t = t();
        this.C = t;
        int audioSessionId = t.getAudioSessionId();
        if (b && com.anythink.expressad.exoplayer.k.af.a < 21) {
            android.media.AudioTrack audioTrack = this.B;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                p();
            }
            if (this.B == null) {
                this.B = new android.media.AudioTrack(3, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        if (this.am != audioSessionId) {
            this.am = audioSessionId;
            com.anythink.expressad.exoplayer.b.h.c cVar = this.A;
            if (cVar != null) {
                cVar.a(audioSessionId);
            }
        }
        this.O = this.L ? this.r.a(this.O) : com.anythink.expressad.exoplayer.v.a;
        k();
        this.y.a(this.C, this.I, this.W, this.M);
        o();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0032 -> B:7:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean n() {
        boolean z;
        int i2;
        com.anythink.expressad.exoplayer.b.f[] fVarArr;
        if (this.aj == -1) {
            this.aj = this.K ? 0 : this.ad.length;
            z = true;
            i2 = this.aj;
            fVarArr = this.ad;
            if (i2 < fVarArr.length) {
                com.anythink.expressad.exoplayer.b.f fVar = fVarArr[i2];
                if (z) {
                    fVar.e();
                }
                a(-9223372036854775807L);
                if (!fVar.g()) {
                    return false;
                }
                this.aj++;
                z = true;
                i2 = this.aj;
                fVarArr = this.ad;
                if (i2 < fVarArr.length) {
                    java.nio.ByteBuffer byteBuffer = this.ag;
                    if (byteBuffer != null) {
                        b(byteBuffer, -9223372036854775807L);
                        if (this.ag != null) {
                            return false;
                        }
                    }
                    this.aj = -1;
                    return true;
                }
            }
        } else {
            z = false;
            i2 = this.aj;
            fVarArr = this.ad;
            if (i2 < fVarArr.length) {
            }
        }
    }

    private void o() {
        if (q()) {
            if (com.anythink.expressad.exoplayer.k.af.a >= 21) {
                this.C.setVolume(this.ac);
                return;
            }
            android.media.AudioTrack audioTrack = this.C;
            float f2 = this.ac;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    private void p() {
        android.media.AudioTrack audioTrack = this.B;
        if (audioTrack == null) {
            return;
        }
        this.B = null;
        new com.anythink.expressad.exoplayer.b.l.AnonymousClass2(audioTrack).start();
    }

    private boolean q() {
        return this.C != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        return this.D ? this.U / this.T : this.V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long s() {
        return this.D ? this.X / this.W : this.Y;
    }

    private android.media.AudioTrack t() {
        android.media.AudioTrack audioTrack;
        if (com.anythink.expressad.exoplayer.k.af.a >= 21) {
            android.media.AudioAttributes build = this.an ? new android.media.AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.J.a();
            android.media.AudioFormat build2 = new android.media.AudioFormat.Builder().setChannelMask(this.H).setEncoding(this.I).setSampleRate(this.G).build();
            int i2 = this.am;
            audioTrack = new android.media.AudioTrack(build, build2, this.M, 1, i2 != 0 ? i2 : 0);
        } else {
            int f2 = com.anythink.expressad.exoplayer.k.af.f(this.J.d);
            audioTrack = this.am == 0 ? new android.media.AudioTrack(f2, this.G, this.H, this.I, this.M, 1) : new android.media.AudioTrack(f2, this.G, this.H, this.I, this.M, 1, this.am);
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (java.lang.Exception unused) {
        }
        throw new com.anythink.expressad.exoplayer.b.h.b(state, this.G, this.H, this.M);
    }

    @android.annotation.TargetApi(21)
    private android.media.AudioTrack u() {
        android.media.AudioAttributes build = this.an ? new android.media.AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.J.a();
        android.media.AudioFormat build2 = new android.media.AudioFormat.Builder().setChannelMask(this.H).setEncoding(this.I).setSampleRate(this.G).build();
        int i2 = this.am;
        return new android.media.AudioTrack(build, build2, this.M, 1, i2 != 0 ? i2 : 0);
    }

    private com.anythink.expressad.exoplayer.b.f[] v() {
        return this.E ? this.w : this.v;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final long a(boolean z) {
        long j2;
        long a2;
        long j3;
        if (!q() || this.aa == 0) {
            return Long.MIN_VALUE;
        }
        long min = java.lang.Math.min(this.y.a(z), e(s()));
        long j4 = this.ab;
        com.anythink.expressad.exoplayer.b.l.d dVar = null;
        while (!this.z.isEmpty() && min >= this.z.getFirst().c) {
            dVar = this.z.remove();
        }
        if (dVar != null) {
            this.O = dVar.a;
            this.Q = dVar.c;
            this.P = dVar.b - this.ab;
        }
        if (this.O.b == 1.0f) {
            j3 = (min + this.P) - this.Q;
        } else {
            if (this.z.isEmpty()) {
                j2 = this.P;
                a2 = this.r.a(min - this.Q);
            } else {
                j2 = this.P;
                a2 = com.anythink.expressad.exoplayer.k.af.a(min - this.Q, this.O.b);
            }
            j3 = a2 + j2;
        }
        return j4 + j3 + e(this.r.b());
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar) {
        if (q() && !this.L) {
            com.anythink.expressad.exoplayer.v vVar2 = com.anythink.expressad.exoplayer.v.a;
            this.O = vVar2;
            return vVar2;
        }
        com.anythink.expressad.exoplayer.v vVar3 = this.N;
        if (vVar3 == null) {
            vVar3 = !this.z.isEmpty() ? this.z.getLast().a : this.O;
        }
        if (!vVar.equals(vVar3)) {
            if (q()) {
                this.N = vVar;
            } else {
                this.O = this.r.a(vVar);
            }
        }
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a() {
        this.al = true;
        if (q()) {
            this.y.a();
            this.C.play();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(float f2) {
        if (this.ac != f2) {
            this.ac = f2;
            o();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    @Override // com.anythink.expressad.exoplayer.b.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i2, int i3, int i4, @androidx.annotation.Nullable int[] iArr, int i5, int i6) {
        int i7;
        boolean z;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        this.F = i4;
        this.D = com.anythink.expressad.exoplayer.k.af.b(i2);
        this.E = this.f205s && a(1073741824) && com.anythink.expressad.exoplayer.k.af.c(i2);
        if (this.D) {
            this.T = com.anythink.expressad.exoplayer.k.af.b(i2, i3);
        }
        int i13 = 4;
        if (this.D) {
            i7 = i2;
            if (i7 != 4) {
                z = true;
                this.L = (z || this.E) ? false : true;
                if (z) {
                    i8 = i4;
                    z2 = false;
                    i9 = i3;
                } else {
                    this.u.a(i5, i6);
                    this.t.a(iArr);
                    i8 = i4;
                    z2 = false;
                    i9 = i3;
                    for (com.anythink.expressad.exoplayer.b.f fVar : v()) {
                        try {
                            z2 |= fVar.a(i8, i9, i7);
                            if (fVar.a()) {
                                i9 = fVar.b();
                                i8 = fVar.d();
                                i7 = fVar.c();
                            }
                        } catch (com.anythink.expressad.exoplayer.b.f.a e2) {
                            throw new com.anythink.expressad.exoplayer.b.h.a(e2);
                        }
                    }
                }
                i10 = com.getui.gtc.extension.distribution.gbd.d.g.aH;
                switch (i9) {
                    case 1:
                        break;
                    case 2:
                        i13 = 12;
                        break;
                    case 3:
                        i13 = 28;
                        break;
                    case 4:
                        i13 = 204;
                        break;
                    case 5:
                        i13 = 220;
                        break;
                    case 6:
                        i13 = com.getui.gtc.extension.distribution.gbd.d.g.aH;
                        break;
                    case 7:
                        i13 = 1276;
                        break;
                    case 8:
                        i13 = com.anythink.expressad.exoplayer.b.C;
                        break;
                    default:
                        throw new com.anythink.expressad.exoplayer.b.h.a("Unsupported channel count: ".concat(java.lang.String.valueOf(i9)));
                }
                i11 = com.anythink.expressad.exoplayer.k.af.a;
                if (i11 <= 23 && "foster".equals(com.anythink.expressad.exoplayer.k.af.b) && "NVIDIA".equals(com.anythink.expressad.exoplayer.k.af.c)) {
                    if (i9 != 3 && i9 != 5) {
                        if (i9 == 7) {
                            i10 = com.anythink.expressad.exoplayer.b.C;
                        }
                    }
                    i12 = (i11 <= 25 || !"fugu".equals(com.anythink.expressad.exoplayer.k.af.b) || this.D || i9 != 1) ? i10 : 12;
                    if (z2 && q() && this.I == i7 && this.G == i8 && this.H == i12) {
                        return;
                    }
                    i();
                    this.K = z;
                    this.G = i8;
                    this.H = i12;
                    this.I = i7;
                    this.W = !this.D ? com.anythink.expressad.exoplayer.k.af.b(i7, i9) : -1;
                    if (!this.D) {
                        int minBufferSize = android.media.AudioTrack.getMinBufferSize(i8, i12, this.I);
                        com.anythink.expressad.exoplayer.k.a.b(minBufferSize != -2);
                        this.M = com.anythink.expressad.exoplayer.k.af.a(minBufferSize * 4, ((int) f(250000L)) * this.W, (int) java.lang.Math.max(minBufferSize, f(e) * this.W));
                        return;
                    }
                    int i14 = this.I;
                    if (i14 == 5 || i14 == 6) {
                        this.M = 20480;
                        return;
                    } else if (i14 == 7) {
                        this.M = 49152;
                        return;
                    } else {
                        this.M = 294912;
                        return;
                    }
                }
                i10 = i13;
                if (i11 <= 25) {
                }
                if (z2) {
                }
                i();
                this.K = z;
                this.G = i8;
                this.H = i12;
                this.I = i7;
                this.W = !this.D ? com.anythink.expressad.exoplayer.k.af.b(i7, i9) : -1;
                if (!this.D) {
                }
            }
        } else {
            i7 = i2;
        }
        z = false;
        this.L = (z || this.E) ? false : true;
        if (z) {
        }
        i10 = com.getui.gtc.extension.distribution.gbd.d.g.aH;
        switch (i9) {
        }
        i11 = com.anythink.expressad.exoplayer.k.af.a;
        if (i11 <= 23) {
            if (i9 != 3) {
                if (i9 == 7) {
                }
            }
            if (i11 <= 25) {
            }
            if (z2) {
            }
            i();
            this.K = z;
            this.G = i8;
            this.H = i12;
            this.I = i7;
            this.W = !this.D ? com.anythink.expressad.exoplayer.k.af.b(i7, i9) : -1;
            if (!this.D) {
            }
        }
        i10 = i13;
        if (i11 <= 25) {
        }
        if (z2) {
        }
        i();
        this.K = z;
        this.G = i8;
        this.H = i12;
        this.I = i7;
        this.W = !this.D ? com.anythink.expressad.exoplayer.k.af.b(i7, i9) : -1;
        if (!this.D) {
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(com.anythink.expressad.exoplayer.b.b bVar) {
        if (this.J.equals(bVar)) {
            return;
        }
        this.J = bVar;
        if (this.an) {
            return;
        }
        i();
        this.am = 0;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(com.anythink.expressad.exoplayer.b.h.c cVar) {
        this.A = cVar;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean a(int i2) {
        if (com.anythink.expressad.exoplayer.k.af.b(i2)) {
            return i2 != 4 || com.anythink.expressad.exoplayer.k.af.a >= 21;
        }
        com.anythink.expressad.exoplayer.b.c cVar = this.q;
        return cVar != null && cVar.a(i2);
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean a(java.nio.ByteBuffer byteBuffer, long j2) {
        int a2;
        java.nio.ByteBuffer byteBuffer2 = this.af;
        com.anythink.expressad.exoplayer.k.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!q()) {
            this.x.block();
            android.media.AudioTrack t = t();
            this.C = t;
            int audioSessionId = t.getAudioSessionId();
            if (b && com.anythink.expressad.exoplayer.k.af.a < 21) {
                android.media.AudioTrack audioTrack = this.B;
                if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                    p();
                }
                if (this.B == null) {
                    this.B = new android.media.AudioTrack(3, 4000, 4, 2, 2, 0, audioSessionId);
                }
            }
            if (this.am != audioSessionId) {
                this.am = audioSessionId;
                com.anythink.expressad.exoplayer.b.h.c cVar = this.A;
                if (cVar != null) {
                    cVar.a(audioSessionId);
                }
            }
            this.O = this.L ? this.r.a(this.O) : com.anythink.expressad.exoplayer.v.a;
            k();
            this.y.a(this.C, this.I, this.W, this.M);
            o();
            if (this.al) {
                a();
            }
        }
        if (!this.y.a(s())) {
            return false;
        }
        if (this.af == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.D && this.Z == 0) {
                int i2 = this.I;
                if (i2 == 7 || i2 == 8) {
                    a2 = com.anythink.expressad.exoplayer.b.m.a(byteBuffer);
                } else if (i2 == 5) {
                    a2 = com.anythink.expressad.exoplayer.b.a.a();
                } else if (i2 == 6) {
                    a2 = com.anythink.expressad.exoplayer.b.a.a(byteBuffer);
                } else {
                    if (i2 != 14) {
                        throw new java.lang.IllegalStateException("Unexpected audio encoding: ".concat(java.lang.String.valueOf(i2)));
                    }
                    int b2 = com.anythink.expressad.exoplayer.b.a.b(byteBuffer);
                    a2 = b2 == -1 ? 0 : com.anythink.expressad.exoplayer.b.a.a(byteBuffer, b2) * 16;
                }
                this.Z = a2;
                if (a2 == 0) {
                    return true;
                }
            }
            if (this.N != null) {
                if (!n()) {
                    return false;
                }
                com.anythink.expressad.exoplayer.v vVar = this.N;
                this.N = null;
                this.z.add(new com.anythink.expressad.exoplayer.b.l.d(this.r.a(vVar), java.lang.Math.max(0L, j2), e(s()), (byte) 0));
                k();
            }
            if (this.aa == 0) {
                this.ab = java.lang.Math.max(0L, j2);
                this.aa = 1;
            } else {
                long r = this.ab + ((r() * 1000000) / this.F);
                if (this.aa == 1 && java.lang.Math.abs(r - j2) > 200000) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("Discontinuity detected [expected ");
                    sb.append(r);
                    sb.append(", got ");
                    sb.append(j2);
                    sb.append("]");
                    this.aa = 2;
                }
                if (this.aa == 2) {
                    this.ab += j2 - r;
                    this.aa = 1;
                    com.anythink.expressad.exoplayer.b.h.c cVar2 = this.A;
                    if (cVar2 != null) {
                        cVar2.a();
                    }
                }
            }
            if (this.D) {
                this.U += byteBuffer.remaining();
            } else {
                this.V += this.Z;
            }
            this.af = byteBuffer;
        }
        if (this.K) {
            a(j2);
        } else {
            b(this.af, j2);
        }
        if (!this.af.hasRemaining()) {
            this.af = null;
            return true;
        }
        if (!this.y.c(s())) {
            return false;
        }
        i();
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void b() {
        if (this.aa == 1) {
            this.aa = 2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void b(int i2) {
        if (this.am != i2) {
            this.am = i2;
            i();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void c() {
        if (!this.ak && q() && n()) {
            this.y.d(s());
            this.C.stop();
            this.S = 0;
            this.ak = true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void c(int i2) {
        com.anythink.expressad.exoplayer.k.a.b(com.anythink.expressad.exoplayer.k.af.a >= 21);
        if (this.an && this.am == i2) {
            return;
        }
        this.an = true;
        this.am = i2;
        i();
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean d() {
        if (q()) {
            return this.ak && !e();
        }
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean e() {
        return q() && this.y.e(s());
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final com.anythink.expressad.exoplayer.v f() {
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void g() {
        if (this.an) {
            this.an = false;
            this.am = 0;
            i();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void h() {
        this.al = false;
        if (q() && this.y.c()) {
            this.C.pause();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void i() {
        if (q()) {
            this.U = 0L;
            this.V = 0L;
            this.X = 0L;
            this.Y = 0L;
            this.Z = 0;
            com.anythink.expressad.exoplayer.v vVar = this.N;
            if (vVar != null) {
                this.O = vVar;
                this.N = null;
            } else if (!this.z.isEmpty()) {
                this.O = this.z.getLast().a;
            }
            this.z.clear();
            this.P = 0L;
            this.Q = 0L;
            this.af = null;
            this.ag = null;
            l();
            this.ak = false;
            this.aj = -1;
            this.R = null;
            this.S = 0;
            this.aa = 0;
            if (this.y.b()) {
                this.C.pause();
            }
            android.media.AudioTrack audioTrack = this.C;
            this.C = null;
            this.y.d();
            this.x.close();
            new com.anythink.expressad.exoplayer.b.l.AnonymousClass1(audioTrack).start();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void j() {
        i();
        p();
        for (com.anythink.expressad.exoplayer.b.f fVar : this.v) {
            fVar.i();
        }
        for (com.anythink.expressad.exoplayer.b.f fVar2 : this.w) {
            fVar2.i();
        }
        this.am = 0;
        this.al = false;
    }
}
