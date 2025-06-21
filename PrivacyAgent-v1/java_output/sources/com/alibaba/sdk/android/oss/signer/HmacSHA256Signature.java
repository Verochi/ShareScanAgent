package com.alibaba.sdk.android.oss.signer;

/* loaded from: classes.dex */
public class HmacSHA256Signature extends com.alibaba.sdk.android.oss.signer.ServiceSignature {
    private static final java.lang.String ALGORITHM = "HmacSHA256";
    private static final java.lang.String DEFAULT_ENCODING = "UTF-8";
    private static final java.lang.Object LOCK = new java.lang.Object();
    private static final java.lang.String VERSION = "1";
    private static javax.crypto.Mac macInstance;

    static {
        try {
            macInstance = javax.crypto.Mac.getInstance(ALGORITHM);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.alibaba.sdk.android.oss.signer.ServiceSignature
    public byte[] computeHash(byte[] bArr, byte[] bArr2) {
        return sign(bArr, bArr2, macInstance, LOCK, ALGORITHM);
    }

    @Override // com.alibaba.sdk.android.oss.signer.ServiceSignature
    public java.lang.String computeSignature(java.lang.String str, java.lang.String str2) {
        try {
            return com.alibaba.sdk.android.oss.common.utils.BinaryUtil.toBase64String(sign(str.getBytes("UTF-8"), str2.getBytes("UTF-8"), macInstance, LOCK, ALGORITHM));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("Unsupported algorithm: UTF-8", e);
        }
    }

    @Override // com.alibaba.sdk.android.oss.signer.ServiceSignature
    public java.lang.String getAlgorithm() {
        return ALGORITHM;
    }

    @Override // com.alibaba.sdk.android.oss.signer.ServiceSignature
    public java.lang.String getVersion() {
        return "1";
    }
}
