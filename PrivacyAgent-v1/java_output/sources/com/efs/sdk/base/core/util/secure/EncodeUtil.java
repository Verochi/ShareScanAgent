package com.efs.sdk.base.core.util.secure;

/* loaded from: classes22.dex */
public class EncodeUtil {
    public static byte[] base64Decode(byte[] bArr) {
        return android.util.Base64.decode(bArr, 11);
    }

    public static java.lang.String base64DecodeToStr(byte[] bArr) {
        try {
            return new java.lang.String(base64Decode(bArr));
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "decode error", th);
            return "";
        }
    }

    public static byte[] base64Encode(byte[] bArr) {
        return android.util.Base64.encode(bArr, 11);
    }

    public static java.lang.String base64EncodeToStr(byte[] bArr) {
        return new java.lang.String(base64Encode(bArr));
    }

    public static java.lang.String md5(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        try {
            return java.lang.String.format(java.util.Locale.CHINA, "%032x", new java.math.BigInteger(1, java.security.MessageDigest.getInstance("MD5").digest(str.getBytes())));
        } catch (java.security.NoSuchAlgorithmException e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "md5 error", e);
            return "";
        }
    }

    public static java.lang.String urlEncode(java.lang.String str) {
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "urlEncode error", e);
            return "";
        }
    }
}
