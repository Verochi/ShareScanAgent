package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class IndexSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
    public final long[] a;
    public final long[] b;
    public final long c;
    public final boolean d;

    public IndexSeekMap(long[] jArr, long[] jArr2, long j) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.d = z;
        if (!z || jArr2[0] <= 0) {
            this.a = jArr;
            this.b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.a = jArr3;
            long[] jArr4 = new long[i];
            this.b = jArr4;
            java.lang.System.arraycopy(jArr, 0, jArr3, 1, length);
            java.lang.System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.c = j;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        if (!this.d) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint.START);
        }
        int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.b, j, true, true);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(this.b[binarySearchFloor], this.a[binarySearchFloor]);
        if (seekPoint.timeUs == j || binarySearchFloor == this.b.length - 1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
        }
        int i = binarySearchFloor + 1;
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(this.b[i], this.a[i]));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.d;
    }
}
