package com.google.android.exoplayer2.extractor.flac;

/* loaded from: classes22.dex */
final class FlacBinarySearchSeeker extends com.google.android.exoplayer2.extractor.BinarySearchSeeker {

    public static final class FlacTimestampSeeker implements com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker {
        public final com.google.android.exoplayer2.extractor.FlacStreamMetadata a;
        public final int b;
        public final com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder c;

        public FlacTimestampSeeker(com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, int i) {
            this.a = flacStreamMetadata;
            this.b = i;
            this.c = new com.google.android.exoplayer2.extractor.FlacFrameReader.SampleNumberHolder();
        }

        public /* synthetic */ FlacTimestampSeeker(com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, int i, com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.AnonymousClass1 anonymousClass1) {
            this(flacStreamMetadata, i);
        }

        public final long a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
            while (extractorInput.getPeekPosition() < extractorInput.getLength() - 6 && !com.google.android.exoplayer2.extractor.FlacFrameReader.checkFrameHeaderFromPeek(extractorInput, this.a, this.b, this.c)) {
                extractorInput.advancePeekPosition(1);
            }
            if (extractorInput.getPeekPosition() < extractorInput.getLength() - 6) {
                return this.c.sampleNumber;
            }
            extractorInput.advancePeekPosition((int) (extractorInput.getLength() - extractorInput.getPeekPosition()));
            return this.a.totalSamples;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public /* synthetic */ void onSeekFinished() {
            defpackage.ai.a(this);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForTimestamp(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException {
            long position = extractorInput.getPosition();
            long a = a(extractorInput);
            long peekPosition = extractorInput.getPeekPosition();
            extractorInput.advancePeekPosition(java.lang.Math.max(6, this.a.minFrameSize));
            long a2 = a(extractorInput);
            return (a > j || a2 <= j) ? a2 <= j ? com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.underestimatedResult(a2, extractorInput.getPeekPosition()) : com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.overestimatedResult(a, position) : com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(peekPosition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlacBinarySearchSeeker(com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, int i, long j, long j2) {
        super(new defpackage.bf0(flacStreamMetadata), new com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.FlacTimestampSeeker(flacStreamMetadata, i, null), flacStreamMetadata.getDurationUs(), 0L, flacStreamMetadata.totalSamples, j, j2, flacStreamMetadata.getApproxBytesPerFrame(), java.lang.Math.max(6, flacStreamMetadata.minFrameSize));
        java.util.Objects.requireNonNull(flacStreamMetadata);
    }
}
