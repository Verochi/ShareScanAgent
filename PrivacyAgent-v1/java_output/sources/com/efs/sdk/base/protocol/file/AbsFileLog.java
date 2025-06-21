package com.efs.sdk.base.protocol.file;

/* loaded from: classes22.dex */
public abstract class AbsFileLog extends com.efs.sdk.base.protocol.AbsLog {
    public AbsFileLog(java.lang.String str) {
        super(str);
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
        return (byte) 2;
    }
}
