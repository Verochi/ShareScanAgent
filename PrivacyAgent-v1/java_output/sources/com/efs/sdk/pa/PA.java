package com.efs.sdk.pa;

/* loaded from: classes22.dex */
public interface PA {
    void enableDumpToFile(java.lang.String str);

    void enableLog(boolean z);

    int endCalFPS(java.lang.String str);

    long endCalTime(java.lang.String str);

    void registerPAANRListener(android.content.Context context, com.efs.sdk.pa.PAANRListener pAANRListener);

    void registerPAANRListener(android.content.Context context, com.efs.sdk.pa.PAANRListener pAANRListener, long j);

    void registerPAANRListener(android.content.Context context, com.efs.sdk.pa.PAANRListener pAANRListener, long j, java.lang.Thread thread);

    void registerPAMsgListener(com.efs.sdk.pa.PAMsgListener pAMsgListener);

    void start();

    void startCalFPS(java.lang.String str, android.view.View view);

    void startCalTime(java.lang.String str);

    void stop();

    void unRegisterPAMsgListener();

    void unregisterPAANRListener();
}
