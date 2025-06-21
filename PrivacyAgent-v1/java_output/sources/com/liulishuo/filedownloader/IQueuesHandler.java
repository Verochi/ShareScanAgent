package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public interface IQueuesHandler {
    boolean contain(int i);

    void freezeAllSerialQueues();

    int serialQueueSize();

    boolean startQueueParallel(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener);

    boolean startQueueSerial(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener);

    void unFreezeSerialQueues(java.util.List<java.lang.Integer> list);
}
