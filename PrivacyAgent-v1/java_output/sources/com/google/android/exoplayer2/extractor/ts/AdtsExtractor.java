package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class AdtsExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.z7();
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public final int a;
    public final com.google.android.exoplayer2.extractor.ts.AdtsReader b;
    public final com.google.android.exoplayer2.util.ParsableByteArray c;
    public final com.google.android.exoplayer2.util.ParsableByteArray d;
    public final com.google.android.exoplayer2.util.ParsableBitArray e;
    public com.google.android.exoplayer2.extractor.ExtractorOutput f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public AdtsExtractor() {
        this(0);
    }

    public AdtsExtractor(int i) {
        this.a = i;
        this.b = new com.google.android.exoplayer2.extractor.ts.AdtsReader(true);
        this.c = new com.google.android.exoplayer2.util.ParsableByteArray(2048);
        this.i = -1;
        this.h = -1L;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(10);
        this.d = parsableByteArray;
        this.e = new com.google.android.exoplayer2.util.ParsableBitArray(parsableByteArray.getData());
    }

    public static int c(int i, long j) {
        return (int) (((i * 8) * 1000000) / j);
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] e() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ts.AdtsExtractor()};
    }

    public final void b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (this.j) {
            return;
        }
        this.i = -1;
        extractorInput.resetPeekPosition();
        long j = 0;
        if (extractorInput.getPosition() == 0) {
            g(extractorInput);
        }
        int i = 0;
        int i2 = 0;
        while (extractorInput.peekFully(this.d.getData(), 0, 2, true)) {
            try {
                this.d.setPosition(0);
                if (!com.google.android.exoplayer2.extractor.ts.AdtsReader.isAdtsSyncWord(this.d.readUnsignedShort())) {
                    break;
                }
                if (!extractorInput.peekFully(this.d.getData(), 0, 4, true)) {
                    break;
                }
                this.e.setPosition(14);
                int readBits = this.e.readBits(13);
                if (readBits <= 6) {
                    this.j = true;
                    throw new com.google.android.exoplayer2.ParserException("Malformed ADTS stream");
                }
                j += readBits;
                i2++;
                if (i2 != 1000 && extractorInput.advancePeekPosition(readBits - 6, true)) {
                }
                break;
            } catch (java.io.EOFException unused) {
            }
        }
        i = i2;
        extractorInput.resetPeekPosition();
        if (i > 0) {
            this.i = (int) (j / i);
        } else {
            this.i = -1;
        }
        this.j = true;
    }

    public final com.google.android.exoplayer2.extractor.SeekMap d(long j) {
        return new com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap(j, this.h, c(this.i, this.b.getSampleDurationUs()), this.i);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    public final void f(long j, boolean z, boolean z2) {
        if (this.l) {
            return;
        }
        boolean z3 = z && this.i > 0;
        if (z3 && this.b.getSampleDurationUs() == -9223372036854775807L && !z2) {
            return;
        }
        if (!z3 || this.b.getSampleDurationUs() == -9223372036854775807L) {
            this.f.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
        } else {
            this.f.seekMap(d(j));
        }
        this.l = true;
    }

    public final int g(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int i = 0;
        while (true) {
            extractorInput.peekFully(this.d.getData(), 0, 10);
            this.d.setPosition(0);
            if (this.d.readUnsignedInt24() != 4801587) {
                break;
            }
            this.d.skipBytes(3);
            int readSynchSafeInt = this.d.readSynchSafeInt();
            i += readSynchSafeInt + 10;
            extractorInput.advancePeekPosition(readSynchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.f = extractorOutput;
        this.b.createTracks(extractorOutput, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.f);
        long length = extractorInput.getLength();
        boolean z = ((this.a & 1) == 0 || length == -1) ? false : true;
        if (z) {
            b(extractorInput);
        }
        int read = extractorInput.read(this.c.getData(), 0, 2048);
        boolean z2 = read == -1;
        f(length, z, z2);
        if (z2) {
            return -1;
        }
        this.c.setPosition(0);
        this.c.setLimit(read);
        if (!this.k) {
            this.b.packetStarted(this.g, 4);
            this.k = true;
        }
        this.b.consume(this.c);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.k = false;
        this.b.seek();
        this.g = j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0023, code lost:
    
        r9.resetPeekPosition();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if ((r3 - r0) < 8192) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        return false;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int g = g(extractorInput);
        int i = g;
        while (true) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                extractorInput.peekFully(this.d.getData(), 0, 2);
                this.d.setPosition(0);
                if (!com.google.android.exoplayer2.extractor.ts.AdtsReader.isAdtsSyncWord(this.d.readUnsignedShort())) {
                    break;
                }
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                extractorInput.peekFully(this.d.getData(), 0, 4);
                this.e.setPosition(14);
                int readBits = this.e.readBits(13);
                if (readBits <= 6) {
                    return false;
                }
                extractorInput.advancePeekPosition(readBits - 6);
                i3 += readBits;
            }
            extractorInput.advancePeekPosition(i);
        }
    }
}
