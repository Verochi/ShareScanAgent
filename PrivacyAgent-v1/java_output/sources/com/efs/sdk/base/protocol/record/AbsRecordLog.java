package com.efs.sdk.base.protocol.record;

/* loaded from: classes22.dex */
public abstract class AbsRecordLog extends com.efs.sdk.base.protocol.AbsLog {
    protected java.util.HashMap<java.lang.String, java.lang.Object> dataMap;

    public AbsRecordLog(java.lang.String str) {
        super(str);
        this.dataMap = new java.util.HashMap<>();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public int getBodyType() {
        return 0;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public java.lang.String getFilePath() {
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte getLogProtocol() {
        return (byte) 1;
    }

    public void put(java.lang.String str, java.lang.Object obj) {
        this.dataMap.put(str, obj);
    }

    public void putMap(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.dataMap.putAll(map);
    }

    public void putNum(java.lang.String str, long j) {
        this.dataMap.put(com.efs.sdk.base.protocol.ILogProtocol.KEY_PREFIX_NUM.concat(java.lang.String.valueOf(str)), java.lang.Long.valueOf(j));
    }

    public void putString(java.lang.String str, java.lang.String str2) {
        this.dataMap.put(com.efs.sdk.base.protocol.ILogProtocol.KEY_PREFIX_STRING.concat(java.lang.String.valueOf(str)), str2);
    }

    public void putTimestamp(java.lang.String str, long j) {
        this.dataMap.put(com.efs.sdk.base.protocol.ILogProtocol.KEY_PREFIX_TIMESTAMP.concat(java.lang.String.valueOf(str)), java.lang.Long.valueOf(j));
    }
}
