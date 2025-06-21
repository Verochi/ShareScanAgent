package okhttp3.internal.huc;

/* loaded from: classes24.dex */
final class StreamedRequestBody extends okhttp3.internal.huc.OutputStreamRequestBody implements okhttp3.internal.http.UnrepeatableRequestBody {
    public final okio.Pipe e;

    public StreamedRequestBody(long j) {
        okio.Pipe pipe = new okio.Pipe(8192L);
        this.e = pipe;
        a(okio.Okio.buffer(pipe.sink()), j);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
        okio.Buffer buffer = new okio.Buffer();
        while (this.e.source().read(buffer, 8192L) != -1) {
            bufferedSink.write(buffer, buffer.size());
        }
    }
}
