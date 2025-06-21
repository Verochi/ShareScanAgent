package com.sensorsdata.sf.core.data;

/* loaded from: classes19.dex */
public class SecretUtil {
    public static java.lang.String decryptAES(java.lang.String str) {
        return com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance().decryptAES(str);
    }

    public static java.lang.String encryptAES(java.lang.String str) {
        return com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance().encryptAES(str);
    }
}
