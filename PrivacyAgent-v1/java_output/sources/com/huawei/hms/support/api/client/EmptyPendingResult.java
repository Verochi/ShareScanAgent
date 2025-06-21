package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public class EmptyPendingResult<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.PendingResult<R> {
    private R result;

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await() {
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, java.util.concurrent.TimeUnit timeUnit) {
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void cancel() {
    }

    public R getResult() {
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public boolean isCanceled() {
        return false;
    }

    public void setResult(R r) {
        this.result = r;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(android.os.Looper looper, com.huawei.hms.support.api.client.ResultCallback<R> resultCallback) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback, long j, java.util.concurrent.TimeUnit timeUnit) {
    }
}
