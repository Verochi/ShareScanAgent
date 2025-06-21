package com.ss.android.socialbase.downloader.model;

/* loaded from: classes19.dex */
public class RandomAccessOutputStream implements java.io.Closeable {
    private static final int MAX_FLUSH_BUFFER_SIZE = 131072;
    private static final int MIN_FLUSH_BUFFER_SIZE = 8192;
    private java.io.FileDescriptor fd;
    private java.io.BufferedOutputStream outputStream;
    private java.io.RandomAccessFile randomAccess;

    public RandomAccessOutputStream(java.io.File file, int i) throws com.ss.android.socialbase.downloader.exception.BaseException {
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            this.randomAccess = randomAccessFile;
            this.fd = randomAccessFile.getFD();
            if (i <= 0) {
                this.outputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(this.randomAccess.getFD()));
                return;
            }
            if (i < 8192) {
                i = 8192;
            } else if (i > 131072) {
                i = 131072;
            }
            this.outputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(this.randomAccess.getFD()), i);
        } catch (java.io.IOException e) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_OUTPUT_STREAM_CREATE_IO, e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(this.randomAccess, this.outputStream);
    }

    public void flush() throws java.io.IOException {
        java.io.BufferedOutputStream bufferedOutputStream = this.outputStream;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void flushAndSync() throws java.io.IOException {
        java.io.BufferedOutputStream bufferedOutputStream = this.outputStream;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        java.io.FileDescriptor fileDescriptor = this.fd;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void seek(long j) throws java.io.IOException {
        this.randomAccess.seek(j);
    }

    public void setLength(long j) throws java.io.IOException {
        this.randomAccess.setLength(j);
    }

    public void sync() throws java.io.IOException {
        java.io.FileDescriptor fileDescriptor = this.fd;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.outputStream.write(bArr, i, i2);
    }
}
