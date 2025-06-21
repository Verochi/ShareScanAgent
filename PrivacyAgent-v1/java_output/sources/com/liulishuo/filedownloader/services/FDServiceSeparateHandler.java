package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
public class FDServiceSeparateHandler extends com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub implements com.liulishuo.filedownloader.message.MessageSnapshotFlow.MessageReceiver, com.liulishuo.filedownloader.services.IFileDownloadServiceHandler {
    private final android.os.RemoteCallbackList<com.liulishuo.filedownloader.i.IFileDownloadIPCCallback> callbackList = new android.os.RemoteCallbackList<>();
    private final com.liulishuo.filedownloader.services.FileDownloadManager downloadManager;
    private final java.lang.ref.WeakReference<com.liulishuo.filedownloader.services.FileDownloadService> wService;

    public FDServiceSeparateHandler(java.lang.ref.WeakReference<com.liulishuo.filedownloader.services.FileDownloadService> weakReference, com.liulishuo.filedownloader.services.FileDownloadManager fileDownloadManager) {
        this.wService = weakReference;
        this.downloadManager = fileDownloadManager;
        com.liulishuo.filedownloader.message.MessageSnapshotFlow.getImpl().setReceiver(this);
    }

    private synchronized int callback(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        android.os.RemoteCallbackList<com.liulishuo.filedownloader.i.IFileDownloadIPCCallback> remoteCallbackList;
        beginBroadcast = this.callbackList.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                try {
                    this.callbackList.getBroadcastItem(i).callback(messageSnapshot);
                } catch (java.lang.Throwable th) {
                    this.callbackList.finishBroadcast();
                    throw th;
                }
            } catch (android.os.RemoteException e) {
                com.liulishuo.filedownloader.util.FileDownloadLog.e(this, e, "callback error", new java.lang.Object[0]);
                remoteCallbackList = this.callbackList;
            }
        }
        remoteCallbackList = this.callbackList;
        remoteCallbackList.finishBroadcast();
        return beginBroadcast;
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean checkDownloading(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
        return this.downloadManager.g(str, str2);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void clearAllTaskData() throws android.os.RemoteException {
        this.downloadManager.a();
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean clearTaskData(int i) throws android.os.RemoteException {
        return this.downloadManager.b(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public long getSofar(int i) throws android.os.RemoteException {
        return this.downloadManager.c(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public byte getStatus(int i) throws android.os.RemoteException {
        return this.downloadManager.d(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public long getTotal(int i) throws android.os.RemoteException {
        return this.downloadManager.e(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean isIdle() throws android.os.RemoteException {
        return this.downloadManager.h();
    }

    @Override // com.liulishuo.filedownloader.services.IFileDownloadServiceHandler
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this;
    }

    public void onDestroy() {
        com.liulishuo.filedownloader.message.MessageSnapshotFlow.getImpl().setReceiver(null);
    }

    @Override // com.liulishuo.filedownloader.services.IFileDownloadServiceHandler
    public void onStartCommand(android.content.Intent intent, int i, int i2) {
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean pause(int i) throws android.os.RemoteException {
        return this.downloadManager.i(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void pauseAllTasks() throws android.os.RemoteException {
        this.downloadManager.j();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshotFlow.MessageReceiver
    public void receive(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        callback(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void registerCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback iFileDownloadIPCCallback) throws android.os.RemoteException {
        this.callbackList.register(iFileDownloadIPCCallback);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public boolean setMaxNetworkThreadCount(int i) throws android.os.RemoteException {
        return this.downloadManager.k(i);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void start(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3) throws android.os.RemoteException {
        this.downloadManager.l(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void startForeground(int i, android.app.Notification notification) throws android.os.RemoteException {
        java.lang.ref.WeakReference<com.liulishuo.filedownloader.services.FileDownloadService> weakReference = this.wService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wService.get().startForeground(i, notification);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void stopForeground(boolean z) throws android.os.RemoteException {
        java.lang.ref.WeakReference<com.liulishuo.filedownloader.services.FileDownloadService> weakReference = this.wService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wService.get().stopForeground(z);
    }

    @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
    public void unregisterCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback iFileDownloadIPCCallback) throws android.os.RemoteException {
        this.callbackList.unregister(iFileDownloadIPCCallback);
    }
}
