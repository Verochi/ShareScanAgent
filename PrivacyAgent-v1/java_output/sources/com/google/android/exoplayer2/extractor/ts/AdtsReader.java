package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class AdtsReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    public static final byte[] v = {73, 68, org.apache.tools.tar.TarConstants.LF_CHR};
    public final boolean a;
    public final com.google.android.exoplayer2.util.ParsableBitArray b;
    public final com.google.android.exoplayer2.util.ParsableByteArray c;

    @androidx.annotation.Nullable
    public final java.lang.String d;
    public java.lang.String e;
    public com.google.android.exoplayer2.extractor.TrackOutput f;
    public com.google.android.exoplayer2.extractor.TrackOutput g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public long f354s;
    public com.google.android.exoplayer2.extractor.TrackOutput t;
    public long u;

    public AdtsReader(boolean z) {
        this(z, null);
    }

    public AdtsReader(boolean z, @androidx.annotation.Nullable java.lang.String str) {
        this.b = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[7]);
        this.c = new com.google.android.exoplayer2.util.ParsableByteArray(java.util.Arrays.copyOf(v, 10));
        l();
        this.m = -1;
        this.n = -1;
        this.q = -9223372036854775807L;
        this.a = z;
        this.d = str;
    }

    public static boolean isAdtsSyncWord(int i) {
        return (i & 65526) == 65520;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"output", "currentOutput", "id3Output"})
    public final void a() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f);
        com.google.android.exoplayer2.util.Util.castNonNull(this.t);
        com.google.android.exoplayer2.util.Util.castNonNull(this.g);
    }

    public final void b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() == 0) {
            return;
        }
        this.b.data[0] = parsableByteArray.getData()[parsableByteArray.getPosition()];
        this.b.setPosition(2);
        int readBits = this.b.readBits(4);
        int i = this.n;
        if (i != -1 && readBits != i) {
            j();
            return;
        }
        if (!this.l) {
            this.l = true;
            this.m = this.o;
            this.n = readBits;
        }
        m();
    }

    public final boolean c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 1);
        if (!p(parsableByteArray, this.b.data, 1)) {
            return false;
        }
        this.b.setPosition(4);
        int readBits = this.b.readBits(1);
        int i2 = this.m;
        if (i2 != -1 && readBits != i2) {
            return false;
        }
        if (this.n != -1) {
            if (!p(parsableByteArray, this.b.data, 1)) {
                return true;
            }
            this.b.setPosition(2);
            if (this.b.readBits(4) != this.n) {
                return false;
            }
            parsableByteArray.setPosition(i + 2);
        }
        if (!p(parsableByteArray, this.b.data, 4)) {
            return true;
        }
        this.b.setPosition(14);
        int readBits2 = this.b.readBits(13);
        if (readBits2 < 7) {
            return false;
        }
        byte[] data = parsableByteArray.getData();
        int limit = parsableByteArray.limit();
        int i3 = i + readBits2;
        if (i3 >= limit) {
            return true;
        }
        byte b = data[i3];
        if (b == -1) {
            int i4 = i3 + 1;
            if (i4 == limit) {
                return true;
            }
            return f((byte) -1, data[i4]) && ((data[i4] & 8) >> 3) == readBits;
        }
        if (b != 73) {
            return false;
        }
        int i5 = i3 + 1;
        if (i5 == limit) {
            return true;
        }
        if (data[i5] != 68) {
            return false;
        }
        int i6 = i3 + 2;
        return i6 == limit || data[i6] == 51;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        a();
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.h;
            if (i == 0) {
                e(parsableByteArray);
            } else if (i == 1) {
                b(parsableByteArray);
            } else if (i != 2) {
                if (i == 3) {
                    if (d(parsableByteArray, this.b.data, this.k ? 7 : 5)) {
                        g();
                    }
                } else {
                    if (i != 4) {
                        throw new java.lang.IllegalStateException();
                    }
                    i(parsableByteArray);
                }
            } else if (d(parsableByteArray, this.c.getData(), 10)) {
                h();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.e = trackIdGenerator.getFormatId();
        com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.f = track;
        this.t = track;
        if (!this.a) {
            this.g = new com.google.android.exoplayer2.extractor.DummyTrackOutput();
            return;
        }
        trackIdGenerator.generateNewId();
        com.google.android.exoplayer2.extractor.TrackOutput track2 = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
        this.g = track2;
        track2.format(new com.google.android.exoplayer2.Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType("application/id3").build());
    }

    public final boolean d(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), i - this.i);
        parsableByteArray.readBytes(bArr, this.i, min);
        int i2 = this.i + min;
        this.i = i2;
        return i2 == i;
    }

    public final void e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        byte[] data = parsableByteArray.getData();
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit) {
            int i = position + 1;
            int i2 = data[position] & 255;
            if (this.j == 512 && f((byte) -1, (byte) i2) && (this.l || c(parsableByteArray, i - 2))) {
                this.o = (i2 & 8) >> 3;
                this.k = (i2 & 1) == 0;
                if (this.l) {
                    m();
                } else {
                    k();
                }
                parsableByteArray.setPosition(i);
                return;
            }
            int i3 = this.j;
            int i4 = i2 | i3;
            if (i4 == 329) {
                this.j = 768;
            } else if (i4 == 511) {
                this.j = 512;
            } else if (i4 == 836) {
                this.j = 1024;
            } else if (i4 == 1075) {
                n();
                parsableByteArray.setPosition(i);
                return;
            } else if (i3 != 256) {
                this.j = 256;
                i--;
            }
            position = i;
        }
        parsableByteArray.setPosition(position);
    }

    public final boolean f(byte b, byte b2) {
        return isAdtsSyncWord(((b & 255) << 8) | (b2 & 255));
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void g() throws com.google.android.exoplayer2.ParserException {
        this.b.setPosition(0);
        if (this.p) {
            this.b.skipBits(10);
        } else {
            int readBits = this.b.readBits(2) + 1;
            if (readBits != 2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(61);
                sb.append("Detected audio object type: ");
                sb.append(readBits);
                sb.append(", but assuming AAC LC.");
                com.google.android.exoplayer2.util.Log.w("AdtsReader", sb.toString());
                readBits = 2;
            }
            this.b.skipBits(5);
            byte[] buildAudioSpecificConfig = com.google.android.exoplayer2.audio.AacUtil.buildAudioSpecificConfig(readBits, this.n, this.b.readBits(3));
            com.google.android.exoplayer2.audio.AacUtil.Config parseAudioSpecificConfig = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(buildAudioSpecificConfig);
            com.google.android.exoplayer2.Format build = new com.google.android.exoplayer2.Format.Builder().setId(this.e).setSampleMimeType("audio/mp4a-latm").setCodecs(parseAudioSpecificConfig.codecs).setChannelCount(parseAudioSpecificConfig.channelCount).setSampleRate(parseAudioSpecificConfig.sampleRateHz).setInitializationData(java.util.Collections.singletonList(buildAudioSpecificConfig)).setLanguage(this.d).build();
            this.q = 1024000000 / build.sampleRate;
            this.f.format(build);
            this.p = true;
        }
        this.b.skipBits(4);
        int readBits2 = (this.b.readBits(13) - 2) - 5;
        if (this.k) {
            readBits2 -= 2;
        }
        o(this.f, this.q, 0, readBits2);
    }

    public long getSampleDurationUs() {
        return this.q;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"id3Output"})
    public final void h() {
        this.g.sampleData(this.c, 10);
        this.c.setPosition(6);
        o(this.g, 0L, 10, this.c.readSynchSafeInt() + 10);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"currentOutput"})
    public final void i(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int min = java.lang.Math.min(parsableByteArray.bytesLeft(), this.r - this.i);
        this.t.sampleData(parsableByteArray, min);
        int i = this.i + min;
        this.i = i;
        int i2 = this.r;
        if (i == i2) {
            this.t.sampleMetadata(this.f354s, 1, i2, 0, null);
            this.f354s += this.u;
            l();
        }
    }

    public final void j() {
        this.l = false;
        l();
    }

    public final void k() {
        this.h = 1;
        this.i = 0;
    }

    public final void l() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    public final void m() {
        this.h = 3;
        this.i = 0;
    }

    public final void n() {
        this.h = 2;
        this.i = v.length;
        this.r = 0;
        this.c.setPosition(0);
    }

    public final void o(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, long j, int i, int i2) {
        this.h = 4;
        this.i = i;
        this.t = trackOutput;
        this.u = j;
        this.r = i2;
    }

    public final boolean p(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        if (parsableByteArray.bytesLeft() < i) {
            return false;
        }
        parsableByteArray.readBytes(bArr, 0, i);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.f354s = j;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        j();
    }
}
