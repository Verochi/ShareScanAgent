package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class H262Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public java.lang.String a;
    public com.google.android.exoplayer2.extractor.TrackOutput b;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.ts.UserDataReader c;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.util.ParsableByteArray d;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer e;
    public final boolean[] f;
    public final com.google.android.exoplayer2.extractor.ts.H262Reader.CsdBuffer g;
    public long h;
    public boolean i;
    public boolean j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;

    public static final class CsdBuffer {
        public static final byte[] e = {0, 0, 1};
        public boolean a;
        public int b;
        public int c;
        public byte[] d;

        public CsdBuffer(int i) {
            this.d = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.b;
                if (length < i4 + i3) {
                    this.d = java.util.Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                java.lang.System.arraycopy(bArr, i, this.d, this.b, i3);
                this.b += i3;
            }
        }

        public boolean b(int i, int i2) {
            if (this.a) {
                int i3 = this.b - i2;
                this.b = i3;
                if (this.c != 0 || i != 181) {
                    this.a = false;
                    return true;
                }
                this.c = i3;
            } else if (i == 179) {
                this.a = true;
            }
            byte[] bArr = e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.a = false;
            this.b = 0;
            this.c = 0;
        }
    }

    public H262Reader() {
        this(null);
    }

    public H262Reader(@androidx.annotation.Nullable com.google.android.exoplayer2.extractor.ts.UserDataReader userDataReader) {
        this.c = userDataReader;
        this.f = new boolean[4];
        this.g = new com.google.android.exoplayer2.extractor.ts.H262Reader.CsdBuffer(128);
        if (userDataReader != null) {
            this.e = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(178, 128);
            this.d = new com.google.android.exoplayer2.util.ParsableByteArray();
        } else {
            this.e = null;
            this.d = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> a(com.google.android.exoplayer2.extractor.ts.H262Reader.CsdBuffer csdBuffer, java.lang.String str) {
        float f;
        int i;
        float f2;
        int i2;
        long j;
        byte[] copyOf = java.util.Arrays.copyOf(csdBuffer.d, csdBuffer.b);
        int i3 = copyOf[4] & 255;
        int i4 = copyOf[5] & 255;
        int i5 = (i3 << 4) | (i4 >> 4);
        int i6 = ((i4 & 15) << 8) | (copyOf[6] & 255);
        int i7 = (copyOf[7] & 240) >> 4;
        if (i7 == 2) {
            f = i6 * 4;
            i = i5 * 3;
        } else if (i7 == 3) {
            f = i6 * 16;
            i = i5 * 9;
        } else {
            if (i7 != 4) {
                f2 = 1.0f;
                com.google.android.exoplayer2.Format build = new com.google.android.exoplayer2.Format.Builder().setId(str).setSampleMimeType("video/mpeg2").setWidth(i5).setHeight(i6).setPixelWidthHeightRatio(f2).setInitializationData(java.util.Collections.singletonList(copyOf)).build();
                i2 = (copyOf[7] & 15) - 1;
                if (i2 >= 0) {
                    double[] dArr = q;
                    if (i2 < dArr.length) {
                        double d = dArr[i2];
                        byte b = copyOf[csdBuffer.c + 9];
                        int i8 = (b & 96) >> 5;
                        if (i8 != (b & com.google.common.base.Ascii.US)) {
                            d *= (i8 + 1.0d) / (r8 + 1);
                        }
                        j = (long) (1000000.0d / d);
                        return android.util.Pair.create(build, java.lang.Long.valueOf(j));
                    }
                }
                j = 0;
                return android.util.Pair.create(build, java.lang.Long.valueOf(j));
            }
            f = i6 * 121;
            i = i5 * 100;
        }
        f2 = f / i;
        com.google.android.exoplayer2.Format build2 = new com.google.android.exoplayer2.Format.Builder().setId(str).setSampleMimeType("video/mpeg2").setWidth(i5).setHeight(i6).setPixelWidthHeightRatio(f2).setInitializationData(java.util.Collections.singletonList(copyOf)).build();
        i2 = (copyOf[7] & 15) - 1;
        if (i2 >= 0) {
        }
        j = 0;
        return android.util.Pair.create(build2, java.lang.Long.valueOf(j));
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i;
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.b);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.h += parsableByteArray.bytesLeft();
        this.b.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(data, position, limit, this.f);
            if (findNalUnit == limit) {
                break;
            }
            int i2 = findNalUnit + 3;
            int i3 = parsableByteArray.getData()[i2] & 255;
            int i4 = findNalUnit - position;
            if (!this.j) {
                if (i4 > 0) {
                    this.g.a(data, position, findNalUnit);
                }
                if (this.g.b(i3, i4 < 0 ? -i4 : 0)) {
                    android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> a = a(this.g, (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.a));
                    this.b.format((com.google.android.exoplayer2.Format) a.first);
                    this.k = ((java.lang.Long) a.second).longValue();
                    this.j = true;
                }
            }
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer = this.e;
            if (nalUnitTargetBuffer != null) {
                if (i4 > 0) {
                    nalUnitTargetBuffer.a(data, position, findNalUnit);
                    i = 0;
                } else {
                    i = -i4;
                }
                if (this.e.b(i)) {
                    com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer2 = this.e;
                    ((com.google.android.exoplayer2.util.ParsableByteArray) com.google.android.exoplayer2.util.Util.castNonNull(this.d)).reset(this.e.d, com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.d, nalUnitTargetBuffer2.e));
                    ((com.google.android.exoplayer2.extractor.ts.UserDataReader) com.google.android.exoplayer2.util.Util.castNonNull(this.c)).a(this.n, this.d);
                }
                if (i3 == 178 && parsableByteArray.getData()[findNalUnit + 2] == 1) {
                    this.e.e(i3);
                }
            }
            if (i3 == 0 || i3 == 179) {
                int i5 = limit - findNalUnit;
                if (this.i && this.p && this.j) {
                    this.b.sampleMetadata(this.n, this.o ? 1 : 0, ((int) (this.h - this.m)) - i5, i5, null);
                }
                boolean z = this.i;
                if (!z || this.p) {
                    this.m = this.h - i5;
                    long j = this.l;
                    if (j == -9223372036854775807L) {
                        j = z ? this.n + this.k : 0L;
                    }
                    this.n = j;
                    this.o = false;
                    this.l = -9223372036854775807L;
                    this.i = true;
                }
                this.p = i3 == 0;
            } else if (i3 == 184) {
                this.o = true;
            }
            position = i2;
        }
        if (!this.j) {
            this.g.a(data, position, limit);
        }
        com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer3 = this.e;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.a(data, position, limit);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.a = trackIdGenerator.getFormatId();
        this.b = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        com.google.android.exoplayer2.extractor.ts.UserDataReader userDataReader = this.c;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.l = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        com.google.android.exoplayer2.util.NalUnitUtil.clearPrefixFlags(this.f);
        this.g.c();
        com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer = this.e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.h = 0L;
        this.i = false;
    }
}
