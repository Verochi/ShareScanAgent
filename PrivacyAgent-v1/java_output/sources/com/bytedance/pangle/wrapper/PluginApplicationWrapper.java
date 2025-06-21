package com.bytedance.pangle.wrapper;

@androidx.annotation.Keep
@android.annotation.SuppressLint({"MissingSuperCall", "NewApi"})
/* loaded from: classes22.dex */
public class PluginApplicationWrapper extends android.app.Application {
    public android.app.Application mOriginApplication;
    public com.bytedance.pangle.PluginContext mPluginContext;

    public PluginApplicationWrapper(android.app.Application application, com.bytedance.pangle.PluginContext pluginContext) {
        this.mOriginApplication = application;
        this.mPluginContext = pluginContext;
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(this, "mBase", pluginContext);
            if (com.bytedance.pangle.util.i.a()) {
                return;
            }
            com.bytedance.pangle.util.FieldUtils.writeField(com.bytedance.pangle.util.FieldUtils.getField(android.content.ContextWrapper.class, "mBase"), this, pluginContext);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getDataDir() {
        return this.mPluginContext.getDataDir();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        this.mOriginApplication.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        this.mOriginApplication.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mOriginApplication.onLowMemory();
    }

    @Override // android.app.Application
    public void onTerminate() {
        this.mOriginApplication.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.mOriginApplication.onTrimMemory(i);
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public void registerOnProvideAssistDataListener(android.app.Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mOriginApplication.registerOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        this.mOriginApplication.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr) {
        this.mOriginApplication.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr, android.os.Bundle bundle) {
        this.mOriginApplication.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent) {
        this.mOriginApplication.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent, android.os.Bundle bundle) {
        this.mOriginApplication.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3) {
        this.mOriginApplication.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(android.content.IntentSender intentSender, android.content.Intent intent, int i, int i2, int i3, android.os.Bundle bundle) {
        this.mOriginApplication.startIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(android.app.Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public void unregisterOnProvideAssistDataListener(android.app.Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mOriginApplication.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
    }
}
