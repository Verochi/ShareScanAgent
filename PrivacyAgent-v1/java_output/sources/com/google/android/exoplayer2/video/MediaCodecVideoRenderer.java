package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public class MediaCodecVideoRenderer extends com.google.android.exoplayer2.mediacodec.MediaCodecRenderer {
    public static final int[] J1 = {1920, 1600, 1440, 1280, 960, 854, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 540, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH};

    @androidx.annotation.Nullable
    public static final java.lang.reflect.Method K1;
    public static boolean L1;
    public static boolean M1;
    public float A1;
    public int B1;
    public int C1;
    public int D1;
    public float E1;
    public boolean F1;
    public int G1;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.video.MediaCodecVideoRenderer.OnFrameRenderedListenerV23 H1;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.video.VideoFrameMetadataListener I1;
    public final android.content.Context W0;
    public final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper X0;
    public final com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher Y0;
    public final long Z0;
    public final int a1;
    public final boolean b1;
    public com.google.android.exoplayer2.video.MediaCodecVideoRenderer.CodecMaxValues c1;
    public boolean d1;
    public boolean e1;
    public android.view.Surface f1;
    public float g1;
    public android.view.Surface h1;
    public boolean i1;
    public int j1;
    public boolean k1;
    public boolean l1;
    public boolean m1;
    public long n1;
    public long o1;
    public long p1;
    public int q1;
    public int r1;
    public int s1;
    public long t1;
    public long u1;
    public int v1;
    public int w1;
    public int x1;
    public int y1;
    public float z1;

    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    @androidx.annotation.RequiresApi(23)
    public final class OnFrameRenderedListenerV23 implements android.media.MediaCodec.OnFrameRenderedListener, android.os.Handler.Callback {
        public final android.os.Handler n;

        public OnFrameRenderedListenerV23(android.media.MediaCodec mediaCodec) {
            android.os.Handler createHandlerForCurrentLooper = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper(this);
            this.n = createHandlerForCurrentLooper;
            mediaCodec.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        public final void a(long j) {
            com.google.android.exoplayer2.video.MediaCodecVideoRenderer mediaCodecVideoRenderer = com.google.android.exoplayer2.video.MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.H1) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                mediaCodecVideoRenderer.l0();
                return;
            }
            try {
                mediaCodecVideoRenderer.onProcessedTunneledBuffer(j);
            } catch (com.google.android.exoplayer2.ExoPlaybackException e) {
                com.google.android.exoplayer2.video.MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message.what != 0) {
                return false;
            }
            a(com.google.android.exoplayer2.util.Util.toLong(message.arg1, message.arg2));
            return true;
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(android.media.MediaCodec mediaCodec, long j, long j2) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 30) {
                a(j);
            } else {
                this.n.sendMessageAtFrontOfQueue(android.os.Message.obtain(this.n, 0, (int) (j >> 32), (int) j));
            }
        }
    }

    static {
        java.lang.reflect.Method method;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 30) {
            try {
                method = android.view.Surface.class.getMethod("setFrameRate", java.lang.Float.TYPE, java.lang.Integer.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            K1 = method;
        }
        method = null;
        K1 = method;
    }

    public MediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    public MediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, -1);
    }

    public MediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, mediaCodecSelector, j, false, handler, videoRendererEventListener, i);
    }

    public MediaCodecVideoRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, long j, boolean z, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, z, 30.0f);
        this.Z0 = j;
        this.a1 = i;
        android.content.Context applicationContext = context.getApplicationContext();
        this.W0 = applicationContext;
        this.X0 = new com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper(applicationContext);
        this.Y0 = new com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.b1 = X();
        this.o1 = -9223372036854775807L;
        this.w1 = -1;
        this.x1 = -1;
        this.z1 = -1.0f;
        this.j1 = 1;
        U();
    }

    @androidx.annotation.RequiresApi(21)
    public static void W(android.media.MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    public static boolean X() {
        return "NVIDIA".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x081d, code lost:
    
        if (r0.equals("AFTN") == false) goto L602;
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x07d3, code lost:
    
        if (r0.equals("CP8676_I02") == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Y() {
        char c;
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        char c2 = 4;
        char c3 = 2;
        if (i <= 28) {
            java.lang.String str = com.google.android.exoplayer2.util.Util.DEVICE;
            str.hashCode();
            switch (str.hashCode()) {
                case -1339091551:
                    if (str.equals("dangal")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1220081023:
                    if (str.equals("dangalFHD")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1220066608:
                    if (str.equals("dangalUHD")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -64886864:
                    if (str.equals("magnolia")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 825323514:
                    if (str.equals("machuca")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
            }
            return true;
        }
        if (i <= 27 && "HWEML".equals(com.google.android.exoplayer2.util.Util.DEVICE)) {
            return true;
        }
        if (i <= 26) {
            java.lang.String str2 = com.google.android.exoplayer2.util.Util.DEVICE;
            str2.hashCode();
            switch (str2.hashCode()) {
                case -2144781245:
                    if (str2.equals("GIONEE_SWW1609")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2144781185:
                    if (str2.equals("GIONEE_SWW1627")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2144781160:
                    if (str2.equals("GIONEE_SWW1631")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2097309513:
                    if (str2.equals("K50a40")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2022874474:
                    break;
                case -1978993182:
                    if (str2.equals("NX541J")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1978990237:
                    if (str2.equals("NX573J")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1936688988:
                    if (str2.equals("PGN528")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1936688066:
                    if (str2.equals("PGN610")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1936688065:
                    if (str2.equals("PGN611")) {
                        c2 = '\t';
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
                case -1885099851:
                    if (str2.equals("RAIJIN")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1696512866:
                    if (str2.equals("XT1663")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1680025915:
                    if (str2.equals("ComioS1")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1615810839:
                    if (str2.equals("Phantom6")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1600724499:
                    if (str2.equals("pacificrim")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1554255044:
                    if (str2.equals("vernee_M5")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1481772737:
                    if (str2.equals("panell_dl")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1481772730:
                    if (str2.equals("panell_ds")) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1481772729:
                    if (str2.equals("panell_dt")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1320080169:
                    if (str2.equals("GiONEE_GBL7319")) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1217592143:
                    if (str2.equals("BRAVIA_ATV2")) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1180384755:
                    if (str2.equals("iris60")) {
                        c2 = 22;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1139198265:
                    if (str2.equals("Slate_Pro")) {
                        c2 = 23;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1052835013:
                    if (str2.equals("namath")) {
                        c2 = 24;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -993250464:
                    if (str2.equals("A10-70F")) {
                        c2 = 25;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -993250458:
                    if (str2.equals("A10-70L")) {
                        c2 = com.alibaba.fastjson.parser.JSONLexer.EOI;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -965403638:
                    if (str2.equals("s905x018")) {
                        c2 = 27;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -958336948:
                    if (str2.equals("ELUGA_Ray_X")) {
                        c2 = 28;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -879245230:
                    if (str2.equals("tcl_eu")) {
                        c2 = 29;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -842500323:
                    if (str2.equals("nicklaus_f")) {
                        c2 = 30;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -821392978:
                    if (str2.equals("A7000-a")) {
                        c2 = 31;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -797483286:
                    if (str2.equals("SVP-DTV15")) {
                        c2 = ' ';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -794946968:
                    if (str2.equals("watson")) {
                        c2 = '!';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -788334647:
                    if (str2.equals("whyred")) {
                        c2 = kotlin.text.Typography.quote;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -782144577:
                    if (str2.equals("OnePlus5T")) {
                        c2 = '#';
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
                        c2 = '%';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -430914369:
                    if (str2.equals("Pixi4-7_3G")) {
                        c2 = kotlin.text.Typography.amp;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -290434366:
                    if (str2.equals("taido_row")) {
                        c2 = '\'';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -282781963:
                    if (str2.equals("BLACK-1X")) {
                        c2 = '(';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -277133239:
                    if (str2.equals("Z12_PRO")) {
                        c2 = ')';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -173639913:
                    if (str2.equals("ELUGA_A3_Pro")) {
                        c2 = '*';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -56598463:
                    if (str2.equals("woods_fn")) {
                        c2 = '+';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2126:
                    if (str2.equals("C1")) {
                        c2 = ',';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2564:
                    if (str2.equals("Q5")) {
                        c2 = '-';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2715:
                    if (str2.equals(com.igexin.push.core.g.e)) {
                        c2 = '.';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2719:
                    if (str2.equals("V5")) {
                        c2 = '/';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3091:
                    if (str2.equals("b5")) {
                        c2 = '0';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3483:
                    if (str2.equals("mh")) {
                        c2 = '1';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 73405:
                    if (str2.equals("JGZ")) {
                        c2 = '2';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 75537:
                    if (str2.equals("M04")) {
                        c2 = '3';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 75739:
                    if (str2.equals("M5c")) {
                        c2 = '4';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 76779:
                    if (str2.equals("MX6")) {
                        c2 = '5';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 78669:
                    if (str2.equals("P85")) {
                        c2 = '6';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 79305:
                    if (str2.equals("PLE")) {
                        c2 = '7';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 80618:
                    if (str2.equals("QX1")) {
                        c2 = '8';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 88274:
                    if (str2.equals("Z80")) {
                        c2 = '9';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 98846:
                    if (str2.equals("cv1")) {
                        c2 = ':';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 98848:
                    if (str2.equals("cv3")) {
                        c2 = ';';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 99329:
                    if (str2.equals("deb")) {
                        c2 = kotlin.text.Typography.less;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 101481:
                    if (str2.equals("flo")) {
                        c2 = com.alipay.sdk.m.n.a.h;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1513190:
                    if (str2.equals("1601")) {
                        c2 = kotlin.text.Typography.greater;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1514184:
                    if (str2.equals("1713")) {
                        c2 = '?';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1514185:
                    if (str2.equals("1714")) {
                        c2 = '@';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2133089:
                    if (str2.equals("F01H")) {
                        c2 = 'A';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2133091:
                    if (str2.equals("F01J")) {
                        c2 = 'B';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2133120:
                    if (str2.equals("F02H")) {
                        c2 = 'C';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2133151:
                    if (str2.equals("F03H")) {
                        c2 = 'D';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2133182:
                    if (str2.equals("F04H")) {
                        c2 = 'E';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2133184:
                    if (str2.equals("F04J")) {
                        c2 = 'F';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2436959:
                    if (str2.equals("P681")) {
                        c2 = 'G';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2463773:
                    if (str2.equals("Q350")) {
                        c2 = 'H';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2464648:
                    if (str2.equals("Q427")) {
                        c2 = 'I';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2689555:
                    if (str2.equals("XE2X")) {
                        c2 = 'J';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3154429:
                    if (str2.equals("fugu")) {
                        c2 = 'K';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3284551:
                    if (str2.equals("kate")) {
                        c2 = 'L';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3351335:
                    if (str2.equals("mido")) {
                        c2 = 'M';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3386211:
                    if (str2.equals("p212")) {
                        c2 = 'N';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 41325051:
                    if (str2.equals("MEIZU_M5")) {
                        c2 = 'O';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51349633:
                    if (str2.equals("601LV")) {
                        c2 = 'P';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51350594:
                    if (str2.equals("602LV")) {
                        c2 = 'Q';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 55178625:
                    if (str2.equals("Aura_Note_2")) {
                        c2 = 'R';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 61542055:
                    if (str2.equals("A1601")) {
                        c2 = 'S';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 65355429:
                    if (str2.equals("E5643")) {
                        c2 = 'T';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 66214468:
                    if (str2.equals("F3111")) {
                        c2 = 'U';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 66214470:
                    if (str2.equals("F3113")) {
                        c2 = 'V';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 66214473:
                    if (str2.equals("F3116")) {
                        c2 = 'W';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 66215429:
                    if (str2.equals("F3211")) {
                        c2 = 'X';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 66215431:
                    if (str2.equals("F3213")) {
                        c2 = 'Y';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 66215433:
                    if (str2.equals("F3215")) {
                        c2 = 'Z';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 66216390:
                    if (str2.equals("F3311")) {
                        c2 = '[';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 76402249:
                    if (str2.equals("PRO7S")) {
                        c2 = '\\';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 76404105:
                    if (str2.equals("Q4260")) {
                        c2 = ']';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 76404911:
                    if (str2.equals("Q4310")) {
                        c2 = '^';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 80963634:
                    if (str2.equals("V23GB")) {
                        c2 = '_';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 82882791:
                    if (str2.equals("X3_HK")) {
                        c2 = '`';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 98715550:
                    if (str2.equals("i9031")) {
                        c2 = 'a';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 101370885:
                    if (str2.equals("l5460")) {
                        c2 = com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 102844228:
                    if (str2.equals("le_x6")) {
                        c2 = 'c';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 165221241:
                    if (str2.equals("A2016a40")) {
                        c2 = 'd';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 182191441:
                    if (str2.equals("CPY83_I00")) {
                        c2 = 'e';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 245388979:
                    if (str2.equals("marino_f")) {
                        c2 = 'f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 287431619:
                    if (str2.equals("griffin")) {
                        c2 = 'g';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 307593612:
                    if (str2.equals("A7010a48")) {
                        c2 = 'h';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 308517133:
                    if (str2.equals("A7020a48")) {
                        c2 = 'i';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 316215098:
                    if (str2.equals("TB3-730F")) {
                        c2 = 'j';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 316215116:
                    if (str2.equals("TB3-730X")) {
                        c2 = 'k';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 316246811:
                    if (str2.equals("TB3-850F")) {
                        c2 = com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 316246818:
                    if (str2.equals("TB3-850M")) {
                        c2 = 'm';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 407160593:
                    if (str2.equals("Pixi5-10_4G")) {
                        c2 = 'n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 507412548:
                    if (str2.equals("QM16XE_U")) {
                        c2 = 'o';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 793982701:
                    if (str2.equals("GIONEE_WBL5708")) {
                        c2 = 'p';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 794038622:
                    if (str2.equals("GIONEE_WBL7365")) {
                        c2 = 'q';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 794040393:
                    if (str2.equals("GIONEE_WBL7519")) {
                        c2 = com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 835649806:
                    if (str2.equals("manning")) {
                        c2 = 's';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 917340916:
                    if (str2.equals("A7000plus")) {
                        c2 = com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 958008161:
                    if (str2.equals("j2xlteins")) {
                        c2 = 'u';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1060579533:
                    if (str2.equals("panell_d")) {
                        c2 = 'v';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1150207623:
                    if (str2.equals("LS-5017")) {
                        c2 = 'w';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1176899427:
                    if (str2.equals("itel_S41")) {
                        c2 = 'x';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1280332038:
                    if (str2.equals("hwALE-H")) {
                        c2 = 'y';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1306947716:
                    if (str2.equals("EverStar_S")) {
                        c2 = 'z';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1349174697:
                    if (str2.equals("htc_e56ml_dtul")) {
                        c2 = '{';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1522194893:
                    if (str2.equals("woods_f")) {
                        c2 = '|';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1691543273:
                    if (str2.equals("CPH1609")) {
                        c2 = '}';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1691544261:
                    if (str2.equals("CPH1715")) {
                        c2 = '~';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1709443163:
                    if (str2.equals("iball8735_9806")) {
                        c2 = com.google.common.base.Ascii.MAX;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1865889110:
                    if (str2.equals("santoni")) {
                        c2 = 128;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1906253259:
                    if (str2.equals("PB2-670M")) {
                        c2 = 129;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1977196784:
                    if (str2.equals("Infinix-X572")) {
                        c2 = 130;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2006372676:
                    if (str2.equals("BRAVIA_ATV3_4K")) {
                        c2 = 131;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2019281702:
                    if (str2.equals("DM-01K")) {
                        c2 = 132;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2029784656:
                    if (str2.equals("HWBLN-H")) {
                        c2 = 133;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2030379515:
                    if (str2.equals("HWCAM-H")) {
                        c2 = 134;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2033393791:
                    if (str2.equals("ASUS_X00AD_2")) {
                        c2 = 135;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2047190025:
                    if (str2.equals("ELUGA_Note")) {
                        c2 = 136;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2047252157:
                    if (str2.equals("ELUGA_Prim")) {
                        c2 = 137;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2048319463:
                    if (str2.equals("HWVNS-H")) {
                        c2 = 138;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2048855701:
                    if (str2.equals("HWWAS-H")) {
                        c2 = 139;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                default:
                    java.lang.String str3 = com.google.android.exoplayer2.util.Util.MODEL;
                    str3.hashCode();
                    switch (str3.hashCode()) {
                        case -594534941:
                            if (str3.equals("JSN-L21")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 2006354:
                            if (str3.equals("AFTA")) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 2006367:
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    switch (c3) {
                    }
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
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case '{':
                case '|':
                case '}':
                case '~':
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID /* 132 */:
                case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD /* 133 */:
                case 134:
                case 135:
                case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME /* 136 */:
                case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON /* 137 */:
                case 138:
                case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL /* 139 */:
                    return true;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int Z(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, java.lang.String str, int i, int i2) {
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
                java.lang.String str2 = com.google.android.exoplayer2.util.Util.MODEL;
                if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !mediaCodecInfo.secure)))) {
                    i3 = com.google.android.exoplayer2.util.Util.ceilDivide(i, 16) * com.google.android.exoplayer2.util.Util.ceilDivide(i2, 16) * 16 * 16;
                    i4 = 2;
                    break;
                }
                break;
        }
        return -1;
    }

    public static android.graphics.Point a0(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format) {
        int i = format.height;
        int i2 = format.width;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : J1) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                android.graphics.Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i6, i4);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = com.google.android.exoplayer2.util.Util.ceilDivide(i4, 16) * 16;
                    int ceilDivide2 = com.google.android.exoplayer2.util.Util.ceilDivide(i5, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= com.google.android.exoplayer2.mediacodec.MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i7 = z ? ceilDivide2 : ceilDivide;
                        if (!z) {
                            ceilDivide = ceilDivide2;
                        }
                        return new android.graphics.Point(i7, ceilDivide);
                    }
                } catch (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public static java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> b0(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format, boolean z, boolean z2) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel;
        java.lang.String str = format.sampleMimeType;
        if (str == null) {
            return java.util.Collections.emptyList();
        }
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfosSortedByFormatSupport = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, z, z2), format);
        if (com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION.equals(str) && (codecProfileAndLevel = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int intValue = ((java.lang.Integer) codecProfileAndLevel.first).intValue();
            if (intValue == 16 || intValue == 256) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/hevc", z, z2));
            } else if (intValue == 512) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/avc", z, z2));
            }
        }
        return java.util.Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    public static boolean c0(long j) {
        return j < -30000;
    }

    public static boolean d0(long j) {
        return j < -500000;
    }

    public static int getMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format) {
        if (format.maxInputSize == -1) {
            return Z(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    @androidx.annotation.RequiresApi(29)
    public static void m0(android.media.MediaCodec mediaCodec, byte[] bArr) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodec.setParameters(bundle);
    }

    public final void T() {
        android.media.MediaCodec codec;
        this.k1 = false;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23 || !this.F1 || (codec = getCodec()) == null) {
            return;
        }
        this.H1 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer.OnFrameRenderedListenerV23(codec);
    }

    public final void U() {
        this.B1 = -1;
        this.C1 = -1;
        this.E1 = -1.0f;
        this.D1 = -1;
    }

    public final void V() {
        android.view.Surface surface;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 30 || (surface = this.f1) == null || surface == this.h1 || this.g1 == 0.0f) {
            return;
        }
        this.g1 = 0.0f;
        p0(surface, 0.0f);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int canKeepCodec(android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        if (!mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true)) {
            return 0;
        }
        int i = format2.width;
        com.google.android.exoplayer2.video.MediaCodecVideoRenderer.CodecMaxValues codecMaxValues = this.c1;
        if (i > codecMaxValues.width || format2.height > codecMaxValues.height || getMaxInputSize(mediaCodecInfo, format2) > this.c1.inputSize) {
            return 0;
        }
        return format.initializationDataEquals(format2) ? 3 : 2;
    }

    public boolean codecNeedsSetOutputSurfaceWorkaround(java.lang.String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (com.google.android.exoplayer2.video.MediaCodecVideoRenderer.class) {
            if (!L1) {
                M1 = Y();
                L1 = true;
            }
        }
        return M1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.mediacodec.MediaCodecAdapter mediaCodecAdapter, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable android.media.MediaCrypto mediaCrypto, float f) {
        java.lang.String str = mediaCodecInfo.codecMimeType;
        com.google.android.exoplayer2.video.MediaCodecVideoRenderer.CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.c1 = codecMaxValues;
        android.media.MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f, this.b1, this.G1);
        if (this.f1 == null) {
            if (!q0(mediaCodecInfo)) {
                throw new java.lang.IllegalStateException();
            }
            if (this.h1 == null) {
                this.h1 = com.google.android.exoplayer2.video.DummySurface.newInstanceV17(this.W0, mediaCodecInfo.secure);
            }
            this.f1 = this.h1;
        }
        mediaCodecAdapter.configure(mediaFormat, this.f1, mediaCrypto, 0);
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23 || !this.F1) {
            return;
        }
        this.H1 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer.OnFrameRenderedListenerV23(mediaCodecAdapter.getCodec());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException createDecoderException(java.lang.Throwable th, @androidx.annotation.Nullable com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return new com.google.android.exoplayer2.video.MediaCodecVideoDecoderException(th, mediaCodecInfo, this.f1);
    }

    public void dropOutputBuffer(android.media.MediaCodec mediaCodec, int i, long j) {
        com.google.android.exoplayer2.util.TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    public final void e0() {
        if (this.q1 > 0) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.Y0.droppedFrames(this.q1, elapsedRealtime - this.p1);
            this.q1 = 0;
            this.p1 = elapsedRealtime;
        }
    }

    public void f0() {
        this.m1 = true;
        if (this.k1) {
            return;
        }
        this.k1 = true;
        this.Y0.renderedFirstFrame(this.f1);
        this.i1 = true;
    }

    public final void g0() {
        int i = this.v1;
        if (i != 0) {
            this.Y0.reportVideoFrameProcessingOffset(this.u1, i);
            this.u1 = 0L;
            this.v1 = 0;
        }
    }

    public com.google.android.exoplayer2.video.MediaCodecVideoRenderer.CodecMaxValues getCodecMaxValues(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        int Z;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (Z = Z(mediaCodecInfo, format.sampleMimeType, format.width, format.height)) != -1) {
                maxInputSize = java.lang.Math.min((int) (maxInputSize * 1.5f), Z);
            }
            return new com.google.android.exoplayer2.video.MediaCodecVideoRenderer.CodecMaxValues(i, i2, maxInputSize);
        }
        boolean z = false;
        for (com.google.android.exoplayer2.Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                int i3 = format2.width;
                z |= i3 == -1 || format2.height == -1;
                i = java.lang.Math.max(i, i3);
                i2 = java.lang.Math.max(i2, format2.height);
                maxInputSize = java.lang.Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(66);
            sb.append("Resolutions unknown. Codec max resolution: ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            com.google.android.exoplayer2.util.Log.w("MediaCodecVideoRenderer", sb.toString());
            android.graphics.Point a0 = a0(mediaCodecInfo, format);
            if (a0 != null) {
                i = java.lang.Math.max(i, a0.x);
                i2 = java.lang.Math.max(i2, a0.y);
                maxInputSize = java.lang.Math.max(maxInputSize, Z(mediaCodecInfo, format.sampleMimeType, i, i2));
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(57);
                sb2.append("Codec max resolution adjusted to: ");
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                com.google.android.exoplayer2.util.Log.w("MediaCodecVideoRenderer", sb2.toString());
            }
        }
        return new com.google.android.exoplayer2.video.MediaCodecVideoRenderer.CodecMaxValues(i, i2, maxInputSize);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean getCodecNeedsEosPropagation() {
        return this.F1 && com.google.android.exoplayer2.util.Util.SDK_INT < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        float f2 = -1.0f;
        for (com.google.android.exoplayer2.Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = java.lang.Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format, boolean z) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        return b0(mediaCodecSelector, format, z, this.F1);
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    @android.annotation.TargetApi(21)
    public android.media.MediaFormat getMediaFormat(com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.video.MediaCodecVideoRenderer.CodecMaxValues codecMaxValues, float f, boolean z, int i) {
        android.util.Pair<java.lang.Integer, java.lang.Integer> codecProfileAndLevel;
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetInteger(mediaFormat, com.google.android.gms.common.Scopes.PROFILE, ((java.lang.Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            W(mediaFormat, i);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public java.lang.String getName() {
        return "MediaCodecVideoRenderer";
    }

    public android.view.Surface getSurface() {
        return this.f1;
    }

    public final void h0() {
        int i = this.w1;
        if (i == -1 && this.x1 == -1) {
            return;
        }
        if (this.B1 == i && this.C1 == this.x1 && this.D1 == this.y1 && this.E1 == this.z1) {
            return;
        }
        this.Y0.videoSizeChanged(i, this.x1, this.y1, this.z1);
        this.B1 = this.w1;
        this.C1 = this.x1;
        this.D1 = this.y1;
        this.E1 = this.z1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @android.annotation.TargetApi(29)
    public void handleInputBufferSupplementalData(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.e1) {
            java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.google.android.exoplayer2.util.Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s3 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s2 == 60 && s3 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    m0(getCodec(), bArr);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i == 1) {
            o0((android.view.Surface) obj);
            return;
        }
        if (i != 4) {
            if (i == 6) {
                this.I1 = (com.google.android.exoplayer2.video.VideoFrameMetadataListener) obj;
                return;
            } else {
                super.handleMessage(i, obj);
                return;
            }
        }
        this.j1 = ((java.lang.Integer) obj).intValue();
        android.media.MediaCodec codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.j1);
        }
    }

    public final void i0() {
        if (this.i1) {
            this.Y0.renderedFirstFrame(this.f1);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        android.view.Surface surface;
        if (super.isReady() && (this.k1 || (((surface = this.h1) != null && this.f1 == surface) || getCodec() == null || this.F1))) {
            this.o1 = -9223372036854775807L;
            return true;
        }
        if (this.o1 == -9223372036854775807L) {
            return false;
        }
        if (android.os.SystemClock.elapsedRealtime() < this.o1) {
            return true;
        }
        this.o1 = -9223372036854775807L;
        return false;
    }

    public final void j0() {
        int i = this.B1;
        if (i == -1 && this.C1 == -1) {
            return;
        }
        this.Y0.videoSizeChanged(i, this.C1, this.D1, this.E1);
    }

    public final void k0(long j, long j2, com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener = this.I1;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    public final void l0() {
        setPendingOutputEndOfStream();
    }

    public boolean maybeDropBuffersToKeyframe(android.media.MediaCodec mediaCodec, int i, long j, long j2, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        int skipSource = skipSource(j2);
        if (skipSource == 0) {
            return false;
        }
        com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedToKeyframeCount++;
        int i2 = this.s1 + skipSource;
        if (z) {
            decoderCounters.skippedOutputBufferCount += i2;
        } else {
            updateDroppedBufferCounters(i2);
        }
        flushOrReinitializeCodec();
        return true;
    }

    public final void n0() {
        this.o1 = this.Z0 > 0 ? android.os.SystemClock.elapsedRealtime() + this.Z0 : -9223372036854775807L;
    }

    public final void o0(android.view.Surface surface) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (surface == null) {
            android.view.Surface surface2 = this.h1;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && q0(codecInfo)) {
                    surface = com.google.android.exoplayer2.video.DummySurface.newInstanceV17(this.W0, codecInfo.secure);
                    this.h1 = surface;
                }
            }
        }
        if (this.f1 == surface) {
            if (surface == null || surface == this.h1) {
                return;
            }
            j0();
            i0();
            return;
        }
        V();
        this.f1 = surface;
        this.i1 = false;
        r0(true);
        int state = getState();
        android.media.MediaCodec codec = getCodec();
        if (codec != null) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT < 23 || surface == null || this.d1) {
                releaseCodec();
                maybeInitCodecOrBypass();
            } else {
                setOutputSurfaceV23(codec, surface);
            }
        }
        if (surface == null || surface == this.h1) {
            U();
            T();
            return;
        }
        j0();
        T();
        if (state == 2) {
            n0();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(java.lang.String str, long j, long j2) {
        this.Y0.decoderInitialized(str, j, j2);
        this.d1 = codecNeedsSetOutputSurfaceWorkaround(str);
        this.e1 = ((com.google.android.exoplayer2.mediacodec.MediaCodecInfo) com.google.android.exoplayer2.util.Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        U();
        T();
        this.i1 = false;
        this.X0.disable();
        this.H1 = null;
        try {
            super.onDisabled();
        } finally {
            this.Y0.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onEnabled(z, z2);
        int i = this.G1;
        int i2 = getConfiguration().tunnelingAudioSessionId;
        this.G1 = i2;
        this.F1 = i2 != 0;
        if (i2 != i) {
            releaseCodec();
        }
        this.Y0.enabled(this.decoderCounters);
        this.X0.enable();
        this.l1 = z2;
        this.m1 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder formatHolder) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onInputFormatChanged(formatHolder);
        this.Y0.inputFormatChanged(formatHolder.format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable android.media.MediaFormat mediaFormat) {
        android.media.MediaCodec codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.j1);
        }
        if (this.F1) {
            this.w1 = format.width;
            this.x1 = format.height;
        } else {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.w1 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.x1 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f = format.pixelWidthHeightRatio;
        this.z1 = f;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            int i = format.rotationDegrees;
            if (i == 90 || i == 270) {
                int i2 = this.w1;
                this.w1 = this.x1;
                this.x1 = i2;
                this.z1 = 1.0f / f;
            }
        } else {
            this.y1 = format.rotationDegrees;
        }
        this.A1 = format.frameRate;
        r0(false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onPositionReset(j, z);
        T();
        this.n1 = -9223372036854775807L;
        this.r1 = 0;
        if (z) {
            n0();
        } else {
            this.o1 = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @androidx.annotation.CallSuper
    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (this.F1) {
            return;
        }
        this.s1--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        T();
    }

    public void onProcessedTunneledBuffer(long j) throws com.google.android.exoplayer2.ExoPlaybackException {
        updateOutputFormatForTime(j);
        h0();
        this.decoderCounters.renderedOutputBufferCount++;
        f0();
        onProcessedOutputBuffer(j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @androidx.annotation.CallSuper
    public void onQueueInputBuffer(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) throws com.google.android.exoplayer2.ExoPlaybackException {
        boolean z = this.F1;
        if (!z) {
            this.s1++;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23 || !z) {
            return;
        }
        onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            super.onReset();
            android.view.Surface surface = this.h1;
            if (surface != null) {
                if (this.f1 == surface) {
                    this.f1 = null;
                }
                surface.release();
                this.h1 = null;
            }
        } catch (java.lang.Throwable th) {
            if (this.h1 != null) {
                android.view.Surface surface2 = this.f1;
                android.view.Surface surface3 = this.h1;
                if (surface2 == surface3) {
                    this.f1 = null;
                }
                surface3.release();
                this.h1 = null;
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.q1 = 0;
        this.p1 = android.os.SystemClock.elapsedRealtime();
        this.t1 = android.os.SystemClock.elapsedRealtime() * 1000;
        this.u1 = 0L;
        this.v1 = 0;
        r0(false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.o1 = -9223372036854775807L;
        e0();
        g0();
        V();
        super.onStopped();
    }

    @androidx.annotation.RequiresApi(30)
    public final void p0(android.view.Surface surface, float f) {
        java.lang.reflect.Method method = K1;
        if (method == null) {
            com.google.android.exoplayer2.util.Log.e("MediaCodecVideoRenderer", "Failed to call Surface.setFrameRate (method does not exist)");
        }
        try {
            method.invoke(surface, java.lang.Float.valueOf(f), java.lang.Integer.valueOf(f == 0.0f ? 0 : 1));
        } catch (java.lang.Exception e) {
            com.google.android.exoplayer2.util.Log.e("MediaCodecVideoRenderer", "Failed to call Surface.setFrameRate", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if (shouldForceRenderOutputBuffer(r1, r13) != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean processOutputBuffer(long j, long j2, @androidx.annotation.Nullable android.media.MediaCodec mediaCodec, @androidx.annotation.Nullable java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        long j4;
        boolean z3;
        long j5;
        boolean z4;
        com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaCodec);
        if (this.n1 == -9223372036854775807L) {
            this.n1 = j;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j6 = j3 - outputStreamOffsetUs;
        if (z && !z2) {
            skipOutputBuffer(mediaCodec, i, j6);
            return true;
        }
        long j7 = j3 - j;
        if (this.f1 == this.h1) {
            if (!c0(j7)) {
                return false;
            }
            skipOutputBuffer(mediaCodec, i, j6);
            updateVideoFrameProcessingOffsetCounters(j7);
            return true;
        }
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
        long j8 = elapsedRealtime - this.t1;
        boolean z5 = getState() == 2;
        if (this.m1 ? this.k1 : !(z5 || this.l1)) {
            j4 = elapsedRealtime;
            z3 = false;
        } else {
            j4 = elapsedRealtime;
            z3 = true;
        }
        if (this.o1 == -9223372036854775807L && j >= outputStreamOffsetUs) {
            if (z3) {
                j5 = j7;
            } else if (z5) {
                j5 = j7;
            }
            z4 = true;
            if (!z4) {
                long nanoTime = java.lang.System.nanoTime();
                k0(j6, nanoTime, format);
                if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                    renderOutputBufferV21(mediaCodec, i, j6, nanoTime);
                } else {
                    renderOutputBuffer(mediaCodec, i, j6);
                }
                updateVideoFrameProcessingOffsetCounters(j5);
                return true;
            }
            if (z5 && j != this.n1) {
                long nanoTime2 = java.lang.System.nanoTime();
                long adjustReleaseTime = this.X0.adjustReleaseTime(j3, ((j5 - (j4 - j2)) * 1000) + nanoTime2);
                long j9 = (adjustReleaseTime - nanoTime2) / 1000;
                boolean z6 = this.o1 != -9223372036854775807L;
                if (shouldDropBuffersToKeyframe(j9, j2, z2) && maybeDropBuffersToKeyframe(mediaCodec, i, j6, j, z6)) {
                    return false;
                }
                if (shouldDropOutputBuffer(j9, j2, z2)) {
                    if (z6) {
                        skipOutputBuffer(mediaCodec, i, j6);
                    } else {
                        dropOutputBuffer(mediaCodec, i, j6);
                    }
                    updateVideoFrameProcessingOffsetCounters(j9);
                    return true;
                }
                if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
                    if (j9 < 50000) {
                        k0(j6, adjustReleaseTime, format);
                        renderOutputBufferV21(mediaCodec, i, j6, adjustReleaseTime);
                        updateVideoFrameProcessingOffsetCounters(j9);
                        return true;
                    }
                } else if (j9 < 30000) {
                    if (j9 > 11000) {
                        try {
                            java.lang.Thread.sleep((j9 - 10000) / 1000);
                        } catch (java.lang.InterruptedException unused) {
                            java.lang.Thread.currentThread().interrupt();
                            return false;
                        }
                    }
                    k0(j6, adjustReleaseTime, format);
                    renderOutputBuffer(mediaCodec, i, j6);
                    updateVideoFrameProcessingOffsetCounters(j9);
                    return true;
                }
            }
            return false;
        }
        j5 = j7;
        z4 = false;
        if (!z4) {
        }
    }

    public final boolean q0(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 23 && !this.F1 && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || com.google.android.exoplayer2.video.DummySurface.isSecureSupported(this.W0));
    }

    public final void r0(boolean z) {
        android.view.Surface surface;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 30 || (surface = this.f1) == null || surface == this.h1) {
            return;
        }
        float operatingRate = getState() == 2 && (this.A1 > (-1.0f) ? 1 : (this.A1 == (-1.0f) ? 0 : -1)) != 0 ? this.A1 * getOperatingRate() : 0.0f;
        if (this.g1 != operatingRate || z) {
            this.g1 = operatingRate;
            p0(this.f1, operatingRate);
        }
    }

    public void renderOutputBuffer(android.media.MediaCodec mediaCodec, int i, long j) {
        h0();
        com.google.android.exoplayer2.util.TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        this.t1 = android.os.SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.r1 = 0;
        f0();
    }

    @androidx.annotation.RequiresApi(21)
    public void renderOutputBufferV21(android.media.MediaCodec mediaCodec, int i, long j, long j2) {
        h0();
        com.google.android.exoplayer2.util.TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        this.t1 = android.os.SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.r1 = 0;
        f0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @androidx.annotation.CallSuper
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.s1 = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public void setOperatingRate(float f) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.setOperatingRate(f);
        r0(false);
    }

    @androidx.annotation.RequiresApi(23)
    public void setOutputSurfaceV23(android.media.MediaCodec mediaCodec, android.view.Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return d0(j) && !z;
    }

    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return c0(j) && !z;
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return c0(j) && j2 > 100000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldInitCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return this.f1 != null || q0(mediaCodecInfo);
    }

    public void skipOutputBuffer(android.media.MediaCodec mediaCodec, int i, long j) {
        com.google.android.exoplayer2.util.TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        com.google.android.exoplayer2.util.TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!com.google.android.exoplayer2.util.MimeTypes.isVideo(format.sampleMimeType)) {
            return defpackage.ub2.a(0);
        }
        boolean z = format.drmInitData != null;
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> b0 = b0(mediaCodecSelector, format, z, false);
        if (z && b0.isEmpty()) {
            b0 = b0(mediaCodecSelector, format, false, false);
        }
        if (b0.isEmpty()) {
            return defpackage.ub2.a(1);
        }
        if (!com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.supportsFormatDrm(format)) {
            return defpackage.ub2.a(2);
        }
        com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo = b0.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i2 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (isFormatSupported) {
            java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> b02 = b0(mediaCodecSelector, format, z, true);
            if (!b02.isEmpty()) {
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo2 = b02.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return defpackage.ub2.b(isFormatSupported ? 4 : 3, i2, i);
    }

    public void updateDroppedBufferCounters(int i) {
        com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i;
        this.q1 += i;
        int i2 = this.r1 + i;
        this.r1 = i2;
        decoderCounters.maxConsecutiveDroppedBufferCount = java.lang.Math.max(i2, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i3 = this.a1;
        if (i3 <= 0 || this.q1 < i3) {
            return;
        }
        e0();
    }

    public void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.u1 += j;
        this.v1++;
    }
}
