package com.huawei.hms.common.util;

/* loaded from: classes22.dex */
public final class Base64Utils {
    private static final int FLAG_DEFAULT = 0;
    private static final int FLAG_URL = 10;
    private static final int FLAG_URL_NOPADDING = 11;
    private static final java.lang.String TAG = "Base64Utils";

    public static byte[] decode(java.lang.String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            try {
                return android.util.Base64.decode(str, 0);
            } catch (java.lang.IllegalArgumentException e) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "decode failed : " + e.getMessage());
            }
        }
        return bArr;
    }

    public static byte[] decodeUrlSafe(java.lang.String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            try {
                return android.util.Base64.decode(str, 10);
            } catch (java.lang.IllegalArgumentException e) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "decodeUrlSafe failed : " + e.getMessage());
            }
        }
        return bArr;
    }

    public static byte[] decodeUrlSafeNoPadding(java.lang.String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            try {
                return android.util.Base64.decode(str, 11);
            } catch (java.lang.IllegalArgumentException e) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "decodeUrlSafeNoPadding failed : " + e.getMessage());
            }
        }
        return bArr;
    }

    public static java.lang.String encode(byte[] bArr) {
        if (bArr != null) {
            return android.util.Base64.encodeToString(bArr, 0);
        }
        return null;
    }

    public static java.lang.String encodeUrlSafe(byte[] bArr) {
        if (bArr != null) {
            return android.util.Base64.encodeToString(bArr, 10);
        }
        return null;
    }

    public static java.lang.String encodeUrlSafeNoPadding(byte[] bArr) {
        if (bArr != null) {
            return android.util.Base64.encodeToString(bArr, 11);
        }
        return null;
    }
}
