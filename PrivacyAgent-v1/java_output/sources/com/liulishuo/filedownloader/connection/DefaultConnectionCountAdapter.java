package com.liulishuo.filedownloader.connection;

/* loaded from: classes23.dex */
public class DefaultConnectionCountAdapter implements com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter {
    @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCountAdapter
    public int determineConnectionCount(int i, java.lang.String str, java.lang.String str2, long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
