package com.bytedance.pangle.activity;

/* loaded from: classes12.dex */
public interface b {
    void finish();

    android.app.Application getApplication();

    android.content.Context getBaseContext();

    android.content.Intent getIntent();

    com.bytedance.pangle.plugin.Plugin getPlugin();

    java.lang.String getPluginPkgName();

    void setPlugin(com.bytedance.pangle.plugin.Plugin plugin);

    void setTargetActivity(com.bytedance.pangle.activity.IPluginActivity iPluginActivity);

    void zeusSuperAttachBaseContext(android.content.Context context);

    void zeusSuperOnCreate(android.os.Bundle bundle);

    void zeusSuperSetTheme(int i);
}
