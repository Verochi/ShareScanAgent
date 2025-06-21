package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class DefaultExtractorInput implements com.google.android.exoplayer2.extractor.ExtractorInput {
    public final com.google.android.exoplayer2.upstream.DataReader b;
    public final long c;
    public long d;
    public int f;
    public int g;
    public byte[] e = new byte[65536];
    public final byte[] a = new byte[4096];

    public DefaultExtractorInput(com.google.android.exoplayer2.upstream.DataReader dataReader, long j, long j2) {
        this.b = dataReader;
        this.d = j;
        this.c = j2;
    }

    public final void a(int i) {
        if (i != -1) {
            this.d += i;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i) throws java.io.IOException {
        advancePeekPosition(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i, boolean z) throws java.io.IOException {
        b(i);
        int i2 = this.g - this.f;
        while (i2 < i) {
            i2 = d(this.e, this.f, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.g = this.f + i2;
        }
        this.f += i;
        return true;
    }

    public final void b(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = java.util.Arrays.copyOf(this.e, com.google.android.exoplayer2.util.Util.constrainValue(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    public final int c(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int min = java.lang.Math.min(i3, i2);
        java.lang.System.arraycopy(this.e, 0, bArr, i, min);
        f(min);
        return min;
    }

    public final int d(byte[] bArr, int i, int i2, int i3, boolean z) throws java.io.IOException {
        if (java.lang.Thread.interrupted()) {
            throw new java.io.InterruptedIOException();
        }
        int read = this.b.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            return i3 + read;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new java.io.EOFException();
    }

    public final int e(int i) {
        int min = java.lang.Math.min(this.g, i);
        f(min);
        return min;
    }

    public final void f(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.d + this.f;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int peek(byte[] bArr, int i, int i2) throws java.io.IOException {
        int min;
        b(i2);
        int i3 = this.g;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            min = d(this.e, i4, i2, 0, true);
            if (min == -1) {
                return -1;
            }
            this.g += min;
        } else {
            min = java.lang.Math.min(i2, i5);
        }
        java.lang.System.arraycopy(this.e, this.f, bArr, i, min);
        this.f += min;
        return min;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i, int i2) throws java.io.IOException {
        peekFully(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws java.io.IOException {
        if (!advancePeekPosition(i2, z)) {
            return false;
        }
        java.lang.System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int c = c(bArr, i, i2);
        if (c == 0) {
            c = d(bArr, i, i2, 0, true);
        }
        a(c);
        return c;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) throws java.io.IOException {
        readFully(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) throws java.io.IOException {
        int c = c(bArr, i, i2);
        while (c < i2 && c != -1) {
            c = d(bArr, i, i2, c, z);
        }
        a(c);
        return c != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.f = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends java.lang.Throwable> void setRetryPosition(long j, E e) throws java.lang.Throwable {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j >= 0);
        this.d = j;
        throw e;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i) throws java.io.IOException {
        int e = e(i);
        if (e == 0) {
            byte[] bArr = this.a;
            e = d(bArr, 0, java.lang.Math.min(i, bArr.length), 0, true);
        }
        a(e);
        return e;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i) throws java.io.IOException {
        skipFully(i, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i, boolean z) throws java.io.IOException {
        int e = e(i);
        while (e < i && e != -1) {
            e = d(this.a, -e, java.lang.Math.min(i, this.a.length + e), e, z);
        }
        a(e);
        return e != -1;
    }
}
