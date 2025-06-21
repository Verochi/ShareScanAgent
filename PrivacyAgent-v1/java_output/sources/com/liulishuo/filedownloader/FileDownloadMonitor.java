package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloadMonitor {
    public static com.liulishuo.filedownloader.FileDownloadMonitor.IMonitor a;

    public interface IMonitor {
        void onRequestStart(int i, boolean z, com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener);

        void onRequestStart(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask);

        void onTaskBegin(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask);

        void onTaskOver(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask);

        void onTaskStarted(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask);
    }

    public static com.liulishuo.filedownloader.FileDownloadMonitor.IMonitor getMonitor() {
        return a;
    }

    public static boolean isValid() {
        return getMonitor() != null;
    }

    public static void releaseGlobalMonitor() {
        a = null;
    }

    public static void setGlobalMonitor(com.liulishuo.filedownloader.FileDownloadMonitor.IMonitor iMonitor) {
        a = iMonitor;
    }
}
