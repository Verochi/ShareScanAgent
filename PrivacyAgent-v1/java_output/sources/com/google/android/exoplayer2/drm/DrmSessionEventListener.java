package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public interface DrmSessionEventListener {

    public static class EventDispatcher {
        public final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> a;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public static final class ListenerAndHandler {
            public android.os.Handler a;
            public com.google.android.exoplayer2.drm.DrmSessionEventListener b;

            public ListenerAndHandler(android.os.Handler handler, com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
                this.a = handler;
                this.b = drmSessionEventListener;
            }
        }

        public EventDispatcher() {
            this(new java.util.concurrent.CopyOnWriteArrayList(), 0, null);
        }

        public EventDispatcher(java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> copyOnWriteArrayList, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            this.a = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysLoaded(this.windowIndex, this.mediaPeriodId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysRemoved(this.windowIndex, this.mediaPeriodId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmKeysRestored(this.windowIndex, this.mediaPeriodId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmSessionAcquired(this.windowIndex, this.mediaPeriodId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener, java.lang.Exception exc) {
            drmSessionEventListener.onDrmSessionManagerError(this.windowIndex, this.mediaPeriodId, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.onDrmSessionReleased(this.windowIndex, this.mediaPeriodId);
        }

        public void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(handler);
            com.google.android.exoplayer2.util.Assertions.checkNotNull(drmSessionEventListener);
            this.a.add(new com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler(handler, drmSessionEventListener));
        }

        public void drmKeysLoaded() {
            java.util.Iterator<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.w60(this, next.b));
            }
        }

        public void drmKeysRemoved() {
            java.util.Iterator<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.v60(this, next.b));
            }
        }

        public void drmKeysRestored() {
            java.util.Iterator<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.y60(this, next.b));
            }
        }

        public void drmSessionAcquired() {
            java.util.Iterator<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.x60(this, next.b));
            }
        }

        public void drmSessionManagerError(java.lang.Exception exc) {
            java.util.Iterator<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.u60(this, next.b, exc));
            }
        }

        public void drmSessionReleased() {
            java.util.Iterator<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                com.google.android.exoplayer2.util.Util.postOrRun(next.a, new defpackage.t60(this, next.b));
            }
        }

        public void removeEventListener(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener) {
            java.util.Iterator<com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler> it = this.a.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                if (next.b == drmSessionEventListener) {
                    this.a.remove(next);
                }
            }
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher withParameters(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            return new com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher(this.a, i, mediaPeriodId);
        }
    }

    void onDrmKeysLoaded(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRemoved(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRestored(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmSessionAcquired(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmSessionManagerError(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.lang.Exception exc);

    void onDrmSessionReleased(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);
}
