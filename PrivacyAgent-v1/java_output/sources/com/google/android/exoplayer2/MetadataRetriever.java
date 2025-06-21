package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class MetadataRetriever {

    public static final class MetadataRetrieverInternal {
        public final com.google.android.exoplayer2.source.MediaSourceFactory a;
        public final android.os.HandlerThread b;
        public final android.os.Handler c;
        public final com.google.common.util.concurrent.SettableFuture<com.google.android.exoplayer2.source.TrackGroupArray> d;

        public final class MediaSourceHandlerCallback implements android.os.Handler.Callback {
            public final com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback.MediaSourceCaller n = new com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback.MediaSourceCaller();
            public com.google.android.exoplayer2.source.MediaSource t;
            public com.google.android.exoplayer2.source.MediaPeriod u;

            public final class MediaSourceCaller implements com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller {
                public final com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback.MediaSourceCaller.MediaPeriodCallback n = new com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback.MediaSourceCaller.MediaPeriodCallback(this, null);
                public final com.google.android.exoplayer2.upstream.Allocator t = new com.google.android.exoplayer2.upstream.DefaultAllocator(true, 65536);
                public boolean u;

                public final class MediaPeriodCallback implements com.google.android.exoplayer2.source.MediaPeriod.Callback {
                    public MediaPeriodCallback() {
                    }

                    public /* synthetic */ MediaPeriodCallback(com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback.MediaSourceCaller mediaSourceCaller, com.google.android.exoplayer2.MetadataRetriever.AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
                        com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.c.obtainMessage(2).sendToTarget();
                    }

                    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
                    public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
                        com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.d.set(mediaPeriod.getTrackGroups());
                        com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.c.obtainMessage(3).sendToTarget();
                    }
                }

                public MediaSourceCaller() {
                }

                @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
                public void onSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
                    if (this.u) {
                        return;
                    }
                    this.u = true;
                    com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback.this.u = mediaSource.createPeriod(new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0)), this.t, 0L);
                    com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback.this.u.prepare(this.n, 0L);
                }
            }

            public MediaSourceHandlerCallback() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                int i = message.what;
                if (i == 0) {
                    com.google.android.exoplayer2.source.MediaSource createMediaSource = com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.a.createMediaSource((com.google.android.exoplayer2.MediaItem) message.obj);
                    this.t = createMediaSource;
                    createMediaSource.prepareSource(this.n, null);
                    com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.c.sendEmptyMessage(1);
                    return true;
                }
                if (i == 1) {
                    try {
                        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.u;
                        if (mediaPeriod == null) {
                            ((com.google.android.exoplayer2.source.MediaSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.t)).maybeThrowSourceInfoRefreshError();
                        } else {
                            mediaPeriod.maybeThrowPrepareError();
                        }
                        com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.c.sendEmptyMessageDelayed(1, 100L);
                    } catch (java.lang.Exception e) {
                        com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.d.setException(e);
                        com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.c.obtainMessage(3).sendToTarget();
                    }
                    return true;
                }
                if (i == 2) {
                    ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.u)).continueLoading(0L);
                    return true;
                }
                if (i != 3) {
                    return false;
                }
                if (this.u != null) {
                    ((com.google.android.exoplayer2.source.MediaSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.t)).releasePeriod(this.u);
                }
                ((com.google.android.exoplayer2.source.MediaSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.t)).releaseSource(this.n);
                com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.c.removeCallbacksAndMessages(null);
                com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.this.b.quit();
                return true;
            }
        }

        public MetadataRetrieverInternal(com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory) {
            this.a = mediaSourceFactory;
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("ExoPlayer:MetadataRetriever");
            this.b = handlerThread;
            handlerThread.start();
            this.c = com.google.android.exoplayer2.util.Util.createHandler(handlerThread.getLooper(), new com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback());
            this.d = com.google.common.util.concurrent.SettableFuture.create();
        }

        public com.google.common.util.concurrent.ListenableFuture<com.google.android.exoplayer2.source.TrackGroupArray> e(com.google.android.exoplayer2.MediaItem mediaItem) {
            this.c.obtainMessage(0, mediaItem).sendToTarget();
            return this.d;
        }
    }

    public static com.google.common.util.concurrent.ListenableFuture<com.google.android.exoplayer2.source.TrackGroupArray> retrieveMetadata(android.content.Context context, com.google.android.exoplayer2.MediaItem mediaItem) {
        return retrieveMetadata(new com.google.android.exoplayer2.source.DefaultMediaSourceFactory(context), mediaItem);
    }

    public static com.google.common.util.concurrent.ListenableFuture<com.google.android.exoplayer2.source.TrackGroupArray> retrieveMetadata(com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.MediaItem mediaItem) {
        return new com.google.android.exoplayer2.MetadataRetriever.MetadataRetrieverInternal(mediaSourceFactory).e(mediaItem);
    }
}
