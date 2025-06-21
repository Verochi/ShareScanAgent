package com.google.android.exoplayer2.extractor.rawcc;

/* loaded from: classes22.dex */
public final class RawCcExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public final com.google.android.exoplayer2.Format a;
    public com.google.android.exoplayer2.extractor.TrackOutput c;
    public int e;
    public long f;
    public int g;
    public int h;
    public final com.google.android.exoplayer2.util.ParsableByteArray b = new com.google.android.exoplayer2.util.ParsableByteArray(9);
    public int d = 0;

    public RawCcExtractor(com.google.android.exoplayer2.Format format) {
        this.a = format;
    }

    public final boolean a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        this.b.reset(8);
        if (!extractorInput.readFully(this.b.getData(), 0, 8, true)) {
            return false;
        }
        if (this.b.readInt() != 1380139777) {
            throw new java.io.IOException("Input not RawCC");
        }
        this.e = this.b.readUnsignedByte();
        return true;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput"})
    public final void b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        while (this.g > 0) {
            this.b.reset(3);
            extractorInput.readFully(this.b.getData(), 0, 3);
            this.c.sampleData(this.b, 3);
            this.h += 3;
            this.g--;
        }
        int i = this.h;
        if (i > 0) {
            this.c.sampleMetadata(this.f, 1, i, 0, null);
        }
    }

    public final boolean c(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int i = this.e;
        if (i == 0) {
            this.b.reset(5);
            if (!extractorInput.readFully(this.b.getData(), 0, 5, true)) {
                return false;
            }
            this.f = (this.b.readUnsignedInt() * 1000) / 45;
        } else {
            if (i != 1) {
                int i2 = this.e;
                java.lang.StringBuilder sb = new java.lang.StringBuilder(39);
                sb.append("Unsupported version number: ");
                sb.append(i2);
                throw new com.google.android.exoplayer2.ParserException(sb.toString());
            }
            this.b.reset(9);
            if (!extractorInput.readFully(this.b.getData(), 0, 9, true)) {
                return false;
            }
            this.f = this.b.readLong();
        }
        this.g = this.b.readUnsignedByte();
        this.h = 0;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        extractorOutput.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
        com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(0, 3);
        this.c = track;
        track.format(this.a);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.c);
        while (true) {
            int i = this.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new java.lang.IllegalStateException();
                    }
                    b(extractorInput);
                    this.d = 1;
                    return 0;
                }
                if (!c(extractorInput)) {
                    this.d = 0;
                    return -1;
                }
                this.d = 2;
            } else {
                if (!a(extractorInput)) {
                    return -1;
                }
                this.d = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.d = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        this.b.reset(8);
        extractorInput.peekFully(this.b.getData(), 0, 8);
        return this.b.readInt() == 1380139777;
    }
}
