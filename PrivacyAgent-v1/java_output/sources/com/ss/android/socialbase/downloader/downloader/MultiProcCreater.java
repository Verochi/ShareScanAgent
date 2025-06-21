package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
class MultiProcCreater implements com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache createCache(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener onMainProcessRebindErrorListener) {
        com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper sqlDownloadCacheAidlWrapper = new com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper();
        sqlDownloadCacheAidlWrapper.setOnMainProcessRebindErrorCallback(onMainProcessRebindErrorListener);
        return sqlDownloadCacheAidlWrapper;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public com.ss.android.socialbase.downloader.downloader.IDownloadProxy createProxy() {
        return new com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler createServiceHandler() {
        return new com.ss.android.socialbase.downloader.impls.IndependentDownloadServiceHandler();
    }
}
