package com.bytedance.pangle.service;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public abstract class PluginService extends android.app.Service implements com.bytedance.pangle.service.a {
    private static final java.lang.String TAG = "PluginService";

    /* renamed from: com.bytedance.pangle.service.PluginService$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.reflect.InvocationHandler {
        public AnonymousClass1() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            java.lang.String name = method.getName();
            name.hashCode();
            if (name.equals("getForegroundServiceType")) {
                return 0;
            }
            if (!name.equals("stopServiceToken")) {
                return null;
            }
            com.bytedance.pangle.service.a.a b = com.bytedance.pangle.service.a.a.b();
            com.bytedance.pangle.service.PluginService pluginService = com.bytedance.pangle.service.PluginService.this;
            return java.lang.Boolean.valueOf(b.a(new android.content.ComponentName(pluginService, pluginService.getClass().getName())));
        }
    }

    @Override // com.bytedance.pangle.service.a
    public void attach(com.bytedance.pangle.plugin.Plugin plugin) {
        attachBaseContext(com.bytedance.pangle.transform.ZeusTransformUtils.wrapperContext2Application(com.bytedance.pangle.Zeus.getAppApplication(), plugin.mPkgName));
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mClassName", getClass().getName());
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mApplication", com.bytedance.pangle.Zeus.getAppApplication());
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mStartCompatibility", java.lang.Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
        }
    }

    public java.lang.Object createActivityManagerProxy() {
        return java.lang.reflect.Proxy.newProxyInstance(getClassLoader(), new java.lang.Class[]{java.lang.Class.forName("android.app.IActivityManager")}, new com.bytedance.pangle.service.PluginService.AnonymousClass1());
    }
}
