package com.umeng.logsdk;

/* loaded from: classes19.dex */
public final class c {
    public static java.lang.String a(byte[] bArr) {
        return new java.lang.String(android.util.Base64.encode(bArr, 11));
    }

    public static java.lang.String b(byte[] bArr) {
        try {
            return new java.lang.String(android.util.Base64.decode(bArr, 11));
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "decode error", th);
            return "";
        }
    }
}
