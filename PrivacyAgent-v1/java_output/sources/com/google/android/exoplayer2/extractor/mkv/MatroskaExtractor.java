package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes22.dex */
public class MatroskaExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    public static final java.util.Map<java.lang.String, java.lang.Integer> f0;
    public long A;
    public long B;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.LongArray C;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.LongArray D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public long I;
    public int J;
    public int K;
    public int[] L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public byte Y;
    public boolean Z;
    public final com.google.android.exoplayer2.extractor.mkv.EbmlReader a;
    public com.google.android.exoplayer2.extractor.ExtractorOutput a0;
    public final com.google.android.exoplayer2.extractor.mkv.VarintReader b;
    public final android.util.SparseArray<com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track> c;
    public final boolean d;
    public final com.google.android.exoplayer2.util.ParsableByteArray e;
    public final com.google.android.exoplayer2.util.ParsableByteArray f;
    public final com.google.android.exoplayer2.util.ParsableByteArray g;
    public final com.google.android.exoplayer2.util.ParsableByteArray h;
    public final com.google.android.exoplayer2.util.ParsableByteArray i;
    public final com.google.android.exoplayer2.util.ParsableByteArray j;
    public final com.google.android.exoplayer2.util.ParsableByteArray k;
    public final com.google.android.exoplayer2.util.ParsableByteArray l;
    public final com.google.android.exoplayer2.util.ParsableByteArray m;
    public final com.google.android.exoplayer2.util.ParsableByteArray n;
    public java.nio.ByteBuffer o;
    public long p;
    public long q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public long f348s;
    public long t;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track u;
    public boolean v;
    public int w;
    public long x;
    public boolean y;
    public long z;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.ub1();
    public static final byte[] b0 = {org.apache.tools.tar.TarConstants.LF_LINK, 10, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 44, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 32, 45, 45, 62, 32, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 44, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 10};
    public static final byte[] c0 = com.google.android.exoplayer2.util.Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    public static final byte[] d0 = {68, 105, 97, 108, 111, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 117, 101, 58, 32, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 44, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 58, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_NORMAL, 44};
    public static final java.util.UUID e0 = new java.util.UUID(72057594037932032L, -9223371306706625679L);

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final class InnerEbmlProcessor implements com.google.android.exoplayer2.extractor.mkv.EbmlProcessor {
        public InnerEbmlProcessor() {
        }

        public /* synthetic */ InnerEbmlProcessor(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor matroskaExtractor, com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void binaryElement(int i, int i2, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.binaryElement(i, i2, extractorInput);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void endMasterElement(int i) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.endMasterElement(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void floatElement(int i, double d) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.floatElement(i, d);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public int getElementType(int i) {
            return com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.getElementType(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void integerElement(int i, long j) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.integerElement(i, j);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public boolean isLevel1Element(int i) {
            return com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.isLevel1Element(i);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void startMasterElement(int i, long j, long j2) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.startMasterElement(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void stringElement(int i, java.lang.String str) throws com.google.android.exoplayer2.ParserException {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.this.stringElement(i, str);
        }
    }

    public static final class Track {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;

        @androidx.annotation.Nullable
        public byte[] N;
        public int O;
        public int P;
        public int Q;
        public long R;
        public long S;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker T;
        public boolean U;
        public boolean V;
        public java.lang.String W;
        public com.google.android.exoplayer2.extractor.TrackOutput X;
        public int Y;
        public java.lang.String a;
        public java.lang.String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public byte[] i;
        public com.google.android.exoplayer2.extractor.TrackOutput.CryptoData j;
        public byte[] k;
        public com.google.android.exoplayer2.drm.DrmInitData l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;

        /* renamed from: s, reason: collision with root package name */
        public float f349s;
        public float t;
        public float u;
        public byte[] v;
        public int w;
        public boolean x;
        public int y;
        public int z;

        public Track() {
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = -1;
            this.f349s = 0.0f;
            this.t = 0.0f;
            this.u = 0.0f;
            this.v = null;
            this.w = -1;
            this.x = false;
            this.y = -1;
            this.z = -1;
            this.A = -1;
            this.B = 1000;
            this.C = 200;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = -1.0f;
            this.O = 1;
            this.P = -1;
            this.Q = 8000;
            this.R = 0L;
            this.S = 0L;
            this.V = true;
            this.W = "eng";
        }

        public /* synthetic */ Track(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.AnonymousClass1 anonymousClass1) {
            this();
        }

        public static android.util.Pair<java.lang.String, java.util.List<byte[]>> g(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (readLittleEndianUnsignedInt == 1482049860) {
                    return new android.util.Pair<>(com.google.android.exoplayer2.util.MimeTypes.VIDEO_DIVX, null);
                }
                if (readLittleEndianUnsignedInt == 859189832) {
                    return new android.util.Pair<>("video/3gpp", null);
                }
                if (readLittleEndianUnsignedInt != 826496599) {
                    com.google.android.exoplayer2.util.Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new android.util.Pair<>("video/x-unknown", null);
                }
                byte[] data = parsableByteArray.getData();
                for (int position = parsableByteArray.getPosition() + 20; position < data.length - 4; position++) {
                    if (data[position] == 0 && data[position + 1] == 0 && data[position + 2] == 1 && data[position + 3] == 15) {
                        return new android.util.Pair<>("video/wvc1", java.util.Collections.singletonList(java.util.Arrays.copyOfRange(data, position, data.length)));
                    }
                }
                throw new com.google.android.exoplayer2.ParserException("Failed to find FourCC VC1 initialization data");
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing FourCC private data");
            }
        }

        public static boolean h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
            try {
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (readLittleEndianUnsignedShort == 1) {
                    return true;
                }
                if (readLittleEndianUnsignedShort != 65534) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                if (parsableByteArray.readLong() == com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.e0.getMostSignificantBits()) {
                    if (parsableByteArray.readLong() == com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.e0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing MS/ACM codec private");
            }
        }

        public static java.util.List<byte[]> i(byte[] bArr) throws com.google.android.exoplayer2.ParserException {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
                }
                int i3 = 1;
                int i4 = 0;
                while (true) {
                    i = bArr[i3];
                    if (i != -1) {
                        break;
                    }
                    i4 += 255;
                    i3++;
                }
                int i5 = i3 + 1;
                int i6 = i4 + i;
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if (i2 != -1) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + i2;
                if (bArr[i8] != 1) {
                    throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[i6];
                java.lang.System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                java.lang.System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                java.util.ArrayList arrayList = new java.util.ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                throw new com.google.android.exoplayer2.ParserException("Error parsing vorbis codec private");
            }
        }

        @androidx.annotation.Nullable
        public final byte[] d() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            java.nio.ByteBuffer order = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.D * 50000.0f) + 0.5f));
            order.putShort((short) ((this.E * 50000.0f) + 0.5f));
            order.putShort((short) ((this.F * 50000.0f) + 0.5f));
            order.putShort((short) ((this.G * 50000.0f) + 0.5f));
            order.putShort((short) ((this.H * 50000.0f) + 0.5f));
            order.putShort((short) ((this.I * 50000.0f) + 0.5f));
            order.putShort((short) ((this.J * 50000.0f) + 0.5f));
            order.putShort((short) ((this.K * 50000.0f) + 0.5f));
            order.putShort((short) (this.L + 0.5f));
            order.putShort((short) (this.M + 0.5f));
            order.putShort((short) this.B);
            order.putShort((short) this.C);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:12:0x037a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0392  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x03a1  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x04d5  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x03b2  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0394  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void e(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, int i) throws com.google.android.exoplayer2.ParserException {
            char c;
            java.util.List<byte[]> singletonList;
            int pcmEncoding;
            java.util.List<byte[]> i2;
            java.lang.String str;
            int i3;
            byte[] bArr;
            java.lang.String str2;
            int i4;
            int i5;
            com.google.android.exoplayer2.video.DolbyVisionConfig parse;
            java.lang.String str3 = this.b;
            str3.hashCode();
            int i6 = 1;
            int i7 = 0;
            switch (str3.hashCode()) {
                case -2095576542:
                    if (str3.equals("V_MPEG4/ISO/AP")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -2095575984:
                    if (str3.equals("V_MPEG4/ISO/SP")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1985379776:
                    if (str3.equals("A_MS/ACM")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1784763192:
                    if (str3.equals("A_TRUEHD")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1730367663:
                    if (str3.equals("A_VORBIS")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641358:
                    if (str3.equals("A_MPEG/L2")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641357:
                    if (str3.equals("A_MPEG/L3")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1373388978:
                    if (str3.equals("V_MS/VFW/FOURCC")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -933872740:
                    if (str3.equals("S_DVBSUB")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -538363189:
                    if (str3.equals("V_MPEG4/ISO/ASP")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -538363109:
                    if (str3.equals("V_MPEG4/ISO/AVC")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -425012669:
                    if (str3.equals("S_VOBSUB")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -356037306:
                    if (str3.equals("A_DTS/LOSSLESS")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 62923557:
                    if (str3.equals("A_AAC")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 62923603:
                    if (str3.equals("A_AC3")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 62927045:
                    if (str3.equals("A_DTS")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 82318131:
                    if (str3.equals("V_AV1")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338133:
                    if (str3.equals("V_VP8")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338134:
                    if (str3.equals("V_VP9")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 99146302:
                    if (str3.equals("S_HDMV/PGS")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 444813526:
                    if (str3.equals("V_THEORA")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 542569478:
                    if (str3.equals("A_DTS/EXPRESS")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 725957860:
                    if (str3.equals("A_PCM/INT/LIT")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 738597099:
                    if (str3.equals("S_TEXT/ASS")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case 855502857:
                    if (str3.equals("V_MPEGH/ISO/HEVC")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 1422270023:
                    if (str3.equals("S_TEXT/UTF8")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 1809237540:
                    if (str3.equals("V_MPEG2")) {
                        c = com.alibaba.fastjson.parser.JSONLexer.EOI;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950749482:
                    if (str3.equals("A_EAC3")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950789798:
                    if (str3.equals("A_FLAC")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 1951062397:
                    if (str3.equals("A_OPUS")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            java.lang.String str4 = "audio/raw";
            switch (c) {
                case 0:
                case 1:
                case '\t':
                    byte[] bArr2 = this.k;
                    singletonList = bArr2 == null ? null : java.util.Collections.singletonList(bArr2);
                    str4 = "video/mp4v-es";
                    i2 = singletonList;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null && (parse = com.google.android.exoplayer2.video.DolbyVisionConfig.parse(new com.google.android.exoplayer2.util.ParsableByteArray(bArr))) != null) {
                        str = parse.codecs;
                        str4 = com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str2 = str4;
                    int i8 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                        builder.setChannelCount(this.O).setSampleRate(this.Q).setPcmEncoding(pcmEncoding);
                    } else if (com.google.android.exoplayer2.util.MimeTypes.isVideo(str2)) {
                        if (this.q == 0) {
                            int i9 = this.o;
                            i4 = -1;
                            if (i9 == -1) {
                                i9 = this.m;
                            }
                            this.o = i9;
                            int i10 = this.p;
                            if (i10 == -1) {
                                i10 = this.n;
                            }
                            this.p = i10;
                        } else {
                            i4 = -1;
                        }
                        float f = (this.o == i4 || (i5 = this.p) == i4) ? -1.0f : (this.n * r1) / (this.m * i5);
                        com.google.android.exoplayer2.video.ColorInfo colorInfo = this.x ? new com.google.android.exoplayer2.video.ColorInfo(this.y, this.A, this.z, d()) : null;
                        if (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                            i4 = ((java.lang.Integer) com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.get(this.a)).intValue();
                        }
                        if (this.r == 0 && java.lang.Float.compare(this.f349s, 0.0f) == 0 && java.lang.Float.compare(this.t, 0.0f) == 0) {
                            if (java.lang.Float.compare(this.u, 0.0f) != 0) {
                                if (java.lang.Float.compare(this.t, 90.0f) == 0) {
                                    i7 = 90;
                                } else if (java.lang.Float.compare(this.t, -180.0f) == 0 || java.lang.Float.compare(this.t, 180.0f) == 0) {
                                    i7 = 180;
                                } else if (java.lang.Float.compare(this.t, -90.0f) == 0) {
                                    i7 = 270;
                                }
                            }
                            builder.setWidth(this.m).setHeight(this.n).setPixelWidthHeightRatio(f).setRotationDegrees(i7).setProjectionData(this.v).setStereoMode(this.w).setColorInfo(colorInfo);
                            i6 = 2;
                        }
                        i7 = i4;
                        builder.setWidth(this.m).setHeight(this.n).setPixelWidthHeightRatio(f).setRotationDegrees(i7).setProjectionData(this.v).setStereoMode(this.w).setColorInfo(colorInfo);
                        i6 = 2;
                    } else {
                        if (!"application/x-subrip".equals(str2)) {
                            if ("text/x-ssa".equals(str2)) {
                                i2 = new java.util.ArrayList<>(2);
                                i2.add(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.c0);
                                i2.add(this.k);
                            } else if (!"application/vobsub".equals(str2) && !"application/pgs".equals(str2) && !"application/dvbsubs".equals(str2)) {
                                throw new com.google.android.exoplayer2.ParserException("Unexpected MIME type.");
                            }
                        }
                        i6 = 3;
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                        builder.setLabel(this.a);
                    }
                    com.google.android.exoplayer2.Format build = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(this.c, i6);
                    this.X = track;
                    track.format(build);
                    return;
                case 2:
                    if (h(new com.google.android.exoplayer2.util.ParsableByteArray(this.k))) {
                        pcmEncoding = com.google.android.exoplayer2.util.Util.getPcmEncoding(this.P);
                        if (pcmEncoding == 0) {
                            int i11 = this.P;
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("audio/x-unknown".length() + 60);
                            sb.append("Unsupported PCM bit depth: ");
                            sb.append(i11);
                            sb.append(". Setting mimeType to ");
                            sb.append("audio/x-unknown");
                            com.google.android.exoplayer2.util.Log.w("MatroskaExtractor", sb.toString());
                        }
                        i2 = null;
                        str = null;
                        i3 = -1;
                        bArr = this.N;
                        if (bArr != null) {
                            str = parse.codecs;
                            str4 = com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION;
                            break;
                        }
                        str2 = str4;
                        int i82 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                        com.google.android.exoplayer2.Format.Builder builder2 = new com.google.android.exoplayer2.Format.Builder();
                        if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                        }
                        if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                        }
                        com.google.android.exoplayer2.Format build2 = builder2.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                        com.google.android.exoplayer2.extractor.TrackOutput track2 = extractorOutput.track(this.c, i6);
                        this.X = track2;
                        track2.format(build2);
                        return;
                    }
                    com.google.android.exoplayer2.util.Log.w("MatroskaExtractor", "audio/x-unknown".length() != 0 ? "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown") : new java.lang.String("Non-PCM MS/ACM is unsupported. Setting mimeType to "));
                    str4 = "audio/x-unknown";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i822 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder22 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build22 = builder22.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track22 = extractorOutput.track(this.c, i6);
                    this.X = track22;
                    track22.format(build22);
                    return;
                case 3:
                    this.T = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker();
                    str4 = "audio/true-hd";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222 = builder222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222 = extractorOutput.track(this.c, i6);
                    this.X = track222;
                    track222.format(build222);
                    return;
                case 4:
                    str4 = "audio/vorbis";
                    i2 = i(this.k);
                    str = null;
                    pcmEncoding = -1;
                    i3 = 8192;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222 = builder2222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222 = extractorOutput.track(this.c, i6);
                    this.X = track2222;
                    track2222.format(build2222);
                    return;
                case 5:
                    str4 = "audio/mpeg-L2";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = 4096;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i822222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder22222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build22222 = builder22222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track22222 = extractorOutput.track(this.c, i6);
                    this.X = track22222;
                    track22222.format(build22222);
                    return;
                case 6:
                    str4 = "audio/mpeg";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = 4096;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222222 = builder222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222222 = extractorOutput.track(this.c, i6);
                    this.X = track222222;
                    track222222.format(build222222);
                    return;
                case 7:
                    android.util.Pair<java.lang.String, java.util.List<byte[]>> g = g(new com.google.android.exoplayer2.util.ParsableByteArray(this.k));
                    str4 = (java.lang.String) g.first;
                    singletonList = (java.util.List) g.second;
                    i2 = singletonList;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222222 = builder2222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222222 = extractorOutput.track(this.c, i6);
                    this.X = track2222222;
                    track2222222.format(build2222222);
                    return;
                case '\b':
                    byte[] bArr3 = this.k;
                    i2 = java.util.Collections.singletonList(new byte[]{bArr3[0], bArr3[1], bArr3[2], bArr3[3]});
                    str4 = "application/dvbsubs";
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i822222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder22222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build22222222 = builder22222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track22222222 = extractorOutput.track(this.c, i6);
                    this.X = track22222222;
                    track22222222.format(build22222222);
                    return;
                case '\n':
                    com.google.android.exoplayer2.video.AvcConfig parse2 = com.google.android.exoplayer2.video.AvcConfig.parse(new com.google.android.exoplayer2.util.ParsableByteArray(this.k));
                    i2 = parse2.initializationData;
                    this.Y = parse2.nalUnitLengthFieldLength;
                    str4 = "video/avc";
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222222222 = builder222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222222222 = extractorOutput.track(this.c, i6);
                    this.X = track222222222;
                    track222222222.format(build222222222);
                    return;
                case 11:
                    i2 = java.util.Collections.singletonList(this.k);
                    str4 = "application/vobsub";
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222222222 = builder2222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222222222 = extractorOutput.track(this.c, i6);
                    this.X = track2222222222;
                    track2222222222.format(build2222222222);
                    return;
                case '\f':
                    str4 = "audio/vnd.dts.hd";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i822222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder22222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build22222222222 = builder22222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track22222222222 = extractorOutput.track(this.c, i6);
                    this.X = track22222222222;
                    track22222222222.format(build22222222222);
                    return;
                case '\r':
                    java.util.List<byte[]> singletonList2 = java.util.Collections.singletonList(this.k);
                    com.google.android.exoplayer2.audio.AacUtil.Config parseAudioSpecificConfig = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(this.k);
                    this.Q = parseAudioSpecificConfig.sampleRateHz;
                    this.O = parseAudioSpecificConfig.channelCount;
                    str4 = "audio/mp4a-latm";
                    str = parseAudioSpecificConfig.codecs;
                    i3 = -1;
                    i2 = singletonList2;
                    pcmEncoding = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222222222222 = builder222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track222222222222;
                    track222222222222.format(build222222222222);
                    return;
                case 14:
                    str4 = "audio/ac3";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222222222222 = builder2222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track2222222222222;
                    track2222222222222.format(build2222222222222);
                    return;
                case 15:
                case 21:
                    str4 = "audio/vnd.dts";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i822222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder22222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build22222222222222 = builder22222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track22222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track22222222222222;
                    track22222222222222.format(build22222222222222);
                    return;
                case 16:
                    str4 = com.google.android.exoplayer2.util.MimeTypes.VIDEO_AV1;
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222222222222222 = builder222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track222222222222222;
                    track222222222222222.format(build222222222222222);
                    return;
                case 17:
                    str4 = "video/x-vnd.on2.vp8";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222222222222222 = builder2222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track2222222222222222;
                    track2222222222222222.format(build2222222222222222);
                    return;
                case 18:
                    str4 = "video/x-vnd.on2.vp9";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i822222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder22222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build22222222222222222 = builder22222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track22222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track22222222222222222;
                    track22222222222222222.format(build22222222222222222);
                    return;
                case 19:
                    str4 = "application/pgs";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222222222222222222 = builder222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track222222222222222222;
                    track222222222222222222.format(build222222222222222222);
                    return;
                case 20:
                    str4 = "video/x-unknown";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222222222222222222 = builder2222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track2222222222222222222;
                    track2222222222222222222.format(build2222222222222222222);
                    return;
                case 22:
                    pcmEncoding = com.google.android.exoplayer2.util.Util.getPcmEncoding(this.P);
                    if (pcmEncoding == 0) {
                        int i12 = this.P;
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("audio/x-unknown".length() + 60);
                        sb2.append("Unsupported PCM bit depth: ");
                        sb2.append(i12);
                        sb2.append(". Setting mimeType to ");
                        sb2.append("audio/x-unknown");
                        com.google.android.exoplayer2.util.Log.w("MatroskaExtractor", sb2.toString());
                        str4 = "audio/x-unknown";
                        i2 = null;
                        str = null;
                        pcmEncoding = -1;
                        i3 = -1;
                        bArr = this.N;
                        if (bArr != null) {
                        }
                        str2 = str4;
                        int i822222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                        com.google.android.exoplayer2.Format.Builder builder22222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                        if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                        }
                        if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                        }
                        com.google.android.exoplayer2.Format build22222222222222222222 = builder22222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                        com.google.android.exoplayer2.extractor.TrackOutput track22222222222222222222 = extractorOutput.track(this.c, i6);
                        this.X = track22222222222222222222;
                        track22222222222222222222.format(build22222222222222222222);
                        return;
                    }
                    i2 = null;
                    str = null;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222222222222222222222 = builder222222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track222222222222222222222;
                    track222222222222222222222.format(build222222222222222222222);
                    return;
                case 23:
                    str4 = "text/x-ssa";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222222222222222222222 = builder2222222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track2222222222222222222222;
                    track2222222222222222222222.format(build2222222222222222222222);
                    return;
                case 24:
                    com.google.android.exoplayer2.video.HevcConfig parse3 = com.google.android.exoplayer2.video.HevcConfig.parse(new com.google.android.exoplayer2.util.ParsableByteArray(this.k));
                    i2 = parse3.initializationData;
                    this.Y = parse3.nalUnitLengthFieldLength;
                    str4 = "video/hevc";
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i822222222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder22222222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build22222222222222222222222 = builder22222222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822222222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track22222222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track22222222222222222222222;
                    track22222222222222222222222.format(build22222222222222222222222);
                    return;
                case 25:
                    str4 = "application/x-subrip";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222222222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222222222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222222222222222222222222 = builder222222222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222222222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222222222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track222222222222222222222222;
                    track222222222222222222222222.format(build222222222222222222222222);
                    return;
                case 26:
                    str4 = "video/mpeg2";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222222222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222222222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222222222222222222222222 = builder2222222222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222222222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222222222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track2222222222222222222222222;
                    track2222222222222222222222222.format(build2222222222222222222222222);
                    return;
                case 27:
                    str4 = "audio/eac3";
                    i2 = null;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i822222222222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder22222222222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build22222222222222222222222222 = builder22222222222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i822222222222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track22222222222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track22222222222222222222222222;
                    track22222222222222222222222222.format(build22222222222222222222222222);
                    return;
                case 28:
                    singletonList = java.util.Collections.singletonList(this.k);
                    str4 = "audio/flac";
                    i2 = singletonList;
                    str = null;
                    pcmEncoding = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i8222222222222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder222222222222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build222222222222222222222222222 = builder222222222222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i8222222222222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track222222222222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track222222222222222222222222222;
                    track222222222222222222222222222.format(build222222222222222222222222222);
                    return;
                case 29:
                    java.util.ArrayList arrayList = new java.util.ArrayList(3);
                    arrayList.add(this.k);
                    java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8);
                    java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
                    arrayList.add(allocate.order(byteOrder).putLong(this.R).array());
                    arrayList.add(java.nio.ByteBuffer.allocate(8).order(byteOrder).putLong(this.S).array());
                    str4 = "audio/opus";
                    i2 = arrayList;
                    str = null;
                    pcmEncoding = -1;
                    i3 = 5760;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str2 = str4;
                    int i82222222222222222222222222222 = (this.V ? 1 : 0) | 0 | (this.U ? 2 : 0);
                    com.google.android.exoplayer2.Format.Builder builder2222222222222222222222222222 = new com.google.android.exoplayer2.Format.Builder();
                    if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str2)) {
                    }
                    if (!com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.f0.containsKey(this.a)) {
                    }
                    com.google.android.exoplayer2.Format build2222222222222222222222222222 = builder2222222222222222222222222222.setId(i).setSampleMimeType(str2).setMaxInputSize(i3).setLanguage(this.W).setSelectionFlags(i82222222222222222222222222222).setInitializationData(i2).setCodecs(str).setDrmInitData(this.l).build();
                    com.google.android.exoplayer2.extractor.TrackOutput track2222222222222222222222222222 = extractorOutput.track(this.c, i6);
                    this.X = track2222222222222222222222222222;
                    track2222222222222222222222222222.format(build2222222222222222222222222222);
                    return;
                default:
                    throw new com.google.android.exoplayer2.ParserException("Unrecognized codec identifier.");
            }
        }

        public void f() {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker trueHdSampleRechunker = this.T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.a(this);
            }
        }

        public void j() {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker trueHdSampleRechunker = this.T;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.b();
            }
        }
    }

    public static final class TrueHdSampleRechunker {
        public final byte[] a = new byte[10];
        public boolean b;
        public int c;
        public long d;
        public int e;
        public int f;
        public int g;

        public void a(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track) {
            if (this.c > 0) {
                track.X.sampleMetadata(this.d, this.e, this.f, this.g, track.j);
                this.c = 0;
            }
        }

        public void b() {
            this.b = false;
            this.c = 0;
        }

        public void c(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, long j, int i, int i2, int i3) {
            if (this.b) {
                int i4 = this.c;
                int i5 = i4 + 1;
                this.c = i5;
                if (i4 == 0) {
                    this.d = j;
                    this.e = i;
                    this.f = 0;
                }
                this.f += i2;
                this.g = i3;
                if (i5 >= 16) {
                    a(track);
                }
            }
        }

        public void d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
            if (this.b) {
                return;
            }
            extractorInput.peekFully(this.a, 0, 10);
            extractorInput.resetPeekPosition();
            if (com.google.android.exoplayer2.audio.Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.a) == 0) {
                return;
            }
            this.b = true;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f0 = java.util.Collections.unmodifiableMap(hashMap);
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int i) {
        this(new com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader(), i);
    }

    public MatroskaExtractor(com.google.android.exoplayer2.extractor.mkv.EbmlReader ebmlReader, int i) {
        this.q = -1L;
        this.r = -9223372036854775807L;
        this.f348s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.a = ebmlReader;
        ebmlReader.a(new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.InnerEbmlProcessor(this, null));
        this.d = (i & 1) == 0;
        this.b = new com.google.android.exoplayer2.extractor.mkv.VarintReader();
        this.c = new android.util.SparseArray<>();
        this.g = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.h = new com.google.android.exoplayer2.util.ParsableByteArray(java.nio.ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.e = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
        this.f = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.j = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.k = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.l = new com.google.android.exoplayer2.util.ParsableByteArray(8);
        this.m = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.n = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.L = new int[1];
    }

    public static int[] g(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[java.lang.Math.max(iArr.length * 2, i)];
    }

    public static byte[] i(long j, java.lang.String str, long j2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - ((i * com.anythink.expressad.d.a.b.ck) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - ((i2 * 60) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return com.google.android.exoplayer2.util.Util.getUtf8Bytes(java.lang.String.format(java.util.Locale.US, str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    public static boolean j(java.lang.String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_AV1".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] k() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor()};
    }

    public static void p(java.lang.String str, long j, byte[] bArr) {
        byte[] i;
        int i2;
        str.hashCode();
        if (str.equals("S_TEXT/ASS")) {
            i = i(j, "%01d:%02d:%02d:%02d", 10000L);
            i2 = 21;
        } else {
            if (!str.equals("S_TEXT/UTF8")) {
                throw new java.lang.IllegalArgumentException();
            }
            i = i(j, "%02d:%02d:%02d,%03d", 1000L);
            i2 = 19;
        }
        java.lang.System.arraycopy(i, 0, bArr, i2, i.length);
    }

    @androidx.annotation.CallSuper
    public void binaryElement(int i, int i2, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        long j;
        int i3;
        int i4;
        int i5;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (this.G != 2) {
                    return;
                }
                handleBlockAdditionalData(this.c.get(this.M), this.P, extractorInput, i2);
                return;
            }
            if (i == 16877) {
                handleBlockAddIDExtraData(this.u, extractorInput, i2);
                return;
            }
            if (i == 16981) {
                byte[] bArr = new byte[i2];
                this.u.i = bArr;
                extractorInput.readFully(bArr, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr2 = new byte[i2];
                extractorInput.readFully(bArr2, 0, i2);
                this.u.j = new com.google.android.exoplayer2.extractor.TrackOutput.CryptoData(1, bArr2, 0, 0);
                return;
            }
            if (i == 21419) {
                java.util.Arrays.fill(this.i.getData(), (byte) 0);
                extractorInput.readFully(this.i.getData(), 4 - i2, i2);
                this.i.setPosition(0);
                this.w = (int) this.i.readUnsignedInt();
                return;
            }
            if (i == 25506) {
                byte[] bArr3 = new byte[i2];
                this.u.k = bArr3;
                extractorInput.readFully(bArr3, 0, i2);
                return;
            } else if (i == 30322) {
                byte[] bArr4 = new byte[i2];
                this.u.v = bArr4;
                extractorInput.readFully(bArr4, 0, i2);
                return;
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(26);
                sb.append("Unexpected id: ");
                sb.append(i);
                throw new com.google.android.exoplayer2.ParserException(sb.toString());
            }
        }
        int i6 = 8;
        if (this.G == 0) {
            this.M = (int) this.b.d(extractorInput, false, true, 8);
            this.N = this.b.b();
            this.I = -9223372036854775807L;
            this.G = 1;
            this.g.reset(0);
        }
        com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track = this.c.get(this.M);
        if (track == null) {
            extractorInput.skipFully(i2 - this.N);
            this.G = 0;
            return;
        }
        if (this.G == 1) {
            m(extractorInput, 3);
            int i7 = (this.g.getData()[2] & 6) >> 1;
            byte b = 255;
            if (i7 == 0) {
                this.K = 1;
                int[] g = g(this.L, 1);
                this.L = g;
                g[0] = (i2 - this.N) - 3;
            } else {
                int i8 = 4;
                m(extractorInput, 4);
                int i9 = (this.g.getData()[3] & 255) + 1;
                this.K = i9;
                int[] g2 = g(this.L, i9);
                this.L = g2;
                if (i7 == 2) {
                    int i10 = (i2 - this.N) - 4;
                    int i11 = this.K;
                    java.util.Arrays.fill(g2, 0, i11, i10 / i11);
                } else {
                    if (i7 != 1) {
                        if (i7 != 3) {
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(36);
                            sb2.append("Unexpected lacing value: ");
                            sb2.append(i7);
                            throw new com.google.android.exoplayer2.ParserException(sb2.toString());
                        }
                        int i12 = 0;
                        int i13 = 0;
                        while (true) {
                            int i14 = this.K;
                            if (i12 >= i14 - 1) {
                                this.L[i14 - 1] = ((i2 - this.N) - i8) - i13;
                                break;
                            }
                            this.L[i12] = 0;
                            i8++;
                            m(extractorInput, i8);
                            int i15 = i8 - 1;
                            if (this.g.getData()[i15] == 0) {
                                throw new com.google.android.exoplayer2.ParserException("No valid varint length mask found");
                            }
                            int i16 = 0;
                            while (true) {
                                if (i16 >= i6) {
                                    j = 0;
                                    break;
                                }
                                int i17 = 1 << (7 - i16);
                                if ((this.g.getData()[i15] & i17) != 0) {
                                    int i18 = i8 + i16;
                                    m(extractorInput, i18);
                                    j = (~i17) & this.g.getData()[i15] & b;
                                    int i19 = i15 + 1;
                                    while (i19 < i18) {
                                        j = (j << i6) | (this.g.getData()[i19] & b);
                                        i19++;
                                        i18 = i18;
                                        i6 = 8;
                                        b = 255;
                                    }
                                    int i20 = i18;
                                    if (i12 > 0) {
                                        j -= (1 << ((i16 * 7) + 6)) - 1;
                                    }
                                    i8 = i20;
                                } else {
                                    i16++;
                                    i6 = 8;
                                    b = 255;
                                }
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int i21 = (int) j;
                            int[] iArr = this.L;
                            if (i12 != 0) {
                                i21 += iArr[i12 - 1];
                            }
                            iArr[i12] = i21;
                            i13 += i21;
                            i12++;
                            i6 = 8;
                            b = 255;
                        }
                        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
                    }
                    int i22 = 0;
                    int i23 = 0;
                    while (true) {
                        i3 = this.K;
                        if (i22 >= i3 - 1) {
                            break;
                        }
                        this.L[i22] = 0;
                        do {
                            i8++;
                            m(extractorInput, i8);
                            i4 = this.g.getData()[i8 - 1] & 255;
                            int[] iArr2 = this.L;
                            i5 = iArr2[i22] + i4;
                            iArr2[i22] = i5;
                        } while (i4 == 255);
                        i23 += i5;
                        i22++;
                    }
                    this.L[i3 - 1] = ((i2 - this.N) - i8) - i23;
                }
            }
            this.H = this.B + o((this.g.getData()[0] << 8) | (this.g.getData()[1] & 255));
            this.O = (track.d == 2 || (i == 163 && (this.g.getData()[2] & 128) == 128)) ? 1 : 0;
            this.G = 2;
            this.J = 0;
        }
        if (i == 163) {
            while (true) {
                int i24 = this.J;
                if (i24 >= this.K) {
                    this.G = 0;
                    return;
                } else {
                    f(track, ((this.J * track.e) / 1000) + this.H, this.O, q(extractorInput, track, this.L[i24]), 0);
                    this.J++;
                }
            }
        } else {
            while (true) {
                int i25 = this.J;
                if (i25 >= this.K) {
                    return;
                }
                int[] iArr3 = this.L;
                iArr3[i25] = q(extractorInput, track, iArr3[i25]);
                this.J++;
            }
        }
    }

    public final com.google.android.exoplayer2.extractor.SeekMap e() {
        com.google.android.exoplayer2.util.LongArray longArray;
        com.google.android.exoplayer2.util.LongArray longArray2;
        int i;
        if (this.q == -1 || this.t == -9223372036854775807L || (longArray = this.C) == null || longArray.size() == 0 || (longArray2 = this.D) == null || longArray2.size() != this.C.size()) {
            this.C = null;
            this.D = null;
            return new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.t);
        }
        int size = this.C.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jArr3[i3] = this.C.get(i3);
            jArr[i3] = this.q + this.D.get(i3);
        }
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArr[i2] = (int) (jArr[i4] - jArr[i2]);
            jArr2[i2] = jArr3[i4] - jArr3[i2];
            i2 = i4;
        }
        iArr[i] = (int) ((this.q + this.p) - jArr[i]);
        long j = this.t - jArr3[i];
        jArr2[i] = j;
        if (j <= 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(72);
            sb.append("Discarding last cue point with unexpected duration: ");
            sb.append(j);
            com.google.android.exoplayer2.util.Log.w("MatroskaExtractor", sb.toString());
            iArr = java.util.Arrays.copyOf(iArr, i);
            jArr = java.util.Arrays.copyOf(jArr, i);
            jArr2 = java.util.Arrays.copyOf(jArr2, i);
            jArr3 = java.util.Arrays.copyOf(jArr3, i);
        }
        this.C = null;
        this.D = null;
        return new com.google.android.exoplayer2.extractor.ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    @androidx.annotation.CallSuper
    public void endMasterElement(int i) throws com.google.android.exoplayer2.ParserException {
        if (i == 160) {
            if (this.G != 2) {
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.K; i3++) {
                i2 += this.L[i3];
            }
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track = this.c.get(this.M);
            for (int i4 = 0; i4 < this.K; i4++) {
                long j = ((track.e * i4) / 1000) + this.H;
                int i5 = this.O;
                if (i4 == 0 && !this.Q) {
                    i5 |= 1;
                }
                int i6 = this.L[i4];
                i2 -= i6;
                f(track, j, i5, i6, i2);
            }
            this.G = 0;
            return;
        }
        if (i == 174) {
            if (j(this.u.b)) {
                com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track2 = this.u;
                track2.e(this.a0, track2.c);
                android.util.SparseArray<com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track> sparseArray = this.c;
                com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track3 = this.u;
                sparseArray.put(track3.c, track3);
            }
            this.u = null;
            return;
        }
        if (i == 19899) {
            int i7 = this.w;
            if (i7 != -1) {
                long j2 = this.x;
                if (j2 != -1) {
                    if (i7 == 475249515) {
                        this.z = j2;
                        return;
                    }
                    return;
                }
            }
            throw new com.google.android.exoplayer2.ParserException("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track4 = this.u;
            if (track4.h) {
                if (track4.j == null) {
                    throw new com.google.android.exoplayer2.ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
                track4.l = new com.google.android.exoplayer2.drm.DrmInitData(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(com.google.android.exoplayer2.C.UUID_NIL, "video/webm", this.u.j.encryptionKey));
                return;
            }
            return;
        }
        if (i == 28032) {
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track5 = this.u;
            if (track5.h && track5.i != null) {
                throw new com.google.android.exoplayer2.ParserException("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.r == -9223372036854775807L) {
                this.r = 1000000L;
            }
            long j3 = this.f348s;
            if (j3 != -9223372036854775807L) {
                this.t = o(j3);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.c.size() == 0) {
                throw new com.google.android.exoplayer2.ParserException("No valid tracks were found");
            }
            this.a0.endTracks();
        } else if (i == 475249515 && !this.v) {
            this.a0.seekMap(e());
            this.v = true;
        }
    }

    public final void f(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, long j, int i, int i2, int i3) {
        com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TrueHdSampleRechunker trueHdSampleRechunker = track.T;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.c(track, j, i, i2, i3);
        } else {
            if ("S_TEXT/UTF8".equals(track.b) || "S_TEXT/ASS".equals(track.b)) {
                if (this.K > 1) {
                    com.google.android.exoplayer2.util.Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.I;
                    if (j2 == -9223372036854775807L) {
                        com.google.android.exoplayer2.util.Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        p(track.b, j2, this.k.getData());
                        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = track.X;
                        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.k;
                        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                        i2 += this.k.limit();
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.K > 1) {
                    i &= -268435457;
                } else {
                    int limit = this.n.limit();
                    track.X.sampleData(this.n, limit, 2);
                    i2 += limit;
                }
            }
            track.X.sampleMetadata(j, i, i2, i3, track.j);
        }
        this.F = true;
    }

    @androidx.annotation.CallSuper
    public void floatElement(int i, double d) throws com.google.android.exoplayer2.ParserException {
        if (i == 181) {
            this.u.Q = (int) d;
        }
        if (i == 17545) {
            this.f348s = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                this.u.D = (float) d;
                break;
            case 21970:
                this.u.E = (float) d;
                break;
            case 21971:
                this.u.F = (float) d;
                break;
            case 21972:
                this.u.G = (float) d;
                break;
            case 21973:
                this.u.H = (float) d;
                break;
            case 21974:
                this.u.I = (float) d;
                break;
            case 21975:
                this.u.J = (float) d;
                break;
            case 21976:
                this.u.K = (float) d;
                break;
            case 21977:
                this.u.L = (float) d;
                break;
            case 21978:
                this.u.M = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        this.u.f349s = (float) d;
                        break;
                    case 30324:
                        this.u.t = (float) d;
                        break;
                    case 30325:
                        this.u.u = (float) d;
                        break;
                }
        }
    }

    @androidx.annotation.CallSuper
    public int getElementType(int i) {
        switch (i) {
            case 131:
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME /* 136 */:
            case org.apache.tools.tar.TarConstants.PREFIXLEN /* 155 */:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL /* 160 */:
            case com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE /* 166 */:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public final int h() {
        int i = this.S;
        n();
        return i;
    }

    public void handleBlockAddIDExtraData(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i) throws java.io.IOException {
        if (track.g != 1685485123 && track.g != 1685480259) {
            extractorInput.skipFully(i);
            return;
        }
        byte[] bArr = new byte[i];
        track.N = bArr;
        extractorInput.readFully(bArr, 0, i);
    }

    public void handleBlockAdditionalData(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, int i, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i2) throws java.io.IOException {
        if (i != 4 || !"V_VP9".equals(track.b)) {
            extractorInput.skipFully(i2);
        } else {
            this.n.reset(i2);
            extractorInput.readFully(this.n.getData(), 0, i2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.a0 = extractorOutput;
    }

    @androidx.annotation.CallSuper
    public void integerElement(int i, long j) throws com.google.android.exoplayer2.ParserException {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw new com.google.android.exoplayer2.ParserException(sb2.toString());
        }
        switch (i) {
            case 131:
                this.u.d = (int) j;
                return;
            case com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME /* 136 */:
                this.u.V = j == 1;
                return;
            case org.apache.tools.tar.TarConstants.PREFIXLEN /* 155 */:
                this.I = o(j);
                return;
            case 159:
                this.u.O = (int) j;
                return;
            case 176:
                this.u.m = (int) j;
                return;
            case 179:
                this.C.add(o(j));
                return;
            case 186:
                this.u.n = (int) j;
                return;
            case 215:
                this.u.c = (int) j;
                return;
            case 231:
                this.B = o(j);
                return;
            case 238:
                this.P = (int) j;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                this.D.add(j);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                this.u.g = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(50);
                sb3.append("ContentCompAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw new com.google.android.exoplayer2.ParserException(sb3.toString());
            case 17029:
                if (j < 1 || j > 2) {
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder(53);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new com.google.android.exoplayer2.ParserException(sb4.toString());
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder(50);
                sb5.append("EBMLReadVersion ");
                sb5.append(j);
                sb5.append(" not supported");
                throw new com.google.android.exoplayer2.ParserException(sb5.toString());
            case 18401:
                if (j == 5) {
                    return;
                }
                java.lang.StringBuilder sb6 = new java.lang.StringBuilder(49);
                sb6.append("ContentEncAlgo ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new com.google.android.exoplayer2.ParserException(sb6.toString());
            case 18408:
                if (j == 1) {
                    return;
                }
                java.lang.StringBuilder sb7 = new java.lang.StringBuilder(56);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j);
                sb7.append(" not supported");
                throw new com.google.android.exoplayer2.ParserException(sb7.toString());
            case 21420:
                this.x = j + this.q;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 0) {
                    this.u.w = 0;
                    return;
                }
                if (i2 == 1) {
                    this.u.w = 2;
                    return;
                } else if (i2 == 3) {
                    this.u.w = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.u.w = 3;
                    return;
                }
            case 21680:
                this.u.o = (int) j;
                return;
            case 21682:
                this.u.q = (int) j;
                return;
            case 21690:
                this.u.p = (int) j;
                return;
            case 21930:
                this.u.U = j == 1;
                return;
            case 21998:
                this.u.f = (int) j;
                return;
            case 22186:
                this.u.R = j;
                return;
            case 22203:
                this.u.S = j;
                return;
            case 25188:
                this.u.P = (int) j;
                return;
            case 30321:
                int i3 = (int) j;
                if (i3 == 0) {
                    this.u.r = 0;
                    return;
                }
                if (i3 == 1) {
                    this.u.r = 1;
                    return;
                } else if (i3 == 2) {
                    this.u.r = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.u.r = 3;
                    return;
                }
            case 2352003:
                this.u.e = (int) j;
                return;
            case 2807729:
                this.r = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.u.A = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.u.A = 1;
                            return;
                        }
                    case 21946:
                        int i5 = (int) j;
                        if (i5 != 1) {
                            if (i5 == 16) {
                                this.u.z = 6;
                                return;
                            } else if (i5 == 18) {
                                this.u.z = 7;
                                return;
                            } else if (i5 != 6 && i5 != 7) {
                                return;
                            }
                        }
                        this.u.z = 3;
                        return;
                    case 21947:
                        com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track = this.u;
                        track.x = true;
                        int i6 = (int) j;
                        if (i6 == 1) {
                            track.y = 1;
                            return;
                        }
                        if (i6 == 9) {
                            track.y = 6;
                            return;
                        } else {
                            if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                track.y = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.u.B = (int) j;
                        return;
                    case 21949:
                        this.u.C = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    @androidx.annotation.CallSuper
    public boolean isLevel1Element(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public final boolean l(com.google.android.exoplayer2.extractor.PositionHolder positionHolder, long j) {
        if (this.y) {
            this.A = j;
            positionHolder.position = this.z;
            this.y = false;
            return true;
        }
        if (this.v) {
            long j2 = this.A;
            if (j2 != -1) {
                positionHolder.position = j2;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    public final void m(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i) throws java.io.IOException {
        if (this.g.limit() >= i) {
            return;
        }
        if (this.g.capacity() < i) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.g;
            parsableByteArray.reset(java.util.Arrays.copyOf(parsableByteArray.getData(), java.lang.Math.max(this.g.getData().length * 2, i)), this.g.limit());
        }
        extractorInput.readFully(this.g.getData(), this.g.limit(), i - this.g.limit());
        this.g.setLimit(i);
    }

    public final void n() {
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = 0;
        this.Y = (byte) 0;
        this.Z = false;
        this.j.reset(0);
    }

    public final long o(long j) throws com.google.android.exoplayer2.ParserException {
        long j2 = this.r;
        if (j2 != -9223372036854775807L) {
            return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j, j2, 1000L);
        }
        throw new com.google.android.exoplayer2.ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    public final int q(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track track, int i) throws java.io.IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(track.b)) {
            r(extractorInput, b0, i);
            return h();
        }
        if ("S_TEXT/ASS".equals(track.b)) {
            r(extractorInput, d0, i);
            return h();
        }
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = track.X;
        if (!this.U) {
            if (track.h) {
                this.O &= -1073741825;
                if (!this.V) {
                    extractorInput.readFully(this.g.getData(), 0, 1);
                    this.R++;
                    if ((this.g.getData()[0] & 128) == 128) {
                        throw new com.google.android.exoplayer2.ParserException("Extension bit is set in signal byte");
                    }
                    this.Y = this.g.getData()[0];
                    this.V = true;
                }
                byte b = this.Y;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.Z) {
                        extractorInput.readFully(this.l.getData(), 0, 8);
                        this.R += 8;
                        this.Z = true;
                        this.g.getData()[0] = (byte) ((z ? 128 : 0) | 8);
                        this.g.setPosition(0);
                        trackOutput.sampleData(this.g, 1, 1);
                        this.S++;
                        this.l.setPosition(0);
                        trackOutput.sampleData(this.l, 8, 1);
                        this.S += 8;
                    }
                    if (z) {
                        if (!this.W) {
                            extractorInput.readFully(this.g.getData(), 0, 1);
                            this.R++;
                            this.g.setPosition(0);
                            this.X = this.g.readUnsignedByte();
                            this.W = true;
                        }
                        int i3 = this.X * 4;
                        this.g.reset(i3);
                        extractorInput.readFully(this.g.getData(), 0, i3);
                        this.R += i3;
                        short s2 = (short) ((this.X / 2) + 1);
                        int i4 = (s2 * 6) + 2;
                        java.nio.ByteBuffer byteBuffer = this.o;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.o = java.nio.ByteBuffer.allocate(i4);
                        }
                        this.o.position(0);
                        this.o.putShort(s2);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.X;
                            if (i5 >= i2) {
                                break;
                            }
                            int readUnsignedIntToInt = this.g.readUnsignedIntToInt();
                            if (i5 % 2 == 0) {
                                this.o.putShort((short) (readUnsignedIntToInt - i6));
                            } else {
                                this.o.putInt(readUnsignedIntToInt - i6);
                            }
                            i5++;
                            i6 = readUnsignedIntToInt;
                        }
                        int i7 = (i - this.R) - i6;
                        if (i2 % 2 == 1) {
                            this.o.putInt(i7);
                        } else {
                            this.o.putShort((short) i7);
                            this.o.putInt(0);
                        }
                        this.m.reset(this.o.array(), i4);
                        trackOutput.sampleData(this.m, i4, 1);
                        this.S += i4;
                    }
                }
            } else {
                byte[] bArr = track.i;
                if (bArr != null) {
                    this.j.reset(bArr, bArr.length);
                }
            }
            if (track.f > 0) {
                this.O |= 268435456;
                this.n.reset(0);
                this.g.reset(4);
                this.g.getData()[0] = (byte) ((i >> 24) & 255);
                this.g.getData()[1] = (byte) ((i >> 16) & 255);
                this.g.getData()[2] = (byte) ((i >> 8) & 255);
                this.g.getData()[3] = (byte) (i & 255);
                trackOutput.sampleData(this.g, 4, 2);
                this.S += 4;
            }
            this.U = true;
        }
        int limit = i + this.j.limit();
        if (!"V_MPEG4/ISO/AVC".equals(track.b) && !"V_MPEGH/ISO/HEVC".equals(track.b)) {
            if (track.T != null) {
                com.google.android.exoplayer2.util.Assertions.checkState(this.j.limit() == 0);
                track.T.d(extractorInput);
            }
            while (true) {
                int i8 = this.R;
                if (i8 >= limit) {
                    break;
                }
                int s3 = s(extractorInput, trackOutput, limit - i8);
                this.R += s3;
                this.S += s3;
            }
        } else {
            byte[] data = this.f.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i9 = track.Y;
            int i10 = 4 - i9;
            while (this.R < limit) {
                int i11 = this.T;
                if (i11 == 0) {
                    t(extractorInput, data, i10, i9);
                    this.R += i9;
                    this.f.setPosition(0);
                    this.T = this.f.readUnsignedIntToInt();
                    this.e.setPosition(0);
                    trackOutput.sampleData(this.e, 4);
                    this.S += 4;
                } else {
                    int s4 = s(extractorInput, trackOutput, i11);
                    this.R += s4;
                    this.S += s4;
                    this.T -= s4;
                }
            }
        }
        if ("A_VORBIS".equals(track.b)) {
            this.h.setPosition(0);
            trackOutput.sampleData(this.h, 4);
            this.S += 4;
        }
        return h();
    }

    public final void r(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, byte[] bArr, int i) throws java.io.IOException {
        int length = bArr.length + i;
        if (this.k.capacity() < length) {
            this.k.reset(java.util.Arrays.copyOf(bArr, length + i));
        } else {
            java.lang.System.arraycopy(bArr, 0, this.k.getData(), 0, bArr.length);
        }
        extractorInput.readFully(this.k.getData(), bArr.length, i);
        this.k.reset(length);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        this.F = false;
        boolean z = true;
        while (z && !this.F) {
            z = this.a.read(extractorInput);
            if (z && l(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.c.size(); i++) {
            this.c.valueAt(i).f();
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void release() {
    }

    public final int s(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.TrackOutput trackOutput, int i) throws java.io.IOException {
        int bytesLeft = this.j.bytesLeft();
        if (bytesLeft <= 0) {
            return trackOutput.sampleData((com.google.android.exoplayer2.upstream.DataReader) extractorInput, i, false);
        }
        int min = java.lang.Math.min(i, bytesLeft);
        trackOutput.sampleData(this.j, min);
        return min;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    @androidx.annotation.CallSuper
    public void seek(long j, long j2) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.a.reset();
        this.b.e();
        n();
        for (int i = 0; i < this.c.size(); i++) {
            this.c.valueAt(i).j();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return new com.google.android.exoplayer2.extractor.mkv.Sniffer().b(extractorInput);
    }

    @androidx.annotation.CallSuper
    public void startMasterElement(int i, long j, long j2) throws com.google.android.exoplayer2.ParserException {
        if (i == 160) {
            this.Q = false;
            return;
        }
        if (i == 174) {
            this.u = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track(null);
            return;
        }
        if (i == 187) {
            this.E = false;
            return;
        }
        if (i == 19899) {
            this.w = -1;
            this.x = -1L;
            return;
        }
        if (i == 20533) {
            this.u.h = true;
            return;
        }
        if (i == 21968) {
            this.u.x = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.q;
            if (j3 != -1 && j3 != j) {
                throw new com.google.android.exoplayer2.ParserException("Multiple Segment elements not supported");
            }
            this.q = j;
            this.p = j2;
            return;
        }
        if (i == 475249515) {
            this.C = new com.google.android.exoplayer2.util.LongArray();
            this.D = new com.google.android.exoplayer2.util.LongArray();
        } else if (i == 524531317 && !this.v) {
            if (this.d && this.z != -1) {
                this.y = true;
            } else {
                this.a0.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.t));
                this.v = true;
            }
        }
    }

    @androidx.annotation.CallSuper
    public void stringElement(int i, java.lang.String str) throws com.google.android.exoplayer2.ParserException {
        if (i == 134) {
            this.u.b = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                this.u.a = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                this.u.W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 22);
        sb.append("DocType ");
        sb.append(str);
        sb.append(" not supported");
        throw new com.google.android.exoplayer2.ParserException(sb.toString());
    }

    public final void t(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws java.io.IOException {
        int min = java.lang.Math.min(i2, this.j.bytesLeft());
        extractorInput.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.j.readBytes(bArr, i, min);
        }
    }
}
