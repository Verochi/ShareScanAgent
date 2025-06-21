package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
class f implements com.huawei.agconnect.config.impl.g {
    public javax.crypto.SecretKey a;

    public f(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) throws java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.IllegalArgumentException {
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return;
        }
        this.a = com.huawei.agconnect.config.impl.i.a(com.huawei.agconnect.config.impl.Hex.decodeHexString(str), com.huawei.agconnect.config.impl.Hex.decodeHexString(str2), com.huawei.agconnect.config.impl.Hex.decodeHexString(str3), com.huawei.agconnect.config.impl.Hex.decodeHexString(str4), 5000);
    }

    @Override // com.huawei.agconnect.config.impl.g
    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        javax.crypto.SecretKey secretKey = this.a;
        if (secretKey == null) {
            return str;
        }
        try {
            return new java.lang.String(com.huawei.agconnect.config.impl.i.b(secretKey, com.huawei.agconnect.config.impl.Hex.decodeHexString(str)), "UTF-8");
        } catch (java.io.UnsupportedEncodingException | java.lang.IllegalArgumentException | java.security.GeneralSecurityException unused) {
            return str2;
        }
    }
}
