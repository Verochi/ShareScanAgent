package com.huawei.secure.android.common.encrypt.keystore.aes;

/* loaded from: classes22.dex */
public class AesCbcKS {
    public static java.util.Map<java.lang.String, javax.crypto.SecretKey> a = new java.util.HashMap();

    public static synchronized javax.crypto.SecretKey a(java.lang.String str) {
        javax.crypto.SecretKey secretKey;
        android.security.keystore.KeyGenParameterSpec.Builder blockModes;
        android.security.keystore.KeyGenParameterSpec.Builder encryptionPaddings;
        android.security.keystore.KeyGenParameterSpec.Builder keySize;
        android.security.keystore.KeyGenParameterSpec build;
        synchronized (com.huawei.secure.android.common.encrypt.keystore.aes.AesCbcKS.class) {
            com.huawei.secure.android.common.encrypt.utils.b.c("CBCKS", "load key");
            secretKey = null;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
                                    keyStore.load(null);
                                    java.security.Key key = keyStore.getKey(str, null);
                                    if (key == null || !(key instanceof javax.crypto.SecretKey)) {
                                        com.huawei.secure.android.common.encrypt.utils.b.c("CBCKS", "generate key");
                                        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES", "AndroidKeyStore");
                                        blockModes = new android.security.keystore.KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC");
                                        encryptionPaddings = blockModes.setEncryptionPaddings("PKCS7Padding");
                                        keySize = encryptionPaddings.setKeySize(256);
                                        build = keySize.build();
                                        keyGenerator.init(build);
                                        secretKey = keyGenerator.generateKey();
                                    } else {
                                        secretKey = (javax.crypto.SecretKey) key;
                                    }
                                } catch (java.security.cert.CertificateException e) {
                                    com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "CertificateException: " + e.getMessage());
                                }
                            } catch (java.security.InvalidAlgorithmParameterException e2) {
                                com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "InvalidAlgorithmParameterException: " + e2.getMessage());
                            }
                        } catch (java.security.NoSuchProviderException e3) {
                            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "NoSuchProviderException: " + e3.getMessage());
                        }
                    } catch (java.security.UnrecoverableKeyException e4) {
                        com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "UnrecoverableKeyException: " + e4.getMessage());
                    }
                } catch (java.io.IOException e5) {
                    com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "IOException: " + e5.getMessage());
                } catch (java.lang.Exception e6) {
                    com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "Exception: " + e6.getMessage());
                }
            } catch (java.security.KeyStoreException e7) {
                com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "KeyStoreException: " + e7.getMessage());
            } catch (java.security.NoSuchAlgorithmException e8) {
                com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "NoSuchAlgorithmException: " + e8.getMessage());
            }
            a.put(str, secretKey);
        }
        return secretKey;
    }

    public static boolean b() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

    public static javax.crypto.SecretKey c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (a.get(str) == null) {
            a(str);
        }
        return a.get(str);
    }

    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return new java.lang.String(decrypt(str, com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] decrypt(java.lang.String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (android.text.TextUtils.isEmpty(str) || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "alias or encrypt content is null");
            return bArr2;
        }
        if (!b()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "Decrypt source data is invalid.");
            return bArr2;
        }
        javax.crypto.SecretKey c = c(str);
        if (c == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "decrypt secret key is null");
            return bArr2;
        }
        byte[] copyOf = java.util.Arrays.copyOf(bArr, 16);
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, c, new javax.crypto.spec.IvParameterSpec(copyOf));
            return cipher.doFinal(bArr, 16, bArr.length - 16);
        } catch (java.security.InvalidAlgorithmParameterException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "InvalidAlgorithmParameterException: " + e.getMessage());
            return bArr2;
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "InvalidKeyException: " + e2.getMessage());
            return bArr2;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "NoSuchAlgorithmException: " + e3.getMessage());
            return bArr2;
        } catch (javax.crypto.BadPaddingException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "BadPaddingException: " + e4.getMessage());
            return bArr2;
        } catch (javax.crypto.IllegalBlockSizeException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "IllegalBlockSizeException: " + e5.getMessage());
            return bArr2;
        } catch (javax.crypto.NoSuchPaddingException e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "NoSuchPaddingException: " + e6.getMessage());
            return bArr2;
        } catch (java.lang.Exception e7) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "encrypt 1 content is null");
            return "";
        }
        try {
            return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (java.io.UnsupportedEncodingException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] encrypt(java.lang.String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (android.text.TextUtils.isEmpty(str) || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "alias or encrypt content is null");
            return bArr2;
        }
        if (!b()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "sdk version is too low");
            return bArr2;
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS7Padding");
            javax.crypto.SecretKey c = c(str);
            if (c == null) {
                com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "encrypt secret key is null");
                return bArr2;
            }
            cipher.init(1, c);
            byte[] doFinal = cipher.doFinal(bArr);
            byte[] iv = cipher.getIV();
            if (iv != null && iv.length == 16) {
                byte[] copyOf = java.util.Arrays.copyOf(iv, iv.length + doFinal.length);
                java.lang.System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                return copyOf;
            }
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "IV is invalid.");
            return bArr2;
        } catch (java.security.InvalidKeyException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "InvalidKeyException: " + e.getMessage());
            return bArr2;
        } catch (java.security.NoSuchAlgorithmException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "NoSuchAlgorithmException: " + e2.getMessage());
            return bArr2;
        } catch (javax.crypto.BadPaddingException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "BadPaddingException: " + e3.getMessage());
            return bArr2;
        } catch (javax.crypto.IllegalBlockSizeException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "IllegalBlockSizeException: " + e4.getMessage());
            return bArr2;
        } catch (javax.crypto.NoSuchPaddingException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "NoSuchPaddingException: " + e5.getMessage());
            return bArr2;
        } catch (java.lang.Exception e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBCKS", "Exception: " + e6.getMessage());
            return bArr2;
        }
    }
}
