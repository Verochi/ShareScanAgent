package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class CheckCRC64DownloadInputStream extends java.util.zip.CheckedInputStream {
    private long mClientCRC64;
    private java.lang.String mRequestId;
    private long mServerCRC64;
    private long mTotalBytesRead;
    private long mTotalLength;

    public CheckCRC64DownloadInputStream(java.io.InputStream inputStream, java.util.zip.Checksum checksum, long j, long j2, java.lang.String str) {
        super(inputStream, checksum);
        this.mTotalLength = j;
        this.mServerCRC64 = j2;
        this.mRequestId = str;
    }

    private void checkCRC64(int i) throws java.io.IOException {
        long j = this.mTotalBytesRead + i;
        this.mTotalBytesRead = j;
        if (j >= this.mTotalLength) {
            long value = getChecksum().getValue();
            this.mClientCRC64 = value;
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.checkChecksum(java.lang.Long.valueOf(value), java.lang.Long.valueOf(this.mServerCRC64), this.mRequestId);
        }
    }

    public long getClientCRC64() {
        return this.mClientCRC64;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        int read = super.read();
        checkCRC64(read);
        return read;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int read = super.read(bArr, i, i2);
        checkCRC64(read);
        return read;
    }
}
