package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes19.dex */
public class DownloadHttpException extends com.ss.android.socialbase.downloader.exception.BaseException {
    private final int httpStatusCode;

    public DownloadHttpException(int i, int i2, java.lang.String str) {
        super(i, str);
        this.httpStatusCode = i2;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
