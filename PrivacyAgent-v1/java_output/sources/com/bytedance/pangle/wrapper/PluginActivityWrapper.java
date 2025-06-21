package com.bytedance.pangle.wrapper;

@androidx.annotation.Keep
/* loaded from: classes22.dex */
public class PluginActivityWrapper extends com.bytedance.pangle.wrapper.GenerateActivityWrapper {
    private static final int OBJECT_TAG = Integer.MAX_VALUE;

    /* renamed from: com.bytedance.pangle.wrapper.PluginActivityWrapper$1, reason: invalid class name */
    public class AnonymousClass1 extends com.bytedance.pangle.a {
        public AnonymousClass1() {
        }
    }

    /* renamed from: com.bytedance.pangle.wrapper.PluginActivityWrapper$2, reason: invalid class name */
    public class AnonymousClass2 extends com.bytedance.pangle.a {
        final /* synthetic */ android.app.Application a;

        public AnonymousClass2(android.app.Application application) {
            this.a = application;
        }

        @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(android.app.Activity activity) {
            super.onActivityDestroyed(activity);
            if (activity == com.bytedance.pangle.wrapper.PluginActivityWrapper.this.mOriginActivity) {
                this.a.unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.wrapper.PluginActivityWrapper$3, reason: invalid class name */
    public class AnonymousClass3 extends com.bytedance.pangle.a {
        public AnonymousClass3() {
        }
    }

    public PluginActivityWrapper(android.app.Activity activity, com.bytedance.pangle.PluginContext pluginContext) {
        this.mOriginActivity = activity;
        this.pluginContext = pluginContext;
        try {
            if (!activity.isDestroyed()) {
                int i = android.os.Build.VERSION.SDK_INT;
                if (i >= 29) {
                    this.mOriginActivity.registerActivityLifecycleCallbacks(new com.bytedance.pangle.wrapper.PluginActivityWrapper.AnonymousClass1());
                } else if (i >= 24) {
                    setTag();
                } else {
                    registerApplicationLifecycleCallbacks();
                }
            }
        } catch (java.lang.Exception unused) {
            registerApplicationLifecycleCallbacks();
        }
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mBase", pluginContext);
            if (!com.bytedance.pangle.util.i.a()) {
                com.bytedance.pangle.util.FieldUtils.writeField(com.bytedance.pangle.util.FieldUtils.getField(android.content.ContextWrapper.class, "mBase"), this, pluginContext);
            }
        } catch (java.lang.IllegalAccessException unused2) {
        }
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (java.lang.IllegalAccessException unused3) {
        }
        com.bytedance.pangle.util.a.a(this, activity);
    }

    private void registerApplicationLifecycleCallbacks() {
        android.app.Application appApplication = com.bytedance.pangle.Zeus.getAppApplication();
        if (appApplication == null) {
            return;
        }
        appApplication.registerActivityLifecycleCallbacks(new com.bytedance.pangle.wrapper.PluginActivityWrapper.AnonymousClass2(appApplication));
    }

    private void setTag() {
        android.view.View decorView;
        java.lang.String pluginPackageName;
        android.view.Window window = this.mOriginActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (pluginPackageName = this.pluginContext.getPluginPackageName()) == null) {
            return;
        }
        decorView.setTag(pluginPackageName.hashCode(), new com.bytedance.pangle.wrapper.PluginActivityWrapper.AnonymousClass3());
    }
}
