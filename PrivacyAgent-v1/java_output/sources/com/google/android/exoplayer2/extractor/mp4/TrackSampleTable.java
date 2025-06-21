package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
final class TrackSampleTable {
    public final com.google.android.exoplayer2.extractor.mp4.Track a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public TrackSampleTable(com.google.android.exoplayer2.extractor.mp4.Track track, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.Assertions.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.Assertions.checkArgument(iArr2.length == jArr2.length);
        this.a = track;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j) {
        for (int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.f, j, true, false); binarySearchFloor >= 0; binarySearchFloor--) {
            if ((this.g[binarySearchFloor] & 1) != 0) {
                return binarySearchFloor;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int binarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.f, j, true, false); binarySearchCeil < this.f.length; binarySearchCeil++) {
            if ((this.g[binarySearchCeil] & 1) != 0) {
                return binarySearchCeil;
            }
        }
        return -1;
    }
}
