package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
public interface IBufferPool {
    @androidx.annotation.NonNull
    com.ss.android.socialbase.downloader.segment.Buffer obtain() throws com.ss.android.socialbase.downloader.segment.StreamClosedException, java.lang.InterruptedException;

    void recycle(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.segment.Buffer buffer);
}
