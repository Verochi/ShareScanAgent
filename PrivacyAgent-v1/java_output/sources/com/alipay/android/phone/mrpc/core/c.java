package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class c implements org.apache.http.HttpRequestInterceptor {
    @Override // org.apache.http.HttpRequestInterceptor
    public final void process(org.apache.http.HttpRequest httpRequest, org.apache.http.protocol.HttpContext httpContext) {
        if (android.os.Looper.myLooper() != null && android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.RuntimeException("This thread forbids HTTP requests");
        }
    }
}
