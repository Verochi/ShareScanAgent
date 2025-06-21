package com.efs.sdk.base.protocol.file.section;

/* loaded from: classes22.dex */
public class KVSection extends com.efs.sdk.base.protocol.file.section.AbsSection {
    private java.util.Map<java.lang.String, java.lang.Object> dataMap;

    public KVSection(java.lang.String str) {
        super("kv");
        this.dataMap = new java.util.HashMap();
        this.name = str;
        this.sep = com.efs.sdk.base.protocol.file.section.AbsSection.SEP_LINE_BREAK;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public java.lang.String changeToStr() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(getDeclarationLine());
        sb.append("\n");
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.dataMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public java.util.Map<java.lang.String, java.lang.Object> getDataMap() {
        return this.dataMap;
    }

    public com.efs.sdk.base.protocol.file.section.KVSection put(java.lang.String str, java.lang.Object obj) {
        this.dataMap.put(str, java.lang.String.valueOf(obj));
        return this;
    }

    public com.efs.sdk.base.protocol.file.section.KVSection putMap(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.dataMap.putAll(map);
        return this;
    }

    public com.efs.sdk.base.protocol.file.section.KVSection putNum(java.lang.String str, long j) {
        this.dataMap.put(com.efs.sdk.base.protocol.ILogProtocol.KEY_PREFIX_NUM.concat(java.lang.String.valueOf(str)), java.lang.Long.valueOf(j));
        return this;
    }

    public com.efs.sdk.base.protocol.file.section.KVSection putString(java.lang.String str, java.lang.String str2) {
        this.dataMap.put(com.efs.sdk.base.protocol.ILogProtocol.KEY_PREFIX_STRING.concat(java.lang.String.valueOf(str)), str2);
        return this;
    }

    public com.efs.sdk.base.protocol.file.section.KVSection putTimestamp(java.lang.String str, long j) {
        this.dataMap.put(com.efs.sdk.base.protocol.ILogProtocol.KEY_PREFIX_TIMESTAMP.concat(java.lang.String.valueOf(str)), java.lang.Long.valueOf(j));
        return this;
    }
}
