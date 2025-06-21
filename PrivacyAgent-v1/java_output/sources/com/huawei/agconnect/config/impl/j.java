package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
class j implements com.huawei.agconnect.config.impl.d {
    public final android.content.Context a;
    public final java.lang.String b;

    public j(android.content.Context context, java.lang.String str) {
        this.a = context;
        this.b = str;
    }

    public static java.lang.String a(java.lang.String str) {
        try {
            return "agc_" + com.huawei.agconnect.config.impl.Hex.encodeHexString(b(str.getBytes("UTF-8")));
        } catch (java.io.UnsupportedEncodingException | java.security.NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static byte[] b(byte[] bArr) throws java.security.NoSuchAlgorithmException {
        return java.security.MessageDigest.getInstance("SHA-256").digest(bArr);
    }

    @Override // com.huawei.agconnect.config.impl.d
    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        int identifier;
        java.lang.String a = a(str);
        if (android.text.TextUtils.isEmpty(a) || (identifier = this.a.getResources().getIdentifier(a, com.anythink.expressad.foundation.h.i.g, this.b)) == 0) {
            return str2;
        }
        try {
            return this.a.getResources().getString(identifier);
        } catch (android.content.res.Resources.NotFoundException unused) {
            return str2;
        }
    }
}
