package com.sensorsdata.analytics.android.sdk.push.core;

/* loaded from: classes19.dex */
public class PushProtocolImp implements com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol {
    private boolean mEnable = false;

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public java.lang.String getModuleName() {
        return com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Push.MODULE_NAME;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public int getPriority() {
        return 5;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public void install(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        if (sAContextManager.getInternalConfigs().saConfigOptions.isEnableTrackPush()) {
            com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(new com.sensorsdata.analytics.android.sdk.push.core.PushLifecycleCallbacks());
        }
        setModuleState(!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK());
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public boolean isEnable() {
        return this.mEnable;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public void setModuleState(boolean z) {
        if (this.mEnable != z) {
            this.mEnable = z;
        }
    }
}
