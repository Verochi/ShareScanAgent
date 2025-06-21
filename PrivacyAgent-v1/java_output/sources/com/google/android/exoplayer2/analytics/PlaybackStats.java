package com.google.android.exoplayer2.analytics;

/* loaded from: classes22.dex */
public final class PlaybackStats {
    public static final com.google.android.exoplayer2.analytics.PlaybackStats EMPTY = merge(new com.google.android.exoplayer2.analytics.PlaybackStats[0]);
    public static final int PLAYBACK_STATE_ABANDONED = 15;
    public static final int PLAYBACK_STATE_BUFFERING = 6;
    public static final int PLAYBACK_STATE_ENDED = 11;
    public static final int PLAYBACK_STATE_FAILED = 13;
    public static final int PLAYBACK_STATE_INTERRUPTED_BY_AD = 14;
    public static final int PLAYBACK_STATE_JOINING_BACKGROUND = 1;
    public static final int PLAYBACK_STATE_JOINING_FOREGROUND = 2;
    public static final int PLAYBACK_STATE_NOT_STARTED = 0;
    public static final int PLAYBACK_STATE_PAUSED = 4;
    public static final int PLAYBACK_STATE_PAUSED_BUFFERING = 7;
    public static final int PLAYBACK_STATE_PLAYING = 3;
    public static final int PLAYBACK_STATE_SEEKING = 5;
    public static final int PLAYBACK_STATE_STOPPED = 12;
    public static final int PLAYBACK_STATE_SUPPRESSED = 9;
    public static final int PLAYBACK_STATE_SUPPRESSED_BUFFERING = 10;
    public final long[] a;
    public final int abandonedBeforeReadyCount;
    public final int adPlaybackCount;
    public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat> audioFormatHistory;
    public final int backgroundJoiningCount;
    public final int endedCount;
    public final int fatalErrorCount;
    public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException> fatalErrorHistory;
    public final int fatalErrorPlaybackCount;
    public final long firstReportedTimeMs;
    public final int foregroundPlaybackCount;
    public final int initialAudioFormatBitrateCount;
    public final int initialVideoFormatBitrateCount;
    public final int initialVideoFormatHeightCount;
    public final long maxRebufferTimeMs;
    public final java.util.List<long[]> mediaTimeHistory;
    public final int nonFatalErrorCount;
    public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException> nonFatalErrorHistory;
    public final int playbackCount;
    public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndPlaybackState> playbackStateHistory;
    public final long totalAudioFormatBitrateTimeProduct;
    public final long totalAudioFormatTimeMs;
    public final long totalAudioUnderruns;
    public final long totalBandwidthBytes;
    public final long totalBandwidthTimeMs;
    public final long totalDroppedFrames;
    public final long totalInitialAudioFormatBitrate;
    public final long totalInitialVideoFormatBitrate;
    public final int totalInitialVideoFormatHeight;
    public final int totalPauseBufferCount;
    public final int totalPauseCount;
    public final int totalRebufferCount;
    public final int totalSeekCount;
    public final long totalValidJoinTimeMs;
    public final long totalVideoFormatBitrateTimeMs;
    public final long totalVideoFormatBitrateTimeProduct;
    public final long totalVideoFormatHeightTimeMs;
    public final long totalVideoFormatHeightTimeProduct;
    public final int validJoinTimeCount;
    public final java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat> videoFormatHistory;

    public static final class EventTimeAndException {
        public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime;
        public final java.lang.Exception exception;

        public EventTimeAndException(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, java.lang.Exception exc) {
            this.eventTime = eventTime;
            this.exception = exc;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException eventTimeAndException = (com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException) obj;
            if (this.eventTime.equals(eventTimeAndException.eventTime)) {
                return this.exception.equals(eventTimeAndException.exception);
            }
            return false;
        }

        public int hashCode() {
            return (this.eventTime.hashCode() * 31) + this.exception.hashCode();
        }
    }

    public static final class EventTimeAndFormat {
        public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.Format format;

