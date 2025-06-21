package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class ReaderInputStream extends java.io.InputStream {
    public final java.io.Reader n;
    public final java.nio.charset.CharsetEncoder t;
    public final byte[] u;
    public java.nio.CharBuffer v;
    public java.nio.ByteBuffer w;
    public boolean x;
    public boolean y;
    public boolean z;

    public ReaderInputStream(java.io.Reader reader, java.nio.charset.Charset charset, int i) {
        this(reader, charset.newEncoder().onMalformedInput(java.nio.charset.CodingErrorAction.REPLACE).onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPLACE), i);
    }

    public ReaderInputStream(java.io.Reader reader, java.nio.charset.CharsetEncoder charsetEncoder, int i) {
        this.u = new byte[1];
        this.n = (java.io.Reader) com.google.common.base.Preconditions.checkNotNull(reader);
        this.t = (java.nio.charset.CharsetEncoder) com.google.common.base.Preconditions.checkNotNull(charsetEncoder);
        com.google.common.base.Preconditions.checkArgument(i > 0, "bufferSize must be positive: %s", i);
        charsetEncoder.reset();
        java.nio.CharBuffer allocate = java.nio.CharBuffer.allocate(i);
        this.v = allocate;
        allocate.flip();
        this.w = java.nio.ByteBuffer.allocate(i);
    }

    public static int a(java.nio.Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    public static java.nio.CharBuffer c(java.nio.CharBuffer charBuffer) {
        java.nio.CharBuffer wrap = java.nio.CharBuffer.wrap(java.util.Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        wrap.position(charBuffer.position());
        wrap.limit(charBuffer.limit());
        return wrap;
    }

    public final int b(byte[] bArr, int i, int i2) {
        int min = java.lang.Math.min(i2, this.w.remaining());
        this.w.get(bArr, i, min);
        return min;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.n.close();
    }

    public final void e() throws java.io.IOException {
        if (a(this.v) == 0) {
            if (this.v.position() > 0) {
                this.v.compact().flip();
            } else {
                this.v = c(this.v);
            }
        }
        int limit = this.v.limit();
        int read = this.n.read(this.v.array(), limit, a(this.v));
        if (read == -1) {
            this.x = true;
        } else {
            this.v.limit(limit + read);
        }
    }

    public final void f(boolean z) {
        this.w.flip();
        if (z && this.w.remaining() == 0) {
            this.w = java.nio.ByteBuffer.allocate(this.w.capacity() * 2);
        } else {
            this.y = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        if (read(this.u) == 1) {
            return com.google.common.primitives.UnsignedBytes.toInt(this.u[0]);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r2 <= 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return r2;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        if (i2 == 0) {
            return 0;
        }
        boolean z = this.x;
        int i3 = 0;
        while (true) {
            if (this.y) {
                i3 += b(bArr, i + i3, i2 - i3);
                if (i3 == i2 || this.z) {
                    break;
                }
                this.y = false;
                this.w.clear();
            }
            while (true) {
                java.nio.charset.CoderResult flush = this.z ? java.nio.charset.CoderResult.UNDERFLOW : z ? this.t.flush(this.w) : this.t.encode(this.v, this.w, this.x);
                if (flush.isOverflow()) {
                    f(true);
                    break;
                }
                if (flush.isUnderflow()) {
                    if (z) {
                        this.z = true;
                        f(false);
                        break;
                    }
                    if (this.x) {
                        z = true;
                    } else {
                        e();
                    }
                } else if (flush.isError()) {
                    flush.throwException();
                    return 0;
                }
            }
        }
    }
}
