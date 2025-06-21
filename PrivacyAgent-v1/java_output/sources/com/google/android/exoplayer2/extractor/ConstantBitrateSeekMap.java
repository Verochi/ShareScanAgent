package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public class ConstantBitrateSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
    public final long a;
    public final long b;
    public final int c;
    public final long d;
    public final int e;
    public final long f;

    public ConstantBitrateSeekMap(long j, long j2, int i, int i2) {
        this.a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        if (j == -1) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        } else {
            this.d = j - j2;
            this.f = b(j, j2, i);
        }
    }

    public static long b(long j, long j2, int i) {
        return ((java.lang.Math.max(0L, j - j2) * 8) * 1000000) / i;
    }

    public final long a(long j) {
        long j2 = (j * this.e) / 8000000;
        int i = this.c;
        return this.b + com.google.android.exoplayer2.util.Util.constrainValue((j2 / i) * i, 0L, this.d - i);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        if (this.d == -1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(0L, this.b));
        }
        long a = a(j);
        long timeUsAtPosition = getTimeUsAtPosition(a);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(timeUsAtPosition, a);
        if (timeUsAtPosition < j) {
            int i = this.c;
            if (i + a < this.a) {
                long j2 = a + i;
                return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(getTimeUsAtPosition(j2), j2));
            }
        }
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUsAtPosition(long j) {
        return b(j, this.b, this.e);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.d != -1;
    }
}
