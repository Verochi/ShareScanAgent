package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public class DefaultLoadErrorHandlingPolicy implements com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    public final int a;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public DefaultLoadErrorHandlingPolicy(int i) {
        this.a = i;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public /* synthetic */ long getBlacklistDurationMsFor(int i, long j, java.io.IOException iOException, int i2) {
        return defpackage.qy0.a(this, i, j, iOException, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getBlacklistDurationMsFor(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        java.io.IOException iOException = loadErrorInfo.exception;
        if (!(iOException instanceof com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException)) {
            return -9223372036854775807L;
        }
        int i = ((com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        return (i == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503) ? 60000L : -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public int getMinimumLoadableRetryCount(int i) {
        int i2 = this.a;
        return i2 == -1 ? i == 7 ? 6 : 3 : i2;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public /* synthetic */ long getRetryDelayMsFor(int i, long j, java.io.IOException iOException, int i2) {
        return defpackage.qy0.c(this, i, j, iOException, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getRetryDelayMsFor(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        java.io.IOException iOException = loadErrorInfo.exception;
        if ((iOException instanceof com.google.android.exoplayer2.ParserException) || (iOException instanceof java.io.FileNotFoundException) || (iOException instanceof com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        return java.lang.Math.min((loadErrorInfo.errorCount - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public /* synthetic */ void onLoadTaskConcluded(long j) {
        defpackage.qy0.e(this, j);
    }
}
