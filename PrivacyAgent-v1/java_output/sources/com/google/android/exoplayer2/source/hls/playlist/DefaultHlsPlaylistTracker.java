package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes22.dex */
public final class DefaultHlsPlaylistTracker implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist>> {
    public static final double DEFAULT_PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5d;
    public static final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory FACTORY = new defpackage.pz();

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.Loader A;

    @androidx.annotation.Nullable
    public android.os.Handler B;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener C;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist D;

    @androidx.annotation.Nullable
    public android.net.Uri E;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist F;
    public boolean G;
    public long H;
    public final com.google.android.exoplayer2.source.hls.HlsDataSourceFactory n;
    public final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory t;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy u;
    public final java.util.HashMap<android.net.Uri, com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle> v;
    public final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener> w;
    public final double x;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> y;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher z;

    public final class MediaPlaylistBundle implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist>>, java.lang.Runnable {
        public boolean A;
        public java.io.IOException B;
        public final android.net.Uri n;
        public final com.google.android.exoplayer2.upstream.Loader t = new com.google.android.exoplayer2.upstream.Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        public final com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> u;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist v;
        public long w;
        public long x;
        public long y;
        public long z;

        public MediaPlaylistBundle(android.net.Uri uri) {
            this.n = uri;
            this.u = new com.google.android.exoplayer2.upstream.ParsingLoadable<>(com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.n.createDataSource(4), uri, 4, com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.y);
        }

        public final boolean d(long j) {
            this.z = android.os.SystemClock.elapsedRealtime() + j;
            return this.n.equals(com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.E) && !com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.r();
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist e() {
            return this.v;
        }

        public boolean f() {
            int i;
            if (this.v == null) {
                return false;
            }
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            long max = java.lang.Math.max(30000L, com.google.android.exoplayer2.C.usToMs(this.v.durationUs));
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist = this.v;
            return hlsMediaPlaylist.hasEndTag || (i = hlsMediaPlaylist.playlistType) == 2 || i == 1 || this.w + max > elapsedRealtime;
        }

        public void g() {
            this.z = 0L;
            if (this.A || this.t.isLoading() || this.t.hasFatalError()) {
                return;
            }
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (elapsedRealtime >= this.y) {
                h();
            } else {
                this.A = true;
                com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.B.postDelayed(this, this.y - elapsedRealtime);
            }
        }

        public final void h() {
            long startLoading = this.t.startLoading(this.u, this, com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.u.getMinimumLoadableRetryCount(this.u.type));
            com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.z;
            com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable = this.u;
            eventDispatcher.loadStarted(new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, startLoading), this.u.type);
        }

        public void i() throws java.io.IOException {
            this.t.maybeThrowError();
            java.io.IOException iOException = this.B;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j, long j2, boolean z) {
            com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.u.onLoadTaskConcluded(parsingLoadable.loadTaskId);
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.z.loadCanceled(loadEventInfo, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist result = parsingLoadable.getResult();
            com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) {
                m((com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) result, loadEventInfo);
                com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.z.loadCompleted(loadEventInfo, 4);
            } else {
                this.B = new com.google.android.exoplayer2.ParserException("Loaded playlist has unexpected type.");
                com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.z.loadError(loadEventInfo, 4, this.B, true);
            }
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.u.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j, long j2, java.io.IOException iOException, int i) {
            com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorAction;
            com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(parsingLoadable.type), iOException, i);
            long blacklistDurationMsFor = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.u.getBlacklistDurationMsFor(loadErrorInfo);
            boolean z = blacklistDurationMsFor != -9223372036854775807L;
            boolean z2 = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.t(this.n, blacklistDurationMsFor) || !z;
            if (z) {
                z2 |= d(blacklistDurationMsFor);
            }
            if (z2) {
                long retryDelayMsFor = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.u.getRetryDelayMsFor(loadErrorInfo);
                loadErrorAction = retryDelayMsFor != -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
            } else {
                loadErrorAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
            }
            boolean isRetry = true ^ loadErrorAction.isRetry();
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.z.loadError(loadEventInfo, parsingLoadable.type, iOException, isRetry);
            if (isRetry) {
                com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.u.onLoadTaskConcluded(parsingLoadable.loadTaskId);
            }
            return loadErrorAction;
        }

