package com.huawei.hms.support.api.entity.core;

/* loaded from: classes22.dex */
public class DisconnectInfo implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.util.List<java.lang.String> apiNameList;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopeList;

    public DisconnectInfo() {
    }

    public DisconnectInfo(java.util.List<com.huawei.hms.support.api.entity.auth.Scope> list, java.util.List<java.lang.String> list2) {
        this.scopeList = list;
        this.apiNameList = list2;
    }

    public java.util.List<java.lang.String> getApiNameList() {
        return this.apiNameList;
    }

    public java.util.List<com.huawei.hms.support.api.entity.auth.Scope> getScopeList() {
        return this.scopeList;
    }
}
