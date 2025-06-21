package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
public class e implements com.huawei.agconnect.config.impl.g {
    public final com.huawei.agconnect.config.impl.d a;
    public javax.crypto.SecretKey b;

    public e(com.huawei.agconnect.config.impl.d dVar) {
        this.a = dVar;
        b();
    }

    public static boolean a(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && java.util.regex.Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (java.lang.IllegalStateException | java.lang.IndexOutOfBoundsException unused) {
        }
        return "";
    }

    @Override // com.huawei.agconnect.config.impl.g
    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (this.b != null && a(str)) {
            try {
                return new java.lang.String(com.huawei.agconnect.config.impl.i.b(this.b, com.huawei.agconnect.config.impl.Hex.decodeHexString(c(str))), "UTF-8");
            } catch (java.io.UnsupportedEncodingException | java.lang.IllegalArgumentException | java.security.GeneralSecurityException unused) {
            }
        }
        return str2;
    }

    public final javax.crypto.SecretKey b() {
        try {
            java.lang.String a = this.a.a("/code/code1", null);
            java.lang.String a2 = this.a.a("/code/code2", null);
            java.lang.String a3 = this.a.a("/code/code3", null);
            java.lang.String a4 = this.a.a("/code/code4", null);
            if (a != null && a2 != null && a3 != null && a4 != null) {
                this.b = com.huawei.agconnect.config.impl.i.a(com.huawei.agconnect.config.impl.Hex.decodeHexString(a), com.huawei.agconnect.config.impl.Hex.decodeHexString(a2), com.huawei.agconnect.config.impl.Hex.decodeHexString(a3), com.huawei.agconnect.config.impl.Hex.decodeHexString(a4), 10000);
            }
        } catch (java.lang.IllegalArgumentException | java.security.NoSuchAlgorithmException | java.security.spec.InvalidKeySpecException unused) {
            this.b = null;
        }
        return this.b;
    }
}
