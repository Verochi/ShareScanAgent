package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public interface VideoRendererEventListener {

    public static final class EventDispatcher {

        @androidx.annotation.Nullable
        public final android.os.Handler a;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.video.VideoRendererEventListener b;

        public EventDispatcher(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener) {
            this.a = videoRendererEventListener != null ? (android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(handler) : null;
            this.b = videoRendererEventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(java.lang.String str, long j, long j2) {
            ((com.google.android.exoplayer2.video.VideoRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onVideoDecoderInitialized(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((com.google.android.exoplayer2.video.VideoRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onVideoDisabled(decoderCounters);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(int i, long j) {
            ((com.google.android.exoplayer2.video.VideoRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onDroppedFrames(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            ((com.google.android.exoplayer2.video.VideoRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onVideoEnabled(decoderCounters);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(com.google.android.exoplayer2.Format format) {
            ((com.google.android.exoplayer2.video.VideoRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onVideoInputFormatChanged(format);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(android.view.Surface surface) {
            ((com.google.android.exoplayer2.video.VideoRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onRenderedFirstFrame(surface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(long j, int i) {
            ((com.google.android.exoplayer2.video.VideoRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onVideoFrameProcessingOffset(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(int i, int i2, int i3, float f) {
            ((com.google.android.exoplayer2.video.VideoRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onVideoSizeChanged(i, i2, i3, f);
        }

        public void decoderInitialized(java.lang.String str, long j, long j2) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.hb3(this, str, j, j2));
            }
        }

        public void disabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.ab3(this, decoderCounters));
            }
        }

        public void droppedFrames(int i, long j) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.eb3(this, i, j));
            }
        }

        public void enabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.bb3(this, decoderCounters));
            }
        }

        public void inputFormatChanged(com.google.android.exoplayer2.Format format) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.db3(this, format));
            }
        }

        public void renderedFirstFrame(@androidx.annotation.Nullable android.view.Surface surface) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.gb3(this, surface));
            }
        }

        public void reportVideoFrameProcessingOffset(long j, int i) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.cb3(this, j, i));
            }
        }

        public void videoSizeChanged(int i, int i2, int i3, float f) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.fb3(this, i, i2, i3, f));
            }
        }
    }

    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(@androidx.annotation.Nullable android.view.Surface surface);

    void onVideoDecoderInitialized(java.lang.String str, long j, long j2);

    void onVideoDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters);

    void onVideoEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters);

    void onVideoFrameProcessingOffset(long j, int i);

    void onVideoInputFormatChanged(com.google.android.exoplayer2.Format format);

    void onVideoSizeChanged(int i, int i2, int i3, float f);
}
