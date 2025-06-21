package com.huawei.secure.android.common.encrypt.aes;

/* loaded from: classes22.dex */
public final class AesCbc {
    public static int a(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "get encryptword exception : " + e.getMessage());
            return "";
        }
    }

    public static java.lang.String c(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (java.lang.Exception e) {
                com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "mix exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static byte[] d(java.lang.String str, byte[] bArr, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 5 key lengh is not right");
            return new byte[0];
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 5 iv lengh is not right");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", " cbc encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 1 content is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 1 key is null");
            return "";
        }
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return decrypt(str, hexStr2ByteArray);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 1 key length is not right");
        return "";
    }

    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 3 content is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 3 key is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 3 iv is null");
            return "";
        }
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 3 key length is not right");
            return "";
        }
        if (hexStr2ByteArray2.length >= 16) {
            return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 3 iv length is not right");
        return "";
    }

    public static java.lang.String decrypt(java.lang.String str, byte[] bArr) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 2 key lengh is not right");
            return "";
        }
        java.lang.String f = f(str);
        java.lang.String b = b(str);
        if (android.text.TextUtils.isEmpty(f)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 2 iv is null");
            return "";
        }
        if (!android.text.TextUtils.isEmpty(b)) {
            return decrypt(b, bArr, com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(f));
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 2 encrypt content is null");
        return "";
    }

    public static java.lang.String decrypt(java.lang.String str, byte[] bArr, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 4 key lengh is not right");
            return "";
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 4 iv lengh is not right");
            return "";
        }
        try {
            return new java.lang.String(decrypt(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", " cbc decrypt data error" + e.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(g(bArr), bArr2, i(bArr));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 6 key length is error");
            return new byte[0];
        }
        if (bArr3 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decrypt 6 iv length is error");
            return new byte[0];
        }
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (java.security.InvalidAlgorithmParameterException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "InvalidAlgorithmParameterException: " + e.getMessage());
            return new byte[0];
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "InvalidKeyException: " + e2.getMessage());
            return new byte[0];
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "NoSuchAlgorithmException: " + e3.getMessage());
            return new byte[0];
        } catch (javax.crypto.BadPaddingException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "BadPaddingException: " + e4.getMessage());
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "key is not right");
            return new byte[0];
        } catch (javax.crypto.IllegalBlockSizeException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "IllegalBlockSizeException: " + e5.getMessage());
            return new byte[0];
        } catch (javax.crypto.NoSuchPaddingException e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "NoSuchPaddingException: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static java.lang.String decryptWithCryptHead(java.lang.String str, byte[] bArr) {
        if (!android.text.TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            java.lang.String h = h(str);
            if ("".equals(h)) {
                return "";
            }
            int indexOf = h.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(h.substring(indexOf + 1))), bArr, com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(h.substring(0, indexOf)));
            }
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", " cbc cipherText data missing colon");
        }
        return "";
    }

    public static java.lang.String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new java.lang.String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] j = j(bArr);
        if (j.length == 0) {
            return new byte[0];
        }
        int a = a(j);
        if (a < 0) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", " cbc cipherText data missing colon");
            return new byte[0];
        }
        byte[] copyOf = java.util.Arrays.copyOf(j, a);
        int length = (j.length - copyOf.length) - 1;
        byte[] bArr3 = new byte[length];
        java.lang.System.arraycopy(j, a + 1, bArr3, 0, length);
        return decrypt(bArr3, bArr2, copyOf);
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 1 content is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 1 key is null");
            return "";
        }
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return encrypt(str, hexStr2ByteArray);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 1 key length is not right");
        return "";
    }

    public static java.lang.String encrypt(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 3 content is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 3 key is null");
            return "";
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 3 iv is null");
            return "";
        }
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 3 key length is not right");
            return "";
        }
        if (hexStr2ByteArray2.length >= 16) {
            return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 3 iv length is not right");
        return "";
    }

    public static java.lang.String encrypt(java.lang.String str, byte[] bArr) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 2 key lengh is not right");
            return "";
        }
        byte[] generateSecureRandom = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(16);
        byte[] d = d(str, bArr, generateSecureRandom);
        return (d == null || d.length == 0) ? "" : c(com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(generateSecureRandom), com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(d));
    }

    public static java.lang.String encrypt(java.lang.String str, byte[] bArr, byte[] bArr2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 4 key lengh is not right");
            return "";
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length >= 16) {
            return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(d(str, bArr, bArr2));
        }
        com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 4 iv lengh is not right");
        return "";
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(16);
        return e(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 6 key length is error");
            return new byte[0];
        }
        if (bArr3 == null) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "encrypt 6 iv length is error");
            return new byte[0];
        }
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (java.security.InvalidAlgorithmParameterException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "InvalidAlgorithmParameterException: " + e.getMessage());
            return new byte[0];
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "InvalidKeyException: " + e2.getMessage());
            return new byte[0];
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "NoSuchAlgorithmException: " + e3.getMessage());
            return new byte[0];
        } catch (javax.crypto.BadPaddingException e4) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "BadPaddingException: " + e4.getMessage());
            return new byte[0];
        } catch (javax.crypto.IllegalBlockSizeException e5) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "IllegalBlockSizeException: " + e5.getMessage());
            return new byte[0];
        } catch (javax.crypto.NoSuchPaddingException e6) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "NoSuchPaddingException: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static java.lang.String f(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "getIv exception : " + e.getMessage());
            return "";
        }
    }

    public static byte[] g(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 16];
        java.lang.System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    public static java.lang.String h(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || str.indexOf("security:") == -1) ? "" : str.substring(9);
    }

    public static byte[] i(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    public static byte[] j(byte[] bArr) {
        java.lang.String str;
        try {
            str = new java.lang.String(bArr, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.huawei.secure.android.common.encrypt.utils.b.b("CBC", "stripCryptHead: exception : " + e.getMessage());
            str = "";
        }
        if (!str.startsWith("security:")) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        int length = bArr.length - 9;
        byte[] bArr2 = new byte[length];
        java.lang.System.arraycopy(bArr, 9, bArr2, 0, length);
        return bArr2;
    }
}
