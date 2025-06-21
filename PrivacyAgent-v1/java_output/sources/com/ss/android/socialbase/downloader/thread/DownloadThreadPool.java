package com.ss.android.socialbase.downloader.thread;

/* loaded from: classes19.dex */
public class DownloadThreadPool {
    private static java.util.concurrent.ExecutorService executorService = new java.util.concurrent.ThreadPoolExecutor(2, 2, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory("Download_OP_Thread"));
    private int clearTimes = 0;
    private volatile android.util.SparseArray<com.ss.android.socialbase.downloader.thread.DownloadRunnable> downloadRunnablePool = new android.util.SparseArray<>();

    private void clearRunnableNotAlive() {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < this.downloadRunnablePool.size(); i++) {
                int keyAt = this.downloadRunnablePool.keyAt(i);
                if (!this.downloadRunnablePool.get(keyAt).isAlive()) {
                    arrayList.add(java.lang.Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    java.lang.Integer num = (java.lang.Integer) arrayList.get(i2);
                    if (num != null) {
                        this.downloadRunnablePool.remove(num.intValue());
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void executeOP(java.lang.Runnable runnable) {
        executorService.execute(runnable);
    }

    private void removeFromThreadPool(com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable) {
        java.util.concurrent.Future future;
        if (downloadRunnable == null) {
            return;
        }
        try {
            java.util.concurrent.ExecutorService mixDefaultThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getMixDefaultThreadExecutor();
            com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = downloadRunnable.getDownloadTask();
            if (downloadTask != null && downloadTask.getDownloadInfo() != null) {
                int executorGroup = downloadTask.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    mixDefaultThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getMixFrequentThreadExecutor();
                } else if (executorGroup == 4) {
                    mixDefaultThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getMixApkThreadExecutor();
                }
            }
            if (mixDefaultThreadExecutor == null || !(mixDefaultThreadExecutor instanceof java.util.concurrent.ThreadPoolExecutor)) {
                return;
            }
            ((java.util.concurrent.ThreadPoolExecutor) mixDefaultThreadExecutor).remove(downloadRunnable);
            if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadRunnable.getDownloadId()).optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_PAUSE_WITH_INTERRUPT, false) || (future = downloadRunnable.getFuture()) == null) {
                return;
            }
            future.cancel(true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public com.ss.android.socialbase.downloader.thread.DownloadRunnable cancel(int i) {
        synchronized (com.ss.android.socialbase.downloader.thread.DownloadThreadPool.class) {
            clearRunnableNotAlive();
            com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i);
            if (downloadRunnable == null) {
                return null;
            }
            downloadRunnable.cancel();
            removeFromThreadPool(downloadRunnable);
            this.downloadRunnablePool.remove(i);
            return downloadRunnable;
        }
    }

    public boolean containsTask(int i) {
        synchronized (com.ss.android.socialbase.downloader.thread.DownloadThreadPool.class) {
            boolean z = false;
            if (this.downloadRunnablePool != null && this.downloadRunnablePool.size() > 0) {
                com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i);
                if (downloadRunnable != null && downloadRunnable.isAlive()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public void execute(com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable) {
        downloadRunnable.prepareDownload();
        synchronized (com.ss.android.socialbase.downloader.thread.DownloadThreadPool.class) {
            int i = this.clearTimes;
            if (i >= 500) {
                clearRunnableNotAlive();
                this.clearTimes = 0;
            } else {
                this.clearTimes = i + 1;
            }
            this.downloadRunnablePool.put(downloadRunnable.getDownloadId(), downloadRunnable);
        }
        com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = downloadRunnable.getDownloadTask();
        try {
            java.util.concurrent.ExecutorService mixDefaultThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getMixDefaultThreadExecutor();
            if (downloadTask != null && downloadTask.getDownloadInfo() != null) {
                if (com.ss.android.socialbase.downloader.constants.DownloadConstants.MIME_PLG.equals(downloadTask.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DIVIDE_PLUGIN, 1) == 1) {
                    downloadTask.getDownloadInfo().safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_EXECUTOR, 3);
                }
                int executorGroup = downloadTask.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    mixDefaultThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getMixFrequentThreadExecutor();
                } else if (executorGroup == 4) {
                    mixDefaultThreadExecutor = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getMixApkThreadExecutor();
                }
            }
            if (mixDefaultThreadExecutor == null) {
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new com.ss.android.socialbase.downloader.exception.BaseException(1003, "execute failed cpu thread executor service is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            } else if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadRunnable.getDownloadId()).optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_PAUSE_WITH_INTERRUPT, false)) {
                downloadRunnable.setFuture(mixDefaultThreadExecutor.submit(downloadRunnable));
            } else {
                mixDefaultThreadExecutor.execute(downloadRunnable);
            }
        } catch (java.lang.Exception e) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new com.ss.android.socialbase.downloader.exception.BaseException(1003, com.ss.android.socialbase.downloader.utils.DownloadUtils.getErrorMsgWithTagPrefix(e, "DownloadThreadPoolExecute")), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
            e.printStackTrace();
        } catch (java.lang.OutOfMemoryError e2) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new com.ss.android.socialbase.downloader.exception.BaseException(1003, "execute OOM"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
            e2.printStackTrace();
        }
    }

    public java.util.List<java.lang.Integer> getAllAliveDownloadIds() {
        java.util.ArrayList arrayList;
        synchronized (com.ss.android.socialbase.downloader.thread.DownloadThreadPool.class) {
            clearRunnableNotAlive();
            arrayList = new java.util.ArrayList();
            for (int i = 0; i < this.downloadRunnablePool.size(); i++) {
                com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(this.downloadRunnablePool.keyAt(i));
                if (downloadRunnable != null) {
                    arrayList.add(java.lang.Integer.valueOf(downloadRunnable.getDownloadId()));
                }
            }
        }
        return arrayList;
    }

    public void pause(int i) {
        synchronized (com.ss.android.socialbase.downloader.thread.DownloadThreadPool.class) {
            clearRunnableNotAlive();
            com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i);
            if (downloadRunnable != null) {
                downloadRunnable.pause();
                removeFromThreadPool(downloadRunnable);
                this.downloadRunnablePool.remove(i);
            }
        }
    }

    public void removeUnAliveDownloadRunnable(com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable) {
        if (downloadRunnable == null) {
            return;
        }
        synchronized (com.ss.android.socialbase.downloader.thread.DownloadThreadPool.class) {
            try {
                if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(524288)) {
                    int indexOfValue = this.downloadRunnablePool.indexOfValue(downloadRunnable);
                    if (indexOfValue >= 0) {
                        this.downloadRunnablePool.removeAt(indexOfValue);
                    }
                } else {
                    this.downloadRunnablePool.remove(downloadRunnable.getDownloadId());
                }
            } finally {
            }
        }
    }

    public void setThrottleNetSpeed(int i, long j) {
        com.ss.android.socialbase.downloader.thread.DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i);
        if (downloadRunnable != null) {
            downloadRunnable.setThrottleNetSpeed(j);
        }
    }
}
