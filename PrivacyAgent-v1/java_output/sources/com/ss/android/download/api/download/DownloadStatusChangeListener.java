package com.ss.android.download.api.download;

/* loaded from: classes19.dex */
public interface DownloadStatusChangeListener {
    void onDownloadActive(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo, int i);

    void onDownloadFailed(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo);

    void onDownloadFinished(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo);

    void onDownloadPaused(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo, int i);

    void onDownloadStart(@androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel, @androidx.annotation.Nullable com.ss.android.download.api.download.DownloadController downloadController);

    void onIdle();

    void onInstalled(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo);
}
