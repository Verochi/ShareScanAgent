package com.huawei.secure.android.common.encrypt.keystore.rsa;

/* loaded from: classes22.dex */
public abstract class RSAEncryptKS {
    public static final java.lang.String a = "RSAEncryptKS";

    public static synchronized java.security.KeyPair a(java.lang.String str, boolean z) {
        android.security.keystore.KeyGenParameterSpec.Builder digests;
        android.security.keystore.KeyGenParameterSpec.Builder encryptionPaddings;
        android.security.keystore.KeyGenParameterSpec.Builder keySize;
        android.security.keystore.KeyGenParameterSpec build;
        android.security.keystore.KeyGenParameterSpec.Builder digests2;
        android.security.keystore.KeyGenParameterSpec.Builder encryptionPaddings2;
        android.security.keystore.KeyGenParameterSpec.Builder keySize2;
        android.security.keystore.KeyGenParameterSpec build2;
        synchronized (com.huawei.secure.android.common.encrypt.keystore.rsa.RSAEncryptKS.class) {
            java.security.KeyPair keyPair = null;
            if (f(str)) {
                com.huawei.secure.android.common.encrypt.utils.b.b(a, "Key pair exits");
                return null;
            }
            com.huawei.secure.android.common.encrypt.utils.b.c(a, "generate key pair.");
            try {
                try {
                    try {
                        java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.a, "AndroidKeyStore");
                        if (z) {
                            digests = new android.security.keystore.KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512");
                            encryptionPaddings = digests.setEncryptionPaddings("OAEPPadding");
                            keySize = encryptionPaddings.setKeySize(3072);
                            build = keySize.build();
                            keyPairGenerator.initialize(build);
                        } else {
                            digests2 = new android.security.keystore.KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512");
                            encryptionPaddings2 = digests2.setEncryptionPaddings("OAEPPadding");
                            keySize2 = encryptionPaddings2.setKeySize(2048);
                            build2 = keySize2.build();
                            keyPairGenerator.initialize(build2);
                        }
                        keyPair = keyPairGenerator.generateKeyPair();
                    } catch (java.security.NoSuchAlgorithmException e) {
                        com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e.getMessage());
                    }
                } catch (java.security.InvalidAlgorithmParameterException e2) {
                    com.huawei.secure.android.common.encrypt.utils.b.b(a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                }
            } catch (java.security.NoSuchProviderException e3) {
                com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchProviderException: " + e3.getMessage());
            } catch (java.lang.Exception e4) {
                com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e4.getMessage());
            }
            return keyPair;
        }
    }

    public static java.security.PrivateKey b(java.lang.String str) {
        if (!f(str)) {
            return null;
        }
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return (java.security.PrivateKey) keyStore.getKey(str, null);
        } catch (java.io.IOException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "IOException: " + e.getMessage());
            return null;
        } catch (java.security.KeyStoreException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "KeyStoreException: " + e2.getMessage());
            return null;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
            return null;
        } catch (java.security.UnrecoverableKeyException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "UnrecoverableKeyException: " + e4.getMessage());
            return null;
        } catch (java.security.cert.CertificateException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "CertificateException: " + e5.getMessage());
            return null;
        } catch (java.lang.Exception e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e6.getMessage());
            return null;
        }
    }

    public static boolean c() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

    public static byte[] d(java.lang.String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (android.text.TextUtils.isEmpty(str) || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "alias or content is null");
            return bArr2;
        }
        if (!c()) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sdk version is too low");
            return bArr2;
        }
        java.security.PublicKey e = e(str, z);
        if (e == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Public key is null");
            return bArr2;
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, e, new javax.crypto.spec.OAEPParameterSpec("SHA-256", "MGF1", new java.security.spec.MGF1ParameterSpec("SHA-1"), javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (java.security.InvalidAlgorithmParameterException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "InvalidAlgorithmParameterException: " + e2.getMessage());
            return bArr2;
        } catch (java.security.InvalidKeyException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "InvalidKeyException: " + e3.getMessage());
            return bArr2;
        } catch (java.security.NoSuchAlgorithmException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e4.getMessage());
            return bArr2;
        } catch (javax.crypto.BadPaddingException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "BadPaddingException: " + e5.getMessage());
            return bArr2;
        } catch (javax.crypto.IllegalBlockSizeException e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "IllegalBlockSizeException: " + e6.getMessage());
            return bArr2;
        } catch (javax.crypto.NoSuchPaddingException e7) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchPaddingException: " + e7.getMessage());
            return bArr2;
        } catch (java.lang.Exception e8) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e8.getMessage());
            return bArr2;
        }
    }

    @java.lang.Deprecated
    public static java.lang.String decrpyt(java.lang.String str, java.lang.String str2) {
        try {
            return new java.lang.String(decrpyt(str, android.util.Base64.decode(str2, 0)), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e2.getMessage());
            return "";
        }
    }

    @java.lang.Deprecated
    public static byte[] decrpyt(java.lang.String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (android.text.TextUtils.isEmpty(str) || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "alias or encrypted content is null");
            return bArr2;
        }
        if (!c()) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "sdk version is too low");
            return bArr2;
        }
        java.security.PrivateKey b = b(str);
        if (b == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Private key is null");
            return bArr2;
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(2, b, new javax.crypto.spec.OAEPParameterSpec("SHA-256", "MGF1", new java.security.spec.MGF1ParameterSpec("SHA-1"), javax.crypto.spec.PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (java.security.InvalidAlgorithmParameterException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "InvalidAlgorithmParameterException: " + e.getMessage());
            return bArr2;
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "InvalidKeyException: " + e2.getMessage());
            return bArr2;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
            return bArr2;
        } catch (javax.crypto.BadPaddingException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "BadPaddingException: " + e4.getMessage());
            return bArr2;
        } catch (javax.crypto.IllegalBlockSizeException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "IllegalBlockSizeException: " + e5.getMessage());
            return bArr2;
        } catch (javax.crypto.NoSuchPaddingException e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchPaddingException: " + e6.getMessage());
            return bArr2;
        } catch (java.lang.Exception e7) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    public static java.lang.String decrpytNew(java.lang.String str, java.lang.String str2) {
        try {
            return new java.lang.String(decrpytNew(str, android.util.Base64.decode(str2, 0)), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e2.getMessage());
            return "";
        }
    }

    public static byte[] decrpytNew(java.lang.String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    public static java.security.PublicKey e(java.lang.String str, boolean z) {
        if (!f(str)) {
            a(str, z);
        }
        java.security.cert.Certificate g = g(str);
        if (g != null) {
            return g.getPublicKey();
        }
        return null;
    }

    @java.lang.Deprecated
    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return android.util.Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    @java.lang.Deprecated
    public static byte[] encrypt(java.lang.String str, byte[] bArr) {
        return d(str, bArr, false);
    }

    public static java.lang.String encryptNew(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return android.util.Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    public static byte[] encryptNew(java.lang.String str, byte[] bArr) {
        return d(str, bArr, true);
    }

    public static boolean f(java.lang.String str) {
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
        } catch (java.lang.Exception e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e6.getMessage());
            return false;
        }
    }

    public static java.security.cert.Certificate g(java.lang.String str) {
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getCertificate(str);
        } catch (java.io.IOException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "IOException: " + e.getMessage());
            return null;
        } catch (java.security.KeyStoreException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "KeyStoreException: " + e2.getMessage());
            return null;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
            return null;
        } catch (java.security.cert.CertificateException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "CertificateException: " + e4.getMessage());
            return null;
        } catch (java.lang.Exception e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b(a, "Exception: " + e5.getMessage());
            return null;
        }
    }
}
