package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
final class HlsMediaChunk extends com.google.android.exoplayer2.source.chunk.MediaChunk {
    public static final java.util.concurrent.atomic.AtomicInteger z = new java.util.concurrent.atomic.AtomicInteger();
    public final int a;
    public final int b;
    public final android.net.Uri c;
    public final boolean d;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.DataSource e;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.DataSpec f;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor g;
    public final boolean h;
    public final boolean i;
    public final com.google.android.exoplayer2.util.TimestampAdjuster j;
    public final com.google.android.exoplayer2.source.hls.HlsExtractorFactory k;

    @androidx.annotation.Nullable
    public final java.util.List<com.google.android.exoplayer2.Format> l;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.drm.DrmInitData m;
    public final com.google.android.exoplayer2.metadata.id3.Id3Decoder n;
    public final com.google.android.exoplayer2.util.ParsableByteArray o;
    public final boolean p;
    public final boolean q;
    public com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor r;

    /* renamed from: s, reason: collision with root package name */
    public com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper f358s;
    public int t;
    public boolean u;
    public volatile boolean v;
    public boolean w;
    public com.google.common.collect.ImmutableList<java.lang.Integer> x;
    public boolean y;

    public HlsMediaChunk(com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.Format format, boolean z2, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource2, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSpec dataSpec2, boolean z3, android.net.Uri uri, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list, int i, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2, long j3, int i2, boolean z4, boolean z5, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, @androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor hlsMediaChunkExtractor, com.google.android.exoplayer2.metadata.id3.Id3Decoder id3Decoder, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, boolean z6) {
        super(dataSource, dataSpec, format, i, obj, j, j2, j3);
        this.p = z2;
        this.b = i2;
        this.f = dataSpec2;
        this.e = dataSource2;
        this.u = dataSpec2 != null;
        this.q = z3;
        this.c = uri;
        this.h = z5;
        this.j = timestampAdjuster;
        this.i = z4;
        this.k = hlsExtractorFactory;
        this.l = list;
        this.m = drmInitData;
        this.g = hlsMediaChunkExtractor;
        this.n = id3Decoder;
        this.o = parsableByteArray;
        this.d = z6;
        this.x = com.google.common.collect.ImmutableList.of();
        this.a = z.getAndIncrement();
    }

