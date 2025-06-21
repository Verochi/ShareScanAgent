package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public interface MediaSource {

    public static final class MediaPeriodId {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final int nextAdGroupIndex;
        public final java.lang.Object periodUid;
        public final long windowSequenceNumber;

        public MediaPeriodId(java.lang.Object obj) {
            this(obj, -1L);
        }

        public MediaPeriodId(java.lang.Object obj, int i, int i2, long j) {
            this(obj, i, i2, j, -1);
        }

        public MediaPeriodId(java.lang.Object obj, int i, int i2, long j, int i3) {
            this.periodUid = obj;
            this.adGroupIndex = i;
            this.adIndexInAdGroup = i2;
            this.windowSequenceNumber = j;
            this.nextAdGroupIndex = i3;
        }

        public MediaPeriodId(java.lang.Object obj, long j) {
            this(obj, -1, -1, j, -1);
        }

        public MediaPeriodId(java.lang.Object obj, long j, int i) {
            this(obj, -1, -1, j, i);
        }

        public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId copyWithPeriodUid(java.lang.Object obj) {
            return this.periodUid.equals(obj) ? this : new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(obj, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber, this.nextAdGroupIndex);
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.source.MediaSource.MediaPeriodId.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) obj;
            return this.periodUid.equals(mediaPeriodId.periodUid) && this.adGroupIndex == mediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaPeriodId.windowSequenceNumber && this.nextAdGroupIndex == mediaPeriodId.nextAdGroupIndex;
        }

        public int hashCode() {
            return ((((((((527 + this.periodUid.hashCode()) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber)) * 31) + this.nextAdGroupIndex;
        }

        public boolean isAd() {
            return this.adGroupIndex != -1;
        }
    }

    public interface MediaSourceCaller {
        void onSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline);
    }

    void addDrmEventListener(android.os.Handler handler, com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener);

    void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener);

    com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j);

    void disable(com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller);

    void enable(com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller);

    @androidx.annotation.Nullable
    com.google.android.exoplayer2.Timeline getInitialTimeline();

    com.google.android.exoplayer2.MediaItem getMediaItem();

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    java.lang.Object getTag();

    boolean isSingleWindow();

    void maybeThrowSourceInfoRefreshError() throws java.io.IOException;

    void prepareSource(com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener);

    void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod);

    void releaseSource(com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller mediaSourceCaller);

    void removeDrmEventListener(com.google.android.exoplayer2.drm.DrmSessionEventListener drmSessionEventListener);

    void removeEventListener(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener);
}
