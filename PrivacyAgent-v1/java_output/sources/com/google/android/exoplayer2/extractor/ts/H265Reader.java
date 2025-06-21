package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class H265Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public final com.google.android.exoplayer2.extractor.ts.SeiReader a;
    public java.lang.String b;
    public com.google.android.exoplayer2.extractor.TrackOutput c;
    public com.google.android.exoplayer2.extractor.ts.H265Reader.SampleReader d;
    public boolean e;
    public long l;
    public long m;
    public final boolean[] f = new boolean[3];
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer g = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(32, 128);
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer h = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(33, 128);
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer i = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(34, 128);
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer j = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(39, 128);
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer k = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(40, 128);
    public final com.google.android.exoplayer2.util.ParsableByteArray n = new com.google.android.exoplayer2.util.ParsableByteArray();

    public static final class SampleReader {
        public final com.google.android.exoplayer2.extractor.TrackOutput a;
        public long b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public SampleReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            this.a = trackOutput;
        }

        public static boolean b(int i) {
            return (32 <= i && i <= 35) || i == 39;
        }

        public static boolean c(int i) {
            return i < 32 || i == 40;
        }

        public void a(long j, int i, boolean z) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            } else if (this.h || this.g) {
                if (z && this.i) {
                    d(i + ((int) (j - this.b)));
                }
                this.k = this.b;
                this.l = this.e;
                this.m = this.c;
                this.i = true;
            }
        }

        public final void d(int i) {
            boolean z = this.m;
            this.a.sampleMetadata(this.l, z ? 1 : 0, (int) (this.b - this.k), i, null);
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                } else {
                    this.g = (bArr[i4] & 128) != 0;
                    this.f = false;
                }
            }
        }

        public void f() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void g(long j, int i, int i2, long j2, boolean z) {
            this.g = false;
            this.h = false;
            this.e = j2;
            this.d = 0;
            this.b = j;
            if (!c(i2)) {
                if (this.i && !this.j) {
                    if (z) {
                        d(i);
                    }
                    this.i = false;
                }
                if (b(i2)) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            boolean z2 = i2 >= 16 && i2 <= 21;
            this.c = z2;
            this.f = z2 || i2 <= 9;
        }
    }

    public H265Reader(com.google.android.exoplayer2.extractor.ts.SeiReader seiReader) {
        this.a = seiReader;
    }

    public static com.google.android.exoplayer2.Format d(@androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer, com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer2, com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i = nalUnitTargetBuffer.e;
        byte[] bArr = new byte[nalUnitTargetBuffer2.e + i + nalUnitTargetBuffer3.e];
        java.lang.System.arraycopy(nalUnitTargetBuffer.d, 0, bArr, 0, i);
        java.lang.System.arraycopy(nalUnitTargetBuffer2.d, 0, bArr, nalUnitTargetBuffer.e, nalUnitTargetBuffer2.e);
        java.lang.System.arraycopy(nalUnitTargetBuffer3.d, 0, bArr, nalUnitTargetBuffer.e + nalUnitTargetBuffer2.e, nalUnitTargetBuffer3.e);
        com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray(nalUnitTargetBuffer2.d, 0, nalUnitTargetBuffer2.e);
        parsableNalUnitBitArray.skipBits(44);
        int readBits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        parsableNalUnitBitArray.skipBits(88);
        parsableNalUnitBitArray.skipBits(8);
        int i2 = 0;
        for (int i3 = 0; i3 < readBits; i3++) {
            if (parsableNalUnitBitArray.readBit()) {
                i2 += 89;
            }
            if (parsableNalUnitBitArray.readBit()) {
                i2 += 8;
            }
        }
        parsableNalUnitBitArray.skipBits(i2);
        if (readBits > 0) {
            parsableNalUnitBitArray.skipBits((8 - readBits) * 2);
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt == 3) {
            parsableNalUnitBitArray.skipBit();
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            readUnsignedExpGolombCodedInt2 -= ((readUnsignedExpGolombCodedInt == 1 || readUnsignedExpGolombCodedInt == 2) ? 2 : 1) * (readUnsignedExpGolombCodedInt4 + readUnsignedExpGolombCodedInt5);
            readUnsignedExpGolombCodedInt3 -= (readUnsignedExpGolombCodedInt == 1 ? 2 : 1) * (readUnsignedExpGolombCodedInt6 + readUnsignedExpGolombCodedInt7);
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        for (int i4 = parsableNalUnitBitArray.readBit() ? 0 : readBits; i4 <= readBits; i4++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            e(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        f(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            for (int i5 = 0; i5 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i5++) {
                parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt8 + 4 + 1);
            }
        }
        parsableNalUnitBitArray.skipBits(2);
        float f = 1.0f;
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            int readBits2 = parsableNalUnitBitArray.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = parsableNalUnitBitArray.readBits(16);
                int readBits4 = parsableNalUnitBitArray.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f = readBits3 / readBits4;
                }
            } else {
                float[] fArr = com.google.android.exoplayer2.util.NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
                if (readBits2 < fArr.length) {
                    f = fArr[readBits2];
                } else {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(46);
                    sb.append("Unexpected aspect_ratio_idc value: ");
                    sb.append(readBits2);
                    com.google.android.exoplayer2.util.Log.w("H265Reader", sb.toString());
                }
            }
        }
        return new com.google.android.exoplayer2.Format.Builder().setId(str).setSampleMimeType("video/hevc").setWidth(readUnsignedExpGolombCodedInt2).setHeight(readUnsignedExpGolombCodedInt3).setPixelWidthHeightRatio(f).setInitializationData(java.util.Collections.singletonList(bArr)).build();
    }

    public static void e(com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (parsableNalUnitBitArray.readBit()) {
                    int min = java.lang.Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i4 = 0; i4 < min; i4++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                } else {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    public static void f(com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < readUnsignedExpGolombCodedInt; i2++) {
            if (i2 != 0) {
                z = parsableNalUnitBitArray.readBit();
            }
            if (z) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i3 = 0; i3 <= i; i3++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                    }
                }
            } else {
                int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int i4 = readUnsignedExpGolombCodedInt2 + readUnsignedExpGolombCodedInt3;
                for (int i5 = 0; i5 < readUnsignedExpGolombCodedInt2; i5++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                for (int i6 = 0; i6 < readUnsignedExpGolombCodedInt3; i6++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                i = i4;
            }
        }
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"output", "sampleReader"})
    public final void a() {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.c);
        com.google.android.exoplayer2.util.Util.castNonNull(this.d);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output", "sampleReader"})
    public final void b(long j, int i, int i2, long j2) {
        this.d.a(j, i, this.e);
        if (!this.e) {
            this.g.b(i2);
            this.h.b(i2);
            this.i.b(i2);
            if (this.g.c() && this.h.c() && this.i.c()) {
                this.c.format(d(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(i2)) {
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer = this.j;
            this.n.reset(this.j.d, com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(nalUnitTargetBuffer.d, nalUnitTargetBuffer.e));
            this.n.skipBytes(5);
            this.a.consume(j2, this.n);
        }
        if (this.k.b(i2)) {
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer2 = this.k;
            this.n.reset(this.k.d, com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.d, nalUnitTargetBuffer2.e));
            this.n.skipBytes(5);
            this.a.consume(j2, this.n);
        }
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"sampleReader"})
    public final void c(byte[] bArr, int i, int i2) {
        this.d.e(bArr, i, i2);
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        a();
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            byte[] data = parsableByteArray.getData();
            this.l += parsableByteArray.bytesLeft();
            this.c.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (position < limit) {
                int findNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(data, position, limit, this.f);
                if (findNalUnit == limit) {
                    c(data, position, limit);
                    return;
                }
                int h265NalUnitType = com.google.android.exoplayer2.util.NalUnitUtil.getH265NalUnitType(data, findNalUnit);
                int i = findNalUnit - position;
                if (i > 0) {
                    c(data, position, findNalUnit);
                }
                int i2 = limit - findNalUnit;
                long j = this.l - i2;
                b(j, i2, i < 0 ? -i : 0, this.m);
                g(j, i2, h265NalUnitType, this.m);
                position = findNalUnit + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.b = trackIdGenerator.getFormatId();
        com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.c = track;
        this.d = new com.google.android.exoplayer2.extractor.ts.H265Reader.SampleReader(track);
        this.a.createTracks(extractorOutput, trackIdGenerator);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"sampleReader"})
    public final void g(long j, int i, int i2, long j2) {
        this.d.g(j, i, i2, j2, this.e);
        if (!this.e) {
            this.g.e(i2);
            this.h.e(i2);
            this.i.e(i2);
        }
        this.j.e(i2);
        this.k.e(i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.m = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.l = 0L;
        com.google.android.exoplayer2.util.NalUnitUtil.clearPrefixFlags(this.f);
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        com.google.android.exoplayer2.extractor.ts.H265Reader.SampleReader sampleReader = this.d;
        if (sampleReader != null) {
            sampleReader.f();
        }
    }
}
