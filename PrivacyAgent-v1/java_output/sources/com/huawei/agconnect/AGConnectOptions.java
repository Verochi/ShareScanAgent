package com.huawei.agconnect;

/* loaded from: classes22.dex */
public interface AGConnectOptions {
    boolean getBoolean(java.lang.String str);

    boolean getBoolean(java.lang.String str, boolean z);

    android.content.Context getContext();

    java.lang.String getIdentifier();

    int getInt(java.lang.String str);

    int getInt(java.lang.String str, int i);

    java.lang.String getPackageName();

    com.huawei.agconnect.AGCRoutePolicy getRoutePolicy();

    java.lang.String getString(java.lang.String str);

    java.lang.String getString(java.lang.String str, java.lang.String str2);
}
