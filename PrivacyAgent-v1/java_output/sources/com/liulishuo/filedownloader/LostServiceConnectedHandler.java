package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class LostServiceConnectedHandler extends com.liulishuo.filedownloader.FileDownloadConnectListener implements com.liulishuo.filedownloader.ILostServiceConnectedHandler {
    public final java.util.ArrayList<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> b = new java.util.ArrayList<>();

    @Override // com.liulishuo.filedownloader.FileDownloadConnectListener
    public void connected() {
        com.liulishuo.filedownloader.IQueuesHandler b = com.liulishuo.filedownloader.FileDownloader.getImpl().b();
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "The downloader service is connected.", new java.lang.Object[0]);
        }
        synchronized (this.b) {
            java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> list = (java.util.List) this.b.clone();
            this.b.clear();
            java.util.ArrayList arrayList = new java.util.ArrayList(b.serialQueueSize());
            for (com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask : list) {
                int attachKey = iRunningTask.getAttachKey();
                if (b.contain(attachKey)) {
                    iRunningTask.getOrigin().asInQueueTask().enqueue();
                    if (!arrayList.contains(java.lang.Integer.valueOf(attachKey))) {
                        arrayList.add(java.lang.Integer.valueOf(attachKey));
                    }
                } else {
                    iRunningTask.startTaskByRescue();
                }
            }
            b.unFreezeSerialQueues(arrayList);
        }
    }

    @Override // com.liulishuo.filedownloader.FileDownloadConnectListener
    public void disconnected() {
        if (getConnectStatus() != com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (com.liulishuo.filedownloader.FileDownloadList.getImpl().l() > 0) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "file download service has be unbound but the size of active tasks are not empty %d ", java.lang.Integer.valueOf(com.liulishuo.filedownloader.FileDownloadList.getImpl().l()));
                return;
            }
            return;
        }
        com.liulishuo.filedownloader.IQueuesHandler b = com.liulishuo.filedownloader.FileDownloader.getImpl().b();
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "lost the connection to the file download service, and current active task size is %d", java.lang.Integer.valueOf(com.liulishuo.filedownloader.FileDownloadList.getImpl().l()));
        }
        if (com.liulishuo.filedownloader.FileDownloadList.getImpl().l() > 0) {
            synchronized (this.b) {
                com.liulishuo.filedownloader.FileDownloadList.getImpl().g(this.b);
                java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().free();
                }
                b.freezeAllSerialQueues();
            }
            try {
                com.liulishuo.filedownloader.FileDownloader.getImpl().bindService();
            } catch (java.lang.IllegalStateException unused) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "restart service failed, you may need to restart downloading manually when the app comes back to foreground", new java.lang.Object[0]);
            }
        }
    }

    @Override // com.liulishuo.filedownloader.ILostServiceConnectedHandler
    public boolean dispatchTaskStart(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask) {
        if (!com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
            synchronized (this.b) {
                if (!com.liulishuo.filedownloader.FileDownloader.getImpl().isServiceConnected()) {
                    if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "Waiting for connecting with the downloader service... %d", java.lang.Integer.valueOf(iRunningTask.getOrigin().getId()));
                    }
                    com.liulishuo.filedownloader.FileDownloadServiceProxy.getImpl().bindStartByContext(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext());
                    if (!this.b.contains(iRunningTask)) {
                        iRunningTask.free();
                        this.b.add(iRunningTask);
                    }
                    return true;
                }
            }
        }
        taskWorkFine(iRunningTask);
        return false;
    }

    @Override // com.liulishuo.filedownloader.ILostServiceConnectedHandler
    public boolean isInWaitingList(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask) {
        return !this.b.isEmpty() && this.b.contains(iRunningTask);
    }

    @Override // com.liulishuo.filedownloader.ILostServiceConnectedHandler
    public void taskWorkFine(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask) {
        if (this.b.isEmpty()) {
            return;
        }
        synchronized (this.b) {
            this.b.remove(iRunningTask);
        }
    }
}
