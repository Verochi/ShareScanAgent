package com.sensorsdata.analytics.android.sdk.advert.impl;

/* loaded from: classes19.dex */
public class SensorsAdvertProtocolAPI implements com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol {
    private com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl mAdvertProtocolImpl;
    private boolean mEnable = false;

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public java.lang.String getModuleName() {
        return com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public int getPriority() {
        return 5;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public void install(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mAdvertProtocolImpl = new com.sensorsdata.analytics.android.sdk.advert.impl.SAAdvertProtocolImpl(sAContextManager);
        if (sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            return;
        }
        setModuleState(true);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        return (T) this.mAdvertProtocolImpl.invokeModuleFunction(str, objArr);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public boolean isEnable() {
        return this.mEnable;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public void setModuleState(boolean z) {
        if (this.mEnable != z) {
            if (z) {
                this.mAdvertProtocolImpl.delayInitTask();
                this.mAdvertProtocolImpl.registerLifeCallback();
                this.mAdvertProtocolImpl.registerPropertyPlugin();
                this.mAdvertProtocolImpl.delayExecution();
            } else {
                this.mAdvertProtocolImpl.unregisterLifecycleCallback();
                this.mAdvertProtocolImpl.unregisterPropertyPlugin();
            }
            this.mEnable = z;
        }
    }
}
