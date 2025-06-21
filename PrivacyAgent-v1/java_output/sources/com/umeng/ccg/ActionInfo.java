package com.umeng.ccg;

/* loaded from: classes19.dex */
public interface ActionInfo {
    java.lang.String getModule(android.content.Context context);

    java.lang.String[] getSupportAction(android.content.Context context);

    boolean getSwitchState(android.content.Context context, java.lang.String str);

    void onCommand(android.content.Context context, java.lang.String str, java.lang.Object obj);
}
