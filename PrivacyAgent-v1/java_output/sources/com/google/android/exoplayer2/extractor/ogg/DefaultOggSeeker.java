package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes22.dex */
final class DefaultOggSeeker implements com.google.android.exoplayer2.extractor.ogg.OggSeeker {
    public final com.google.android.exoplayer2.extractor.ogg.OggPageHeader a;
    public final long b;
    public final long c;
    public final com.google.android.exoplayer2.extractor.ogg.StreamReader d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    public final class OggSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
        public OggSeekMap() {
        }

        public /* synthetic */ OggSeekMap(com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker defaultOggSeeker, com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.d.a(com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.f);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(j, com.google.android.exoplayer2.util.Util.constrainValue((com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.b + ((com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.d.b(j) * (com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.c - com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.b)) / com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.f)) - 30000, com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.b, com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.c - 1)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    public DefaultOggSeeker(com.google.android.exoplayer2.extractor.ogg.StreamReader streamReader, long j, long j2, long j3, long j4, boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j >= 0 && j2 > j);
        this.d = streamReader;
        this.b = j;
        this.c = j2;
        if (j3 == j2 - j || z) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new com.google.android.exoplayer2.extractor.ogg.OggPageHeader();
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public void b(long j) {
        this.h = com.google.android.exoplayer2.util.Util.constrainValue(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    @androidx.annotation.Nullable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.OggSeekMap a() {
        if (this.f != 0) {
            return new com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.OggSeekMap(this, null);
        }
        return null;
    }

    public final long h(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (this.i == this.j) {
            return -1L;
        }
        long position = extractorInput.getPosition();
        if (!this.a.e(extractorInput, this.j)) {
            long j = this.i;
            if (j != position) {
                return j;
            }
            throw new java.io.IOException("No ogg page can be found.");
        }
        this.a.b(extractorInput, false);
        extractorInput.resetPeekPosition();
        long j2 = this.h;
        com.google.android.exoplayer2.extractor.ogg.OggPageHeader oggPageHeader = this.a;
        long j3 = oggPageHeader.c;
        long j4 = j2 - j3;
        int i = oggPageHeader.h + oggPageHeader.i;
        if (0 <= j4 && j4 < 72000) {
            return -1L;
        }
        if (j4 < 0) {
            this.j = position;
            this.l = j3;
        } else {
            this.i = extractorInput.getPosition() + i;
            this.k = this.a.c;
        }
        long j5 = this.j;
        long j6 = this.i;
        if (j5 - j6 < 100000) {
            this.j = j6;
            return j6;
        }
        long position2 = extractorInput.getPosition() - (i * (j4 <= 0 ? 2L : 1L));
        long j7 = this.j;
        long j8 = this.i;
        return com.google.android.exoplayer2.util.Util.constrainValue(position2 + ((j4 * (j7 - j8)) / (this.l - this.k)), j8, j7 - 1);
    }

    @androidx.annotation.VisibleForTesting
    public long i(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        this.a.c();
        if (!this.a.d(extractorInput)) {
            throw new java.io.EOFException();
        }
        do {
            this.a.b(extractorInput, false);
            com.google.android.exoplayer2.extractor.ogg.OggPageHeader oggPageHeader = this.a;
            extractorInput.skipFully(oggPageHeader.h + oggPageHeader.i);
            com.google.android.exoplayer2.extractor.ogg.OggPageHeader oggPageHeader2 = this.a;
            if ((oggPageHeader2.b & 4) == 4 || !oggPageHeader2.d(extractorInput)) {
                break;
            }
        } while (extractorInput.getPosition() < this.c);
        return this.a.c;
    }

    public final void j(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        while (true) {
            this.a.d(extractorInput);
            this.a.b(extractorInput, false);
            com.google.android.exoplayer2.extractor.ogg.OggPageHeader oggPageHeader = this.a;
            if (oggPageHeader.c > this.h) {
                extractorInput.resetPeekPosition();
                return;
            } else {
                extractorInput.skipFully(oggPageHeader.h + oggPageHeader.i);
                this.i = extractorInput.getPosition();
                this.k = this.a.c;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int i = this.e;
        if (i == 0) {
            long position = extractorInput.getPosition();
            this.g = position;
            this.e = 1;
            long j = this.c - 65307;
            if (j > position) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long h = h(extractorInput);
                if (h != -1) {
                    return h;
                }
                this.e = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1L;
                }
                throw new java.lang.IllegalStateException();
            }
            j(extractorInput);
            this.e = 4;
            return -(this.k + 2);
        }
        this.f = i(extractorInput);
        this.e = 4;
        return this.g;
    }
}
