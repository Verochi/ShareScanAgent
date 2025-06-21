package com.getui.gs.e;

/* loaded from: classes22.dex */
public final class f implements com.getui.gtc.base.http.Interceptor {
    private static java.lang.String a() {
        try {
            return com.getui.gs.h.e.a(com.getui.gs.a.d.d(), com.getui.gs.a.d.e(), java.lang.System.currentTimeMillis());
        } catch (java.security.NoSuchAlgorithmException unused) {
            return com.getui.gs.a.d.d() + com.getui.gs.a.d.e() + java.lang.System.currentTimeMillis();
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = (byte) (bArr2[i] ^ bArr[i % bArr.length]);
        }
        return bArr2;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
        com.getui.gtc.base.http.Request request = chain.request();
        com.getui.gtc.base.http.Request.Builder newBuilder = request.newBuilder();
        com.getui.gtc.base.http.RequestBody body = request.body();
        if (body == null) {
            throw new java.lang.RuntimeException("SimpleCryptoInterceptor Error: request body is null");
        }
        newBuilder.addHeader("X-TP", request.url().toString().toLowerCase().startsWith("https") ? "5" : "3").addHeader("X-V", "2.0.0.0").addHeader("X-NT", com.getui.gs.h.a.a.f()).addHeader("X-SV", com.getui.gs.a.d.i());
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            body.writeTo(byteArrayOutputStream);
            com.getui.gtc.base.http.Util.closeQuietly(byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            java.lang.String a = a();
            byte[] bytes = a.getBytes(java.nio.charset.Charset.forName("UTF-8"));
            if (bytes.length >= 16) {
                byte[] bArr = new byte[16];
                java.lang.System.arraycopy(bytes, 0, bArr, 0, 8);
                java.lang.System.arraycopy(bytes, bytes.length - 8, bArr, 8, 8);
                bytes = bArr;
            }
            byte[] a2 = a(bytes, byteArray);
            newBuilder.addHeader("X-CK", a);
            newBuilder.body(com.getui.gtc.base.http.RequestBody.create(body.contentType(), a2));
            com.getui.gtc.base.http.Response proceed = chain.proceed(newBuilder.build());
            com.getui.gtc.base.http.Response.Builder request2 = proceed.newBuilder().request(request);
            request2.body(com.getui.gtc.base.http.ResponseBody.create(proceed.body().contentType(), a(bytes, proceed.body().bytes())));
            com.getui.gtc.base.http.Response build = request2.build();
            byteArrayOutputStream.close();
            return build;
        } finally {
        }
    }
}