        public final void m(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2 = this.v;
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.w = elapsedRealtime;
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist n = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.n(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.v = n;
            if (n != hlsMediaPlaylist2) {
                this.B = null;
                this.x = elapsedRealtime;
                com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.u(this.n, n);
            } else if (!n.hasEndTag) {
                if (hlsMediaPlaylist.mediaSequence + hlsMediaPlaylist.segments.size() < this.v.mediaSequence) {
                    this.B = new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistResetException(this.n);
                    com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.t(this.n, -9223372036854775807L);
                } else if (elapsedRealtime - this.x > com.google.android.exoplayer2.C.usToMs(r12.targetDurationUs) * com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.x) {
                    this.B = new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistStuckException(this.n);
                    long blacklistDurationMsFor = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.u.getBlacklistDurationMsFor(new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(4), this.B, 1));
                    com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.t(this.n, blacklistDurationMsFor);
                    if (blacklistDurationMsFor != -9223372036854775807L) {
                        d(blacklistDurationMsFor);
                    }
                }
            }
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist3 = this.v;
            this.y = elapsedRealtime + com.google.android.exoplayer2.C.usToMs(hlsMediaPlaylist3 != hlsMediaPlaylist2 ? hlsMediaPlaylist3.targetDurationUs : hlsMediaPlaylist3.targetDurationUs / 2);
            if (!this.n.equals(com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.E) || this.v.hasEndTag) {
                return;
            }
            g();
        }

