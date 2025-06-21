package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class CallServerInterceptor implements com.getui.gtc.base.http.Interceptor {
    @Override // com.getui.gtc.base.http.Interceptor
    public com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
        com.getui.gtc.base.http.Request request = chain.request();
        java.net.HttpURLConnection connection = chain.connection();
        if (connection.getDoOutput() && request.body() != null) {
            java.io.OutputStream outputStream = connection.getOutputStream();
            request.body().writeTo(outputStream);
            com.getui.gtc.base.http.Util.closeQuietly(outputStream);
        }
        int responseCode = connection.getResponseCode();
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = connection.getHeaderFields();
        com.getui.gtc.base.http.MediaType parse = com.getui.gtc.base.http.MediaType.parse("text/json; charset=utf-8");
        if (connection.getContentType() != null) {
            parse = com.getui.gtc.base.http.MediaType.parse(connection.getContentType());
        }
        return new com.getui.gtc.base.http.Response.Builder().code(responseCode).headers(headerFields).message(connection.getResponseMessage()).body(com.getui.gtc.base.http.ResponseBody.create(parse, connection.getContentLength(), responseCode == 200 ? connection.getInputStream() : connection.getErrorStream())).request(request).build();
    }
}
