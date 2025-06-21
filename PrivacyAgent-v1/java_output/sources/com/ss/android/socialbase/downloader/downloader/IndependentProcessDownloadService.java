package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public class IndependentProcessDownloadService extends com.ss.android.socialbase.downloader.downloader.DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setAppContext(this);
        if (com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getIndependentHolderCreator() == null) {
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setIndependentServiceCreator(new com.ss.android.socialbase.downloader.downloader.MultiProcCreater());
        }
        com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler independentDownloadServiceHandler = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler = independentDownloadServiceHandler;
        independentDownloadServiceHandler.setDownloadService(new java.lang.ref.WeakReference(this));
    }
}
