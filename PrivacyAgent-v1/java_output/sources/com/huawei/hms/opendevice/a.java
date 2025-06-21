package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public abstract class a {
    public static java.lang.String a(byte[] bArr) {
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(bArr);
    }

    public static byte[] a(java.lang.String str) {
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str);
    }
}
