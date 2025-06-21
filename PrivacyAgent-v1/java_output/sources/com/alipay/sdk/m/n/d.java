package com.alipay.sdk.m.n;

/* loaded from: classes.dex */
public class d {
    public static final java.lang.String a = "RSA";

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(java.lang.String str, java.lang.String str2) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        java.io.ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                try {
                    java.security.PublicKey b = b(a, str2);
                    javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(1, b);
                    byte[] bytes = str.getBytes("UTF-8");
                    int blockSize = cipher.getBlockSize();
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    for (int i = 0; i < bytes.length; i += blockSize) {
                        try {
                            byteArrayOutputStream.write(cipher.doFinal(bytes, i, bytes.length - i < blockSize ? bytes.length - i : blockSize));
                        } catch (java.lang.Exception e) {
                            e = e;
                            com.alipay.sdk.m.u.e.a(e);
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return bArr;
                        }
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.close();
                        } catch (java.io.IOException e2) {
                            com.alipay.sdk.m.u.e.a(e2);
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (byteArrayOutputStream3 != null) {
                }
                throw th;
            }
        } catch (java.io.IOException e4) {
            com.alipay.sdk.m.u.e.a(e4);
        }
        return bArr;
    }

    public static java.security.PublicKey b(java.lang.String str, java.lang.String str2) throws java.security.NoSuchAlgorithmException, java.lang.Exception {
        return java.security.KeyFactory.getInstance(str).generatePublic(new java.security.spec.X509EncodedKeySpec(com.alipay.sdk.m.n.a.a(str2)));
    }
}
