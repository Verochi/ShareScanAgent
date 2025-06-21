package com.huawei.hms.common.api;

/* loaded from: classes22.dex */
public class BooleanResult extends com.huawei.hms.support.api.client.Result {
    private final com.huawei.hms.support.api.client.Status myStatus;
    private final boolean resultValue;

    public BooleanResult(com.huawei.hms.support.api.client.Status status, boolean z) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(status, "status cannot be null");
        this.myStatus = status;
        this.resultValue = z;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.huawei.hms.common.api.BooleanResult)) {
            return false;
        }
        com.huawei.hms.common.api.BooleanResult booleanResult = (com.huawei.hms.common.api.BooleanResult) obj;
        return this.resultValue == booleanResult.getValue() && this.myStatus.equals(booleanResult.getStatus());
    }

    @Override // com.huawei.hms.support.api.client.Result
    public com.huawei.hms.support.api.client.Status getStatus() {
        return this.myStatus;
    }

    public boolean getValue() {
        return this.resultValue;
    }

    public final int hashCode() {
        boolean z = this.resultValue;
        return (z ? 1 : 0) + ((this.myStatus.hashCode() + 127) * 77);
    }
}
