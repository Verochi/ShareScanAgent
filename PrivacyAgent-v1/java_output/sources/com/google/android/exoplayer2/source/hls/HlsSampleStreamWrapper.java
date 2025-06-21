package com.google.android.exoplayer2.source.hls;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class HlsSampleStreamWrapper implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.source.chunk.Chunk>, com.google.android.exoplayer2.upstream.Loader.ReleaseCallback, com.google.android.exoplayer2.source.SequenceableLoader, com.google.android.exoplayer2.extractor.ExtractorOutput, com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener {
    public static final java.util.Set<java.lang.Integer> p0 = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList(1, 2, 4)));
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher B;
    public final int C;
    public final java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> E;
    public final java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> F;
    public final java.lang.Runnable G;
    public final java.lang.Runnable H;
    public final android.os.Handler I;
    public final java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsSampleStream> J;
    public final java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> K;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.chunk.Chunk L;
    public com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue[] M;
    public java.util.Set<java.lang.Integer> O;
    public android.util.SparseIntArray P;
    public com.google.android.exoplayer2.extractor.TrackOutput Q;
    public int R;
    public int S;
    public boolean T;
    public boolean U;
    public int V;
    public com.google.android.exoplayer2.Format W;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format X;
    public boolean Y;
    public com.google.android.exoplayer2.source.TrackGroupArray Z;
    public java.util.Set<com.google.android.exoplayer2.source.TrackGroup> a0;
    public int[] b0;
    public int c0;
    public boolean d0;
    public boolean[] e0;
    public boolean[] f0;
    public long g0;
    public long h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public long m0;
    public final int n;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmInitData n0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.hls.HlsMediaChunk o0;
    public final com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback t;
    public final com.google.android.exoplayer2.source.hls.HlsChunkSource u;
    public final com.google.android.exoplayer2.upstream.Allocator v;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.Format w;
    public final com.google.android.exoplayer2.drm.DrmSessionManager x;
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher y;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy z;
    public final com.google.android.exoplayer2.upstream.Loader A = new com.google.android.exoplayer2.upstream.Loader("Loader:HlsSampleStreamWrapper");
    public final com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder D = new com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder();
    public int[] N = new int[0];

    public interface Callback extends com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(android.net.Uri uri);

        void onPrepared();
    }

    public static class EmsgUnwrappingTrackOutput implements com.google.android.exoplayer2.extractor.TrackOutput {
        public static final com.google.android.exoplayer2.Format g = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("application/id3").build();
        public static final com.google.android.exoplayer2.Format h = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("application/x-emsg").build();
        public final com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder a = new com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder();
        public final com.google.android.exoplayer2.extractor.TrackOutput b;
        public final com.google.android.exoplayer2.Format c;
        public com.google.android.exoplayer2.Format d;
        public byte[] e;
        public int f;

        public EmsgUnwrappingTrackOutput(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, int i) {
            this.b = trackOutput;
            if (i == 1) {
                this.c = g;
            } else {
                if (i != 3) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(33);
                    sb.append("Unknown metadataType: ");
                    sb.append(i);
                    throw new java.lang.IllegalArgumentException(sb.toString());
                }
                this.c = h;
            }
            this.e = new byte[0];
            this.f = 0;
        }

        public final boolean a(com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage) {
            com.google.android.exoplayer2.Format wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && com.google.android.exoplayer2.util.Util.areEqual(this.c.sampleMimeType, wrappedMetadataFormat.sampleMimeType);
        }

        public final void b(int i) {
            byte[] bArr = this.e;
            if (bArr.length < i) {
                this.e = java.util.Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        public final com.google.android.exoplayer2.util.ParsableByteArray c(int i, int i2) {
            int i3 = this.f - i2;
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(java.util.Arrays.copyOfRange(this.e, i3 - i, i3));
            byte[] bArr = this.e;
            java.lang.System.arraycopy(bArr, i3, bArr, 0, i2);
            this.f = i2;
            return parsableByteArray;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(com.google.android.exoplayer2.Format format) {
            this.d = format;
            this.b.format(this.c);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z) {
            return defpackage.p33.a(this, dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z, int i2) throws java.io.IOException {
            b(this.f + i);
            int read = dataReader.read(this.e, this.f, i);
            if (read != -1) {
                this.f += read;
                return read;
            }
            if (z) {
                return -1;
            }
            throw new java.io.EOFException();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
            defpackage.p33.b(this, parsableByteArray, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, int i2) {
            b(this.f + i);
            parsableByteArray.readBytes(this.e, this.f, i);
            this.f += i;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d);
            com.google.android.exoplayer2.util.ParsableByteArray c = c(i2, i3);
            if (!com.google.android.exoplayer2.util.Util.areEqual(this.d.sampleMimeType, this.c.sampleMimeType)) {
                if (!"application/x-emsg".equals(this.d.sampleMimeType)) {
                    java.lang.String valueOf = java.lang.String.valueOf(this.d.sampleMimeType);
                    com.google.android.exoplayer2.util.Log.w("EmsgUnwrappingTrackOutput", valueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(valueOf) : new java.lang.String("Ignoring sample for unsupported format: "));
                    return;
                } else {
                    com.google.android.exoplayer2.metadata.emsg.EventMessage decode = this.a.decode(c);
                    if (!a(decode)) {
                        com.google.android.exoplayer2.util.Log.w("EmsgUnwrappingTrackOutput", java.lang.String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.c.sampleMimeType, decode.getWrappedMetadataFormat()));
                        return;
                    }
                    c = new com.google.android.exoplayer2.util.ParsableByteArray((byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(decode.getWrappedMetadataBytes()));
                }
            }
            int bytesLeft = c.bytesLeft();
            this.b.sampleData(c, bytesLeft);
            this.b.sampleMetadata(j, i, bytesLeft, i3, cryptoData);
        }
    }

    public static final class HlsSampleQueue extends com.google.android.exoplayer2.source.SampleQueue {
        public final java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> J;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.drm.DrmInitData K;

        public HlsSampleQueue(com.google.android.exoplayer2.upstream.Allocator allocator, android.os.Looper looper, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> map) {
            super(allocator, looper, drmSessionManager, eventDispatcher);
            this.J = map;
        }

        public /* synthetic */ HlsSampleQueue(com.google.android.exoplayer2.upstream.Allocator allocator, android.os.Looper looper, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, java.util.Map map, com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.AnonymousClass1 anonymousClass1) {
            this(allocator, looper, drmSessionManager, eventDispatcher, map);
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue
        public com.google.android.exoplayer2.Format getAdjustedUpstreamFormat(com.google.android.exoplayer2.Format format) {
            com.google.android.exoplayer2.drm.DrmInitData drmInitData;
            com.google.android.exoplayer2.drm.DrmInitData drmInitData2 = this.K;
            if (drmInitData2 == null) {
                drmInitData2 = format.drmInitData;
            }
            if (drmInitData2 != null && (drmInitData = this.J.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            com.google.android.exoplayer2.metadata.Metadata r = r(format.metadata);
            if (drmInitData2 != format.drmInitData || r != format.metadata) {
                format = format.buildUpon().setDrmInitData(drmInitData2).setMetadata(r).build();
            }
            return super.getAdjustedUpstreamFormat(format);
        }

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.metadata.Metadata r(@androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata.get(i2);
                if ((entry instanceof com.google.android.exoplayer2.metadata.id3.PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((com.google.android.exoplayer2.metadata.id3.PrivFrame) entry).owner)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            com.google.android.exoplayer2.metadata.Metadata.Entry[] entryArr = new com.google.android.exoplayer2.metadata.Metadata.Entry[length - 1];
            while (i < length) {
                if (i != i2) {
                    entryArr[i < i2 ? i : i - 1] = metadata.get(i);
                }
                i++;
            }
            return new com.google.android.exoplayer2.metadata.Metadata(entryArr);
        }

        public void s(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
            this.K = drmInitData;
            invalidateUpstreamFormatAdjustment();
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue, com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
            super.sampleMetadata(j, i, i2, i3, cryptoData);
        }

        public void t(com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk) {
            sourceId(hlsMediaChunk.a);
        }
    }

    public HlsSampleStreamWrapper(int i, com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback callback, com.google.android.exoplayer2.source.hls.HlsChunkSource hlsChunkSource, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> map, com.google.android.exoplayer2.upstream.Allocator allocator, long j, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher2, int i2) {
        this.n = i;
        this.t = callback;
        this.u = hlsChunkSource;
        this.K = map;
        this.v = allocator;
        this.w = format;
        this.x = drmSessionManager;
        this.y = eventDispatcher;
        this.z = loadErrorHandlingPolicy;
        this.B = eventDispatcher2;
        this.C = i2;
        java.util.Set<java.lang.Integer> set = p0;
        this.O = new java.util.HashSet(set.size());
        this.P = new android.util.SparseIntArray(set.size());
        this.M = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue[0];
        this.f0 = new boolean[0];
        this.e0 = new boolean[0];
        java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> arrayList = new java.util.ArrayList<>();
        this.E = arrayList;
        this.F = java.util.Collections.unmodifiableList(arrayList);
        this.J = new java.util.ArrayList<>();
        this.G = new com.google.android.exoplayer2.source.hls.a(this);
        this.H = new com.google.android.exoplayer2.source.hls.b(this);
        this.I = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper();
        this.g0 = j;
        this.h0 = j;
    }

    public static com.google.android.exoplayer2.extractor.DummyTrackOutput h(int i, int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(54);
        sb.append("Unmapped track with id ");
        sb.append(i);
        sb.append(" of type ");
        sb.append(i2);
        com.google.android.exoplayer2.util.Log.w("HlsSampleStreamWrapper", sb.toString());
        return new com.google.android.exoplayer2.extractor.DummyTrackOutput();
    }

    public static com.google.android.exoplayer2.Format k(@androidx.annotation.Nullable com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2, boolean z) {
        if (format == null) {
            return format2;
        }
        java.lang.String codecsOfType = com.google.android.exoplayer2.util.Util.getCodecsOfType(format.codecs, com.google.android.exoplayer2.util.MimeTypes.getTrackType(format2.sampleMimeType));
        java.lang.String mediaMimeType = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(codecsOfType);
        com.google.android.exoplayer2.Format.Builder height = format2.buildUpon().setId(format.id).setLabel(format.label).setLanguage(format.language).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).setAverageBitrate(z ? format.averageBitrate : -1).setPeakBitrate(z ? format.peakBitrate : -1).setCodecs(codecsOfType).setWidth(format.width).setHeight(format.height);
        if (mediaMimeType != null) {
            height.setSampleMimeType(mediaMimeType);
        }
        int i = format.channelCount;
        if (i != -1) {
            height.setChannelCount(i);
        }
        com.google.android.exoplayer2.metadata.Metadata metadata = format.metadata;
        if (metadata != null) {
            com.google.android.exoplayer2.metadata.Metadata metadata2 = format2.metadata;
            if (metadata2 != null) {
                metadata = metadata2.copyWithAppendedEntriesFrom(metadata);
            }
            height.setMetadata(metadata);
        }
        return height.build();
    }

    public static boolean o(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        java.lang.String str = format.sampleMimeType;
        java.lang.String str2 = format2.sampleMimeType;
        int trackType = com.google.android.exoplayer2.util.MimeTypes.getTrackType(str);
        if (trackType != 3) {
            return trackType == com.google.android.exoplayer2.util.MimeTypes.getTrackType(str2);
        }
        if (com.google.android.exoplayer2.util.Util.areEqual(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || format.accessibilityChannel == format2.accessibilityChannel;
        }
        return false;
    }

    public static int s(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    public static boolean u(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        return chunk instanceof com.google.android.exoplayer2.source.hls.HlsMediaChunk;
    }

    public void A(int i) throws java.io.IOException {
        z();
        this.M[i].maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onLoadCanceled(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j, long j2, boolean z) {
        this.L = null;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.z.onLoadTaskConcluded(chunk.loadTaskId);
        this.B.loadCanceled(loadEventInfo, chunk.type, this.n, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        if (z) {
            return;
        }
        if (v() || this.V == 0) {
            K();
        }
        if (this.V > 0) {
            this.t.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j, long j2) {
        this.L = null;
        this.u.k(chunk);
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.z.onLoadTaskConcluded(chunk.loadTaskId);
        this.B.loadCompleted(loadEventInfo, chunk.type, this.n, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        if (this.U) {
            this.t.onContinueLoadingRequested(this);
        } else {
            continueLoading(this.g0);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j, long j2, java.io.IOException iOException, int i) {
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction createRetryAction;
        long bytesLoaded = chunk.bytesLoaded();
        boolean u = u(chunk);
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, bytesLoaded);
        com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(chunk.type, this.n, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, com.google.android.exoplayer2.C.usToMs(chunk.startTimeUs), com.google.android.exoplayer2.C.usToMs(chunk.endTimeUs)), iOException, i);
        long blacklistDurationMsFor = this.z.getBlacklistDurationMsFor(loadErrorInfo);
        boolean i2 = blacklistDurationMsFor != -9223372036854775807L ? this.u.i(chunk, blacklistDurationMsFor) : false;
        if (i2) {
            if (u && bytesLoaded == 0) {
                java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> arrayList = this.E;
                com.google.android.exoplayer2.util.Assertions.checkState(arrayList.remove(arrayList.size() - 1) == chunk);
                if (this.E.isEmpty()) {
                    this.h0 = this.g0;
                } else {
                    ((com.google.android.exoplayer2.source.hls.HlsMediaChunk) com.google.common.collect.Iterables.getLast(this.E)).f();
                }
            }
            createRetryAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
        } else {
            long retryDelayMsFor = this.z.getRetryDelayMsFor(loadErrorInfo);
            createRetryAction = retryDelayMsFor != -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
        }
        boolean z = !createRetryAction.isRetry();
        boolean z2 = i2;
        this.B.loadError(loadEventInfo, chunk.type, this.n, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, iOException, z);
        if (z) {
            this.L = null;
            this.z.onLoadTaskConcluded(chunk.loadTaskId);
        }
        if (z2) {
            if (this.U) {
                this.t.onContinueLoadingRequested(this);
            } else {
                continueLoading(this.g0);
            }
        }
        return createRetryAction;
    }

    public void E() {
        this.O.clear();
    }

    public boolean F(android.net.Uri uri, long j) {
        return this.u.l(uri, j);
    }

    public final void G() {
        this.T = true;
        y();
    }

    public void H(com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr, int i, int... iArr) {
        this.Z = j(trackGroupArr);
        this.a0 = new java.util.HashSet();
        for (int i2 : iArr) {
            this.a0.add(this.Z.get(i2));
        }
        this.c0 = i;
        android.os.Handler handler = this.I;
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback callback = this.t;
        java.util.Objects.requireNonNull(callback);
        handler.post(new defpackage.cn0(callback));
        P();
    }

    public int I(int i, com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (v()) {
            return -3;
        }
        int i2 = 0;
        if (!this.E.isEmpty()) {
            int i3 = 0;
            while (i3 < this.E.size() - 1 && n(this.E.get(i3))) {
                i3++;
            }
            com.google.android.exoplayer2.util.Util.removeRange(this.E, 0, i3);
            com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk = this.E.get(0);
            com.google.android.exoplayer2.Format format = hlsMediaChunk.trackFormat;
            if (!format.equals(this.X)) {
                this.B.downstreamFormatChanged(this.n, format, hlsMediaChunk.trackSelectionReason, hlsMediaChunk.trackSelectionData, hlsMediaChunk.startTimeUs);
            }
            this.X = format;
        }
        int read = this.M[i].read(formatHolder, decoderInputBuffer, z, this.k0);
        if (read == -5) {
            com.google.android.exoplayer2.Format format2 = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(formatHolder.format);
            if (i == this.S) {
                int peekSourceId = this.M[i].peekSourceId();
                while (i2 < this.E.size() && this.E.get(i2).a != peekSourceId) {
                    i2++;
                }
                format2 = format2.withManifestFormatInfo(i2 < this.E.size() ? this.E.get(i2).trackFormat : (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.W));
            }
            formatHolder.format = format2;
        }
        return read;
    }

    public void J() {
        if (this.U) {
            for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue : this.M) {
                hlsSampleQueue.preRelease();
            }
        }
        this.A.release(this);
        this.I.removeCallbacksAndMessages(null);
        this.Y = true;
        this.J.clear();
    }

    public final void K() {
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue : this.M) {
            hlsSampleQueue.reset(this.i0);
        }
        this.i0 = false;
    }

    public final boolean L(long j) {
        int length = this.M.length;
        for (int i = 0; i < length; i++) {
            if (!this.M[i].seekTo(j, false) && (this.f0[i] || !this.d0)) {
                return false;
            }
        }
        return true;
    }

    public boolean M(long j, boolean z) {
        this.g0 = j;
        if (v()) {
            this.h0 = j;
            return true;
        }
        if (this.T && !z && L(j)) {
            return false;
        }
        this.h0 = j;
        this.k0 = false;
        this.E.clear();
        if (this.A.isLoading()) {
            this.A.cancelLoading();
        } else {
            this.A.clearFatalError();
            K();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean N(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        c();
        int i = this.V;
        int i2 = 0;
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            com.google.android.exoplayer2.source.hls.HlsSampleStream hlsSampleStream = (com.google.android.exoplayer2.source.hls.HlsSampleStream) sampleStreamArr[i3];
            if (hlsSampleStream != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                this.V--;
                hlsSampleStream.c();
                sampleStreamArr[i3] = null;
            }
        }
        boolean z4 = z || (!this.j0 ? j == this.g0 : i != 0);
        com.google.android.exoplayer2.trackselection.TrackSelection g = this.u.g();
        boolean z5 = z4;
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = g;
        for (int i4 = 0; i4 < trackSelectionArr.length; i4++) {
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection2 = trackSelectionArr[i4];
            if (trackSelection2 != null) {
                int indexOf = this.Z.indexOf(trackSelection2.getTrackGroup());
                if (indexOf == this.c0) {
                    this.u.p(trackSelection2);
                    trackSelection = trackSelection2;
                }
                if (sampleStreamArr[i4] == null) {
                    this.V++;
                    com.google.android.exoplayer2.source.hls.HlsSampleStream hlsSampleStream2 = new com.google.android.exoplayer2.source.hls.HlsSampleStream(this, indexOf);
                    sampleStreamArr[i4] = hlsSampleStream2;
                    zArr2[i4] = true;
                    if (this.b0 != null) {
                        hlsSampleStream2.a();
                        if (!z5) {
                            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue = this.M[this.b0[indexOf]];
                            z5 = (hlsSampleQueue.seekTo(j, true) || hlsSampleQueue.getReadIndex() == 0) ? false : true;
                        }
                    }
                }
            }
        }
        if (this.V == 0) {
            this.u.m();
            this.X = null;
            this.i0 = true;
            this.E.clear();
            if (this.A.isLoading()) {
                if (this.T) {
                    com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue[] hlsSampleQueueArr = this.M;
                    int length = hlsSampleQueueArr.length;
                    while (i2 < length) {
                        hlsSampleQueueArr[i2].discardToEnd();
                        i2++;
                    }
                }
                this.A.cancelLoading();
            } else {
                K();
            }
        } else {
            if (!this.E.isEmpty() && !com.google.android.exoplayer2.util.Util.areEqual(trackSelection, g)) {
                if (!this.j0) {
                    long j2 = j < 0 ? -j : 0L;
                    com.google.android.exoplayer2.source.hls.HlsMediaChunk p = p();
                    trackSelection.updateSelectedTrack(j, j2, -9223372036854775807L, this.F, this.u.a(p, j));
                    if (trackSelection.getSelectedIndexInTrackGroup() == this.u.f().indexOf(p.trackFormat)) {
                        z3 = false;
                        if (z3) {
                            this.i0 = true;
                            z2 = true;
                            z5 = true;
                            if (z5) {
                                M(j, z2);
                                while (i2 < sampleStreamArr.length) {
                                    if (sampleStreamArr[i2] != null) {
                                        zArr2[i2] = true;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                }
                z3 = true;
                if (z3) {
                }
            }
            z2 = z;
            if (z5) {
            }
        }
        U(sampleStreamArr);
        this.j0 = true;
        return z5;
    }

    public void O(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        if (com.google.android.exoplayer2.util.Util.areEqual(this.n0, drmInitData)) {
            return;
        }
        this.n0 = drmInitData;
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue[] hlsSampleQueueArr = this.M;
            if (i >= hlsSampleQueueArr.length) {
                return;
            }
            if (this.f0[i]) {
                hlsSampleQueueArr[i].s(drmInitData);
            }
            i++;
        }
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    public final void P() {
        this.U = true;
    }

    public void Q(boolean z) {
        this.u.o(z);
    }

    public void R(long j) {
        if (this.m0 != j) {
            this.m0 = j;
            for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue : this.M) {
                hlsSampleQueue.setSampleOffsetUs(j);
            }
        }
    }

    public int S(int i, long j) {
        if (v()) {
            return 0;
        }
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue = this.M[i];
        int skipCount = hlsSampleQueue.getSkipCount(j, this.k0);
        hlsSampleQueue.skip(skipCount);
        return skipCount;
    }

    public void T(int i) {
        c();
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b0);
        int i2 = this.b0[i];
        com.google.android.exoplayer2.util.Assertions.checkState(this.e0[i2]);
        this.e0[i2] = false;
    }

    public final void U(com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr) {
        this.J.clear();
        for (com.google.android.exoplayer2.source.SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream != null) {
                this.J.add((com.google.android.exoplayer2.source.hls.HlsSampleStream) sampleStream);
            }
        }
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    public final void c() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.U);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.Z);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.a0);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> list;
        long max;
        if (this.k0 || this.A.isLoading() || this.A.hasFatalError()) {
            return false;
        }
        if (v()) {
            list = java.util.Collections.emptyList();
            max = this.h0;
            for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue : this.M) {
                hlsSampleQueue.setStartTimeUs(this.h0);
            }
        } else {
            list = this.F;
            com.google.android.exoplayer2.source.hls.HlsMediaChunk p = p();
            max = p.isLoadCompleted() ? p.endTimeUs : java.lang.Math.max(this.g0, p.startTimeUs);
        }
        java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> list2 = list;
        this.u.d(j, max, list2, this.U || !list2.isEmpty(), this.D);
        com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.D;
        boolean z = hlsChunkHolder.endOfStream;
        com.google.android.exoplayer2.source.chunk.Chunk chunk = hlsChunkHolder.chunk;
        android.net.Uri uri = hlsChunkHolder.playlistUrl;
        hlsChunkHolder.clear();
        if (z) {
            this.h0 = -9223372036854775807L;
            this.k0 = true;
            return true;
        }
        if (chunk == null) {
            if (uri != null) {
                this.t.onPlaylistRefreshRequired(uri);
            }
            return false;
        }
        if (u(chunk)) {
            t((com.google.android.exoplayer2.source.hls.HlsMediaChunk) chunk);
        }
        this.L = chunk;
        this.B.loadStarted(new com.google.android.exoplayer2.source.LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, this.A.startLoading(chunk, this, this.z.getMinimumLoadableRetryCount(chunk.type))), chunk.type, this.n, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        return true;
    }

    public int d(int i) {
        c();
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b0);
        int i2 = this.b0[i];
        if (i2 == -1) {
            return this.a0.contains(this.Z.get(i)) ? -3 : -2;
        }
        boolean[] zArr = this.e0;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    public void discardBuffer(long j, boolean z) {
        if (!this.T || v()) {
            return;
        }
        int length = this.M.length;
        for (int i = 0; i < length; i++) {
            this.M[i].discardTo(j, z, this.e0[i]);
        }
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    public final void e() {
        int length = this.M.length;
        int i = 0;
        int i2 = 6;
        int i3 = -1;
        while (true) {
            if (i >= length) {
                break;
            }
            java.lang.String str = ((com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.M[i].getUpstreamFormat())).sampleMimeType;
            int i4 = com.google.android.exoplayer2.util.MimeTypes.isVideo(str) ? 2 : com.google.android.exoplayer2.util.MimeTypes.isAudio(str) ? 1 : com.google.android.exoplayer2.util.MimeTypes.isText(str) ? 3 : 6;
            if (s(i4) > s(i2)) {
                i3 = i;
                i2 = i4;
            } else if (i4 == i2 && i3 != -1) {
                i3 = -1;
            }
            i++;
        }
        com.google.android.exoplayer2.source.TrackGroup f = this.u.f();
        int i5 = f.length;
        this.c0 = -1;
        this.b0 = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.b0[i6] = i6;
        }
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[length];
        for (int i7 = 0; i7 < length; i7++) {
            com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.M[i7].getUpstreamFormat());
            if (i7 == i3) {
                com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[i5];
                if (i5 == 1) {
                    formatArr[0] = format.withManifestFormatInfo(f.getFormat(0));
                } else {
                    for (int i8 = 0; i8 < i5; i8++) {
                        formatArr[i8] = k(f.getFormat(i8), format, true);
                    }
                }
                trackGroupArr[i7] = new com.google.android.exoplayer2.source.TrackGroup(formatArr);
                this.c0 = i7;
            } else {
                trackGroupArr[i7] = new com.google.android.exoplayer2.source.TrackGroup(k((i2 == 2 && com.google.android.exoplayer2.util.MimeTypes.isAudio(format.sampleMimeType)) ? this.w : null, format, false));
            }
        }
        this.Z = j(trackGroupArr);
        com.google.android.exoplayer2.util.Assertions.checkState(this.a0 == null);
        this.a0 = java.util.Collections.emptySet();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.l0 = true;
        this.I.post(this.H);
    }

    public final boolean f(int i) {
        for (int i2 = i; i2 < this.E.size(); i2++) {
            if (this.E.get(i2).d) {
                return false;
            }
        }
        com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk = this.E.get(i);
        for (int i3 = 0; i3 < this.M.length; i3++) {
            if (this.M[i3].getReadIndex() > hlsMediaChunk.getFirstSampleIndex(i3)) {
                return false;
            }
        }
        return true;
    }

    public void g() {
        if (this.U) {
            return;
        }
        continueLoading(this.g0);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        /*
            r7 = this;
            boolean r0 = r7.k0
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.v()
            if (r0 == 0) goto L10
            long r0 = r7.h0
            return r0
        L10:
            long r0 = r7.g0
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r2 = r7.p()
            boolean r3 = r2.isLoadCompleted()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r2 = r7.E
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r2 = r7.E
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r2 = (com.google.android.exoplayer2.source.hls.HlsMediaChunk) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.endTimeUs
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.T
            if (r2 == 0) goto L55
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r2 = r7.M
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.getLargestQueuedTimestampUs()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.getBufferedPositionUs():long");
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (v()) {
            return this.h0;
        }
        if (this.k0) {
            return Long.MIN_VALUE;
        }
        return p().endTimeUs;
    }

    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        c();
        return this.Z;
    }

    public final com.google.android.exoplayer2.source.SampleQueue i(int i, int i2) {
        int length = this.M.length;
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue(this.v, this.I.getLooper(), this.x, this.y, this.K, null);
        if (z) {
            hlsSampleQueue.s(this.n0);
        }
        hlsSampleQueue.setSampleOffsetUs(this.m0);
        com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk = this.o0;
        if (hlsMediaChunk != null) {
            hlsSampleQueue.t(hlsMediaChunk);
        }
        hlsSampleQueue.setUpstreamFormatChangeListener(this);
        int i3 = length + 1;
        int[] copyOf = java.util.Arrays.copyOf(this.N, i3);
        this.N = copyOf;
        copyOf[length] = i;
        this.M = (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue[]) com.google.android.exoplayer2.util.Util.nullSafeArrayAppend(this.M, hlsSampleQueue);
        boolean[] copyOf2 = java.util.Arrays.copyOf(this.f0, i3);
        this.f0 = copyOf2;
        copyOf2[length] = z;
        this.d0 |= z;
        this.O.add(java.lang.Integer.valueOf(i2));
        this.P.append(i2, length);
        if (s(i2) > s(this.R)) {
            this.S = length;
            this.R = i2;
        }
        this.e0 = java.util.Arrays.copyOf(this.e0, i3);
        return hlsSampleQueue;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.A.isLoading();
    }

    public final com.google.android.exoplayer2.source.TrackGroupArray j(com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr) {
        for (int i = 0; i < trackGroupArr.length; i++) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroupArr[i];
            com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[trackGroup.length];
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                com.google.android.exoplayer2.Format format = trackGroup.getFormat(i2);
                formatArr[i2] = format.copyWithExoMediaCryptoType(this.x.getExoMediaCryptoType(format));
            }
            trackGroupArr[i] = new com.google.android.exoplayer2.source.TrackGroup(formatArr);
        }
        return new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
    }

    public final void l(int i) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.A.isLoading());
        while (true) {
            if (i >= this.E.size()) {
                i = -1;
                break;
            } else if (f(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = p().endTimeUs;
        com.google.android.exoplayer2.source.hls.HlsMediaChunk m = m(i);
        if (this.E.isEmpty()) {
            this.h0 = this.g0;
        } else {
            ((com.google.android.exoplayer2.source.hls.HlsMediaChunk) com.google.common.collect.Iterables.getLast(this.E)).f();
        }
        this.k0 = false;
        this.B.upstreamDiscarded(this.R, m.startTimeUs, j);
    }

    public final com.google.android.exoplayer2.source.hls.HlsMediaChunk m(int i) {
        com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk = this.E.get(i);
        java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> arrayList = this.E;
        com.google.android.exoplayer2.util.Util.removeRange(arrayList, i, arrayList.size());
        for (int i2 = 0; i2 < this.M.length; i2++) {
            this.M[i2].discardUpstreamSamples(hlsMediaChunk.getFirstSampleIndex(i2));
        }
        return hlsMediaChunk;
    }

    public void maybeThrowPrepareError() throws java.io.IOException {
        z();
        if (this.k0 && !this.U) {
            throw new com.google.android.exoplayer2.ParserException("Loading finished before preparation is complete.");
        }
    }

    public final boolean n(com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk) {
        int i = hlsMediaChunk.a;
        int length = this.M.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.e0[i2] && this.M[i2].peekSourceId() == i) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue : this.M) {
            hlsSampleQueue.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(com.google.android.exoplayer2.Format format) {
        this.I.post(this.G);
    }

    public final com.google.android.exoplayer2.source.hls.HlsMediaChunk p() {
        return this.E.get(r0.size() - 1);
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.TrackOutput q(int i, int i2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(p0.contains(java.lang.Integer.valueOf(i2)));
        int i3 = this.P.get(i2, -1);
        if (i3 == -1) {
            return null;
        }
        if (this.O.add(java.lang.Integer.valueOf(i2))) {
            this.N[i3] = i;
        }
        return this.N[i3] == i ? this.M[i3] : h(i, i2);
    }

    public int r() {
        return this.c0;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        if (this.A.hasFatalError() || v()) {
            return;
        }
        if (this.A.isLoading()) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.L);
            if (this.u.q(j, this.L, this.F)) {
                this.A.cancelLoading();
                return;
            }
            return;
        }
        int e = this.u.e(j, this.F);
        if (e < this.E.size()) {
            l(e);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
    }

    public final void t(com.google.android.exoplayer2.source.hls.HlsMediaChunk hlsMediaChunk) {
        this.o0 = hlsMediaChunk;
        this.W = hlsMediaChunk.trackFormat;
        this.h0 = -9223372036854775807L;
        this.E.add(hlsMediaChunk);
        com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue : this.M) {
            builder.add((com.google.common.collect.ImmutableList.Builder) java.lang.Integer.valueOf(hlsSampleQueue.getWriteIndex()));
        }
        hlsMediaChunk.e(this, builder.build());
        for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue2 : this.M) {
            hlsSampleQueue2.t(hlsMediaChunk);
            if (hlsMediaChunk.d) {
                hlsSampleQueue2.splice();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public com.google.android.exoplayer2.extractor.TrackOutput track(int i, int i2) {
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput;
        if (!p0.contains(java.lang.Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                com.google.android.exoplayer2.extractor.TrackOutput[] trackOutputArr = this.M;
                if (i3 >= trackOutputArr.length) {
                    trackOutput = null;
                    break;
                }
                if (this.N[i3] == i) {
                    trackOutput = trackOutputArr[i3];
                    break;
                }
                i3++;
            }
        } else {
            trackOutput = q(i, i2);
        }
        if (trackOutput == null) {
            if (this.l0) {
                return h(i, i2);
            }
            trackOutput = i(i, i2);
        }
        if (i2 != 4) {
            return trackOutput;
        }
        if (this.Q == null) {
            this.Q = new com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.EmsgUnwrappingTrackOutput(trackOutput, this.C);
        }
        return this.Q;
    }

    public final boolean v() {
        return this.h0 != -9223372036854775807L;
    }

    public boolean w(int i) {
        return !v() && this.M[i].isReady(this.k0);
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackGroups"})
    public final void x() {
        int i = this.Z.length;
        int[] iArr = new int[i];
        this.b0 = iArr;
        java.util.Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue[] hlsSampleQueueArr = this.M;
                if (i3 >= hlsSampleQueueArr.length) {
                    break;
                }
                if (o((com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(hlsSampleQueueArr[i3].getUpstreamFormat()), this.Z.get(i2).getFormat(0))) {
                    this.b0[i2] = i3;
                    break;
                }
                i3++;
            }
        }
        java.util.Iterator<com.google.android.exoplayer2.source.hls.HlsSampleStream> it = this.J.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final void y() {
        if (!this.Y && this.b0 == null && this.T) {
            for (com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.HlsSampleQueue hlsSampleQueue : this.M) {
                if (hlsSampleQueue.getUpstreamFormat() == null) {
                    return;
                }
            }
            if (this.Z != null) {
                x();
                return;
            }
            e();
            P();
            this.t.onPrepared();
        }
    }

    public void z() throws java.io.IOException {
        this.A.maybeThrowError();
        this.u.j();
    }
}
