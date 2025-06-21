package com.huawei.hms.common.api.internal;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class OptionalPendingResultImpl<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.common.api.OptionalPendingResult<R> {
    private final com.huawei.hms.support.api.client.PendingResult<R> pendingResult;

    public OptionalPendingResultImpl(com.huawei.hms.support.api.client.PendingResult<R> pendingResult) {
        this.pendingResult = pendingResult;
    }

    public final void addStatusListener() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        return this.pendingResult.await();
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await(long j, java.util.concurrent.TimeUnit timeUnit) {
        return this.pendingResult.await(j, timeUnit);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void cancel() {
    }

    @Override // com.huawei.hms.common.api.OptionalPendingResult
    public final R get() {
        throw new java.lang.IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hms.common.api.OptionalPendingResult
    public final boolean isDone() {
        return false;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(android.os.Looper looper, com.huawei.hms.support.api.client.ResultCallback<R> resultCallback) {
        this.pendingResult.setResultCallback(looper, resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback) {
        this.pendingResult.setResultCallback(resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback, long j, java.util.concurrent.TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }
}