    public static com.google.android.exoplayer2.upstream.DataSource a(com.google.android.exoplayer2.upstream.DataSource dataSource, @androidx.annotation.Nullable byte[] bArr, @androidx.annotation.Nullable byte[] bArr2) {
        if (bArr == null) {
            return dataSource;
        }
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr2);
        return new com.google.android.exoplayer2.source.hls.Aes128DataSource(dataSource, bArr, bArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
    
        if (r20 >= r50.endTimeUs) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.android.exoplayer2.source.hls.HlsMediaChunk b(com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.Format format, long j, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, int i, android.net.Uri uri, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.Format> list, int i2, @androidx.annotation.Nullable java.lang.Object obj, boolean z2, com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider timestampAdjusterProvider, @androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk, @androidx.annotation.Nullable byte[] bArr, @androidx.annotation.Nullable byte[] bArr2) {
        boolean z3;
        com.google.android.exoplayer2.upstream.DataSource dataSource2;
        boolean z4;
        com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        com.google.android.exoplayer2.metadata.id3.Id3Decoder id3Decoder;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray;
        com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor hlsMediaChunkExtractor;
        boolean z5;
        com.google.android.exoplayer2.metadata.id3.Id3Decoder id3Decoder2;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2;
        boolean z6;
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i);
        com.google.android.exoplayer2.upstream.DataSpec dataSpec2 = new com.google.android.exoplayer2.upstream.DataSpec(com.google.android.exoplayer2.util.UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byteRangeOffset, segment.byteRangeLength);
        boolean z7 = bArr != null;
        com.google.android.exoplayer2.upstream.DataSource a = a(dataSource, bArr, z7 ? d((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(segment.encryptionIV)) : null);
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment2 = segment.initializationSegment;
        if (segment2 != null) {
            boolean z8 = bArr2 != null;
            byte[] d = z8 ? d((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(segment2.encryptionIV)) : null;
            z3 = z7;
            com.google.android.exoplayer2.upstream.DataSpec dataSpec3 = new com.google.android.exoplayer2.upstream.DataSpec(com.google.android.exoplayer2.util.UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment2.url), segment2.byteRangeOffset, segment2.byteRangeLength);
            dataSource2 = a(dataSource, bArr2, d);
            z4 = z8;
            dataSpec = dataSpec3;
        } else {
            z3 = z7;
            dataSource2 = null;
            z4 = false;
            dataSpec = null;
        }
        long j2 = j + segment.relativeStartTimeUs;
        long j3 = j2 + segment.durationUs;
        int i3 = hlsMediaPlaylist.discontinuitySequence + segment.relativeDiscontinuitySequence;
        if (hlsMediaChunk != null) {
            boolean z9 = uri.equals(hlsMediaChunk.c) && hlsMediaChunk.w;
            com.google.android.exoplayer2.metadata.id3.Id3Decoder id3Decoder3 = hlsMediaChunk.n;
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray3 = hlsMediaChunk.o;
            if (z9) {
                id3Decoder2 = id3Decoder3;
                parsableByteArray2 = parsableByteArray3;
            } else {
                if (hlsMediaPlaylist.hasIndependentSegments) {
                    id3Decoder2 = id3Decoder3;
                    parsableByteArray2 = parsableByteArray3;
                } else {
                    id3Decoder2 = id3Decoder3;
                    parsableByteArray2 = parsableByteArray3;
                }
                z6 = false;
                boolean z10 = !z6;
                hlsMediaChunkExtractor = (z9 || hlsMediaChunk.y || hlsMediaChunk.b != i3) ? null : hlsMediaChunk.r;
                id3Decoder = id3Decoder2;
                z5 = z10;
                parsableByteArray = parsableByteArray2;
            }
            z6 = true;
            boolean z102 = !z6;
            if (z9) {
            }
            id3Decoder = id3Decoder2;
            z5 = z102;
            parsableByteArray = parsableByteArray2;
        } else {
            id3Decoder = new com.google.android.exoplayer2.metadata.id3.Id3Decoder();
            parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(10);
            hlsMediaChunkExtractor = null;
            z5 = false;
        }
        return new com.google.android.exoplayer2.source.hls.HlsMediaChunk(hlsExtractorFactory, a, dataSpec2, format, z3, dataSource2, dataSpec, z4, uri, list, i2, obj, j2, j3, hlsMediaPlaylist.mediaSequence + i, i3, segment.hasGapTag, z2, timestampAdjusterProvider.getAdjuster(i3), segment.drmInitData, hlsMediaChunkExtractor, id3Decoder, parsableByteArray, z5);
    }

    public static byte[] d(java.lang.String str) {
        if (com.google.android.exoplayer2.util.Util.toLowerInvariant(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new java.math.BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        java.lang.System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void c(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, boolean z2) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSpec subrange;
        if (z2) {
            r0 = this.t != 0;
            subrange = dataSpec;
        } else {
            subrange = dataSpec.subrange(this.t);
        }
        try {
            com.google.android.exoplayer2.extractor.DefaultExtractorInput j = j(dataSource, subrange);
            if (r0) {
                j.skipFully(this.t);
            }
            do {
                try {
                    if (this.v) {
                        break;
                    }
                } finally {
                    this.t = (int) (j.getPosition() - dataSpec.position);
                }
            } while (this.r.read(j));
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(dataSource);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.v = true;
    }

    public void e(com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper, com.google.common.collect.ImmutableList<java.lang.Integer> immutableList) {
        this.f358s = hlsSampleStreamWrapper;
        this.x = immutableList;
    }

    public void f() {
        this.y = true;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void g() throws java.io.IOException {
        if (!this.h) {
            try {
                this.j.waitUntilInitialized();
            } catch (java.lang.InterruptedException unused) {
                throw new java.io.InterruptedIOException();
            }
        } else if (this.j.getFirstSampleTimestampUs() == Long.MAX_VALUE) {
            this.j.setFirstSampleTimestampUs(this.startTimeUs);
        }
        c(this.dataSource, this.dataSpec, this.p);
    }

    public int getFirstSampleIndex(int i) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.d);
        if (i >= this.x.size()) {
            return 0;
        }
        return this.x.get(i).intValue();
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final void h() throws java.io.IOException {
        if (this.u) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.e);
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f);
            c(this.e, this.f, this.q);
            this.t = 0;
            this.u = false;
        }
    }

    public final long i(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.resetPeekPosition();
        try {
            extractorInput.peekFully(this.o.getData(), 0, 10);
            this.o.reset(10);
        } catch (java.io.EOFException unused) {
        }
        if (this.o.readUnsignedInt24() != 4801587) {
            return -9223372036854775807L;
        }
        this.o.skipBytes(3);
        int readSynchSafeInt = this.o.readSynchSafeInt();
        int i = readSynchSafeInt + 10;
        if (i > this.o.capacity()) {
            byte[] data = this.o.getData();
            this.o.reset(i);
            java.lang.System.arraycopy(data, 0, this.o.getData(), 0, 10);
        }
        extractorInput.peekFully(this.o.getData(), 10, readSynchSafeInt);
        com.google.android.exoplayer2.metadata.Metadata decode = this.n.decode(this.o.getData(), readSynchSafeInt);
        if (decode == null) {
            return -9223372036854775807L;
        }
        int length = decode.length();
        for (int i2 = 0; i2 < length; i2++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = decode.get(i2);
            if (entry instanceof com.google.android.exoplayer2.metadata.id3.PrivFrame) {
                com.google.android.exoplayer2.metadata.id3.PrivFrame privFrame = (com.google.android.exoplayer2.metadata.id3.PrivFrame) entry;
                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                    java.lang.System.arraycopy(privFrame.privateData, 0, this.o.getData(), 0, 8);
                    this.o.reset(8);
                    return this.o.readLong() & org.apache.tools.tar.TarConstants.MAXSIZE;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.w;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"extractor"})
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    public final com.google.android.exoplayer2.extractor.DefaultExtractorInput j(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.DefaultExtractorInput defaultExtractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(dataSource, dataSpec.position, dataSource.open(dataSpec));
        if (this.r == null) {
            long i = i(defaultExtractorInput);
            defaultExtractorInput.resetPeekPosition();
            com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor hlsMediaChunkExtractor = this.g;
            com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor recreate = hlsMediaChunkExtractor != null ? hlsMediaChunkExtractor.recreate() : this.k.createExtractor(dataSpec.uri, this.trackFormat, this.l, this.j, dataSource.getResponseHeaders(), defaultExtractorInput);
            this.r = recreate;
            if (recreate.isPackedAudioExtractor()) {
                this.f358s.R(i != -9223372036854775807L ? this.j.adjustTsTimestamp(i) : this.startTimeUs);
            } else {
                this.f358s.R(0L);
            }
            this.f358s.E();
            this.r.init(this.f358s);
        }
        this.f358s.O(this.m);
        return defaultExtractorInput;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws java.io.IOException {
        com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor hlsMediaChunkExtractor;
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f358s);
        if (this.r == null && (hlsMediaChunkExtractor = this.g) != null && hlsMediaChunkExtractor.isReusable()) {
            this.r = this.g;
            this.u = false;
        }
        h();
        if (this.v) {
            return;
        }
        if (!this.i) {
            g();
        }
        this.w = !this.v;
    }
}
