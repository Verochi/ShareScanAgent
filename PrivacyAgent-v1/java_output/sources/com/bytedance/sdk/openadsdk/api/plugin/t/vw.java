package com.bytedance.sdk.openadsdk.api.plugin.t;

/* loaded from: classes22.dex */
public class vw {
    public static java.lang.String vw(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str3.getBytes(), "AES");
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(str2.getBytes()));
            return android.util.Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
