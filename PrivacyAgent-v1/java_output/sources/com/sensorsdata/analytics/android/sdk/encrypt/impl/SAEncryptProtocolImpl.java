package com.sensorsdata.analytics.android.sdk.encrypt.impl;

/* loaded from: classes19.dex */
public class SAEncryptProtocolImpl implements com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol {
    private boolean mEnable = false;
    private com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPIImpl mEncryptAPIImpl;

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public java.lang.String getModuleName() {
        return com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public int getPriority() {
        return 6;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public void install(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mEncryptAPIImpl = new com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPIImpl(sAContextManager);
        if (sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            return;
        }
        setModuleState(true);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        return (T) this.mEncryptAPIImpl.invokeModuleFunction(str, objArr);
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
