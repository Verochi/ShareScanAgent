package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public interface BaseDownloadTask {
    public static final int DEFAULT_CALLBACK_PROGRESS_MIN_INTERVAL_MILLIS = 10;

    public interface FinishListener {
        void over(com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask);
    }

    public interface IRunningTask {
        void free();

        int getAttachKey();

        com.liulishuo.filedownloader.ITaskHunter.IMessageHandler getMessageHandler();

        com.liulishuo.filedownloader.BaseDownloadTask getOrigin();

        java.lang.Object getPauseLock();

        boolean is(int i);

        boolean is(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener);

        boolean isContainFinishListener();

        boolean isMarkedAdded2List();

        boolean isOver();

        void markAdded2List();

        void setAttachKeyByQueue(int i);

        void setAttachKeyDefault();

        void startTaskByQueue();

        void startTaskByRescue();
    }

    public interface InQueueTask {
        int enqueue();
    }

    public interface LifeCycleCallback {
        void onBegin();

        void onIng();

        void onOver();
    }

    com.liulishuo.filedownloader.BaseDownloadTask addFinishListener(com.liulishuo.filedownloader.BaseDownloadTask.FinishListener finishListener);

    com.liulishuo.filedownloader.BaseDownloadTask addHeader(java.lang.String str);

    com.liulishuo.filedownloader.BaseDownloadTask addHeader(java.lang.String str, java.lang.String str2);

    com.liulishuo.filedownloader.BaseDownloadTask.InQueueTask asInQueueTask();

    boolean cancel();

    int getAutoRetryTimes();

    int getCallbackProgressMinInterval();

    int getCallbackProgressTimes();

    int getDownloadId();

    java.lang.Throwable getErrorCause();

    java.lang.String getEtag();

    java.lang.Throwable getEx();

    java.lang.String getFilename();

    int getId();

    long getLargeFileSoFarBytes();

    long getLargeFileTotalBytes();

    com.liulishuo.filedownloader.FileDownloadListener getListener();

    java.lang.String getPath();

    int getRetryingTimes();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSoFarBytes();

    int getSpeed();

    byte getStatus();

    java.lang.Object getTag();

    java.lang.Object getTag(int i);

    java.lang.String getTargetFilePath();

    int getTotalBytes();

    java.lang.String getUrl();

    boolean isAttached();

    boolean isContinue();

    boolean isForceReDownload();

    boolean isLargeFile();

    boolean isPathAsDirectory();

    boolean isResuming();

    boolean isReusedOldFile();

    boolean isRunning();

    boolean isSyncCallback();

    boolean isUsing();

    boolean isWifiRequired();

    boolean pause();

    int ready();

    com.liulishuo.filedownloader.BaseDownloadTask removeAllHeaders(java.lang.String str);

    boolean removeFinishListener(com.liulishuo.filedownloader.BaseDownloadTask.FinishListener finishListener);

    boolean reuse();

    com.liulishuo.filedownloader.BaseDownloadTask setAutoRetryTimes(int i);

    com.liulishuo.filedownloader.BaseDownloadTask setCallbackProgressIgnored();

    com.liulishuo.filedownloader.BaseDownloadTask setCallbackProgressMinInterval(int i);

    com.liulishuo.filedownloader.BaseDownloadTask setCallbackProgressTimes(int i);

    com.liulishuo.filedownloader.BaseDownloadTask setFinishListener(com.liulishuo.filedownloader.BaseDownloadTask.FinishListener finishListener);

    com.liulishuo.filedownloader.BaseDownloadTask setForceReDownload(boolean z);

    com.liulishuo.filedownloader.BaseDownloadTask setListener(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener);

    com.liulishuo.filedownloader.BaseDownloadTask setMinIntervalUpdateSpeed(int i);

    com.liulishuo.filedownloader.BaseDownloadTask setPath(java.lang.String str);

    com.liulishuo.filedownloader.BaseDownloadTask setPath(java.lang.String str, boolean z);

    com.liulishuo.filedownloader.BaseDownloadTask setSyncCallback(boolean z);

    com.liulishuo.filedownloader.BaseDownloadTask setTag(int i, java.lang.Object obj);

    com.liulishuo.filedownloader.BaseDownloadTask setTag(java.lang.Object obj);

    com.liulishuo.filedownloader.BaseDownloadTask setWifiRequired(boolean z);

    int start();
}
