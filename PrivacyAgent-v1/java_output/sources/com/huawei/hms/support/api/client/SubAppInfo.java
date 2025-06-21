package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public class SubAppInfo {
    private java.lang.String subAppID;

    public SubAppInfo(com.huawei.hms.support.api.client.SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.subAppID = subAppInfo.getSubAppID();
        }
    }

    public SubAppInfo(java.lang.String str) {
        this.subAppID = str;
    }

    public java.lang.String getSubAppID() {
        return this.subAppID;
    }

    public void setSubAppInfoID(java.lang.String str) {
        this.subAppID = str;
    }
}
