package com.anythink.expressad.exoplayer.l;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public class e extends com.anythink.expressad.exoplayer.f.b {
    private static boolean A = false;

    /* renamed from: s, reason: collision with root package name */
    private static final java.lang.String f230s = "MediaCodecVideoRenderer";
    private static final java.lang.String t = "crop-left";
    private static final java.lang.String u = "crop-right";
    private static final java.lang.String v = "crop-bottom";
    private static final java.lang.String w = "crop-top";
    private static final int[] x = {1920, 1600, 1440, 1280, 960, 854, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 540, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH};
    private static final int y = 10;
    private static boolean z;
    private final android.content.Context B;
    private final com.anythink.expressad.exoplayer.l.f C;
    private final com.anythink.expressad.exoplayer.l.h.a D;
    private final long E;
    private final int F;
    private final boolean G;
    private final long[] H;
    private final long[] I;
    private com.anythink.expressad.exoplayer.l.e.a J;
    private boolean K;
    private android.view.Surface L;
    private android.view.Surface M;
    private int N;
    private boolean O;
    private long P;
    private long Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private long V;
    private int W;
    private float X;
    private int Y;
    private int Z;
    private int aa;
    private float ab;
    private int ac;
    private int ad;
    private int ae;
    private float af;
    private boolean ag;
    private int ah;
    private long ai;
    private long aj;
    private int ak;
    com.anythink.expressad.exoplayer.l.e.b r;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    @android.annotation.TargetApi(23)
    public final class b implements android.media.MediaCodec.OnFrameRenderedListener {
        private b(android.media.MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new android.os.Handler());
        }

        public /* synthetic */ b(com.anythink.expressad.exoplayer.l.e eVar, android.media.MediaCodec mediaCodec, byte b) {
            this(mediaCodec);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public final void onFrameRendered(@androidx.annotation.NonNull android.media.MediaCodec mediaCodec, long j, long j2) {
            com.anythink.expressad.exoplayer.l.e eVar = com.anythink.expressad.exoplayer.l.e.this;
            if (this != eVar.r) {
                return;
            }
            eVar.C();
        }
    }

    private e(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar) {
        this(context, cVar, (byte) 0);
    }

    private e(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar, byte b2) {
        this(context, cVar, null, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar, long j, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.l.h hVar, int i) {
        super(2, cVar, gVar, false);
        boolean z2 = false;
        this.E = j;
        this.F = i;
        android.content.Context applicationContext = context.getApplicationContext();
        this.B = applicationContext;
        this.C = new com.anythink.expressad.exoplayer.l.f(applicationContext);
        this.D = new com.anythink.expressad.exoplayer.l.h.a(handler, hVar);
        if (com.anythink.expressad.exoplayer.k.af.a <= 22 && "foster".equals(com.anythink.expressad.exoplayer.k.af.b) && "NVIDIA".equals(com.anythink.expressad.exoplayer.k.af.c)) {
            z2 = true;
        }
        this.G = z2;
        this.H = new long[10];
        this.I = new long[10];
        this.aj = -9223372036854775807L;
        this.ai = -9223372036854775807L;
        this.Q = -9223372036854775807L;
        this.Y = -1;
        this.Z = -1;
        this.ab = -1.0f;
        this.X = -1.0f;
        this.N = 1;
        G();
    }

    private e(android.content.Context context, com.anythink.expressad.exoplayer.f.c cVar, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.l.h hVar) {
        this(context, cVar, 0L, null, handler, hVar, -1);
    }

    private void D() {
        this.Q = this.E > 0 ? android.os.SystemClock.elapsedRealtime() + this.E : -9223372036854775807L;
    }

    private void E() {
        android.media.MediaCodec y2;
        this.O = false;
        if (com.anythink.expressad.exoplayer.k.af.a < 23 || !this.ag || (y2 = y()) == null) {
            return;
        }
        this.r = new com.anythink.expressad.exoplayer.l.e.b(this, y2, (byte) 0);
    }

    private void F() {
        if (this.O) {
            this.D.a(this.L);
        }
    }

    private void G() {
        this.ac = -1;
        this.ad = -1;
        this.af = -1.0f;
        this.ae = -1;
    }

    private void H() {
        int i = this.Y;
        if (i == -1 && this.Z == -1) {
            return;
        }
        if (this.ac == i && this.ad == this.Z && this.ae == this.aa && this.af == this.ab) {
            return;
        }
        this.D.a(i, this.Z, this.aa, this.ab);
        this.ac = this.Y;
        this.ad = this.Z;
        this.ae = this.aa;
        this.af = this.ab;
    }

    private void I() {
        int i = this.ac;
        if (i == -1 && this.ad == -1) {
            return;
        }
        this.D.a(i, this.ad, this.ae, this.af);
    }

    private void J() {
        if (this.S > 0) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.D.a(this.S, elapsedRealtime - this.R);
            this.S = 0;
            this.R = elapsedRealtime;
        }
    }

    private static boolean K() {
        return com.anythink.expressad.exoplayer.k.af.a <= 22 && "foster".equals(com.anythink.expressad.exoplayer.k.af.b) && "NVIDIA".equals(com.anythink.expressad.exoplayer.k.af.c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(com.anythink.expressad.exoplayer.f.a aVar, java.lang.String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.hashCode();
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 4:
                i3 = i * i2;
                i4 = 2;
                break;
            case 1:
            case 5:
                i3 = i * i2;
                break;
            case 3:
                java.lang.String str2 = com.anythink.expressad.exoplayer.k.af.d;
                if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(com.anythink.expressad.exoplayer.k.af.c) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !aVar.h)))) {
                    i3 = com.anythink.expressad.exoplayer.k.af.a(i, 16) * com.anythink.expressad.exoplayer.k.af.a(i2, 16) * 16 * 16;
                    i4 = 2;
                    break;
                }
                break;
        }
        return -1;
    }

    private static android.graphics.Point a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar) {
        int i = mVar.n;
        int i2 = mVar.m;
        boolean z2 = i > i2;
        int i3 = z2 ? i : i2;
        if (z2) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : x) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (com.anythink.expressad.exoplayer.k.af.a >= 21) {
                int i6 = z2 ? i5 : i4;
                if (!z2) {
                    i4 = i5;
                }
                android.graphics.Point a2 = aVar.a(i6, i4);
                if (aVar.a(a2.x, a2.y, mVar.o)) {
                    return a2;
                }
            } else {
                int a3 = com.anythink.expressad.exoplayer.k.af.a(i4, 16) * 16;
                int a4 = com.anythink.expressad.exoplayer.k.af.a(i5, 16) * 16;
                if (a3 * a4 <= com.anythink.expressad.exoplayer.f.d.b()) {
                    int i7 = z2 ? a4 : a3;
                    if (!z2) {
                        a3 = a4;
                    }
                    return new android.graphics.Point(i7, a3);
                }
            }
        }
        return null;
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    private static android.media.MediaFormat a(com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.l.e.a aVar, boolean z2, int i) {
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", mVar.h);
        mediaFormat.setInteger("width", mVar.m);
        mediaFormat.setInteger("height", mVar.n);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.j);
        float f = mVar.o;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "rotation-degrees", mVar.p);
        com.anythink.expressad.exoplayer.l.b bVar = mVar.t;
        if (bVar != null) {
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-transfer", bVar.c);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-standard", bVar.a);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", java.nio.ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger("max-width", aVar.a);
        mediaFormat.setInteger("max-height", aVar.b);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "max-input-size", aVar.c);
        if (com.anythink.expressad.exoplayer.k.af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z2) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
        return mediaFormat;
    }

    private static com.anythink.expressad.exoplayer.l.e.a a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m[] mVarArr) {
        int i = mVar.m;
        int i2 = mVar.n;
        int b2 = b(aVar, mVar);
        if (mVarArr.length == 1) {
            return new com.anythink.expressad.exoplayer.l.e.a(i, i2, b2);
        }
        boolean z2 = false;
        for (com.anythink.expressad.exoplayer.m mVar2 : mVarArr) {
            if (a(aVar.f, mVar, mVar2)) {
                int i3 = mVar2.m;
                z2 |= i3 == -1 || mVar2.n == -1;
                i = java.lang.Math.max(i, i3);
                i2 = java.lang.Math.max(i2, mVar2.n);
                b2 = java.lang.Math.max(b2, b(aVar, mVar2));
            }
        }
        if (z2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Resolutions unknown. Codec max resolution: ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            android.graphics.Point a2 = a(aVar, mVar);
            if (a2 != null) {
                i = java.lang.Math.max(i, a2.x);
                i2 = java.lang.Math.max(i2, a2.y);
                b2 = java.lang.Math.max(b2, a(aVar, mVar.h, i, i2));
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Codec max resolution adjusted to: ");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
            }
        }
        return new com.anythink.expressad.exoplayer.l.e.a(i, i2, b2);
    }

    private void a(android.media.MediaCodec mediaCodec, int i) {
        com.anythink.expressad.exoplayer.k.ad.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        com.anythink.expressad.exoplayer.k.ad.a();
        ((com.anythink.expressad.exoplayer.f.b) this).q.f++;
    }

    @android.annotation.TargetApi(21)
    private void a(android.media.MediaCodec mediaCodec, int i, long j) {
        H();
        com.anythink.expressad.exoplayer.k.ad.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        com.anythink.expressad.exoplayer.k.ad.a();
        this.V = android.os.SystemClock.elapsedRealtime() * 1000;
        ((com.anythink.expressad.exoplayer.f.b) this).q.e++;
        this.T = 0;
        C();
    }

    @android.annotation.TargetApi(23)
    private static void a(android.media.MediaCodec mediaCodec, android.view.Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @android.annotation.TargetApi(21)
    private static void a(android.media.MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    private void a(android.view.Surface surface) {
        if (surface == null) {
            android.view.Surface surface2 = this.M;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.anythink.expressad.exoplayer.f.a z2 = z();
                if (z2 != null && b(z2)) {
                    surface = com.anythink.expressad.exoplayer.l.c.a(this.B, z2.h);
                    this.M = surface;
                }
            }
        }
        if (this.L == surface) {
            if (surface == null || surface == this.M) {
                return;
            }
            I();
            if (this.O) {
                this.D.a(this.L);
                return;
            }
            return;
        }
        this.L = surface;
        int a_ = a_();
        if (a_ == 1 || a_ == 2) {
            android.media.MediaCodec y2 = y();
            if (com.anythink.expressad.exoplayer.k.af.a < 23 || y2 == null || surface == null || this.K) {
                A();
                x();
            } else {
                y2.setOutputSurface(surface);
            }
        }
        if (surface == null || surface == this.M) {
            G();
            E();
            return;
        }
        I();
        E();
        if (a_ == 2) {
            D();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x05c8 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(java.lang.String str) {
        char c = 0;
        char c2 = 27;
        if (com.anythink.expressad.exoplayer.k.af.a >= 27 || str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (com.anythink.expressad.exoplayer.l.e.class) {
            if (!z) {
                java.lang.String str2 = com.anythink.expressad.exoplayer.k.af.b;
                switch (str2.hashCode()) {
                    case -2144781245:
                        if (str2.equals("GIONEE_SWW1609")) {
                            c2 = '\'';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2144781185:
                        if (str2.equals("GIONEE_SWW1627")) {
                            c2 = '(';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2144781160:
                        if (str2.equals("GIONEE_SWW1631")) {
                            c2 = ')';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2097309513:
                        if (str2.equals("K50a40")) {
                            c2 = '9';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -2022874474:
                        if (str2.equals("CP8676_I02")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1978993182:
                        if (str2.equals("NX541J")) {
                            c2 = 'E';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1978990237:
                        if (str2.equals("NX573J")) {
                            c2 = 'F';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1936688988:
                        if (str2.equals("PGN528")) {
                            c2 = 'P';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1936688066:
                        if (str2.equals("PGN610")) {
                            c2 = 'Q';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1936688065:
                        if (str2.equals("PGN611")) {
                            c2 = 'R';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1931988508:
                        if (str2.equals("AquaPowerM")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1696512866:
                        if (str2.equals("XT1663")) {
                            c2 = 's';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1680025915:
                        if (str2.equals("ComioS1")) {
                            c2 = 15;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1615810839:
                        if (str2.equals("Phantom6")) {
                            c2 = 'S';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1554255044:
                        if (str2.equals("vernee_M5")) {
                            c2 = com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1481772737:
                        if (str2.equals("panell_dl")) {
                            c2 = 'L';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1481772730:
                        if (str2.equals("panell_ds")) {
                            c2 = 'M';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1481772729:
                        if (str2.equals("panell_dt")) {
                            c2 = 'N';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1320080169:
                        if (str2.equals("GiONEE_GBL7319")) {
                            c2 = '%';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1217592143:
                        if (str2.equals("BRAVIA_ATV2")) {
                            c2 = '\r';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1180384755:
                        if (str2.equals("iris60")) {
                            c2 = '5';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1139198265:
                        if (str2.equals("Slate_Pro")) {
                            c2 = '`';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1052835013:
                        if (str2.equals("namath")) {
                            c2 = 'C';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -993250464:
                        if (str2.equals("A10-70F")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -965403638:
                        if (str2.equals("s905x018")) {
                            c2 = com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -958336948:
                        if (str2.equals("ELUGA_Ray_X")) {
                            c2 = com.alibaba.fastjson.parser.JSONLexer.EOI;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -879245230:
                        if (str2.equals("tcl_eu")) {
                            c2 = 'h';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -842500323:
                        if (str2.equals("nicklaus_f")) {
                            c2 = 'D';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -821392978:
                        if (str2.equals("A7000-a")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -797483286:
                        if (str2.equals("SVP-DTV15")) {
                            c2 = 'a';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -794946968:
                        if (str2.equals("watson")) {
                            c2 = 'm';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -788334647:
                        if (str2.equals("whyred")) {
                            c2 = 'n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -782144577:
                        if (str2.equals("OnePlus5T")) {
                            c2 = 'G';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -575125681:
                        if (str2.equals("GiONEE_CBL7513")) {
                            c2 = kotlin.text.Typography.dollar;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -521118391:
                        if (str2.equals("GIONEE_GBL7360")) {
                            c2 = kotlin.text.Typography.amp;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -430914369:
                        if (str2.equals("Pixi4-7_3G")) {
                            c2 = 'T';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -290434366:
                        if (str2.equals("taido_row")) {
                            c2 = 'c';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -282781963:
                        if (str2.equals("BLACK-1X")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -277133239:
                        if (str2.equals("Z12_PRO")) {
                            c2 = com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -173639913:
                        if (str2.equals("ELUGA_A3_Pro")) {
                            c2 = 23;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -56598463:
                        if (str2.equals("woods_fn")) {
                            c2 = 'p';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2126:
                        if (str2.equals("C1")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2564:
                        if (str2.equals("Q5")) {
                            c2 = '\\';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2715:
                        if (str2.equals(com.igexin.push.core.g.e)) {
                            c2 = 'i';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2719:
                        if (str2.equals("V5")) {
                            c2 = 'k';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3483:
                        if (str2.equals("mh")) {
                            c2 = '@';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 73405:
                        if (str2.equals("JGZ")) {
                            c2 = '8';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 75739:
                        if (str2.equals("M5c")) {
                            c2 = kotlin.text.Typography.less;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 76779:
                        if (str2.equals("MX6")) {
                            c2 = 'B';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 78669:
                        if (str2.equals("P85")) {
                            c2 = 'J';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 79305:
                        if (str2.equals("PLE")) {
                            c2 = 'V';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 80618:
                        if (str2.equals("QX1")) {
                            c2 = '^';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 88274:
                        if (str2.equals("Z80")) {
                            c2 = 'u';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 98846:
                        if (str2.equals("cv1")) {
                            c2 = 19;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 98848:
                        if (str2.equals("cv3")) {
                            c2 = 20;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 99329:
                        if (str2.equals("deb")) {
                            c2 = 21;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 101481:
                        if (str2.equals("flo")) {
                            c2 = '#';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1513190:
                        if (str2.equals("1601")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1514184:
                        if (str2.equals("1713")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1514185:
                        if (str2.equals("1714")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2436959:
                        if (str2.equals("P681")) {
                            c2 = 'I';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2463773:
                        if (str2.equals("Q350")) {
                            c2 = 'X';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2464648:
                        if (str2.equals("Q427")) {
                            c2 = 'Z';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2689555:
                        if (str2.equals("XE2X")) {
                            c2 = com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3351335:
                        if (str2.equals("mido")) {
                            c2 = 'A';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3386211:
                        if (str2.equals("p212")) {
                            c2 = 'H';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 41325051:
                        if (str2.equals("MEIZU_M5")) {
                            c2 = '?';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 55178625:
                        if (str2.equals("Aura_Note_2")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 61542055:
                        if (str2.equals("A1601")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 65355429:
                        if (str2.equals("E5643")) {
                            c2 = 22;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66214468:
                        if (str2.equals("F3111")) {
                            c2 = 28;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66214470:
                        if (str2.equals("F3113")) {
                            c2 = 29;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66214473:
                        if (str2.equals("F3116")) {
                            c2 = 30;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66215429:
                        if (str2.equals("F3211")) {
                            c2 = 31;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66215431:
                        if (str2.equals("F3213")) {
                            c2 = ' ';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66215433:
                        if (str2.equals("F3215")) {
                            c2 = '!';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 66216390:
                        if (str2.equals("F3311")) {
                            c2 = kotlin.text.Typography.quote;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 76402249:
                        if (str2.equals("PRO7S")) {
                            c2 = 'W';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 76404105:
                        if (str2.equals("Q4260")) {
                            c2 = 'Y';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 76404911:
                        if (str2.equals("Q4310")) {
                            c2 = '[';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 80963634:
                        if (str2.equals("V23GB")) {
                            c2 = 'j';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 82882791:
                        if (str2.equals("X3_HK")) {
                            c2 = 'q';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 102844228:
                        if (str2.equals("le_x6")) {
                            c2 = ':';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 165221241:
                        if (str2.equals("A2016a40")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 182191441:
                        if (str2.equals("CPY83_I00")) {
                            c2 = 18;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 245388979:
                        if (str2.equals("marino_f")) {
                            c2 = kotlin.text.Typography.greater;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 287431619:
                        if (str2.equals("griffin")) {
                            c2 = '-';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 307593612:
                        if (str2.equals("A7010a48")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 308517133:
                        if (str2.equals("A7020a48")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 316215098:
                        if (str2.equals("TB3-730F")) {
                            c2 = 'd';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 316215116:
                        if (str2.equals("TB3-730X")) {
                            c2 = 'e';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 316246811:
                        if (str2.equals("TB3-850F")) {
                            c2 = 'f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 316246818:
                        if (str2.equals("TB3-850M")) {
                            c2 = 'g';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 407160593:
                        if (str2.equals("Pixi5-10_4G")) {
                            c2 = 'U';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 507412548:
                        if (str2.equals("QM16XE_U")) {
                            c2 = ']';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 793982701:
                        if (str2.equals("GIONEE_WBL5708")) {
                            c2 = '*';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 794038622:
                        if (str2.equals("GIONEE_WBL7365")) {
                            c2 = '+';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 794040393:
                        if (str2.equals("GIONEE_WBL7519")) {
                            c2 = ',';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 835649806:
                        if (str2.equals("manning")) {
                            c2 = com.alipay.sdk.m.n.a.h;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 917340916:
                        if (str2.equals("A7000plus")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 958008161:
                        if (str2.equals("j2xlteins")) {
                            c2 = '7';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1060579533:
                        if (str2.equals("panell_d")) {
                            c2 = 'K';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1150207623:
                        if (str2.equals("LS-5017")) {
                            c2 = ';';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1176899427:
                        if (str2.equals("itel_S41")) {
                            c2 = '6';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1280332038:
                        if (str2.equals("hwALE-H")) {
                            c2 = '/';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1306947716:
                        if (str2.equals("EverStar_S")) {
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1349174697:
                        if (str2.equals("htc_e56ml_dtul")) {
                            c2 = '.';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1522194893:
                        if (str2.equals("woods_f")) {
                            c2 = 'o';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1691543273:
                        if (str2.equals("CPH1609")) {
                            c2 = 17;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1709443163:
                        if (str2.equals("iball8735_9806")) {
                            c2 = '3';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1865889110:
                        if (str2.equals("santoni")) {
                            c2 = '_';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1906253259:
                        if (str2.equals("PB2-670M")) {
                            c2 = 'O';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1977196784:
                        if (str2.equals("Infinix-X572")) {
                            c2 = '4';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2029784656:
                        if (str2.equals("HWBLN-H")) {
                            c2 = '0';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2030379515:
                        if (str2.equals("HWCAM-H")) {
                            c2 = '1';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2047190025:
                        if (str2.equals("ELUGA_Note")) {
                            c2 = 24;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2047252157:
                        if (str2.equals("ELUGA_Prim")) {
                            c2 = 25;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2048319463:
                        if (str2.equals("HWVNS-H")) {
                            c2 = '2';
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case ' ':
                    case '!':
                    case '\"':
                    case '#':
                    case '$':
                    case '%':
                    case '&':
                    case '\'':
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '/':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'I':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'O':
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'S':
                    case 'T':
                    case 'U':
                    case 'V':
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                    case '[':
                    case '\\':
                    case ']':
                    case '^':
                    case '_':
                    case '`':
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                        A = true;
                        break;
                }
                java.lang.String str3 = com.anythink.expressad.exoplayer.k.af.d;
                int hashCode = str3.hashCode();
                if (hashCode != 2006354) {
                    if (hashCode == 2006367 && str3.equals("AFTN")) {
                        c = 1;
                        if (c != 0 || c == 1) {
                            A = true;
                        }
                        z = true;
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                    A = true;
                    z = true;
                } else {
                    if (str3.equals("AFTA")) {
                        if (c != 0) {
                        }
                        A = true;
                        z = true;
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                    A = true;
                    z = true;
                }
            }
        }
        return A;
    }

    private static boolean a(boolean z2, com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        if (mVar.h.equals(mVar2.h) && mVar.p == mVar2.p) {
            return (z2 || (mVar.m == mVar2.m && mVar.n == mVar2.n)) && com.anythink.expressad.exoplayer.k.af.a(mVar.t, mVar2.t);
        }
        return false;
    }

    private static int b(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar) {
        if (mVar.i == -1) {
            return a(aVar, mVar.h, mVar.m, mVar.n);
        }
        int size = mVar.j.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += mVar.j.get(i2).length;
        }
        return mVar.i + i;
    }

    private void b(int i) {
        com.anythink.expressad.exoplayer.c.d dVar = ((com.anythink.expressad.exoplayer.f.b) this).q;
        dVar.g += i;
        this.S += i;
        int i2 = this.T + i;
        this.T = i2;
        dVar.h = java.lang.Math.max(i2, dVar.h);
        if (this.S >= this.F) {
            J();
        }
    }

    private void b(android.media.MediaCodec mediaCodec, int i) {
        com.anythink.expressad.exoplayer.k.ad.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        com.anythink.expressad.exoplayer.k.ad.a();
        b(1);
    }

    private static boolean b(long j, long j2) {
        return g(j) && j2 > 100000;
    }

    private boolean b(com.anythink.expressad.exoplayer.f.a aVar) {
        if (com.anythink.expressad.exoplayer.k.af.a < 23 || this.ag || a(aVar.c)) {
            return false;
        }
        return !aVar.h || com.anythink.expressad.exoplayer.l.c.a(this.B);
    }

    private void c(android.media.MediaCodec mediaCodec, int i) {
        H();
        com.anythink.expressad.exoplayer.k.ad.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        com.anythink.expressad.exoplayer.k.ad.a();
        this.V = android.os.SystemClock.elapsedRealtime() * 1000;
        ((com.anythink.expressad.exoplayer.f.b) this).q.e++;
        this.T = 0;
        C();
    }

    private static boolean d(long j) {
        return g(j);
    }

    private static boolean e(long j) {
        return j < -500000;
    }

    private boolean f(long j) {
        int b2 = b(j);
        if (b2 == 0) {
            return false;
        }
        ((com.anythink.expressad.exoplayer.f.b) this).q.i++;
        b(this.U + b2);
        B();
        return true;
    }

    private static boolean g(long j) {
        return j < -30000;
    }

    private static boolean h(long j) {
        return j < -500000;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    @androidx.annotation.CallSuper
    public final void A() {
        try {
            super.A();
            this.U = 0;
            android.view.Surface surface = this.M;
            if (surface != null) {
                if (this.L == surface) {
                    this.L = null;
                }
                surface.release();
                this.M = null;
            }
        } catch (java.lang.Throwable th) {
            this.U = 0;
            if (this.M != null) {
                android.view.Surface surface2 = this.L;
                android.view.Surface surface3 = this.M;
                if (surface2 == surface3) {
                    this.L = null;
                }
                surface3.release();
                this.M = null;
            }
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    @androidx.annotation.CallSuper
    public final void B() {
        super.B();
        this.U = 0;
    }

    public final void C() {
        if (this.O) {
            return;
        }
        this.O = true;
        this.D.a(this.L);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final int a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        if (!a(aVar.f, mVar, mVar2)) {
            return 0;
        }
        int i = mVar2.m;
        com.anythink.expressad.exoplayer.l.e.a aVar2 = this.J;
        if (i > aVar2.a || mVar2.n > aVar2.b || b(aVar, mVar2) > this.J.c) {
            return 0;
        }
        return mVar.b(mVar2) ? 1 : 3;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final int a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.m mVar) {
        boolean z2;
        int i;
        int i2;
        java.lang.String str = mVar.h;
        if (!com.anythink.expressad.exoplayer.k.o.b(str)) {
            return 0;
        }
        com.anythink.expressad.exoplayer.d.e eVar = mVar.k;
        if (eVar != null) {
            z2 = false;
            for (int i3 = 0; i3 < eVar.b; i3++) {
                z2 |= eVar.a(i3).d;
            }
        } else {
            z2 = false;
        }
        com.anythink.expressad.exoplayer.f.a a2 = cVar.a(str, z2);
        if (a2 == null) {
            return (!z2 || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!com.anythink.expressad.exoplayer.a.a(gVar, eVar)) {
            return 2;
        }
        boolean b2 = a2.b(mVar.e);
        if (b2 && (i = mVar.m) > 0 && (i2 = mVar.n) > 0) {
            if (com.anythink.expressad.exoplayer.k.af.a >= 21) {
                b2 = a2.a(i, i2, mVar.o);
            } else {
                boolean z3 = i * i2 <= com.anythink.expressad.exoplayer.f.d.b();
                if (!z3) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("FalseCheck [legacyFrameSize, ");
                    sb.append(mVar.m);
                    sb.append("x");
                    sb.append(mVar.n);
                    sb.append("] [");
                    sb.append(com.anythink.expressad.exoplayer.k.af.e);
                    sb.append("]");
                }
                b2 = z3;
            }
        }
        return (b2 ? 4 : 3) | (a2.f ? 16 : 8) | (a2.g ? 32 : 0);
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i, java.lang.Object obj) {
        if (i != 1) {
            if (i != 4) {
                super.a(i, obj);
                return;
            }
            this.N = ((java.lang.Integer) obj).intValue();
            android.media.MediaCodec y2 = y();
            if (y2 != null) {
                y2.setVideoScalingMode(this.N);
                return;
            }
            return;
        }
        android.view.Surface surface = (android.view.Surface) obj;
        if (surface == null) {
            android.view.Surface surface2 = this.M;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.anythink.expressad.exoplayer.f.a z2 = z();
                if (z2 != null && b(z2)) {
                    surface = com.anythink.expressad.exoplayer.l.c.a(this.B, z2.h);
                    this.M = surface;
                }
            }
        }
        if (this.L == surface) {
            if (surface == null || surface == this.M) {
                return;
            }
            I();
            if (this.O) {
                this.D.a(this.L);
                return;
            }
            return;
        }
        this.L = surface;
        int a_ = a_();
        if (a_ == 1 || a_ == 2) {
            android.media.MediaCodec y3 = y();
            if (com.anythink.expressad.exoplayer.k.af.a < 23 || y3 == null || surface == null || this.K) {
                A();
                x();
            } else {
                y3.setOutputSurface(surface);
            }
        }
        if (surface == null || surface == this.M) {
            G();
            E();
            return;
        }
        I();
        E();
        if (a_ == 2) {
            D();
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void a(long j, boolean z2) {
        super.a(j, z2);
        E();
        this.P = -9223372036854775807L;
        this.T = 0;
        this.ai = -9223372036854775807L;
        int i = this.ak;
        if (i != 0) {
            this.aj = this.H[i - 1];
            this.ak = 0;
        }
        if (z2) {
            D();
        } else {
            this.Q = -9223372036854775807L;
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
        boolean z2 = mediaFormat.containsKey(u) && mediaFormat.containsKey(t) && mediaFormat.containsKey(v) && mediaFormat.containsKey(w);
        this.Y = z2 ? (mediaFormat.getInteger(u) - mediaFormat.getInteger(t)) + 1 : mediaFormat.getInteger("width");
        int integer = z2 ? (mediaFormat.getInteger(v) - mediaFormat.getInteger(w)) + 1 : mediaFormat.getInteger("height");
        this.Z = integer;
        float f = this.X;
        this.ab = f;
        if (com.anythink.expressad.exoplayer.k.af.a >= 21) {
            int i = this.W;
            if (i == 90 || i == 270) {
                int i2 = this.Y;
                this.Y = integer;
                this.Z = i2;
                this.ab = 1.0f / f;
            }
        } else {
            this.aa = this.W;
        }
        mediaCodec.setVideoScalingMode(this.N);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    @androidx.annotation.CallSuper
    public final void a(com.anythink.expressad.exoplayer.c.e eVar) {
        this.U++;
        this.ai = java.lang.Math.max(eVar.f, this.ai);
        if (com.anythink.expressad.exoplayer.k.af.a >= 23 || !this.ag) {
            return;
        }
        C();
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(com.anythink.expressad.exoplayer.f.a aVar, android.media.MediaCodec mediaCodec, com.anythink.expressad.exoplayer.m mVar, android.media.MediaCrypto mediaCrypto) {
        com.anythink.expressad.exoplayer.l.e.a aVar2;
        com.anythink.expressad.exoplayer.m[] q = q();
        int i = mVar.m;
        int i2 = mVar.n;
        int b2 = b(aVar, mVar);
        if (q.length == 1) {
            aVar2 = new com.anythink.expressad.exoplayer.l.e.a(i, i2, b2);
        } else {
            boolean z2 = false;
            for (com.anythink.expressad.exoplayer.m mVar2 : q) {
                if (a(aVar.f, mVar, mVar2)) {
                    int i3 = mVar2.m;
                    z2 |= i3 == -1 || mVar2.n == -1;
                    i = java.lang.Math.max(i, i3);
                    i2 = java.lang.Math.max(i2, mVar2.n);
                    b2 = java.lang.Math.max(b2, b(aVar, mVar2));
                }
            }
            if (z2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Resolutions unknown. Codec max resolution: ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                android.graphics.Point a2 = a(aVar, mVar);
                if (a2 != null) {
                    i = java.lang.Math.max(i, a2.x);
                    i2 = java.lang.Math.max(i2, a2.y);
                    b2 = java.lang.Math.max(b2, a(aVar, mVar.h, i, i2));
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Codec max resolution adjusted to: ");
                    sb2.append(i);
                    sb2.append("x");
                    sb2.append(i2);
                }
            }
            aVar2 = new com.anythink.expressad.exoplayer.l.e.a(i, i2, b2);
        }
        this.J = aVar2;
        boolean z3 = this.G;
        int i4 = this.ah;
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", mVar.h);
        mediaFormat.setInteger("width", mVar.m);
        mediaFormat.setInteger("height", mVar.n);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.j);
        float f = mVar.o;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "rotation-degrees", mVar.p);
        com.anythink.expressad.exoplayer.l.b bVar = mVar.t;
        if (bVar != null) {
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-transfer", bVar.c);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-standard", bVar.a);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", java.nio.ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger("max-width", aVar2.a);
        mediaFormat.setInteger("max-height", aVar2.b);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "max-input-size", aVar2.c);
        int i5 = com.anythink.expressad.exoplayer.k.af.a;
        if (i5 >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z3) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i4 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i4);
        }
        if (this.L == null) {
            com.anythink.expressad.exoplayer.k.a.b(b(aVar));
            if (this.M == null) {
                this.M = com.anythink.expressad.exoplayer.l.c.a(this.B, aVar.h);
            }
            this.L = this.M;
        }
        mediaCodec.configure(mediaFormat, this.L, mediaCrypto, 0);
        if (i5 < 23 || !this.ag) {
            return;
        }
        this.r = new com.anythink.expressad.exoplayer.l.e.b(this, mediaCodec, (byte) 0);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(java.lang.String str, long j, long j2) {
        this.D.a(str, j, j2);
        this.K = a(str);
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void a(boolean z2) {
        super.a(z2);
        int i = r().b;
        this.ah = i;
        this.ag = i != 0;
        this.D.a(((com.anythink.expressad.exoplayer.f.b) this).q);
        this.C.a();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(com.anythink.expressad.exoplayer.m[] mVarArr, long j) {
        if (this.aj == -9223372036854775807L) {
            this.aj = j;
        } else {
            int i = this.ak;
            if (i == this.H.length) {
                new java.lang.StringBuilder("Too many stream changes, so dropping offset: ").append(this.H[this.ak - 1]);
            } else {
                this.ak = i + 1;
            }
            long[] jArr = this.H;
            int i2 = this.ak;
            jArr[i2 - 1] = j;
            this.I[i2 - 1] = this.ai;
        }
        super.a(mVarArr, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        if ((g(r8) && r10 - r19.V > 100000) != false) goto L72;
     */
    @Override // com.anythink.expressad.exoplayer.f.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(long j, long j2, android.media.MediaCodec mediaCodec, java.nio.ByteBuffer byteBuffer, int i, int i2, long j3, boolean z2) {
        boolean z3;
        if (this.P == -9223372036854775807L) {
            this.P = j;
        }
        if (z2) {
            a(mediaCodec, i);
            return true;
        }
        long j4 = j3 - j;
        if (this.L == this.M) {
            if (!g(j4)) {
                return false;
            }
            a(mediaCodec, i);
            return true;
        }
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
        boolean z4 = a_() == 2;
        if (this.O) {
            if (z4) {
            }
            if (!z4 || j == this.P) {
                return false;
            }
            long j5 = j4 - (elapsedRealtime - j2);
            long nanoTime = java.lang.System.nanoTime();
            long a2 = this.C.a(j3, (j5 * 1000) + nanoTime);
            long j6 = (a2 - nanoTime) / 1000;
            if (j6 < -500000) {
                int b2 = b(j);
                if (b2 == 0) {
                    z3 = false;
                } else {
                    ((com.anythink.expressad.exoplayer.f.b) this).q.i++;
                    b(this.U + b2);
                    B();
                    z3 = true;
                }
                if (z3) {
                    return false;
                }
            }
            if (g(j6)) {
                com.anythink.expressad.exoplayer.k.ad.a("dropVideoBuffer");
                mediaCodec.releaseOutputBuffer(i, false);
                com.anythink.expressad.exoplayer.k.ad.a();
                b(1);
                return true;
            }
            if (com.anythink.expressad.exoplayer.k.af.a >= 21) {
                if (j6 >= 50000) {
                    return false;
                }
                a(mediaCodec, i, a2);
                return true;
            }
            if (j6 >= 30000) {
                return false;
            }
            if (j6 > 11000) {
                try {
                    java.lang.Thread.sleep((j6 - 10000) / 1000);
                } catch (java.lang.InterruptedException unused) {
                    java.lang.Thread.currentThread().interrupt();
                    return false;
                }
            }
            c(mediaCodec, i);
            return true;
        }
        if (com.anythink.expressad.exoplayer.k.af.a >= 21) {
            a(mediaCodec, i, java.lang.System.nanoTime());
            return true;
        }
        c(mediaCodec, i);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final boolean a(com.anythink.expressad.exoplayer.f.a aVar) {
        return this.L != null || b(aVar);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void b(com.anythink.expressad.exoplayer.m mVar) {
        super.b(mVar);
        this.D.a(mVar);
        this.X = mVar.q;
        this.W = mVar.p;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    @androidx.annotation.CallSuper
    public final void c(long j) {
        this.U--;
        while (true) {
            int i = this.ak;
            if (i == 0 || j < this.I[0]) {
                return;
            }
            long[] jArr = this.H;
            this.aj = jArr[0];
            int i2 = i - 1;
            this.ak = i2;
            java.lang.System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.I;
            java.lang.System.arraycopy(jArr2, 1, jArr2, 0, this.ak);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void n() {
        super.n();
        this.S = 0;
        this.R = android.os.SystemClock.elapsedRealtime();
        this.V = android.os.SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void o() {
        this.Q = -9223372036854775807L;
        J();
        super.o();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void p() {
        this.Y = -1;
        this.Z = -1;
        this.ab = -1.0f;
        this.X = -1.0f;
        this.aj = -9223372036854775807L;
        this.ai = -9223372036854775807L;
        this.ak = 0;
        G();
        E();
        this.C.b();
        this.r = null;
        this.ag = false;
        try {
            super.p();
        } finally {
            this.D.b(((com.anythink.expressad.exoplayer.f.b) this).q);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean u() {
        android.view.Surface surface;
        if (super.u() && (this.O || (((surface = this.M) != null && this.L == surface) || y() == null || this.ag))) {
            this.Q = -9223372036854775807L;
            return true;
        }
        if (this.Q == -9223372036854775807L) {
            return false;
        }
        if (android.os.SystemClock.elapsedRealtime() < this.Q) {
            return true;
        }
        this.Q = -9223372036854775807L;
        return false;
    }
}
