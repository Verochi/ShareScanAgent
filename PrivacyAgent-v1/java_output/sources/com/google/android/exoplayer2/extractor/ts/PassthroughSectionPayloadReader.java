package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class PassthroughSectionPayloadReader implements com.google.android.exoplayer2.extractor.ts.SectionPayloadReader {
    public com.google.android.exoplayer2.Format a;
    public com.google.android.exoplayer2.util.TimestampAdjuster b;
    public com.google.android.exoplayer2.extractor.TrackOutput c;

    public PassthroughSectionPayloadReader(java.lang.String str) {
        this.a = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType(str).build();
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"timestampAdjuster", "output"})
    public final void a() {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.b);
        com.google.android.exoplayer2.util.Util.castNonNull(this.c);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        a();
        long timestampOffsetUs = this.b.getTimestampOffsetUs();
        if (timestampOffsetUs == -9223372036854775807L) {
            return;
        }
        com.google.android.exoplayer2.Format format = this.a;
        if (timestampOffsetUs != format.subsampleOffsetUs) {
            com.google.android.exoplayer2.Format build = format.buildUpon().setSubsampleOffsetUs(timestampOffsetUs).build();
            this.a = build;
            this.c.format(build);
        }
        int bytesLeft = parsableByteArray.bytesLeft();
        this.c.sampleData(parsableByteArray, bytesLeft);
        this.c.sampleMetadata(this.b.getLastAdjustedTimestampUs(), 1, bytesLeft, 0, null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.b = timestampAdjuster;
        trackIdGenerator.generateNewId();
        com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
        this.c = track;
        track.format(this.a);
    }
}
