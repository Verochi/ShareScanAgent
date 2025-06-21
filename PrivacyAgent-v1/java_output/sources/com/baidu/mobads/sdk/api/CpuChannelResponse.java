package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class CpuChannelResponse {
    private com.baidu.mobads.sdk.internal.n mCpuChannelInfo;

    public CpuChannelResponse(com.baidu.mobads.sdk.internal.n nVar) {
        this.mCpuChannelInfo = nVar;
    }

    public int getChannelId() {
        com.baidu.mobads.sdk.internal.n nVar = this.mCpuChannelInfo;
        if (nVar != null) {
            return nVar.a();
        }
        return -1;
    }

    public java.lang.String getChannelName() {
        com.baidu.mobads.sdk.internal.n nVar = this.mCpuChannelInfo;
        return nVar != null ? nVar.b() : "";
    }
}
