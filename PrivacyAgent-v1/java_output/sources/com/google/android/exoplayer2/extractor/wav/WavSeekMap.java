package com.google.android.exoplayer2.extractor.wav;

/* loaded from: classes22.dex */
final class WavSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
    public final com.google.android.exoplayer2.extractor.wav.WavHeader a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    public WavSeekMap(com.google.android.exoplayer2.extractor.wav.WavHeader wavHeader, int i, long j, long j2) {
        this.a = wavHeader;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / wavHeader.e;
        this.d = j3;
        this.e = a(j3);
    }

    public final long a(long j) {
        return com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j * this.b, 1000000L, this.a.c);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        long constrainValue = com.google.android.exoplayer2.util.Util.constrainValue((this.a.c * j) / (this.b * 1000000), 0L, this.d - 1);
        long j2 = this.c + (this.a.e * constrainValue);
        long a = a(constrainValue);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(a, j2);
        if (a >= j || constrainValue == this.d - 1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
        }
        long j3 = constrainValue + 1;
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(a(j3), this.c + (this.a.e * j3)));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
