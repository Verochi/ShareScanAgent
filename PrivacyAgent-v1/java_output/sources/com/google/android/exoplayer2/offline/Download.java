package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class Download {
    public static final int FAILURE_REASON_NONE = 0;
    public static final int FAILURE_REASON_UNKNOWN = 1;
    public static final int STATE_COMPLETED = 3;
    public static final int STATE_DOWNLOADING = 2;
    public static final int STATE_FAILED = 4;
    public static final int STATE_QUEUED = 0;
    public static final int STATE_REMOVING = 5;
    public static final int STATE_RESTARTING = 7;
    public static final int STATE_STOPPED = 1;
    public static final int STOP_REASON_NONE = 0;
    public final com.google.android.exoplayer2.offline.DownloadProgress a;
    public final long contentLength;
    public final int failureReason;
    public final com.google.android.exoplayer2.offline.DownloadRequest request;
    public final long startTimeMs;
    public final int state;
    public final int stopReason;
    public final long updateTimeMs;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface FailureReason {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface State {
    }

    public Download(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, int i, long j, long j2, long j3, int i2, int i3) {
        this(downloadRequest, i, j, j2, j3, i2, i3, new com.google.android.exoplayer2.offline.DownloadProgress());
    }

    public Download(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, int i, long j, long j2, long j3, int i2, int i3, com.google.android.exoplayer2.offline.DownloadProgress downloadProgress) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(downloadProgress);
        com.google.android.exoplayer2.util.Assertions.checkArgument((i3 == 0) == (i != 4));
        if (i2 != 0) {
            com.google.android.exoplayer2.util.Assertions.checkArgument((i == 2 || i == 0) ? false : true);
        }
        this.request = downloadRequest;
        this.state = i;
        this.startTimeMs = j;
        this.updateTimeMs = j2;
        this.contentLength = j3;
        this.stopReason = i2;
        this.failureReason = i3;
        this.a = downloadProgress;
    }

    public long getBytesDownloaded() {
        return this.a.bytesDownloaded;
    }

    public float getPercentDownloaded() {
        return this.a.percentDownloaded;
    }

    public boolean isTerminalState() {
        int i = this.state;
        return i == 3 || i == 4;
    }
}
