package com.sensorsdata.analytics.android.sdk.exposure;

/* loaded from: classes19.dex */
public class SAExposureProtocolImpl implements com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol {
    private boolean mEnable = false;
    private com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess mExposedProcess;

    private void addExposureView(android.view.View view, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData) {
        com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess sAExposedProcess = this.mExposedProcess;
        if (sAExposedProcess != null) {
            sAExposedProcess.addExposureView(view, sAExposureData);
        }
    }

    private void init(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig sAExposureConfig) {
        if (sAExposureConfig == null) {
            sAExposureConfig = new com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig(0.0f, 0.0d, true);
        }
        this.mExposedProcess = new com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess(sAExposureConfig);
    }

    private void removeExposureView(android.view.View view, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess sAExposedProcess = this.mExposedProcess;
        if (sAExposedProcess != null) {
            sAExposedProcess.removeExposureView(view, str);
        }
    }

    private void setExposureIdentifier(android.view.View view, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess sAExposedProcess = this.mExposedProcess;
        if (sAExposedProcess != null) {
            sAExposedProcess.setExposureIdentifier(view, str);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public java.lang.String getModuleName() {
        return com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.MODULE_NAME;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public int getPriority() {
        return 5;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    public void install(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        if (!sAContextManager.getInternalConfigs().saConfigOptions.isDisableSDK()) {
            setModuleState(true);
        }
        init(sAContextManager.getInternalConfigs().saConfigOptions.getExposureConfig());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
    
        return null;
     */
    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        str.hashCode();
        switch (str) {
            case "addExposureView":
                addExposureView((android.view.View) objArr[0], (com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData) objArr[1]);
                break;
            case "removeExposureView":
                if (objArr.length != 2) {
                    removeExposureView((android.view.View) objArr[0], null);
                    break;
                } else {
                    removeExposureView((android.view.View) objArr[0], (java.lang.String) objArr[1]);
                    break;
                }
            case "updateExposureProperties":
                this.mExposedProcess.updateExposureView((android.view.View) objArr[0], (org.json.JSONObject) objArr[1]);
                break;
            case "setExposureIdentifier":
                setExposureIdentifier((android.view.View) objArr[0], (java.lang.String) objArr[1]);
                break;
        }
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
