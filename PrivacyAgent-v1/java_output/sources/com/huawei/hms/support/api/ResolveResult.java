package com.huawei.hms.support.api;

/* loaded from: classes22.dex */
public class ResolveResult<T> extends com.huawei.hms.support.api.client.Result {
    private T entity;

    public ResolveResult() {
        this.entity = null;
    }

    public ResolveResult(T t) {
        this.entity = t;
    }

    public T getValue() {
        return this.entity;
    }
}
