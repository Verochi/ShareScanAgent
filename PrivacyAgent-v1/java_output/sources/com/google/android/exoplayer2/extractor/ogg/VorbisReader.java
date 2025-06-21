package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
final class VorbisReader extends com.google.android.exoplayer2.extractor.ogg.StreamReader {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup n;
    public int o;
    public boolean p;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.VorbisUtil.VorbisIdHeader q;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.VorbisUtil.CommentHeader r;

    public static final class VorbisSetup {
        public final com.google.android.exoplayer2.extractor.VorbisUtil.VorbisIdHeader a;
        public final com.google.android.exoplayer2.extractor.VorbisUtil.CommentHeader b;
        public final byte[] c;
        public final com.google.android.exoplayer2.extractor.VorbisUtil.Mode[] d;
        public final int e;

        public VorbisSetup(com.google.android.exoplayer2.extractor.VorbisUtil.VorbisIdHeader vorbisIdHeader, com.google.android.exoplayer2.extractor.VorbisUtil.CommentHeader commentHeader, byte[] bArr, com.google.android.exoplayer2.extractor.VorbisUtil.Mode[] modeArr, int i) {
            this.a = vorbisIdHeader;
            this.b = commentHeader;
            this.c = bArr;
            this.d = modeArr;
            this.e = i;
        }
    }

    @androidx.annotation.VisibleForTesting
    public static void l(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j) {
        if (parsableByteArray.capacity() < parsableByteArray.limit() + 4) {
            parsableByteArray.reset(java.util.Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit() + 4));
        } else {
            parsableByteArray.setLimit(parsableByteArray.limit() + 4);
        }
        byte[] data = parsableByteArray.getData();
        data[parsableByteArray.limit() - 4] = (byte) (j & 255);
        data[parsableByteArray.limit() - 3] = (byte) ((j >>> 8) & 255);
        data[parsableByteArray.limit() - 2] = (byte) ((j >>> 16) & 255);
        data[parsableByteArray.limit() - 1] = (byte) ((j >>> 24) & 255);
    }

    public static int m(byte b, com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup vorbisSetup) {
        return !vorbisSetup.d[n(b, vorbisSetup.e, 1)].blockFlag ? vorbisSetup.a.blockSize0 : vorbisSetup.a.blockSize1;
    }

    @androidx.annotation.VisibleForTesting
    public static int n(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    public static boolean p(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        try {
            return com.google.android.exoplayer2.extractor.VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
        } catch (com.google.android.exoplayer2.ParserException unused) {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void d(long j) {
        super.d(j);
        this.p = j != 0;
        com.google.android.exoplayer2.extractor.VorbisUtil.VorbisIdHeader vorbisIdHeader = this.q;
        this.o = vorbisIdHeader != null ? vorbisIdHeader.blockSize0 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if ((parsableByteArray.getData()[0] & 1) == 1) {
            return -1L;
        }
        int m = m(parsableByteArray.getData()[0], this.n);
        long j = this.p ? (this.o + m) / 4 : 0;
        l(parsableByteArray, j);
        this.p = true;
        this.o = m;
        return j;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j, com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData) throws java.io.IOException {
        if (this.n != null) {
            return false;
        }
        com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup o = o(parsableByteArray);
        this.n = o;
        if (o == null) {
            return true;
        }
        com.google.android.exoplayer2.extractor.VorbisUtil.VorbisIdHeader vorbisIdHeader = o.a;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(vorbisIdHeader.data);
        arrayList.add(this.n.c);
        setupData.a = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/vorbis").setAverageBitrate(vorbisIdHeader.bitrateNominal).setPeakBitrate(vorbisIdHeader.bitrateMaximum).setChannelCount(vorbisIdHeader.channels).setSampleRate(vorbisIdHeader.sampleRate).setInitializationData(arrayList).build();
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void j(boolean z) {
        super.j(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    public com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup o(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws java.io.IOException {
        if (this.q == null) {
            this.q = com.google.android.exoplayer2.extractor.VorbisUtil.readVorbisIdentificationHeader(parsableByteArray);
            return null;
        }
        if (this.r == null) {
            this.r = com.google.android.exoplayer2.extractor.VorbisUtil.readVorbisCommentHeader(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.limit()];
        java.lang.System.arraycopy(parsableByteArray.getData(), 0, bArr, 0, parsableByteArray.limit());
        return new com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup(this.q, this.r, bArr, com.google.android.exoplayer2.extractor.VorbisUtil.readVorbisModes(parsableByteArray, this.q.channels), com.google.android.exoplayer2.extractor.VorbisUtil.iLog(r5.length - 1));
    }
}
