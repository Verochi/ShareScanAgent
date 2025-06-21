package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
public interface IInput {
    @androidx.annotation.NonNull
    com.ss.android.socialbase.downloader.segment.Buffer read() throws com.ss.android.socialbase.downloader.segment.StreamClosedException, java.lang.InterruptedException;
}
