package com.getui.gtc.base.crypt;

/* loaded from: classes22.dex */
public class CryptTools {
    public static java.io.InputStream decrypt(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, java.io.InputStream inputStream) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return new javax.crypto.CipherInputStream(inputStream, cipher);
    }

    public static java.io.OutputStream decrypt(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, java.io.OutputStream outputStream) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return new javax.crypto.CipherOutputStream(outputStream, cipher);
    }

    public static byte[] decrypt(java.lang.String str, java.security.PrivateKey privateKey, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(2, privateKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] decrypt(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] digest(java.lang.String str, byte[] bArr) throws java.security.NoSuchAlgorithmException {
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static java.lang.String digestToHexString(java.lang.String str, byte[] bArr) throws java.security.NoSuchAlgorithmException {
        byte[] digest = digest(str, bArr);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = digest.length;
        for (int i = 0; i < length; i++) {
            int i2 = digest[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (i2 < 16) {
                sb.append("0");
            }
            sb.append(java.lang.Integer.toHexString(i2));
        }
        return sb.toString();
    }

    public static java.io.InputStream encrypt(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, java.io.InputStream inputStream) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return new javax.crypto.CipherInputStream(inputStream, cipher);
    }

    public static java.io.OutputStream encrypt(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, java.io.OutputStream outputStream) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return new javax.crypto.CipherOutputStream(outputStream, cipher);
    }

    public static byte[] encrypt(java.lang.String str, java.security.PublicKey publicKey, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] encrypt(java.lang.String str, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec, byte[] bArr) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, javax.crypto.BadPaddingException, javax.crypto.IllegalBlockSizeException, java.security.InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static javax.crypto.SecretKey generateKey(java.lang.String str, int i) throws java.security.NoSuchAlgorithmException {
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(str);
        keyGenerator.init(i);
        return keyGenerator.generateKey();
    }

    public static java.security.KeyPair generateKeyPair(java.lang.String str, int i) throws java.security.NoSuchAlgorithmException {
        java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance(str);
        keyPairGenerator.initialize(i);
        return keyPairGenerator.generateKeyPair();
    }

    public static java.lang.String keyToString(java.security.Key key) {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            return android.util.Base64.encodeToString(encoded, 0);
        }
        throw new java.lang.RuntimeException("can not transform key to string");
    }

    public static java.security.PrivateKey parsePrivateKey(java.lang.String str, java.io.File file) throws java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException, java.io.IOException {
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file)));
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while (true) {
                    java.lang.String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        java.security.PrivateKey parsePrivateKey = parsePrivateKey(str, sb.toString());
                        bufferedReader2.close();
                        return parsePrivateKey;
                    }
                    if (readLine.charAt(0) != '-') {
                        sb.append(readLine);
                        sb.append('\r');
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.security.PrivateKey parsePrivateKey(java.lang.String str, java.lang.String str2) throws java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException {
        return java.security.KeyFactory.getInstance(str).generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(android.util.Base64.decode(str2, 0)));
    }

    public static java.security.PublicKey parsePublicKey(java.lang.String str, java.io.File file) throws java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException, java.io.IOException {
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file)));
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while (true) {
                    java.lang.String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        java.security.PublicKey parsePublicKey = parsePublicKey(str, sb.toString());
                        bufferedReader2.close();
                        return parsePublicKey;
                    }
                    if (readLine.charAt(0) != '-') {
                        sb.append(readLine);
                        sb.append('\r');
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.security.PublicKey parsePublicKey(java.lang.String str, java.lang.String str2) throws java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException {
        return java.security.KeyFactory.getInstance(str).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str2, 0)));
    }

    public static javax.crypto.SecretKey parseSecretKey(java.lang.String str, java.lang.String str2) {
        return wrapperKey(str, android.util.Base64.decode(str2, 0));
    }

    public static byte[] sign(java.lang.String str, java.security.PrivateKey privateKey, byte[] bArr) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.SignatureException {
        java.security.Signature signature = java.security.Signature.getInstance(str);
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }

    public static boolean verify(java.lang.String str, java.security.PublicKey publicKey, byte[] bArr, byte[] bArr2) throws java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.SignatureException {
        java.security.Signature signature = java.security.Signature.getInstance(str);
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public static javax.crypto.SecretKey wrapperKey(java.lang.String str, byte[] bArr) {
        return new javax.crypto.spec.SecretKeySpec(bArr, str);
    }
}
