package com.huawei.hms.framework.network.grs.f;

/* loaded from: classes22.dex */
public class b {
    private static final java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.f.b> b = new java.util.concurrent.ConcurrentHashMap(16);
    private static final java.lang.Object c = new java.lang.Object();
    private com.huawei.hms.framework.network.grs.f.a a;

    public b(android.content.Context context, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, boolean z) {
        a(context, z);
        b.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    public static com.huawei.hms.framework.network.grs.f.b a(java.lang.String str, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        return b.get(str + grsBaseInfo.uniqueCode());
    }

    public static void a(android.content.Context context, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        com.huawei.hms.framework.network.grs.f.b a = a(context.getPackageName(), grsBaseInfo);
        if (a != null) {
            com.huawei.hms.framework.common.Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
            synchronized (c) {
                a.a.a();
            }
        }
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.a.b();
    }

    public java.lang.String a(android.content.Context context, com.huawei.hms.framework.network.grs.e.a aVar, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, java.lang.String str, java.lang.String str2, boolean z) {
        synchronized (c) {
            java.lang.String a = this.a.a(context, aVar, grsBaseInfo, str, str2, z);
            if (!android.text.TextUtils.isEmpty(a) || !this.a.d()) {
                return a;
            }
            a(context, true);
            a(grsBaseInfo);
            b.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
            return this.a.a(context, aVar, grsBaseInfo, str, str2, z);
        }
    }

    public java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context, com.huawei.hms.framework.network.grs.e.a aVar, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, java.lang.String str, boolean z) {
        synchronized (c) {
            java.util.Map<java.lang.String, java.lang.String> a = this.a.a(context, aVar, grsBaseInfo, str, z);
            if ((a != null && !a.isEmpty()) || !this.a.d()) {
                return a;
            }
            a(context, true);
            a(grsBaseInfo);
            b.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
            return this.a.a(context, aVar, grsBaseInfo, str, z);
        }
    }

    public void a(android.content.Context context, boolean z) {
        java.lang.String[] list = com.huawei.hms.framework.common.AssetsUtil.list(context, com.huawei.hms.framework.network.grs.GrsApp.getInstance().getBrand(""));
        java.util.List<java.lang.String> arrayList = list == null ? new java.util.ArrayList<>() : java.util.Arrays.asList(list);
        java.lang.String appConfigName = com.huawei.hms.framework.network.grs.GrsApp.getInstance().getAppConfigName();
        com.huawei.hms.framework.common.Logger.i("LocalManagerProxy", "appConfigName is" + appConfigName);
        this.a = new com.huawei.hms.framework.network.grs.f.d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !android.text.TextUtils.isEmpty(appConfigName)) {
            this.a = new com.huawei.hms.framework.network.grs.f.d(context, appConfigName, z);
        }
        if (!this.a.e() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.a = new com.huawei.hms.framework.network.grs.f.c(context, z);
        }
        this.a.a(context, arrayList);
    }

    public void a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        this.a.a(grsBaseInfo);
    }

    public java.util.Set<java.lang.String> b() {
        return this.a.c();
    }
}
