package com.huawei.hms.framework.network.grs.local.model;

/* loaded from: classes22.dex */
public class c {
    private java.lang.String a;
    private final java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.local.model.d> b = new java.util.concurrent.ConcurrentHashMap(16);
    private java.util.List<com.huawei.hms.framework.network.grs.local.model.b> c = new java.util.ArrayList(16);

    public com.huawei.hms.framework.network.grs.local.model.d a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            return this.b.get(str);
        }
        com.huawei.hms.framework.common.Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    public java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a() {
        return this.c;
    }

    public void a(java.lang.String str, com.huawei.hms.framework.network.grs.local.model.d dVar) {
        if (android.text.TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        this.b.put(str, dVar);
    }

    public void a(java.util.List<com.huawei.hms.framework.network.grs.local.model.b> list) {
        this.c = list;
    }

    public java.lang.String b() {
        return this.a;
    }

    public void b(java.lang.String str) {
    }

    public void c(java.lang.String str) {
        this.a = str;
    }
}
