package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes19.dex */
public class DownloadFileExistException extends com.ss.android.socialbase.downloader.exception.BaseException {
    private java.lang.String existTargetFileName;

    public DownloadFileExistException(java.lang.String str) {
        this.existTargetFileName = str;
    }

    public java.lang.String getExistTargetFileName() {
        return this.existTargetFileName;
    }
}
