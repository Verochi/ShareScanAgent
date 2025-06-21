package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public interface LoadErrorHandlingPolicy {

    public static final class LoadErrorInfo {
        public final int errorCount;
        public final java.io.IOException exception;
        public final com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo;
        public final com.google.android.exoplayer2.source.MediaLoadData mediaLoadData;

        public LoadErrorInfo(com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, int i) {
            this.loadEventInfo = loadEventInfo;
            this.mediaLoadData = mediaLoadData;
            this.exception = iOException;
            this.errorCount = i;
        }
    }

    @java.lang.Deprecated
    long getBlacklistDurationMsFor(int i, long j, java.io.IOException iOException, int i2);

    long getBlacklistDurationMsFor(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo);

    int getMinimumLoadableRetryCount(int i);

    @java.lang.Deprecated
    long getRetryDelayMsFor(int i, long j, java.io.IOException iOException, int i2);

    long getRetryDelayMsFor(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo);

    void onLoadTaskConcluded(long j);
}
