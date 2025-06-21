package com.google.android.exoplayer2.offline;

@androidx.annotation.WorkerThread
/* loaded from: classes22.dex */
public interface DownloadIndex {
    @androidx.annotation.Nullable
    com.google.android.exoplayer2.offline.Download getDownload(java.lang.String str) throws java.io.IOException;

    com.google.android.exoplayer2.offline.DownloadCursor getDownloads(int... iArr) throws java.io.IOException;
}
