package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public abstract class BinarySearchSeeker {
    public final int a;
    protected final com.google.android.exoplayer2.extractor.BinarySearchSeeker.BinarySearchSeekMap seekMap;

    @androidx.annotation.Nullable
    protected com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams seekOperationParams;
    protected final com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker timestampSeeker;

    public static class BinarySearchSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
        public final com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter a;
        public final long b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;

        public BinarySearchSeekMap(com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter seekTimestampConverter, long j, long j2, long j3, long j4, long j5, long j6) {
            this.a = seekTimestampConverter;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.b;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(j, com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams.calculateNextSearchBytePosition(this.a.timeUsToTargetTime(j), this.c, this.d, this.e, this.f, this.g)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public long timeUsToTargetTime(long j) {
            return this.a.timeUsToTargetTime(j);
        }
    }

    public static final class DefaultSeekTimestampConverter implements com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter {
        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
        public long timeUsToTargetTime(long j) {
            return j;
        }
    }

    public static class SeekOperationParams {
        public final long a;
        public final long b;
        public final long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public SeekOperationParams(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = calculateNextSearchBytePosition(j2, j3, j4, j5, j6, j7);
        }

        public static long calculateNextSearchBytePosition(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return com.google.android.exoplayer2.util.Util.constrainValue(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        public final long h() {
            return this.g;
        }

        public final long i() {
            return this.f;
        }

        public final long j() {
            return this.h;
        }

        public final long k() {
            return this.a;
        }

        public final long l() {
            return this.b;
        }

        public final void m() {
            this.h = calculateNextSearchBytePosition(this.b, this.d, this.e, this.f, this.g, this.c);
        }

        public final void n(long j, long j2) {
            this.e = j;
            this.g = j2;
            m();
        }

        public final void o(long j, long j2) {
            this.d = j;
            this.f = j2;
            m();
        }
    }

    public interface SeekTimestampConverter {
        long timeUsToTargetTime(long j);
    }

    public static final class TimestampSearchResult {
        public static final com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = new com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult(-3, -9223372036854775807L, -1);
        public static final int TYPE_NO_TIMESTAMP = -3;
        public static final int TYPE_POSITION_OVERESTIMATED = -1;
        public static final int TYPE_POSITION_UNDERESTIMATED = -2;
        public static final int TYPE_TARGET_TIMESTAMP_FOUND = 0;
        public final int a;
        public final long b;
        public final long c;

        public TimestampSearchResult(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        public static com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult overestimatedResult(long j, long j2) {
            return new com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult(-1, j, j2);
        }

        public static com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult targetFoundResult(long j) {
            return new com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult(0, -9223372036854775807L, j);
        }

        public static com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult underestimatedResult(long j, long j2) {
            return new com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult(-2, j, j2);
        }
    }

    public interface TimestampSeeker {
        void onSeekFinished();

        com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForTimestamp(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException;
    }

    public BinarySearchSeeker(com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter seekTimestampConverter, com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker timestampSeeker, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.timestampSeeker = timestampSeeker;
        this.a = i;
        this.seekMap = new com.google.android.exoplayer2.extractor.BinarySearchSeeker.BinarySearchSeekMap(seekTimestampConverter, j, j2, j3, j4, j5, j6);
    }

    public com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams createSeekParamsForTargetTimeUs(long j) {
        return new com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams(j, this.seekMap.timeUsToTargetTime(j), this.seekMap.c, this.seekMap.d, this.seekMap.e, this.seekMap.f, this.seekMap.g);
    }

    public final com.google.android.exoplayer2.extractor.SeekMap getSeekMap() {
        return this.seekMap;
    }

    public int handlePendingSeek(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        while (true) {
            com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams seekOperationParams = (com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.seekOperationParams);
            long i = seekOperationParams.i();
            long h = seekOperationParams.h();
            long j = seekOperationParams.j();
            if (h - i <= this.a) {
                markSeekOperationFinished(false, i);
                return seekToPosition(extractorInput, i, positionHolder);
            }
            if (!skipInputUntilPosition(extractorInput, j)) {
                return seekToPosition(extractorInput, j, positionHolder);
            }
            extractorInput.resetPeekPosition();
            com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForTimestamp = this.timestampSeeker.searchForTimestamp(extractorInput, seekOperationParams.l());
            int i2 = searchForTimestamp.a;
            if (i2 == -3) {
                markSeekOperationFinished(false, j);
                return seekToPosition(extractorInput, j, positionHolder);
            }
            if (i2 == -2) {
                seekOperationParams.o(searchForTimestamp.b, searchForTimestamp.c);
            } else {
                if (i2 != -1) {
                    if (i2 != 0) {
                        throw new java.lang.IllegalStateException("Invalid case");
                    }
                    skipInputUntilPosition(extractorInput, searchForTimestamp.c);
                    markSeekOperationFinished(true, searchForTimestamp.c);
                    return seekToPosition(extractorInput, searchForTimestamp.c, positionHolder);
                }
                seekOperationParams.n(searchForTimestamp.b, searchForTimestamp.c);
            }
        }
    }

    public final boolean isSeeking() {
        return this.seekOperationParams != null;
    }

    public final void markSeekOperationFinished(boolean z, long j) {
        this.seekOperationParams = null;
        this.timestampSeeker.onSeekFinished();
        onSeekOperationFinished(z, j);
    }

    public void onSeekOperationFinished(boolean z, long j) {
    }

    public final int seekToPosition(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) {
        if (j == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.position = j;
        return 1;
    }

    public final void setSeekTargetUs(long j) {
        com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams seekOperationParams = this.seekOperationParams;
        if (seekOperationParams == null || seekOperationParams.k() != j) {
            this.seekOperationParams = createSeekParamsForTargetTimeUs(j);
        }
    }

    public final boolean skipInputUntilPosition(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException {
        long position = j - extractorInput.getPosition();
        if (position < 0 || position > android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }
}
