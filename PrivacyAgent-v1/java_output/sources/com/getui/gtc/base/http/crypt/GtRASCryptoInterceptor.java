package com.getui.gtc.base.http.crypt;

/* loaded from: classes22.dex */
public class GtRASCryptoInterceptor implements com.getui.gtc.base.http.Interceptor {
    private final java.lang.String keyId;
    private final java.lang.String publicKeyStr;

    public GtRASCryptoInterceptor(java.lang.String str, java.lang.String str2) {
        this.keyId = str;
        this.publicKeyStr = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x01bb, code lost:
    
        throw new java.lang.SecurityException("GT_ERR header is " + r9.get(0));
     */
    @Override // com.getui.gtc.base.http.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
        com.getui.gtc.base.http.Request request = chain.request();
        com.getui.gtc.base.http.Request.Builder newBuilder = request.newBuilder();
        com.getui.gtc.base.http.RequestBody body = request.body();
        if (body == null) {
            throw new java.lang.RuntimeException("GtRASCryptoInterceptor Error: request body is null");
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
        body.writeTo(gZIPOutputStream);
        gZIPOutputStream.finish();
        com.getui.gtc.base.http.Util.closeQuietly(gZIPOutputStream);
        com.getui.gtc.base.http.Util.closeQuietly(byteArrayOutputStream);
        try {
            newBuilder.addHeader("GT_C_T", "1").addHeader("GT_C_K", this.keyId);
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            newBuilder.addHeader("GT_T", valueOf);
            byte[] bArr = new byte[16];
            new java.security.SecureRandom().nextBytes(bArr);
            java.security.PublicKey parsePublicKey = com.getui.gtc.base.crypt.CryptTools.parsePublicKey(com.alipay.sdk.m.n.d.a, this.publicKeyStr);
            javax.crypto.SecretKey generateKey = com.getui.gtc.base.crypt.CryptTools.generateKey("AES", 128);
            byte[] encrypt = com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", parsePublicKey, generateKey.getEncoded());
            byte[] bArr2 = new byte[encrypt.length + 16];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, 16);
            java.lang.System.arraycopy(encrypt, 0, bArr2, 16, encrypt.length);
            newBuilder.addHeader("GT_C_V", android.util.Base64.encodeToString(bArr2, 2));
            byte[] bytes = valueOf.getBytes();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] bArr3 = new byte[bytes.length + byteArray.length];
            java.lang.System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
            java.lang.System.arraycopy(byteArray, 0, bArr3, bytes.length, byteArray.length);
            java.lang.String encodeToString = android.util.Base64.encodeToString(com.getui.gtc.base.crypt.CryptTools.digest("SHA1", bArr3), 2);
            newBuilder.addHeader("GT_C_S", encodeToString);
            newBuilder.body(com.getui.gtc.base.http.RequestBody.create(body.contentType(), com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CFB/NoPadding", generateKey, new javax.crypto.spec.IvParameterSpec(com.getui.gtc.base.crypt.CryptTools.digest("MD5", encodeToString.getBytes())), byteArray)));
            com.getui.gtc.base.http.Response proceed = chain.proceed(newBuilder.build());
            if (proceed.code() != 200) {
                return proceed;
            }
            com.getui.gtc.base.http.Response.Builder request2 = proceed.newBuilder().request(request);
            java.util.List<java.lang.String> list = proceed.getHeaders().get("GT_ERR");
            if (list != null && list.size() > 0 && "0".equals(list.get(0))) {
                request2.removeHeader("GT_ERR");
                java.util.List<java.lang.String> list2 = proceed.getHeaders().get("GT_T");
                if (list2 == null || list2.size() <= 0) {
                    throw new java.lang.SecurityException("GT_T header not found");
                }
                byte[] bytes2 = list2.get(0).getBytes();
                javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(com.getui.gtc.base.crypt.CryptTools.digest("MD5", bytes2));
                request2.removeHeader("GT_T");
                java.util.List<java.lang.String> list3 = proceed.getHeaders().get("GT_C_S");
                if (list3 == null || list3.size() <= 0) {
                    throw new java.lang.SecurityException("GT_C_S header not found");
                }
                byte[] decode = android.util.Base64.decode(list3.get(0), 2);
                byte[] decrypt = com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CFB/NoPadding", generateKey, ivParameterSpec, proceed.body().bytes());
                byte[] bArr4 = new byte[decrypt.length + bytes2.length];
                java.lang.System.arraycopy(bytes2, 0, bArr4, 0, bytes2.length);
                java.lang.System.arraycopy(decrypt, 0, bArr4, bytes2.length, decrypt.length);
                if (!java.util.Arrays.equals(com.getui.gtc.base.crypt.CryptTools.digest("SHA1", bArr4), decode)) {
                    throw new java.lang.SecurityException("response body sign check failed");
                }
                request2.removeHeader("GT_C_S");
                request2.body(com.getui.gtc.base.http.ResponseBody.create(proceed.body().contentType(), decrypt));
                return request2.build();
            }
            throw new java.lang.SecurityException("GT_ERR header not found");
        } catch (java.security.GeneralSecurityException e) {
            throw new java.lang.RuntimeException("GtRASCryptoInterceptor Error", e);
        }
    }
}
