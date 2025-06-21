package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public abstract class ConvertedResult<R extends com.huawei.hms.support.api.client.Result> {
    public abstract <S extends com.huawei.hms.support.api.client.Result> com.huawei.hms.support.api.client.ConvertedResult<S> convertResult(com.huawei.hms.support.api.client.ResultConvert<? super R, ? extends S> resultConvert);

    public abstract void finalExec(com.huawei.hms.support.api.client.ResultCallbacks<? super R> resultCallbacks);
}
