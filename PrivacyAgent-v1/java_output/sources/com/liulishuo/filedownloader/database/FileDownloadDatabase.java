package com.liulishuo.filedownloader.database;

/* loaded from: classes23.dex */
public interface FileDownloadDatabase {

    public interface Maintainer extends java.lang.Iterable<com.liulishuo.filedownloader.model.FileDownloadModel> {
        void changeFileDownloadModelId(int i, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel);

        void onFinishMaintain();

        void onRefreshedValidData(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel);

        void onRemovedInvalidData(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel);
    }

    void clear();

    com.liulishuo.filedownloader.model.FileDownloadModel find(int i);

    java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel(int i);

    void insert(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel);

    void insertConnectionModel(com.liulishuo.filedownloader.model.ConnectionModel connectionModel);

    com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer maintainer();

    void onTaskStart(int i);

    boolean remove(int i);

    void removeConnections(int i);

    void update(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel);

    void updateCompleted(int i, long j);

    void updateConnected(int i, long j, java.lang.String str, java.lang.String str2);

    void updateConnectionCount(int i, int i2);

    void updateConnectionModel(int i, int i2, long j);

    void updateError(int i, java.lang.Throwable th, long j);

    void updateOldEtagOverdue(int i, java.lang.String str, long j, long j2, int i2);

    void updatePause(int i, long j);

    void updatePending(int i);

    void updateProgress(int i, long j);

    void updateRetry(int i, java.lang.Throwable th);
}
