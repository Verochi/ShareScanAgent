package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public abstract class InnerPendingResult<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.PendingResult<R> {
    public abstract R awaitOnAnyThread();

    public abstract R awaitOnAnyThread(long j, java.util.concurrent.TimeUnit timeUnit);
}
