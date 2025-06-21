package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class x {
    public static com.huawei.hms.hatool.x b = new com.huawei.hms.hatool.x();
    public com.huawei.hms.hatool.x.a a = new com.huawei.hms.hatool.x.a();

    public class a {
        public java.lang.String a;
        public java.lang.String b;
        public long c = 0;

        public a() {
        }

        public void a(long j) {
            com.huawei.hms.hatool.x.this.a.c = j;
        }

        public void a(java.lang.String str) {
            com.huawei.hms.hatool.x.this.a.b = str;
        }

        public void b(java.lang.String str) {
            com.huawei.hms.hatool.x.this.a.a = str;
        }
    }

    public static com.huawei.hms.hatool.x d() {
        return b;
    }

    public java.lang.String a() {
        return this.a.b;
    }

    public void a(java.lang.String str, java.lang.String str2) {
        long b2 = b();
        java.lang.String b3 = com.huawei.hms.hatool.r0.b(str, str2);
        if (b3 == null || b3.isEmpty()) {
            com.huawei.hms.hatool.y.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b2 == 0) {
            b2 = java.lang.System.currentTimeMillis();
        } else if (java.lang.System.currentTimeMillis() - b2 <= com.heytap.mcssdk.constant.a.g) {
            return;
        }
        java.lang.String generateSecureRandomStr = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(16);
        java.lang.String a2 = com.huawei.hms.hatool.e.a(b3, generateSecureRandomStr);
        this.a.a(b2);
        this.a.b(generateSecureRandomStr);
        this.a.a(a2);
    }

    public long b() {
        return this.a.c;
    }

    public java.lang.String c() {
        return this.a.a;
    }
}
