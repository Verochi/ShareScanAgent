package cn.fly.verify;

/* loaded from: classes.dex */
public class w {
    public static java.lang.String a(byte[] bArr, java.lang.String str, byte[] bArr2) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr2));
            return android.util.Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static byte[] a() {
        byte[] bArr = new byte[16];
        new java.security.SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static java.lang.String b(byte[] bArr, java.lang.String str, byte[] bArr2) {
        try {
            byte[] decode = android.util.Base64.decode(str, 0);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr2));
            return new java.lang.String(cipher.doFinal(decode), "utf-8");
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
