package com.huawei.hms.support.api.entity.core;

/* loaded from: classes22.dex */
public class ConnectResp implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.util.List<java.lang.Integer> protocolVersion = java.util.Arrays.asList(1, 2);

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String sessionId;

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("protocol version:");
        java.util.Iterator<java.lang.Integer> it = this.protocolVersion.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(',');
        }
        return sb.toString();
    }
}
