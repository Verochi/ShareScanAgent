package com.google.android.exoplayer2.extractor.flac;

/* loaded from: classes22.dex */
public final class FlacExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.cf0();
    public static final int FLAG_DISABLE_ID3_METADATA = 1;
    public final byte[] a;
    public final com.google.android.exoplayer2.util.ParsableByteArray b;
    public final boolean c;
    public final com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder d;
    public com.google.android.exoplayer2.extractor.ExtractorOutput e;
    public com.google.android.exoplayer2.extractor.TrackOutput f;
    public int g;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.Metadata h;
    public com.google.android.exoplayer2.extractor.FlacStreamMetadata i;
    public int j;
    public int k;
    public com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker l;
    public int m;
    public long n;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public FlacExtractor() {
        this(0);
    }

    public FlacExtractor(int i) {
        this.a = new byte[42];
        this.b = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[32768], 0);
        this.c = (i & 1) != 0;
        this.d = new com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder();
        this.g = 0;
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] f() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.flac.FlacExtractor()};
    }

    public final long b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, boolean z) {
        boolean z2;
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.i);
        int position = parsableByteArray.getPosition();
        while (position <= parsableByteArray.limit() - 16) {
            parsableByteArray.setPosition(position);
            if (com.google.android.exoplayer2.extractor.FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, this.i, this.k, this.d)) {
                parsableByteArray.setPosition(position);
                return this.d.sampleNumber;
            }
            position++;
        }
        if (!z) {
            parsableByteArray.setPosition(position);
            return -1L;
        }
        while (position <= parsableByteArray.limit() - this.j) {
            parsableByteArray.setPosition(position);
            try {
                z2 = com.google.android.exoplayer2.extractor.FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, this.i, this.k, this.d);
            } catch (java.lang.IndexOutOfBoundsException unused) {
                z2 = false;
            }
            if (parsableByteArray.getPosition() <= parsableByteArray.limit() ? z2 : false) {
                parsableByteArray.setPosition(position);
                return this.d.sampleNumber;
            }
            position++;
        }
        parsableByteArray.setPosition(parsableByteArray.limit());
        return -1L;
    }

    public final void c(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        this.k = com.google.android.exoplayer2.extractor.FlacMetadataReader.getFrameStartMarker(extractorInput);
        ((com.google.android.exoplayer2.extractor.ExtractorOutput) com.google.android.exoplayer2.util.Util.castNonNull(this.e)).seekMap(d(extractorInput.getPosition(), extractorInput.getLength()));
        this.g = 5;
    }

    public final com.google.android.exoplayer2.extractor.SeekMap d(long j, long j2) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.i);
        com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata = this.i;
        if (flacStreamMetadata.seekTable != null) {
            return new com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap(flacStreamMetadata, j);
        }
        if (j2 == -1 || flacStreamMetadata.totalSamples <= 0) {
            return new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(flacStreamMetadata.getDurationUs());
        }
        com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker flacBinarySearchSeeker = new com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker(flacStreamMetadata, this.k, j, j2);
        this.l = flacBinarySearchSeeker;
        return flacBinarySearchSeeker.getSeekMap();
    }

    public final void e(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        byte[] bArr = this.a;
        extractorInput.peekFully(bArr, 0, bArr.length);
        extractorInput.resetPeekPosition();
        this.g = 2;
    }

    public final void g() {
        ((com.google.android.exoplayer2.extractor.TrackOutput) com.google.android.exoplayer2.util.Util.castNonNull(this.f)).sampleMetadata((this.n * 1000000) / ((com.google.android.exoplayer2.extractor.FlacStreamMetadata) com.google.android.exoplayer2.util.Util.castNonNull(this.i)).sampleRate, 1, this.m, 0, null);
    }

    public final int h(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        boolean z;
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.i);
        com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker flacBinarySearchSeeker = this.l;
        if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.isSeeking()) {
            return this.l.handlePendingSeek(extractorInput, positionHolder);
        }
        if (this.n == -1) {
            this.n = com.google.android.exoplayer2.extractor.FlacFrameReader.getFirstSampleNumber(extractorInput, this.i);
            return 0;
        }
        int limit = this.b.limit();
        if (limit < 32768) {
            int read = extractorInput.read(this.b.getData(), limit, 32768 - limit);
            z = read == -1;
            if (!z) {
                this.b.setLimit(limit + read);
            } else if (this.b.bytesLeft() == 0) {
                g();
                return -1;
            }
        } else {
            z = false;
        }
        int position = this.b.getPosition();
        int i = this.m;
        int i2 = this.j;
        if (i < i2) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.b;
            parsableByteArray.skipBytes(java.lang.Math.min(i2 - i, parsableByteArray.bytesLeft()));
        }
        long b = b(this.b, z);
        int position2 = this.b.getPosition() - position;
        this.b.setPosition(position);
        this.f.sampleData(this.b, position2);
        this.m += position2;
        if (b != -1) {
            g();
            this.m = 0;
            this.n = b;
        }
        if (this.b.bytesLeft() < 16) {
            java.lang.System.arraycopy(this.b.getData(), this.b.getPosition(), this.b.getData(), 0, this.b.bytesLeft());
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = this.b;
            parsableByteArray2.reset(parsableByteArray2.bytesLeft());
        }
        return 0;
    }

    public final void i(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        this.h = com.google.android.exoplayer2.extractor.FlacMetadataReader.readId3Metadata(extractorInput, !this.c);
        this.g = 1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.e = extractorOutput;
        this.f = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    public final void j(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new com.google.android.exoplayer2.extractor.FlacMetadataReader.FlacStreamMetadataHolder(this.i);
        boolean z = false;
        while (!z) {
            z = com.google.android.exoplayer2.extractor.FlacMetadataReader.readMetadataBlock(extractorInput, flacStreamMetadataHolder);
            this.i = (com.google.android.exoplayer2.extractor.FlacStreamMetadata) com.google.android.exoplayer2.util.Util.castNonNull(flacStreamMetadataHolder.flacStreamMetadata);
        }
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.i);
        this.j = java.lang.Math.max(this.i.minFrameSize, 6);
        ((com.google.android.exoplayer2.extractor.TrackOutput) com.google.android.exoplayer2.util.Util.castNonNull(this.f)).format(this.i.getFormat(this.a, this.h));
        this.g = 4;
    }

    public final void k(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.FlacMetadataReader.readStreamMarker(extractorInput);
        this.g = 3;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        int i = this.g;
        if (i == 0) {
            i(extractorInput);
            return 0;
        }
        if (i == 1) {
            e(extractorInput);
            return 0;
        }
        if (i == 2) {
            k(extractorInput);
            return 0;
        }
        if (i == 3) {
            j(extractorInput);
            return 0;
        }
        if (i == 4) {
            c(extractorInput);
            return 0;
        }
        if (i == 5) {
            return h(extractorInput, positionHolder);
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker flacBinarySearchSeeker = this.l;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.setSeekTargetUs(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.b.reset(0);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.FlacMetadataReader.peekId3Metadata(extractorInput, false);
        return com.google.android.exoplayer2.extractor.FlacMetadataReader.checkAndPeekStreamMarker(extractorInput);
    }
}
