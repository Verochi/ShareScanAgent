package com.google.android.exoplayer2.source.ads;

/* loaded from: classes22.dex */
public final class AdsMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> {
    public static final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId M = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(new java.lang.Object());
    public final com.google.android.exoplayer2.source.MediaSource B;
    public final com.google.android.exoplayer2.source.MediaSourceFactory C;
    public final com.google.android.exoplayer2.source.ads.AdsLoader D;
    public final com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider E;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.DataSpec F;
    public final android.os.Handler G;
    public final com.google.android.exoplayer2.Timeline.Period H;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener I;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Timeline J;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.ads.AdPlaybackState K;
    public com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[][] L;

    public static final class AdLoadException extends java.io.IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private AdLoadException(int i, java.lang.Exception exc) {
            super(exc);
            this.type = i;
        }

        public static com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException createForAd(java.lang.Exception exc) {
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException(0, exc);
        }

        public static com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException createForAdGroup(java.lang.Exception exc, int i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(35);
            sb.append("Failed to load ad group ");
            sb.append(i);
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException(1, new java.io.IOException(sb.toString(), exc));
        }

        public static com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException createForAllAds(java.lang.Exception exc) {
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException(2, exc);
        }

        public static com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException createForUnexpected(java.lang.RuntimeException runtimeException) {
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException(3, runtimeException);
        }

