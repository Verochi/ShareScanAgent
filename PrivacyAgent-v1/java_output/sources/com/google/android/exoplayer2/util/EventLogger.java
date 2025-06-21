package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public class EventLogger implements com.google.android.exoplayer2.analytics.AnalyticsListener {
    public static final java.text.NumberFormat f;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.trackselection.MappingTrackSelector a;
    public final java.lang.String b;
    public final com.google.android.exoplayer2.Timeline.Window c;
    public final com.google.android.exoplayer2.Timeline.Period d;
    public final long e;

    static {
        java.text.NumberFormat numberFormat = java.text.NumberFormat.getInstance(java.util.Locale.US);
        f = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger(@androidx.annotation.Nullable com.google.android.exoplayer2.trackselection.MappingTrackSelector mappingTrackSelector) {
        this(mappingTrackSelector, "EventLogger");
    }

    public EventLogger(@androidx.annotation.Nullable com.google.android.exoplayer2.trackselection.MappingTrackSelector mappingTrackSelector, java.lang.String str) {
        this.a = mappingTrackSelector;
        this.b = str;
        this.c = new com.google.android.exoplayer2.Timeline.Window();
        this.d = new com.google.android.exoplayer2.Timeline.Period();
        this.e = android.os.SystemClock.elapsedRealtime();
    }

    public static java.lang.String a(int i, int i2) {
        if (i < 2) {
            return "N/A";
        }
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 8) {
            return "YES_NOT_SEAMLESS";
        }
        if (i2 == 16) {
            return "YES";
        }
        throw new java.lang.IllegalStateException();
    }

    public static java.lang.String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    public static java.lang.String e(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT";
    }

    public static java.lang.String f(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST";
    }

    public static java.lang.String g(int i) {
        return i != 0 ? i != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE";
    }

    public static java.lang.String h(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "?" : org.apache.commons.codec.language.bm.Rule.ALL : "ONE" : "OFF";
    }

    public static java.lang.String i(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    public static java.lang.String j(long j) {
        return j == -9223372036854775807L ? "?" : f.format(j / 1000.0f);
    }

    public static java.lang.String k(int i) {
        return i != 0 ? i != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED";
    }

    public static java.lang.String l(@androidx.annotation.Nullable com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, com.google.android.exoplayer2.source.TrackGroup trackGroup, int i) {
        return m((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i) == -1) ? false : true);
    }

    public static java.lang.String m(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    public final java.lang.String c(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        java.lang.String d = d(eventTime);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 2 + java.lang.String.valueOf(d).length());
        sb.append(str);
        sb.append(" [");
        sb.append(d);
        java.lang.String sb2 = sb.toString();
        if (str2 != null) {
            java.lang.String valueOf = java.lang.String.valueOf(sb2);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(valueOf.length() + 2 + str2.length());
            sb3.append(valueOf);
            sb3.append(", ");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        java.lang.String throwableString = com.google.android.exoplayer2.util.Log.getThrowableString(th);
        if (!android.text.TextUtils.isEmpty(throwableString)) {
            java.lang.String valueOf2 = java.lang.String.valueOf(sb2);
            java.lang.String replace = throwableString.replace("\n", "\n  ");
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder(valueOf2.length() + 4 + java.lang.String.valueOf(replace).length());
            sb4.append(valueOf2);
            sb4.append("\n  ");
            sb4.append(replace);
            sb4.append('\n');
            sb2 = sb4.toString();
        }
        return java.lang.String.valueOf(sb2).concat("]");
    }

    public final java.lang.String d(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        int i = eventTime.windowIndex;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(18);
        sb.append("window=");
        sb.append(i);
        java.lang.String sb2 = sb.toString();
        if (eventTime.mediaPeriodId != null) {
            java.lang.String valueOf = java.lang.String.valueOf(sb2);
            int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(valueOf.length() + 20);
            sb3.append(valueOf);
            sb3.append(", period=");
            sb3.append(indexOfPeriod);
            sb2 = sb3.toString();
            if (eventTime.mediaPeriodId.isAd()) {
                java.lang.String valueOf2 = java.lang.String.valueOf(sb2);
                int i2 = eventTime.mediaPeriodId.adGroupIndex;
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder(valueOf2.length() + 21);
                sb4.append(valueOf2);
                sb4.append(", adGroup=");
                sb4.append(i2);
                java.lang.String valueOf3 = java.lang.String.valueOf(sb4.toString());
                int i3 = eventTime.mediaPeriodId.adIndexInAdGroup;
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder(valueOf3.length() + 16);
                sb5.append(valueOf3);
                sb5.append(", ad=");
                sb5.append(i3);
                sb2 = sb5.toString();
            }
        }
        java.lang.String j = j(eventTime.realtimeMs - this.e);
        java.lang.String j2 = j(eventTime.eventPlaybackPositionMs);
        java.lang.StringBuilder sb6 = new java.lang.StringBuilder(java.lang.String.valueOf(j).length() + 23 + java.lang.String.valueOf(j2).length() + java.lang.String.valueOf(sb2).length());
        sb6.append("eventTime=");
        sb6.append(j);
        sb6.append(", mediaPos=");
        sb6.append(j2);
        sb6.append(", ");
        sb6.append(sb2);
        return sb6.toString();
    }

    public void logd(java.lang.String str) {
        com.google.android.exoplayer2.util.Log.d(this.b, str);
    }

    public void loge(java.lang.String str) {
        com.google.android.exoplayer2.util.Log.e(this.b, str);
    }

    public final void n(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str) {
        logd(c(eventTime, str, null, null));
    }

    public final void o(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.String str2) {
        logd(c(eventTime, str, str2, null));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioAttributesChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        int i = audioAttributes.contentType;
        int i2 = audioAttributes.flags;
        int i3 = audioAttributes.usage;
        int i4 = audioAttributes.allowedCapturePolicy;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(47);
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        sb.append(",");
        sb.append(i3);
        sb.append(",");
        sb.append(i4);
        o(eventTime, "audioAttributes", sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, long j) {
        o(eventTime, "audioDecoderInitialized", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        n(eventTime, "audioDisabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        n(eventTime, "audioEnabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.Format format) {
        o(eventTime, "audioInputFormat", com.google.android.exoplayer2.Format.toLogString(format));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioPositionAdvancing(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, long j) {
        defpackage.f9.f(this, eventTime, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioSessionId(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        o(eventTime, "audioSessionId", java.lang.Integer.toString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onAudioUnderrun(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(55);
        sb.append(i);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        p(eventTime, "audioTrackUnderrun", sb.toString(), null);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onBandwidthEstimate(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        defpackage.f9.j(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        defpackage.f9.k(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, java.lang.String str, long j) {
        defpackage.f9.l(this, eventTime, i, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, com.google.android.exoplayer2.Format format) {
        defpackage.f9.m(this, eventTime, i, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDownstreamFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        o(eventTime, "downstreamFormat", com.google.android.exoplayer2.Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysLoaded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        n(eventTime, "drmKeysLoaded");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRemoved(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        n(eventTime, "drmKeysRemoved");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmKeysRestored(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        n(eventTime, "drmKeysRestored");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionAcquired(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        n(eventTime, "drmSessionAcquired");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionManagerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.Exception exc) {
        r(eventTime, "drmSessionManagerError", exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDrmSessionReleased(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        n(eventTime, "drmSessionReleased");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onDroppedVideoFrames(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, long j) {
        o(eventTime, "droppedFrames", java.lang.Integer.toString(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsLoadingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        o(eventTime, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.e, java.lang.Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onIsPlayingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        o(eventTime, "isPlaying", java.lang.Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCanceled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadCompleted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
        r(eventTime, "loadError", iOException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onLoadStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadingChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        defpackage.f9.B(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMediaItemTransition(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, @androidx.annotation.Nullable com.google.android.exoplayer2.MediaItem mediaItem, int i) {
        java.lang.String d = d(eventTime);
        java.lang.String e = e(i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(d).length() + 21 + java.lang.String.valueOf(e).length());
        sb.append("mediaItem [");
        sb.append(d);
        sb.append(", reason=");
        sb.append(e);
        sb.append("]");
        logd(sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onMetadata(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.metadata.Metadata metadata) {
        java.lang.String valueOf = java.lang.String.valueOf(d(eventTime));
        logd(valueOf.length() != 0 ? "metadata [".concat(valueOf) : new java.lang.String("metadata ["));
        s(metadata, "  ");
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayWhenReadyChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z, int i) {
        java.lang.String f2 = f(i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(f2).length() + 7);
        sb.append(z);
        sb.append(", ");
        sb.append(f2);
        o(eventTime, "playWhenReady", sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackParametersChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        o(eventTime, "playbackParameters", playbackParameters.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        o(eventTime, com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, i(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlaybackSuppressionReasonChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        o(eventTime, "playbackSuppressionReason", g(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPlayerError(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        q(eventTime, "playerFailed", exoPlaybackException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayerStateChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z, int i) {
        defpackage.f9.J(this, eventTime, z, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onPositionDiscontinuity(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        o(eventTime, "positionDiscontinuity", b(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, @androidx.annotation.Nullable android.view.Surface surface) {
        o(eventTime, "renderedFirstFrame", java.lang.String.valueOf(surface));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRepeatModeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        o(eventTime, "repeatMode", h(i));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSeekProcessed(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        defpackage.f9.N(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime) {
        n(eventTime, "seekStarted");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onShuffleModeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        o(eventTime, "shuffleModeEnabled", java.lang.Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSkipSilenceEnabledChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, boolean z) {
        o(eventTime, "skipSilenceEnabled", java.lang.Boolean.toString(z));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSurfaceSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(24);
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        o(eventTime, "surfaceSize", sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTimelineChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        java.lang.String d = d(eventTime);
        java.lang.String k = k(i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(d).length() + 69 + java.lang.String.valueOf(k).length());
        sb.append("timeline [");
        sb.append(d);
        sb.append(", periodCount=");
        sb.append(periodCount);
        sb.append(", windowCount=");
        sb.append(windowCount);
        sb.append(", reason=");
        sb.append(k);
        logd(sb.toString());
        for (int i2 = 0; i2 < java.lang.Math.min(periodCount, 3); i2++) {
            eventTime.timeline.getPeriod(i2, this.d);
            java.lang.String j = j(this.d.getDurationMs());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(j).length() + 11);
            sb2.append("  period [");
            sb2.append(j);
            sb2.append("]");
            logd(sb2.toString());
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i3 = 0; i3 < java.lang.Math.min(windowCount, 3); i3++) {
            eventTime.timeline.getWindow(i3, this.c);
            java.lang.String j2 = j(this.c.getDurationMs());
            com.google.android.exoplayer2.Timeline.Window window = this.c;
            boolean z = window.isSeekable;
            boolean z2 = window.isDynamic;
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(java.lang.String.valueOf(j2).length() + 25);
            sb3.append("  window [");
            sb3.append(j2);
            sb3.append(", ");
            sb3.append(z);
            sb3.append(", ");
            sb3.append(z2);
            sb3.append("]");
            logd(sb3.toString());
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onTracksChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        com.google.android.exoplayer2.trackselection.MappingTrackSelector mappingTrackSelector = this.a;
        com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = mappingTrackSelector != null ? mappingTrackSelector.getCurrentMappedTrackInfo() : null;
        if (currentMappedTrackInfo == null) {
            o(eventTime, "tracks", "[]");
            return;
        }
        java.lang.String valueOf = java.lang.String.valueOf(d(eventTime));
        logd(valueOf.length() != 0 ? "tracks [".concat(valueOf) : new java.lang.String("tracks ["));
        int rendererCount = currentMappedTrackInfo.getRendererCount();
        int i = 0;
        while (true) {
            java.lang.String str = "    Group:";
            java.lang.String str2 = " [";
            if (i >= rendererCount) {
                break;
            }
            com.google.android.exoplayer2.source.TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArray.get(i);
            int i2 = rendererCount;
            if (trackGroups.length == 0) {
                java.lang.String rendererName = currentMappedTrackInfo.getRendererName(i);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(rendererName).length() + 5);
                sb.append("  ");
                sb.append(rendererName);
                sb.append(" []");
                logd(sb.toString());
            } else {
                java.lang.String rendererName2 = currentMappedTrackInfo.getRendererName(i);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(rendererName2).length() + 4);
                sb2.append("  ");
                sb2.append(rendererName2);
                sb2.append(" [");
                logd(sb2.toString());
                int i3 = 0;
                while (i3 < trackGroups.length) {
                    com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroups.get(i3);
                    com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray2 = trackGroups;
                    java.lang.String a = a(trackGroup.length, currentMappedTrackInfo.getAdaptiveSupport(i, i3, false));
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder(java.lang.String.valueOf(a).length() + 44);
                    sb3.append(str);
                    sb3.append(i3);
                    sb3.append(", adaptive_supported=");
                    sb3.append(a);
                    sb3.append(str2);
                    logd(sb3.toString());
                    int i4 = 0;
                    while (i4 < trackGroup.length) {
                        java.lang.String l = l(trackSelection, trackGroup, i4);
                        java.lang.String e = defpackage.ub2.e(currentMappedTrackInfo.getTrackSupport(i, i3, i4));
                        com.google.android.exoplayer2.source.TrackGroup trackGroup2 = trackGroup;
                        java.lang.String logString = com.google.android.exoplayer2.Format.toLogString(trackGroup.getFormat(i4));
                        java.lang.String str3 = str;
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder(java.lang.String.valueOf(l).length() + 38 + java.lang.String.valueOf(logString).length() + java.lang.String.valueOf(e).length());
                        sb4.append("      ");
                        sb4.append(l);
                        sb4.append(" Track:");
                        sb4.append(i4);
                        sb4.append(", ");
                        sb4.append(logString);
                        sb4.append(", supported=");
                        sb4.append(e);
                        logd(sb4.toString());
                        i4++;
                        str = str3;
                        trackGroup = trackGroup2;
                        str2 = str2;
                    }
                    logd("    ]");
                    i3++;
                    trackGroups = trackGroupArray2;
                }
                if (trackSelection != null) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= trackSelection.length()) {
                            break;
                        }
                        com.google.android.exoplayer2.metadata.Metadata metadata = trackSelection.getFormat(i5).metadata;
                        if (metadata != null) {
                            logd("    Metadata [");
                            s(metadata, "      ");
                            logd("    ]");
                            break;
                        }
                        i5++;
                    }
                }
                logd("  ]");
            }
            i++;
            rendererCount = i2;
        }
        java.lang.String str4 = "    Group:";
        java.lang.String str5 = " [";
        com.google.android.exoplayer2.source.TrackGroupArray unmappedTrackGroups = currentMappedTrackInfo.getUnmappedTrackGroups();
        if (unmappedTrackGroups.length > 0) {
            logd("  Unmapped [");
            int i6 = 0;
            while (i6 < unmappedTrackGroups.length) {
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder(23);
                java.lang.String str6 = str4;
                sb5.append(str6);
                sb5.append(i6);
                java.lang.String str7 = str5;
                sb5.append(str7);
                logd(sb5.toString());
                com.google.android.exoplayer2.source.TrackGroup trackGroup3 = unmappedTrackGroups.get(i6);
                int i7 = 0;
                while (i7 < trackGroup3.length) {
                    java.lang.String m = m(false);
                    java.lang.String e2 = defpackage.ub2.e(0);
                    java.lang.String logString2 = com.google.android.exoplayer2.Format.toLogString(trackGroup3.getFormat(i7));
                    com.google.android.exoplayer2.source.TrackGroup trackGroup4 = trackGroup3;
                    java.lang.StringBuilder sb6 = new java.lang.StringBuilder(java.lang.String.valueOf(m).length() + 38 + java.lang.String.valueOf(logString2).length() + java.lang.String.valueOf(e2).length());
                    sb6.append("      ");
                    sb6.append(m);
                    sb6.append(" Track:");
                    sb6.append(i7);
                    sb6.append(", ");
                    sb6.append(logString2);
                    sb6.append(", supported=");
                    sb6.append(e2);
                    logd(sb6.toString());
                    i7++;
                    unmappedTrackGroups = unmappedTrackGroups;
                    trackGroup3 = trackGroup4;
                }
                logd("    ]");
                i6++;
                str4 = str6;
                str5 = str7;
            }
            logd("  ]");
        }
        logd("]");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onUpstreamDiscarded(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        o(eventTime, "upstreamDiscarded", com.google.android.exoplayer2.Format.toLogString(mediaLoadData.trackFormat));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDecoderInitialized(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, long j) {
        o(eventTime, "videoDecoderInitialized", str);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoDisabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        n(eventTime, "videoDisabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoEnabled(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        n(eventTime, "videoEnabled");
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoFrameProcessingOffset(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, long j, int i) {
        defpackage.f9.Y(this, eventTime, j, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoInputFormatChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, com.google.android.exoplayer2.Format format) {
        o(eventTime, "videoInputFormat", com.google.android.exoplayer2.Format.toLogString(format));
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVideoSizeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(24);
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        o(eventTime, com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, sb.toString());
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onVolumeChanged(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, float f2) {
        o(eventTime, "volume", java.lang.Float.toString(f2));
    }

    public final void p(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        loge(c(eventTime, str, str2, th));
    }

    public final void q(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, @androidx.annotation.Nullable java.lang.Throwable th) {
        loge(c(eventTime, str, null, th));
    }

    public final void r(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.String str, java.lang.Exception exc) {
        p(eventTime, "internalError", str, exc);
    }

    public final void s(com.google.android.exoplayer2.metadata.Metadata metadata, java.lang.String str) {
        for (int i = 0; i < metadata.length(); i++) {
            java.lang.String valueOf = java.lang.String.valueOf(metadata.get(i));
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + valueOf.length());
            sb.append(str);
            sb.append(valueOf);
            logd(sb.toString());
        }
    }
}
