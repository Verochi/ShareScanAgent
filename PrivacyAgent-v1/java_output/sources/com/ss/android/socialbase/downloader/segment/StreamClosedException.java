package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
public class StreamClosedException extends com.ss.android.socialbase.downloader.exception.BaseException {
    public StreamClosedException(java.lang.String str) {
        super(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_STREAM_CLOSED, str);
    }
}
