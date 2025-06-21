package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public abstract class PendingResult<R extends com.huawei.hms.support.api.client.Result> {
    public abstract R await();

    public abstract R await(long j, java.util.concurrent.TimeUnit timeUnit);

    @java.lang.Deprecated
    public abstract void cancel();

    public <S extends com.huawei.hms.support.api.client.Result> com.huawei.hms.support.api.client.ConvertedResult<S> convertResult(com.huawei.hms.support.api.client.ResultConvert<? super R, ? extends S> resultConvert) {
        throw new java.lang.UnsupportedOperationException();
    }

    @java.lang.Deprecated
    public abstract boolean isCanceled();

    public abstract void setResultCallback(android.os.Looper looper, com.huawei.hms.support.api.client.ResultCallback<R> resultCallback);

    public abstract void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback);

    @java.lang.Deprecated
    public abstract void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback, long j, java.util.concurrent.TimeUnit timeUnit);
}
