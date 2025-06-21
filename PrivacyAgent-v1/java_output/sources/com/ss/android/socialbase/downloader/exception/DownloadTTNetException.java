package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes19.dex */
public class DownloadTTNetException extends com.ss.android.socialbase.downloader.exception.BaseException {
    public DownloadTTNetException(int i, java.lang.String str) {
        super(i, str);
    }

    public DownloadTTNetException(int i, java.lang.Throwable th) {
        super(i, th);
    }

    public java.lang.String getRequestLog() {
        return getExtraInfo();
    }

    public com.ss.android.socialbase.downloader.exception.DownloadTTNetException setRequestLog(java.lang.String str) {
        setExtraInfo(str);
        return this;
    }
}
