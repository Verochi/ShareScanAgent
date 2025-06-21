package com.aliyun.svideo.common.okhttp.interceptor;

/* loaded from: classes.dex */
public class LoggingIntcepetor implements okhttp3.Interceptor {
    private final java.lang.String TAG = getClass().getSimpleName();

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Request request = chain.request();
        long nanoTime = java.lang.System.nanoTime();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Sending request: ");
        sb.append(request.url());
        sb.append("\n");
        sb.append(request.headers());
        okhttp3.Response proceed = chain.proceed(request);
        long nanoTime2 = java.lang.System.nanoTime();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("Received response for ");
        sb2.append(proceed.request().url());
        sb2.append(" in ");
        sb2.append((nanoTime2 - nanoTime) / 1000000.0d);
        sb2.append("ms\n");
        sb2.append(proceed.headers());
        return proceed;
    }
}
