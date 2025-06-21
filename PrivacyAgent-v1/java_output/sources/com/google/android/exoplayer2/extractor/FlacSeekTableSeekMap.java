package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class FlacSeekTableSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
    public final com.google.android.exoplayer2.extractor.FlacStreamMetadata a;
    public final long b;

    public FlacSeekTableSeekMap(com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata, long j) {
        this.a = flacStreamMetadata;
        this.b = j;
    }

    public final com.google.android.exoplayer2.extractor.SeekPoint a(long j, long j2) {
        return new com.google.android.exoplayer2.extractor.SeekPoint((j * 1000000) / this.a.sampleRate, this.b + j2);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.a.getDurationUs();
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.a.seekTable);
        com.google.android.exoplayer2.extractor.FlacStreamMetadata flacStreamMetadata = this.a;
        com.google.android.exoplayer2.extractor.FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata.seekTable;
        long[] jArr = seekTable.pointSampleNumbers;
        long[] jArr2 = seekTable.pointOffsets;
        int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(jArr, flacStreamMetadata.getSampleNumber(j), true, false);
        com.google.android.exoplayer2.extractor.SeekPoint a = a(binarySearchFloor == -1 ? 0L : jArr[binarySearchFloor], binarySearchFloor != -1 ? jArr2[binarySearchFloor] : 0L);
        if (a.timeUs == j || binarySearchFloor == jArr.length - 1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(a);
        }
        int i = binarySearchFloor + 1;
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(a, a(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
