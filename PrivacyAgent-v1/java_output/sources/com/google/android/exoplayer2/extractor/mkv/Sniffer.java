package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes22.dex */
final class Sniffer {
    public final com.google.android.exoplayer2.util.ParsableByteArray a = new com.google.android.exoplayer2.util.ParsableByteArray(8);
    public int b;

    public final long a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int i = 0;
        extractorInput.peekFully(this.a.getData(), 0, 1);
        int i2 = this.a.getData()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        extractorInput.peekFully(this.a.getData(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.getData()[i] & 255) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        long length = extractorInput.getLength();
        long j = 1024;
        if (length != -1 && length <= 1024) {
            j = length;
        }
        int i = (int) j;
        extractorInput.peekFully(this.a.getData(), 0, 4);
        long readUnsignedInt = this.a.readUnsignedInt();
        this.b = 4;
        while (readUnsignedInt != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.peekFully(this.a.getData(), 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.a.getData()[0] & 255);
        }
        long a = a(extractorInput);
        long j2 = this.b;
        if (a == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j2 + a >= length) {
            return false;
        }
        while (true) {
            int i3 = this.b;
            long j3 = j2 + a;
            if (i3 >= j3) {
                return ((long) i3) == j3;
            }
            if (a(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            long a2 = a(extractorInput);
            if (a2 < 0 || a2 > 2147483647L) {
                break;
            }
            if (a2 != 0) {
                int i4 = (int) a2;
                extractorInput.advancePeekPosition(i4);
                this.b += i4;
            }
        }
    }
}
