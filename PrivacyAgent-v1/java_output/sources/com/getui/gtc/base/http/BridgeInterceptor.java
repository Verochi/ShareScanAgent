package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class BridgeInterceptor implements com.getui.gtc.base.http.Interceptor {
    @Override // com.getui.gtc.base.http.Interceptor
    public com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
        boolean z;
        com.getui.gtc.base.http.Request request = chain.request();
        com.getui.gtc.base.http.Request.Builder builder = new com.getui.gtc.base.http.Request.Builder(request);
        android.net.Network network = request.network();
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) (network != null ? network.openConnection(request.url()) : request.url().openConnection());
        com.getui.gtc.base.http.RequestBody body = request.body();
        if (body != null) {
            com.getui.gtc.base.http.MediaType contentType = body.contentType();
            if (contentType != null) {
                builder.addHeader("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                builder.addHeader("Content-Length", java.lang.Long.toString(contentLength)).removeHeader("Transfer-Encoding");
            } else {
                builder.addHeader("Transfer-Encoding", com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED).removeHeader("Content-Length");
            }
        }
        if (request.header("Host") == null) {
            builder.addHeader("Host", request.url().getHost());
        }
        if (request.header(com.google.common.net.HttpHeaders.CONNECTION) == null) {
            builder.addHeader(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
        }
        if (request.header(com.google.common.net.HttpHeaders.ACCEPT_ENCODING) == null && request.header("Range") == null) {
            builder.addHeader(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        } else {
            z = false;
        }
        com.getui.gtc.base.http.Response proceed = ((com.getui.gtc.base.http.RealInterceptorChain) chain).proceed(builder.build(), httpURLConnection);
        com.getui.gtc.base.http.Response.Builder request2 = new com.getui.gtc.base.http.Response.Builder(proceed).request(request);
        if (z && "gzip".equalsIgnoreCase(proceed.header("Content-Encoding")) && proceed.body() != null) {
            request2.body(com.getui.gtc.base.http.ResponseBody.create(proceed.body().contentType(), -1L, new java.util.zip.GZIPInputStream(proceed.body().byteStream()))).removeHeader("Content-Encoding").removeHeader("Content-Length");
        }
        return request2.build();
    }
}
