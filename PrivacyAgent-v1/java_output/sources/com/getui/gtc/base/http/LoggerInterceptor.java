package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class LoggerInterceptor implements com.getui.gtc.base.http.Interceptor {
    public static final int BASIC = 1;
    public static final int BODY = 4;
    static final int FLAG_UNSET = -1;
    public static final int HEADER = 2;
    private final int flags;
    private final com.getui.gtc.base.log.Logger logger;

    public LoggerInterceptor(com.getui.gtc.base.log.Logger logger) {
        this(logger, 5);
    }

    public LoggerInterceptor(com.getui.gtc.base.log.Logger logger, int i) {
        this.logger = logger;
        this.flags = i;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> headers;
        java.util.Map<java.lang.String, java.lang.String> headers2;
        com.getui.gtc.base.http.Request request = chain.request();
        com.getui.gtc.base.http.Request.Builder newBuilder = request.newBuilder();
        int logFlags = request.logFlags();
        if (logFlags == -1) {
            logFlags = this.flags;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = logFlags & 1;
        if (i == 1) {
            sb.append(request.method() + " " + request.url().toString() + " " + request.tag() + "\n");
        }
        int i2 = logFlags & 2;
        if (i2 == 2 && (headers2 = request.headers()) != null && headers2.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : headers2.entrySet()) {
                sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
        int i3 = logFlags & 4;
        if (i3 == 4 && request.body() != null && request.body().contentType().charset() != null) {
            if (request.body().contentLength() > 2147483647L) {
                sb.append("request body content length: " + request.body().contentLength() + "\n");
            } else {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                request.body().writeTo(byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                sb.append(new java.lang.String(byteArray, request.body().contentType().charset()) + "\n");
                newBuilder.body(com.getui.gtc.base.http.RequestBody.create(request.body().contentType(), byteArray));
            }
        }
        this.logger.d(sb.toString());
        com.getui.gtc.base.http.Response proceed = chain.proceed(newBuilder.build());
        com.getui.gtc.base.http.Response.Builder newBuilder2 = proceed.newBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        if (i == 1) {
            sb2.append(proceed.code() + " " + proceed.message() + " " + request.url().toString() + " " + request.tag() + "\n");
        }
        if (i2 == 2 && (headers = proceed.headers()) != null && headers.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry2 : headers.entrySet()) {
                if (entry2.getValue() != null && entry2.getValue().size() > 0) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    for (int i4 = 0; i4 < entry2.getValue().size(); i4++) {
                        sb3.append(entry2.getValue().get(i4));
                        if (i4 < entry2.getValue().size() - 1) {
                            sb3.append("; ");
                        }
                    }
                    sb2.append(entry2.getKey() + ": " + sb3.toString() + "\n");
                }
            }
        }
        if (i3 == 4 && proceed.body() != null && proceed.body().contentType().charset() != null) {
            if (proceed.body().contentLength() > 2147483647L) {
                sb2.append("response body content length: " + proceed.body().contentLength() + "\n");
            } else {
                byte[] bytes = proceed.body().bytes();
                sb2.append(new java.lang.String(bytes, proceed.body().charset()) + "\n");
                newBuilder2.body(com.getui.gtc.base.http.ResponseBody.create(proceed.body().contentType(), bytes));
            }
        }
        this.logger.d(sb2.toString());
        return newBuilder2.build();
    }
}
