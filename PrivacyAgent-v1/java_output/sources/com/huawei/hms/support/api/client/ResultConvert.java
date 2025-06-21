package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public abstract class ResultConvert<R extends com.huawei.hms.support.api.client.Result, S extends com.huawei.hms.support.api.client.Result> {

    public class FailPendingResult extends com.huawei.hms.support.api.client.EmptyPendingResult {
        public FailPendingResult(com.huawei.hms.support.api.client.Status status) {
            setResult(status);
        }
    }

    public final com.huawei.hms.support.api.client.PendingResult newFailedPendingResult(com.huawei.hms.support.api.client.Status status) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(status, "The input status cannot be null");
        com.huawei.hms.common.internal.Preconditions.checkArgument(!status.isSuccess(), "The input status must be call with success status");
        return new com.huawei.hms.support.api.client.ResultConvert.FailPendingResult(status);
    }

    public com.huawei.hms.support.api.client.Status onFailed(com.huawei.hms.support.api.client.Status status) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(status, "The input status cannot be null");
        return status.getStatusCode() != 0 ? status : com.huawei.hms.support.api.client.Status.CoreException;
    }

    public abstract com.huawei.hms.support.api.client.PendingResult onSuccess(com.huawei.hms.support.api.client.Result result);
}
