package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public interface ILostServiceConnectedHandler {
    boolean dispatchTaskStart(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask);

    boolean isInWaitingList(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask);

    void taskWorkFine(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask);
}
