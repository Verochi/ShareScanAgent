package com.liulishuo.filedownloader.stream;

/* loaded from: classes23.dex */
public interface FileDownloadOutputStream {
    void close() throws java.io.IOException;

    void flushAndSync() throws java.io.IOException;

    void seek(long j) throws java.io.IOException, java.lang.IllegalAccessException;

    void setLength(long j) throws java.io.IOException, java.lang.IllegalAccessException;

    void write(byte[] bArr, int i, int i2) throws java.io.IOException;
}
