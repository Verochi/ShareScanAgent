package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class e {
    static {
        java.nio.charset.Charset.forName("UTF-8");
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return a(str, str2.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException unused) {
            com.huawei.hms.hatool.y.c("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
    }

    public static java.lang.String a(java.lang.String str, byte[] bArr) {
        java.lang.String str2;
        if (bArr == null || bArr.length == 0) {
            com.huawei.hms.hatool.y.f("hmsSdk", "encrypt: content is empty or null");
            return "";
        }
        try {
            return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(a(bArr, a(com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str))));
        } catch (java.security.NoSuchAlgorithmException unused) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            com.huawei.hms.hatool.y.f("hmsSdk", str2);
            return "";
        } catch (java.security.spec.InvalidKeySpecException unused2) {
            str2 = "encrypt(): Invalid key specification";
            com.huawei.hms.hatool.y.f("hmsSdk", str2);
            return "";
        }
    }

    public static java.security.PublicKey a(byte[] bArr) {
        return java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(bArr));
    }

    public static byte[] a(byte[] bArr, java.security.PublicKey publicKey) {
        java.lang.String str;
        try {
            if (publicKey == null) {
                throw new java.io.UnsupportedEncodingException("The loaded public key is null");
            }
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (java.io.UnsupportedEncodingException unused) {
            str = "rsaEncrypt(): getBytes - Unsupported coding format!";
            com.huawei.hms.hatool.y.f("hmsSdk", str);
            return new byte[0];
        } catch (java.security.InvalidKeyException unused2) {
            str = "rsaEncrypt(): init - Invalid key!";
            com.huawei.hms.hatool.y.f("hmsSdk", str);
            return new byte[0];
        } catch (java.security.NoSuchAlgorithmException unused3) {
            str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
            com.huawei.hms.hatool.y.f("hmsSdk", str);
            return new byte[0];
        } catch (javax.crypto.BadPaddingException unused4) {
            str = "rsaEncrypt():False filling parameters!";
            com.huawei.hms.hatool.y.f("hmsSdk", str);
            return new byte[0];
        } catch (javax.crypto.IllegalBlockSizeException unused5) {
            str = "rsaEncrypt(): doFinal - The provided block is not filled with";
            com.huawei.hms.hatool.y.f("hmsSdk", str);
            return new byte[0];
        } catch (javax.crypto.NoSuchPaddingException unused6) {
            str = "rsaEncrypt():  No such filling parameters ";
            com.huawei.hms.hatool.y.f("hmsSdk", str);
            return new byte[0];
        }
    }
}
