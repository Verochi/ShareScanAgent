package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
public final class PlayerEmsgHandler implements android.os.Handler.Callback {
    public boolean B;
    public boolean C;
    public final com.google.android.exoplayer2.upstream.Allocator n;
    public final com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback t;
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest x;
    public long y;
    public final java.util.TreeMap<java.lang.Long, java.lang.Long> w = new java.util.TreeMap<>();
    public final android.os.Handler v = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper(this);
    public final com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder u = new com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder();
    public long z = -9223372036854775807L;
    public long A = -9223372036854775807L;

    public static final class ManifestExpiryEventInfo {
        public final long a;
        public final long b;

        public ManifestExpiryEventInfo(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    public interface PlayerEmsgCallback {
        void onDashManifestPublishTimeExpired(long j);

        void onDashManifestRefreshRequested();
    }

    public final class PlayerTrackEmsgHandler implements com.google.android.exoplayer2.extractor.TrackOutput {
        public final com.google.android.exoplayer2.source.SampleQueue a;
        public final com.google.android.exoplayer2.FormatHolder b = new com.google.android.exoplayer2.FormatHolder();
        public final com.google.android.exoplayer2.metadata.MetadataInputBuffer c = new com.google.android.exoplayer2.metadata.MetadataInputBuffer();

        public PlayerTrackEmsgHandler(com.google.android.exoplayer2.upstream.Allocator allocator) {
            this.a = new com.google.android.exoplayer2.source.SampleQueue(allocator, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.v.getLooper(), defpackage.z60.c(), new com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher());
        }

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.metadata.MetadataInputBuffer a() {
            this.c.clear();
            if (this.a.read(this.b, this.c, false, false) != -4) {
                return null;
            }
            this.c.flip();
            return this.c;
        }

        public final void b(long j, long j2) {
            com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.v.sendMessage(com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.v.obtainMessage(1, new com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.ManifestExpiryEventInfo(j, j2)));
        }

        public final void c() {
            while (this.a.isReady(false)) {
                com.google.android.exoplayer2.metadata.MetadataInputBuffer a = a();
                if (a != null) {
                    long j = a.timeUs;
                    com.google.android.exoplayer2.metadata.Metadata decode = com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.u.decode(a);
                    if (decode != null) {
                        com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage = (com.google.android.exoplayer2.metadata.emsg.EventMessage) decode.get(0);
                        if (com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.isPlayerEmsgEvent(eventMessage.schemeIdUri, eventMessage.value)) {
                            d(j, eventMessage);
                        }
                    }
                }
            }
            this.a.discardToRead();
        }

        public final void d(long j, com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage) {
            long e = com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.e(eventMessage);
            if (e == -9223372036854775807L) {
                return;
            }
            b(j, e);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(com.google.android.exoplayer2.Format format) {
            this.a.format(format);
        }

        public boolean maybeRefreshManifestBeforeLoadingNextChunk(long j) {
            return com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.h(j);
        }

        public boolean maybeRefreshManifestOnLoadingError(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
            return com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.i(chunk);
        }

        public void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
            com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.this.k(chunk);
        }

        public void release() {
            this.a.release();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z) {
            return defpackage.p33.a(this, dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z, int i2) throws java.io.IOException {
            return this.a.sampleData(dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
            defpackage.p33.b(this, parsableByteArray, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
            this.a.sampleData(parsableByteArray, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
            this.a.sampleMetadata(j, i, i2, i3, cryptoData);
            c();
        }
    }

    public PlayerEmsgHandler(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, com.google.android.exoplayer2.upstream.Allocator allocator) {
        this.x = dashManifest;
        this.t = playerEmsgCallback;
        this.n = allocator;
    }

    public static long e(com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage) {
        try {
            return com.google.android.exoplayer2.util.Util.parseXsDateTime(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(eventMessage.messageData));
        } catch (com.google.android.exoplayer2.ParserException unused) {
            return -9223372036854775807L;
        }
    }

    public static boolean isPlayerEmsgEvent(java.lang.String str, java.lang.String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    @androidx.annotation.Nullable
    public final java.util.Map.Entry<java.lang.Long, java.lang.Long> d(long j) {
        return this.w.ceilingEntry(java.lang.Long.valueOf(j));
    }

    public final void f(long j, long j2) {
        java.lang.Long l = this.w.get(java.lang.Long.valueOf(j2));
        if (l == null) {
            this.w.put(java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j));
        } else if (l.longValue() > j) {
            this.w.put(java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j));
        }
    }

    public final void g() {
        long j = this.A;
        if (j == -9223372036854775807L || j != this.z) {
            this.B = true;
            this.A = this.z;
            this.t.onDashManifestRefreshRequested();
        }
    }

    public boolean h(long j) {
        com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest = this.x;
        boolean z = false;
        if (!dashManifest.dynamic) {
            return false;
        }
        if (this.B) {
            return true;
        }
        java.util.Map.Entry<java.lang.Long, java.lang.Long> d = d(dashManifest.publishTimeMs);
        if (d != null && d.getValue().longValue() < j) {
            this.y = d.getKey().longValue();
            j();
            z = true;
        }
        if (z) {
            g();
        }
        return z;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (this.C) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.ManifestExpiryEventInfo manifestExpiryEventInfo = (com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.ManifestExpiryEventInfo) message.obj;
        f(manifestExpiryEventInfo.a, manifestExpiryEventInfo.b);
        return true;
    }

    public boolean i(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        if (!this.x.dynamic) {
            return false;
        }
        if (this.B) {
            return true;
        }
        long j = this.z;
        if (!(j != -9223372036854775807L && j < chunk.startTimeUs)) {
            return false;
        }
        g();
        return true;
    }

    public final void j() {
        this.t.onDashManifestPublishTimeExpired(this.y);
    }

    public void k(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        long j = this.z;
        if (j != -9223372036854775807L || chunk.endTimeUs > j) {
            this.z = chunk.endTimeUs;
        }
    }

    public final void l() {
        java.util.Iterator<java.util.Map.Entry<java.lang.Long, java.lang.Long>> it = this.w.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.x.publishTimeMs) {
                it.remove();
            }
        }
    }

    public com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler newPlayerTrackEmsgHandler() {
        return new com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler(this.n);
    }

    public void release() {
        this.C = true;
        this.v.removeCallbacksAndMessages(null);
    }

    public void updateManifest(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest) {
        this.B = false;
        this.y = -9223372036854775807L;
        this.x = dashManifest;
        l();
    }
}
