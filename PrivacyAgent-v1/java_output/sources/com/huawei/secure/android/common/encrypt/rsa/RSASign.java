package com.huawei.secure.android.common.encrypt.rsa;

/* loaded from: classes22.dex */
public abstract class RSASign {
    public static final java.lang.String a = "RSASign";

    public static java.lang.String a(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign content or key is null");
            return "";
        }
        java.security.PrivateKey privateKey = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.getPrivateKey(str2);
        return z ? newSign(str, privateKey) : sign(str, privateKey);
    }

    public static java.lang.String b(java.lang.String str, java.security.PrivateKey privateKey, boolean z) {
        try {
            return android.util.Base64.encodeToString(sign(str.getBytes("UTF-8"), privateKey, z), 0);
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    public static boolean c(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "content or public key or sign value is null");
            return false;
        }
        java.security.interfaces.RSAPublicKey publicKey = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.getPublicKey(str3);
        return z ? newVerifySign(str, str2, publicKey) : verifySign(str, str2, publicKey);
    }

    public static boolean d(java.lang.String str, java.lang.String str2, java.security.PublicKey publicKey, boolean z) {
        try {
            return verifySign(str.getBytes("UTF-8"), android.util.Base64.decode(str2, 0), publicKey, z);
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "base64 decode Exception : " + e2.getMessage());
            return false;
        }
    }

    public static boolean isBuildVersionHigherThan23() {
        return android.os.Build.VERSION.SDK_INT > 23;
    }

    public static java.lang.String newSign(java.lang.String str, java.lang.String str2) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, true);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b(a, "sdk version is too low");
        return "";
    }

    public static java.lang.String newSign(java.lang.String str, java.security.PrivateKey privateKey) {
        if (isBuildVersionHigherThan23()) {
            return b(str, privateKey, true);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b(a, "sdk version is too low");
        return "";
    }

    public static boolean newVerifySign(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (isBuildVersionHigherThan23()) {
            return c(str, str2, str3, true);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b(a, "sdk version is too low");
        return false;
    }

    public static boolean newVerifySign(java.lang.String str, java.lang.String str2, java.security.PublicKey publicKey) {
        if (isBuildVersionHigherThan23()) {
            return d(str, str2, publicKey, true);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b(a, "sdk version is too low");
        return false;
    }

    @java.lang.Deprecated
    public static java.lang.String sign(java.lang.String str, java.lang.String str2) {
        return a(str, str2, false);
    }

    @java.lang.Deprecated
    public static java.lang.String sign(java.lang.String str, java.security.PrivateKey privateKey) {
        return b(str, privateKey, false);
    }

    public static byte[] sign(java.nio.ByteBuffer byteBuffer, java.security.PrivateKey privateKey, boolean z) {
        java.security.Signature signature;
        byte[] bArr = new byte[0];
        if (byteBuffer == null || privateKey == null || !com.huawei.secure.android.common.encrypt.rsa.RSAEncrypt.isPrivateKeyLengthRight((java.security.interfaces.RSAPrivateKey) privateKey)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "content or privateKey is null , or length is too short");
            return bArr;
        }
        try {
            if (z) {
                signature = java.security.Signature.getInstance("SHA256WithRSA/PSS");
                signature.setParameter(new java.security.spec.PSSParameterSpec("SHA-256", "MGF1", java.security.spec.MGF1ParameterSpec.SHA256, 32, 1));
            } else {
                signature = java.security.Signature.getInstance("SHA256WithRSA");
            }
            signature.initSign(privateKey);
            signature.update(byteBuffer);
            bArr = signature.sign();
            com.huawei.secure.android.common.encrypt.utils.b.c(a, "result is : " + java.util.Arrays.toString(bArr));
            return bArr;
        } catch (java.security.InvalidAlgorithmParameterException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign InvalidAlgorithmParameterException: " + e.getMessage());
            return bArr;
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign InvalidKeyException: " + e2.getMessage());
            return bArr;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign NoSuchAlgorithmException: " + e3.getMessage());
            return bArr;
        } catch (java.security.SignatureException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign SignatureException: " + e4.getMessage());
            return bArr;
        } catch (java.lang.Exception e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign Exception: " + e5.getMessage());
            return bArr;
        }
    }

    public static byte[] sign(byte[] bArr, java.security.PrivateKey privateKey, boolean z) {
        java.security.Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !com.huawei.secure.android.common.encrypt.rsa.RSAEncrypt.isPrivateKeyLengthRight((java.security.interfaces.RSAPrivateKey) privateKey)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        try {
            if (z) {
                signature = java.security.Signature.getInstance("SHA256WithRSA/PSS");
                signature.setParameter(new java.security.spec.PSSParameterSpec("SHA-256", "MGF1", java.security.spec.MGF1ParameterSpec.SHA256, 32, 1));
            } else {
                signature = java.security.Signature.getInstance("SHA256WithRSA");
            }
            signature.initSign(privateKey);
            signature.update(bArr);
            return signature.sign();
        } catch (java.security.InvalidAlgorithmParameterException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign InvalidAlgorithmParameterException: " + e.getMessage());
            return bArr2;
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign InvalidKeyException: " + e2.getMessage());
            return bArr2;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign NoSuchAlgorithmException: " + e3.getMessage());
            return bArr2;
        } catch (java.security.SignatureException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign SignatureException: " + e4.getMessage());
            return bArr2;
        } catch (java.lang.Exception e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sign Exception: " + e5.getMessage());
            return bArr2;
        }
    }

    @java.lang.Deprecated
    public static boolean verifySign(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return c(str, str2, str3, false);
    }

    @java.lang.Deprecated
    public static boolean verifySign(java.lang.String str, java.lang.String str2, java.security.PublicKey publicKey) {
        return d(str, str2, publicKey, false);
    }

    public static boolean verifySign(java.nio.ByteBuffer byteBuffer, byte[] bArr, java.security.PublicKey publicKey, boolean z) {
        java.security.Signature signature;
        if (byteBuffer == null || publicKey == null || bArr == null || !com.huawei.secure.android.common.encrypt.rsa.RSAEncrypt.isPublicKeyLengthRight((java.security.interfaces.RSAPublicKey) publicKey)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "content or publicKey is null , or length is too short");
            return false;
        }
        try {
            if (z) {
                signature = java.security.Signature.getInstance("SHA256WithRSA/PSS");
                signature.setParameter(new java.security.spec.PSSParameterSpec("SHA-256", "MGF1", java.security.spec.MGF1ParameterSpec.SHA256, 32, 1));
            } else {
                signature = java.security.Signature.getInstance("SHA256WithRSA");
            }
            signature.initVerify(publicKey);
            signature.update(byteBuffer);
            return signature.verify(bArr);
        } catch (java.security.GeneralSecurityException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "check sign exception: " + e.getMessage());
            return false;
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "exception : " + e2.getMessage());
            return false;
        }
    }

    public static boolean verifySign(byte[] bArr, byte[] bArr2, java.security.PublicKey publicKey, boolean z) {
        java.security.Signature signature;
        if (bArr == null || publicKey == null || bArr2 == null || !com.huawei.secure.android.common.encrypt.rsa.RSAEncrypt.isPublicKeyLengthRight((java.security.interfaces.RSAPublicKey) publicKey)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "content or publicKey is null , or length is too short");
            return false;
        }
        try {
            if (z) {
                signature = java.security.Signature.getInstance("SHA256WithRSA/PSS");
                signature.setParameter(new java.security.spec.PSSParameterSpec("SHA-256", "MGF1", java.security.spec.MGF1ParameterSpec.SHA256, 32, 1));
            } else {
                signature = java.security.Signature.getInstance("SHA256WithRSA");
            }
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (java.security.GeneralSecurityException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "check sign exception: " + e.getMessage());
            return false;
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "exception : " + e2.getMessage());
            return false;
        }
    }
}
