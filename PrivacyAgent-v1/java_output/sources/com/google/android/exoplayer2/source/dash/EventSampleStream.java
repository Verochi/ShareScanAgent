package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
final class EventSampleStream implements com.google.android.exoplayer2.source.SampleStream {
    public final com.google.android.exoplayer2.Format n;
    public long[] u;
    public boolean v;
    public com.google.android.exoplayer2.source.dash.manifest.EventStream w;
    public boolean x;
    public int y;
    public final com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder t = new com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder();
    public long z = -9223372036854775807L;

    public EventSampleStream(com.google.android.exoplayer2.source.dash.manifest.EventStream eventStream, com.google.android.exoplayer2.Format format, boolean z) {
        this.n = format;
        this.w = eventStream;
        this.u = eventStream.presentationTimesUs;
        c(eventStream, z);
    }

    public java.lang.String a() {
        return this.w.id();
    }

    public void b(long j) {
        int binarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.u, j, true, false);
        this.y = binarySearchCeil;
        if (!(this.v && binarySearchCeil == this.u.length)) {
            j = -9223372036854775807L;
        }
        this.z = j;
    }

    public void c(com.google.android.exoplayer2.source.dash.manifest.EventStream eventStream, boolean z) {
        int i = this.y;
        long j = i == 0 ? -9223372036854775807L : this.u[i - 1];
        this.v = z;
        this.w = eventStream;
        long[] jArr = eventStream.presentationTimesUs;
        this.u = jArr;
        long j2 = this.z;
        if (j2 != -9223372036854775807L) {
            b(j2);
        } else if (j != -9223372036854775807L) {
            this.y = com.google.android.exoplayer2.util.Util.binarySearchCeil(jArr, j, false, false);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws java.io.IOException {
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (z || !this.x) {
            formatHolder.format = this.n;
            this.x = true;
            return -5;
        }
        int i = this.y;
        if (i == this.u.length) {
            if (this.v) {
                return -3;
            }
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        this.y = i + 1;
        byte[] encode = this.t.encode(this.w.events[i]);
        decoderInputBuffer.ensureSpaceForWrite(encode.length);
        decoderInputBuffer.data.put(encode);
        decoderInputBuffer.timeUs = this.u[i];
        decoderInputBuffer.setFlags(1);
        return -4;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        int max = java.lang.Math.max(this.y, com.google.android.exoplayer2.util.Util.binarySearchCeil(this.u, j, true, false));
        int i = max - this.y;
        this.y = max;
        return i;
    }
}
