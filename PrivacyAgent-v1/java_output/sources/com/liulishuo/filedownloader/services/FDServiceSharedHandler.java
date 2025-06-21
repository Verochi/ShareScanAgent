package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
public class FDServiceSharedHandler extends com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub implements com.liulishuo.filedownloader.services.IFileDownloadServiceHandler {
    private final com.liulishuo.filedownloader.services.FileDownloadManager downloadManager;
    private final java.lang.ref.WeakReference<com.liulishuo.filedownloader.services.FileDownloadService> wService;

    public interface FileDownloadServiceSharedConnection {
        void onConnected(com.liulishuo.filedownloader.services.FDServiceSharedHandler fDServiceSharedHandler);

        void onDisconnected();
    }

    public FDServiceSharedHandler(java.lang.ref.WeakReference<com.liulishuo.filedownloader.services.FileDownloadService> weakReference, com.liulishuo.filedownloader.services.FileDownloadManager fileDownloadManager) {
        this.wService = weakReference;
        this.downloadManager = fileDownloadManager;
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean checkDownloading(java.lang.String str, java.lang.String str2) {
        return this.downloadManager.g(str, str2);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void clearAllTaskData() {
        this.downloadManager.a();
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean clearTaskData(int i) {
        return this.downloadManager.b(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public long getSofar(int i) {
        return this.downloadManager.c(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public byte getStatus(int i) {
        return this.downloadManager.d(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public long getTotal(int i) {
        return this.downloadManager.e(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean isIdle() {
        return this.downloadManager.h();
    }

    @Override // com.liulishuo.filedownloader.services.IFileDownloadServiceHandler
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    public void onDestroy() {
        com.liulishuo.filedownloader.FileDownloadServiceProxy.getConnectionListener().onDisconnected();
    }

    @Override // com.liulishuo.filedownloader.services.IFileDownloadServiceHandler
    public void onStartCommand(android.content.Intent intent, int i, int i2) {
        com.liulishuo.filedownloader.FileDownloadServiceProxy.getConnectionListener().onConnected(this);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean pause(int i) {
        return this.downloadManager.i(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void pauseAllTasks() {
        this.downloadManager.j();
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void registerCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback iFileDownloadIPCCallback) {
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean setMaxNetworkThreadCount(int i) {
        return this.downloadManager.k(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void start(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3) {
        this.downloadManager.l(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void startForeground(int i, android.app.Notification notification) {
        java.lang.ref.WeakReference<com.liulishuo.filedownloader.services.FileDownloadService> weakReference = this.wService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wService.get().startForeground(i, notification);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void stopForeground(boolean z) {
        java.lang.ref.WeakReference<com.liulishuo.filedownloader.services.FileDownloadService> weakReference = this.wService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wService.get().stopForeground(z);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void unregisterCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback iFileDownloadIPCCallback) {
    }
}
