package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public final class r {
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = "SHA-256";
            }
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str2);
            messageDigest.update(bytes);
            return com.huawei.hms.utils.HEX.encodeHexString(messageDigest.digest(), false);
        } catch (java.io.UnsupportedEncodingException unused) {
            com.huawei.hms.support.log.HMSLog.e("SHACoder", "trans failed .");
            return null;
        } catch (java.security.NoSuchAlgorithmException unused2) {
            com.huawei.hms.support.log.HMSLog.e("SHACoder", "encrypt failed .");
            return null;
        }
    }
}
