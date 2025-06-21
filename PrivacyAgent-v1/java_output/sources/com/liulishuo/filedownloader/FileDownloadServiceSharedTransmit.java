package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
class FileDownloadServiceSharedTransmit implements com.liulishuo.filedownloader.IFileDownloadServiceProxy, com.liulishuo.filedownloader.services.FDServiceSharedHandler.FileDownloadServiceSharedConnection {
    public static final java.lang.Class<?> v = com.liulishuo.filedownloader.services.FileDownloadService.SharedMainProcessService.class;
    public boolean n = false;
    public final java.util.ArrayList<java.lang.Runnable> t = new java.util.ArrayList<>();
    public com.liulishuo.filedownloader.services.FDServiceSharedHandler u;

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void bindStartByContext(android.content.Context context) {
        bindStartByContext(context, null);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void bindStartByContext(android.content.Context context, java.lang.Runnable runnable) {
        if (runnable != null && !this.t.contains(runnable)) {
            this.t.add(runnable);
        }
        android.content.Intent intent = new android.content.Intent(context, v);
        boolean needMakeServiceForeground = com.liulishuo.filedownloader.util.FileDownloadUtils.needMakeServiceForeground(context);
        this.n = needMakeServiceForeground;
        intent.putExtra(com.liulishuo.filedownloader.util.ExtraKeys.IS_FOREGROUND, needMakeServiceForeground);
        if (!this.n) {
            context.startService(intent);
            return;
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "start foreground service", new java.lang.Object[0]);
        }
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void clearAllTaskData() {
        if (isConnected()) {
            this.u.clearAllTaskData();
        } else {
            com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.clearAllTaskData();
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean clearTaskData(int i) {
        return !isConnected() ? com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.clearTaskData(i) : this.u.clearTaskData(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public long getSofar(int i) {
        return !isConnected() ? com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.getSofar(i) : this.u.getSofar(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public byte getStatus(int i) {
        return !isConnected() ? com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.getStatus(i) : this.u.getStatus(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public long getTotal(int i) {
        return !isConnected() ? com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.getTotal(i) : this.u.getTotal(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isConnected() {
        return this.u != null;
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isDownloading(java.lang.String str, java.lang.String str2) {
        return !isConnected() ? com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.isDownloading(str, str2) : this.u.checkDownloading(str, str2);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isIdle() {
        return !isConnected() ? com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.isIdle() : this.u.isIdle();
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isRunServiceForeground() {
        return this.n;
    }

    @Override // com.liulishuo.filedownloader.services.FDServiceSharedHandler.FileDownloadServiceSharedConnection
    public void onConnected(com.liulishuo.filedownloader.services.FDServiceSharedHandler fDServiceSharedHandler) {
        this.u = fDServiceSharedHandler;
        java.util.List list = (java.util.List) this.t.clone();
        this.t.clear();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            ((java.lang.Runnable) it.next()).run();
        }
        com.liulishuo.filedownloader.FileDownloadEventPool.getImpl().asyncPublishInNewThread(new com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent(com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus.connected, v));
    }

    @Override // com.liulishuo.filedownloader.services.FDServiceSharedHandler.FileDownloadServiceSharedConnection
    public void onDisconnected() {
        this.u = null;
        com.liulishuo.filedownloader.FileDownloadEventPool.getImpl().asyncPublishInNewThread(new com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent(com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, v));
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean pause(int i) {
        return !isConnected() ? com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.pause(i) : this.u.pause(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void pauseAllTasks() {
        if (isConnected()) {
            this.u.pauseAllTasks();
        } else {
            com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.pauseAllTasks();
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean setMaxNetworkThreadCount(int i) {
        return !isConnected() ? com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.setMaxNetworkThreadCount(i) : this.u.setMaxNetworkThreadCount(i);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean start(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.start(str, str2, z);
        }
        this.u.start(str, str2, z, i, i2, i3, z2, fileDownloadHeader, z3);
        return true;
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void startForeground(int i, android.app.Notification notification) {
        if (isConnected()) {
            this.u.startForeground(i, notification);
        } else {
            com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.startForeground(i, notification);
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void stopForeground(boolean z) {
        if (!isConnected()) {
            com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.stopForeground(z);
        } else {
            this.u.stopForeground(z);
            this.n = false;
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void unbindByContext(android.content.Context context) {
        context.stopService(new android.content.Intent(context, v));
        this.u = null;
    }
}
