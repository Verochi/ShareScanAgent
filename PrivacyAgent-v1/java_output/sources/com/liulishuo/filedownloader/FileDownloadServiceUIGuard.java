package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
class FileDownloadServiceUIGuard extends com.liulishuo.filedownloader.services.BaseFileServiceUIGuard<com.liulishuo.filedownloader.FileDownloadServiceUIGuard.FileDownloadServiceCallback, com.liulishuo.filedownloader.i.IFileDownloadIPCService> {

    public static class FileDownloadServiceCallback extends com.liulishuo.filedownloader.i.IFileDownloadIPCCallback.Stub {
        @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCCallback
        public void callback(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) throws android.os.RemoteException {
            com.liulishuo.filedownloader.message.MessageSnapshotFlow.getImpl().inflow(messageSnapshot);
        }
    }

    public FileDownloadServiceUIGuard() {
        super(com.liulishuo.filedownloader.services.FileDownloadService.SeparateProcessService.class);
    }

    @Override // com.liulishuo.filedownloader.services.BaseFileServiceUIGuard
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.liulishuo.filedownloader.i.IFileDownloadIPCService asInterface(android.os.IBinder iBinder) {
        return com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.asInterface(iBinder);
    }

    @Override // com.liulishuo.filedownloader.services.BaseFileServiceUIGuard
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.liulishuo.filedownloader.FileDownloadServiceUIGuard.FileDownloadServiceCallback createCallback() {
        return new com.liulishuo.filedownloader.FileDownloadServiceUIGuard.FileDownloadServiceCallback();
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void clearAllTaskData() {
        if (!isConnected()) {
            com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.clearAllTaskData();
            return;
        }
        try {
            getService().clearAllTaskData();
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean clearTaskData(int i) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.clearTaskData(i);
        }
        try {
            return getService().clearTaskData(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.liulishuo.filedownloader.services.BaseFileServiceUIGuard
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void registerCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCService iFileDownloadIPCService, com.liulishuo.filedownloader.FileDownloadServiceUIGuard.FileDownloadServiceCallback fileDownloadServiceCallback) throws android.os.RemoteException {
        iFileDownloadIPCService.registerCallback(fileDownloadServiceCallback);
    }

    @Override // com.liulishuo.filedownloader.services.BaseFileServiceUIGuard
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void unregisterCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCService iFileDownloadIPCService, com.liulishuo.filedownloader.FileDownloadServiceUIGuard.FileDownloadServiceCallback fileDownloadServiceCallback) throws android.os.RemoteException {
        iFileDownloadIPCService.unregisterCallback(fileDownloadServiceCallback);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public long getSofar(int i) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.getSofar(i);
        }
        try {
            return getService().getSofar(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public byte getStatus(int i) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.getStatus(i);
        }
        try {
            return getService().getStatus(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public long getTotal(int i) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.getTotal(i);
        }
        try {
            return getService().getTotal(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isDownloading(java.lang.String str, java.lang.String str2) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.isDownloading(str, str2);
        }
        try {
            return getService().checkDownloading(str, str2);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isIdle() {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.isIdle();
        }
        try {
            getService().isIdle();
            return true;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean pause(int i) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.pause(i);
        }
        try {
            return getService().pause(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void pauseAllTasks() {
        if (!isConnected()) {
            com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.pauseAllTasks();
            return;
        }
        try {
            getService().pauseAllTasks();
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean setMaxNetworkThreadCount(int i) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.setMaxNetworkThreadCount(i);
        }
        try {
            return getService().setMaxNetworkThreadCount(i);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean start(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.start(str, str2, z);
        }
        try {
            getService().start(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
            return true;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void startForeground(int i, android.app.Notification notification) {
        if (!isConnected()) {
            com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.startForeground(i, notification);
            return;
        }
        try {
            getService().startForeground(i, notification);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void stopForeground(boolean z) {
        if (!isConnected()) {
            com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.stopForeground(z);
            return;
        }
        try {
            try {
                getService().stopForeground(z);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        } finally {
            this.runServiceForeground = false;
        }
    }
}
