package com.bytedance.pangle;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class ZeusApplication extends com.bytedance.pangle.PluginContext {
    android.app.Application mHostApplication;

    public void attach(com.bytedance.pangle.plugin.Plugin plugin, android.app.Application application) {
        this.mPlugin = plugin;
        this.mHostApplication = application;
        attachBaseContext(application);
        onCreate();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate() {
    }
}
