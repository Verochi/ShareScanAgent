package com.liulishuo.filedownloader.stream;

/* loaded from: classes23.dex */
public class FileDownloadRandomAccessFile implements com.liulishuo.filedownloader.stream.FileDownloadOutputStream {
    public final java.io.BufferedOutputStream a;
    public final java.io.FileDescriptor b;
    public final java.io.RandomAccessFile c;

    public static class Creator implements com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator {
        @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator
        public com.liulishuo.filedownloader.stream.FileDownloadOutputStream create(java.io.File file) throws java.io.IOException {
            return new com.liulishuo.filedownloader.stream.FileDownloadRandomAccessFile(file);
        }

        @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.OutputStreamCreator
        public boolean supportSeek() {
            return true;
        }
    }

    public FileDownloadRandomAccessFile(java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
        this.c = randomAccessFile;
        this.b = randomAccessFile.getFD();
        this.a = new java.io.BufferedOutputStream(new java.io.FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // com.liulishuo.filedownloader.stream.FileDownloadOutputStream
    public void close() throws java.io.IOException {
        this.a.close();
        this.c.close();
    }

    @Override // com.liulishuo.filedownloader.stream.FileDownloadOutputStream
    public void flushAndSync() throws java.io.IOException {
        this.a.flush();
        this.b.sync();
    }

    @Override // com.liulishuo.filedownloader.stream.FileDownloadOutputStream
    public void seek(long j) throws java.io.IOException {
        this.c.seek(j);
    }

    @Override // com.liulishuo.filedownloader.stream.FileDownloadOutputStream
    public void setLength(long j) throws java.io.IOException {
        this.c.setLength(j);
    }

    @Override // com.liulishuo.filedownloader.stream.FileDownloadOutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.a.write(bArr, i, i2);
    }
}
