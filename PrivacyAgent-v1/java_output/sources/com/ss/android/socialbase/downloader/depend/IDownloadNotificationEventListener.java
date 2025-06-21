package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadNotificationEventListener {
    java.lang.String getNotifyProcessName();

    boolean interceptAfterNotificationSuccess(boolean z);

    void onNotificationEvent(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2);
}