        public java.lang.RuntimeException getRuntimeExceptionForUnexpected() {
            com.google.android.exoplayer2.util.Assertions.checkState(this.type == 3);
            return (java.lang.RuntimeException) com.google.android.exoplayer2.util.Assertions.checkNotNull(getCause());
        }
    }

    public final class AdMediaSourceHolder {
        public final com.google.android.exoplayer2.source.MediaSource a;
        public final java.util.List<com.google.android.exoplayer2.source.MaskingMediaPeriod> b = new java.util.ArrayList();
        public com.google.android.exoplayer2.Timeline c;

        public AdMediaSourceHolder(com.google.android.exoplayer2.source.MediaSource mediaSource) {
            this.a = mediaSource;
        }

        public com.google.android.exoplayer2.source.MediaPeriod a(android.net.Uri uri, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
            com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod = new com.google.android.exoplayer2.source.MaskingMediaPeriod(this.a, mediaPeriodId, allocator, j);
            maskingMediaPeriod.setPrepareListener(com.google.android.exoplayer2.source.ads.AdsMediaSource.this.new AdPrepareListener(uri));
            this.b.add(maskingMediaPeriod);
            com.google.android.exoplayer2.Timeline timeline = this.c;
            if (timeline != null) {
                maskingMediaPeriod.createPeriod(new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0), mediaPeriodId.windowSequenceNumber));
            }
            return maskingMediaPeriod;
        }

        public long b() {
            com.google.android.exoplayer2.Timeline timeline = this.c;
            if (timeline == null) {
                return -9223372036854775807L;
            }
            return timeline.getPeriod(0, com.google.android.exoplayer2.source.ads.AdsMediaSource.this.H).getDurationUs();
        }

        public void c(com.google.android.exoplayer2.Timeline timeline) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(timeline.getPeriodCount() == 1);
            if (this.c == null) {
                java.lang.Object uidOfPeriod = timeline.getUidOfPeriod(0);
                for (int i = 0; i < this.b.size(); i++) {
                    com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod = this.b.get(i);
                    maskingMediaPeriod.createPeriod(new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(uidOfPeriod, maskingMediaPeriod.id.windowSequenceNumber));
                }
            }
            this.c = timeline;
        }

        public boolean d() {
            return this.b.isEmpty();
        }

        public void e(com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod) {
            this.b.remove(maskingMediaPeriod);
            maskingMediaPeriod.releasePeriod();
        }
    }

    public final class AdPrepareListener implements com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener {
        public final android.net.Uri a;

        public AdPrepareListener(android.net.Uri uri) {
            this.a = uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.D.handlePrepareComplete(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.io.IOException iOException) {
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.D.handlePrepareError(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, iOException);
        }

        @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
        public void onPrepareComplete(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.G.post(new com.google.android.exoplayer2.source.ads.b(this, mediaPeriodId));
        }

        @Override // com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener
        public void onPrepareError(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.io.IOException iOException) {
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.createEventDispatcher(mediaPeriodId).loadError(new com.google.android.exoplayer2.source.LoadEventInfo(com.google.android.exoplayer2.source.LoadEventInfo.getNewId(), new com.google.android.exoplayer2.upstream.DataSpec(this.a), android.os.SystemClock.elapsedRealtime()), 6, (java.io.IOException) com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException.createForAd(iOException), true);
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.G.post(new com.google.android.exoplayer2.source.ads.c(this, mediaPeriodId, iOException));
        }
    }

    public final class ComponentListener implements com.google.android.exoplayer2.source.ads.AdsLoader.EventListener {
        public final android.os.Handler a = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper();
        public volatile boolean b;

        public ComponentListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
            if (this.b) {
                return;
            }
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.m(adPlaybackState);
        }

        public void c() {
            this.b = true;
            this.a.removeCallbacksAndMessages(null);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public /* synthetic */ void onAdClicked() {
            defpackage.x7.a(this);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdLoadError(com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException adLoadException, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            if (this.b) {
                return;
            }
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.createEventDispatcher(null).loadError(new com.google.android.exoplayer2.source.LoadEventInfo(com.google.android.exoplayer2.source.LoadEventInfo.getNewId(), dataSpec, android.os.SystemClock.elapsedRealtime()), 6, (java.io.IOException) adLoadException, true);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdPlaybackState(com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
            if (this.b) {
                return;
            }
            this.a.post(new com.google.android.exoplayer2.source.ads.d(this, adPlaybackState));
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public /* synthetic */ void onAdTapped() {
            defpackage.x7.d(this);
        }
    }

    @java.lang.Deprecated
    public AdsMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.source.ads.AdsLoader adsLoader, com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider) {
        this(mediaSource, mediaSourceFactory, adsLoader, adViewProvider, (com.google.android.exoplayer2.upstream.DataSpec) null);
    }

    public AdsMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.source.ads.AdsLoader adsLoader, com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        this.B = mediaSource;
        this.C = mediaSourceFactory;
        this.D = adsLoader;
        this.E = adViewProvider;
        this.F = dataSpec;
        this.G = new android.os.Handler(android.os.Looper.getMainLooper());
        this.H = new com.google.android.exoplayer2.Timeline.Period();
        this.L = new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[0][];
        adsLoader.setSupportedContentTypes(mediaSourceFactory.getSupportedTypes());
    }

    @java.lang.Deprecated
    public AdsMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.ads.AdsLoader adsLoader, com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider) {
        this(mediaSource, new com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory(factory), adsLoader, adViewProvider, (com.google.android.exoplayer2.upstream.DataSpec) null);
    }

    public AdsMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.source.ads.AdsLoader adsLoader, com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider) {
        this(mediaSource, mediaSourceFactory, adsLoader, adViewProvider, dataSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener componentListener) {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = this.F;
        if (dataSpec != null) {
            this.D.setAdTagDataSpec(dataSpec);
        }
        this.D.start(componentListener, this.E);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder adMediaSourceHolder;
        com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState = (com.google.android.exoplayer2.source.ads.AdPlaybackState) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.K);
        if (adPlaybackState.adGroupCount <= 0 || !mediaPeriodId.isAd()) {
            com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod = new com.google.android.exoplayer2.source.MaskingMediaPeriod(this.B, mediaPeriodId, allocator, j);
            maskingMediaPeriod.createPeriod(mediaPeriodId);
            return maskingMediaPeriod;
        }
        int i = mediaPeriodId.adGroupIndex;
        int i2 = mediaPeriodId.adIndexInAdGroup;
        android.net.Uri uri = (android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(adPlaybackState.adGroups[i].uris[i2]);
        com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[][] adMediaSourceHolderArr = this.L;
        com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i];
        if (adMediaSourceHolderArr2.length <= i2) {
            adMediaSourceHolderArr[i] = (com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[]) java.util.Arrays.copyOf(adMediaSourceHolderArr2, i2 + 1);
        }
        com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder adMediaSourceHolder2 = this.L[i][i2];
        if (adMediaSourceHolder2 == null) {
            com.google.android.exoplayer2.source.MediaSource createMediaSource = this.C.createMediaSource(com.google.android.exoplayer2.MediaItem.fromUri(uri));
            adMediaSourceHolder = new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder(createMediaSource);
            this.L[i][i2] = adMediaSourceHolder;
            prepareChildSource(mediaPeriodId, createMediaSource);
        } else {
            adMediaSourceHolder = adMediaSourceHolder2;
        }
        return adMediaSourceHolder.a(uri, mediaPeriodId, allocator, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.B.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.B.getTag();
    }

    public final long[][] j() {
        long[][] jArr = new long[this.L.length][];
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[][] adMediaSourceHolderArr = this.L;
            if (i >= adMediaSourceHolderArr.length) {
                return jArr;
            }
            jArr[i] = new long[adMediaSourceHolderArr[i].length];
            int i2 = 0;
            while (true) {
                com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[] adMediaSourceHolderArr2 = this.L[i];
                if (i2 < adMediaSourceHolderArr2.length) {
                    com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr2[i2];
                    jArr[i][i2] = adMediaSourceHolder == null ? -9223372036854775807L : adMediaSourceHolder.b();
                    i2++;
                }
            }
            i++;
        }
    }

    public final void l() {
        com.google.android.exoplayer2.Timeline timeline = this.J;
        com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState = this.K;
        if (adPlaybackState == null || timeline == null) {
            return;
        }
        com.google.android.exoplayer2.source.ads.AdPlaybackState withAdDurationsUs = adPlaybackState.withAdDurationsUs(j());
        this.K = withAdDurationsUs;
        if (withAdDurationsUs.adGroupCount != 0) {
            timeline = new com.google.android.exoplayer2.source.ads.SinglePeriodAdTimeline(timeline, this.K);
        }
        refreshSourceInfo(timeline);
    }

    public final void m(com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
        if (this.K == null) {
            com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[][] adMediaSourceHolderArr = new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[adPlaybackState.adGroupCount][];
            this.L = adMediaSourceHolderArr;
            java.util.Arrays.fill(adMediaSourceHolderArr, new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[0]);
        }
        this.K = adPlaybackState;
        l();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void b(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        if (mediaPeriodId.isAd()) {
            ((com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.L[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup])).c(timeline);
        } else {
            com.google.android.exoplayer2.util.Assertions.checkArgument(timeline.getPeriodCount() == 1);
            this.J = timeline;
        }
        l();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener componentListener = new com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener();
        this.I = componentListener;
        prepareChildSource(M, this.B);
        this.G.post(new com.google.android.exoplayer2.source.ads.a(this, componentListener));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod = (com.google.android.exoplayer2.source.MaskingMediaPeriod) mediaPeriod;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.id;
        if (!mediaPeriodId.isAd()) {
            maskingMediaPeriod.releasePeriod();
            return;
        }
        com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder adMediaSourceHolder = (com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.L[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup]);
        adMediaSourceHolder.e(maskingMediaPeriod);
        if (adMediaSourceHolder.d()) {
            releaseChildSource(mediaPeriodId);
            this.L[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup] = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        ((com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.I)).c();
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdMediaSourceHolder[0][];
        android.os.Handler handler = this.G;
        com.google.android.exoplayer2.source.ads.AdsLoader adsLoader = this.D;
        java.util.Objects.requireNonNull(adsLoader);
        handler.post(new defpackage.y7(adsLoader));
    }
}
