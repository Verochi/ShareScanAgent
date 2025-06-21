package com.ss.android.downloadad.api;

/* loaded from: classes19.dex */
public interface wg {
    android.app.Dialog vw(android.content.Context context, java.lang.String str, boolean z, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i);

    android.app.Dialog vw(android.content.Context context, java.lang.String str, boolean z, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener);

    boolean vw(long j);

    boolean vw(long j, int i);

    boolean vw(android.content.Context context, long j, java.lang.String str, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, int i);

    boolean vw(android.content.Context context, android.net.Uri uri, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController);

    boolean vw(android.content.Context context, android.net.Uri uri, com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener);
}
