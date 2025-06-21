package com.bytedance.pangle.wrapper;

@androidx.annotation.Keep
/* loaded from: classes22.dex */
public class PluginFragmentActivityWrapper extends com.bytedance.pangle.wrapper.GenerateFragmentActivityWrapper {
    boolean hasInit = true;

    /* renamed from: com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper$1, reason: invalid class name */
    public class AnonymousClass1 extends com.bytedance.pangle.a {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(android.app.Activity activity) {
            super.onActivityDestroyed(activity);
            if (activity == com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper.this.mOriginActivity) {
                com.bytedance.pangle.Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    public PluginFragmentActivityWrapper(android.app.Activity activity, com.bytedance.pangle.PluginContext pluginContext) {
        androidx.fragment.app.FragmentActivity fragmentActivity = (androidx.fragment.app.FragmentActivity) activity;
        this.mOriginActivity = fragmentActivity;
        this.pluginContext = pluginContext;
        if (!fragmentActivity.isDestroyed()) {
            com.bytedance.pangle.Zeus.getAppApplication().registerActivityLifecycleCallbacks(new com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper.AnonymousClass1());
        }
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mBase", pluginContext);
            if (!com.bytedance.pangle.util.i.a()) {
                com.bytedance.pangle.util.FieldUtils.writeField(com.bytedance.pangle.util.FieldUtils.getField(android.content.ContextWrapper.class, "mBase"), this, pluginContext);
            }
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
        }
        com.bytedance.pangle.util.a.a(this, activity);
    }

    @Override // com.bytedance.pangle.wrapper.GenerateFragmentActivityWrapper, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public androidx.lifecycle.Lifecycle getLifecycle() {
        if (!this.hasInit) {
            try {
                androidx.lifecycle.LifecycleRegistry lifecycleRegistry = new androidx.lifecycle.LifecycleRegistry(this);
                try {
                    java.lang.reflect.Field declaredField = androidx.lifecycle.LifecycleRegistry.class.getDeclaredField("mEnforceMainThread");
                    declaredField.setAccessible(true);
                    declaredField.set(lifecycleRegistry, java.lang.Boolean.FALSE);
                } catch (java.lang.Throwable unused) {
                }
                return lifecycleRegistry;
            } catch (java.lang.Throwable unused2) {
            }
        }
        return super.getLifecycle();
    }

    public android.app.Activity getOriginActivity() {
        return this.mOriginActivity;
    }
}
