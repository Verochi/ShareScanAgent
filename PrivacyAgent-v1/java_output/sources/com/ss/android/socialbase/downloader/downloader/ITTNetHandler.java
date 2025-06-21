package com.ss.android.socialbase.downloader.downloader;

/* loaded from: classes19.dex */
public interface ITTNetHandler {

    public static class DefaultTTNetHandler implements com.ss.android.socialbase.downloader.downloader.ITTNetHandler {
        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService getTTNetDownloadHeadHttpService() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public com.ss.android.socialbase.downloader.network.IDownloadHttpService getTTNetDownloadHttpService() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public boolean isResponseCode304Error(java.lang.Throwable th) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public boolean isTTNetEnable() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public com.ss.android.socialbase.downloader.exception.DownloadTTNetException translateTTNetException(java.lang.Throwable th, java.lang.String str) {
            return null;
        }
    }

    com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService getTTNetDownloadHeadHttpService();

    com.ss.android.socialbase.downloader.network.IDownloadHttpService getTTNetDownloadHttpService();

    boolean isResponseCode304Error(java.lang.Throwable th);

    boolean isTTNetEnable();

    com.ss.android.socialbase.downloader.exception.DownloadTTNetException translateTTNetException(java.lang.Throwable th, java.lang.String str);
}
