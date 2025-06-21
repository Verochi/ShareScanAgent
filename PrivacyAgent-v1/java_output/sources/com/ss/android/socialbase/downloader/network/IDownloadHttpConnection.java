package com.ss.android.socialbase.downloader.network;

/* loaded from: classes19.dex */
public interface IDownloadHttpConnection extends com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection {
    void end();

    java.io.InputStream getInputStream() throws java.io.IOException;
}
