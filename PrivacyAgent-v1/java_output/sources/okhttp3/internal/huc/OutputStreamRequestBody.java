package okhttp3.internal.huc;

/* loaded from: classes24.dex */
abstract class OutputStreamRequestBody extends okhttp3.RequestBody {
    public okio.Timeout a;
    public long b;
    public java.io.OutputStream c;
    public boolean d;

    /* renamed from: okhttp3.internal.huc.OutputStreamRequestBody$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.OutputStream {
        public long n;
        public final /* synthetic */ long t;
        public final /* synthetic */ okio.BufferedSink u;

        public AnonymousClass1(long j, okio.BufferedSink bufferedSink) {
            this.t = j;
            this.u = bufferedSink;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            okhttp3.internal.huc.OutputStreamRequestBody.this.d = true;
            long j = this.t;
            if (j == -1 || this.n >= j) {
                this.u.close();
                return;
            }
            throw new java.net.ProtocolException("expected " + this.t + " bytes but received " + this.n);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws java.io.IOException {
            if (okhttp3.internal.huc.OutputStreamRequestBody.this.d) {
                return;
            }
            this.u.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws java.io.IOException {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
            if (okhttp3.internal.huc.OutputStreamRequestBody.this.d) {
                throw new java.io.IOException("closed");
            }
            long j = this.t;
            if (j == -1 || this.n + i2 <= j) {
                this.n += i2;
                try {
                    this.u.write(bArr, i, i2);
                    return;
                } catch (java.io.InterruptedIOException e) {
                    throw new java.net.SocketTimeoutException(e.getMessage());
                }
            }
            throw new java.net.ProtocolException("expected " + this.t + " bytes but received " + this.n + i2);
        }
    }

    public void a(okio.BufferedSink bufferedSink, long j) {
        this.a = bufferedSink.timeout();
        this.b = j;
        this.c = new okhttp3.internal.huc.OutputStreamRequestBody.AnonymousClass1(j, bufferedSink);
    }

    public final boolean b() {
        return this.d;
    }

    public final java.io.OutputStream c() {
        return this.c;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws java.io.IOException {
        return this.b;
    }

    @Override // okhttp3.RequestBody
    public final okhttp3.MediaType contentType() {
        return null;
    }

    public okhttp3.Request d(okhttp3.Request request) throws java.io.IOException {
        return request;
    }

    public final okio.Timeout e() {
        return this.a;
    }
}
