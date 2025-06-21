package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class z0 {
    public static com.huawei.hms.hatool.z0 b;
    public android.content.Context a;

    public static class a extends com.huawei.hms.hatool.a1 {
        public java.lang.String a;
        public java.lang.String b;

        public a(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.huawei.hms.hatool.a1
        public java.lang.String a() {
            return com.huawei.hms.hatool.a.d(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public java.lang.String a(java.lang.String str) {
            return com.huawei.secure.android.common.encrypt.hash.SHA.sha256Encrypt(str);
        }

        @Override // com.huawei.hms.hatool.a1
        public java.lang.String b() {
            return com.huawei.hms.hatool.a.g(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public java.lang.String c() {
            return com.huawei.hms.hatool.a.j(this.a, this.b);
        }

        @Override // com.huawei.hms.hatool.a1
        public int d() {
            return (com.huawei.hms.hatool.a.k(this.a, this.b) ? 4 : 0) | 0 | (com.huawei.hms.hatool.a.e(this.a, this.b) ? 2 : 0) | (com.huawei.hms.hatool.a.h(this.a, this.b) ? 1 : 0);
        }
    }

    public static com.huawei.hms.hatool.z0 a() {
        com.huawei.hms.hatool.z0 z0Var;
        synchronized (com.huawei.hms.hatool.z0.class) {
            if (b == null) {
                b = new com.huawei.hms.hatool.z0();
            }
            z0Var = b;
        }
        return z0Var;
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        return com.huawei.hms.hatool.g.a(this.a, str, str2);
    }

    public java.lang.String a(boolean z) {
        if (!z) {
            return "";
        }
        java.lang.String e = com.huawei.hms.hatool.b.e();
        if (android.text.TextUtils.isEmpty(e)) {
            e = com.huawei.hms.hatool.g0.a(this.a, "global_v2", "uuid", "");
            if (android.text.TextUtils.isEmpty(e)) {
                e = java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                com.huawei.hms.hatool.g0.b(this.a, "global_v2", "uuid", e);
            }
            com.huawei.hms.hatool.b.h(e);
        }
        return e;
    }

    public void a(android.content.Context context) {
        if (this.a == null) {
            this.a = context;
        }
    }

    public java.lang.String b(java.lang.String str, java.lang.String str2) {
        return com.huawei.hms.hatool.g.b(this.a, str, str2);
    }

    public com.huawei.hms.hatool.x0 c(java.lang.String str, java.lang.String str2) {
        return new com.huawei.hms.hatool.z0.a(str, str2).a(this.a);
    }

    public java.lang.String d(java.lang.String str, java.lang.String str2) {
        return com.huawei.hms.hatool.c1.b(str, str2);
    }

    public android.util.Pair<java.lang.String, java.lang.String> e(java.lang.String str, java.lang.String str2) {
        if (!com.huawei.hms.hatool.a.f(str, str2)) {
            return new android.util.Pair<>("", "");
        }
        java.lang.String p = com.huawei.hms.hatool.i.c().b().p();
        java.lang.String q = com.huawei.hms.hatool.i.c().b().q();
        if (!android.text.TextUtils.isEmpty(p) && !android.text.TextUtils.isEmpty(q)) {
            return new android.util.Pair<>(p, q);
        }
        android.util.Pair<java.lang.String, java.lang.String> e = com.huawei.hms.hatool.b1.e(this.a);
        com.huawei.hms.hatool.i.c().b().k((java.lang.String) e.first);
        com.huawei.hms.hatool.i.c().b().l((java.lang.String) e.second);
        return e;
    }

    public java.lang.String f(java.lang.String str, java.lang.String str2) {
        return com.huawei.hms.hatool.c1.a(str, str2);
    }
}
