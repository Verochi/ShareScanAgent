package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class d extends org.apache.http.impl.client.DefaultHttpClient {
    public final /* synthetic */ com.alipay.android.phone.mrpc.core.b a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.alipay.android.phone.mrpc.core.b bVar, org.apache.http.conn.ClientConnectionManager clientConnectionManager, org.apache.http.params.HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
        this.a = bVar;
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public final org.apache.http.conn.ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new com.alipay.android.phone.mrpc.core.f(this);
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public final org.apache.http.protocol.HttpContext createHttpContext() {
        org.apache.http.protocol.BasicHttpContext basicHttpContext = new org.apache.http.protocol.BasicHttpContext();
        basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
        basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return basicHttpContext;
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public final org.apache.http.protocol.BasicHttpProcessor createHttpProcessor() {
        org.apache.http.HttpRequestInterceptor httpRequestInterceptor;
        org.apache.http.protocol.BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
        httpRequestInterceptor = com.alipay.android.phone.mrpc.core.b.c;
        createHttpProcessor.addRequestInterceptor(httpRequestInterceptor);
        createHttpProcessor.addRequestInterceptor(new com.alipay.android.phone.mrpc.core.b.a(this.a, (byte) 0));
        return createHttpProcessor;
    }

    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public final org.apache.http.client.RedirectHandler createRedirectHandler() {
        return new com.alipay.android.phone.mrpc.core.e(this);
    }
}
