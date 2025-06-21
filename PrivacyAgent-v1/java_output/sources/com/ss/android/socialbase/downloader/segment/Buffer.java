package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
public final class Buffer {
    public final byte[] data;
    public com.ss.android.socialbase.downloader.segment.Buffer next;
    com.ss.android.socialbase.downloader.segment.IOutput output;
    public int size;

    public Buffer(int i) {
        this.data = new byte[i];
    }
}
