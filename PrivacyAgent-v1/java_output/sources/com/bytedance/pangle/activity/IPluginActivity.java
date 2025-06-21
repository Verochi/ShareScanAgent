package com.bytedance.pangle.activity;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public interface IPluginActivity {
    void _requestPermissions(java.lang.String[] strArr, int i);

    void attachBaseContext(android.content.Context context);

    java.lang.String getPluginPkgName();

    void onCreate(android.os.Bundle bundle);

    void setPluginProxyActivity(com.bytedance.pangle.activity.b bVar, com.bytedance.pangle.plugin.Plugin plugin);

    void setProxyTheme2Plugin(int i);
}
