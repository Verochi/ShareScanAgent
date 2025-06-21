package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public class DebugTextViewHelper implements com.google.android.exoplayer2.Player.EventListener, java.lang.Runnable {
    public final com.google.android.exoplayer2.SimpleExoPlayer n;
    public final android.widget.TextView t;
    public boolean u;

    public DebugTextViewHelper(com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer, android.widget.TextView textView) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(simpleExoPlayer.getApplicationLooper() == android.os.Looper.getMainLooper());
        this.n = simpleExoPlayer;
        this.t = textView;
    }

    public static java.lang.String a(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.ensureUpdated();
        int i = decoderCounters.skippedInputBufferCount;
        int i2 = decoderCounters.skippedOutputBufferCount;
        int i3 = decoderCounters.renderedOutputBufferCount;
        int i4 = decoderCounters.droppedBufferCount;
        int i5 = decoderCounters.maxConsecutiveDroppedBufferCount;
        int i6 = decoderCounters.droppedToKeyframeCount;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(93);
        sb.append(" sib:");
        sb.append(i);
        sb.append(" sb:");
        sb.append(i2);
        sb.append(" rb:");
        sb.append(i3);
        sb.append(" db:");
        sb.append(i4);
        sb.append(" mcdb:");
        sb.append(i5);
        sb.append(" dk:");
        sb.append(i6);
        return sb.toString();
    }

    public static java.lang.String b(float f) {
        if (f == -1.0f || f == 1.0f) {
            return "";
        }
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.String.format(java.util.Locale.US, "%.02f", java.lang.Float.valueOf(f)));
        return valueOf.length() != 0 ? " par:".concat(valueOf) : new java.lang.String(" par:");
    }

    public static java.lang.String c(long j, int i) {
        return i == 0 ? "N/A" : java.lang.String.valueOf((long) (j / i));
    }

    public java.lang.String getAudioString() {
        com.google.android.exoplayer2.Format audioFormat = this.n.getAudioFormat();
        com.google.android.exoplayer2.decoder.DecoderCounters audioDecoderCounters = this.n.getAudioDecoderCounters();
        if (audioFormat == null || audioDecoderCounters == null) {
            return "";
        }
        java.lang.String str = audioFormat.sampleMimeType;
        java.lang.String str2 = audioFormat.id;
        int i = audioFormat.sampleRate;
        int i2 = audioFormat.channelCount;
        java.lang.String a = a(audioDecoderCounters);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 36 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(a).length());
        sb.append("\n");
        sb.append(str);
        sb.append("(id:");
        sb.append(str2);
        sb.append(" hz:");
        sb.append(i);
        sb.append(" ch:");
        sb.append(i2);
        sb.append(a);
        sb.append(")");
        return sb.toString();
    }

    public java.lang.String getDebugString() {
        java.lang.String playerStateString = getPlayerStateString();
        java.lang.String videoString = getVideoString();
        java.lang.String audioString = getAudioString();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(playerStateString).length() + java.lang.String.valueOf(videoString).length() + java.lang.String.valueOf(audioString).length());
        sb.append(playerStateString);
        sb.append(videoString);
        sb.append(audioString);
        return sb.toString();
    }

    public java.lang.String getPlayerStateString() {
        int playbackState = this.n.getPlaybackState();
        return java.lang.String.format("playWhenReady:%s playbackState:%s window:%s", java.lang.Boolean.valueOf(this.n.getPlayWhenReady()), playbackState != 1 ? playbackState != 2 ? playbackState != 3 ? playbackState != 4 ? "unknown" : "ended" : "ready" : "buffering" : "idle", java.lang.Integer.valueOf(this.n.getCurrentWindowIndex()));
    }

    public java.lang.String getVideoString() {
        com.google.android.exoplayer2.Format videoFormat = this.n.getVideoFormat();
        com.google.android.exoplayer2.decoder.DecoderCounters videoDecoderCounters = this.n.getVideoDecoderCounters();
        if (videoFormat == null || videoDecoderCounters == null) {
            return "";
        }
        java.lang.String str = videoFormat.sampleMimeType;
        java.lang.String str2 = videoFormat.id;
        int i = videoFormat.width;
        int i2 = videoFormat.height;
        java.lang.String b = b(videoFormat.pixelWidthHeightRatio);
        java.lang.String a = a(videoDecoderCounters);
        java.lang.String c = c(videoDecoderCounters.totalVideoFrameProcessingOffsetUs, videoDecoderCounters.videoFrameProcessingOffsetCount);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 39 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(b).length() + java.lang.String.valueOf(a).length() + java.lang.String.valueOf(c).length());
        sb.append("\n");
        sb.append(str);
        sb.append("(id:");
        sb.append(str2);
        sb.append(" r:");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append(b);
        sb.append(a);
        sb.append(" vfpo: ");
        sb.append(c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        defpackage.h32.a(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onIsLoadingChanged(boolean z) {
        defpackage.h32.b(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onIsPlayingChanged(boolean z) {
        defpackage.h32.c(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onLoadingChanged(boolean z) {
        defpackage.h32.d(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.MediaItem mediaItem, int i) {
        defpackage.h32.e(this, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlayWhenReadyChanged(boolean z, int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        defpackage.h32.g(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPlaybackStateChanged(int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        defpackage.h32.i(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        defpackage.h32.j(this, exoPlaybackException);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
        defpackage.h32.k(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public final void onPositionDiscontinuity(int i) {
        updateAndPost();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onRepeatModeChanged(int i) {
        defpackage.h32.m(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onSeekProcessed() {
        defpackage.h32.n(this);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
        defpackage.h32.o(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
        defpackage.h32.p(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i) {
        defpackage.h32.q(this, timeline, obj, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        defpackage.h32.r(this, trackGroupArray, trackSelectionArray);
    }

    @Override // java.lang.Runnable
    public final void run() {
        updateAndPost();
    }

    public final void start() {
        if (this.u) {
            return;
        }
        this.u = true;
        this.n.addListener(this);
        updateAndPost();
    }

    public final void stop() {
        if (this.u) {
            this.u = false;
            this.n.removeListener(this);
            this.t.removeCallbacks(this);
        }
    }

    @android.annotation.SuppressLint({"SetTextI18n"})
    public final void updateAndPost() {
        this.t.setText(getDebugString());
        this.t.removeCallbacks(this);
        this.t.postDelayed(this, 1000L);
    }
}
