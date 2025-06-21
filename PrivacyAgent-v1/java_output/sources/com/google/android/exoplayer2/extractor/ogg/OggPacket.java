package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
final class OggPacket {
    public final com.google.android.exoplayer2.extractor.ogg.OggPageHeader a = new com.google.android.exoplayer2.extractor.ogg.OggPageHeader();
    public final com.google.android.exoplayer2.util.ParsableByteArray b = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[65025], 0);
    public int c = -1;
    public int d;
    public boolean e;

    public final int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            com.google.android.exoplayer2.extractor.ogg.OggPageHeader oggPageHeader = this.a;
            if (i5 >= oggPageHeader.g) {
                break;
            }
            int[] iArr = oggPageHeader.j;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public com.google.android.exoplayer2.extractor.ogg.OggPageHeader b() {
        return this.a;
    }

    public com.google.android.exoplayer2.util.ParsableByteArray c() {
        return this.b;
    }

    public boolean d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int i;
        com.google.android.exoplayer2.util.Assertions.checkState(extractorInput != null);
        if (this.e) {
            this.e = false;
            this.b.reset(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.d(extractorInput) || !this.a.b(extractorInput, true)) {
                    return false;
                }
                com.google.android.exoplayer2.extractor.ogg.OggPageHeader oggPageHeader = this.a;
                int i2 = oggPageHeader.h;
                if ((oggPageHeader.b & 1) == 1 && this.b.limit() == 0) {
                    i2 += a(0);
                    i = this.d + 0;
                } else {
                    i = 0;
                }
                extractorInput.skipFully(i2);
                this.c = i;
            }
            int a = a(this.c);
            int i3 = this.c + this.d;
            if (a > 0) {
                if (this.b.capacity() < this.b.limit() + a) {
                    com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.b;
                    parsableByteArray.reset(java.util.Arrays.copyOf(parsableByteArray.getData(), this.b.limit() + a), this.b.limit());
                }
                extractorInput.readFully(this.b.getData(), this.b.limit(), a);
                com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = this.b;
                parsableByteArray2.setLimit(parsableByteArray2.limit() + a);
                this.e = this.a.j[i3 + (-1)] != 255;
            }
            if (i3 == this.a.g) {
                i3 = -1;
            }
            this.c = i3;
        }
        return true;
    }

    public void e() {
        this.a.c();
        this.b.reset(0);
        this.c = -1;
        this.e = false;
    }

    public void f() {
        if (this.b.getData().length == 65025) {
            return;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.b;
        parsableByteArray.reset(java.util.Arrays.copyOf(parsableByteArray.getData(), java.lang.Math.max(65025, this.b.limit())), this.b.limit());
    }
}
