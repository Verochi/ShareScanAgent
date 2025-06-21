package com.huawei.hms.framework.network.grs.local.model;

/* loaded from: classes22.dex */
public class a {
    private java.lang.String a;
    private final java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.local.model.c> b = new java.util.concurrent.ConcurrentHashMap(16);

    public com.huawei.hms.framework.network.grs.local.model.c a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            return this.b.get(str);
        }
        com.huawei.hms.framework.common.Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    }

    public void a() {
        java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.local.model.c> map = this.b;
        if (map != null) {
            map.clear();
        }
    }

    public void a(long j) {
    }

    public void a(java.lang.String str, com.huawei.hms.framework.network.grs.local.model.c cVar) {
        if (android.text.TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        this.b.put(str, cVar);
    }

    public java.lang.String b() {
        return this.a;
    }

    public void b(java.lang.String str) {
        this.a = str;
    }
}
