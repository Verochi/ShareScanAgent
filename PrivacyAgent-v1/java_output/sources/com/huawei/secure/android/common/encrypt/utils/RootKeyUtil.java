package com.huawei.secure.android.common.encrypt.utils;

/* loaded from: classes22.dex */
public class RootKeyUtil {
    public static final java.lang.String b = "RootKeyUtil";
    public byte[] a = null;

    public static com.huawei.secure.android.common.encrypt.utils.RootKeyUtil newInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil = new com.huawei.secure.android.common.encrypt.utils.RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public static com.huawei.secure.android.common.encrypt.utils.RootKeyUtil newInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        com.huawei.secure.android.common.encrypt.utils.RootKeyUtil rootKeyUtil = new com.huawei.secure.android.common.encrypt.utils.RootKeyUtil();
        rootKeyUtil.b(str, str2, str3, bArr);
        return rootKeyUtil;
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        b(str, str2, str3, com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str4));
    }

    @android.annotation.SuppressLint({"NewApi"})
    public final void b(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            com.huawei.secure.android.common.encrypt.utils.b.c(b, "initRootKey: sha1");
            this.a = com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil.exportRootKey(str, str2, str3, bArr, false);
        } else {
            com.huawei.secure.android.common.encrypt.utils.b.c(b, "initRootKey: sha256");
            this.a = com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
        }
    }

    public byte[] getRootKey() {
        return (byte[]) this.a.clone();
    }

    public java.lang.String getRootKeyHex() {
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(this.a);
    }
}
