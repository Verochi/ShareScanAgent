package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bo {
    public static final java.lang.String a = "ContainerFactoryBuilder";
    private static com.baidu.mobads.sdk.api.IXAdContainerFactory e;
    private android.content.Context c;
    private java.lang.Class<?> d;
    public double b = 0.1d;
    private com.baidu.mobads.sdk.internal.bt f = com.baidu.mobads.sdk.internal.bt.a();

    public bo(java.lang.Class<?> cls, android.content.Context context) {
        this.d = null;
        this.d = cls;
        this.c = context;
    }

    public com.baidu.mobads.sdk.api.IXAdContainerFactory a() {
        if (e == null) {
            try {
                e = (com.baidu.mobads.sdk.api.IXAdContainerFactory) this.d.getDeclaredConstructor(android.content.Context.class).newInstance(this.c);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.umeng.analytics.pro.bo.bl, "9.3711");
                e.initConfig(jSONObject);
                this.b = e.getRemoteVersion();
                e.onTaskDistribute(com.baidu.mobads.sdk.internal.bc.a, com.baidu.mobads.sdk.api.MobadsPermissionSettings.getPermissionInfo());
                e.initCommonModuleObj(com.baidu.mobads.sdk.internal.t.a());
            } catch (java.lang.Throwable th) {
                this.f.b(a, th.getMessage());
                throw new com.baidu.mobads.sdk.internal.bz.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return e;
    }

    public void b() {
        e = null;
    }
}
