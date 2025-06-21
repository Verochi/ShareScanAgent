package com.huawei.hms.common.api;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class OptionalPendingResult<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.PendingResult<R> {
    public abstract R get();

    public abstract boolean isDone();
}
