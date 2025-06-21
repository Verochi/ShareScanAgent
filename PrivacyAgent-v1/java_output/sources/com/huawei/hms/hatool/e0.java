package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public final class e0 {
    public static com.huawei.hms.hatool.e0 b;
    public volatile java.util.Map<java.lang.String, com.huawei.hms.hatool.f0> a = new java.util.HashMap();

    public static com.huawei.hms.hatool.e0 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static synchronized void b() {
        synchronized (com.huawei.hms.hatool.e0.class) {
            if (b == null) {
                b = new com.huawei.hms.hatool.e0();
            }
        }
    }

    public final com.huawei.hms.hatool.f0 a(java.lang.String str) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, new com.huawei.hms.hatool.f0());
        }
        return this.a.get(str);
    }

    public com.huawei.hms.hatool.f0 a(java.lang.String str, long j) {
        com.huawei.hms.hatool.f0 a = a(str);
        a.a(j);
        return a;
    }
}
