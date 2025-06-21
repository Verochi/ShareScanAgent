package com.hihonor.push.sdk.tasks;

/* loaded from: classes22.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    com.hihonor.push.sdk.tasks.Task<TContinuationResult> then(TResult tresult) throws java.lang.Exception;
}
