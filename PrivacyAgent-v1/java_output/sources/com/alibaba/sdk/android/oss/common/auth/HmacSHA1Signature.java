package com.alibaba.sdk.android.oss.common.auth;

/* loaded from: classes.dex */
public class HmacSHA1Signature {
    private static final java.lang.String ALGORITHM = "HmacSHA1";
    private static final java.lang.String DEFAULT_ENCODING = "UTF-8";
    private static final java.lang.Object LOCK = new java.lang.Object();
    private static final java.lang.String VERSION = "1";
    private static javax.crypto.Mac macInstance;

    private byte[] sign(byte[] bArr, byte[] bArr2) {
        javax.crypto.Mac mac;
        try {
            if (macInstance == null) {
                synchronized (LOCK) {
                    if (macInstance == null) {
                        macInstance = javax.crypto.Mac.getInstance(getAlgorithm());
                    }
                }
            }
            try {
                mac = (javax.crypto.Mac) macInstance.clone();
            } catch (java.lang.CloneNotSupportedException unused) {
                mac = javax.crypto.Mac.getInstance(getAlgorithm());
            }
            mac.init(new javax.crypto.spec.SecretKeySpec(bArr, getAlgorithm()));
            return mac.doFinal(bArr2);
        } catch (java.security.InvalidKeyException unused2) {
            throw new java.lang.RuntimeException("key must not be null");
        } catch (java.security.NoSuchAlgorithmException unused3) {
            throw new java.lang.RuntimeException("Unsupported algorithm: HmacSHA1");
        }
    }

    public java.lang.String computeSignature(java.lang.String str, java.lang.String str2) {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(getAlgorithm(), false);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(getVersion(), false);
        try {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("sign start");
            byte[] sign = sign(str.getBytes("UTF-8"), str2.getBytes("UTF-8"));
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("base64 start");
            return com.alibaba.sdk.android.oss.common.utils.BinaryUtil.toBase64String(sign);
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new java.lang.RuntimeException("Unsupported algorithm: UTF-8");
        }
    }

    public java.lang.String getAlgorithm() {
        return ALGORITHM;
    }

    public java.lang.String getVersion() {
        return "1";
    }
}
