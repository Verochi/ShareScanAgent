package com.liulishuo.filedownloader.message;

/* loaded from: classes23.dex */
public class MessageSnapshotTaker {
    public static com.liulishuo.filedownloader.message.MessageSnapshot catchCanReusedOldFile(int i, java.io.File file, boolean z) {
        long length = file.length();
        return length > 2147483647L ? z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.CompletedFlowDirectlySnapshot(i, true, length) : new com.liulishuo.filedownloader.message.LargeMessageSnapshot.CompletedSnapshot(i, true, length) : z ? new com.liulishuo.filedownloader.message.SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i, true, (int) length) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.CompletedSnapshot(i, true, (int) length);
    }

    public static com.liulishuo.filedownloader.message.MessageSnapshot catchException(int i, long j, java.lang.Throwable th) {
        return j > 2147483647L ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot(i, j, th) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot(i, (int) j, th);
    }

    public static com.liulishuo.filedownloader.message.MessageSnapshot catchPause(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask) {
        return baseDownloadTask.isLargeFile() ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.PausedSnapshot(baseDownloadTask.getId(), baseDownloadTask.getLargeFileSoFarBytes(), baseDownloadTask.getLargeFileTotalBytes()) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.PausedSnapshot(baseDownloadTask.getId(), baseDownloadTask.getSmallFileSoFarBytes(), baseDownloadTask.getSmallFileTotalBytes());
    }

    public static com.liulishuo.filedownloader.message.MessageSnapshot catchWarn(int i, long j, long j2, boolean z) {
        return j2 > 2147483647L ? z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.WarnFlowDirectlySnapshot(i, j, j2) : new com.liulishuo.filedownloader.message.LargeMessageSnapshot.WarnMessageSnapshot(i, j, j2) : z ? new com.liulishuo.filedownloader.message.SmallMessageSnapshot.WarnFlowDirectlySnapshot(i, (int) j, (int) j2) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.WarnMessageSnapshot(i, (int) j, (int) j2);
    }

    public static com.liulishuo.filedownloader.message.MessageSnapshot take(byte b, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        return take(b, fileDownloadModel, null);
    }

    public static com.liulishuo.filedownloader.message.MessageSnapshot take(byte b, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel, com.liulishuo.filedownloader.download.DownloadStatusCallback.ProcessParams processParams) {
        com.liulishuo.filedownloader.message.MessageSnapshot errorMessageSnapshot;
        int id = fileDownloadModel.getId();
        if (b == -4) {
            throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("please use #catchWarn instead %d", java.lang.Integer.valueOf(id)));
        }
        if (b == -3) {
            return fileDownloadModel.isLargeFile() ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.CompletedSnapshot(id, false, fileDownloadModel.getTotal()) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.CompletedSnapshot(id, false, (int) fileDownloadModel.getTotal());
        }
        if (b == -1) {
            errorMessageSnapshot = fileDownloadModel.isLargeFile() ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot(id, fileDownloadModel.getSoFar(), processParams.getException()) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot(id, (int) fileDownloadModel.getSoFar(), processParams.getException());
        } else {
            if (b == 1) {
                return fileDownloadModel.isLargeFile() ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot(id, fileDownloadModel.getSoFar(), fileDownloadModel.getTotal()) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot(id, (int) fileDownloadModel.getSoFar(), (int) fileDownloadModel.getTotal());
            }
            if (b == 2) {
                java.lang.String filename = fileDownloadModel.isPathAsDirectory() ? fileDownloadModel.getFilename() : null;
                return fileDownloadModel.isLargeFile() ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.ConnectedMessageSnapshot(id, processParams.isResuming(), fileDownloadModel.getTotal(), fileDownloadModel.getETag(), filename) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.ConnectedMessageSnapshot(id, processParams.isResuming(), (int) fileDownloadModel.getTotal(), fileDownloadModel.getETag(), filename);
            }
            if (b == 3) {
                return fileDownloadModel.isLargeFile() ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.ProgressMessageSnapshot(id, fileDownloadModel.getSoFar()) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.ProgressMessageSnapshot(id, (int) fileDownloadModel.getSoFar());
            }
            if (b != 5) {
                if (b == 6) {
                    return new com.liulishuo.filedownloader.message.MessageSnapshot.StartedMessageSnapshot(id);
                }
                java.lang.String formatString = com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, java.lang.Byte.valueOf(b));
                com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.message.MessageSnapshotTaker.class, "it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, java.lang.Byte.valueOf(b));
                java.lang.IllegalStateException illegalStateException = processParams.getException() != null ? new java.lang.IllegalStateException(formatString, processParams.getException()) : new java.lang.IllegalStateException(formatString);
                return fileDownloadModel.isLargeFile() ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot(id, fileDownloadModel.getSoFar(), illegalStateException) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot(id, (int) fileDownloadModel.getSoFar(), illegalStateException);
            }
            errorMessageSnapshot = fileDownloadModel.isLargeFile() ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.RetryMessageSnapshot(id, fileDownloadModel.getSoFar(), processParams.getException(), processParams.getRetryingTimes()) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.RetryMessageSnapshot(id, (int) fileDownloadModel.getSoFar(), processParams.getException(), processParams.getRetryingTimes());
        }
        return errorMessageSnapshot;
    }

    public static com.liulishuo.filedownloader.message.MessageSnapshot takeBlockCompleted(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (messageSnapshot.getStatus() == -3) {
            return new com.liulishuo.filedownloader.message.BlockCompleteMessage.BlockCompleteMessageImpl(messageSnapshot);
        }
        throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("take block completed snapshot, must has already be completed. %d %d", java.lang.Integer.valueOf(messageSnapshot.getId()), java.lang.Byte.valueOf(messageSnapshot.getStatus())));
    }
}
