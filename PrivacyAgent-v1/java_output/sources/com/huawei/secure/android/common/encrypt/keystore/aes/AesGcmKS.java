package com.huawei.secure.android.common.encrypt.keystore.aes;

/* loaded from: classes22.dex */
public class AesGcmKS {
    public static java.util.Map<java.lang.String, javax.crypto.SecretKey> a = new java.util.HashMap();

    public static javax.crypto.SecretKey a(java.lang.String str) {
        android.security.keystore.KeyGenParameterSpec.Builder blockModes;
        android.security.keystore.KeyGenParameterSpec.Builder encryptionPaddings;
        android.security.keystore.KeyGenParameterSpec.Builder keySize;
        android.security.keystore.KeyGenParameterSpec build;
        com.huawei.secure.android.common.encrypt.utils.b.c("GCMKS", "load key");
        javax.crypto.SecretKey secretKey = null;
        try {
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            java.security.Key key = keyStore.getKey(str, null);
            if (key instanceof javax.crypto.SecretKey) {
                secretKey = (javax.crypto.SecretKey) key;
            } else {
                com.huawei.secure.android.common.encrypt.utils.b.c("GCMKS", "generate key");
                javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES", "AndroidKeyStore");
                blockModes = new android.security.keystore.KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM");
                encryptionPaddings = blockModes.setEncryptionPaddings("NoPadding");
                keySize = encryptionPaddings.setKeySize(256);
                build = keySize.build();
                keyGenerator.init(build);
                secretKey = keyGenerator.generateKey();
            }
        } catch (java.io.IOException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "IOException : " + e.getMessage());
        } catch (java.security.InvalidAlgorithmParameterException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "InvalidAlgorithmParameterException : " + e2.getMessage());
        } catch (java.security.KeyStoreException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "KeyStoreException : " + e3.getMessage());
        } catch (java.security.NoSuchAlgorithmException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "NoSuchAlgorithmException : " + e4.getMessage());
        } catch (java.security.NoSuchProviderException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "NoSuchProviderException : " + e5.getMessage());
        } catch (java.security.UnrecoverableKeyException e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "UnrecoverableKeyException : " + e6.getMessage());
        } catch (java.security.cert.CertificateException e7) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "CertificateException : " + e7.getMessage());
        } catch (java.lang.Exception e8) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "Exception: " + e8.getMessage());
        }
        a.put(str, secretKey);
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
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return new java.lang.String(decrypt(str, com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "decrypt: UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(java.lang.String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (android.text.TextUtils.isEmpty(str) || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        if (!b()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "sdk version is too low");
            return bArr2;
        }
        if (bArr.length > 12) {
            return decrypt(c(str), bArr);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "Decrypt source data is invalid.");
        return bArr2;
    }

    public static byte[] decrypt(javax.crypto.SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "Decrypt secret key is null");
            return bArr2;
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "content is null");
            return bArr2;
        }
        if (!b()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "Decrypt source data is invalid.");
            return bArr2;
        }
        byte[] copyOf = java.util.Arrays.copyOf(bArr, 12);
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKey, new javax.crypto.spec.GCMParameterSpec(128, copyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (java.security.InvalidAlgorithmParameterException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "InvalidAlgorithmParameterException : " + e.getMessage());
            return bArr2;
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "InvalidKeyException : " + e2.getMessage());
            return bArr2;
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "NoSuchAlgorithmException : " + e3.getMessage());
            return bArr2;
        } catch (javax.crypto.BadPaddingException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "BadPaddingException : " + e4.getMessage());
            return bArr2;
        } catch (javax.crypto.IllegalBlockSizeException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "IllegalBlockSizeException : " + e5.getMessage());
            return bArr2;
        } catch (javax.crypto.NoSuchPaddingException e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "NoSuchPaddingException : " + e6.getMessage());
            return bArr2;
        } catch (java.lang.Exception e7) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "alias or encrypt content is null");
            return "";
        }
        try {
            return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "encrypt: UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(java.lang.String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (android.text.TextUtils.isEmpty(str) || bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        if (b()) {
            return encrypt(c(str), bArr);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "sdk version is too low");
        return bArr2;
    }

    public static byte[] encrypt(javax.crypto.SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "content is null");
            return bArr2;
        }
        if (secretKey == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "secret key is null");
            return bArr2;
        }
        if (!b()) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "sdk version is too low");
            return bArr2;
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKey);
            byte[] doFinal = cipher.doFinal(bArr);
            byte[] iv = cipher.getIV();
            if (iv != null && iv.length == 12) {
                byte[] copyOf = java.util.Arrays.copyOf(iv, iv.length + doFinal.length);
                java.lang.System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                return copyOf;
            }
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "IV is invalid.");
            return bArr2;
        } catch (java.security.InvalidKeyException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "InvalidKeyException : " + e.getMessage());
            return bArr2;
        } catch (java.security.NoSuchAlgorithmException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "NoSuchAlgorithmException : " + e2.getMessage());
            return bArr2;
        } catch (javax.crypto.BadPaddingException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "BadPaddingException : " + e3.getMessage());
            return bArr2;
        } catch (javax.crypto.IllegalBlockSizeException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "IllegalBlockSizeException : " + e4.getMessage());
            return bArr2;
        } catch (javax.crypto.NoSuchPaddingException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "NoSuchPaddingException : " + e5.getMessage());
            return bArr2;
        } catch (java.lang.Exception e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b("GCMKS", "Exception: " + e6.getMessage());
            return bArr2;
        }
    }
}
