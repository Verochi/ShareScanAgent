package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    com.huawei.hmf.tasks.Task<TContinuationResult> then(TResult tresult) throws java.lang.Exception;
}
