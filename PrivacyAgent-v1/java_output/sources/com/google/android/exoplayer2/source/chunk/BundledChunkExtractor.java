package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public final class BundledChunkExtractor implements com.google.android.exoplayer2.extractor.ExtractorOutput, com.google.android.exoplayer2.source.chunk.ChunkExtractor {
    public static final com.google.android.exoplayer2.extractor.PositionHolder B = new com.google.android.exoplayer2.extractor.PositionHolder();
    public com.google.android.exoplayer2.Format[] A;
    public final com.google.android.exoplayer2.extractor.Extractor n;
    public final int t;
    public final com.google.android.exoplayer2.Format u;
    public final android.util.SparseArray<com.google.android.exoplayer2.source.chunk.BundledChunkExtractor.BindingTrackOutput> v = new android.util.SparseArray<>();
    public boolean w;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider x;
    public long y;
    public com.google.android.exoplayer2.extractor.SeekMap z;

    public static final class BindingTrackOutput implements com.google.android.exoplayer2.extractor.TrackOutput {
        public final int a;
        public final int b;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.Format c;
        public final com.google.android.exoplayer2.extractor.DummyTrackOutput d = new com.google.android.exoplayer2.extractor.DummyTrackOutput();
        public com.google.android.exoplayer2.Format e;
        public com.google.android.exoplayer2.extractor.TrackOutput f;
        public long g;

        public BindingTrackOutput(int i, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format) {
            this.a = i;
            this.b = i2;
            this.c = format;
        }

        public void a(@androidx.annotation.Nullable com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider trackOutputProvider, long j) {
            if (trackOutputProvider == null) {
                this.f = this.d;
                return;
            }
            this.g = j;
            com.google.android.exoplayer2.extractor.TrackOutput track = trackOutputProvider.track(this.a, this.b);
            this.f = track;
            com.google.android.exoplayer2.Format format = this.e;
            if (format != null) {
                track.format(format);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(com.google.android.exoplayer2.Format format) {
            com.google.android.exoplayer2.Format format2 = this.c;
            if (format2 != null) {
                format = format.withManifestFormatInfo(format2);
            }
            this.e = format;
            ((com.google.android.exoplayer2.extractor.TrackOutput) com.google.android.exoplayer2.util.Util.castNonNull(this.f)).format(this.e);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z) {
            return defpackage.p33.a(this, dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z, int i2) throws java.io.IOException {
            return ((com.google.android.exoplayer2.extractor.TrackOutput) com.google.android.exoplayer2.util.Util.castNonNull(this.f)).sampleData(dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
            defpackage.p33.b(this, parsableByteArray, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
            ((com.google.android.exoplayer2.extractor.TrackOutput) com.google.android.exoplayer2.util.Util.castNonNull(this.f)).sampleData(parsableByteArray, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
            long j2 = this.g;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.f = this.d;
            }
            ((com.google.android.exoplayer2.extractor.TrackOutput) com.google.android.exoplayer2.util.Util.castNonNull(this.f)).sampleMetadata(j, i, i2, i3, cryptoData);
        }
    }

    public BundledChunkExtractor(com.google.android.exoplayer2.extractor.Extractor extractor, int i, com.google.android.exoplayer2.Format format) {
        this.n = extractor;
        this.t = i;
        this.u = format;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[this.v.size()];
        for (int i = 0; i < this.v.size(); i++) {
            formatArr[i] = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.v.valueAt(i).e);
        }
        this.A = formatArr;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.ChunkIndex getChunkIndex() {
        com.google.android.exoplayer2.extractor.SeekMap seekMap = this.z;
        if (seekMap instanceof com.google.android.exoplayer2.extractor.ChunkIndex) {
            return (com.google.android.exoplayer2.extractor.ChunkIndex) seekMap;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format[] getSampleFormats() {
        return this.A;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void init(@androidx.annotation.Nullable com.google.android.exoplayer2.source.chunk.ChunkExtractor.TrackOutputProvider trackOutputProvider, long j, long j2) {
        this.x = trackOutputProvider;
        this.y = j2;
        if (!this.w) {
            this.n.init(this);
            if (j != -9223372036854775807L) {
                this.n.seek(0L, j);
            }
            this.w = true;
            return;
        }
        com.google.android.exoplayer2.extractor.Extractor extractor = this.n;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        extractor.seek(0L, j);
        for (int i = 0; i < this.v.size(); i++) {
            this.v.valueAt(i).a(trackOutputProvider, j2);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public boolean read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int read = this.n.read(extractorInput, B);
        com.google.android.exoplayer2.util.Assertions.checkState(read != 1);
        return read == 0;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void release() {
        this.n.release();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
        this.z = seekMap;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public com.google.android.exoplayer2.extractor.TrackOutput track(int i, int i2) {
        com.google.android.exoplayer2.source.chunk.BundledChunkExtractor.BindingTrackOutput bindingTrackOutput = this.v.get(i);
        if (bindingTrackOutput == null) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.A == null);
            bindingTrackOutput = new com.google.android.exoplayer2.source.chunk.BundledChunkExtractor.BindingTrackOutput(i, i2, i2 == this.t ? this.u : null);
            bindingTrackOutput.a(this.x, this.y);
            this.v.put(i, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }
}
