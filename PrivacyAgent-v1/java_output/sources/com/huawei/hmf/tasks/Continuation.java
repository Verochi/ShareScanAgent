package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(com.huawei.hmf.tasks.Task<TResult> task) throws java.lang.Exception;
}