        public EventTimeAndFormat(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format) {
            this.eventTime = eventTime;
            this.format = format;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat eventTimeAndFormat = (com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat) obj;
            if (!this.eventTime.equals(eventTimeAndFormat.eventTime)) {
                return false;
            }
            com.google.android.exoplayer2.Format format = this.format;
            com.google.android.exoplayer2.Format format2 = eventTimeAndFormat.format;
            return format != null ? format.equals(format2) : format2 == null;
        }

        public int hashCode() {
            int hashCode = this.eventTime.hashCode() * 31;
            com.google.android.exoplayer2.Format format = this.format;
            return hashCode + (format != null ? format.hashCode() : 0);
        }
    }

    public static final class EventTimeAndPlaybackState {
        public final com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime;
        public final int playbackState;

        public EventTimeAndPlaybackState(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, int i) {
            this.eventTime = eventTime;
            this.playbackState = i;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndPlaybackState.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndPlaybackState eventTimeAndPlaybackState = (com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndPlaybackState) obj;
            if (this.playbackState != eventTimeAndPlaybackState.playbackState) {
                return false;
            }
            return this.eventTime.equals(eventTimeAndPlaybackState.eventTime);
        }

        public int hashCode() {
            return (this.eventTime.hashCode() * 31) + this.playbackState;
        }
    }

    public PlaybackStats(int i, long[] jArr, java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndPlaybackState> list, java.util.List<long[]> list2, long j, int i2, int i3, int i4, int i5, long j2, int i6, int i7, int i8, int i9, int i10, long j3, int i11, java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat> list3, java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndFormat> list4, long j4, long j5, long j6, long j7, long j8, long j9, int i12, int i13, int i14, long j10, int i15, long j11, long j12, long j13, long j14, long j15, int i16, int i17, int i18, java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException> list5, java.util.List<com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndException> list6) {
        this.playbackCount = i;
        this.a = jArr;
        this.playbackStateHistory = java.util.Collections.unmodifiableList(list);
        this.mediaTimeHistory = java.util.Collections.unmodifiableList(list2);
        this.firstReportedTimeMs = j;
        this.foregroundPlaybackCount = i2;
        this.abandonedBeforeReadyCount = i3;
        this.endedCount = i4;
        this.backgroundJoiningCount = i5;
        this.totalValidJoinTimeMs = j2;
        this.validJoinTimeCount = i6;
        this.totalPauseCount = i7;
        this.totalPauseBufferCount = i8;
        this.totalSeekCount = i9;
        this.totalRebufferCount = i10;
        this.maxRebufferTimeMs = j3;
        this.adPlaybackCount = i11;
        this.videoFormatHistory = java.util.Collections.unmodifiableList(list3);
        this.audioFormatHistory = java.util.Collections.unmodifiableList(list4);
        this.totalVideoFormatHeightTimeMs = j4;
        this.totalVideoFormatHeightTimeProduct = j5;
        this.totalVideoFormatBitrateTimeMs = j6;
        this.totalVideoFormatBitrateTimeProduct = j7;
        this.totalAudioFormatTimeMs = j8;
        this.totalAudioFormatBitrateTimeProduct = j9;
        this.initialVideoFormatHeightCount = i12;
        this.initialVideoFormatBitrateCount = i13;
        this.totalInitialVideoFormatHeight = i14;
        this.totalInitialVideoFormatBitrate = j10;
        this.initialAudioFormatBitrateCount = i15;
        this.totalInitialAudioFormatBitrate = j11;
        this.totalBandwidthTimeMs = j12;
        this.totalBandwidthBytes = j13;
        this.totalDroppedFrames = j14;
        this.totalAudioUnderruns = j15;
        this.fatalErrorPlaybackCount = i16;
        this.fatalErrorCount = i17;
        this.nonFatalErrorCount = i18;
        this.fatalErrorHistory = java.util.Collections.unmodifiableList(list5);
        this.nonFatalErrorHistory = java.util.Collections.unmodifiableList(list6);
    }

