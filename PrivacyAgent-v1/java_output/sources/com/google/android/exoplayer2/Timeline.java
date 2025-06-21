package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public abstract class Timeline {
    public static final com.google.android.exoplayer2.Timeline EMPTY = new com.google.android.exoplayer2.Timeline.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.Timeline$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.exoplayer2.Timeline {
        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(java.lang.Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public java.lang.Object getUidOfPeriod(int i) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j) {
            throw new java.lang.IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 0;
        }
    }

    public static final class Period {
        public long a;
        public com.google.android.exoplayer2.source.ads.AdPlaybackState b = com.google.android.exoplayer2.source.ads.AdPlaybackState.NONE;
        public long durationUs;

        @androidx.annotation.Nullable
        public java.lang.Object id;

        @androidx.annotation.Nullable
        public java.lang.Object uid;
        public int windowIndex;

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !com.google.android.exoplayer2.Timeline.Period.class.equals(obj.getClass())) {
                return false;
            }
            com.google.android.exoplayer2.Timeline.Period period = (com.google.android.exoplayer2.Timeline.Period) obj;
            return com.google.android.exoplayer2.util.Util.areEqual(this.id, period.id) && com.google.android.exoplayer2.util.Util.areEqual(this.uid, period.uid) && this.windowIndex == period.windowIndex && this.durationUs == period.durationUs && this.a == period.a && com.google.android.exoplayer2.util.Util.areEqual(this.b, period.b);
        }

        public int getAdCountInAdGroup(int i) {
            return this.b.adGroups[i].count;
        }

        public long getAdDurationUs(int i, int i2) {
            com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup adGroup = this.b.adGroups[i];
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i2];
            }
            return -9223372036854775807L;
        }

        public int getAdGroupCount() {
            return this.b.adGroupCount;
        }

        public int getAdGroupIndexAfterPositionUs(long j) {
            return this.b.getAdGroupIndexAfterPositionUs(j, this.durationUs);
        }

        public int getAdGroupIndexForPositionUs(long j) {
            return this.b.getAdGroupIndexForPositionUs(j, this.durationUs);
        }

        public long getAdGroupTimeUs(int i) {
            return this.b.adGroupTimesUs[i];
        }

        public long getAdResumePositionUs() {
            return this.b.adResumePositionUs;
        }

        public long getDurationMs() {
            return com.google.android.exoplayer2.C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public int getFirstAdIndexToPlay(int i) {
            return this.b.adGroups[i].getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int i, int i2) {
            return this.b.adGroups[i].getNextAdIndexToPlay(i2);
        }

        public long getPositionInWindowMs() {
            return com.google.android.exoplayer2.C.usToMs(this.a);
        }

        public long getPositionInWindowUs() {
            return this.a;
        }

        public boolean hasPlayedAdGroup(int i) {
            return !this.b.adGroups[i].hasUnplayedAds();
        }

        public int hashCode() {
            java.lang.Object obj = this.id;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            java.lang.Object obj2 = this.uid;
            int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.windowIndex) * 31;
            long j = this.durationUs;
            int i = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.a;
            return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.b.hashCode();
        }

        public boolean isAdAvailable(int i, int i2) {
            com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup adGroup = this.b.adGroups[i];
            return (adGroup.count == -1 || adGroup.states[i2] == 0) ? false : true;
        }

        public com.google.android.exoplayer2.Timeline.Period set(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2, int i, long j, long j2) {
            return set(obj, obj2, i, j, j2, com.google.android.exoplayer2.source.ads.AdPlaybackState.NONE);
        }

        public com.google.android.exoplayer2.Timeline.Period set(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2, int i, long j, long j2, com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
            this.id = obj;
            this.uid = obj2;
            this.windowIndex = i;
            this.durationUs = j;
            this.a = j2;
            this.b = adPlaybackState;
            return this;
        }
    }

    public static final class Window {
        public static final java.lang.Object SINGLE_WINDOW_UID = new java.lang.Object();
        public static final com.google.android.exoplayer2.MediaItem a = new com.google.android.exoplayer2.MediaItem.Builder().setMediaId("com.google.android.exoplayer2.Timeline").setUri(android.net.Uri.EMPTY).build();
        public long defaultPositionUs;
        public long durationUs;
        public long elapsedRealtimeEpochOffsetMs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isLive;
        public boolean isPlaceholder;
        public boolean isSeekable;
        public int lastPeriodIndex;

        @androidx.annotation.Nullable
        public java.lang.Object manifest;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;

        @androidx.annotation.Nullable
        @java.lang.Deprecated
        public java.lang.Object tag;
        public long windowStartTimeMs;
        public java.lang.Object uid = SINGLE_WINDOW_UID;
        public com.google.android.exoplayer2.MediaItem mediaItem = a;

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !com.google.android.exoplayer2.Timeline.Window.class.equals(obj.getClass())) {
                return false;
            }
            com.google.android.exoplayer2.Timeline.Window window = (com.google.android.exoplayer2.Timeline.Window) obj;
            return com.google.android.exoplayer2.util.Util.areEqual(this.uid, window.uid) && com.google.android.exoplayer2.util.Util.areEqual(this.mediaItem, window.mediaItem) && com.google.android.exoplayer2.util.Util.areEqual(this.manifest, window.manifest) && this.presentationStartTimeMs == window.presentationStartTimeMs && this.windowStartTimeMs == window.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == window.elapsedRealtimeEpochOffsetMs && this.isSeekable == window.isSeekable && this.isDynamic == window.isDynamic && this.isLive == window.isLive && this.isPlaceholder == window.isPlaceholder && this.defaultPositionUs == window.defaultPositionUs && this.durationUs == window.durationUs && this.firstPeriodIndex == window.firstPeriodIndex && this.lastPeriodIndex == window.lastPeriodIndex && this.positionInFirstPeriodUs == window.positionInFirstPeriodUs;
        }

        public long getCurrentUnixTimeMs() {
            return com.google.android.exoplayer2.util.Util.getNowUnixTimeMs(this.elapsedRealtimeEpochOffsetMs);
        }

        public long getDefaultPositionMs() {
            return com.google.android.exoplayer2.C.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return com.google.android.exoplayer2.C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return com.google.android.exoplayer2.C.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public int hashCode() {
            int hashCode = (((217 + this.uid.hashCode()) * 31) + this.mediaItem.hashCode()) * 31;
            java.lang.Object obj = this.manifest;
            int hashCode2 = obj == null ? 0 : obj.hashCode();
            long j = this.presentationStartTimeMs;
            int i = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.windowStartTimeMs;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.elapsedRealtimeEpochOffsetMs;
            int i3 = (((((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + (this.isLive ? 1 : 0)) * 31) + (this.isPlaceholder ? 1 : 0)) * 31;
            long j4 = this.defaultPositionUs;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.durationUs;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.firstPeriodIndex) * 31) + this.lastPeriodIndex) * 31;
            long j6 = this.positionInFirstPeriodUs;
            return i5 + ((int) (j6 ^ (j6 >>> 32)));
        }

        public com.google.android.exoplayer2.Timeline.Window set(java.lang.Object obj, @androidx.annotation.Nullable com.google.android.exoplayer2.MediaItem mediaItem, @androidx.annotation.Nullable java.lang.Object obj2, long j, long j2, long j3, boolean z, boolean z2, boolean z3, long j4, long j5, int i, int i2, long j6) {
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties;
            this.uid = obj;
            this.mediaItem = mediaItem != null ? mediaItem : a;
            this.tag = (mediaItem == null || (playbackProperties = mediaItem.playbackProperties) == null) ? null : playbackProperties.tag;
            this.manifest = obj2;
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.elapsedRealtimeEpochOffsetMs = j3;
            this.isSeekable = z;
            this.isDynamic = z2;
            this.isLive = z3;
            this.defaultPositionUs = j4;
            this.durationUs = j5;
            this.firstPeriodIndex = i;
            this.lastPeriodIndex = i2;
            this.positionInFirstPeriodUs = j6;
            this.isPlaceholder = false;
            return this;
        }
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.exoplayer2.Timeline)) {
            return false;
        }
        com.google.android.exoplayer2.Timeline timeline = (com.google.android.exoplayer2.Timeline) obj;
        if (timeline.getWindowCount() != getWindowCount() || timeline.getPeriodCount() != getPeriodCount()) {
            return false;
        }
        com.google.android.exoplayer2.Timeline.Window window = new com.google.android.exoplayer2.Timeline.Window();
        com.google.android.exoplayer2.Timeline.Period period = new com.google.android.exoplayer2.Timeline.Period();
        com.google.android.exoplayer2.Timeline.Window window2 = new com.google.android.exoplayer2.Timeline.Window();
        com.google.android.exoplayer2.Timeline.Period period2 = new com.google.android.exoplayer2.Timeline.Period();
        for (int i = 0; i < getWindowCount(); i++) {
            if (!getWindow(i, window).equals(timeline.getWindow(i, window2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            if (!getPeriod(i2, period, true).equals(timeline.getPeriod(i2, period2, true))) {
                return false;
            }
        }
        return true;
    }

    public int getFirstWindowIndex(boolean z) {
        return isEmpty() ? -1 : 0;
    }

    public abstract int getIndexOfPeriod(java.lang.Object obj);

    public int getLastWindowIndex(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i, com.google.android.exoplayer2.Timeline.Period period, com.google.android.exoplayer2.Timeline.Window window, int i2, boolean z) {
        int i3 = getPeriod(i, period).windowIndex;
        if (getWindow(i3, window).lastPeriodIndex != i) {
            return i + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i3, i2, z);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == getLastWindowIndex(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == getLastWindowIndex(z) ? getFirstWindowIndex(z) : i + 1;
        }
        throw new java.lang.IllegalStateException();
    }

    public final com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period) {
        return getPeriod(i, period, false);
    }

    public abstract com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z);

    public com.google.android.exoplayer2.Timeline.Period getPeriodByUid(java.lang.Object obj, com.google.android.exoplayer2.Timeline.Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public abstract int getPeriodCount();

    public final android.util.Pair<java.lang.Object, java.lang.Long> getPeriodPosition(com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period, int i, long j) {
        return (android.util.Pair) com.google.android.exoplayer2.util.Assertions.checkNotNull(getPeriodPosition(window, period, i, j, 0L));
    }

    @androidx.annotation.Nullable
    public final android.util.Pair<java.lang.Object, java.lang.Long> getPeriodPosition(com.google.android.exoplayer2.Timeline.Window window, com.google.android.exoplayer2.Timeline.Period period, int i, long j, long j2) {
        com.google.android.exoplayer2.util.Assertions.checkIndex(i, 0, getWindowCount());
        getWindow(i, window, j2);
        if (j == -9223372036854775807L) {
            j = window.getDefaultPositionUs();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j;
        long durationUs = getPeriod(i2, period, true).getDurationUs();
        while (durationUs != -9223372036854775807L && positionInFirstPeriodUs >= durationUs && i2 < window.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i2++;
            durationUs = getPeriod(i2, period, true).getDurationUs();
        }
        return android.util.Pair.create(com.google.android.exoplayer2.util.Assertions.checkNotNull(period.uid), java.lang.Long.valueOf(positionInFirstPeriodUs));
    }

    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == getFirstWindowIndex(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == getFirstWindowIndex(z) ? getLastWindowIndex(z) : i - 1;
        }
        throw new java.lang.IllegalStateException();
    }

    public abstract java.lang.Object getUidOfPeriod(int i);

    public final com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window) {
        return getWindow(i, window, 0L);
    }

    public abstract com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j);

    @java.lang.Deprecated
    public final com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, boolean z) {
        return getWindow(i, window, 0L);
    }

    public abstract int getWindowCount();

    public int hashCode() {
        com.google.android.exoplayer2.Timeline.Window window = new com.google.android.exoplayer2.Timeline.Window();
        com.google.android.exoplayer2.Timeline.Period period = new com.google.android.exoplayer2.Timeline.Period();
        int windowCount = 217 + getWindowCount();
        for (int i = 0; i < getWindowCount(); i++) {
            windowCount = (windowCount * 31) + getWindow(i, window).hashCode();
        }
        int periodCount = (windowCount * 31) + getPeriodCount();
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            periodCount = (periodCount * 31) + getPeriod(i2, period, true).hashCode();
        }
        return periodCount;
    }

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public final boolean isLastPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, com.google.android.exoplayer2.Timeline.Window window, int i2, boolean z) {
        return getNextPeriodIndex(i, period, window, i2, z) == -1;
    }
}
