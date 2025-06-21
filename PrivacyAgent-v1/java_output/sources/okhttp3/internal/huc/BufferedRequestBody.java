package okhttp3.internal.huc;

/* loaded from: classes24.dex */
final class BufferedRequestBody extends okhttp3.internal.huc.OutputStreamRequestBody {
    public final okio.Buffer e;
    public long f;

    public BufferedRequestBody(long j) {
        okio.Buffer buffer = new okio.Buffer();
        this.e = buffer;
        this.f = -1L;
        a(buffer, j);
    }

    @Override // okhttp3.internal.huc.OutputStreamRequestBody, okhttp3.RequestBody
    public long contentLength() throws java.io.IOException {
        return this.f;
    }

    @Override // okhttp3.internal.huc.OutputStreamRequestBody
    public okhttp3.Request d(okhttp3.Request request) throws java.io.IOException {
        if (request.header("Content-Length") != null) {
            return request;
        }
        c().close();
        this.f = this.e.size();
        return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", java.lang.Long.toString(this.e.size())).build();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
        this.e.copyTo(bufferedSink.buffer(), 0L, this.e.size());
    }
}
