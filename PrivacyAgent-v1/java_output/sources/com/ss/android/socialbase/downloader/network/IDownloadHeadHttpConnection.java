package com.ss.android.socialbase.downloader.network;

/* loaded from: classes19.dex */
public interface IDownloadHeadHttpConnection {
    void cancel();

    int getResponseCode() throws java.io.IOException;

    java.lang.String getResponseHeaderField(java.lang.String str);
}
