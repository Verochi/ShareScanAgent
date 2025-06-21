package okhttp3.internal.http;

/* loaded from: classes24.dex */
public interface ExchangeCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    okhttp3.internal.connection.RealConnection connection();

    okio.Sink createRequestBody(okhttp3.Request request, long j) throws java.io.IOException;

    void finishRequest() throws java.io.IOException;

    void flushRequest() throws java.io.IOException;

    okio.Source openResponseBodySource(okhttp3.Response response) throws java.io.IOException;

    @javax.annotation.Nullable
    okhttp3.Response.Builder readResponseHeaders(boolean z) throws java.io.IOException;

    long reportedContentLength(okhttp3.Response response) throws java.io.IOException;

    okhttp3.Headers trailers() throws java.io.IOException;

    void writeRequestHeaders(okhttp3.Request request) throws java.io.IOException;
}
