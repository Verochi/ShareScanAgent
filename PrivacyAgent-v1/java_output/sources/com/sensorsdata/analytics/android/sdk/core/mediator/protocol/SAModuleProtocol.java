package com.sensorsdata.analytics.android.sdk.core.mediator.protocol;

/* loaded from: classes19.dex */
public interface SAModuleProtocol {
    java.lang.String getModuleName();

    int getPriority();

    void install(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager);

    <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr);

    boolean isEnable();

    void setModuleState(boolean z);
}
