package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class e extends org.apache.http.impl.client.DefaultRedirectHandler {
    public int a;
    public final /* synthetic */ com.alipay.android.phone.mrpc.core.d b;

    public e(com.alipay.android.phone.mrpc.core.d dVar) {
        this.b = dVar;
    }

    @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
    public final boolean isRedirectRequested(org.apache.http.HttpResponse httpResponse, org.apache.http.protocol.HttpContext httpContext) {
        int statusCode;
        this.a++;
        boolean isRedirectRequested = super.isRedirectRequested(httpResponse, httpContext);
        if (isRedirectRequested || this.a >= 5 || !((statusCode = httpResponse.getStatusLine().getStatusCode()) == 301 || statusCode == 302)) {
            return isRedirectRequested;
        }
        return true;
    }
}
