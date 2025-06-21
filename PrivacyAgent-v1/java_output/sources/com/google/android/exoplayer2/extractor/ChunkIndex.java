package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class ChunkIndex implements com.google.android.exoplayer2.extractor.SeekMap {
    public final long a;
    public final long[] durationsUs;
    public final int length;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timesUs;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.sizes = iArr;
        this.offsets = jArr;
        this.durationsUs = jArr2;
        this.timesUs = jArr3;
        int length = iArr.length;
        this.length = length;
        if (length > 0) {
            this.a = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.a = 0L;
        }
    }

    public int getChunkIndex(long j) {
        return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.timesUs, j, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        int chunkIndex = getChunkIndex(j);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(this.timesUs[chunkIndex], this.offsets[chunkIndex]);
        if (seekPoint.timeUs >= j || chunkIndex == this.length - 1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
        }
        int i = chunkIndex + 1;
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(this.timesUs[i], this.offsets[i]));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public java.lang.String toString() {
        int i = this.length;
        java.lang.String arrays = java.util.Arrays.toString(this.sizes);
        java.lang.String arrays2 = java.util.Arrays.toString(this.offsets);
        java.lang.String arrays3 = java.util.Arrays.toString(this.timesUs);
        java.lang.String arrays4 = java.util.Arrays.toString(this.durationsUs);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(arrays).length() + 71 + java.lang.String.valueOf(arrays2).length() + java.lang.String.valueOf(arrays3).length() + java.lang.String.valueOf(arrays4).length());
        sb.append("ChunkIndex(length=");
        sb.append(i);
        sb.append(", sizes=");
        sb.append(arrays);
        sb.append(", offsets=");
        sb.append(arrays2);
        sb.append(", timeUs=");
        sb.append(arrays3);
        sb.append(", durationsUs=");
        sb.append(arrays4);
        sb.append(")");
        return sb.toString();
    }
}
