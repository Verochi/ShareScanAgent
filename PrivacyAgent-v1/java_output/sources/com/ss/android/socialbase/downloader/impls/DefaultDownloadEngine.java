package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DefaultDownloadEngine extends com.ss.android.socialbase.downloader.impls.AbsDownloadEngine {
    private static final java.lang.String TAG = "DefaultDownloadEngine";
    private static com.ss.android.socialbase.downloader.thread.DownloadThreadPool downloadThreadPool;

    public DefaultDownloadEngine() {
        downloadThreadPool = new com.ss.android.socialbase.downloader.thread.DownloadThreadPool();
    }

    public static java.util.List<java.util.concurrent.Future> executeFutureTasks(java.util.List<java.lang.Runnable> list) {
        java.util.concurrent.ExecutorService chunkDownloadThreadExecutorService = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getChunkDownloadThreadExecutorService();
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<java.lang.Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(chunkDownloadThreadExecutorService.submit(it.next()));
        }
        return arrayList;
    }

    public static java.lang.Runnable getUnstartedTask(java.util.List<java.util.concurrent.Future> list) {
        java.util.concurrent.BlockingQueue<java.lang.Runnable> queue;
        java.lang.Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                java.util.concurrent.ExecutorService chunkDownloadThreadExecutorService = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getChunkDownloadThreadExecutorService();
                if ((chunkDownloadThreadExecutorService instanceof java.util.concurrent.ThreadPoolExecutor) && (queue = ((java.util.concurrent.ThreadPoolExecutor) chunkDownloadThreadExecutorService).getQueue()) != null && !queue.isEmpty()) {
                    java.util.Iterator<java.util.concurrent.Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        java.util.concurrent.Future next = it.next();
                        if ((next instanceof java.lang.Runnable) && queue.remove(next)) {
                            runnable = (java.lang.Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (java.lang.Throwable th) {
                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    public static void invokeFutureTasks(java.util.List<java.util.concurrent.Callable<java.lang.Object>> list) throws java.lang.InterruptedException {
        java.util.concurrent.ExecutorService chunkDownloadThreadExecutorService = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getChunkDownloadThreadExecutorService();
        if (chunkDownloadThreadExecutorService != null) {
            chunkDownloadThreadExecutorService.invokeAll(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public com.ss.android.socialbase.downloader.thread.DownloadRunnable doCancel(int i) {
        com.ss.android.socialbase.downloader.thread.DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null) {
            return null;
        }
        return downloadThreadPool2.cancel(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doDownload(int i, com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.logger.Logger.d("DownloadTask", "start doDownload for task : ".concat(java.lang.String.valueOf(i)));
        downloadThreadPool.execute(new com.ss.android.socialbase.downloader.thread.DownloadRunnable(downloadTask, this.mainHandler));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doPause(int i) {
        com.ss.android.socialbase.downloader.thread.DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null) {
            return;
        }
        downloadThreadPool2.pause(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doSetThrottleNetSpeed(int i, long j) {
        com.ss.android.socialbase.downloader.thread.DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null) {
            return;
        }
        downloadThreadPool2.setThrottleNetSpeed(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public java.util.List<java.lang.Integer> getAllAliveDownloadIds() {
        return downloadThreadPool.getAllAliveDownloadIds();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public boolean isDownloading(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.thread.DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null || !downloadThreadPool2.containsTask(i) || (downloadInfo = getDownloadInfo(i)) == null) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloading(downloadInfo.getStatus())) {
            return true;
        }
        doPause(i);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void removeDownloadRunnable(com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable) {
        com.ss.android.socialbase.downloader.thread.DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null) {
            return;
        }
        downloadThreadPool2.removeUnAliveDownloadRunnable(downloadRunnable);
    }
}
