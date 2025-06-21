package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes22.dex */
final class MlltSeeker implements com.google.android.exoplayer2.extractor.mp3.Seeker {
    public final long[] a;
    public final long[] b;
    public final long c;

    public MlltSeeker(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j == -9223372036854775807L ? com.google.android.exoplayer2.C.msToUs(jArr2[jArr2.length - 1]) : j;
    }

    public static com.google.android.exoplayer2.extractor.mp3.MlltSeeker a(long j, com.google.android.exoplayer2.metadata.id3.MlltFrame mlltFrame, long j2) {
        int length = mlltFrame.bytesDeviations.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i3];
            j3 += mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new com.google.android.exoplayer2.extractor.mp3.MlltSeeker(jArr, jArr2, j2);
    }

    public static android.util.Pair<java.lang.Long, java.lang.Long> b(long j, long[] jArr, long[] jArr2) {
        int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(jArr, j, true, true);
        long j2 = jArr[binarySearchFloor];
        long j3 = jArr2[binarySearchFloor];
        int i = binarySearchFloor + 1;
        if (i == jArr.length) {
            return android.util.Pair.create(java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3));
        }
        return android.util.Pair.create(java.lang.Long.valueOf(j), java.lang.Long.valueOf(((long) ((jArr[i] == j2 ? 0.0d : (j - j2) / (r6 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        android.util.Pair<java.lang.Long, java.lang.Long> b = b(com.google.android.exoplayer2.C.usToMs(com.google.android.exoplayer2.util.Util.constrainValue(j, 0L, this.c)), this.b, this.a);
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(com.google.android.exoplayer2.C.msToUs(((java.lang.Long) b.first).longValue()), ((java.lang.Long) b.second).longValue()));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return com.google.android.exoplayer2.C.msToUs(((java.lang.Long) b(j, this.a, this.b).second).longValue());
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
