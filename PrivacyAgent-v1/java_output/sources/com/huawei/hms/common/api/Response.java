package com.huawei.hms.common.api;

/* loaded from: classes22.dex */
public class Response<T extends com.huawei.hms.support.api.client.Result> {
    protected T result;

    public Response() {
    }

    public Response(T t) {
        this.result = t;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T t) {
        this.result = t;
    }
}
