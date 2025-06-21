package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class LatmReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {

    @androidx.annotation.Nullable
    public final java.lang.String a;
    public final com.google.android.exoplayer2.util.ParsableByteArray b;
    public final com.google.android.exoplayer2.util.ParsableBitArray c;
    public com.google.android.exoplayer2.extractor.TrackOutput d;
    public java.lang.String e;
    public com.google.android.exoplayer2.Format f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public long f355s;
    public int t;

    @androidx.annotation.Nullable
    public java.lang.String u;

    public LatmReader(@androidx.annotation.Nullable java.lang.String str) {
        this.a = str;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(1024);
        this.b = parsableByteArray;
        this.c = new com.google.android.exoplayer2.util.ParsableBitArray(parsableByteArray.getData());
    }

    public static long a(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        return parsableBitArray.readBits((parsableBitArray.readBits(2) + 1) * 8);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void b(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) throws com.google.android.exoplayer2.ParserException {
        if (!parsableBitArray.readBit()) {
            this.l = true;
            g(parsableBitArray);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw new com.google.android.exoplayer2.ParserException();
        }
        if (this.n != 0) {
            throw new com.google.android.exoplayer2.ParserException();
        }
        f(parsableBitArray, e(parsableBitArray));
        if (this.p) {
            parsableBitArray.skipBits((int) this.q);
        }
    }

    public final int c(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) throws com.google.android.exoplayer2.ParserException {
        int bitsLeft = parsableBitArray.bitsLeft();
        com.google.android.exoplayer2.audio.AacUtil.Config parseAudioSpecificConfig = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(parsableBitArray, true);
        this.u = parseAudioSpecificConfig.codecs;
        this.r = parseAudioSpecificConfig.sampleRateHz;
        this.t = parseAudioSpecificConfig.channelCount;
        return bitsLeft - parsableBitArray.bitsLeft();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.d);
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.g;
            if (i != 0) {
                if (i == 1) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    if ((readUnsignedByte & 224) == 224) {
                        this.j = readUnsignedByte;
                        this.g = 2;
                    } else if (readUnsignedByte != 86) {
                        this.g = 0;
                    }
                } else if (i == 2) {
                    int readUnsignedByte2 = ((this.j & (-225)) << 8) | parsableByteArray.readUnsignedByte();
                    this.i = readUnsignedByte2;
                    if (readUnsignedByte2 > this.b.getData().length) {
                        h(this.i);
                    }
                    this.h = 0;
                    this.g = 3;
                } else {
                    if (i != 3) {
                        throw new java.lang.IllegalStateException();
                    }
                    int min = java.lang.Math.min(parsableByteArray.bytesLeft(), this.i - this.h);
                    parsableByteArray.readBytes(this.c.data, this.h, min);
                    int i2 = this.h + min;
                    this.h = i2;
                    if (i2 == this.i) {
                        this.c.setPosition(0);
                        b(this.c);
                        this.g = 0;
                    }
                }
            } else if (parsableByteArray.readUnsignedByte() == 86) {
                this.g = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.d = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.e = trackIdGenerator.getFormatId();
    }

    public final void d(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(3);
        this.o = readBits;
        if (readBits == 0) {
            parsableBitArray.skipBits(8);
            return;
        }
        if (readBits == 1) {
            parsableBitArray.skipBits(9);
            return;
        }
        if (readBits == 3 || readBits == 4 || readBits == 5) {
            parsableBitArray.skipBits(6);
        } else {
            if (readBits != 6 && readBits != 7) {
                throw new java.lang.IllegalStateException();
            }
            parsableBitArray.skipBits(1);
        }
    }

    public final int e(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) throws com.google.android.exoplayer2.ParserException {
        int readBits;
        if (this.o != 0) {
            throw new com.google.android.exoplayer2.ParserException();
        }
        int i = 0;
        do {
            readBits = parsableBitArray.readBits(8);
            i += readBits;
        } while (readBits == 255);
        return i;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void f(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i) {
        int position = parsableBitArray.getPosition();
        if ((position & 7) == 0) {
            this.b.setPosition(position >> 3);
        } else {
            parsableBitArray.readBits(this.b.getData(), 0, i * 8);
            this.b.setPosition(0);
        }
        this.d.sampleData(this.b, i);
        this.d.sampleMetadata(this.k, 1, i, 0, null);
        this.k += this.f355s;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void g(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) throws com.google.android.exoplayer2.ParserException {
        boolean readBit;
        int readBits = parsableBitArray.readBits(1);
        int readBits2 = readBits == 1 ? parsableBitArray.readBits(1) : 0;
        this.m = readBits2;
        if (readBits2 != 0) {
            throw new com.google.android.exoplayer2.ParserException();
        }
        if (readBits == 1) {
            a(parsableBitArray);
        }
        if (!parsableBitArray.readBit()) {
            throw new com.google.android.exoplayer2.ParserException();
        }
        this.n = parsableBitArray.readBits(6);
        int readBits3 = parsableBitArray.readBits(4);
        int readBits4 = parsableBitArray.readBits(3);
        if (readBits3 != 0 || readBits4 != 0) {
            throw new com.google.android.exoplayer2.ParserException();
        }
        if (readBits == 0) {
            int position = parsableBitArray.getPosition();
            int c = c(parsableBitArray);
            parsableBitArray.setPosition(position);
            byte[] bArr = new byte[(c + 7) / 8];
            parsableBitArray.readBits(bArr, 0, c);
            com.google.android.exoplayer2.Format build = new com.google.android.exoplayer2.Format.Builder().setId(this.e).setSampleMimeType("audio/mp4a-latm").setCodecs(this.u).setChannelCount(this.t).setSampleRate(this.r).setInitializationData(java.util.Collections.singletonList(bArr)).setLanguage(this.a).build();
            if (!build.equals(this.f)) {
                this.f = build;
                this.f355s = 1024000000 / build.sampleRate;
                this.d.format(build);
            }
        } else {
            parsableBitArray.skipBits(((int) a(parsableBitArray)) - c(parsableBitArray));
        }
        d(parsableBitArray);
        boolean readBit2 = parsableBitArray.readBit();
        this.p = readBit2;
        this.q = 0L;
        if (readBit2) {
            if (readBits == 1) {
                this.q = a(parsableBitArray);
            } else {
                do {
                    readBit = parsableBitArray.readBit();
                    this.q = (this.q << 8) + parsableBitArray.readBits(8);
                } while (readBit);
            }
        }
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(8);
        }
    }

    public final void h(int i) {
        this.b.reset(i);
        this.c.reset(this.b.getData());
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
        this.g = 0;
        this.l = false;
    }
}
