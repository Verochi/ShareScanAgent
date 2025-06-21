package com.efs.sdk.memoryinfo;

/* loaded from: classes22.dex */
public interface UMMemoryMonitorApi {
    java.lang.String getCurrentActivity();

    boolean isEnable();

    boolean isForeground();

    void onActivityResumed(android.app.Activity activity);

    void onActivityStarted(android.app.Activity activity);

    void onActivityStopped(android.app.Activity activity);

    void setEnable(boolean z);

    void start(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter);
}
