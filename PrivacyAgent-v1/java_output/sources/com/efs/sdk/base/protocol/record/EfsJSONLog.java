package com.efs.sdk.base.protocol.record;

/* loaded from: classes22.dex */
public class EfsJSONLog extends com.efs.sdk.base.protocol.record.AbsRecordLog {
    private long beginTime;
    private long endTime;

    public EfsJSONLog(java.lang.String str) {
        super(str);
        put("type", str);
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        java.lang.String generateString = generateString();
        if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            com.efs.sdk.base.core.util.Log.i("efs.base", generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public java.lang.String generateString() {
        return new org.json.JSONObject(this.dataMap).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public java.lang.String getLinkId() {
        if (this.dataMap.containsKey(com.efs.sdk.base.Constants.LOG_KEY_LINK_ID)) {
            return java.lang.String.valueOf(this.dataMap.get(com.efs.sdk.base.Constants.LOG_KEY_LINK_ID));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public java.lang.String getLinkKey() {
        if (this.dataMap.containsKey(com.efs.sdk.base.Constants.LOG_KEY_LINK_KEY)) {
            return java.lang.String.valueOf(this.dataMap.get(com.efs.sdk.base.Constants.LOG_KEY_LINK_KEY));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public long getLogBeginTime() {
        return this.beginTime;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public long getLogEndTime() {
        return this.endTime;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(com.efs.sdk.base.core.config.GlobalInfo globalInfo) {
        this.dataMap.putAll(globalInfo.getGlobalInfoMap());
        this.dataMap.putAll(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void setLogBeginTime(long j) {
        this.beginTime = j;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void setLogEndTime(long j) {
        this.endTime = j;
    }
}
