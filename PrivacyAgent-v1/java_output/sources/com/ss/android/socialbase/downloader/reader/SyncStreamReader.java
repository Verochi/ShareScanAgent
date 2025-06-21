package com.ss.android.socialbase.downloader.reader;

/* loaded from: classes19.dex */
public class SyncStreamReader implements com.ss.android.socialbase.downloader.reader.IStreamReader {
    private final com.ss.android.socialbase.downloader.segment.Buffer buffer;
    private final java.io.InputStream inputStream;

    public SyncStreamReader(java.io.InputStream inputStream, int i) {
        this.inputStream = inputStream;
        this.buffer = new com.ss.android.socialbase.downloader.segment.Buffer(i);
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void close() {
        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(this.inputStream);
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public com.ss.android.socialbase.downloader.segment.Buffer read() throws java.io.IOException {
        com.ss.android.socialbase.downloader.segment.Buffer buffer = this.buffer;
        buffer.size = this.inputStream.read(buffer.data);
        return this.buffer;
    }

    @Override // com.ss.android.socialbase.downloader.reader.IStreamReader
    public void recycle(com.ss.android.socialbase.downloader.segment.Buffer buffer) {
    }
}
