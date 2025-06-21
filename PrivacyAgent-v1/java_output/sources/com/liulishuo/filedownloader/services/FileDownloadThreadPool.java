package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
class FileDownloadThreadPool {
    public java.util.concurrent.ThreadPoolExecutor b;
    public int d;
    public android.util.SparseArray<com.liulishuo.filedownloader.download.DownloadLaunchRunnable> a = new android.util.SparseArray<>();
    public final java.lang.String c = "Network";
    public int e = 0;

    public FileDownloadThreadPool(int i) {
        this.b = com.liulishuo.filedownloader.util.FileDownloadExecutors.newDefaultThreadPool(i, "Network");
        this.d = i;
    }

    public void a(int i) {
        d();
        synchronized (this) {
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable downloadLaunchRunnable = this.a.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean remove = this.b.remove(downloadLaunchRunnable);
                if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "successful cancel %d %B", java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(remove));
                }
            }
            this.a.remove(i);
        }
    }

    public synchronized int b() {
        d();
        return this.a.size();
    }

    public void c(com.liulishuo.filedownloader.download.DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.pending();
        synchronized (this) {
            this.a.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.b.execute(downloadLaunchRunnable);
        int i = this.e;
        if (i < 600) {
            this.e = i + 1;
        } else {
            d();
            this.e = 0;
        }
    }

    public final synchronized void d() {
        android.util.SparseArray<com.liulishuo.filedownloader.download.DownloadLaunchRunnable> sparseArray = new android.util.SparseArray<>();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.a.keyAt(i);
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable downloadLaunchRunnable = this.a.get(keyAt);
            if (downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.a = sparseArray;
    }

    public synchronized int e(java.lang.String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable valueAt = this.a.valueAt(i2);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i && str.equals(valueAt.getTempFilePath())) {
                return valueAt.getId();
            }
        }
        return 0;
    }

    public synchronized java.util.List<java.lang.Integer> f() {
        java.util.ArrayList arrayList;
        d();
        arrayList = new java.util.ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            android.util.SparseArray<com.liulishuo.filedownloader.download.DownloadLaunchRunnable> sparseArray = this.a;
            arrayList.add(java.lang.Integer.valueOf(sparseArray.get(sparseArray.keyAt(i)).getId()));
        }
        return arrayList;
    }

    public synchronized boolean g(int i) {
        boolean z;
        com.liulishuo.filedownloader.download.DownloadLaunchRunnable downloadLaunchRunnable = this.a.get(i);
        if (downloadLaunchRunnable != null) {
            z = downloadLaunchRunnable.isAlive();
        }
        return z;
    }

    public synchronized boolean h(int i) {
        if (b() > 0) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new java.lang.Object[0]);
            return false;
        }
        int validNetworkThreadCount = com.liulishuo.filedownloader.util.FileDownloadProperties.getValidNetworkThreadCount(i);
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "change the max network thread count, from %d to %d", java.lang.Integer.valueOf(this.d), java.lang.Integer.valueOf(validNetworkThreadCount));
        }
        java.util.List<java.lang.Runnable> shutdownNow = this.b.shutdownNow();
        this.b = com.liulishuo.filedownloader.util.FileDownloadExecutors.newDefaultThreadPool(validNetworkThreadCount, "Network");
        if (shutdownNow.size() > 0) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "recreate the network thread pool and discard %d tasks", java.lang.Integer.valueOf(shutdownNow.size()));
        }
        this.d = validNetworkThreadCount;
        return true;
    }
}
