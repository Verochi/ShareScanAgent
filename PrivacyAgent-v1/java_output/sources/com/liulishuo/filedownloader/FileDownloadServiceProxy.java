package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloadServiceProxy implements com.liulishuo.filedownloader.IFileDownloadServiceProxy {
    public final com.liulishuo.filedownloader.IFileDownloadServiceProxy n;

    public static final class HolderClass {
        public static final com.liulishuo.filedownloader.FileDownloadServiceProxy a = new com.liulishuo.filedownloader.FileDownloadServiceProxy(null);
    }

    public FileDownloadServiceProxy() {
        this.n = com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().processNonSeparate ? new com.liulishuo.filedownloader.FileDownloadServiceSharedTransmit() : new com.liulishuo.filedownloader.FileDownloadServiceUIGuard();
    }

    public /* synthetic */ FileDownloadServiceProxy(com.liulishuo.filedownloader.FileDownloadServiceProxy.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.liulishuo.filedownloader.services.FDServiceSharedHandler.FileDownloadServiceSharedConnection getConnectionListener() {
        if (getImpl().n instanceof com.liulishuo.filedownloader.FileDownloadServiceSharedTransmit) {
            return (com.liulishuo.filedownloader.services.FDServiceSharedHandler.FileDownloadServiceSharedConnection) getImpl().n;
        }
        return null;
    }

    public static com.liulishuo.filedownloader.FileDownloadServiceProxy getImpl() {
        return com.liulishuo.filedownloader.FileDownloadServiceProxy.HolderClass.a;
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void bindStartByContext(android.content.Context context) {
        this.n.bindStartByContext(context);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void bindStartByContext(android.content.Context context, java.lang.Runnable runnable) {
        this.n.bindStartByContext(context, runnable);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void clearAllTaskData() {
        this.n.clearAllTaskData();
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean clearTaskData(int i) {
        return this.n.clearTaskData(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public long getSofar(int i) {
        return this.n.getSofar(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public byte getStatus(int i) {
        return this.n.getStatus(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public long getTotal(int i) {
        return this.n.getTotal(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isConnected() {
        return this.n.isConnected();
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isDownloading(java.lang.String str, java.lang.String str2) {
        return this.n.isDownloading(str, str2);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isIdle() {
        return this.n.isIdle();
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isRunServiceForeground() {
        return this.n.isRunServiceForeground();
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean pause(int i) {
        return this.n.pause(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void pauseAllTasks() {
        this.n.pauseAllTasks();
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean setMaxNetworkThreadCount(int i) {
        return this.n.setMaxNetworkThreadCount(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean start(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3) {
        return this.n.start(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void startForeground(int i, android.app.Notification notification) {
        this.n.startForeground(i, notification);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void stopForeground(boolean z) {
        this.n.stopForeground(z);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void unbindByContext(android.content.Context context) {
        this.n.unbindByContext(context);
    }
}
