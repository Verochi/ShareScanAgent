package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class EncryptUtil {
    public static final java.lang.String a = "EncryptUtil";

    /* JADX WARN: Removed duplicated region for block: B:16:0x0017 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] generateSecureRandom(int i) {
        java.security.SecureRandom secureRandom;
        byte[] bArr = new byte[i];
        try {
        } catch (java.security.NoSuchAlgorithmException unused) {
            com.huawei.secure.android.common.util.LogsUtil.e(a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            secureRandom = java.security.SecureRandom.getInstanceStrong();
            if (secureRandom == null) {
                try {
                    secureRandom = java.security.SecureRandom.getInstance("SHA1PRNG");
                } catch (java.security.NoSuchAlgorithmException unused2) {
                    com.huawei.secure.android.common.util.LogsUtil.e(a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                    return new byte[0];
                } catch (java.lang.Exception e) {
                    com.huawei.secure.android.common.util.LogsUtil.e(a, "getSecureRandomBytes getInstance: exception : " + e.getMessage());
                    return new byte[0];
                }
            }
            secureRandom.nextBytes(bArr);
            return bArr;
        }
        secureRandom = null;
        if (secureRandom == null) {
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    @java.lang.Deprecated
    public static java.lang.String generateSecureRandomStr(int i) {
        return com.huawei.secure.android.common.util.HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    @java.lang.Deprecated
    public static java.security.PrivateKey getPrivateKey(java.lang.String str) {
        try {
            try {
                return java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(android.util.Base64.decode(str, 0)));
            } catch (java.security.GeneralSecurityException e) {
                com.huawei.secure.android.common.util.LogsUtil.e(a, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.huawei.secure.android.common.util.LogsUtil.e(a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (java.lang.Exception unused2) {
            com.huawei.secure.android.common.util.LogsUtil.e(a, "base64 decode Exception", true);
            return null;
        }
    }

    @java.lang.Deprecated
    public static java.security.interfaces.RSAPublicKey getPublicKey(java.lang.String str) {
        try {
            try {
                return (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str, 0)));
            } catch (java.security.GeneralSecurityException e) {
                com.huawei.secure.android.common.util.LogsUtil.e(a, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.huawei.secure.android.common.util.LogsUtil.e(a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (java.lang.Exception unused2) {
            com.huawei.secure.android.common.util.LogsUtil.e(a, "base64 decode Exception", true);
            return null;
        }
    }
}
