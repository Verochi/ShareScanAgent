package com.getui.gs.h;

/* loaded from: classes22.dex */
public final class e {
    public static java.lang.String a() throws java.security.NoSuchAlgorithmException {
        com.getui.gs.b.e eVar;
        eVar = com.getui.gs.b.e.a.a;
        long a = eVar.a.a(6);
        if (a <= 0) {
            a = java.lang.System.currentTimeMillis();
        }
        return a(com.getui.gs.a.d.d(), com.getui.gs.a.d.e(), a);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, long j) throws java.security.NoSuchAlgorithmException {
        return com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", (str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + j).getBytes());
    }
}
