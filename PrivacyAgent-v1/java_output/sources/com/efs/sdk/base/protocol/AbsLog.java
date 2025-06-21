package com.efs.sdk.base.protocol;

/* loaded from: classes22.dex */
public abstract class AbsLog implements com.efs.sdk.base.protocol.ILogProtocol {
    private java.lang.String cp = "none";
    private byte de = 1;
    private java.lang.String logType;

    public AbsLog(java.lang.String str) {
        this.logType = str;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public java.lang.String getLogType() {
        return this.logType;
    }

    public boolean isCp() {
        return !this.cp.equals("none");
    }

    public boolean isDe() {
        return this.de != 1;
    }

    public void setCp(java.lang.String str) {
        this.cp = str;
    }

    public void setDe(byte b) {
        this.de = b;
    }
}
