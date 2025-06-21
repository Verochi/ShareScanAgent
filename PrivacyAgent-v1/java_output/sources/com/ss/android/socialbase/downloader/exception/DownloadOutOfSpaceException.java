package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes19.dex */
public class DownloadOutOfSpaceException extends com.ss.android.socialbase.downloader.exception.BaseException {
    private final long avaliableSpaceBytes;
    private final long requiredSpaceBytes;

    public DownloadOutOfSpaceException(long j, long j2) {
        super(1006, java.lang.String.format("space is not enough required space is : %s but available space is :%s", java.lang.String.valueOf(j2), java.lang.String.valueOf(j)));
        this.avaliableSpaceBytes = j;
        this.requiredSpaceBytes = j2;
    }

    public long getAvaliableSpaceBytes() {
        return this.avaliableSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