        public void n() {
            this.t.release();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.A = false;
            h();
        }
    }

    public DefaultHlsPlaylistTracker(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5d);
    }

    public DefaultHlsPlaylistTracker(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory, double d) {
        this.n = hlsDataSourceFactory;
        this.t = hlsPlaylistParserFactory;
        this.u = loadErrorHandlingPolicy;
        this.x = d;
        this.w = new java.util.ArrayList();
        this.v = new java.util.HashMap<>();
        this.H = -9223372036854775807L;
    }

    public static com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment m(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2) {
        int i = (int) (hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence);
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void addListener(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(playlistEventListener);
        this.w.add(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long getInitialStartTimeUs() {
        return this.H;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist getMasterPlaylist() {
        return this.D;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist getPlaylistSnapshot(android.net.Uri uri, boolean z) {
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist e = this.v.get(uri).e();
        if (e != null && z) {
            s(uri);
        }
        return e;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isLive() {
        return this.G;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isSnapshotValid(android.net.Uri uri) {
        return this.v.get(uri).f();
    }

    public final void l(java.util.List<android.net.Uri> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            android.net.Uri uri = list.get(i);
            this.v.put(uri, new com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle(uri));
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPlaylistRefreshError(android.net.Uri uri) throws java.io.IOException {
        this.v.get(uri).i();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPrimaryPlaylistRefreshError() throws java.io.IOException {
        com.google.android.exoplayer2.upstream.Loader loader = this.A;
        if (loader != null) {
            loader.maybeThrowError();
        }
        android.net.Uri uri = this.E;
        if (uri != null) {
            maybeThrowPlaylistRefreshError(uri);
        }
    }

    public final com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist n(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2) {
        return !hlsMediaPlaylist2.isNewerThan(hlsMediaPlaylist) ? hlsMediaPlaylist2.hasEndTag ? hlsMediaPlaylist.copyWithEndTag() : hlsMediaPlaylist : hlsMediaPlaylist2.copyWith(p(hlsMediaPlaylist, hlsMediaPlaylist2), o(hlsMediaPlaylist, hlsMediaPlaylist2));
    }

    public final int o(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2) {
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment m;
        if (hlsMediaPlaylist2.hasDiscontinuitySequence) {
            return hlsMediaPlaylist2.discontinuitySequence;
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist3 = this.F;
        int i = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.discontinuitySequence : 0;
        return (hlsMediaPlaylist == null || (m = m(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) ? i : (hlsMediaPlaylist.discontinuitySequence + m.relativeDiscontinuitySequence) - hlsMediaPlaylist2.segments.get(0).relativeDiscontinuitySequence;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j, long j2, boolean z) {
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.u.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.z.loadCanceled(loadEventInfo, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist result = parsingLoadable.getResult();
        boolean z = result instanceof com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist createSingleVariantMasterPlaylist = z ? com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.createSingleVariantMasterPlaylist(result.baseUri) : (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) result;
        this.D = createSingleVariantMasterPlaylist;
        this.y = this.t.createPlaylistParser(createSingleVariantMasterPlaylist);
        this.E = createSingleVariantMasterPlaylist.variants.get(0).url;
        l(createSingleVariantMasterPlaylist.mediaPlaylistUrls);
        com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle = this.v.get(this.E);
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        if (z) {
            mediaPlaylistBundle.m((com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) result, loadEventInfo);
        } else {
            mediaPlaylistBundle.g();
        }
        this.u.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.z.loadCompleted(loadEventInfo, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j, long j2, java.io.IOException iOException, int i) {
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        long retryDelayMsFor = this.u.getRetryDelayMsFor(new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(parsingLoadable.type), iOException, i));
        boolean z = retryDelayMsFor == -9223372036854775807L;
        this.z.loadError(loadEventInfo, parsingLoadable.type, iOException, z);
        if (z) {
            this.u.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        }
        return z ? com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL : com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor);
    }

    public final long p(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.hasProgramDateTime) {
            return hlsMediaPlaylist2.startTimeUs;
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist3 = this.F;
        long j = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.startTimeUs : 0L;
        if (hlsMediaPlaylist == null) {
            return j;
        }
        int size = hlsMediaPlaylist.segments.size();
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment m = m(hlsMediaPlaylist, hlsMediaPlaylist2);
        return m != null ? hlsMediaPlaylist.startTimeUs + m.relativeStartTimeUs : ((long) size) == hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence ? hlsMediaPlaylist.getEndTimeUs() : j;
    }

    public final boolean q(android.net.Uri uri) {
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant> list = this.D.variants;
        for (int i = 0; i < list.size(); i++) {
            if (uri.equals(list.get(i).url)) {
                return true;
            }
        }
        return false;
    }

    public final boolean r() {
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant> list = this.D.variants;
        int size = list.size();
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle = this.v.get(list.get(i).url);
            if (elapsedRealtime > mediaPlaylistBundle.z) {
                this.E = mediaPlaylistBundle.n;
                mediaPlaylistBundle.g();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void refreshPlaylist(android.net.Uri uri) {
        this.v.get(uri).g();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void removeListener(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.w.remove(playlistEventListener);
    }

    public final void s(android.net.Uri uri) {
        if (uri.equals(this.E) || !q(uri)) {
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist = this.F;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.hasEndTag) {
            this.E = uri;
            this.v.get(uri).g();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void start(android.net.Uri uri, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        this.B = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper();
        this.z = eventDispatcher;
        this.C = primaryPlaylistListener;
        com.google.android.exoplayer2.upstream.ParsingLoadable parsingLoadable = new com.google.android.exoplayer2.upstream.ParsingLoadable(this.n.createDataSource(4), uri, 4, this.t.createPlaylistParser());
        com.google.android.exoplayer2.util.Assertions.checkState(this.A == null);
        com.google.android.exoplayer2.upstream.Loader loader = new com.google.android.exoplayer2.upstream.Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.A = loader;
        eventDispatcher.loadStarted(new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, loader.startLoading(parsingLoadable, this, this.u.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.E = null;
        this.F = null;
        this.D = null;
        this.H = -9223372036854775807L;
        this.A.release();
        this.A = null;
        java.util.Iterator<com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle> it = this.v.values().iterator();
        while (it.hasNext()) {
            it.next().n();
        }
        this.B.removeCallbacksAndMessages(null);
        this.B = null;
        this.v.clear();
    }

    public final boolean t(android.net.Uri uri, long j) {
        int size = this.w.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            z |= !this.w.get(i).onPlaylistError(uri, j);
        }
        return z;
    }

    public final void u(android.net.Uri uri, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        if (uri.equals(this.E)) {
            if (this.F == null) {
                this.G = !hlsMediaPlaylist.hasEndTag;
                this.H = hlsMediaPlaylist.startTimeUs;
            }
            this.F = hlsMediaPlaylist;
            this.C.onPrimaryPlaylistRefreshed(hlsMediaPlaylist);
        }
        int size = this.w.size();
        for (int i = 0; i < size; i++) {
            this.w.get(i).onPlaylistChanged();
        }
    }
}
