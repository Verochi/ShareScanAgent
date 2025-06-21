package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class j implements com.zx.a.I8b7.n0 {
    @Override // com.zx.a.I8b7.n0
    public com.zx.a.I8b7.t1 a(com.zx.a.I8b7.n0.a aVar) throws java.io.IOException {
        com.zx.a.I8b7.j1 j1Var = (com.zx.a.I8b7.j1) aVar;
        com.zx.a.I8b7.q1 q1Var = j1Var.c;
        java.net.HttpURLConnection httpURLConnection = j1Var.d;
        if (httpURLConnection.getDoOutput() && q1Var.d != null) {
            java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
            com.zx.a.I8b7.r1 r1Var = (com.zx.a.I8b7.r1) q1Var.d;
            outputStream.write(r1Var.c, r1Var.d, r1Var.b);
            com.zx.a.I8b7.c2.a(outputStream);
        }
        int responseCode = httpURLConnection.getResponseCode();
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
        com.zx.a.I8b7.x0 b = com.zx.a.I8b7.x0.b("text/json; charset=utf-8");
        if (httpURLConnection.getContentType() != null) {
            b = com.zx.a.I8b7.x0.b(httpURLConnection.getContentType());
        }
        java.lang.String responseMessage = httpURLConnection.getResponseMessage();
        com.zx.a.I8b7.t1.a aVar2 = new com.zx.a.I8b7.t1.a();
        aVar2.b = responseCode;
        aVar2.d = new java.util.HashMap(headerFields);
        aVar2.c = responseMessage;
        aVar2.e = com.zx.a.I8b7.u1.a(b, httpURLConnection.getContentLength(), responseCode == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
        aVar2.a = q1Var;
        return aVar2.a();
    }
}
