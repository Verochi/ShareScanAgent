package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes22.dex */
final class XingSeeker implements com.google.android.exoplayer2.extractor.mp3.Seeker {
    public final long a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    @androidx.annotation.Nullable
    public final long[] f;

    public XingSeeker(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    public XingSeeker(long j, int i, long j2, long j3, @androidx.annotation.Nullable long[] jArr) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp3.XingSeeker a(long j, long j2, com.google.android.exoplayer2.audio.MpegAudioUtil.Header header, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt;
        int i = header.samplesPerFrame;
        int i2 = header.sampleRate;
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) != 1 || (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long scaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(readUnsignedIntToInt, i * 1000000, i2);
        if ((readInt & 6) != 6) {
            return new com.google.android.exoplayer2.extractor.mp3.XingSeeker(j2, header.frameSize, scaleLargeTimestamp);
        }
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = parsableByteArray.readUnsignedByte();
        }
        if (j != -1) {
            long j3 = j2 + readUnsignedInt;
            if (j != j3) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(67);
                sb.append("XING data size mismatch: ");
                sb.append(j);
                sb.append(", ");
                sb.append(j3);
                com.google.android.exoplayer2.util.Log.w("XingSeeker", sb.toString());
            }
        }
        return new com.google.android.exoplayer2.extractor.mp3.XingSeeker(j2, header.frameSize, scaleLargeTimestamp, readUnsignedInt, jArr);
    }

    public final long b(int i) {
        return (this.c * i) / 100;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        if (!isSeekable()) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(0L, this.a + this.b));
        }
        long constrainValue = com.google.android.exoplayer2.util.Util.constrainValue(j, 0L, this.c);
        double d = (constrainValue * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = ((long[]) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.f))[i];
                d2 = d3 + ((d - i) * ((i == 99 ? 256.0d : r3[i + 1]) - d3));
            }
        }
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(constrainValue, this.a + com.google.android.exoplayer2.util.Util.constrainValue(java.lang.Math.round((d2 / 256.0d) * this.d), this.b, this.d - 1)));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        long j2 = j - this.a;
        if (!isSeekable() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.f);
        double d = (j2 * 256.0d) / this.d;
        int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(jArr, (long) d, true, true);
        long b = b(binarySearchFloor);
        long j3 = jArr[binarySearchFloor];
        int i = binarySearchFloor + 1;
        long b2 = b(i);
        return b + java.lang.Math.round((j3 == (binarySearchFloor == 99 ? 256L : jArr[i]) ? 0.0d : (d - j3) / (r0 - j3)) * (b2 - b));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.f != null;
    }
}
