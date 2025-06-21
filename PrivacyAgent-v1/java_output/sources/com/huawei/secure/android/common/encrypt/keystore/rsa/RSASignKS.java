package com.huawei.secure.android.common.encrypt.keystore.rsa;

/* loaded from: classes22.dex */
public abstract class RSASignKS {
    public static final java.lang.String a = "RSASignKS";

    public static synchronized java.security.KeyPair a(java.lang.String str, boolean z) {
        android.security.keystore.KeyGenParameterSpec.Builder digests;
        android.security.keystore.KeyGenParameterSpec.Builder signaturePaddings;
        android.security.keystore.KeyGenParameterSpec.Builder keySize;
        android.security.keystore.KeyGenParameterSpec build;
        android.security.keystore.KeyGenParameterSpec.Builder digests2;
        android.security.keystore.KeyGenParameterSpec.Builder signaturePaddings2;
        android.security.keystore.KeyGenParameterSpec.Builder keySize2;
        android.security.keystore.KeyGenParameterSpec build2;
        synchronized (com.huawei.secure.android.common.encrypt.keystore.rsa.RSASignKS.class) {
            java.security.KeyPair keyPair = null;
            if (b(str)) {
                com.huawei.secure.android.common.encrypt.utils.b.b(a, "Key pair exits");
                return null;
            }
            try {
                try {
                    java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.a, "AndroidKeyStore");
                    if (z) {
                        digests = new android.security.keystore.KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512");
                        signaturePaddings = digests.setSignaturePaddings("PSS");
                        keySize = signaturePaddings.setKeySize(3072);
                        build = keySize.build();
                        keyPairGenerator.initialize(build);
                    } else {
                        digests2 = new android.security.keystore.KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512");
                        signaturePaddings2 = digests2.setSignaturePaddings("PSS");
                        keySize2 = signaturePaddings2.setKeySize(2048);
                        build2 = keySize2.build();
                        keyPairGenerator.initialize(build2);
                    }
                    keyPair = keyPairGenerator.generateKeyPair();
                } catch (java.security.NoSuchAlgorithmException e) {
                    com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e.getMessage());
                }
            } catch (java.security.InvalidAlgorithmParameterException e2) {
                com.huawei.secure.android.common.encrypt.utils.b.b(a, "InvalidAlgorithmParameterException: " + e2.getMessage());
            } catch (java.security.NoSuchProviderException e3) {
                com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchProviderException: " + e3.getMessage());
            }
            return keyPair;
        }
    }

    public static boolean b(java.lang.String str) {
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (java.io.IOException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "IOException: " + e.getMessage());
            return false;
        } catch (java.security.KeyStoreException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "KeyStoreException: " + e2.getMessage());
            return false;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
            return false;
        } catch (java.security.UnrecoverableKeyException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "UnrecoverableKeyException: " + e4.getMessage());
            return false;
        } catch (java.security.cert.CertificateException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "CertificateException: " + e5.getMessage());
            return false;
        }
    }

    public static boolean c(java.lang.String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (android.text.TextUtils.isEmpty(str) || bArr == null || bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "alias or content or sign value is null");
            return false;
        }
        if (!isBuildVersionHigherThan22()) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sdk version is too low");
            return false;
        }
        java.security.KeyStore.Entry e = e(str, z);
        if (!(e instanceof java.security.KeyStore.PrivateKeyEntry)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Not an instance of a PrivateKeyEntry");
            return false;
        }
        try {
            java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA/PSS");
            signature.initVerify(((java.security.KeyStore.PrivateKeyEntry) e).getCertificate());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "InvalidKeyException: " + e2.getMessage());
            return false;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
            return false;
        } catch (java.security.SignatureException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "SignatureException: " + e4.getMessage());
            return false;
        } catch (java.lang.Exception e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e5.getMessage());
            return false;
        }
    }

    public static byte[] d(java.lang.String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (android.text.TextUtils.isEmpty(str) || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "alias or content is null");
            return bArr2;
        }
        if (!isBuildVersionHigherThan22()) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sdk version is too low");
            return bArr2;
        }
        java.security.KeyStore.Entry e = e(str, z);
        if (!(e instanceof java.security.KeyStore.PrivateKeyEntry)) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Not an instance of a PrivateKeyEntry");
            return bArr2;
        }
        try {
            java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA/PSS");
            signature.initSign(((java.security.KeyStore.PrivateKeyEntry) e).getPrivateKey());
            signature.update(bArr);
            return signature.sign();
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "InvalidKeyException: " + e2.getMessage());
            return bArr2;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
            return bArr2;
        } catch (java.security.SignatureException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "SignatureException: " + e4.getMessage());
            return bArr2;
        } catch (java.lang.Exception e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e5.getMessage());
            return bArr2;
        }
    }

    public static java.security.KeyStore.Entry e(java.lang.String str, boolean z) {
        if (!b(str)) {
            a(str, z);
        }
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getEntry(str, null);
        } catch (java.io.IOException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "IOException: " + e.getMessage());
            return null;
        } catch (java.security.KeyStoreException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "KeyStoreException: " + e2.getMessage());
            return null;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
            return null;
        } catch (java.security.UnrecoverableEntryException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "UnrecoverableEntryException: " + e4.getMessage());
            return null;
        } catch (java.security.cert.CertificateException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "CertificateException: " + e5.getMessage());
            return null;
        }
    }

    public static boolean isBuildVersionHigherThan22() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

    @java.lang.Deprecated
    public static java.lang.String sign(java.lang.String str, java.lang.String str2) {
        try {
            return android.util.Base64.encodeToString(sign(str, str2.getBytes("UTF-8")), 0);
        } catch (java.io.UnsupportedEncodingException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("sign UnsupportedEncodingException : ");
            sb.append(e.getMessage());
            return "";
        }
    }

    @java.lang.Deprecated
    public static byte[] sign(java.lang.String str, byte[] bArr) {
        return d(str, bArr, false);
    }

    public static java.lang.String signNew(java.lang.String str, java.lang.String str2) {
        try {
            return android.util.Base64.encodeToString(signNew(str, str2.getBytes("UTF-8")), 0);
        } catch (java.io.UnsupportedEncodingException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("sign UnsupportedEncodingException : ");
            sb.append(e.getMessage());
            return "";
        }
    }

    public static byte[] signNew(java.lang.String str, byte[] bArr) {
        return d(str, bArr, true);
    }

    @java.lang.Deprecated
    public static boolean verifySign(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return verifySign(str, str2.getBytes("UTF-8"), android.util.Base64.decode(str3, 0));
        } catch (java.io.UnsupportedEncodingException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("verifySign UnsupportedEncodingException: ");
            sb.append(e.getMessage());
            return false;
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "base64 decode Exception" + e2.getMessage());
            return false;
        }
    }

    @java.lang.Deprecated
    public static boolean verifySign(java.lang.String str, byte[] bArr, byte[] bArr2) {
        return c(str, bArr, bArr2, false);
    }

    public static boolean verifySignNew(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return verifySignNew(str, str2.getBytes("UTF-8"), android.util.Base64.decode(str3, 0));
        } catch (java.io.UnsupportedEncodingException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("verifySign UnsupportedEncodingException: ");
            sb.append(e.getMessage());
            return false;
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "base64 decode Exception" + e2.getMessage());
            return false;
        }
    }

    public static boolean verifySignNew(java.lang.String str, byte[] bArr, byte[] bArr2) {
        return c(str, bArr, bArr2, true);
    }
}
