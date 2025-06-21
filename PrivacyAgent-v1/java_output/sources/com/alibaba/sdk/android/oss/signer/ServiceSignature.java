package com.alibaba.sdk.android.oss.signer;

/* loaded from: classes.dex */
public abstract class ServiceSignature {
    public static com.alibaba.sdk.android.oss.signer.ServiceSignature create() {
        return new com.alibaba.sdk.android.oss.signer.HmacSHA1Signature();
    }

    public static com.alibaba.sdk.android.oss.signer.ServiceSignature create(java.lang.String str) {
        if ("HmacSHA256".equals(str)) {
            return new com.alibaba.sdk.android.oss.signer.HmacSHA256Signature();
        }
        if ("HmacSHA1".equals(str)) {
            return new com.alibaba.sdk.android.oss.signer.HmacSHA1Signature();
        }
        throw new java.lang.RuntimeException("Unsupported algorithm: " + str);
    }

    public abstract byte[] computeHash(byte[] bArr, byte[] bArr2);

    public abstract java.lang.String computeSignature(java.lang.String str, java.lang.String str2);

    public abstract java.lang.String getAlgorithm();

    public abstract java.lang.String getVersion();

    public byte[] sign(byte[] bArr, byte[] bArr2, javax.crypto.Mac mac, java.lang.Object obj, java.lang.String str) {
        javax.crypto.Mac mac2;
        if (mac == null) {
            try {
                synchronized (obj) {
                    if (mac == null) {
                        mac = javax.crypto.Mac.getInstance(str);
                    }
                }
            } catch (java.security.InvalidKeyException e) {
                throw new java.lang.RuntimeException("Invalid key: " + bArr, e);
            } catch (java.security.NoSuchAlgorithmException e2) {
                throw new java.lang.RuntimeException("Unsupported algorithm: " + str, e2);
            }
        }
        try {
            mac2 = (javax.crypto.Mac) mac.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            mac2 = javax.crypto.Mac.getInstance(str);
        }
        mac2.init(new javax.crypto.spec.SecretKeySpec(bArr, str));
        return mac2.doFinal(bArr2);
    }
}
