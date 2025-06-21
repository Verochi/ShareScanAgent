package com.efs.sdk.net;

/* loaded from: classes22.dex */
public class OkHttpInterceptor implements okhttp3.Interceptor {
    private final com.efs.sdk.net.a.a.f a = com.efs.sdk.net.a.a.g.c();

    public static class a extends okhttp3.ResponseBody {
        private final okhttp3.ResponseBody a;
        private final okio.BufferedSource b;

        public a(okhttp3.ResponseBody responseBody, java.io.InputStream inputStream) {
            this.a = responseBody;
            this.b = okio.Okio.buffer(okio.Okio.source(inputStream));
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final okhttp3.MediaType contentType() {
            return this.a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final okio.BufferedSource source() {
            return this.b;
        }
    }

    public static class b implements com.efs.sdk.net.a.a.f.b {
        private final java.lang.String a;
        private final okhttp3.Request b;
        private com.efs.sdk.net.a.a.h c;

        public b(java.lang.String str, okhttp3.Request request, com.efs.sdk.net.a.a.h hVar) {
            this.a = str;
            this.b = request;
            this.c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.c
        public final java.lang.String a() {
            return this.a;
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final java.lang.String a(int i) {
            return this.b.headers().name(i);
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final java.lang.String b() {
            return this.b.url().toString();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final java.lang.String b(int i) {
            return this.b.headers().value(i);
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final java.lang.String c() {
            return this.b.method();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        @org.jetbrains.annotations.Nullable
        public final byte[] d() {
            okhttp3.RequestBody body = this.b.body();
            if (body == null) {
                return null;
            }
            com.efs.sdk.net.a.a.h hVar = this.c;
            java.lang.String header = this.b.header("Content-Encoding");
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            com.efs.sdk.net.a.a.a aVar = new com.efs.sdk.net.a.a.a("gzip".equals(header) ? com.efs.sdk.net.a.a.e.a(byteArrayOutputStream) : "deflate".equals(header) ? new java.util.zip.InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream);
            hVar.c = aVar;
            hVar.b = byteArrayOutputStream;
            okio.BufferedSink buffer = okio.Okio.buffer(okio.Okio.sink(aVar));
            try {
                body.writeTo(buffer);
                buffer.close();
                com.efs.sdk.net.a.a.h hVar2 = this.c;
                hVar2.b();
                return hVar2.b.toByteArray();
            } catch (java.lang.Throwable th) {
                buffer.close();
                throw th;
            }
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.b.headers().size();
        }
    }

    public static class c implements com.efs.sdk.net.a.a.f.d {
        private final java.lang.String a;
        private final okhttp3.Request b;
        private final okhttp3.Response c;

        @org.jetbrains.annotations.Nullable
        private final okhttp3.Connection d;

        public c(java.lang.String str, okhttp3.Request request, okhttp3.Response response, @org.jetbrains.annotations.Nullable okhttp3.Connection connection) {
            this.a = str;
            this.b = request;
            this.c = response;
            this.d = connection;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final java.lang.String a() {
            return this.a;
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final java.lang.String a(int i) {
            return this.c.headers().name(i);
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final int b() {
            return this.c.code();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final java.lang.String b(int i) {
            return this.c.headers().value(i);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.c.headers().size();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|1|2|3|(1:5)|(3:55|56|(1:58)(6:59|15|(3:38|39|(1:41)(1:42))|(1:20)|21|(6:23|(1:25)(1:35)|26|(1:28)|29|(2:31|32)(1:34))(2:36|37)))|(1:9)(1:54)|10|11|12|13|14|15|(0)|(2:18|20)|21|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0088, code lost:
    
        r8 = r3;
        r3 = r0;
        r0 = r5;
        r5 = r4;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008f, code lost:
    
        r5 = r4;
        r4 = r3;
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:39:0x00a3, B:18:0x00ae, B:20:0x00b4, B:21:0x00c1, B:23:0x00c7, B:25:0x00d7, B:26:0x00e2, B:28:0x00e6, B:29:0x00ea, B:31:0x00fd, B:36:0x0110, B:37:0x0117), top: B:38:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c7 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:39:0x00a3, B:18:0x00ae, B:20:0x00b4, B:21:0x00c1, B:23:0x00c7, B:25:0x00d7, B:26:0x00e2, B:28:0x00e6, B:29:0x00ea, B:31:0x00fd, B:36:0x0110, B:37:0x0117), top: B:38:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0110 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:39:0x00a3, B:18:0x00ae, B:20:0x00b4, B:21:0x00c1, B:23:0x00c7, B:25:0x00d7, B:26:0x00e2, B:28:0x00e6, B:29:0x00ea, B:31:0x00fd, B:36:0x0110, B:37:0x0117), top: B:38:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) {
        com.efs.sdk.net.a.a.h hVar;
        java.lang.String str;
        boolean z;
        com.efs.sdk.net.a.a.h hVar2;
        boolean z2;
        java.lang.String str2;
        okhttp3.Connection connection;
        okhttp3.MediaType mediaType;
        java.io.InputStream inputStream;
        okhttp3.Request request = chain.request();
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "begin intercept");
            z2 = com.efs.sdk.net.NetManager.getNetConfigManager() != null ? com.efs.sdk.net.NetManager.getNetConfigManager().enableTracer() : false;
        } catch (java.lang.Throwable th) {
            th = th;
            hVar = null;
            str = null;
            z = false;
        }
        if (!z2) {
            try {
            } catch (java.lang.Throwable th2) {
                th = th2;
                str = null;
                z = z2;
                hVar = null;
                th.printStackTrace();
                hVar2 = hVar;
                z2 = z;
                str2 = str;
                okhttp3.Response proceed = chain.proceed(request);
                if (!z2) {
                }
                if (hVar2 != null) {
                }
                connection = chain.connection();
                if (connection != null) {
                }
            }
            if (!com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "net enable is false~");
                hVar2 = null;
                str2 = null;
                okhttp3.Response proceed2 = chain.proceed(request);
                if (!z2) {
                    try {
                        if (!com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                            return proceed2;
                        }
                    } catch (java.lang.Throwable th3) {
                        th3.printStackTrace();
                        return proceed2;
                    }
                }
                if (hVar2 != null && hVar2.a()) {
                    hVar2.b();
                    com.efs.sdk.net.a.a.f fVar = hVar2.a;
                    hVar2.b.size();
                    fVar.a();
                }
                connection = chain.connection();
                if (connection != null) {
                    throw new java.lang.IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
                }
                this.a.a(new com.efs.sdk.net.OkHttpInterceptor.c(str2, request, proceed2, connection));
                okhttp3.ResponseBody body = proceed2.body();
                if (body != null) {
                    mediaType = body.contentType();
                    inputStream = body.byteStream();
                } else {
                    mediaType = null;
                    inputStream = null;
                }
                com.efs.sdk.net.a.a.f fVar2 = this.a;
                java.lang.String mediaType2 = mediaType != null ? mediaType.toString() : null;
                java.lang.String header = proceed2.header("Content-Encoding");
                new com.efs.sdk.net.a.a.c(this.a, str2);
                java.io.InputStream a2 = fVar2.a(str2, mediaType2, header, inputStream);
                return a2 != null ? proceed2.newBuilder().body(new com.efs.sdk.net.OkHttpInterceptor.a(body, a2)).build() : proceed2;
            }
        }
        if (request != null) {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "intercept request is " + request.toString());
        } else {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "intercept request is null~");
        }
        str2 = this.a.b();
        com.efs.sdk.base.core.util.Log.d("NetTrace-Interceptor", "intercept request id is ".concat(java.lang.String.valueOf(str2)));
        com.efs.sdk.net.a.a.a().a(str2).c = request.url().toString();
        hVar2 = new com.efs.sdk.net.a.a.h(this.a, str2);
        this.a.a(new com.efs.sdk.net.OkHttpInterceptor.b(str2, request, hVar2));
        okhttp3.Response proceed22 = chain.proceed(request);
        if (!z2) {
        }
        if (hVar2 != null) {
            hVar2.b();
            com.efs.sdk.net.a.a.f fVar3 = hVar2.a;
            hVar2.b.size();
            fVar3.a();
        }
        connection = chain.connection();
        if (connection != null) {
        }
    }
}
