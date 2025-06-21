package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
final class TsBinarySearchSeeker extends com.google.android.exoplayer2.extractor.BinarySearchSeeker {

    public static final class TsPcrSeeker implements com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker {
        public final com.google.android.exoplayer2.util.TimestampAdjuster a;
        public final com.google.android.exoplayer2.util.ParsableByteArray b = new com.google.android.exoplayer2.util.ParsableByteArray();
        public final int c;
        public final int d;

        public TsPcrSeeker(int i, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, int i2) {
            this.c = i;
            this.a = timestampAdjuster;
            this.d = i2;
        }

        public final com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j, long j2) {
            int findSyncBytePosition;
            int findSyncBytePosition2;
            int limit = parsableByteArray.limit();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (parsableByteArray.bytesLeft() >= 188 && (findSyncBytePosition2 = (findSyncBytePosition = com.google.android.exoplayer2.extractor.ts.TsUtil.findSyncBytePosition(parsableByteArray.getData(), parsableByteArray.getPosition(), limit)) + com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE) <= limit) {
                long readPcrFromPacket = com.google.android.exoplayer2.extractor.ts.TsUtil.readPcrFromPacket(parsableByteArray, findSyncBytePosition, this.c);
                if (readPcrFromPacket != -9223372036854775807L) {
                    long adjustTsTimestamp = this.a.adjustTsTimestamp(readPcrFromPacket);
                    if (adjustTsTimestamp > j) {
                        return j5 == -9223372036854775807L ? com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, j2) : com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + j4);
                    }
                    if (100000 + adjustTsTimestamp > j) {
                        return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + findSyncBytePosition);
                    }
                    j4 = findSyncBytePosition;
                    j5 = adjustTsTimestamp;
                }
                parsableByteArray.setPosition(findSyncBytePosition2);
                j3 = findSyncBytePosition2;
            }
            return j5 != -9223372036854775807L ? com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j5, j2 + j3) : com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.b.reset(com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForTimestamp(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException {
            long position = extractorInput.getPosition();
            int min = (int) java.lang.Math.min(this.d, extractorInput.getLength() - position);
            this.b.reset(min);
            extractorInput.peekFully(this.b.getData(), 0, min);
            return a(this.b, j, position);
        }
    }

    public TsBinarySearchSeeker(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, long j, long j2, int i, int i2) {
        super(new com.google.android.exoplayer2.extractor.BinarySearchSeeker.DefaultSeekTimestampConverter(), new com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker.TsPcrSeeker(i, timestampAdjuster, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
