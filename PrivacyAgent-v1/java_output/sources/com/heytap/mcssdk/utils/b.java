package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public class b {
    public static java.lang.String a = null;
    public static final java.lang.String b = "Y29tLm5lYXJtZS5tY3M=";
    public static java.lang.String c = "";

    private static java.lang.String a() {
        if (android.text.TextUtils.isEmpty(c)) {
            c = new java.lang.String(com.heytap.mcssdk.a.a.b(b));
        }
        byte[] a2 = a(a(c));
        return a2 != null ? new java.lang.String(a2, java.nio.charset.Charset.forName("UTF-8")) : "";
    }

    public static byte[] a(java.lang.String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b2 = bArr[i];
            int i2 = i + 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b2;
        }
        return bArr;
    }

    public static java.lang.String b(java.lang.String str) {
        boolean z;
        java.lang.String str2 = "";
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = com.heytap.mcssdk.utils.c.a(str, a());
            com.heytap.mcssdk.utils.d.b("sdkDecrypt desDecrypt des data " + str2);
            z = true;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b("sdkDecrypt DES excepiton " + e.toString());
            z = false;
        }
        if (android.text.TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = com.heytap.msp.push.encrypt.AESEncrypt.decrypt(com.heytap.msp.push.encrypt.AESEncrypt.SDK_APP_SECRET, str);
            a = "AES";
            com.heytap.mcssdk.utils.e.f().b(a);
            com.heytap.mcssdk.utils.d.b("sdkDecrypt desDecrypt aes data " + str2);
            return str2;
        } catch (java.lang.Exception e2) {
            com.heytap.mcssdk.utils.d.b("sdkDecrypt AES excepiton " + e2.toString());
            return str2;
        }
    }

    public static java.lang.String c(java.lang.String str) {
        boolean z;
        java.lang.String str2 = "";
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = com.heytap.msp.push.encrypt.AESEncrypt.decrypt(com.heytap.msp.push.encrypt.AESEncrypt.SDK_APP_SECRET, str);
            com.heytap.mcssdk.utils.d.b("sdkDecrypt aesDecrypt aes data " + str2);
            z = true;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b("sdkDecrypt AES excepiton " + e.toString());
            z = false;
        }
        if (android.text.TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = com.heytap.mcssdk.utils.c.a(str, a());
            a = "DES";
            com.heytap.mcssdk.utils.e.f().b(a);
            com.heytap.mcssdk.utils.d.b("sdkDecrypt aesDecrypt des data " + str2);
            return str2;
        } catch (java.lang.Exception e2) {
            com.heytap.mcssdk.utils.d.b("sdkDecrypt DES excepiton " + e2.toString());
            return str2;
        }
    }

    public static java.lang.String d(java.lang.String str) {
        com.heytap.mcssdk.utils.d.b("sdkDecrypt start data " + str);
        if (android.text.TextUtils.isEmpty(a)) {
            a = com.heytap.mcssdk.utils.e.f().e();
        }
        if ("DES".equals(a)) {
            com.heytap.mcssdk.utils.d.b("sdkDecrypt start DES");
            return b(str);
        }
        com.heytap.mcssdk.utils.d.b("sdkDecrypt start AES");
        return c(str);
    }
}
