package com.igexin.sdk.message;

/* loaded from: classes23.dex */
public class BindAliasCmdMessage extends com.igexin.sdk.message.GTCmdMessage {
    private java.lang.String code;
    private java.lang.String sn;

    public BindAliasCmdMessage() {
    }

    public BindAliasCmdMessage(java.lang.String str, java.lang.String str2, int i) {
        super(i);
        this.sn = str;
        this.code = str2;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    public java.lang.String getSn() {
        return this.sn;
    }

    public void setCode(java.lang.String str) {
        this.code = str;
    }

    public void setSn(java.lang.String str) {
        this.sn = str;
    }
}
