package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
final class BufferedSink {
    public final java.io.OutputStream sink;
    private long size;

    public BufferedSink(java.io.OutputStream outputStream) {
        if (outputStream == null) {
            throw new java.lang.NullPointerException("sink == null");
        }
        this.sink = outputStream;
        this.size = 0L;
    }

    public final void close() throws java.io.IOException {
        this.sink.close();
    }

    public final long size() {
        return this.size;
    }

    public final com.getui.gtc.base.http.BufferedSink write(java.lang.String str) throws java.io.IOException {
        this.sink.write(str.getBytes());
        this.size += r5.length;
        return this;
    }

    public final com.getui.gtc.base.http.BufferedSink write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        this.sink.write(byteBuffer.array());
        this.size += r5.length;
        return this;
    }

    public final com.getui.gtc.base.http.BufferedSink write(byte[] bArr) throws java.io.IOException {
        this.sink.write(bArr);
        this.size += bArr.length;
        return this;
    }

    public final com.getui.gtc.base.http.BufferedSink writeLong(long j) throws java.io.IOException {
        this.sink.write(java.lang.String.valueOf(j).getBytes());
        this.size += r3.length;
        return this;
    }

    public final com.getui.gtc.base.http.BufferedSink writeUtf8(java.lang.String str) throws java.io.IOException {
        this.sink.write(str.getBytes());
        this.size += r5.length;
        return this;
    }
}
