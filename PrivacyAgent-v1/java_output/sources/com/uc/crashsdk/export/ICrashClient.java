package com.uc.crashsdk.export;

/* loaded from: classes19.dex */
public interface ICrashClient {
    public static final int EVENT_TYPE_ADD_CRASH_STATS = 3;
    public static final int EVENT_TYPE_CLIENT_PROCESS_LOG_GENERATED = 4;
    public static final int EVENT_TYPE_CRASH_RESTARTING = 2;
    public static final int EVENT_TYPE_LOG_GENERATED = 1;

    void onAddCrashStats(java.lang.String str, int i, int i2);

    java.io.File onBeforeUploadLog(java.io.File file);

    void onClientProcessLogGenerated(java.lang.String str, java.io.File file, java.lang.String str2);

    void onCrashRestarting(boolean z);

    java.lang.String onGetCallbackInfo(java.lang.String str, boolean z);

    void onLogGenerated(java.io.File file, java.lang.String str);
}
