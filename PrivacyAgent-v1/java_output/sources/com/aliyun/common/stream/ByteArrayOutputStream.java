package com.aliyun.common.stream;

/* loaded from: classes.dex */
public class ByteArrayOutputStream extends java.io.OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final java.util.List<byte[]> buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;

    public ByteArrayOutputStream() {
        this(1024);
    }

    public ByteArrayOutputStream(int i) {
        this.buffers = new java.util.ArrayList();
        if (i >= 0) {
            synchronized (this) {
                needNewBuffer(i);
            }
        } else {
            throw new java.lang.IllegalArgumentException("Negative initial size: " + i);
        }
    }

    private void needNewBuffer(int i) {
        int length;
        if (this.currentBufferIndex < this.buffers.size() - 1) {
            this.filledBufferSum += this.currentBuffer.length;
            int i2 = this.currentBufferIndex + 1;
            this.currentBufferIndex = i2;
            this.currentBuffer = this.buffers.get(i2);
            return;
        }
        byte[] bArr = this.currentBuffer;
        if (bArr == null) {
            length = 0;
        } else {
            i = java.lang.Math.max(bArr.length << 1, i - this.filledBufferSum);
            length = this.filledBufferSum + this.currentBuffer.length;
        }
        this.filledBufferSum = length;
        this.currentBufferIndex++;
        byte[] bArr2 = new byte[i];
        this.currentBuffer = bArr2;
        this.buffers.add(bArr2);
    }

    private java.io.InputStream toBufferedInputStream() {
        int i = this.count;
        if (i == 0) {
            return new com.aliyun.common.stream.ClosedInputStream();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.buffers.size());
        for (byte[] bArr : this.buffers) {
            int min = java.lang.Math.min(bArr.length, i);
            arrayList.add(new java.io.ByteArrayInputStream(bArr, 0, min));
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return new java.io.SequenceInputStream(java.util.Collections.enumeration(arrayList));
    }

    public static java.io.InputStream toBufferedInputStream(java.io.InputStream inputStream) throws java.io.IOException {
        com.aliyun.common.stream.ByteArrayOutputStream byteArrayOutputStream = new com.aliyun.common.stream.ByteArrayOutputStream();
        byteArrayOutputStream.write(inputStream);
        return byteArrayOutputStream.toBufferedInputStream();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
    }

    public synchronized void reset() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        this.currentBuffer = this.buffers.get(0);
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        int i = this.count;
        if (i == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.buffers) {
            int min = java.lang.Math.min(bArr2.length, i);
            java.lang.System.arraycopy(bArr2, 0, bArr, i2, min);
            i2 += min;
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return bArr;
    }

    public java.lang.String toString() {
        return new java.lang.String(toByteArray());
    }

    public java.lang.String toString(java.lang.String str) throws java.io.UnsupportedEncodingException {
        return new java.lang.String(toByteArray(), str);
    }

    public synchronized int write(java.io.InputStream inputStream) throws java.io.IOException {
        int i;
        int i2 = this.count - this.filledBufferSum;
        byte[] bArr = this.currentBuffer;
        int read = inputStream.read(bArr, i2, bArr.length - i2);
        i = 0;
        while (read != -1) {
            i += read;
            i2 += read;
            this.count += read;
            byte[] bArr2 = this.currentBuffer;
            if (i2 == bArr2.length) {
                needNewBuffer(bArr2.length);
                i2 = 0;
            }
            byte[] bArr3 = this.currentBuffer;
            read = inputStream.read(bArr3, i2, bArr3.length - i2);
        }
        return i;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        int i2 = this.count;
        int i3 = i2 - this.filledBufferSum;
        if (i3 == this.currentBuffer.length) {
            needNewBuffer(i2 + 1);
            i3 = 0;
        }
        this.currentBuffer[i3] = (byte) i;
        this.count++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        synchronized (this) {
            int i4 = this.count;
            int i5 = i4 + i2;
            int i6 = i4 - this.filledBufferSum;
            while (i2 > 0) {
                int min = java.lang.Math.min(i2, this.currentBuffer.length - i6);
                java.lang.System.arraycopy(bArr, i3 - i2, this.currentBuffer, i6, min);
                i2 -= min;
                if (i2 > 0) {
                    needNewBuffer(i5);
                    i6 = 0;
                }
            }
            this.count = i5;
        }
    }

    public synchronized void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        int i = this.count;
        for (byte[] bArr : this.buffers) {
            int min = java.lang.Math.min(bArr.length, i);
            outputStream.write(bArr, 0, min);
            i -= min;
            if (i == 0) {
                break;
            }
        }
    }
}
