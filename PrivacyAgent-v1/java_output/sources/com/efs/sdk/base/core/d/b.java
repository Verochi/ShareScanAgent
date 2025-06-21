package com.efs.sdk.base.core.d;

/* loaded from: classes22.dex */
public final class b extends com.efs.sdk.base.protocol.record.AbsRecordLog {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private long e;
    private long f;

    public b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super("wa");
        this.e = 0L;
        this.f = 0L;
        this.a = str;
        this.b = str2;
        this.d = str3;
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:SS", java.util.Locale.CHINA);
        com.efs.sdk.base.core.a.a.a();
        this.c = simpleDateFormat.format(new java.util.Date(com.efs.sdk.base.core.a.a.b()));
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final byte[] generate() {
        java.lang.String generateString = generateString();
        if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            com.efs.sdk.base.core.util.Log.i("efs.base", generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final java.lang.String generateString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("lt=event`");
        sb.append("ev_ct=");
        sb.append(this.a);
        sb.append("`");
        sb.append("ev_ac=");
        sb.append(this.b);
        sb.append("`");
        sb.append("tm=");
        sb.append(this.c);
        sb.append("`");
        sb.append("dn=");
        sb.append(this.d);
        sb.append("`");
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.dataMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
            sb.append("`");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final java.lang.String getLinkId() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final java.lang.String getLinkKey() {
        return "";
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final long getLogBeginTime() {
        return this.e;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final long getLogEndTime() {
        return this.f;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void insertGlobal(com.efs.sdk.base.core.config.GlobalInfo globalInfo) {
        this.dataMap.putAll(globalInfo.getGlobalInfoMap());
        this.dataMap.putAll(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void setLogBeginTime(long j) {
        this.e = j;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public final void setLogEndTime(long j) {
        this.f = j;
    }
}
