package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public interface AudioRendererEventListener {

    public static final class EventDispatcher {

        @androidx.annotation.Nullable
        public final android.os.Handler a;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.audio.AudioRendererEventListener b;

        public EventDispatcher(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
            this.a = audioRendererEventListener != null ? (android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(handler) : null;
            this.b = audioRendererEventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(int i) {
            ((com.google.android.exoplayer2.audio.AudioRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onAudioSessionId(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(java.lang.String str, long j, long j2) {
            ((com.google.android.exoplayer2.audio.AudioRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onAudioDecoderInitialized(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((com.google.android.exoplayer2.audio.AudioRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onAudioDisabled(decoderCounters);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            ((com.google.android.exoplayer2.audio.AudioRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onAudioEnabled(decoderCounters);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(com.google.android.exoplayer2.Format format) {
            ((com.google.android.exoplayer2.audio.AudioRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onAudioInputFormatChanged(format);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(long j) {
            ((com.google.android.exoplayer2.audio.AudioRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onAudioPositionAdvancing(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(boolean z) {
            ((com.google.android.exoplayer2.audio.AudioRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onSkipSilenceEnabledChanged(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(int i, long j, long j2) {
            ((com.google.android.exoplayer2.audio.AudioRendererEventListener) com.google.android.exoplayer2.util.Util.castNonNull(this.b)).onAudioUnderrun(i, j, j2);
        }

        public void audioSessionId(int i) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.oe(this, i));
            }
        }

        public void decoderInitialized(java.lang.String str, long j, long j2) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.ne(this, str, j, j2));
            }
        }

        public void disabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.je(this, decoderCounters));
            }
        }

        public void enabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.le(this, decoderCounters));
            }
        }

        public void inputFormatChanged(com.google.android.exoplayer2.Format format) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.ke(this, format));
            }
        }

        public void positionAdvancing(long j) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.ie(this, j));
            }
        }

        public void skipSilenceEnabledChanged(boolean z) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.he(this, z));
            }
        }

        public void underrun(int i, long j, long j2) {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.post(new defpackage.me(this, i, j, j2));
            }
        }
    }

    void onAudioDecoderInitialized(java.lang.String str, long j, long j2);

    void onAudioDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters);

    void onAudioEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters);

    void onAudioInputFormatChanged(com.google.android.exoplayer2.Format format);

    void onAudioPositionAdvancing(long j);

    void onAudioSessionId(int i);

    void onAudioUnderrun(int i, long j, long j2);

    void onSkipSilenceEnabledChanged(boolean z);
}
