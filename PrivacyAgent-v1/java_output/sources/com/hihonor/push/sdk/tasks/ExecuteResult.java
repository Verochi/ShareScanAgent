package com.hihonor.push.sdk.tasks;

/* loaded from: classes22.dex */
public interface ExecuteResult<TResult> {
    void cancel();

    void onComplete(com.hihonor.push.sdk.tasks.Task<TResult> task);
}
