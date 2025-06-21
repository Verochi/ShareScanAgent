package com.sensorsdata.analytics.android.webview.impl;

/* loaded from: classes19.dex */
public class SensorsWebViewAPI implements com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol {
    private boolean mEnable = false;
    private com.sensorsdata.analytics.android.webview.impl.SAWebViewProtocolImpl mWebViewProtocolImpl;

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public java.lang.String getModuleName() {
        return com.sensorsdata.analytics.android.sdk.core.mediator.Modules.WebView.MODULE_NAME;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public int getPriority() {
        return 5;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public void install(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mWebViewProtocolImpl = new com.sensorsdata.analytics.android.webview.impl.SAWebViewProtocolImpl(sAContextManager);
        if (sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            return;
        }
        setModuleState(true);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        return (T) this.mWebViewProtocolImpl.invokeModuleFunction(str, objArr);
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
