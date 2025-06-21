package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes22.dex */
public final class FlvExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.bh0();
    public com.google.android.exoplayer2.extractor.ExtractorOutput f;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader o;
    public com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader p;
    public final com.google.android.exoplayer2.util.ParsableByteArray a = new com.google.android.exoplayer2.util.ParsableByteArray(4);
    public final com.google.android.exoplayer2.util.ParsableByteArray b = new com.google.android.exoplayer2.util.ParsableByteArray(9);
    public final com.google.android.exoplayer2.util.ParsableByteArray c = new com.google.android.exoplayer2.util.ParsableByteArray(11);
    public final com.google.android.exoplayer2.util.ParsableByteArray d = new com.google.android.exoplayer2.util.ParsableByteArray();
    public final com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader e = new com.google.android.exoplayer2.extractor.flv.ScriptTagPayloadReader();
    public int g = 1;

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] d() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.flv.FlvExtractor()};
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    public final void b() {
        if (this.n) {
            return;
        }
        this.f.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L));
        this.n = true;
    }

    public final long c() {
        if (this.h) {
            return this.i + this.m;
        }
        if (this.e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.m;
    }

    public final com.google.android.exoplayer2.util.ParsableByteArray e(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (this.l > this.d.capacity()) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.d;
            parsableByteArray.reset(new byte[java.lang.Math.max(parsableByteArray.capacity() * 2, this.l)], 0);
        } else {
            this.d.setPosition(0);
        }
        this.d.setLimit(this.l);
        extractorInput.readFully(this.d.getData(), 0, this.l);
        return this.d;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    public final boolean f(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (!extractorInput.readFully(this.b.getData(), 0, 9, true)) {
            return false;
        }
        this.b.setPosition(0);
        this.b.skipBytes(4);
        int readUnsignedByte = this.b.readUnsignedByte();
        boolean z = (readUnsignedByte & 4) != 0;
        boolean z2 = (readUnsignedByte & 1) != 0;
        if (z && this.o == null) {
            this.o = new com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader(this.f.track(8, 1));
        }
        if (z2 && this.p == null) {
            this.p = new com.google.android.exoplayer2.extractor.flv.VideoTagPayloadReader(this.f.track(9, 2));
        }
        this.f.endTracks();
        this.j = (this.b.readInt() - 9) + 4;
        this.g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        boolean z;
        boolean z2;
        long c = c();
        int i = this.k;
        if (i == 8 && this.o != null) {
            b();
            z = this.o.a(e(extractorInput), c);
        } else if (i == 9 && this.p != null) {
            b();
            z = this.p.a(e(extractorInput), c);
        } else {
            if (i != 18 || this.n) {
                extractorInput.skipFully(this.l);
                z = false;
                z2 = false;
                if (!this.h && z) {
                    this.h = true;
                    this.i = this.e.d() != -9223372036854775807L ? -this.m : 0L;
                }
                this.j = 4;
                this.g = 2;
                return z2;
            }
            z = this.e.a(e(extractorInput), c);
            long d = this.e.d();
            if (d != -9223372036854775807L) {
                this.f.seekMap(new com.google.android.exoplayer2.extractor.IndexSeekMap(this.e.e(), this.e.f(), d));
                this.n = true;
            }
        }
        z2 = true;
        if (!this.h) {
            this.h = true;
            this.i = this.e.d() != -9223372036854775807L ? -this.m : 0L;
        }
        this.j = 4;
        this.g = 2;
        return z2;
    }

    public final boolean h(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (!extractorInput.readFully(this.c.getData(), 0, 11, true)) {
            return false;
        }
        this.c.setPosition(0);
        this.k = this.c.readUnsignedByte();
        this.l = this.c.readUnsignedInt24();
        this.m = this.c.readUnsignedInt24();
        this.m = ((this.c.readUnsignedByte() << 24) | this.m) * 1000;
        this.c.skipBytes(3);
        this.g = 4;
        return true;
    }

    public final void i(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.skipFully(this.j);
        this.j = 0;
        this.g = 3;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.f = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.f);
        while (true) {
            int i = this.g;
            if (i != 1) {
                if (i == 2) {
                    i(extractorInput);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new java.lang.IllegalStateException();
                    }
                    if (g(extractorInput)) {
                        return 0;
                    }
                } else if (!h(extractorInput)) {
                    return -1;
                }
            } else if (!f(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        if (j == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.peekFully(this.a.getData(), 0, 3);
        this.a.setPosition(0);
        if (this.a.readUnsignedInt24() != 4607062) {
            return false;
        }
        extractorInput.peekFully(this.a.getData(), 0, 2);
        this.a.setPosition(0);
        if ((this.a.readUnsignedShort() & 250) != 0) {
            return false;
        }
        extractorInput.peekFully(this.a.getData(), 0, 4);
        this.a.setPosition(0);
        int readInt = this.a.readInt();
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(readInt);
        extractorInput.peekFully(this.a.getData(), 0, 4);
        this.a.setPosition(0);
        return this.a.readInt() == 0;
    }
}
