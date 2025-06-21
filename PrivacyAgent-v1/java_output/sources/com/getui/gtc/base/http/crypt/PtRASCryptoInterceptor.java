package com.getui.gtc.base.http.crypt;

/* loaded from: classes22.dex */
public class PtRASCryptoInterceptor implements com.getui.gtc.base.http.Interceptor {
    private javax.crypto.SecretKey aesKey;
    private java.lang.String encryptedAesKey;
    private java.lang.String keyId;
    private java.lang.String publicKeyStr;
    private java.security.PublicKey rsaPublicKey;

    public PtRASCryptoInterceptor(java.lang.String str, java.lang.String str2) {
        this.keyId = str;
        this.publicKeyStr = str2;
        try {
            this.rsaPublicKey = com.getui.gtc.base.crypt.CryptTools.parsePublicKey(com.alipay.sdk.m.n.d.a, str2);
            javax.crypto.SecretKey generateKey = com.getui.gtc.base.crypt.CryptTools.generateKey("AES", 128);
            this.aesKey = generateKey;
            this.encryptedAesKey = android.util.Base64.encodeToString(com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", this.rsaPublicKey, generateKey.getEncoded()), 2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
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
            newBuilder.addHeader("X-TP", startsWith ? "4" : "3").addHeader("X-KD", this.keyId).addHeader("X-V", "1.0.1.0");
            if (!startsWith) {
                newBuilder.addHeader("X-TL", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                javax.crypto.SecretKey generateKey = com.getui.gtc.base.crypt.CryptTools.generateKey("AES", 128);
                this.aesKey = generateKey;
                this.encryptedAesKey = android.util.Base64.encodeToString(com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", this.rsaPublicKey, generateKey.getEncoded()), 2);
            }
            newBuilder.addHeader("X-AK", this.encryptedAesKey);
            java.lang.String encodeToString = android.util.Base64.encodeToString(com.getui.gtc.base.crypt.CryptTools.digest("SHA256", (this.keyId + android.util.Base64.encodeToString(this.aesKey.getEncoded(), 2) + str).getBytes()), 2);
            newBuilder.addHeader("X-SG", encodeToString);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(com.getui.gtc.base.crypt.CryptTools.digest("md5", encodeToString.getBytes()));
            newBuilder.body(com.getui.gtc.base.http.RequestBody.create(body.contentType(), com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CFB/NoPadding", this.aesKey, ivParameterSpec, byteArray)));
            com.getui.gtc.base.http.Response proceed = chain.proceed(newBuilder.build());
            if (proceed.code() != 200) {
                return proceed;
            }
            com.getui.gtc.base.http.Response.Builder request2 = proceed.newBuilder().request(request);
            request2.body(com.getui.gtc.base.http.ResponseBody.create(proceed.body().contentType(), com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CFB/NoPadding", this.aesKey, ivParameterSpec, proceed.body().bytes())));
            return request2.build();
        } catch (java.security.GeneralSecurityException e) {
            throw new java.lang.RuntimeException("PtRASCryptoInterceptor Error", e);
        }
    }
}
