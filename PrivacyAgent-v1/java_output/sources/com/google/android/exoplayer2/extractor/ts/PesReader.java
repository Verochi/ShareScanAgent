package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class PesReader implements com.google.android.exoplayer2.extractor.ts.TsPayloadReader {
    public final com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader a;
    public final com.google.android.exoplayer2.util.ParsableBitArray b = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[10]);
    public int c = 0;
    public int d;
    public com.google.android.exoplayer2.util.TimestampAdjuster e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public PesReader(com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader elementaryStreamReader) {
        this.a = elementaryStreamReader;
    }

    public final boolean a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, @androidx.annotation.Nullable byte[] bArr, int i) {
        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), i - this.d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.skipBytes(min);
        } else {
            parsableByteArray.readBytes(bArr, this.d, min);
        }
        int i2 = this.d + min;
        this.d = i2;
        return i2 == i;
    }

    public final boolean b() {
        this.b.setPosition(0);
        int readBits = this.b.readBits(24);
        if (readBits != 1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(41);
            sb.append("Unexpected start code prefix: ");
            sb.append(readBits);
            com.google.android.exoplayer2.util.Log.w("PesReader", sb.toString());
            this.j = -1;
            return false;
        }
        this.b.skipBits(8);
        int readBits2 = this.b.readBits(16);
        this.b.skipBits(5);
        this.k = this.b.readBit();
        this.b.skipBits(2);
        this.f = this.b.readBit();
        this.g = this.b.readBit();
        this.b.skipBits(6);
        int readBits3 = this.b.readBits(8);
        this.i = readBits3;
        if (readBits2 == 0) {
            this.j = -1;
        } else {
            int i = ((readBits2 + 6) - 9) - readBits3;
            this.j = i;
            if (i < 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(47);
                sb2.append("Found negative packet payload size: ");
                sb2.append(i);
                com.google.android.exoplayer2.util.Log.w("PesReader", sb2.toString());
                this.j = -1;
            }
        }
        return true;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"timestampAdjuster"})
    public final void c() {
        this.b.setPosition(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.skipBits(4);
            this.b.skipBits(1);
            this.b.skipBits(1);
            long readBits = (this.b.readBits(3) << 30) | (this.b.readBits(15) << 15) | this.b.readBits(15);
            this.b.skipBits(1);
            if (!this.h && this.g) {
                this.b.skipBits(4);
                this.b.skipBits(1);
                this.b.skipBits(1);
                this.b.skipBits(1);
                this.e.adjustTsTimestamp((this.b.readBits(3) << 30) | (this.b.readBits(15) << 15) | this.b.readBits(15));
                this.h = true;
            }
            this.l = this.e.adjustTsTimestamp(readBits);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.e);
        if ((i & 1) != 0) {
            int i2 = this.c;
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    com.google.android.exoplayer2.util.Log.w("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i2 != 3) {
                        throw new java.lang.IllegalStateException();
                    }
                    int i3 = this.j;
                    if (i3 != -1) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(59);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i3);
                        sb.append(" more bytes");
                        com.google.android.exoplayer2.util.Log.w("PesReader", sb.toString());
                    }
                    this.a.packetFinished();
                }
            }
            d(1);
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i4 = this.c;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        if (a(parsableByteArray, this.b.data, java.lang.Math.min(10, this.i)) && a(parsableByteArray, null, this.i)) {
                            c();
                            i |= this.k ? 4 : 0;
                            this.a.packetStarted(this.l, i);
                            d(3);
                        }
                    } else {
                        if (i4 != 3) {
                            throw new java.lang.IllegalStateException();
                        }
                        int bytesLeft = parsableByteArray.bytesLeft();
                        int i5 = this.j;
                        int i6 = i5 != -1 ? bytesLeft - i5 : 0;
                        if (i6 > 0) {
                            bytesLeft -= i6;
                            parsableByteArray.setLimit(parsableByteArray.getPosition() + bytesLeft);
                        }
                        this.a.consume(parsableByteArray);
                        int i7 = this.j;
                        if (i7 != -1) {
                            int i8 = i7 - bytesLeft;
                            this.j = i8;
                            if (i8 == 0) {
                                this.a.packetFinished();
                                d(1);
                            }
                        }
                    }
                } else if (a(parsableByteArray, this.b.data, 9)) {
                    d(b() ? 2 : 0);
                }
            } else {
                parsableByteArray.skipBytes(parsableByteArray.bytesLeft());
            }
        }
    }

    public final void d(int i) {
        this.c = i;
        this.d = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.e = timestampAdjuster;
        this.a.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void seek() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.seek();
    }
}
