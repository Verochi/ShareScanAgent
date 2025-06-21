package com.hihonor.push.sdk.tasks;

/* loaded from: classes22.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(com.hihonor.push.sdk.tasks.Task<TResult> task) throws java.lang.Exception;
}
