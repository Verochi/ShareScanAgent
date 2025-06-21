package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class PsExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int AUDIO_STREAM = 192;
    public static final int AUDIO_STREAM_MASK = 224;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.e62();
    public static final int PRIVATE_STREAM_1 = 189;
    public static final int VIDEO_STREAM = 224;
    public static final int VIDEO_STREAM_MASK = 240;
    public final com.google.android.exoplayer2.util.TimestampAdjuster a;
    public final android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.PsExtractor.PesReader> b;
    public final com.google.android.exoplayer2.util.ParsableByteArray c;
    public final com.google.android.exoplayer2.extractor.ts.PsDurationReader d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker i;
    public com.google.android.exoplayer2.extractor.ExtractorOutput j;
    public boolean k;

    public static final class PesReader {
        public final com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader a;
        public final com.google.android.exoplayer2.util.TimestampAdjuster b;
        public final com.google.android.exoplayer2.util.ParsableBitArray c = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[64]);
        public boolean d;
        public boolean e;
        public boolean f;
        public int g;
        public long h;

        public PesReader(com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader elementaryStreamReader, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
            this.a = elementaryStreamReader;
            this.b = timestampAdjuster;
        }

        public void a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
            parsableByteArray.readBytes(this.c.data, 0, 3);
            this.c.setPosition(0);
            b();
            parsableByteArray.readBytes(this.c.data, 0, this.g);
            this.c.setPosition(0);
            c();
            this.a.packetStarted(this.h, 4);
            this.a.consume(parsableByteArray);
            this.a.packetFinished();
        }

        public final void b() {
            this.c.skipBits(8);
            this.d = this.c.readBit();
            this.e = this.c.readBit();
            this.c.skipBits(6);
            this.g = this.c.readBits(8);
        }

        public final void c() {
            this.h = 0L;
            if (this.d) {
                this.c.skipBits(4);
                this.c.skipBits(1);
                this.c.skipBits(1);
                long readBits = (this.c.readBits(3) << 30) | (this.c.readBits(15) << 15) | this.c.readBits(15);
                this.c.skipBits(1);
                if (!this.f && this.e) {
                    this.c.skipBits(4);
                    this.c.skipBits(1);
                    this.c.skipBits(1);
                    this.c.skipBits(1);
                    this.b.adjustTsTimestamp((this.c.readBits(3) << 30) | (this.c.readBits(15) << 15) | this.c.readBits(15));
                    this.f = true;
                }
                this.h = this.b.adjustTsTimestamp(readBits);
            }
        }

        public void d() {
            this.f = false;
            this.a.seek();
        }
    }

    public PsExtractor() {
        this(new com.google.android.exoplayer2.util.TimestampAdjuster(0L));
    }

    public PsExtractor(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        this.a = timestampAdjuster;
        this.c = new com.google.android.exoplayer2.util.ParsableByteArray(4096);
        this.b = new android.util.SparseArray<>();
        this.d = new com.google.android.exoplayer2.extractor.ts.PsDurationReader();
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] b() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ts.PsExtractor()};
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void c(long j) {
        if (this.k) {
            return;
        }
        this.k = true;
        if (this.d.c() == -9223372036854775807L) {
            this.j.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.d.c()));
            return;
        }
        com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker psBinarySearchSeeker = new com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker(this.d.d(), this.d.c(), j);
        this.i = psBinarySearchSeeker;
        this.j.seekMap(psBinarySearchSeeker.getSeekMap());
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.j = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader elementaryStreamReader;
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.j);
        long length = extractorInput.getLength();
        if ((length != -1) && !this.d.e()) {
            return this.d.g(extractorInput, positionHolder);
        }
        c(length);
        com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker psBinarySearchSeeker = this.i;
        if (psBinarySearchSeeker != null && psBinarySearchSeeker.isSeeking()) {
            return this.i.handlePendingSeek(extractorInput, positionHolder);
        }
        extractorInput.resetPeekPosition();
        long peekPosition = length != -1 ? length - extractorInput.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !extractorInput.peekFully(this.c.getData(), 0, 4, true)) {
            return -1;
        }
        this.c.setPosition(0);
        int readInt = this.c.readInt();
        if (readInt == 441) {
            return -1;
        }
        if (readInt == 442) {
            extractorInput.peekFully(this.c.getData(), 0, 10);
            this.c.setPosition(9);
            extractorInput.skipFully((this.c.readUnsignedByte() & 7) + 14);
            return 0;
        }
        if (readInt == 443) {
            extractorInput.peekFully(this.c.getData(), 0, 2);
            this.c.setPosition(0);
            extractorInput.skipFully(this.c.readUnsignedShort() + 6);
            return 0;
        }
        if (((readInt & androidx.core.view.InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            extractorInput.skipFully(1);
            return 0;
        }
        int i = readInt & 255;
        com.google.android.exoplayer2.extractor.ts.PsExtractor.PesReader pesReader = this.b.get(i);
        if (!this.e) {
            if (pesReader == null) {
                if (i == 189) {
                    elementaryStreamReader = new com.google.android.exoplayer2.extractor.ts.Ac3Reader();
                    this.f = true;
                    this.h = extractorInput.getPosition();
                } else if ((i & 224) == 192) {
                    elementaryStreamReader = new com.google.android.exoplayer2.extractor.ts.MpegAudioReader();
                    this.f = true;
                    this.h = extractorInput.getPosition();
                } else if ((i & 240) == 224) {
                    elementaryStreamReader = new com.google.android.exoplayer2.extractor.ts.H262Reader();
                    this.g = true;
                    this.h = extractorInput.getPosition();
                } else {
                    elementaryStreamReader = null;
                }
                if (elementaryStreamReader != null) {
                    elementaryStreamReader.createTracks(this.j, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(i, 256));
                    pesReader = new com.google.android.exoplayer2.extractor.ts.PsExtractor.PesReader(elementaryStreamReader, this.a);
                    this.b.put(i, pesReader);
                }
            }
            if (extractorInput.getPosition() > ((this.f && this.g) ? this.h + 8192 : 1048576L)) {
                this.e = true;
                this.j.endTracks();
            }
        }
        extractorInput.peekFully(this.c.getData(), 0, 2);
        this.c.setPosition(0);
        int readUnsignedShort = this.c.readUnsignedShort() + 6;
        if (pesReader == null) {
            extractorInput.skipFully(readUnsignedShort);
        } else {
            this.c.reset(readUnsignedShort);
            extractorInput.readFully(this.c.getData(), 0, readUnsignedShort);
            this.c.setPosition(6);
            pesReader.a(this.c);
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.c;
            parsableByteArray.setLimit(parsableByteArray.capacity());
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        if ((this.a.getTimestampOffsetUs() == -9223372036854775807L) || (this.a.getFirstSampleTimestampUs() != 0 && this.a.getFirstSampleTimestampUs() != j2)) {
            this.a.reset();
            this.a.setFirstSampleTimestampUs(j2);
        }
        com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker psBinarySearchSeeker = this.i;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.setSeekTargetUs(j2);
        }
        for (int i = 0; i < this.b.size(); i++) {
            this.b.valueAt(i).d();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        byte[] bArr = new byte[14];
        extractorInput.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.advancePeekPosition(bArr[13] & 7);
        extractorInput.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }
}
