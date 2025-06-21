package com.liulishuo.filedownloader.exception;

/* loaded from: classes23.dex */
public class PathConflictException extends java.lang.IllegalAccessException {
    private final int mAnotherSamePathTaskId;
    private final java.lang.String mDownloadingConflictPath;
    private final java.lang.String mTargetFilePath;

    public PathConflictException(int i, java.lang.String str, java.lang.String str2) {
        super(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("There is an another running task(%d) with the same downloading path(%s), because of they are with the same target-file-path(%s), so if the current task is started, the path of the file is sure to be written by multiple tasks, it is wrong, then you receive this exception to avoid such conflict.", java.lang.Integer.valueOf(i), str, str2));
        this.mAnotherSamePathTaskId = i;
        this.mDownloadingConflictPath = str;
        this.mTargetFilePath = str2;
    }

    public int getAnotherSamePathTaskId() {
        return this.mAnotherSamePathTaskId;
    }

    public java.lang.String getDownloadingConflictPath() {
        return this.mDownloadingConflictPath;
    }

    public java.lang.String getTargetFilePath() {
        return this.mTargetFilePath;
    }
}
