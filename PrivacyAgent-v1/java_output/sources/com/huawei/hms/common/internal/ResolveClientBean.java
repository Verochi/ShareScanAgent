package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class ResolveClientBean {
    private final int clientKey;
    private final com.huawei.hms.common.internal.AnyClient mClient;
    private int minSdkVersion;

    public ResolveClientBean(com.huawei.hms.common.internal.AnyClient anyClient, int i) {
        this.mClient = anyClient;
        this.clientKey = com.huawei.hms.common.internal.Objects.hashCode(anyClient);
        this.minSdkVersion = i;
    }

    public void clientReconnect() {
        this.mClient.connect(this.minSdkVersion, true);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof com.huawei.hms.common.internal.ResolveClientBean)) {
            return false;
        }
        return this.mClient.equals(((com.huawei.hms.common.internal.ResolveClientBean) obj).mClient);
    }

    public com.huawei.hms.common.internal.AnyClient getClient() {
        return this.mClient;
    }

    public int hashCode() {
        return this.clientKey;
    }
}
