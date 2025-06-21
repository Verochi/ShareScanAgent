package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class H263Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public static final float[] l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.ts.UserDataReader a;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.util.ParsableByteArray b;
    public final boolean[] c;
    public final com.google.android.exoplayer2.extractor.ts.H263Reader.CsdBuffer d;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer e;
    public com.google.android.exoplayer2.extractor.ts.H263Reader.SampleReader f;
    public long g;
    public java.lang.String h;
    public com.google.android.exoplayer2.extractor.TrackOutput i;
    public boolean j;
    public long k;

    public static final class CsdBuffer {
        public static final byte[] f = {0, 0, 1};
        public boolean a;
        public int b;
        public int c;
        public int d;
        public byte[] e;

        public CsdBuffer(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = java.util.Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                java.lang.System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }

        public boolean b(int i, int i2) {
            int i3 = this.b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new java.lang.IllegalStateException();
                            }
                            if (i == 179 || i == 181) {
                                this.c -= i2;
                                this.a = false;
                                return true;
                            }
                        } else if ((i & 240) != 32) {
                            com.google.android.exoplayer2.util.Log.w("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.d = this.c;
                            this.b = 4;
                        }
                    } else if (i > 31) {
                        com.google.android.exoplayer2.util.Log.w("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.b = 3;
                    }
                } else if (i != 181) {
                    com.google.android.exoplayer2.util.Log.w("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.b = 2;
                }
            } else if (i == 176) {
                this.b = 1;
                this.a = true;
            }
            byte[] bArr = f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.a = false;
            this.c = 0;
            this.b = 0;
        }
    }

    public static final class SampleReader {
        public final com.google.android.exoplayer2.extractor.TrackOutput a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public long g;
        public long h;

        public SampleReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            this.a = trackOutput;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f = i3 + (i2 - i);
                } else {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                }
            }
        }

        public void b(long j, int i, boolean z) {
            if (this.e == 182 && z && this.b) {
                this.a.sampleMetadata(this.h, this.d ? 1 : 0, (int) (j - this.g), i, null);
            }
            if (this.e != 179) {
                this.g = j;
            }
        }

        public void c(int i, long j) {
            this.e = i;
            this.d = false;
            this.b = i == 182 || i == 179;
            this.c = i == 182;
            this.f = 0;
            this.h = j;
        }

        public void d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = -1;
        }
    }

    public H263Reader() {
        this(null);
    }

    public H263Reader(@androidx.annotation.Nullable com.google.android.exoplayer2.extractor.ts.UserDataReader userDataReader) {
        this.a = userDataReader;
        this.c = new boolean[4];
        this.d = new com.google.android.exoplayer2.extractor.ts.H263Reader.CsdBuffer(128);
        if (userDataReader != null) {
            this.e = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(178, 128);
            this.b = new com.google.android.exoplayer2.util.ParsableByteArray();
        } else {
            this.e = null;
            this.b = null;
        }
    }

    public static com.google.android.exoplayer2.Format a(com.google.android.exoplayer2.extractor.ts.H263Reader.CsdBuffer csdBuffer, int i, java.lang.String str) {
        byte[] copyOf = java.util.Arrays.copyOf(csdBuffer.e, csdBuffer.c);
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(copyOf);
        parsableBitArray.skipBytes(i);
        parsableBitArray.skipBytes(4);
        parsableBitArray.skipBit();
        parsableBitArray.skipBits(8);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(4);
            parsableBitArray.skipBits(3);
        }
        int readBits = parsableBitArray.readBits(4);
        float f = 1.0f;
        if (readBits == 15) {
            int readBits2 = parsableBitArray.readBits(8);
            int readBits3 = parsableBitArray.readBits(8);
            if (readBits3 == 0) {
                com.google.android.exoplayer2.util.Log.w("H263Reader", "Invalid aspect ratio");
            } else {
                f = readBits2 / readBits3;
            }
        } else {
            float[] fArr = l;
            if (readBits < fArr.length) {
                f = fArr[readBits];
            } else {
                com.google.android.exoplayer2.util.Log.w("H263Reader", "Invalid aspect ratio");
            }
        }
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(2);
            parsableBitArray.skipBits(1);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(15);
                parsableBitArray.skipBit();
                parsableBitArray.skipBits(15);
                parsableBitArray.skipBit();
                parsableBitArray.skipBits(15);
                parsableBitArray.skipBit();
                parsableBitArray.skipBits(3);
                parsableBitArray.skipBits(11);
                parsableBitArray.skipBit();
                parsableBitArray.skipBits(15);
                parsableBitArray.skipBit();
            }
        }
        if (parsableBitArray.readBits(2) != 0) {
            com.google.android.exoplayer2.util.Log.w("H263Reader", "Unhandled video object layer shape");
        }
        parsableBitArray.skipBit();
        int readBits4 = parsableBitArray.readBits(16);
        parsableBitArray.skipBit();
        if (parsableBitArray.readBit()) {
            if (readBits4 == 0) {
                com.google.android.exoplayer2.util.Log.w("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i2 = 0;
                for (int i3 = readBits4 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                parsableBitArray.skipBits(i2);
            }
        }
        parsableBitArray.skipBit();
        int readBits5 = parsableBitArray.readBits(13);
        parsableBitArray.skipBit();
        int readBits6 = parsableBitArray.readBits(13);
        parsableBitArray.skipBit();
        parsableBitArray.skipBit();
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setSampleMimeType("video/mp4v-es").setWidth(readBits5).setHeight(readBits6).setPixelWidthHeightRatio(f).setInitializationData(java.util.Collections.singletonList(copyOf)).build();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.f);
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.i);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.g += parsableByteArray.bytesLeft();
        this.i.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(data, position, limit, this.c);
            if (findNalUnit == limit) {
                break;
            }
            int i = findNalUnit + 3;
            int i2 = parsableByteArray.getData()[i] & 255;
            int i3 = findNalUnit - position;
            int i4 = 0;
            if (!this.j) {
                if (i3 > 0) {
                    this.d.a(data, position, findNalUnit);
                }
                if (this.d.b(i2, i3 < 0 ? -i3 : 0)) {
                    com.google.android.exoplayer2.extractor.TrackOutput trackOutput = this.i;
                    com.google.android.exoplayer2.extractor.ts.H263Reader.CsdBuffer csdBuffer = this.d;
                    trackOutput.format(a(csdBuffer, csdBuffer.d, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.h)));
                    this.j = true;
                }
            }
            this.f.a(data, position, findNalUnit);
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer = this.e;
            if (nalUnitTargetBuffer != null) {
                if (i3 > 0) {
                    nalUnitTargetBuffer.a(data, position, findNalUnit);
                } else {
                    i4 = -i3;
                }
                if (this.e.b(i4)) {
                    com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer2 = this.e;
                    ((com.google.android.exoplayer2.util.ParsableByteArray) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).reset(this.e.d, com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.d, nalUnitTargetBuffer2.e));
                    ((com.google.android.exoplayer2.extractor.ts.UserDataReader) com.google.android.exoplayer2.util.Util.castNonNull(this.a)).a(this.k, this.b);
                }
                if (i2 == 178 && parsableByteArray.getData()[findNalUnit + 2] == 1) {
                    this.e.e(i2);
                }
            }
            int i5 = limit - findNalUnit;
            this.f.b(this.g - i5, i5, this.j);
            this.f.c(i2, this.k);
            position = i;
        }
        if (!this.j) {
            this.d.a(data, position, limit);
        }
        this.f.a(data, position, limit);
        com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer3 = this.e;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.a(data, position, limit);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.h = trackIdGenerator.getFormatId();
        com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.i = track;
        this.f = new com.google.android.exoplayer2.extractor.ts.H263Reader.SampleReader(track);
        com.google.android.exoplayer2.extractor.ts.UserDataReader userDataReader = this.a;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.k = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        com.google.android.exoplayer2.util.NalUnitUtil.clearPrefixFlags(this.c);
        this.d.c();
        com.google.android.exoplayer2.extractor.ts.H263Reader.SampleReader sampleReader = this.f;
        if (sampleReader != null) {
            sampleReader.d();
        }
        com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer = this.e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.g = 0L;
    }
}
