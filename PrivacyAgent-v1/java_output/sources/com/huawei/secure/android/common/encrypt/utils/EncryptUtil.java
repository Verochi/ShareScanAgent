package com.huawei.secure.android.common.encrypt.utils;

/* loaded from: classes22.dex */
public class EncryptUtil {
    public static boolean a = false;
    public static boolean b = true;

    /* JADX WARN: Removed duplicated region for block: B:19:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.security.SecureRandom a() {
        java.security.SecureRandom secureRandom;
        com.huawei.secure.android.common.encrypt.utils.b.a(com.huawei.secure.android.common.util.EncryptUtil.a, "generateSecureRandomNew ");
        try {
        } catch (java.security.NoSuchAlgorithmException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            secureRandom = java.security.SecureRandom.getInstanceStrong();
            if (secureRandom == null) {
                try {
                    secureRandom = java.security.SecureRandom.getInstance("SHA1PRNG");
                } catch (java.security.NoSuchAlgorithmException unused2) {
                    com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "NoSuchAlgorithmException");
                    return secureRandom;
                } catch (java.lang.Throwable th) {
                    if (b) {
                        com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
                        b = false;
                    }
                    return secureRandom;
                }
            }
            org.bouncycastle.crypto.engines.AESEngine aESEngine = new org.bouncycastle.crypto.engines.AESEngine();
            byte[] bArr = new byte[32];
            secureRandom.nextBytes(bArr);
            return new org.bouncycastle.crypto.prng.SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(384).buildCTR(aESEngine, 256, bArr, false);
        }
        secureRandom = null;
        if (secureRandom == null) {
        }
        org.bouncycastle.crypto.engines.AESEngine aESEngine2 = new org.bouncycastle.crypto.engines.AESEngine();
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        return new org.bouncycastle.crypto.prng.SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(384).buildCTR(aESEngine2, 256, bArr2, false);
    }

    public static byte[] b(int i) {
        java.security.SecureRandom a2 = a();
        if (a2 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        a2.nextBytes(bArr);
        return bArr;
    }

    public static java.security.SecureRandom genSecureRandom() {
        if (a) {
            return a();
        }
        try {
            return android.os.Build.VERSION.SDK_INT >= 26 ? java.security.SecureRandom.getInstanceStrong() : java.security.SecureRandom.getInstance("SHA1PRNG");
        } catch (java.security.NoSuchAlgorithmException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "genSecureRandom: NoSuchAlgorithmException");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] generateSecureRandom(int i) {
        java.security.SecureRandom secureRandom;
        if (a) {
            return b(i);
        }
        byte[] bArr = new byte[i];
        try {
        } catch (java.security.NoSuchAlgorithmException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            secureRandom = java.security.SecureRandom.getInstanceStrong();
            if (secureRandom == null) {
                try {
                    secureRandom = java.security.SecureRandom.getInstance("SHA1PRNG");
                } catch (java.security.NoSuchAlgorithmException unused2) {
                    com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                    return new byte[0];
                } catch (java.lang.Exception e) {
                    com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "getSecureRandomBytes getInstance: exception : " + e.getMessage());
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

    public static java.lang.String generateSecureRandomStr(int i) {
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    public static java.security.PrivateKey getPrivateKey(java.lang.String str) {
        try {
            try {
                return java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(android.util.Base64.decode(str, 0)));
            } catch (java.security.GeneralSecurityException e) {
                com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "base64 decode IllegalArgumentException");
            return null;
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static java.security.interfaces.RSAPublicKey getPublicKey(java.lang.String str) {
        try {
            try {
                return (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str, 0)));
            } catch (java.security.GeneralSecurityException e) {
                com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "base64 decode IllegalArgumentException");
            return null;
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(com.huawei.secure.android.common.util.EncryptUtil.a, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return a;
    }

    public static void setBouncycastleFlag(boolean z) {
        com.huawei.secure.android.common.encrypt.utils.b.c(com.huawei.secure.android.common.util.EncryptUtil.a, "setBouncycastleFlag: " + z);
        a = z;
    }
}
