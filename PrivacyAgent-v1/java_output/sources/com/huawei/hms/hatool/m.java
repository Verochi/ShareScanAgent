package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class m {
    public com.huawei.hms.hatool.k a;
    public com.huawei.hms.hatool.k b;
    public com.huawei.hms.hatool.k c;
    public com.huawei.hms.hatool.k d;

    public m(java.lang.String str) {
    }

    public com.huawei.hms.hatool.k a() {
        return this.c;
    }

    public com.huawei.hms.hatool.k a(java.lang.String str) {
        if (str.equals("oper")) {
            return c();
        }
        if (str.equals("maint")) {
            return b();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return d();
        }
        com.huawei.hms.hatool.y.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(com.huawei.hms.hatool.k kVar) {
        this.a = kVar;
    }

    public com.huawei.hms.hatool.k b() {
        return this.a;
    }

    public void b(com.huawei.hms.hatool.k kVar) {
        this.b = kVar;
    }

    public com.huawei.hms.hatool.k c() {
        return this.b;
    }

    public com.huawei.hms.hatool.k d() {
        return this.d;
    }
}
