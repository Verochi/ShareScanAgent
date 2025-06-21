package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTPluginListener {
    android.os.Bundle config();

    void onPluginListener(int i, java.lang.ClassLoader classLoader, android.content.res.Resources resources, android.os.Bundle bundle);

    java.lang.String packageName();
}
