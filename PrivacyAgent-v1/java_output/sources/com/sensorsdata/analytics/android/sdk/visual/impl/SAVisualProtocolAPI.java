package com.sensorsdata.analytics.android.sdk.visual.impl;

/* loaded from: classes19.dex */
public class SAVisualProtocolAPI implements com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol {
    private static final java.lang.String TAG = "SA.SAVisualProtocolImpl";
    private boolean mEnable = false;
    private com.sensorsdata.analytics.android.sdk.core.SAContextManager mSAContextManager;
    private com.sensorsdata.analytics.android.sdk.visual.impl.VisualProtocolImpl mVisualImpl;

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public java.lang.String getModuleName() {
        return com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public int getPriority() {
        return 5;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public void install(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        this.mVisualImpl = new com.sensorsdata.analytics.android.sdk.visual.impl.VisualProtocolImpl(sAContextManager);
        if (sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            return;
        }
        setModuleState(true);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        return (T) this.mVisualImpl.invokeModuleFunction(str, objArr);
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
        if (z && this.mSAContextManager.getInternalConfigs().saConfigOptions.isVisualizedPropertiesEnabled()) {
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().requestVisualConfig(this.mSAContextManager);
        }
    }
}
