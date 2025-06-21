package okhttp3.internal.http2;

/* loaded from: classes24.dex */
final class Http2Writer implements java.io.Closeable {
    public static final java.util.logging.Logger y = java.util.logging.Logger.getLogger(okhttp3.internal.http2.Http2.class.getName());
    public final okio.BufferedSink n;
    public final boolean t;
    public final okio.Buffer u;
    public int v;
    public boolean w;
    public final okhttp3.internal.http2.Hpack.Writer x;

    public Http2Writer(okio.BufferedSink bufferedSink, boolean z) {
        this.n = bufferedSink;
        this.t = z;
        okio.Buffer buffer = new okio.Buffer();
        this.u = buffer;
        this.x = new okhttp3.internal.http2.Hpack.Writer(buffer);
        this.v = 16384;
    }

    public static void q(okio.BufferedSink bufferedSink, int i) throws java.io.IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    public synchronized void a(okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        this.v = settings.f(this.v);
        if (settings.c() != -1) {
            this.x.e(settings.c());
        }
        f(0, 0, (byte) 4, (byte) 1);
        this.n.flush();
    }

    public synchronized void c() throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        if (this.t) {
            java.util.logging.Logger logger = y;
            if (logger.isLoggable(java.util.logging.Level.FINE)) {
                logger.fine(okhttp3.internal.Util.format(">> CONNECTION %s", okhttp3.internal.http2.Http2.a.hex()));
            }
            this.n.write(okhttp3.internal.http2.Http2.a.toByteArray());
            this.n.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        this.w = true;
        this.n.close();
    }

    public synchronized void d(boolean z, int i, okio.Buffer buffer, int i2) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        e(i, z ? (byte) 1 : (byte) 0, buffer, i2);
    }

    public void e(int i, byte b, okio.Buffer buffer, int i2) throws java.io.IOException {
        f(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.n.write(buffer, i2);
        }
    }

    public void f(int i, int i2, byte b, byte b2) throws java.io.IOException {
        java.util.logging.Logger logger = y;
        if (logger.isLoggable(java.util.logging.Level.FINE)) {
            logger.fine(okhttp3.internal.http2.Http2.b(false, i, i2, b, b2));
        }
        int i3 = this.v;
        if (i2 > i3) {
            throw okhttp3.internal.http2.Http2.c("FRAME_SIZE_ERROR length > %d: %d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw okhttp3.internal.http2.Http2.c("reserved bit set: %s", java.lang.Integer.valueOf(i));
        }
        q(this.n, i2);
        this.n.writeByte(b & 255);
        this.n.writeByte(b2 & 255);
        this.n.writeInt(i & Integer.MAX_VALUE);
    }

    public synchronized void flush() throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        this.n.flush();
    }

    public synchronized void g(int i, okhttp3.internal.http2.ErrorCode errorCode, byte[] bArr) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw okhttp3.internal.http2.Http2.c("errorCode.httpCode == -1", new java.lang.Object[0]);
        }
        f(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.n.writeInt(i);
        this.n.writeInt(errorCode.httpCode);
        if (bArr.length > 0) {
            this.n.write(bArr);
        }
        this.n.flush();
    }

    public synchronized void h(boolean z, int i, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        this.x.g(list);
        long size = this.u.size();
        int min = (int) java.lang.Math.min(this.v, size);
        long j = min;
        byte b = size == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        f(i, min, (byte) 1, b);
        this.n.write(this.u, j);
        if (size > j) {
            p(i, size - j);
        }
    }

    public int j() {
        return this.v;
    }

    public synchronized void k(boolean z, int i, int i2) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        f(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.n.writeInt(i);
        this.n.writeInt(i2);
        this.n.flush();
    }

    public synchronized void l(int i, int i2, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        this.x.g(list);
        long size = this.u.size();
        int min = (int) java.lang.Math.min(this.v - 4, size);
        long j = min;
        f(i, min + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
        this.n.writeInt(i2 & Integer.MAX_VALUE);
        this.n.write(this.u, j);
        if (size > j) {
            p(i, size - j);
        }
    }

    public synchronized void m(int i, okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new java.lang.IllegalArgumentException();
        }
        f(i, 4, (byte) 3, (byte) 0);
        this.n.writeInt(errorCode.httpCode);
        this.n.flush();
    }

    public synchronized void n(okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        int i = 0;
        f(0, settings.j() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (settings.g(i)) {
                this.n.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                this.n.writeInt(settings.b(i));
            }
            i++;
        }
        this.n.flush();
    }

    public synchronized void o(int i, long j) throws java.io.IOException {
        if (this.w) {
            throw new java.io.IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw okhttp3.internal.http2.Http2.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", java.lang.Long.valueOf(j));
        }
        f(i, 4, (byte) 8, (byte) 0);
        this.n.writeInt((int) j);
        this.n.flush();
    }

    public final void p(int i, long j) throws java.io.IOException {
        while (j > 0) {
            int min = (int) java.lang.Math.min(this.v, j);
            long j2 = min;
            j -= j2;
            f(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.n.write(this.u, j2);
        }
    }
}
