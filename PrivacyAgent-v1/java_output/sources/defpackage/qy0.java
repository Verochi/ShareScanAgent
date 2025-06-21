package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class qy0 {
    @java.lang.Deprecated
    public static long a(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i, long j, java.io.IOException iOException, int i2) {
        throw new java.lang.UnsupportedOperationException();
    }

    public static long b(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return loadErrorHandlingPolicy.getBlacklistDurationMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }

    @java.lang.Deprecated
    public static long c(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i, long j, java.io.IOException iOException, int i2) {
        throw new java.lang.UnsupportedOperationException();
    }

    public static long d(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        return loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo.mediaLoadData.dataType, loadErrorInfo.loadEventInfo.loadDurationMs, loadErrorInfo.exception, loadErrorInfo.errorCount);
    }

    public static void e(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
    }
}
