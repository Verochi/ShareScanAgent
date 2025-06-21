package com.alimm.tanx.core.net.okhttp.tanxc_if;

/* loaded from: classes.dex */
public class tanxc_do implements okhttp3.Interceptor {

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 extends okhttp3.RequestBody {
        final /* synthetic */ okhttp3.RequestBody tanxc_do;

        public AnonymousClass1(okhttp3.RequestBody requestBody) {
            this.tanxc_do = requestBody;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return -1L;
        }

        @Override // okhttp3.RequestBody
        public okhttp3.MediaType contentType() {
            return this.tanxc_do.contentType();
        }

        @Override // okhttp3.RequestBody
        public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
            okio.BufferedSink buffer = okio.Okio.buffer(new okio.GzipSink(bufferedSink));
            this.tanxc_do.writeTo(buffer);
            buffer.close();
        }
    }

    private okhttp3.RequestBody tanxc_do(okhttp3.RequestBody requestBody) {
        return new com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_do.AnonymousClass1(requestBody);
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Request request = chain.request();
        return (request.body() == null || request.header("Content-Encoding") != null) ? chain.proceed(request) : chain.proceed(request.newBuilder().method(request.method(), tanxc_do(request.body())).build());
    }
}
