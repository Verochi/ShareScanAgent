package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
public class OggExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.su1();
    public com.google.android.exoplayer2.extractor.ExtractorOutput a;
    public com.google.android.exoplayer2.extractor.ogg.StreamReader b;
    public boolean c;

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] b() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ogg.OggExtractor()};
    }

    public static com.google.android.exoplayer2.util.ParsableByteArray c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(0);
        return parsableByteArray;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    public final boolean d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.ogg.OggPageHeader oggPageHeader = new com.google.android.exoplayer2.extractor.ogg.OggPageHeader();
        if (oggPageHeader.b(extractorInput, true) && (oggPageHeader.b & 2) == 2) {
            int min = java.lang.Math.min(oggPageHeader.i, 8);
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(min);
            extractorInput.peekFully(parsableByteArray.getData(), 0, min);
            if (com.google.android.exoplayer2.extractor.ogg.FlacReader.n(c(parsableByteArray))) {
                this.b = new com.google.android.exoplayer2.extractor.ogg.FlacReader();
            } else if (com.google.android.exoplayer2.extractor.ogg.VorbisReader.p(c(parsableByteArray))) {
                this.b = new com.google.android.exoplayer2.extractor.ogg.VorbisReader();
            } else if (com.google.android.exoplayer2.extractor.ogg.OpusReader.m(c(parsableByteArray))) {
                this.b = new com.google.android.exoplayer2.extractor.ogg.OpusReader();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.a = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.a);
        if (this.b == null) {
            if (!d(extractorInput)) {
                throw new com.google.android.exoplayer2.ParserException("Failed to determine bitstream type");
            }
            extractorInput.resetPeekPosition();
        }
        if (!this.c) {
            com.google.android.exoplayer2.extractor.TrackOutput track = this.a.track(0, 1);
            this.a.endTracks();
            this.b.c(this.a, track);
            this.c = true;
        }
        return this.b.f(extractorInput, positionHolder);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        com.google.android.exoplayer2.extractor.ogg.StreamReader streamReader = this.b;
        if (streamReader != null) {
            streamReader.k(j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        try {
            return d(extractorInput);
        } catch (com.google.android.exoplayer2.ParserException unused) {
            return false;
        }
    }
}
