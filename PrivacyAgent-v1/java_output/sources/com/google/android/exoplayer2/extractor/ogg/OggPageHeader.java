package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
final class OggPageHeader {
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    public final com.google.android.exoplayer2.util.ParsableByteArray k = new com.google.android.exoplayer2.util.ParsableByteArray(255);

    public static boolean a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, byte[] bArr, int i, int i2, boolean z) throws java.io.IOException {
        try {
            return extractorInput.peekFully(bArr, i, i2, z);
        } catch (java.io.EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public boolean b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z) throws java.io.IOException {
        c();
        this.k.reset(27);
        if (!a(extractorInput, this.k.getData(), 0, 27, z) || this.k.readUnsignedInt() != 1332176723) {
            return false;
        }
        int readUnsignedByte = this.k.readUnsignedByte();
        this.a = readUnsignedByte;
        if (readUnsignedByte != 0) {
            if (z) {
                return false;
            }
            throw new com.google.android.exoplayer2.ParserException("unsupported bit stream revision");
        }
        this.b = this.k.readUnsignedByte();
        this.c = this.k.readLittleEndianLong();
        this.d = this.k.readLittleEndianUnsignedInt();
        this.e = this.k.readLittleEndianUnsignedInt();
        this.f = this.k.readLittleEndianUnsignedInt();
        int readUnsignedByte2 = this.k.readUnsignedByte();
        this.g = readUnsignedByte2;
        this.h = readUnsignedByte2 + 27;
        this.k.reset(readUnsignedByte2);
        extractorInput.peekFully(this.k.getData(), 0, this.g);
        for (int i = 0; i < this.g; i++) {
            this.j[i] = this.k.readUnsignedByte();
            this.i += this.j[i];
        }
        return true;
    }

    public void c() {
        this.a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return e(extractorInput, -1L);
    }

    public boolean e(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkArgument(extractorInput.getPosition() == extractorInput.getPeekPosition());
        while (true) {
            if ((j == -1 || extractorInput.getPosition() + 4 < j) && a(extractorInput, this.k.getData(), 0, 4, true)) {
                this.k.reset(4);
                if (this.k.readUnsignedInt() == 1332176723) {
                    extractorInput.resetPeekPosition();
                    return true;
                }
                extractorInput.skipFully(1);
            }
        }
        do {
            if (j != -1 && extractorInput.getPosition() >= j) {
                break;
            }
        } while (extractorInput.skip(1) != -1);
        return false;
    }
}
