package com.google.android.exoplayer2.extractor.amr;

/* loaded from: classes22.dex */
public final class AmrExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int[] q;
    public static final int t;
    public final byte[] a;
    public final int b;
    public boolean c;
    public long d;
    public int e;
    public int f;
    public boolean g;
    public long h;
    public int i;
    public int j;
    public long k;
    public com.google.android.exoplayer2.extractor.ExtractorOutput l;
    public com.google.android.exoplayer2.extractor.TrackOutput m;
    public com.google.android.exoplayer2.extractor.SeekMap n;
    public boolean o;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.e9();
    public static final int[] p = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final byte[] r = com.google.android.exoplayer2.util.Util.getUtf8Bytes("#!AMR\n");

    /* renamed from: s, reason: collision with root package name */
    public static final byte[] f347s = com.google.android.exoplayer2.util.Util.getUtf8Bytes("#!AMR-WB\n");

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        q = iArr;
        t = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    public AmrExtractor(int i) {
        this.b = i;
        this.a = new byte[1];
        this.i = -1;
    }

    public static int c(int i, long j) {
        return (int) (((i * 8) * 1000000) / j);
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] i() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.amr.AmrExtractor()};
    }

    public static boolean l(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, byte[] bArr) throws java.io.IOException {
        extractorInput.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.peekFully(bArr2, 0, bArr.length);
        return java.util.Arrays.equals(bArr2, bArr);
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"extractorOutput", "trackOutput"})
    public final void b() {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.m);
        com.google.android.exoplayer2.util.Util.castNonNull(this.l);
    }

    public final com.google.android.exoplayer2.extractor.SeekMap d(long j) {
        return new com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap(j, this.h, c(this.i, com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US), this.i);
    }

    public final int e(int i) throws com.google.android.exoplayer2.ParserException {
        if (g(i)) {
            return this.c ? q[i] : p[i];
        }
        java.lang.String str = this.c ? "WB" : "NB";
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 35);
        sb.append("Illegal AMR ");
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i);
        throw new com.google.android.exoplayer2.ParserException(sb.toString());
    }

    public final boolean f(int i) {
        return !this.c && (i < 12 || i > 14);
    }

    public final boolean g(int i) {
        return i >= 0 && i <= 15 && (h(i) || f(i));
    }

    public final boolean h(int i) {
        return this.c && (i < 10 || i > 13);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.l = extractorOutput;
        this.m = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput"})
    public final void j() {
        if (this.o) {
            return;
        }
        this.o = true;
        boolean z = this.c;
        this.m.format(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType(z ? "audio/amr-wb" : "audio/3gpp").setMaxInputSize(t).setChannelCount(1).setSampleRate(z ? com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND : 8000).build());
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    public final void k(long j, int i) {
        int i2;
        if (this.g) {
            return;
        }
        if ((this.b & 1) == 0 || j == -1 || !((i2 = this.i) == -1 || i2 == this.e)) {
            com.google.android.exoplayer2.extractor.SeekMap.Unseekable unseekable = new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L);
            this.n = unseekable;
            this.l.seekMap(unseekable);
            this.g = true;
            return;
        }
        if (this.j >= 20 || i == -1) {
            com.google.android.exoplayer2.extractor.SeekMap d = d(j);
            this.n = d;
            this.l.seekMap(d);
            this.g = true;
        }
    }

    public final int m(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.a, 0, 1);
        byte b = this.a[0];
        if ((b & 131) <= 0) {
            return e((b >> 3) & 15);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(42);
        sb.append("Invalid padding bits for frame header ");
        sb.append((int) b);
        throw new com.google.android.exoplayer2.ParserException(sb.toString());
    }

    public final boolean n(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        byte[] bArr = r;
        if (l(extractorInput, bArr)) {
            this.c = false;
            extractorInput.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = f347s;
        if (!l(extractorInput, bArr2)) {
            return false;
        }
        this.c = true;
        extractorInput.skipFully(bArr2.length);
        return true;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput"})
    public final int o(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (this.f == 0) {
            try {
                int m = m(extractorInput);
                this.e = m;
                this.f = m;
                if (this.i == -1) {
                    this.h = extractorInput.getPosition();
                    this.i = this.e;
                }
                if (this.i == this.e) {
                    this.j++;
                }
            } catch (java.io.EOFException unused) {
                return -1;
            }
        }
        int sampleData = this.m.sampleData((com.google.android.exoplayer2.upstream.DataReader) extractorInput, this.f, true);
        if (sampleData == -1) {
            return -1;
        }
        int i = this.f - sampleData;
        this.f = i;
        if (i > 0) {
            return 0;
        }
        this.m.sampleMetadata(this.k + this.d, 1, this.e, 0, null);
        this.d += com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        b();
        if (extractorInput.getPosition() == 0 && !n(extractorInput)) {
            throw new com.google.android.exoplayer2.ParserException("Could not find AMR header.");
        }
        j();
        int o = o(extractorInput);
        k(extractorInput.getLength(), o);
        return o;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.d = 0L;
        this.e = 0;
        this.f = 0;
        if (j != 0) {
            com.google.android.exoplayer2.extractor.SeekMap seekMap = this.n;
            if (seekMap instanceof com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap) {
                this.k = ((com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap) seekMap).getTimeUsAtPosition(j);
                return;
            }
        }
        this.k = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return n(extractorInput);
    }
}
