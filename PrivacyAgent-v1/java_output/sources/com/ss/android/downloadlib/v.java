package com.ss.android.downloadlib;

/* loaded from: classes19.dex */
public class v {
    private java.util.concurrent.ScheduledExecutorService t;
    private java.util.concurrent.ExecutorService vw;
    private java.util.concurrent.ExecutorService wg;

    /* renamed from: com.ss.android.downloadlib.v$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.downloader.IDownloadCache downloadCache;
            synchronized (com.ss.android.downloadlib.v.class) {
                try {
                    java.lang.String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", com.ss.android.socialbase.downloader.constants.DownloadConstants.SP_ANTI_HIJACK_CONFIG, com.ss.android.socialbase.downloader.constants.DownloadConstants.SP_DOWNLOAD_INFO, "sp_appdownloader"};
                    for (int i = 0; i < 13; i++) {
                        android.content.SharedPreferences sharedPreferences = com.ss.android.downloadlib.addownload.z.getContext().getSharedPreferences(strArr[i], 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().clear().apply();
                        }
                    }
                    downloadCache = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
                } catch (java.lang.Throwable unused) {
                }
                if (downloadCache instanceof com.ss.android.socialbase.downloader.impls.DefaultDownloadCache) {
                    android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoMap = ((com.ss.android.socialbase.downloader.impls.DefaultDownloadCache) downloadCache).getDownloadCache().getDownloadInfoMap();
                    for (int size = downloadInfoMap.size() - 1; size >= 0; size--) {
                        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = downloadInfoMap.get(downloadInfoMap.keyAt(size));
                        if (downloadInfo != null) {
                            com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).clearDownloadData(downloadInfo.getId());
                        }
                    }
                }
            }
        }
    }

    public static class vw {
        private static com.ss.android.downloadlib.v vw = new com.ss.android.downloadlib.v(null);
    }

    private v() {
    }

    public /* synthetic */ v(com.ss.android.downloadlib.v.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.downloadlib.v vw() {
        return com.ss.android.downloadlib.v.vw.vw;
    }

    public java.util.concurrent.ExecutorService t() {
        if (this.wg == null) {
            synchronized (com.ss.android.downloadlib.v.class) {
                if (this.wg == null) {
                    this.wg = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory(com.ss.android.downloadlib.o.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.wg;
    }

    public java.util.concurrent.ScheduledExecutorService v() {
        if (this.t == null) {
            synchronized (com.ss.android.downloadlib.v.class) {
                if (this.t == null) {
                    this.t = new java.util.concurrent.ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory(com.ss.android.downloadlib.o.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.t;
    }

    public void vw(java.lang.Runnable runnable) {
        vw(runnable, false);
    }

    public void vw(java.lang.Runnable runnable, long j) {
        try {
            v().schedule(runnable, j, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void vw(java.lang.Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || com.ss.android.downloadlib.bt.vl.wg()) {
            wg().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public java.util.concurrent.ExecutorService wg() {
        if (this.vw == null) {
            synchronized (com.ss.android.downloadlib.v.class) {
                if (this.vw == null) {
                    this.vw = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), new com.ss.android.socialbase.downloader.thread.DefaultThreadFactory(com.ss.android.downloadlib.o.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.vw;
    }

    public void wg(java.lang.Runnable runnable) {
        wg(runnable, false);
    }

    public void wg(java.lang.Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || com.ss.android.downloadlib.bt.vl.wg()) {
            t().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public void yl() {
        vw(new com.ss.android.downloadlib.v.AnonymousClass1());
    }
}
