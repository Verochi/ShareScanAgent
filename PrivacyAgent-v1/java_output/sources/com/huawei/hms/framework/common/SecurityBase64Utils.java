package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class SecurityBase64Utils {
    private static volatile boolean IS_AEGIS_BASE64_LIBRARY_LOADED = false;
    private static final java.lang.String SAFE_BASE64_PATH = "com.huawei.secure.android.common.util.SafeBase64";

    private static boolean checkCompatible(java.lang.String str) {
        java.lang.ClassLoader classLoader = com.huawei.hms.framework.common.SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (com.huawei.hms.framework.common.SecurityBase64Utils.class) {
                IS_AEGIS_BASE64_LIBRARY_LOADED = true;
            }
            return true;
        } catch (java.lang.ClassNotFoundException unused) {
            return false;
        }
    }

    public static byte[] decode(java.lang.String str, int i) {
        if (IS_AEGIS_BASE64_LIBRARY_LOADED || checkCompatible(SAFE_BASE64_PATH)) {
            return com.huawei.secure.android.common.util.SafeBase64.decode(str, i);
        }
        try {
            return android.util.Base64.decode(str, i);
        } catch (java.lang.Exception unused) {
            return new byte[0];
        }
    }

    public static java.lang.String encodeToString(byte[] bArr, int i) {
        if (IS_AEGIS_BASE64_LIBRARY_LOADED || checkCompatible(SAFE_BASE64_PATH)) {
            return com.huawei.secure.android.common.util.SafeBase64.encodeToString(bArr, i);
        }
        try {
            return android.util.Base64.encodeToString(bArr, i);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
