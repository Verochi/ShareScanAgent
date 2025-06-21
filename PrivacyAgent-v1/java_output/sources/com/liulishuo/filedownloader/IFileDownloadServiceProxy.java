package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public interface IFileDownloadServiceProxy {
    void bindStartByContext(android.content.Context context);

    void bindStartByContext(android.content.Context context, java.lang.Runnable runnable);

    void clearAllTaskData();

    boolean clearTaskData(int i);

    long getSofar(int i);

    byte getStatus(int i);

    long getTotal(int i);

    boolean isConnected();

    boolean isDownloading(java.lang.String str, java.lang.String str2);

    boolean isIdle();

    boolean isRunServiceForeground();

    boolean pause(int i);

    void pauseAllTasks();

    boolean setMaxNetworkThreadCount(int i);

    boolean start(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3);

    void startForeground(int i, android.app.Notification notification);

    void stopForeground(boolean z);

    void unbindByContext(android.content.Context context);
}
