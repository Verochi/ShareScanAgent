package okhttp3.internal.http2;

/* loaded from: classes24.dex */
final class Http2Reader implements java.io.Closeable {
    public static final java.util.logging.Logger w = java.util.logging.Logger.getLogger(okhttp3.internal.http2.Http2.class.getName());
    public final okio.BufferedSource n;
    public final okhttp3.internal.http2.Http2Reader.ContinuationSource t;
    public final boolean u;
    public final okhttp3.internal.http2.Hpack.Reader v;

    public static final class ContinuationSource implements okio.Source {
        public final okio.BufferedSource n;
        public int t;
        public byte u;
        public int v;
        public int w;
        public short x;

        public ContinuationSource(okio.BufferedSource bufferedSource) {
            this.n = bufferedSource;
        }

        public final void a() throws java.io.IOException {
            int i = this.v;
            int h = okhttp3.internal.http2.Http2Reader.h(this.n);
            this.w = h;
            this.t = h;
            byte readByte = (byte) (this.n.readByte() & 255);
            this.u = (byte) (this.n.readByte() & 255);
            java.util.logging.Logger logger = okhttp3.internal.http2.Http2Reader.w;
            if (logger.isLoggable(java.util.logging.Level.FINE)) {
                logger.fine(okhttp3.internal.http2.Http2.b(true, this.v, this.t, readByte, this.u));
            }
            int readInt = this.n.readInt() & Integer.MAX_VALUE;
            this.v = readInt;
            if (readByte != 9) {
                throw okhttp3.internal.http2.Http2.d("%s != TYPE_CONTINUATION", java.lang.Byte.valueOf(readByte));
            }
            if (readInt != i) {
                throw okhttp3.internal.http2.Http2.d("TYPE_CONTINUATION streamId changed", new java.lang.Object[0]);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            while (true) {
                int i = this.w;
                if (i != 0) {
                    long read = this.n.read(buffer, java.lang.Math.min(j, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.w = (int) (this.w - read);
                    return read;
                }
                this.n.skip(this.x);
                this.x = (short) 0;
                if ((this.u & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.n.timeout();
        }
    }

    public interface Handler {
        void a(int i, int i2, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException;

        void b(boolean z, int i, int i2);

        void c(int i, okhttp3.internal.http2.ErrorCode errorCode);

        void d(int i, okhttp3.internal.http2.ErrorCode errorCode, okio.ByteString byteString);

        void e(boolean z, okhttp3.internal.http2.Settings settings);

        void f(boolean z, int i, int i2, java.util.List<okhttp3.internal.http2.Header> list);

        void g(int i, long j);

        void h();

        void i(boolean z, int i, okio.BufferedSource bufferedSource, int i2) throws java.io.IOException;

        void j(int i, int i2, int i3, boolean z);
    }

    public Http2Reader(okio.BufferedSource bufferedSource, boolean z) {
        this.n = bufferedSource;
        this.u = z;
        okhttp3.internal.http2.Http2Reader.ContinuationSource continuationSource = new okhttp3.internal.http2.Http2Reader.ContinuationSource(bufferedSource);
        this.t = continuationSource;
        this.v = new okhttp3.internal.http2.Hpack.Reader(4096, continuationSource);
    }

    public static int a(int i, byte b, short s2) throws java.io.IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s2 <= i) {
            return (short) (i - s2);
        }
        throw okhttp3.internal.http2.Http2.d("PROTOCOL_ERROR padding %s > remaining length %s", java.lang.Short.valueOf(s2), java.lang.Integer.valueOf(i));
    }

    public static int h(okio.BufferedSource bufferedSource) throws java.io.IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    public boolean b(boolean z, okhttp3.internal.http2.Http2Reader.Handler handler) throws java.io.IOException {
        try {
            this.n.require(9L);
            int h = h(this.n);
            if (h < 0 || h > 16384) {
                throw okhttp3.internal.http2.Http2.d("FRAME_SIZE_ERROR: %s", java.lang.Integer.valueOf(h));
            }
            byte readByte = (byte) (this.n.readByte() & 255);
            if (z && readByte != 4) {
                throw okhttp3.internal.http2.Http2.d("Expected a SETTINGS frame but was %s", java.lang.Byte.valueOf(readByte));
            }
            byte readByte2 = (byte) (this.n.readByte() & 255);
            int readInt = this.n.readInt() & Integer.MAX_VALUE;
            java.util.logging.Logger logger = w;
            if (logger.isLoggable(java.util.logging.Level.FINE)) {
                logger.fine(okhttp3.internal.http2.Http2.b(true, readInt, h, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    d(handler, h, readByte2, readInt);
                    return true;
                case 1:
                    g(handler, h, readByte2, readInt);
                    return true;
                case 2:
                    k(handler, h, readByte2, readInt);
                    return true;
                case 3:
                    m(handler, h, readByte2, readInt);
                    return true;
                case 4:
                    n(handler, h, readByte2, readInt);
                    return true;
                case 5:
                    l(handler, h, readByte2, readInt);
                    return true;
                case 6:
                    i(handler, h, readByte2, readInt);
                    return true;
                case 7:
                    e(handler, h, readByte2, readInt);
                    return true;
                case 8:
                    o(handler, h, readByte2, readInt);
                    return true;
                default:
                    this.n.skip(h);
                    return true;
            }
        } catch (java.io.EOFException unused) {
            return false;
        }
    }

    public void c(okhttp3.internal.http2.Http2Reader.Handler handler) throws java.io.IOException {
        if (this.u) {
            if (!b(true, handler)) {
                throw okhttp3.internal.http2.Http2.d("Required SETTINGS preface not received", new java.lang.Object[0]);
            }
            return;
        }
        okio.BufferedSource bufferedSource = this.n;
        okio.ByteString byteString = okhttp3.internal.http2.Http2.a;
        okio.ByteString readByteString = bufferedSource.readByteString(byteString.size());
        java.util.logging.Logger logger = w;
        if (logger.isLoggable(java.util.logging.Level.FINE)) {
            logger.fine(okhttp3.internal.Util.format("<< CONNECTION %s", readByteString.hex()));
        }
        if (!byteString.equals(readByteString)) {
            throw okhttp3.internal.http2.Http2.d("Expected a connection header but was %s", readByteString.utf8());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.n.close();
    }

    public final void d(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new java.lang.Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw okhttp3.internal.http2.Http2.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new java.lang.Object[0]);
        }
        short readByte = (b & 8) != 0 ? (short) (this.n.readByte() & 255) : (short) 0;
        handler.i(z, i2, this.n, a(i, b, readByte));
        this.n.skip(readByte);
    }

    public final void e(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i < 8) {
            throw okhttp3.internal.http2.Http2.d("TYPE_GOAWAY length < 8: %s", java.lang.Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw okhttp3.internal.http2.Http2.d("TYPE_GOAWAY streamId != 0", new java.lang.Object[0]);
        }
        int readInt = this.n.readInt();
        int readInt2 = this.n.readInt();
        int i3 = i - 8;
        okhttp3.internal.http2.ErrorCode fromHttp2 = okhttp3.internal.http2.ErrorCode.fromHttp2(readInt2);
        if (fromHttp2 == null) {
            throw okhttp3.internal.http2.Http2.d("TYPE_GOAWAY unexpected error code: %d", java.lang.Integer.valueOf(readInt2));
        }
        okio.ByteString byteString = okio.ByteString.EMPTY;
        if (i3 > 0) {
            byteString = this.n.readByteString(i3);
        }
        handler.d(readInt, fromHttp2, byteString);
    }

    public final java.util.List<okhttp3.internal.http2.Header> f(int i, short s2, byte b, int i2) throws java.io.IOException {
        okhttp3.internal.http2.Http2Reader.ContinuationSource continuationSource = this.t;
        continuationSource.w = i;
        continuationSource.t = i;
        continuationSource.x = s2;
        continuationSource.u = b;
        continuationSource.v = i2;
        this.v.k();
        return this.v.e();
    }

    public final void g(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new java.lang.Object[0]);
        }
        boolean z = (b & 1) != 0;
        short readByte = (b & 8) != 0 ? (short) (this.n.readByte() & 255) : (short) 0;
        if ((b & 32) != 0) {
            j(handler, i2);
            i -= 5;
        }
        handler.f(z, i2, -1, f(a(i, b, readByte), readByte, b, i2));
    }

    public final void i(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i != 8) {
            throw okhttp3.internal.http2.Http2.d("TYPE_PING length != 8: %s", java.lang.Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw okhttp3.internal.http2.Http2.d("TYPE_PING streamId != 0", new java.lang.Object[0]);
        }
        handler.b((b & 1) != 0, this.n.readInt(), this.n.readInt());
    }

    public final void j(okhttp3.internal.http2.Http2Reader.Handler handler, int i) throws java.io.IOException {
        int readInt = this.n.readInt();
        handler.j(i, readInt & Integer.MAX_VALUE, (this.n.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    public final void k(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i != 5) {
            throw okhttp3.internal.http2.Http2.d("TYPE_PRIORITY length: %d != 5", java.lang.Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.d("TYPE_PRIORITY streamId == 0", new java.lang.Object[0]);
        }
        j(handler, i2);
    }

    public final void l(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new java.lang.Object[0]);
        }
        short readByte = (b & 8) != 0 ? (short) (this.n.readByte() & 255) : (short) 0;
        handler.a(i2, this.n.readInt() & Integer.MAX_VALUE, f(a(i - 4, b, readByte), readByte, b, i2));
    }

    public final void m(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i != 4) {
            throw okhttp3.internal.http2.Http2.d("TYPE_RST_STREAM length: %d != 4", java.lang.Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw okhttp3.internal.http2.Http2.d("TYPE_RST_STREAM streamId == 0", new java.lang.Object[0]);
        }
        int readInt = this.n.readInt();
        okhttp3.internal.http2.ErrorCode fromHttp2 = okhttp3.internal.http2.ErrorCode.fromHttp2(readInt);
        if (fromHttp2 == null) {
            throw okhttp3.internal.http2.Http2.d("TYPE_RST_STREAM unexpected error code: %d", java.lang.Integer.valueOf(readInt));
        }
        handler.c(i2, fromHttp2);
    }

    public final void n(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i2 != 0) {
            throw okhttp3.internal.http2.Http2.d("TYPE_SETTINGS streamId != 0", new java.lang.Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw okhttp3.internal.http2.Http2.d("FRAME_SIZE_ERROR ack frame should be empty!", new java.lang.Object[0]);
            }
            handler.h();
            return;
        }
        if (i % 6 != 0) {
            throw okhttp3.internal.http2.Http2.d("TYPE_SETTINGS length %% 6 != 0: %s", java.lang.Integer.valueOf(i));
        }
        okhttp3.internal.http2.Settings settings = new okhttp3.internal.http2.Settings();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int readShort = this.n.readShort() & kotlin.UShort.MAX_VALUE;
            int readInt = this.n.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    if (readInt < 0) {
                        throw okhttp3.internal.http2.Http2.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new java.lang.Object[0]);
                    }
                    readShort = 7;
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    throw okhttp3.internal.http2.Http2.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", java.lang.Integer.valueOf(readInt));
                }
            } else if (readInt != 0 && readInt != 1) {
                throw okhttp3.internal.http2.Http2.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new java.lang.Object[0]);
            }
            settings.i(readShort, readInt);
        }
        handler.e(false, settings);
    }

    public final void o(okhttp3.internal.http2.Http2Reader.Handler handler, int i, byte b, int i2) throws java.io.IOException {
        if (i != 4) {
            throw okhttp3.internal.http2.Http2.d("TYPE_WINDOW_UPDATE length !=4: %s", java.lang.Integer.valueOf(i));
        }
        long readInt = this.n.readInt() & 2147483647L;
        if (readInt == 0) {
            throw okhttp3.internal.http2.Http2.d("windowSizeIncrement was 0", java.lang.Long.valueOf(readInt));
        }
        handler.g(i2, readInt);
    }
}
