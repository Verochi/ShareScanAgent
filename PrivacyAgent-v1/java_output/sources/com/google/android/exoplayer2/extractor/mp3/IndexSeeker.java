package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes22.dex */
final class IndexSeeker implements com.google.android.exoplayer2.extractor.mp3.Seeker {
    public final long a;
    public final com.google.android.exoplayer2.util.LongArray b;
    public final com.google.android.exoplayer2.util.LongArray c;
    public long d;

    public IndexSeeker(long j, long j2, long j3) {
        this.d = j;
        this.a = j3;
        com.google.android.exoplayer2.util.LongArray longArray = new com.google.android.exoplayer2.util.LongArray();
        this.b = longArray;
        com.google.android.exoplayer2.util.LongArray longArray2 = new com.google.android.exoplayer2.util.LongArray();
        this.c = longArray2;
        longArray.add(0L);
        longArray2.add(j2);
    }

    public boolean a(long j) {
        com.google.android.exoplayer2.util.LongArray longArray = this.b;
        return j - longArray.get(longArray.size() - 1) < 100000;
    }

    public void b(long j, long j2) {
        if (a(j)) {
            return;
        }
        this.b.add(j);
        this.c.add(j2);
    }

    public void c(long j) {
        this.d = j;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.b, j, true, true);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(this.b.get(binarySearchFloor), this.c.get(binarySearchFloor));
        if (seekPoint.timeUs == j || binarySearchFloor == this.b.size() - 1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
        }
        int i = binarySearchFloor + 1;
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(this.b.get(i), this.c.get(i)));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return this.b.get(com.google.android.exoplayer2.util.Util.binarySearchFloor(this.c, j, true, true));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
