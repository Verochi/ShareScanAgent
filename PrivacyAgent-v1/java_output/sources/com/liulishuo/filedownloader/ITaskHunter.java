package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public interface ITaskHunter extends com.liulishuo.filedownloader.IDownloadSpeed.Lookup {

    public interface IMessageHandler {
        com.liulishuo.filedownloader.IFileDownloadMessenger getMessenger();

        com.liulishuo.filedownloader.message.MessageSnapshot prepareErrorMessage(java.lang.Throwable th);

        boolean updateKeepAhead(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

        boolean updateKeepFlow(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

        boolean updateMoreLikelyCompleted(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

        boolean updateSameFilePathTaskRunning(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);
    }

    public interface IStarter {
        boolean equalListener(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener);

        void start();
    }

    void free();

    java.lang.Throwable getErrorCause();

    java.lang.String getEtag();

    int getRetryingTimes();

    long getSofarBytes();

    byte getStatus();

    long getTotalBytes();

    void intoLaunchPool();

    boolean isLargeFile();

    boolean isResuming();

    boolean isReusedOldFile();

    boolean pause();

    void reset();
}
