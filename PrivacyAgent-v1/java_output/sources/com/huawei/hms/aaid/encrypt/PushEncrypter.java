package com.huawei.hms.aaid.encrypt;

/* loaded from: classes22.dex */
public class PushEncrypter {
    public static java.lang.String decrypter(android.content.Context context, java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : com.huawei.secure.android.common.encrypt.aes.AesCbc.decrypt(str, com.huawei.hms.opendevice.c.b(context));
    }

    public static java.lang.String encrypter(android.content.Context context, java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : com.huawei.secure.android.common.encrypt.aes.AesCbc.encrypt(str, com.huawei.hms.opendevice.c.b(context));
    }

    public static java.lang.String encrypterOld(android.content.Context context, java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : com.huawei.secure.android.common.encrypt.aes.AesCbc.encrypt(str, com.huawei.hms.opendevice.c.a(context));
    }
}
