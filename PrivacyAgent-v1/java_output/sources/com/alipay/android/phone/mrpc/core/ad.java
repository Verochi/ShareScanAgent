package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public class ad implements org.apache.http.client.HttpRequestRetryHandler {
    public static final java.lang.String a = com.alipay.android.phone.mrpc.core.ad.class.getSimpleName();

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(java.io.IOException iOException, int i, org.apache.http.protocol.HttpContext httpContext) {
        if (i >= 3) {
            return false;
        }
        if (iOException instanceof org.apache.http.NoHttpResponseException) {
            return true;
        }
        return ((iOException instanceof java.net.SocketException) || (iOException instanceof javax.net.ssl.SSLException)) && iOException.getMessage() != null && iOException.getMessage().contains("Broken pipe");
    }
}
