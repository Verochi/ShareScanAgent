package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public interface Downloader {

    public interface ProgressListener {
        void onProgress(long j, long j2, float f);
    }

    void cancel();

    void download(@androidx.annotation.Nullable com.google.android.exoplayer2.offline.Downloader.ProgressListener progressListener) throws java.io.IOException, java.lang.InterruptedException;

    void remove();
}