    public static com.google.android.exoplayer2.analytics.PlaybackStats merge(com.google.android.exoplayer2.analytics.PlaybackStats... playbackStatsArr) {
        int i;
        int i2 = 16;
        long[] jArr = new long[16];
        int length = playbackStatsArr.length;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        long j11 = -9223372036854775807L;
        long j12 = -9223372036854775807L;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        long j13 = -9223372036854775807L;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        long j14 = -1;
        int i18 = 0;
        long j15 = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i3 < length) {
            com.google.android.exoplayer2.analytics.PlaybackStats playbackStats = playbackStatsArr[i3];
            i4 += playbackStats.playbackCount;
            for (int i22 = 0; i22 < i2; i22++) {
                jArr[i22] = jArr[i22] + playbackStats.a[i22];
            }
            if (j12 == -9223372036854775807L) {
                j12 = playbackStats.firstReportedTimeMs;
                i = length;
            } else {
                i = length;
                long j16 = playbackStats.firstReportedTimeMs;
                if (j16 != -9223372036854775807L) {
                    j12 = java.lang.Math.min(j12, j16);
                }
            }
            i6 += playbackStats.foregroundPlaybackCount;
            i7 += playbackStats.abandonedBeforeReadyCount;
            i8 += playbackStats.endedCount;
            i9 += playbackStats.backgroundJoiningCount;
            if (j13 == -9223372036854775807L) {
                j13 = playbackStats.totalValidJoinTimeMs;
            } else {
                long j17 = playbackStats.totalValidJoinTimeMs;
                if (j17 != -9223372036854775807L) {
                    j13 += j17;
                }
            }
            i10 += playbackStats.validJoinTimeCount;
            i11 += playbackStats.totalPauseCount;
            i12 += playbackStats.totalPauseBufferCount;
            i13 += playbackStats.totalSeekCount;
            i14 += playbackStats.totalRebufferCount;
            if (j11 == -9223372036854775807L) {
                j11 = playbackStats.maxRebufferTimeMs;
            } else {
                long j18 = playbackStats.maxRebufferTimeMs;
                if (j18 != -9223372036854775807L) {
                    j11 = java.lang.Math.max(j11, j18);
                }
            }
            i15 += playbackStats.adPlaybackCount;
            j += playbackStats.totalVideoFormatHeightTimeMs;
            j2 += playbackStats.totalVideoFormatHeightTimeProduct;
            j3 += playbackStats.totalVideoFormatBitrateTimeMs;
            j4 += playbackStats.totalVideoFormatBitrateTimeProduct;
            j5 += playbackStats.totalAudioFormatTimeMs;
            j6 += playbackStats.totalAudioFormatBitrateTimeProduct;
            i16 += playbackStats.initialVideoFormatHeightCount;
            i17 += playbackStats.initialVideoFormatBitrateCount;
            if (i5 == -1) {
                i5 = playbackStats.totalInitialVideoFormatHeight;
            } else {
                int i23 = playbackStats.totalInitialVideoFormatHeight;
                if (i23 != -1) {
                    i5 += i23;
                }
            }
            if (j14 == -1) {
                j14 = playbackStats.totalInitialVideoFormatBitrate;
            } else {
                long j19 = playbackStats.totalInitialVideoFormatBitrate;
                if (j19 != -1) {
                    j14 += j19;
                }
            }
            i18 += playbackStats.initialAudioFormatBitrateCount;
            if (j15 == -1) {
                j15 = playbackStats.totalInitialAudioFormatBitrate;
            } else {
                long j20 = playbackStats.totalInitialAudioFormatBitrate;
                if (j20 != -1) {
                    j15 += j20;
                }
            }
            j7 += playbackStats.totalBandwidthTimeMs;
            j8 += playbackStats.totalBandwidthBytes;
            j9 += playbackStats.totalDroppedFrames;
            j10 += playbackStats.totalAudioUnderruns;
            i19 += playbackStats.fatalErrorPlaybackCount;
            i20 += playbackStats.fatalErrorCount;
            i21 += playbackStats.nonFatalErrorCount;
            i3++;
            length = i;
            i2 = 16;
        }
        return new com.google.android.exoplayer2.analytics.PlaybackStats(i4, jArr, java.util.Collections.emptyList(), java.util.Collections.emptyList(), j12, i6, i7, i8, i9, j13, i10, i11, i12, i13, i14, j11, i15, java.util.Collections.emptyList(), java.util.Collections.emptyList(), j, j2, j3, j4, j5, j6, i16, i17, i5, j14, i18, j15, j7, j8, j9, j10, i19, i20, i21, java.util.Collections.emptyList(), java.util.Collections.emptyList());
    }

    public float getAbandonedBeforeReadyRatio() {
        int i = this.abandonedBeforeReadyCount;
        int i2 = this.playbackCount;
        int i3 = this.foregroundPlaybackCount;
        int i4 = i - (i2 - i3);
        if (i3 == 0) {
            return 0.0f;
        }
        return i4 / i3;
    }

    public float getAudioUnderrunRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (this.totalAudioUnderruns * 1000.0f) / totalPlayTimeMs;
    }

    public float getDroppedFramesRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (this.totalDroppedFrames * 1000.0f) / totalPlayTimeMs;
    }

    public float getEndedRatio() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return this.endedCount / i;
    }

    public float getFatalErrorRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (this.fatalErrorCount * 1000.0f) / totalPlayTimeMs;
    }

    public float getFatalErrorRatio() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return this.fatalErrorPlaybackCount / i;
    }

    public float getJoinTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return getTotalJoinTimeMs() / totalPlayAndWaitTimeMs;
    }

    public int getMeanAudioFormatBitrate() {
        long j = this.totalAudioFormatTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalAudioFormatBitrateTimeProduct / j);
    }

    public int getMeanBandwidth() {
        long j = this.totalBandwidthTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) ((this.totalBandwidthBytes * 8000) / j);
    }

    public long getMeanElapsedTimeMs() {
        if (this.playbackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalElapsedTimeMs() / this.playbackCount;
    }

    public int getMeanInitialAudioFormatBitrate() {
        int i = this.initialAudioFormatBitrateCount;
        if (i == 0) {
            return -1;
        }
        return (int) (this.totalInitialAudioFormatBitrate / i);
    }

    public int getMeanInitialVideoFormatBitrate() {
        int i = this.initialVideoFormatBitrateCount;
        if (i == 0) {
            return -1;
        }
        return (int) (this.totalInitialVideoFormatBitrate / i);
    }

    public int getMeanInitialVideoFormatHeight() {
        int i = this.initialVideoFormatHeightCount;
        if (i == 0) {
            return -1;
        }
        return this.totalInitialVideoFormatHeight / i;
    }

    public long getMeanJoinTimeMs() {
        int i = this.validJoinTimeCount;
        if (i == 0) {
            return -9223372036854775807L;
        }
        return this.totalValidJoinTimeMs / i;
    }

    public float getMeanNonFatalErrorCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return this.nonFatalErrorCount / i;
    }

    public float getMeanPauseBufferCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return this.totalPauseBufferCount / i;
    }

    public float getMeanPauseCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return this.totalPauseCount / i;
    }

    public long getMeanPausedTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPausedTimeMs() / this.foregroundPlaybackCount;
    }

    public long getMeanPlayAndWaitTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPlayAndWaitTimeMs() / this.foregroundPlaybackCount;
    }

    public long getMeanPlayTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPlayTimeMs() / this.foregroundPlaybackCount;
    }

    public float getMeanRebufferCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return this.totalRebufferCount / i;
    }

    public long getMeanRebufferTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalRebufferTimeMs() / this.foregroundPlaybackCount;
    }

    public float getMeanSeekCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return this.totalSeekCount / i;
    }

    public long getMeanSeekTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalSeekTimeMs() / this.foregroundPlaybackCount;
    }

    public long getMeanSingleRebufferTimeMs() {
        if (this.totalRebufferCount == 0) {
            return -9223372036854775807L;
        }
        return (getPlaybackStateDurationMs(6) + getPlaybackStateDurationMs(7)) / this.totalRebufferCount;
    }

    public long getMeanSingleSeekTimeMs() {
        if (this.totalSeekCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalSeekTimeMs() / this.totalSeekCount;
    }

    public float getMeanTimeBetweenFatalErrors() {
        return 1.0f / getFatalErrorRate();
    }

    public float getMeanTimeBetweenNonFatalErrors() {
        return 1.0f / getNonFatalErrorRate();
    }

    public float getMeanTimeBetweenRebuffers() {
        return 1.0f / getRebufferRate();
    }

    public int getMeanVideoFormatBitrate() {
        long j = this.totalVideoFormatBitrateTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalVideoFormatBitrateTimeProduct / j);
    }

    public int getMeanVideoFormatHeight() {
        long j = this.totalVideoFormatHeightTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalVideoFormatHeightTimeProduct / j);
    }

    public long getMeanWaitTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalWaitTimeMs() / this.foregroundPlaybackCount;
    }

    public long getMediaTimeMsAtRealtimeMs(long j) {
        if (this.mediaTimeHistory.isEmpty()) {
            return -9223372036854775807L;
        }
        int i = 0;
        while (i < this.mediaTimeHistory.size() && this.mediaTimeHistory.get(i)[0] <= j) {
            i++;
        }
        if (i == 0) {
            return this.mediaTimeHistory.get(0)[1];
        }
        if (i == this.mediaTimeHistory.size()) {
            java.util.List<long[]> list = this.mediaTimeHistory;
            return list.get(list.size() - 1)[1];
        }
        int i2 = i - 1;
        long j2 = this.mediaTimeHistory.get(i2)[0];
        long j3 = this.mediaTimeHistory.get(i2)[1];
        long j4 = this.mediaTimeHistory.get(i)[0];
        long j5 = this.mediaTimeHistory.get(i)[1];
        long j6 = j4 - j2;
        if (j6 == 0) {
            return j3;
        }
        return j3 + ((long) ((j5 - j3) * ((j - j2) / j6)));
    }

    public float getNonFatalErrorRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (this.nonFatalErrorCount * 1000.0f) / totalPlayTimeMs;
    }

    public int getPlaybackStateAtTime(long j) {
        int i = 0;
        for (com.google.android.exoplayer2.analytics.PlaybackStats.EventTimeAndPlaybackState eventTimeAndPlaybackState : this.playbackStateHistory) {
            if (eventTimeAndPlaybackState.eventTime.realtimeMs > j) {
                break;
            }
            i = eventTimeAndPlaybackState.playbackState;
        }
        return i;
    }

    public long getPlaybackStateDurationMs(int i) {
        return this.a[i];
    }

    public float getRebufferRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (this.totalRebufferCount * 1000.0f) / totalPlayTimeMs;
    }

    public float getRebufferTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return getTotalRebufferTimeMs() / totalPlayAndWaitTimeMs;
    }

    public float getSeekTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return getTotalSeekTimeMs() / totalPlayAndWaitTimeMs;
    }

    public long getTotalElapsedTimeMs() {
        long j = 0;
        for (int i = 0; i < 16; i++) {
            j += this.a[i];
        }
        return j;
    }

    public long getTotalJoinTimeMs() {
        return getPlaybackStateDurationMs(2);
    }

    public long getTotalPausedTimeMs() {
        return getPlaybackStateDurationMs(4) + getPlaybackStateDurationMs(7);
    }

    public long getTotalPlayAndWaitTimeMs() {
        return getTotalPlayTimeMs() + getTotalWaitTimeMs();
    }

    public long getTotalPlayTimeMs() {
        return getPlaybackStateDurationMs(3);
    }

    public long getTotalRebufferTimeMs() {
        return getPlaybackStateDurationMs(6);
    }

    public long getTotalSeekTimeMs() {
        return getPlaybackStateDurationMs(5);
    }

    public long getTotalWaitTimeMs() {
        return getPlaybackStateDurationMs(2) + getPlaybackStateDurationMs(6) + getPlaybackStateDurationMs(5);
    }

    public float getWaitTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return getTotalWaitTimeMs() / totalPlayAndWaitTimeMs;
    }
}
