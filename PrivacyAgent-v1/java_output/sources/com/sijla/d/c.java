package com.sijla.d;

/* loaded from: classes19.dex */
public final class c {
    private static java.lang.String a = "RSA";

    private static java.security.PublicKey a(java.lang.String str) {
        try {
            return java.security.KeyFactory.getInstance(a).generatePublic(new java.security.spec.X509EncodedKeySpec(com.sijla.d.a.a(str)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception("公钥数据为空");
        } catch (java.security.NoSuchAlgorithmException unused2) {
            throw new java.lang.Exception("无此算法");
        } catch (java.security.spec.InvalidKeySpecException unused3) {
            throw new java.lang.Exception("公钥非法");
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return a(bArr, a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCMiNanribLqJOKsubsBGWo cdyj4xHI8fA65G+0Bx+PLmsn/EjrSGq/+0h91ZwTeDGvy4N6VugfCye65KZI TwKb7CtieHZKO10BptLIGBtrAnoe5w1BxlNxnu8/1/PAubH0qA0TXTKniQ1N 9hcnTAcH6dQ9xxk7y5294Xl13UKsjQIDAQAB"));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(byte[] bArr, java.security.PublicKey publicKey) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
