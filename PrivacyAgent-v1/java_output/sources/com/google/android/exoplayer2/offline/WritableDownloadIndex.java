package com.google.android.exoplayer2.offline;

@androidx.annotation.WorkerThread
/* loaded from: classes22.dex */
public interface WritableDownloadIndex extends com.google.android.exoplayer2.offline.DownloadIndex {
    void putDownload(com.google.android.exoplayer2.offline.Download download) throws java.io.IOException;

    void removeDownload(java.lang.String str) throws java.io.IOException;

    void setDownloadingStatesToQueued() throws java.io.IOException;

    void setStatesToRemoving() throws java.io.IOException;

    void setStopReason(int i) throws java.io.IOException;

    void setStopReason(java.lang.String str, int i) throws java.io.IOException;
}
