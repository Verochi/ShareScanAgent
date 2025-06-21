package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class H264Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public final com.google.android.exoplayer2.extractor.ts.SeiReader a;
    public final boolean b;
    public final boolean c;
    public long g;
    public java.lang.String i;
    public com.google.android.exoplayer2.extractor.TrackOutput j;
    public com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader k;
    public boolean l;
    public long m;
    public boolean n;
    public final boolean[] h = new boolean[3];
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer d = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(7, 128);
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer e = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(8, 128);
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer f = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(6, 128);
    public final com.google.android.exoplayer2.util.ParsableByteArray o = new com.google.android.exoplayer2.util.ParsableByteArray();

    public static final class SampleReader {
        public final com.google.android.exoplayer2.extractor.TrackOutput a;
        public final boolean b;
        public final boolean c;
        public final com.google.android.exoplayer2.util.ParsableNalUnitBitArray f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public boolean k;
        public long l;
        public boolean o;
        public long p;
        public long q;
        public boolean r;
        public final android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil.SpsData> d = new android.util.SparseArray<>();
        public final android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil.PpsData> e = new android.util.SparseArray<>();
        public com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData m = new com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData(null);
        public com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData n = new com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData(null);

        public static final class SliceHeaderData {
            public boolean a;
            public boolean b;

            @androidx.annotation.Nullable
            public com.google.android.exoplayer2.util.NalUnitUtil.SpsData c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public SliceHeaderData() {
            }

            public /* synthetic */ SliceHeaderData(com.google.android.exoplayer2.extractor.ts.H264Reader.AnonymousClass1 anonymousClass1) {
                this();
            }

            public void b() {
                this.b = false;
                this.a = false;
            }

            public final boolean c(com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData sliceHeaderData) {
                int i;
                int i2;
                int i3;
                boolean z;
                if (!this.a) {
                    return false;
                }
                if (!sliceHeaderData.a) {
                    return true;
                }
                com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData = (com.google.android.exoplayer2.util.NalUnitUtil.SpsData) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.c);
                com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData2 = (com.google.android.exoplayer2.util.NalUnitUtil.SpsData) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(sliceHeaderData.c);
                return (this.f == sliceHeaderData.f && this.g == sliceHeaderData.g && this.h == sliceHeaderData.h && (!this.i || !sliceHeaderData.i || this.j == sliceHeaderData.j) && (((i = this.d) == (i2 = sliceHeaderData.d) || (i != 0 && i2 != 0)) && (((i3 = spsData.picOrderCountType) != 0 || spsData2.picOrderCountType != 0 || (this.m == sliceHeaderData.m && this.n == sliceHeaderData.n)) && ((i3 != 1 || spsData2.picOrderCountType != 1 || (this.o == sliceHeaderData.o && this.p == sliceHeaderData.p)) && (z = this.k) == sliceHeaderData.k && (!z || this.l == sliceHeaderData.l))))) ? false : true;
            }

            public boolean d() {
                int i;
                return this.b && ((i = this.e) == 7 || i == 2);
            }

            public void e(com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.c = spsData;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.a = true;
                this.b = true;
            }

            public void f(int i) {
                this.e = i;
                this.b = true;
            }
        }

        public SampleReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, boolean z, boolean z2) {
            this.a = trackOutput;
            this.b = z;
            this.c = z2;
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0102  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int readSignedExpGolombCodedInt;
            if (this.k) {
                int i8 = i2 - i;
                byte[] bArr2 = this.g;
                int length = bArr2.length;
                int i9 = this.h;
                if (length < i9 + i8) {
                    this.g = java.util.Arrays.copyOf(bArr2, (i9 + i8) * 2);
                }
                java.lang.System.arraycopy(bArr, i, this.g, this.h, i8);
                int i10 = this.h + i8;
                this.h = i10;
                this.f.reset(this.g, 0, i10);
                if (this.f.canReadBits(8)) {
                    this.f.skipBit();
                    int readBits = this.f.readBits(2);
                    this.f.skipBits(5);
                    if (this.f.canReadExpGolombCodedNum()) {
                        this.f.readUnsignedExpGolombCodedInt();
                        if (this.f.canReadExpGolombCodedNum()) {
                            int readUnsignedExpGolombCodedInt = this.f.readUnsignedExpGolombCodedInt();
                            if (!this.c) {
                                this.k = false;
                                this.n.f(readUnsignedExpGolombCodedInt);
                                return;
                            }
                            if (this.f.canReadExpGolombCodedNum()) {
                                int readUnsignedExpGolombCodedInt2 = this.f.readUnsignedExpGolombCodedInt();
                                if (this.e.indexOfKey(readUnsignedExpGolombCodedInt2) < 0) {
                                    this.k = false;
                                    return;
                                }
                                com.google.android.exoplayer2.util.NalUnitUtil.PpsData ppsData = this.e.get(readUnsignedExpGolombCodedInt2);
                                com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData = this.d.get(ppsData.seqParameterSetId);
                                if (spsData.separateColorPlaneFlag) {
                                    if (!this.f.canReadBits(2)) {
                                        return;
                                    } else {
                                        this.f.skipBits(2);
                                    }
                                }
                                if (this.f.canReadBits(spsData.frameNumLength)) {
                                    int readBits2 = this.f.readBits(spsData.frameNumLength);
                                    if (spsData.frameMbsOnlyFlag) {
                                        z = false;
                                    } else {
                                        if (!this.f.canReadBits(1)) {
                                            return;
                                        }
                                        boolean readBit = this.f.readBit();
                                        if (readBit) {
                                            if (this.f.canReadBits(1)) {
                                                z = readBit;
                                                z3 = this.f.readBit();
                                                z2 = true;
                                                z4 = this.i != 5;
                                                if (z4) {
                                                    i3 = 0;
                                                } else if (!this.f.canReadExpGolombCodedNum()) {
                                                    return;
                                                } else {
                                                    i3 = this.f.readUnsignedExpGolombCodedInt();
                                                }
                                                i4 = spsData.picOrderCountType;
                                                if (i4 != 0) {
                                                    if (!this.f.canReadBits(spsData.picOrderCntLsbLength)) {
                                                        return;
                                                    }
                                                    int readBits3 = this.f.readBits(spsData.picOrderCntLsbLength);
                                                    if (ppsData.bottomFieldPicOrderInFramePresentFlag && !z) {
                                                        if (this.f.canReadExpGolombCodedNum()) {
                                                            i7 = this.f.readSignedExpGolombCodedInt();
                                                            i5 = readBits3;
                                                            i6 = 0;
                                                            readSignedExpGolombCodedInt = 0;
                                                            this.n.e(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i5 = readBits3;
                                                } else {
                                                    if (i4 == 1 && !spsData.deltaPicOrderAlwaysZeroFlag) {
                                                        if (this.f.canReadExpGolombCodedNum()) {
                                                            int readSignedExpGolombCodedInt2 = this.f.readSignedExpGolombCodedInt();
                                                            if (!ppsData.bottomFieldPicOrderInFramePresentFlag || z) {
                                                                i6 = readSignedExpGolombCodedInt2;
                                                                i5 = 0;
                                                                i7 = 0;
                                                                readSignedExpGolombCodedInt = 0;
                                                                this.n.e(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                                                this.k = false;
                                                            }
                                                            if (this.f.canReadExpGolombCodedNum()) {
                                                                readSignedExpGolombCodedInt = this.f.readSignedExpGolombCodedInt();
                                                                i6 = readSignedExpGolombCodedInt2;
                                                                i5 = 0;
                                                                i7 = 0;
                                                                this.n.e(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                                                this.k = false;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    i5 = 0;
                                                }
                                                i7 = 0;
                                                i6 = 0;
                                                readSignedExpGolombCodedInt = 0;
                                                this.n.e(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                                this.k = false;
                                            }
                                            return;
                                        }
                                        z = readBit;
                                    }
                                    z2 = false;
                                    z3 = false;
                                    if (this.i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i4 = spsData.picOrderCountType;
                                    if (i4 != 0) {
                                    }
                                    i7 = 0;
                                    i6 = 0;
                                    readSignedExpGolombCodedInt = 0;
                                    this.n.e(spsData, readBits, readUnsignedExpGolombCodedInt, readBits2, readUnsignedExpGolombCodedInt2, z, z2, z3, z4, i3, i5, i7, i6, readSignedExpGolombCodedInt);
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean b(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.i == 9 || (this.c && this.n.c(this.m))) {
                if (z && this.o) {
                    d(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            if (this.b) {
                z2 = this.n.d();
            }
            boolean z4 = this.r;
            int i2 = this.i;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.r = z5;
            return z5;
        }

        public boolean c() {
            return this.c;
        }

        public final void d(int i) {
            boolean z = this.r;
            this.a.sampleMetadata(this.q, z ? 1 : 0, (int) (this.j - this.p), i, null);
        }

        public void e(com.google.android.exoplayer2.util.NalUnitUtil.PpsData ppsData) {
            this.e.append(ppsData.picParameterSetId, ppsData);
        }

        public void f(com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData) {
            this.d.append(spsData.seqParameterSetId, spsData);
        }

        public void g() {
            this.k = false;
            this.o = false;
            this.n.b();
        }

        public void h(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.b || i != 1) {
                if (!this.c) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData sliceHeaderData = this.m;
            this.m = this.n;
            this.n = sliceHeaderData;
            sliceHeaderData.b();
            this.h = 0;
            this.k = true;
        }
    }

    public H264Reader(com.google.android.exoplayer2.extractor.ts.SeiReader seiReader, boolean z, boolean z2) {
        this.a = seiReader;
        this.b = z;
        this.c = z2;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"output", "sampleReader"})
    public final void a() {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.j);
        com.google.android.exoplayer2.util.Util.castNonNull(this.k);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output", "sampleReader"})
    public final void b(long j, int i, int i2, long j2) {
        if (!this.l || this.k.c()) {
            this.d.b(i2);
            this.e.b(i2);
            if (this.l) {
                if (this.d.c()) {
                    com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer = this.d;
                    this.k.f(com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer.d, 3, nalUnitTargetBuffer.e));
                    this.d.d();
                } else if (this.e.c()) {
                    com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer2 = this.e;
                    this.k.e(com.google.android.exoplayer2.util.NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer2.d, 3, nalUnitTargetBuffer2.e));
                    this.e.d();
                }
            } else if (this.d.c() && this.e.c()) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer3 = this.d;
                arrayList.add(java.util.Arrays.copyOf(nalUnitTargetBuffer3.d, nalUnitTargetBuffer3.e));
                com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer4 = this.e;
                arrayList.add(java.util.Arrays.copyOf(nalUnitTargetBuffer4.d, nalUnitTargetBuffer4.e));
                com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer5 = this.d;
                com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer5.d, 3, nalUnitTargetBuffer5.e);
                com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer6 = this.e;
                com.google.android.exoplayer2.util.NalUnitUtil.PpsData parsePpsNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer6.d, 3, nalUnitTargetBuffer6.e);
                this.j.format(new com.google.android.exoplayer2.Format.Builder().setId(this.i).setSampleMimeType("video/avc").setCodecs(com.google.android.exoplayer2.util.CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc)).setWidth(parseSpsNalUnit.width).setHeight(parseSpsNalUnit.height).setPixelWidthHeightRatio(parseSpsNalUnit.pixelWidthAspectRatio).setInitializationData(arrayList).build());
                this.l = true;
                this.k.f(parseSpsNalUnit);
                this.k.e(parsePpsNalUnit);
                this.d.d();
                this.e.d();
            }
        }
        if (this.f.b(i2)) {
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer7 = this.f;
            this.o.reset(this.f.d, com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(nalUnitTargetBuffer7.d, nalUnitTargetBuffer7.e));
            this.o.setPosition(4);
            this.a.consume(j2, this.o);
        }
        if (this.k.b(j, i, this.l, this.n)) {
            this.n = false;
        }
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"sampleReader"})
    public final void c(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.c()) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        a();
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.g += parsableByteArray.bytesLeft();
        this.j.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(data, position, limit, this.h);
            if (findNalUnit == limit) {
                c(data, position, limit);
                return;
            }
            int nalUnitType = com.google.android.exoplayer2.util.NalUnitUtil.getNalUnitType(data, findNalUnit);
            int i = findNalUnit - position;
            if (i > 0) {
                c(data, position, findNalUnit);
            }
            int i2 = limit - findNalUnit;
            long j = this.g - i2;
            b(j, i2, i < 0 ? -i : 0, this.m);
            d(j, nalUnitType, this.m);
            position = findNalUnit + 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.i = trackIdGenerator.getFormatId();
        com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.j = track;
        this.k = new com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader(track, this.b, this.c);
        this.a.createTracks(extractorOutput, trackIdGenerator);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"sampleReader"})
    public final void d(long j, int i, long j2) {
        if (!this.l || this.k.c()) {
            this.d.e(i);
            this.e.e(i);
        }
        this.f.e(i);
        this.k.h(j, i, j2);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.m = j;
        this.n |= (i & 2) != 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.g = 0L;
        this.n = false;
        com.google.android.exoplayer2.util.NalUnitUtil.clearPrefixFlags(this.h);
        this.d.d();
        this.e.d();
        this.f.d();
        com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader sampleReader = this.k;
        if (sampleReader != null) {
            sampleReader.g();
        }
    }
}
