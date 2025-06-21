package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface INotificationClickCallback {
    boolean onClickWhenInstalled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    boolean onClickWhenSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);

    boolean onClickWhenUnSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo);
}
