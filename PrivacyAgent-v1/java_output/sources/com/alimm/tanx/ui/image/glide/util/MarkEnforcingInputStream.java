package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public class MarkEnforcingInputStream extends java.io.FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes;

    public MarkEnforcingInputStream(java.io.InputStream inputStream) {
        super(inputStream);
        this.availableBytes = Integer.MIN_VALUE;
    }

    private long getBytesToRead(long j) {
        int i = this.availableBytes;
        if (i == 0) {
            return -1L;
        }
        if (i != Integer.MIN_VALUE) {
            long j2 = i;
            if (j > j2) {
                return j2;
            }
        }
        return j;
    }

    private void updateAvailableBytesAfterRead(long j) {
        int i = this.availableBytes;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.availableBytes = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws java.io.IOException {
        int i = this.availableBytes;
        return i == Integer.MIN_VALUE ? super.available() : java.lang.Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.availableBytes = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        if (getBytesToRead(1L) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int bytesToRead = (int) getBytesToRead(i2);
        if (bytesToRead == -1) {
            return -1;
        }
        int read = super.read(bArr, i, bytesToRead);
        updateAvailableBytesAfterRead(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws java.io.IOException {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        long bytesToRead = getBytesToRead(j);
        if (bytesToRead == -1) {
            return -1L;
        }
        long skip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(skip);
        return skip;
    }
}
