package com.anythink.core.api;

@java.lang.Deprecated
/* loaded from: classes12.dex */
public abstract class ATMediationRequestInfo {
    protected java.lang.String adSourceId;
    protected java.lang.String className;
    protected int networkFirmId;

    public java.lang.String getAdSourceId() {
        return this.adSourceId;
    }

    public java.lang.String getClassName() {
        return this.className;
    }

    public int getNetworkFirmId() {
        return this.networkFirmId;
    }

    public abstract java.util.Map<java.lang.String, java.lang.Object> getRequestParamMap();

    public void setAdSourceId(java.lang.String str) {
        this.adSourceId = str;
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.o(str);
    }

    public abstract void setFormat(java.lang.String str);
}
