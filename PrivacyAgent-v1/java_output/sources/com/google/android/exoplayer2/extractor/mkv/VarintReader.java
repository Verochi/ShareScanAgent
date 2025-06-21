package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes22.dex */
final class VarintReader {
    public static final long[] d = {128, 64, 32, 16, 8, 4, 2, 1};
    public final byte[] a = new byte[8];
    public int b;
    public int c;

    public static long a(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= ~d[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    public static int c(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = d;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & i) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public int b() {
        return this.c;
    }

    public long d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z, boolean z2, int i) throws java.io.IOException {
        if (this.b == 0) {
            if (!extractorInput.readFully(this.a, 0, 1, z)) {
                return -1L;
            }
            int c = c(this.a[0] & 255);
            this.c = c;
            if (c == -1) {
                throw new java.lang.IllegalStateException("No valid varint length mask found");
            }
            this.b = 1;
        }
        int i2 = this.c;
        if (i2 > i) {
            this.b = 0;
            return -2L;
        }
        if (i2 != 1) {
            extractorInput.readFully(this.a, 1, i2 - 1);
        }
        this.b = 0;
        return a(this.a, this.c, z2);
    }

    public void e() {
        this.b = 0;
        this.c = 0;
    }
}
