package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public interface MediaSourceEventListener {

    public static class EventDispatcher {
        public final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> a;
        public final long b;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public static final class ListenerAndHandler {
            public android.os.Handler a;
            public com.google.android.exoplayer2.source.MediaSourceEventListener b;

            public ListenerAndHandler(android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
                this.a = handler;
                this.b = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new java.util.concurrent.CopyOnWriteArrayList(), 0, null, 0L);
        }

        public EventDispatcher(java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> copyOnWriteArrayList, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j) {
            this.a = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId;
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onDownstreamFormatChanged(this.windowIndex, this.mediaPeriodId, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCanceled(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCompleted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
            mediaSourceEventListener.onLoadError(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadStarted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onUpstreamDiscarded(this.windowIndex, mediaPeriodId, mediaLoadData);
        }

        public void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(handler);
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaSourceEventListener);
            this.a.add(new com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void downstreamFormatChanged(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i2, @androidx.annotation.Nullable java.lang.Object obj, long j) {
            downstreamFormatChanged(new com.google.android.exoplayer2.source.MediaLoadData(1, i, format, i2, obj, g(j), -9223372036854775807L));
        }

        public void downstreamFormatChanged(com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.pd1(this, next.b, mediaLoadData));
            }
        }

        public final long g(long j) {
            long usToMs = com.google.android.exoplayer2.C.usToMs(j);
            if (usToMs == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.b + usToMs;
        }

        public void loadCanceled(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, int i) {
            loadCanceled(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void loadCanceled(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, int i, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i3, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2) {
            loadCanceled(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(i, i2, format, i3, obj, g(j), g(j2)));
        }

        public void loadCanceled(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.sd1(this, next.b, loadEventInfo, mediaLoadData));
            }
        }

        public void loadCompleted(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, int i) {
            loadCompleted(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void loadCompleted(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, int i, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i3, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2) {
            loadCompleted(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(i, i2, format, i3, obj, g(j), g(j2)));
        }

        public void loadCompleted(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.rd1(this, next.b, loadEventInfo, mediaLoadData));
            }
        }

        public void loadError(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, int i, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i3, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2, java.io.IOException iOException, boolean z) {
            loadError(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(i, i2, format, i3, obj, g(j), g(j2)), iOException, z);
        }

        public void loadError(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, int i, java.io.IOException iOException, boolean z) {
            loadError(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        public void loadError(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.qd1(this, next.b, loadEventInfo, mediaLoadData, iOException, z));
            }
        }

        public void loadStarted(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, int i) {
            loadStarted(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void loadStarted(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, int i, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i3, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2) {
            loadStarted(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(i, i2, format, i3, obj, g(j), g(j2)));
        }

        public void loadStarted(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.od1(this, next.b, loadEventInfo, mediaLoadData));
            }
        }

        public void removeEventListener(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                if (next.b == mediaSourceEventListener) {
                    this.a.remove(next);
                }
            }
        }

        public void upstreamDiscarded(int i, long j, long j2) {
            upstreamDiscarded(new com.google.android.exoplayer2.source.MediaLoadData(1, i, null, 3, null, g(j), g(j2)));
        }

        public void upstreamDiscarded(com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.mediaPeriodId);
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.td1(this, next.b, mediaPeriodId, mediaLoadData));
            }
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher withParameters(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j) {
            return new com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher(this.a, i, mediaPeriodId, j);
        }
    }

    void onDownstreamFormatChanged(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData);

    void onLoadCanceled(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData);

    void onLoadCompleted(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData);

    void onLoadError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z);

    void onLoadStarted(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData);

    void onUpstreamDiscarded(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData);
}
