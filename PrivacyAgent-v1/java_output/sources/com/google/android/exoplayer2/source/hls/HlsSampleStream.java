package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
final class HlsSampleStream implements com.google.android.exoplayer2.source.SampleStream {
    public final int n;
    public final com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper t;
    public int u = -1;

    public HlsSampleStream(com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper, int i) {
        this.t = hlsSampleStreamWrapper;
        this.n = i;
    }

    public void a() {
        com.google.android.exoplayer2.util.Assertions.checkArgument(this.u == -1);
        this.u = this.t.d(this.n);
    }

    public final boolean b() {
        int i = this.u;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    public void c() {
        if (this.u != -1) {
            this.t.T(this.n);
            this.u = -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return this.u == -3 || (b() && this.t.w(this.u));
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws java.io.IOException {
        int i = this.u;
        if (i == -2) {
            throw new com.google.android.exoplayer2.source.hls.SampleQueueMappingException(this.t.getTrackGroups().get(this.n).getFormat(0).sampleMimeType);
        }
        if (i == -1) {
            this.t.z();
        } else if (i != -3) {
            this.t.A(i);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (this.u == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (b()) {
            return this.t.I(this.u, formatHolder, decoderInputBuffer, z);
        }
        return -3;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        if (b()) {
            return this.t.S(this.u, j);
        }
        return 0;
    }
}
