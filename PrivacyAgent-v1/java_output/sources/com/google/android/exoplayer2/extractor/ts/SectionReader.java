package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class SectionReader implements com.google.android.exoplayer2.extractor.ts.TsPayloadReader {
    public final com.google.android.exoplayer2.extractor.ts.SectionPayloadReader a;
    public final com.google.android.exoplayer2.util.ParsableByteArray b = new com.google.android.exoplayer2.util.ParsableByteArray(32);
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public SectionReader(com.google.android.exoplayer2.extractor.ts.SectionPayloadReader sectionPayloadReader) {
        this.a = sectionPayloadReader;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        boolean z = (i & 1) != 0;
        int position = z ? parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            parsableByteArray.setPosition(position);
            this.d = 0;
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i2 = this.d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    parsableByteArray.setPosition(parsableByteArray.getPosition() - 1);
                    if (readUnsignedByte == 255) {
                        this.f = true;
                        return;
                    }
                }
                int min = java.lang.Math.min(parsableByteArray.bytesLeft(), 3 - this.d);
                parsableByteArray.readBytes(this.b.getData(), this.d, min);
                int i3 = this.d + min;
                this.d = i3;
                if (i3 == 3) {
                    this.b.reset(3);
                    this.b.skipBytes(1);
                    int readUnsignedByte2 = this.b.readUnsignedByte();
                    int readUnsignedByte3 = this.b.readUnsignedByte();
                    this.e = (readUnsignedByte2 & 128) != 0;
                    this.c = (((readUnsignedByte2 & 15) << 8) | readUnsignedByte3) + 3;
                    if (this.b.capacity() < this.c) {
                        byte[] data = this.b.getData();
                        this.b.reset(java.lang.Math.min(4098, java.lang.Math.max(this.c, data.length * 2)));
                        java.lang.System.arraycopy(data, 0, this.b.getData(), 0, 3);
                    }
                }
            } else {
                int min2 = java.lang.Math.min(parsableByteArray.bytesLeft(), this.c - this.d);
                parsableByteArray.readBytes(this.b.getData(), this.d, min2);
                int i4 = this.d + min2;
                this.d = i4;
                int i5 = this.c;
                if (i4 != i5) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.reset(i5);
                    } else {
                        if (com.google.android.exoplayer2.util.Util.crc32(this.b.getData(), 0, this.c, -1) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.reset(this.c - 4);
                    }
                    this.a.consume(this.b);
                    this.d = 0;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.a.init(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f = true;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void seek() {
        this.f = true;
    }
}
