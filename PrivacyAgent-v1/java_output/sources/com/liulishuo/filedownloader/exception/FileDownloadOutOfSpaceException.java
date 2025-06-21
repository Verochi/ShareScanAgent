package com.liulishuo.filedownloader.exception;

/* loaded from: classes23.dex */
public class FileDownloadOutOfSpaceException extends java.io.IOException {
    private long breakpointBytes;
    private long freeSpaceBytes;
    private long requiredSpaceBytes;

    public FileDownloadOutOfSpaceException(long j, long j2, long j3) {
        super(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j)));
        init(j, j2, j3);
    }

    @android.annotation.TargetApi(9)
    public FileDownloadOutOfSpaceException(long j, long j2, long j3, java.lang.Throwable th) {
        super(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j)), th);
        init(j, j2, j3);
    }

    private void init(long j, long j2, long j3) {
        this.freeSpaceBytes = j;
        this.requiredSpaceBytes = j2;
        this.breakpointBytes = j3;
    }

    public long getBreakpointBytes() {
        return this.breakpointBytes;
    }

    public long getFreeSpaceBytes() {
        return this.freeSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
