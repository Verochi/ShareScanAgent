package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class BridgeInterceptor implements okhttp3.Interceptor {
    public final okhttp3.CookieJar a;

    public BridgeInterceptor(okhttp3.CookieJar cookieJar) {
        this.a = cookieJar;
    }

    public final java.lang.String a(java.util.List<okhttp3.Cookie> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            okhttp3.Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append(com.alipay.sdk.m.n.a.h);
            sb.append(cookie.value());
        }
        return sb.toString();
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Request request = chain.request();
        okhttp3.Request.Builder newBuilder = request.newBuilder();
        okhttp3.RequestBody body = request.body();
        if (body != null) {
            okhttp3.MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", java.lang.Long.toString(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED);
                newBuilder.removeHeader("Content-Length");
            }
        }
        boolean z = false;
        if (request.header("Host") == null) {
            newBuilder.header("Host", okhttp3.internal.Util.hostHeader(request.url(), false));
        }
        if (request.header(com.google.common.net.HttpHeaders.CONNECTION) == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
        }
        if (request.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING) == null && request.header("Range") == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        }
        java.util.List<okhttp3.Cookie> loadForRequest = this.a.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(com.google.common.net.HttpHeaders.COOKIE, a(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", okhttp3.internal.Version.userAgent());
        }
        okhttp3.Response proceed = chain.proceed(newBuilder.build());
        okhttp3.internal.http.HttpHeaders.receiveHeaders(this.a, request.url(), proceed.headers());
        okhttp3.Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && okhttp3.internal.http.HttpHeaders.hasBody(proceed)) {
            okio.GzipSource gzipSource = new okio.GzipSource(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new okhttp3.internal.http.RealResponseBody(proceed.header("Content-Type"), -1L, okio.Okio.buffer(gzipSource)));
        }
        return request2.build();
    }
}
