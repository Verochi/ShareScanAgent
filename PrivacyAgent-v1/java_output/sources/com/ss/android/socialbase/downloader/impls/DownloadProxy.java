package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DownloadProxy {
    private static volatile com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadIndependentProxy;
    private static volatile com.ss.android.socialbase.downloader.downloader.IDownloadProxy downloadProxy;

    public static com.ss.android.socialbase.downloader.downloader.IDownloadProxy get(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.supportMultiProc()) {
            if (downloadIndependentProxy == null) {
                synchronized (com.ss.android.socialbase.downloader.impls.DownloadProxy.class) {
                    if (downloadIndependentProxy == null) {
                        downloadIndependentProxy = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getIndependentHolderCreator().createProxy();
                    }
                }
            }
            return downloadIndependentProxy;
        }
        if (downloadProxy == null) {
            synchronized (com.ss.android.socialbase.downloader.impls.DownloadProxy.class) {
                if (downloadProxy == null) {
                    downloadProxy = new com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler();
                }
            }
        }
        return downloadProxy;
    }
}
