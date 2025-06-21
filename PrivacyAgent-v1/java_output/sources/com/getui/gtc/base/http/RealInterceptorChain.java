package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class RealInterceptorChain implements com.getui.gtc.base.http.Interceptor.Chain {
    private final java.net.HttpURLConnection connection;
    private final int index;
    private final java.util.List<com.getui.gtc.base.http.Interceptor> interceptors;
    private final com.getui.gtc.base.http.Request request;

    public RealInterceptorChain(java.util.List<com.getui.gtc.base.http.Interceptor> list, java.net.HttpURLConnection httpURLConnection, int i, com.getui.gtc.base.http.Request request) {
        this.interceptors = list;
        this.connection = httpURLConnection;
        this.index = i;
        this.request = request;
    }

    @Override // com.getui.gtc.base.http.Interceptor.Chain
    public java.net.HttpURLConnection connection() {
        return this.connection;
    }

    @Override // com.getui.gtc.base.http.Interceptor.Chain
    public com.getui.gtc.base.http.Response proceed(com.getui.gtc.base.http.Request request) throws java.io.IOException {
        return proceed(request, this.connection);
    }

    public com.getui.gtc.base.http.Response proceed(com.getui.gtc.base.http.Request request, java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        if (this.index >= this.interceptors.size()) {
            throw new java.lang.AssertionError();
        }
        com.getui.gtc.base.http.RealInterceptorChain realInterceptorChain = new com.getui.gtc.base.http.RealInterceptorChain(this.interceptors, httpURLConnection, this.index + 1, request);
        com.getui.gtc.base.http.Interceptor interceptor = this.interceptors.get(this.index);
        com.getui.gtc.base.http.Response intercept = interceptor.intercept(realInterceptorChain);
        if (intercept == null) {
            throw new java.lang.NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (intercept.body() != null) {
            return intercept;
        }
        throw new java.lang.IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }

    @Override // com.getui.gtc.base.http.Interceptor.Chain
    public com.getui.gtc.base.http.Request request() {
        return this.request;
    }
}
