package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public final class i {
    public static java.util.Map<java.lang.String, com.huawei.hms.hatool.m> b = new java.util.HashMap();
    public static com.huawei.hms.hatool.i c;
    public com.huawei.hms.hatool.l a = new com.huawei.hms.hatool.l();

    public static com.huawei.hms.hatool.i c() {
        if (c == null) {
            d();
        }
        return c;
    }

    public static synchronized void d() {
        synchronized (com.huawei.hms.hatool.i.class) {
            if (c == null) {
                c = new com.huawei.hms.hatool.i();
            }
        }
    }

    public com.huawei.hms.hatool.m a(java.lang.String str) {
        return b.get(str);
    }

    public java.util.Set<java.lang.String> a() {
        return b.keySet();
    }

    public void a(java.lang.String str, com.huawei.hms.hatool.m mVar) {
        b.put(str, mVar);
    }

    public com.huawei.hms.hatool.l b() {
        return this.a;
    }
}
