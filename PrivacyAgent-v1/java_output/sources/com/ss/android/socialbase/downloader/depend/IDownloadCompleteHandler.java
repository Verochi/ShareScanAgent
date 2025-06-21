package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadCompleteHandler {
    void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws com.ss.android.socialbase.downloader.exception.BaseException;

    boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);
}
