package com.getui.gs.e;

/* loaded from: classes22.dex */
public final class e implements com.getui.gtc.base.http.Interceptor {
    private java.lang.String a;
    private javax.crypto.SecretKey b;
    private java.lang.String c;

    public e(java.lang.String str, java.lang.String str2) {
        this.a = str;
        try {
            java.security.PublicKey parsePublicKey = com.getui.gtc.base.crypt.CryptTools.parsePublicKey(com.alipay.sdk.m.n.d.a, str2);
            javax.crypto.SecretKey generateKey = com.getui.gtc.base.crypt.CryptTools.generateKey("AES", 128);
            this.b = generateKey;
            this.c = android.util.Base64.encodeToString(com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", parsePublicKey, generateKey.getEncoded()), 2);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
        com.getui.gtc.base.http.Request request = chain.request();
        com.getui.gtc.base.http.Request.Builder newBuilder = request.newBuilder();
        com.getui.gtc.base.http.RequestBody body = request.body();
        if (body == null) {
            throw new java.lang.RuntimeException("PtRASCryptoInterceptor Error: request body is null");
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        body.writeTo(byteArrayOutputStream);
        com.getui.gtc.base.http.Util.closeQuietly(byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        java.lang.String str = new java.lang.String(byteArray, body.contentType().charset());
        try {
            boolean startsWith = request.url().toString().toLowerCase().startsWith("https");
            newBuilder.addHeader("X-TP", startsWith ? "4" : "3").addHeader("X-KD", this.a).addHeader("X-V", "1.0.1.0").addHeader("X-NT", com.getui.gs.h.a.a.f()).addHeader("X-SV", com.getui.gs.a.d.i());
            if (!startsWith) {
                newBuilder.addHeader("X-TL", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            }
            newBuilder.addHeader("X-AK", this.c);
            java.lang.String encodeToString = android.util.Base64.encodeToString(com.getui.gtc.base.crypt.CryptTools.digest("SHA256", (this.a + android.util.Base64.encodeToString(this.b.getEncoded(), 2) + str).getBytes()), 2);
            newBuilder.addHeader("X-SG", encodeToString);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(com.getui.gtc.base.crypt.CryptTools.digest("md5", encodeToString.getBytes()));
            newBuilder.body(com.getui.gtc.base.http.RequestBody.create(body.contentType(), com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CFB/NoPadding", this.b, ivParameterSpec, byteArray)));
            com.getui.gtc.base.http.Request build = newBuilder.build();
            com.getui.gs.h.b.a.a.a.d(new java.util.HashMap(build.headers()).toString());
            com.getui.gtc.base.http.Response proceed = chain.proceed(build);
            com.getui.gtc.base.http.Response.Builder request2 = proceed.newBuilder().request(request);
            request2.body(com.getui.gtc.base.http.ResponseBody.create(proceed.body().contentType(), com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CFB/NoPadding", this.b, ivParameterSpec, proceed.body().bytes())));
            return request2.build();
        } catch (java.security.GeneralSecurityException e) {
            throw new java.lang.RuntimeException("PtRASCryptoInterceptor Error", e);
        }
    }
}
