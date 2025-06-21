package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
abstract class StreamReader {
    public final com.google.android.exoplayer2.extractor.ogg.OggPacket a = new com.google.android.exoplayer2.extractor.ogg.OggPacket();
    public com.google.android.exoplayer2.extractor.TrackOutput b;
    public com.google.android.exoplayer2.extractor.ExtractorOutput c;
    public com.google.android.exoplayer2.extractor.ogg.OggSeeker d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData j;
    public long k;
    public boolean l;
    public boolean m;

    public static class SetupData {
        public com.google.android.exoplayer2.Format a;
        public com.google.android.exoplayer2.extractor.ogg.OggSeeker b;
    }

    public static final class UnseekableOggSeeker implements com.google.android.exoplayer2.extractor.ogg.OggSeeker {
        public UnseekableOggSeeker() {
        }

        public /* synthetic */ UnseekableOggSeeker(com.google.android.exoplayer2.extractor.ogg.StreamReader.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public com.google.android.exoplayer2.extractor.SeekMap a() {
            return new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L);
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void b(long j) {
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) {
            return -1L;
        }
    }

    public long a(long j) {
        return (j * 1000000) / this.i;
    }

    public long b(long j) {
        return (this.i * j) / 1000000;
    }

    public void c(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        this.c = extractorOutput;
        this.b = trackOutput;
        j(true);
    }

    public void d(long j) {
        this.g = j;
    }

    public abstract long e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray);

    public final int f(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        int i = this.h;
        if (i == 0) {
            return g(extractorInput);
        }
        if (i != 1) {
            if (i == 2) {
                return i(extractorInput, positionHolder);
            }
            throw new java.lang.IllegalStateException();
        }
        extractorInput.skipFully((int) this.f);
        this.h = 2;
        return 0;
    }

    public final int g(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        boolean z = true;
        while (z) {
            if (!this.a.d(extractorInput)) {
                this.h = 3;
                return -1;
            }
            this.k = extractorInput.getPosition() - this.f;
            z = h(this.a.c(), this.f, this.j);
            if (z) {
                this.f = extractorInput.getPosition();
            }
        }
        com.google.android.exoplayer2.Format format = this.j.a;
        this.i = format.sampleRate;
        if (!this.m) {
            this.b.format(format);
            this.m = true;
        }
        com.google.android.exoplayer2.extractor.ogg.OggSeeker oggSeeker = this.j.b;
        if (oggSeeker != null) {
            this.d = oggSeeker;
        } else if (extractorInput.getLength() == -1) {
            this.d = new com.google.android.exoplayer2.extractor.ogg.StreamReader.UnseekableOggSeeker(null);
        } else {
            com.google.android.exoplayer2.extractor.ogg.OggPageHeader b = this.a.b();
            this.d = new com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker(this, this.f, extractorInput.getLength(), b.h + b.i, b.c, (b.b & 4) != 0);
        }
        this.j = null;
        this.h = 2;
        this.a.f();
        return 0;
    }

    public abstract boolean h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j, com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData) throws java.io.IOException;

    public final int i(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        long read = this.d.read(extractorInput);
        if (read >= 0) {
            positionHolder.position = read;
            return 1;
        }
        if (read < -1) {
            d(-(read + 2));
        }
        if (!this.l) {
            this.c.seekMap((com.google.android.exoplayer2.extractor.SeekMap) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.d.a()));
            this.l = true;
        }
        if (this.k <= 0 && !this.a.d(extractorInput)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        com.google.android.exoplayer2.util.ParsableByteArray c = this.a.c();
        long e = e(c);
        if (e >= 0) {
            long j = this.g;
            if (j + e >= this.e) {
                long a = a(j);
                this.b.sampleData(c, c.limit());
                this.b.sampleMetadata(a, 1, c.limit(), 0, null);
                this.e = -1L;
            }
        }
        this.g += e;
        return 0;
    }

    public void j(boolean z) {
        if (z) {
            this.j = new com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }

    public final void k(long j, long j2) {
        this.a.e();
        if (j == 0) {
            j(!this.l);
        } else if (this.h != 0) {
            long b = b(j2);
            this.e = b;
            this.d.b(b);
            this.h = 2;
        }
    }
}
