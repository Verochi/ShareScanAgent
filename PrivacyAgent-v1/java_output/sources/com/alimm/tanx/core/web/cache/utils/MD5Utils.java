package com.alimm.tanx.core.web.cache.utils;

/* loaded from: classes.dex */
public class MD5Utils {
    public static java.lang.String bytesToHex(byte[] bArr, boolean z) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (i2 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(java.lang.Integer.toHexString(i2));
        }
        return z ? stringBuffer.toString().toUpperCase() : stringBuffer.toString().toLowerCase();
    }

    public static java.lang.String getMD5(java.lang.String str) {
        return getMD5(str, true);
    }

    public static java.lang.String getMD5(java.lang.String str, boolean z) {
        try {
            return bytesToHex(java.security.MessageDigest.getInstance("MD5").digest(str.getBytes()), z);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
