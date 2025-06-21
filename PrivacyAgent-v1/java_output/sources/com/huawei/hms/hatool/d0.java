package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class d0 {
    public static com.huawei.hms.hatool.d0 c;
    public java.lang.String a;
    public java.lang.String b;

    public static com.huawei.hms.hatool.d0 f() {
        if (c == null) {
            g();
        }
        return c;
    }

    public static synchronized void g() {
        synchronized (com.huawei.hms.hatool.d0.class) {
            if (c == null) {
                c = new com.huawei.hms.hatool.d0();
            }
        }
    }

    public java.lang.String a() {
        if (android.text.TextUtils.isEmpty(this.a)) {
            this.a = c();
        }
        return this.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
    
        if (e() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String a(java.lang.String str) {
        java.lang.String decrypt = e() ? com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.decrypt("analytics_keystore", str) : "";
        if (android.text.TextUtils.isEmpty(decrypt)) {
            com.huawei.hms.hatool.y.c("hmsSdk", "deCrypt work key first");
            decrypt = com.huawei.hms.hatool.d.a(str, d());
            if (android.text.TextUtils.isEmpty(decrypt)) {
                decrypt = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(16);
                c(b(decrypt));
            } else if (e()) {
                c(b(decrypt));
                com.huawei.hms.hatool.c0.d();
            }
        }
        return decrypt;
    }

    public final java.lang.String b(java.lang.String str) {
        return e() ? com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.encrypt("analytics_keystore", str) : com.huawei.hms.hatool.d.b(str, d());
    }

    public void b() {
        java.lang.String generateSecureRandomStr = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(16);
        if (c(b(generateSecureRandomStr))) {
            this.a = generateSecureRandomStr;
        }
    }

    public final java.lang.String c() {
        java.lang.String a = com.huawei.hms.hatool.g0.a(com.huawei.hms.hatool.b.i(), "Privacy_MY", "PrivacyData", "");
        if (!android.text.TextUtils.isEmpty(a)) {
            return a(a);
        }
        java.lang.String generateSecureRandomStr = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(16);
        c(b(generateSecureRandomStr));
        return generateSecureRandomStr;
    }

    public final boolean c(java.lang.String str) {
        com.huawei.hms.hatool.y.c("hmsSdk", "refresh sp aes key");
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.hms.hatool.y.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "Privacy_MY", "PrivacyData", str);
        com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "Privacy_MY", "flashKeyTime", java.lang.System.currentTimeMillis());
        return true;
    }

    public final java.lang.String d() {
        if (android.text.TextUtils.isEmpty(this.b)) {
            this.b = new com.huawei.hms.hatool.c0().a();
        }
        return this.b;
    }

    public final boolean e() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }
}
